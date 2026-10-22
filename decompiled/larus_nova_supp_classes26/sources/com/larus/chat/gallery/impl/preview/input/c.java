package com.larus.chat.gallery.impl.preview.input;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.camera.api.params.OutputParam;
import com.larus.chat.gallery.impl.preview.provider.w0;
import com.larus.platform.model.preview.AttachmentEditState;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements d0 {
    public final com.larus.chat.gallery.api.q a;
    public final Function0<AttachmentEditType> b;
    public ChildResultMode c;
    public final List<com.larus.chat.gallery.api.o> d;
    public final Map<String, com.larus.chat.gallery.api.o> e;
    public com.larus.chat.gallery.api.o f;
    public List<com.larus.chat.gallery.api.o> g;
    public com.larus.chat.gallery.impl.preview.input.a h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ChildResultMode.values().length];
            r0[ChildResultMode.APPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ChildResultMode.ALBUM_APPEND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ChildResultMode.EDIT_REPLACE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void g() {
        this.c = null;
        this.f = null;
        this.g = CollectionsKt.emptyList();
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final String a() {
        return this.a.a();
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.o b() {
        com.larus.chat.gallery.api.o r0 = this.f;
        this.f = null;
        return r0;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void detach() {
        com.larus.chat.gallery.impl.preview.input.a r0 = this.h;
        if (r0 == null) goto L5;
        this.a.b(r0);
    L5:
        this.h = null;
        g();
        this.f = null;
        this.g = CollectionsKt.emptyList();
        ((LinkedHashMap) this.e).clear();
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean e() {
        if (this.c == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final List<com.larus.chat.gallery.api.o> l() {
        List<com.larus.chat.gallery.api.o> r0 = this.g;
        this.g = CollectionsKt.emptyList();
        return r0;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.q getSession() {
        return this.a;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean c(ChildResultMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        if (this.c == null) goto L5;
        return false;
    L5:
        if (this.a.getCapability().e == false) goto L11;
        this.c = r2;
        this.f = null;
        this.g = CollectionsKt.emptyList();
        return true;
    L11:
        return false;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final com.larus.chat.gallery.api.o d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemKey");
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((com.larus.chat.gallery.api.o) r1).a, r4) == false) goto L4;
    L10:
        return (com.larus.chat.gallery.api.o) r1;
    L8:
        r1 = null;
        goto L10
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean f(CameraResultRoute r6) {
        ChildResultMode r0 = this.c;
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != (-1)) goto L9;
        return false;
    L9:
        if (r1 != 1) goto L11;
        CameraResultRoute.Delivery r2 = CameraResultRoute.Delivery.PREVIEW_CAPTURE_APPEND;
    L19:
        if (r6 == null) goto L21;
        String r3 = r6.getOwnerNodeId();
    L23:
        if (Intrinsics.areEqual(r3, this.a.j()) == true) goto L25;
        return false;
    L25:
        if (r6.getDelivery() != r2) goto L30;
        return true;
    L30:
        return false;
    L21:
        r3 = null;
        goto L23
    L11:
        if (r1 != 2) goto L13;
    L17:
        r2 = CameraResultRoute.Delivery.CONFIRM_TO_OWNER;
        goto L19
    L13:
        if (r1 == 3) goto L17;
        throw new NoWhenBranchMatchedException();
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final int i(String r4) {
        Intrinsics.checkNotNullParameter(r4, "itemKey");
        Iterator<com.larus.chat.gallery.api.o> r0 = this.d.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r0.next().a, r4) == true) goto L13;
        r1 = r1 + 1;
        goto L4
    L13:
        return r1;
    L9:
        return -1;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final void j(w0 r2) {
        Intrinsics.checkNotNullParameter(r2, "onSelectionChanged");
        if (this.h == null) goto L5;
        return;
    L5:
        com.larus.chat.gallery.impl.preview.input.a r0 = new com.larus.chat.gallery.impl.preview.input.a(this, r2);
        this.h = r0;
        this.a.f(r0);
        r0.invoke(this.a.Qa());
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean k(String r3) {
        Intrinsics.checkNotNullParameter(r3, "itemKey");
        if (this.a.getCapability().d == true) goto L5;
    L7:
        this.a.Pa(r3, false);
        return false;
    L5:
        if (this.a.getCapability().b == true) goto L7;
        return this.a.t(r3);
    }

    @Override // com.larus.chat.gallery.impl.preview.input.d0
    public final boolean h(CameraOutputContext r40, xy8.d r41) {
        Intrinsics.checkNotNullParameter(r40, "outputContext");
        boolean r5 = false;
        if (f(r40.getResultRoute()) == true) goto L6;
        FLogger.a.e("PreviewMediaSessionCtrl", "consumeResult: result route does not match pending transaction");
        return false;
    L6:
        ChildResultMode r2 = this.c;
        if (r2 != null) goto L9;
        return false;
    L9:
        this.f = null;
        this.g = CollectionsKt.emptyList();
        this.c = null;
        if (r2 != ChildResultMode.ALBUM_APPEND) goto L26;
        List<OutputParam> r7 = r40.getOutputParamList();
        if (r7 != null) goto L14;
        r7 = CollectionsKt.emptyList();
    L14:
        ArrayList r9 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L16:
        if (r8.hasNext() == false) goto L25;
        Object r10 = r8.next();
        OutputParam r11 = (OutputParam) r10;
        if (r11 != null) goto L20;
    L22:
        boolean r12 = false;
    L23:
        if (r12 == false) goto L16;
        r9.add(r10);
        goto L16
    L20:
        if (r11.isFromAlbum() != true) goto L22;
        r12 = true;
        goto L23
    L25:
        CameraOutputContext r13 = new CameraOutputContext();
        r13.setOutputParamList(CollectionsKt.toMutableList(r9));
        List<com.larus.chat.gallery.api.o> r14 = wy8.a.a(r13);
    L28:
        if (r2 != ChildResultMode.APPEND) goto L30;
    L33:
        boolean r15 = true;
    L34:
        HashSet r16 = new HashSet();
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r14.iterator();
    L36:
        if (r18.hasNext() == false) goto L40;
        Object r19 = r18.next();
        if (r16.add(((com.larus.chat.gallery.api.o) r19).a) == false) goto L36;
        r17.add(r19);
        goto L36
    L40:
        if (r15 == false) goto L67;
        ArrayList r110 = new ArrayList();
        Iterator r111 = r17.iterator();
    L43:
        if (r111.hasNext() == false) goto L66;
        Object r112 = r111.next();
        com.larus.chat.gallery.api.o r113 = (com.larus.chat.gallery.api.o) r112;
        List<com.larus.chat.gallery.api.o> r114 = this.d;
        if ((r114 instanceof Collection) == true) goto L47;
    L49:
        Iterator<T> r115 = r114.iterator();
    L51:
        if (r115.hasNext() == false) goto L62;
        com.larus.chat.gallery.api.o r116 = (com.larus.chat.gallery.api.o) r115.next();
        if (Intrinsics.areEqual(r116.a, r113.a) == false) goto L55;
    L58:
        boolean r6 = true;
    L59:
        if (r6 == false) goto L51;
        r5 = true;
    L63:
        if (r5 == true) goto L65;
        r110.add(r112);
    L65:
        r5 = false;
        goto L43
    L55:
        if (Intrinsics.areEqual(r116.b, r113.b) == true) goto L58;
        r6 = false;
        goto L59
    L62:
        r5 = false;
        goto L63
    L47:
        if (r114.isEmpty() == false) goto L49;
    L66:
        r17 = r110;
    L67:
        ChildResultMode r20 = ChildResultMode.ALBUM_APPEND;
        if (r2 != r20) goto L70;
        AttachmentSource r21 = AttachmentSource.LOCAL_ALBUM;
    L71:
        if (r2 != r20) goto L96;
        List<OutputParam> r22 = r40.getOutputParamList();
        if (r22 != null) goto L75;
        r22 = CollectionsKt.emptyList();
    L75:
        List r23 = CollectionsKt.filterNotNull(r22);
        ArrayList r117 = new ArrayList();
        Iterator r24 = r23.iterator();
    L77:
        if (r24.hasNext() == false) goto L95;
        OutputParam r118 = (OutputParam) r24.next();
        String r119 = r118.getSrcAlbumUri();
        if (r119 != null) goto L81;
    L92:
        Pair r120 = null;
    L93:
        if (r120 == null) goto L77;
        r117.add(r120);
        goto L77
    L81:
        if ((!StringsKt.isBlank(r119)) == true) goto L84;
        r119 = null;
    L84:
        if (r119 == null) goto L92;
        String r121 = r118.getPath();
        if ((!StringsKt.isBlank(r121)) == true) goto L90;
        r121 = null;
    L90:
        if (r121 == null) goto L92;
        r120 = TuplesKt.to(r121, r119);
        goto L93
    L95:
        Map r25 = MapsKt.toMap(r117);
    L98:
        if (r2 != ChildResultMode.ALBUM_APPEND) goto L106;
        List<OutputParam> r3 = r40.getOutputParamList();
        if (r3 != null) goto L102;
        r3 = CollectionsKt.emptyList();
    L102:
        List r4 = CollectionsKt.filterNotNull(r3);
        Map r122 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16));
        Iterator r26 = r4.iterator();
    L104:
        if (r26.hasNext() == false) goto L107;
        OutputParam r123 = (OutputParam) r26.next();
        Pair r124 = TuplesKt.to(r123.getPath(), Boolean.valueOf(r123.isOriginalImageChecked()));
        r122.put(r124.getFirst(), r124.getSecond());
    L107:
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r125 = r17.iterator();
        int r126 = 0;
    L109:
        if (r125.hasNext() == false) goto L125;
        Object r127 = r125.next();
        int r128 = r126 + 1;
        if (r126 >= 0) goto L113;
        CollectionsKt.throwIndexOverflow();
    L113:
        com.larus.chat.gallery.api.o r129 = (com.larus.chat.gallery.api.o) r127;
        AttachmentSnapshot r130 = com.larus.chat.gallery.api.p.a(r129, r21, r126);
        Map r131 = r130.getExtra();
        String r132 = (String) r25.get(r129.b);
        if (r132 == null) goto L116;
        Map r28 = MapsKt.mapOf(TuplesKt.to("preview_attachment_source_media_uri", r132));
    L117:
        if (r28 != null) goto L119;
        r28 = MapsKt.emptyMap();
    L119:
        Map r29 = MapsKt.plus(r131, r28);
        if (Intrinsics.areEqual(r122.get(r129.b), Boolean.TRUE) == false) goto L122;
        String r133 = "1";
    L123:
        r27.add(AttachmentSnapshot.copy$default(r130, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, MapsKt.plus(r29, TuplesKt.to("preview_attachment_original_image_checked", r133)), 65535, null));
        r126 = r128;
        goto L109
    L122:
        r133 = TriggerSendLoading.NO_LOADING;
        goto L123
    L116:
        r28 = null;
        goto L117
    L125:
        if (r27.isEmpty() == false) goto L128;
        return false;
    L128:
        if (r41 == null) goto L130;
        String r1 = r41.b;
    L132:
        if (r2 != ChildResultMode.EDIT_REPLACE) goto L143;
        com.larus.chat.gallery.api.o r134 = (com.larus.chat.gallery.api.o) CollectionsKt.lastOrNull(r14);
        if (r134 == null) goto L143;
        if (r1 == null) goto L143;
        if ((!StringsKt.isBlank(r1)) == false) goto L139;
        String r135 = r1;
    L140:
        if (r135 == null) goto L143;
        com.larus.chat.gallery.api.o r30 = com.larus.chat.gallery.api.o.a(r134, r135, null, null, 0, 0, 126);
    L144:
        if (r30 == null) goto L154;
        Iterator<com.larus.chat.gallery.api.o> r31 = this.d.iterator();
        int r32 = 0;
    L147:
        if (r31.hasNext() == false) goto L152;
        if (Intrinsics.areEqual(r31.next().a, r30.a) == true) goto L153;
        r32 = r32 + 1;
    L153:
        Integer r33 = Integer.valueOf(r32);
    L155:
        ChildResultMode r34 = ChildResultMode.EDIT_REPLACE;
        if (r2 != r34) goto L163;
        if (r30 == null) goto L163;
        if (r33 != null) goto L160;
    L161:
        FLogger.a.e("PreviewMediaSessionCtrl", "consumeResult: replacement item is missing from preview session");
        return false;
    L160:
        if (CollectionsKt.getIndices(this.d).contains(r33.intValue()) == false) goto L161;
    L163:
        if (r15 == false) goto L165;
        com.larus.chat.gallery.api.r r35 = new com.larus.chat.gallery.api.r.a(r27);
    L180:
        if (r15 == false) goto L182;
        this.d.addAll(r17);
    L182:
        if (r30 == null) goto L195;
        if (r33 == null) goto L195;
        int r36 = r33.intValue();
        if (r36 >= 0) goto L187;
    L189:
        boolean r136 = false;
    L190:
        if (r136 == true) goto L193;
        r33 = null;
    L193:
        if (r33 == null) goto L195;
        int r37 = r33.intValue();
        Integer r38 = Integer.valueOf(r37);
        Object r39 = ListProtector.get(this.d, r37);
        com.larus.chat.gallery.api.o r137 = (com.larus.chat.gallery.api.o) r39;
        ListProtector.set(this.d, r37, r30);
        Pair r42 = TuplesKt.to(r38, r39);
    L196:
        if (r30 == null) goto L198;
        com.larus.chat.gallery.api.o r43 = this.e.put(r30.a, r30);
    L199:
        boolean r44 = this.a.q(r35);
        if (r44 == true) goto L216;
        if (r30 == null) goto L205;
        if (r43 != null) goto L204;
        this.e.remove(r30.a);
        goto L205
    L204:
        this.e.put(r30.a, r43);
        Unit r45 = Unit.INSTANCE;
    L205:
        if (r15 == false) goto L211;
        ArrayList r46 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r47 = r17.iterator();
    L208:
        if (r47.hasNext() == false) goto L210;
        r46.add(((com.larus.chat.gallery.api.o) r47.next()).a);
        goto L208
    L210:
        final Set r48 = CollectionsKt.toSet(r46);
        CollectionsKt.removeAll(this.d, new com.larus.chat.gallery.impl.preview.input.b(r48));
    L211:
        if (r42 == null) goto L215;
        ListProtector.set(this.d, ((Number) r42.component1()).intValue(), (com.larus.chat.gallery.api.o) r42.component2());
        com.larus.chat.gallery.impl.preview.input.a r49 = this.h;
        if (r49 == null) goto L215;
        r49.invoke(this.a.Qa());
        Unit r50 = Unit.INSTANCE;
    L215:
        FLogger.a.e("PreviewMediaSessionCtrl", "owner mutation rejected by source");
    L222:
        return r44;
    L216:
        if (r2 != r34) goto L220;
        this.f = r30;
        com.larus.chat.gallery.impl.preview.input.a r51 = this.h;
        if (r51 == null) goto L222;
        r51.invoke(this.a.Qa());
        Unit r52 = Unit.INSTANCE;
        goto L222
    L220:
        if (r15 == false) goto L222;
        this.g = r17;
        goto L222
    L198:
        r43 = null;
        goto L199
    L187:
        if (r36 >= this.d.size()) goto L189;
        r136 = true;
    L195:
        r42 = null;
        goto L196
    L165:
        AttachmentSnapshot r138 = (AttachmentSnapshot) CollectionsKt.lastOrNull(r27);
        if (r1 != null) goto L168;
    L171:
        boolean r53 = true;
    L172:
        if (r53 == true) goto L223;
        if (r138 == null) goto L252;
        AttachmentEditType r54 = (AttachmentEditType) this.b.invoke();
        ResourceRef r139 = r138.effectiveRef();
        if (r139 == null) goto L178;
        AttachmentEditState r310 = new AttachmentEditState(r139, r1, r54);
    L179:
        r35 = new com.larus.chat.gallery.api.r.b(r1, AttachmentSnapshot.copy$default(r138, r1, null, null, null, null, null, null, null, null, null, null, 0, null, r310, 0, null, null, 122878, null));
        goto L180
    L178:
        r310 = null;
        goto L179
    L252:
        return false;
    L223:
        return false;
    L168:
        if (StringsKt.isBlank(r1) == true) goto L171;
        r53 = false;
        goto L172
    L152:
        r32 = -1;
        goto L153
    L154:
        r33 = null;
        goto L155
    L139:
        r135 = null;
    L143:
        r30 = null;
        goto L144
    L130:
        r1 = null;
        goto L132
    L106:
        r122 = MapsKt.emptyMap();
        goto L107
    L96:
        r25 = MapsKt.emptyMap();
        goto L98
    L70:
        r21 = AttachmentSource.CAMERA;
        goto L71
    L30:
        if (r2 == ChildResultMode.ALBUM_APPEND) goto L33;
        r15 = false;
        goto L34
    L26:
        r14 = wy8.a.a(r40);
        goto L28
    }

    public c(com.larus.chat.gallery.api.q r2, List<com.larus.chat.gallery.api.o> r3, Function0<? extends AttachmentEditType> r4) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "mediaItems");
        Intrinsics.checkNotNullParameter(r4, "consumePendingEditType");
        this.a = r2;
        this.b = r4;
        this.d = CollectionsKt.toMutableList(r3);
        this.e = new LinkedHashMap();
        this.g = CollectionsKt.emptyList();
    }
}
