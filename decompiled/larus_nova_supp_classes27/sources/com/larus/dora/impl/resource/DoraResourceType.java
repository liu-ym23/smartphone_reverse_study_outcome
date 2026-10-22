package com.larus.dora.impl.resource;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0014\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceType;", "", "androidResourceType", "", "directoryName", "fileExtensions", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAndroidResourceType", "()Ljava/lang/String;", "getDirectoryName", "STRING", "DRAWABLE", "LAYOUT", "RAW", "COLOR", "XML", "DIMEN", "candidateFileNames", "resourceName", "candidateFileNames$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceType extends Enum<DoraResourceType> {
    public static final DoraResourceType COLOR = null;
    public static final DoraResourceType DIMEN = null;
    public static final DoraResourceType DRAWABLE = null;
    public static final DoraResourceType LAYOUT = null;
    public static final DoraResourceType RAW = null;
    public static final DoraResourceType STRING = null;
    public static final DoraResourceType XML = null;
    public static final /* synthetic */ DoraResourceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String androidResourceType;
    private final String directoryName;
    private final List<String> fileExtensions;

    public static EnumEntries<DoraResourceType> getEntries() {
        return b;
    }

    static {
        DoraResourceType r6 = new DoraResourceType("STRING", 0, "string", "values", CollectionsKt.listOf(new String[]{"txt", "json", "xml"}));
        STRING = r6;
        DoraResourceType r0 = new DoraResourceType("DRAWABLE", 1, "drawable", "drawable", CollectionsKt.listOf(new String[]{"xml", "webp", "png", "jpg", "jpeg", "gif"}));
        DRAWABLE = r0;
        DoraResourceType r1 = new DoraResourceType("LAYOUT", 2, "layout", "layout", CollectionsKt.listOf(new String[]{"xml", "json"}));
        LAYOUT = r1;
        DoraResourceType r2 = new DoraResourceType("RAW", 3, "raw", "raw", CollectionsKt.listOf(new String[]{"json", "xml", "mp4", "webm", "wav", "mp3", "bin"}));
        RAW = r2;
        DoraResourceType r3 = new DoraResourceType("COLOR", 4, "color", "values", CollectionsKt.listOf(new String[]{"xml", "json", "txt"}));
        COLOR = r3;
        DoraResourceType r4 = new DoraResourceType("XML", 5, "xml", "xml", CollectionsKt.listOf("xml"));
        XML = r4;
        DoraResourceType r5 = new DoraResourceType("DIMEN", 6, "dimen", "values", CollectionsKt.listOf(new String[]{"txt", "json", "xml"}));
        DIMEN = r5;
        DoraResourceType[] r7 = {r6, r0, r1, r2, r3, r4, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DoraResourceType[] values() {
        return (DoraResourceType[]) a.clone();
    }

    public final String getAndroidResourceType() {
        return this.androidResourceType;
    }

    public final String getDirectoryName() {
        return this.directoryName;
    }

    public static DoraResourceType valueOf(String r1) {
        return (DoraResourceType) a.a(DoraResourceType.class, r1);
    }

    public final List<String> candidateFileNames$impl_mainlandRelease(String r6) {
        Intrinsics.checkNotNullParameter(r6, "resourceName");
        if (StringsKt.substringAfterLast(r6, '.', "").length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        List<String> r1 = CollectionsKt.mutableListOf(new String[]{r6});
        Iterator<T> r2 = this.fileExtensions.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        r1.add(r6 + '.' + ((String) r2.next()));
        goto L11
    L13:
        return r1;
    L8:
        return CollectionsKt.listOf(r6);
    L5:
        r0 = false;
        goto L6
    }

    public DoraResourceType(String r1, int r2, String r3, String r4, List r5) {
        super(r1, r2);
        this.androidResourceType = r3;
        this.directoryName = r4;
        this.fileExtensions = r5;
    }
}
