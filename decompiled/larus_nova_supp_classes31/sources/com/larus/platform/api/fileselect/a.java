package com.larus.platform.api.fileselect;

import aq9.e;
import aq9.f;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.u;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.model.chat.r0;
import com.larus.platform.service.z2;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements IChatFileSelectionStore {
    public final Object a;
    public f b;
    public final LinkedHashMap<String, u> c;
    public final LinkedHashMap<String, IChatFileSelectionStore.Source> d;
    public final StateFlowImpl e;
    public final StateFlowImpl f;

    /* JADX INFO: renamed from: com.larus.platform.api.fileselect.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0008a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowDriveFileType.values().length];
            r0[FlowDriveFileType.AUDIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FlowDriveFileType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public a() {
        f r0 = new f(0);
        Intrinsics.checkNotNullParameter(r0, "initialPolicy");
        this.a = new Object();
        this.b = r0;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = j1.a(new LinkedHashMap());
        this.f = j1.a(new e(0));
    }

    public final void f() {
        StateFlowImpl r0 = this.e;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll(this.c);
        r0.setValue(r1);
        FlowDriveFileType r2 = (FlowDriveFileType) CollectionsKt.singleOrNull(SequencesKt.toList(SequencesKt.distinct(SequencesKt.map(CollectionsKt.asSequence(this.c.values()), new aq9.a()))));
        Set<Map.Entry<String, u>> r3 = this.c.entrySet();
        boolean r4 = false;
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        Map.Entry r6 = (Map.Entry) r5.next();
        Intrinsics.checkNotNull(r6);
        String r7 = (String) r6.getKey();
        if (((u) r6.getValue()).f.isMediaType() == true) goto L13;
    L15:
        boolean r8 = false;
    L16:
        if (r8 == false) goto L9;
        r4 = true;
        goto L18
    L13:
        if (this.d.get(r7) != IChatFileSelectionStore.Source.DRIVE) goto L15;
        r8 = true;
    L18:
        this.f.setValue(new e(r2, r4));
        return;
    L5:
        if (r3.isEmpty() == false) goto L7;
        goto L7
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final List<u> snapshot() {
        Object r0 = this.a;
        monitor-enter(r0);
        List<u> r1 = CollectionsKt.toList(this.c.values());     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final StateFlowImpl getState() {
        return this.e;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final void d(f r2) {
        Intrinsics.checkNotNullParameter(r2, "policy");
        Object r0 = this.a;
        monitor-enter(r0);
        this.b = r2;     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final IChatFileSelectionStore.Source e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "fileUri");
        Object r0 = this.a;
        monitor-enter(r0);
        IChatFileSelectionStore.Source r4 = this.d.get(r3);     // Catch: Throwable -> L9
        if (r4 != null) goto L7;
        r4 = IChatFileSelectionStore.Source.UNKNOWN;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);
        return r4;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final IChatFileSelectionStore.b.a a(String r2, IChatFileSelectionStore.Source r3) {
        Intrinsics.checkNotNullParameter(r2, "fileUri");
        Intrinsics.checkNotNullParameter(r3, "source");
        Object r4 = this.a;
        monitor-enter(r4);
        this.c.remove(r2);     // Catch: Throwable -> L7
        this.d.remove(r2);     // Catch: Throwable -> L7
        f();     // Catch: Throwable -> L7
        IChatFileSelectionStore.b.a r5 = IChatFileSelectionStore.b.a.a;     // Catch: Throwable -> L7
        monitor-exit(r4);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final IChatFileSelectionStore.b b(u r2, IChatFileSelectionStore.Source r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "source");
        Object r0 = this.a;
        monitor-enter(r0);
        IChatFileSelectionStore.b r4 = g(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.platform.api.fileselect.IChatFileSelectionStore
    public final IChatFileSelectionStore.b c(u r8, IChatFileSelectionStore.Source r9) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "source");
        Object r0 = this.a;
        monitor-enter(r0);
        IChatFileSelectionStore.b r1 = g(r8, r9);     // Catch: Throwable -> L23
        if ((r1 instanceof IChatFileSelectionStore.b.C0007b) == false) goto L8;
        monitor-exit(r0);
        return r1;
    L8:
        LinkedHashMap<String, u> r2 = this.c;     // Catch: Throwable -> L23
        String r3 = r8.a;     // Catch: Throwable -> L23
        u r4 = r2.get(r3);     // Catch: Throwable -> L23
        if (r4 == null) goto L19;
        Map<String, String> r5 = r4.m;     // Catch: Throwable -> L23
        if (r5 == null) goto L19;
        String r6 = r5.get("upload_way");     // Catch: Throwable -> L23
        if (r6 == null) goto L19;
        Map<String, String> r7 = r8.m;     // Catch: Throwable -> L23
        if (r7 != null) goto L18;
        r7 = MapsKt.emptyMap();     // Catch: Throwable -> L23
    L18:
        u r10 = u.a(r8, 0, MapsKt.plus(r7, MapsKt.mapOf(TuplesKt.to("upload_way", r6))), 4095);     // Catch: Throwable -> L23
    L20:
        r2.put(r3, r10);     // Catch: Throwable -> L23
        this.d.put(r8.a, r9);     // Catch: Throwable -> L23
        f();     // Catch: Throwable -> L23
        IChatFileSelectionStore.b.a r11 = IChatFileSelectionStore.b.a.a;     // Catch: Throwable -> L23
        monitor-exit(r0);
        return r11;
    L19:
        r10 = r8;
    L23:
        th = move-exception;
        throw th;
    }

    public final IChatFileSelectionStore.b g(u r12, IChatFileSelectionStore.Source r13) {
        if (this.c.containsKey(r12.a) == true) goto L5;
        LinkedHashMap<String, u> r0 = this.c;
        f r1 = this.b;
        boolean r2 = UploadFilePolicy.a;
        boolean r3 = false;
        if (UploadFilePolicy.b == true) goto L37;
        Collection<u> r4 = r0.values();
        if (r4.isEmpty() == true) goto L17;
        Iterator<T> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        if (((u) r5.next()).f.isMediaType() == false) goto L13;
        boolean r6 = true;
    L18:
        Collection<u> r7 = r0.values();
        if (r7.isEmpty() == true) goto L27;
        Iterator<T> r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L27;
        if ((!((u) r8.next()).f.isMediaType()) == false) goto L23;
        boolean r9 = true;
    L28:
        boolean r10 = r12.f.isMediaType();
        if (r10 == false) goto L31;
        if (r9 == false) goto L31;
    L33:
        if (r6 == false) goto L35;
        FlowDriveFileType r14 = FlowDriveFileType.IMAGE;
    L104:
        return new IChatFileSelectionStore.b.C0007b(new IChatFileSelectionStore.a.d(r14, r12.f.toMixCategory()));
    L35:
        r14 = FlowDriveFileType.FILE;
    L31:
        if (r10 == true) goto L37;
        if (r6 == false) goto L37;
    L27:
        r9 = false;
    L17:
        r6 = false;
    L37:
        Set<FlowDriveFileType> r11 = r1.a;
        if (r11 != null) goto L40;
    L42:
        int r15 = bq9.a.a;
        Map<String, String> r16 = r12.m;
        Long r17 = null;
        if (r16 == null) goto L45;
        String r18 = r16.get("originFileTypeString");
    L47:
        if (l1.k(r18) == true) goto L86;
        String r19 = StringsKt.substringAfterLast(r12.b, '.', "").toLowerCase(Locale.ROOT);
        IChatFileSelectionStore.Source r20 = IChatFileSelectionStore.Source.DRIVE;
        if (r13 != r20) goto L51;
    L54:
        boolean r21 = UploadFilePolicy.e(r19);
    L55:
        if (r21 == true) goto L58;
        return new IChatFileSelectionStore.b.C0007b(new IChatFileSelectionStore.a.e(r12.f));
    L58:
        if (r13 == r20) goto L60;
    L62:
        boolean r22 = false;
    L64:
        if (r13 == IChatFileSelectionStore.Source.LOCAL) goto L66;
    L79:
        long r23 = UploadFilePolicy.d();
    L80:
        if (r22 == true) goto L86;
        long r24 = r12.c;
        if (r24 <= 0) goto L107;
        if (r24 <= r23) goto L86;
    L107:
        return new IChatFileSelectionStore.b.C0007b(new IChatFileSelectionStore.a.C0006a(r23));
    L66:
        if (r12.f != FlowDriveFileType.AUDIO) goto L79;
        r0 r110 = z2.a.getFlowMultiUploadConfig().j();
        if (r110 == null) goto L78;
        Long r111 = r110.e();
        if (r111 == null) goto L78;
        if (r111.longValue() <= 0) goto L74;
        r3 = true;
    L74:
        if (r3 == false) goto L76;
        r17 = r111;
    L76:
        if (r17 == null) goto L78;
        r23 = r17.longValue();
    L78:
        r23 = 314572800;
        goto L80
    L60:
        if (r12.c > 0) goto L62;
        r22 = true;
        goto L64
    L51:
        if (r13 == IChatFileSelectionStore.Source.RECENT) goto L54;
        r21 = UploadFilePolicy.g(r19);
    L86:
        int r112 = C0008a.a[r12.f.ordinal()];
        if (r112 != 1) goto L89;
        int r113 = r1.c;
    L94:
        if (((r0.size() + r1.b) + 1) <= r113) goto L97;
        return new IChatFileSelectionStore.b.C0007b(new IChatFileSelectionStore.a.c(r113));
    L97:
        return IChatFileSelectionStore.b.a.a;
    L89:
        if (r112 == 2) goto L91;
        r113 = r1.e;
        goto L94
    L91:
        r113 = r1.d;
        goto L94
    L45:
        r18 = null;
        goto L47
    L40:
        if (r11.contains(r12.f) == true) goto L42;
        return new IChatFileSelectionStore.b.C0007b(new IChatFileSelectionStore.a.e(r12.f));
    L5:
        return IChatFileSelectionStore.b.a.a;
    }
}
