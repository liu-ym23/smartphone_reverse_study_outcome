package org.apache.poi.poifs.filesystem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import org.apache.poi.poifs.property.DirectoryProperty;
import org.apache.poi.poifs.property.DocumentProperty;
import org.apache.poi.poifs.property.Property;

/* JADX INFO: loaded from: classes7.dex */
public class DirectoryNode extends EntryNode implements Iterable<Entry>, DirectoryEntry {
    private final Map<String, Entry> _byname;
    private final ArrayList<Entry> _entries;
    private final POIFSFileSystem _filesystem;
    private final POIFSDocumentPath _path;

    DirectoryNode(DirectoryProperty r4, POIFSFileSystem r5, DirectoryNode r6) {
        super(r4, r6);
        this._byname = new HashMap();
        this._entries = new ArrayList();
        this._filesystem = r5;
        if (r6 != null) goto L5;
        POIFSDocumentPath r7 = new POIFSDocumentPath();
    L6:
        this._path = r7;
        Iterator<Property> r8 = r4.getChildren();
    L8:
        if (r8.hasNext() == false) goto L14;
        Property r9 = (Property) ZeusTransformUtils.preCheckCast(r8.next(), Property.class, "com.obric.memorydata.plugin");
        if (r9.isDirectory() == false) goto L12;
        Entry r10 = new DirectoryNode((DirectoryProperty) ZeusTransformUtils.preCheckCast(r9, DirectoryProperty.class, "com.obric.memorydata.plugin"), this._filesystem, this);
    L13:
        this._entries.add(r10);
        this._byname.put(r10.getName(), r10);
        goto L8
    L12:
        r10 = new DocumentNode((DocumentProperty) ZeusTransformUtils.preCheckCast(r9, DocumentProperty.class, "com.obric.memorydata.plugin"), this);
        goto L13
    L14:
        return;
    L5:
        r7 = new POIFSDocumentPath(r6._path, new String[]{r4.getName()});
        goto L6
    }

    public DocumentEntry createDocument(String r3, int r4, POIFSWriterListener r5) {
        POIFSWriterListener r6 = (POIFSWriterListener) ZeusTransformUtils.wrapperContextForParams(r5, POIFSWriterListener.class, "com.obric.memorydata.plugin");
        return createDocument(new POIFSDocument(r3, r4, this._filesystem, r6));
    }

    DocumentEntry createDocument(POIFSDocument r6) {
        DocumentProperty r0 = r6.getDocumentProperty();
        DocumentNode r1 = new DocumentNode(r0, this);
        ((DirectoryProperty) ZeusTransformUtils.preCheckCast(getProperty(), DirectoryProperty.class, "com.obric.memorydata.plugin")).addChild(r0);
        this._filesystem.addDocument(r6);
        this._entries.add(r1);
        this._byname.put(r0.getName(), r1);
        return r1;
    }

    public DocumentInputStream createDocumentInputStream(String r1) {
        return createDocumentInputStream(getEntry(r1));
    }

    public DocumentInputStream createDocumentInputStream(Entry r3) {
        Entry r2 = (Entry) ZeusTransformUtils.wrapperContextForParams(r3, Entry.class, "com.obric.memorydata.plugin");
        if (r2.isDocumentEntry() == false) goto L7;
        return new DocumentInputStream((DocumentEntry) ZeusTransformUtils.preCheckCast(r2, DocumentEntry.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IOException("Entry '" + r2.getName() + "' is not a DocumentEntry");
    }

    boolean deleteEntry(EntryNode r4) {
        boolean r0 = ((DirectoryProperty) ZeusTransformUtils.preCheckCast(getProperty(), DirectoryProperty.class, "com.obric.memorydata.plugin")).deleteChild(r4.getProperty());
        if (r0 == false) goto L10;
        this._entries.remove(r4);
        this._byname.remove(r4.getName());
        this._filesystem.remove(r4);     // Catch: IOException -> L7
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        return r0;
    }

    public Iterator<Entry> getEntries() {
        return this._entries.iterator();
    }

    public Entry getEntry(String r4) {
        if (r4 == null) goto L4;
        Entry r0 = (Entry) ZeusTransformUtils.preCheckCast(this._byname.get(r4), Entry.class, "com.obric.memorydata.plugin");
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        if (this._byname.containsKey("Workbook") == true) goto L19;
        if (this._byname.containsKey("PowerPoint Document") == true) goto L17;
        if (this._byname.containsKey("VisioDocument") == false) goto L15;
        throw new IllegalArgumentException("The document is really a VSD file");
    L15:
        throw new FileNotFoundException("no such entry: \"" + r4 + "\", had: " + this._byname.keySet());
    L17:
        throw new IllegalArgumentException("The document is really a PPT file");
    L19:
        throw new IllegalArgumentException("The document is really a XLS file");
    L4:
        r0 = null;
        goto L5
    }

    public Set<String> getEntryNames() {
        return this._byname.keySet();
    }

    public POIFSFileSystem getFileSystem() {
        return this._filesystem;
    }

    public boolean hasEntry(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this._byname.containsKey(r1) == false) goto L6;
        return true;
    }

    @Override // org.apache.poi.poifs.filesystem.EntryNode
    public boolean isDeleteOK() {
        return isEmpty();
    }

    public boolean isEmpty() {
        return this._entries.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return getEntries();
    }

    @Override // java.lang.Iterable
    public Spliterator<Entry> spliterator() {
        return this._entries.spliterator();
    }
}
