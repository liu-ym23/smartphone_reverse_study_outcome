package com.obric.memorydata.utils.c;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0007J \u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020%J \u0010'\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u0005J3\u0010(\u001a\u0004\u0018\u0001H)\"\u0004\b\u0000\u0010)2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0+H\u0007¢\u0006\u0002\u0010,JB\u0010-\u001a\u0016\u0012\u0004\u0012\u0002H)\u0018\u00010.j\n\u0012\u0004\u0012\u0002H)\u0018\u0001`/\"\u0004\b\u0000\u0010)2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00072\u000e\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u0002H)0+H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/utils/framework/MemoryManager;", "", "<init>", "()V", "FROM_SHARE", "", "LEGACY_PREFIX", "", "NEW_PREFIX", "keyAliases", "", "primary", "KEY_TEXT", "KEY_IMAGE_URI", "KEY_IMAGE_LIST", "KEY_PACKAGE", "KEY_TIMESTAMP", "KEY_IMAGE_TYPE", "KEY_SOURCE", "IMAGE_TYPE_NORMAL", "IMAGE_TYPE_LONG", "IMAGE_TYPE_CAMERA_VIEWFINDER", "IMAGE_TYPE_GALLERY_SINGLE", "IMAGE_TYPE_GALLERY_DOCUMENT", "IMAGE_TYPE_CAMERA_POSTVIEW", "SOURCE_SYSTEM_UI", "SOURCE_GALLERY", "SOURCE_GALLERY_SCROLL", "SOURCE_CAMERA_VIEWFINDER", "SOURCE_GALLERY_SINGLE", "SOURCE_GALLERY_DOCUMENT", "SOURCE_CAMERA_POSTVIEW", "readStringCompat", "bundle", "Landroid/os/Bundle;", "primaryKey", "readLongCompat", "", "defaultValue", "readIntCompat", "readParcelableCompat", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "readParcelableArrayListCompat", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13197a = null;

    static {
        f13197a = new a();
    }

    private a() {
    }

    public static /* synthetic */ long a(a r0, Bundle r1, String r2, long r3, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        return r0.a(r1, r2, r3);
    }

    private final List<String> a(String r7) {
        String r2 = null;
        if (StringsKt.startsWith$default(r7, "com.obric.memorydata.", false, 2, null) == false) goto L7;
        StringBuilder r6 = new StringBuilder().append("com.aiassistant.memorydata.").append(StringsKt.removePrefix(r7, (CharSequence) ZeusTransformUtils.preCheckCast("com.obric.memorydata.", CharSequence.class, "com.obric.memorydata.plugin")));
    L5:
        r2 = r6.toString();
    L9:
        if (r2 == null) goto L12;
        return CollectionsKt.listOf(new String[]{r7, r2});
    L12:
        return CollectionsKt.listOf(r7);
    L7:
        if (StringsKt.startsWith$default(r7, "com.aiassistant.memorydata.", false, 2, null) == false) goto L9;
        r6 = new StringBuilder().append("com.obric.memorydata.").append(StringsKt.removePrefix(r7, (CharSequence) ZeusTransformUtils.preCheckCast("com.aiassistant.memorydata.", CharSequence.class, "com.obric.memorydata.plugin")));
        goto L5
    }

    public final int a(Bundle r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "primaryKey");
        Iterator<String> r2 = a(r4).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.containsKey(r6) == false) goto L4;
        return r3.getInt(r6, r5);
    L9:
        return r5;
    }

    public final long a(Bundle r3, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "primaryKey");
        Iterator<String> r2 = a(r4).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.containsKey(r6) == false) goto L4;
        return r3.getLong(r6, r5);
    L9:
        return r5;
    }

    public final <T> T a(Bundle r3, String r4, Class<T> r5) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "primaryKey");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Iterator<String> r2 = a(r4).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.containsKey(r6) == false) goto L4;
        T r7 = (T) r3.getParcelable(r6, r5);
        if (r7 == null) goto L4;
        return r7;
    L10:
        return null;
    }

    public final String a(Bundle r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "primaryKey");
        Iterator<String> r2 = a(r4).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.containsKey(r5) == false) goto L4;
        String r6 = r3.getString(r5);
        if (r6 == null) goto L4;
        return r6;
    L10:
        return null;
    }

    public final <T> ArrayList<T> b(Bundle r3, String r4, Class<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "primaryKey");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Iterator<String> r2 = a(r4).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.containsKey(r6) == false) goto L4;
        ArrayList<T> r7 = r3.getParcelableArrayList(r6, r5);
        if (r7 == null) goto L4;
        return r7;
    L10:
        return null;
    }
}
