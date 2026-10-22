package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.pb.basic.v1.File;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u0005J$\u0010\u0006\u001a\u00020\u00072\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\tH\u0014¨\u0006\n"}, d2 = {"com/ss/android/lark/im/sdk/message/TextAttachmentLocalCache$attachmentsByMessageKey$1", "Ljava/util/LinkedHashMap;", "", "", "Lcom/bytedance/lark/pb/basic/v1/File;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class TextAttachmentLocalCache$attachmentsByMessageKey$1 extends LinkedHashMap<String, List<? extends File>> {
    public TextAttachmentLocalCache$attachmentsByMessageKey$1() {
        super(100, 0.75f, true);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, List<File>>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set<Map.Entry<String, List<File>>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<List<File>> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<List<File>> values() {
        return getValues();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return containsKey((String) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r2) {
        if ((r2 instanceof List) == true) goto L7;
        return false;
    L7:
        return containsValue((List) r2);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, List<? extends File>> r2) {
        if (size() <= 100) goto L5;
        return true;
    L5:
        return false;
    }

    public /* bridge */ boolean containsKey(String r1) {
        return super.containsKey(r1);
    }

    public /* bridge */ boolean containsValue(List<File> r1) {
        return super.containsValue(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ List<File> get(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return get((String) r2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ List<File> remove(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return null;
    L7:
        return remove((String) r2);
    }

    public /* bridge */ List<File> get(String r1) {
        return (List) super.get(r1);
    }

    public /* bridge */ List<File> remove(String r1) {
        return (List) super.remove(r1);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, (List) r3);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object r3, Object r4) {
        if ((r3 instanceof String) == true) goto L6;
        return false;
    L6:
        if ((r4 instanceof List) == true) goto L9;
        return false;
    L9:
        return remove((String) r3, (List) r4);
    }

    public final /* bridge */ List<File> getOrDefault(Object r2, List<File> r3) {
        if ((r2 instanceof String) == true) goto L6;
        return r3;
    L6:
        return getOrDefault((String) r2, r3);
    }

    public /* bridge */ boolean remove(String r1, List<File> r2) {
        return super.remove(r1, r2);
    }

    public /* bridge */ List<File> getOrDefault(String r1, List<File> r2) {
        return (List) super.getOrDefault(r1, r2);
    }
}
