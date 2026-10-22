package com.larus.chat.gallery.impl.preview.toolbar;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.chat.gallery.api.PreviewSourceAction;
import com.larus.chat.gallery.api.l;
import com.larus.chat.gallery.api.q;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.input.e0;
import com.larus.chat.gallery.impl.preview.input.v;
import com.larus.chat.gallery.impl.preview.toolbar.action.DeleteAction;
import com.larus.chat.gallery.impl.preview.toolbar.action.DownloadAction;
import com.larus.chat.gallery.impl.preview.toolbar.action.MarkAction;
import com.larus.chat.gallery.impl.preview.toolbar.action.PublishAction;
import com.larus.chat.gallery.impl.preview.toolbar.action.SetPrivateAction;
import com.larus.chat.gallery.impl.preview.toolbar.action.SourceOwnerAction;
import com.larus.chat.gallery.impl.preview.toolbar.action.ToolbarActionDispatcher;
import com.larus.chat.gallery.impl.preview.toolbar.action.n0;
import com.larus.chat.gallery.impl.preview.toolbar.action.o;
import com.larus.chat.gallery.impl.preview.toolbar.action.o0;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.p;
import com.larus.gallery.api.w;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import sq9.a0;
import sq9.z;
import v19.i5;
import zp9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreviewToolbarCoordinator implements r {
    public static final /* synthetic */ int v = 0;
    public final ToolbarLayoutMode a;
    public final ToolbarVisualStyle b;
    public final CoroutineScope c;
    public final Function0<Context> d;
    public final Function0<FragmentManager> e;
    public final Function0<w> f;
    public final Function0<xy8.d> g;
    public final Function0<xy8.a> h;
    public final PreviewCameraParamProvider i;
    public final e0 j;
    public final q k;
    public final Function1<SourceType, a0> l;
    public final boolean m;
    public final Lazy n;
    public final boolean o;
    public final boolean p;
    public final ToolbarActionDispatcher q;
    public PreviewToolbarView r;
    public final Map<String, Boolean> s;
    public int t;
    public final c u;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ToolbarButtonType.values().length];
            r0[ToolbarButtonType.MARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L67:
            r0[ToolbarButtonType.CROP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L75:
            r0[ToolbarButtonType.SELECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L49:
            r0[ToolbarButtonType.DELETE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L51:
            r0[ToolbarButtonType.SHARE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L61:
            r0[ToolbarButtonType.DOWNLOAD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L69:
            r0[ToolbarButtonType.RENAME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L35
        L53:
            r0[ToolbarButtonType.MOVE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L36
        L18:
            a = r0;
            int[] r1 = new int[SourceType.values().length];
            r1[SourceType.USER_SEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
        L47:
            r1[SourceType.BOT_RESP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
        L59:
            r1[SourceType.CREATION_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
        L65:
            r1[SourceType.CREATION_RECORD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L40
        L71:
            r1[SourceType.ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L41
        L45:
            r1[SourceType.ATTACHMENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L42
        L57:
            r1[SourceType.CAMERA_RESULT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L43
        L63:
            r1[SourceType.CLOUD_DRIVE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L44
        L27:
            b = r1;
        }
    }

    static {
    }

    public PreviewToolbarCoordinator() {
        throw null;
    }

    public final void c() {
        q r0 = this.k;
        if (r0 == null) goto L6;
        r0.b(this.u);
    L6:
        if (this.p == false) goto L8;
        com.larus.platform.service.e0.a.c1(this);
    L8:
        this.r = null;
    }

    public static boolean e(String r3) {
        if (r3 == null) goto L9;
        String r4 = StringsKt.substringBefore$default(r3, '?', null, 2, null);
        if (r4 == null) goto L11;
        String r5 = StringsKt.substringBefore$default(r4, '#', null, 2, null);
        if (r5 != null) goto L8;
        return false;
    L8:
        return StringsKt.equals(StringsKt.substringAfterLast(r5, '.', ""), "gif", true);
    L11:
        return false;
    L9:
        return false;
    }

    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
    }

    public final MarkAction a(ToolbarButtonType r13) {
        PreviewCameraParamProvider r0 = this.i;
        if (r0 != null) goto L5;
        r0 = new PreviewCameraParamProvider(new d(), v.a, false, null);
    L5:
        PreviewCameraParamProvider r6 = r0;
        if (r13 != ToolbarButtonType.CROP) goto L8;
        AttachmentEditType r1 = AttachmentEditType.CROP;
    L9:
        e0 r7 = this.j;
        q r8 = this.k;
        return new MarkAction(r6, r7, r8, r1, r13, new PreviewToolbarCoordinator$createMarkAction$1(this));
    L8:
        r1 = AttachmentEditType.MARK;
        goto L9
    }

    public final PreviewToolbarView b(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        int r3 = 0;
        PreviewToolbarView r0 = new PreviewToolbarView(r8, null, 6, 0);
        ToolbarLayoutMode r9 = this.a;
        ToolbarVisualStyle r1 = this.b;
        ToolbarActionDispatcher r2 = this.q;
        List r4 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r9, "mode");
        Intrinsics.checkNotNullParameter(r1, "visualStyle");
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r4, "emphasizedButtons");
        r0.a = r9;
        r0.b = r1;
        r0.c = r2;
        r0.d = CollectionsKt.toSet(r4);
        r0.f = CollectionsKt.emptyList();
        FLogger.a.i("PreviewToolbarView", "init: mode=" + r9 + ", listener=" + r2);
        r0.removeAllViews();
        r0.e.removeAllViews();
        LinearLayout r5 = r0.e;
        int[] r6 = PreviewToolbarView.d.a;
        int r7 = r6[r9.ordinal()];
        if (r7 == 1) goto L8;
        if (r7 != 2) goto L7;
    L9:
        r5.setOrientation(r3);
        r0.e.setGravity(17);
        LinearLayout r10 = r0.e;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        int r12 = r6[r9.ordinal()];
        if (r12 == 1) goto L15;
        if (r12 != 2) goto L14;
        int r13 = 8388629;
    L16:
        r11.gravity = r13;
        int r14 = r6[r9.ordinal()];
        if (r14 == 1) goto L22;
        if (r14 != 2) goto L21;
        r11.setMarginEnd(i5.h());
    L23:
        r10.setLayoutParams(r11);
        r0.addView(r0.e);
        this.r = r0;
        return r0;
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        r11.topMargin = i5.z();
        r11.setMarginEnd(i5.r0());
        goto L23
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r13 = 8388661;
        goto L16
    L7:
        throw new NoWhenBranchMatchedException();
    L8:
        r3 = 1;
        goto L9
    }

    public final void bZ(UserCreation r29) {
        Intrinsics.checkNotNullParameter(r29, "userCreation");
        xy8.d r2 = (xy8.d) this.g.invoke();
        if (r2 != null) goto L5;
        return;
    L5:
        xy8.e r3 = r2.m;
        if (r3 != null) goto L8;
        return;
    L8:
        String r4 = r3.a;
        String r15 = r29.a;
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
    L19:
        String r6 = r3.c;
        CreationDynamicInfo r1 = r29.h;
        if (r1 == null) goto L22;
        String r7 = r1.d;
    L23:
        if (r6 != null) goto L25;
    L28:
        boolean r8 = true;
    L29:
        if (r8 == true) goto L41;
        if (r7 != null) goto L32;
    L35:
        boolean r9 = true;
    L36:
        if (r9 == true) goto L41;
        if (Intrinsics.areEqual(r6, r7) == true) goto L41;
        return;
    L32:
        if (r7.length() == 0) goto L35;
        r9 = false;
    L41:
        if (r15 == null) goto L44;
        r4 = r15;
    L44:
        xy8.e r10 = xy8.e.a(r3, r4, null, null, null, null, true, 1022);
        UserCreation r11 = r2.n;
        if (r11 == null) goto L47;
        UserCreation r12 = UserCreation.c(r11, 1, null, null, null, null, null, 131063);
    L48:
        xy8.d r13 = xy8.d.a(r2, null, null, null, null, null, null, r10, r12, null, 0, 118783);
        w r14 = (w) this.f.invoke();
        if (r14 == null) goto L51;
        r14.Rf(new p.j(r13, false));
    L51:
        FLogger.a.i("PreviewToolbarCoordinator", "onPublishSuccess: 更新预览发布状态, itemKey=" + r2.b + ", creationId=" + r15);
        return;
    L47:
        r12 = null;
        goto L48
    L25:
        if (r6.length() == 0) goto L28;
        r8 = false;
        goto L29
    L22:
        r7 = null;
        goto L23
    L17:
        if (Intrinsics.areEqual(r4, r15) == true) goto L19;
        return;
    L11:
        if (r4.length() == 0) goto L14;
        r5 = false;
        goto L15
    }

    public final a0 d(SourceType r4) {
        z r0 = ((sq9.e) this.n.getValue()).g();
        if (r0 != null) goto L6;
        return null;
    L6:
        switch(b.b[r4.ordinal()]) {
            case 1: goto L13;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            default: goto L8;
        };
    L14:
        return null;
    L8:
        throw new NoWhenBranchMatchedException();
    L15:
        return r0.c();
    L16:
        return r0.b();
    L17:
        return r0.a();
    L13:
        return r0.d();
    }

    public final void h(xy8.d r42) {
        Intrinsics.checkNotNullParameter(r42, "data");
        xy8.e r2 = r42.m;
        if (r2 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        Function1<SourceType, a0> r5 = this.l;
        if (r5 == null) goto L12;
        a0 r6 = (a0) r5.invoke(r42.a);
        if (r6 == null) goto L12;
    L13:
        int r7 = f.a;
        e r8 = f.a(r42, r6, this.m);
        List<String> r9 = r8.a;
        List<String> r11 = r8.b;
        List<String> r10 = r8.c;
        String r13 = "PreviewToolbarCoordinator";
        FLogger.a.d("PreviewToolbarCoordinator", "updateButtons: sourceType=" + r42.a + ", sourceConfig=" + r6 + ", order=" + r9 + ", more=" + r11 + ", emphasized=" + r10);
        PreviewToolbarView r12 = this.r;
        if (r12 == null) goto L18;
        Intrinsics.checkNotNullParameter(r10, "emphasizedButtons");
        Set<String> r14 = CollectionsKt.toSet(r10);
        if (Intrinsics.areEqual(r14, r12.d) == true) goto L18;
        r12.d = r14;
        r12.f = CollectionsKt.emptyList();
    L18:
        Map<SourceType, Set<ToolbarButtonType>> r15 = k.a;
        SourceType r16 = r42.a;
        ToolbarLayoutMode r17 = this.a;
        GalleryType r18 = r42.e;
        String r19 = r42.j.get("source_url");
        GalleryType r20 = r42.e;
        GalleryType r21 = GalleryType.Image;
        if (r20 == r21) goto L21;
        boolean r110 = false;
    L42:
        Intrinsics.checkNotNullParameter(r16, "sourceType");
        Intrinsics.checkNotNullParameter(r17, "layoutMode");
        Intrinsics.checkNotNullParameter(r9, "buttonOrder");
        Intrinsics.checkNotNullParameter(r11, "moreMenuItems");
        if (r17 != ToolbarLayoutMode.HORIZONTAL) goto L45;
        boolean r22 = true;
    L46:
        j[] r23 = new j[13];
        ToolbarButtonType r111 = ToolbarButtonType.SHARE;
        if (r22 == false) goto L49;
        int r24 = 2131241752;
    L50:
        r23[0] = new j(r111, r24, 2131241752, 2131901248, null, false, 336);
        ToolbarButtonType r27 = ToolbarButtonType.DOWNLOAD;
        if (r22 == false) goto L53;
        int r28 = 2131241748;
    L54:
        r23[1] = new j(r27, r28, 2131241748, 2131906511, null, false, 336);
        ToolbarButtonType r112 = ToolbarButtonType.MARK;
        if (r22 == false) goto L57;
        int r25 = 2131241744;
    L58:
        r23[2] = new j(r112, r25, 2131241744, 2131899433, null, false, 336);
        r23[3] = new j(ToolbarButtonType.CROP, 2131241739, 2131241739, 2131898781, null, false, 336);
        ToolbarButtonType r113 = ToolbarButtonType.PUBLISH;
        if (r22 == false) goto L61;
        int r26 = 2131241751;
    L62:
        r23[4] = new j(r113, r26, 2131241751, 2131901168, null, false, 336);
        ToolbarButtonType r29 = ToolbarButtonType.SET_PRIVATE;
        if (r22 == false) goto L65;
        int r210 = 2131241750;
    L66:
        r23[5] = new j(r29, r210, 2131241750, 2131899486, null, false, 336);
        ToolbarButtonType r211 = ToolbarButtonType.VIEW_SOURCE;
        if (r22 == false) goto L69;
        int r212 = 2131241753;
    L70:
        r23[6] = new j(r211, r212, 2131241753, 2131906360, null, false, 336);
        ToolbarButtonType r213 = ToolbarButtonType.DELETE;
        AppHost.Companion r214 = AppHost.a;
        int r4 = r214.getApplication().getResources().getIdentifier("larus_del_button", "string", r214.getApplication().getPackageName());
        if (r4 == 0) goto L73;
        String r30 = r214.getApplication().getString(r4);
        Intrinsics.checkNotNull(r30);
    L74:
        r23[7] = new j(r213, 2131242603, 2131241682, 0, r30, true, 320);
        r23[8] = new j(ToolbarButtonType.WATERMARK, 0, 2131241754, 0, "水印设置", true, 320);
        r23[9] = new j(ToolbarButtonType.SELECT, 2131243173, 2131243173, k.b, null, false, 336);
        r23[10] = new j(ToolbarButtonType.RENAME, 2131241847, 2131241847, 2131905329, null, true, 336);
        r23[11] = new j(ToolbarButtonType.MOVE, 2131242085, 2131242085, 2131905328, null, true, 336);
        ToolbarButtonType r215 = ToolbarButtonType.MORE;
        if (r22 == false) goto L77;
        int r216 = 2131241747;
    L78:
        r23[12] = new j(r215, r216, 0, 2131898823, null, false, 340);
        List r31 = CollectionsKt.listOf(r23);
        LinkedHashMap r32 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r31, 10)), 16));
        Iterator r33 = r31.iterator();
    L80:
        if (r33.hasNext() == false) goto L83;
        Object r34 = r33.next();
        r32.put(((j) r34).getType().getKey(), r34);
        goto L80
    L83:
        if ((!r9.isEmpty()) == false) goto L85;
    L117:
        String r114 = "PreviewToolbarCoordinator";
        ArrayList r35 = new ArrayList();
        boolean r115 = r9.contains(ToolbarButtonType.MORE.getKey());
        Iterator<String> r217 = r9.iterator();
        int r116 = -1;
    L119:
        if (r217.hasNext() == false) goto L136;
        j r218 = (j) r32.get(r217.next());
        if (r218 == null) goto L134;
        if (r218.getType() == ToolbarButtonType.DELETE) goto L134;
        if (r218.getType() == ToolbarButtonType.WATERMARK) goto L134;
        if (r218.getType() == ToolbarButtonType.MORE) goto L129;
        int r117 = r116;
        if (k.b(r218.getType(), r16, r3, r18, r19, r110) == false) goto L135;
        r35.add(j.a(r218, 0, 0, 0, false, false, null, 383));
    L135:
        r116 = r117;
        goto L119
    L129:
        r116 = r35.size();
    L134:
        r117 = r116;
        goto L135
    L136:
        int r118 = r116;
        if (r115 == false) goto L161;
        ArrayList r119 = new ArrayList();
        Iterator<String> r120 = r11.iterator();
    L140:
        if (r120.hasNext() == false) goto L149;
        j r219 = (j) r32.get(r120.next());
        if (r219 == null) goto L140;
        boolean r36 = r3;
        boolean r121 = r3;
        ArrayList r37 = r119;
        if (k.b(r219.getType(), r16, r36, r18, r19, r110) == false) goto L148;
        r37.add(j.a(r219, 0, 0, 0, false, true, null, 383));
    L148:
        r119 = r37;
        r3 = r121;
        goto L140
    L149:
        ArrayList r38 = r119;
        if ((!r38.isEmpty()) == false) goto L161;
        j r39 = (j) MapsKt.getValue(r32, ToolbarButtonType.MORE.getKey());
        if (r118 >= 0) goto L154;
    L156:
        boolean r40 = false;
    L157:
        if (r40 == false) goto L159;
        int r122 = r118;
    L160:
        ListProtector.add(r35, r122, r39);
        r35.addAll(r122 + 1, r38);
        goto L161
    L159:
        r122 = r35.size();
        goto L160
    L154:
        if (r118 > r35.size()) goto L156;
        r40 = true;
    L161:
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r35, 10));
        Iterator r43 = r35.iterator();
    L163:
        if (r43.hasNext() == false) goto L227;
        j r44 = (j) r43.next();
        q r45 = this.k;
        if (r45 == null) goto L167;
        l r46 = r45.getCapability();
    L169:
        switch(b.a[r44.getType().ordinal()]) {
            case 1: goto L196;
            case 2: goto L196;
            case 3: goto L189;
            case 4: goto L176;
            case 5: goto L174;
            case 6: goto L173;
            case 7: goto L172;
            case 8: goto L171;
            default: goto L204;
        };
    L171:
        boolean r47 = f(r44.getType(), r42, r44.f);
    L206:
        if (r44.getType() != ToolbarButtonType.SELECT) goto L221;
        Map<SourceType, Set<ToolbarButtonType>> r48 = k.a;
        if (r44.f == false) goto L211;
        if (r47 == false) goto L211;
        boolean r220 = true;
    L212:
        j r49 = j.a(r44, 0, 0, 0, r220, false, null, 479);
        q r50 = this.k;
        if (r50 == null) goto L218;
        if (r50.Oa(r42.b) != true) goto L218;
        boolean r51 = true;
    L219:
        j r52 = k.a(r49, r51);
    L226:
        r41.add(r52);
    L218:
        r51 = false;
    L211:
        r220 = false;
        goto L212
    L221:
        if (r44.f == false) goto L224;
        if (r47 == false) goto L224;
        boolean r221 = true;
    L225:
        r52 = j.a(r44, 0, 0, 0, r221, false, null, 479);
    L224:
        r221 = false;
        goto L225
    L172:
        r47 = f(r44.getType(), r42, r44.f);
        goto L206
    L173:
        r47 = f(r44.getType(), r42, r44.f);
        goto L206
    L174:
        r47 = f(r44.getType(), r42, r44.f);
        goto L206
    L189:
        if (r46 != null) goto L191;
    L193:
        boolean r53 = false;
    L194:
        if (r53 == false) goto L204;
    L203:
        r47 = false;
        goto L206
    L191:
        if (r46.b == true) goto L193;
        r53 = true;
        goto L194
    L196:
        if (r46 != null) goto L198;
    L200:
        boolean r54 = false;
    L201:
        if (r54 == true) goto L203;
    L198:
        if (r46.c == true) goto L200;
        r54 = true;
    L204:
        r47 = true;
        goto L206
    L176:
        if (r42.a != SourceType.CLOUD_DRIVE) goto L182;
        q r55 = this.k;
        if (r55 == null) goto L203;
        if (r55.l(PreviewSourceAction.DELETE, r42.b) != true) goto L203;
    L182:
        if (r46 != null) goto L184;
    L186:
        boolean r56 = false;
    L187:
        if (r56 == true) goto L203;
    L184:
        if (r46.d == true) goto L186;
        r56 = true;
        goto L187
    L167:
        r46 = null;
        goto L169
    L227:
        PreviewToolbarView r57 = this.r;
        if (r57 == null) goto L230;
        r57.setButtons(r41);
    L230:
        FLogger r58 = FLogger.a;
        StringBuilder r59 = new StringBuilder("updateButtons: sourceType=");
        r59.append(r42.a);
        r59.append(", buttons=");
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator r60 = r41.iterator();
    L232:
        if (r60.hasNext() == false) goto L234;
        j r61 = (j) r60.next();
        r1.add(r61.getType() + ':' + r61.f + ":overflow=" + r61.h);
        goto L232
    L234:
        r59.append(r1);
        r58.d(r114, r59.toString());
        return;
    L85:
        if ((!r11.isEmpty()) == true) goto L117;
        if (k.a.get(r16) != null) goto L90;
        SetsKt.emptySet();
    L90:
        List r62 = CollectionsKt.listOf(new ToolbarButtonType[]{ToolbarButtonType.SHARE, ToolbarButtonType.DOWNLOAD, ToolbarButtonType.MARK, ToolbarButtonType.PUBLISH, ToolbarButtonType.SET_PRIVATE, ToolbarButtonType.VIEW_SOURCE, ToolbarButtonType.DELETE, ToolbarButtonType.SELECT});
        r35 = new ArrayList();
        Iterator r63 = r62.iterator();
    L92:
        if (r63.hasNext() == false) goto L101;
        ToolbarButtonType r123 = (ToolbarButtonType) r63.next();
        j r222 = (j) r32.get(r123.getKey());
        if (r222 == null) goto L92;
        Iterator r124 = r63;
        LinkedHashMap r64 = r32;
        String r125 = r13;
        boolean r223 = k.b(r123, r16, r3, r18, r19, r110);
        if (r123 != ToolbarButtonType.DELETE) goto L99;
        boolean r224 = true;
    L100:
        r35.add(j.a(r222, 0, 0, 0, r223, r224, null, 351));
        r32 = r64;
        r63 = r124;
        r13 = r125;
        goto L92
    L99:
        r224 = false;
        goto L100
    L101:
        LinkedHashMap r65 = r32;
        r114 = r13;
        if (r35.isEmpty() == true) goto L115;
        Iterator r66 = r35.iterator();
    L106:
        if (r66.hasNext() == false) goto L115;
        j r67 = (j) r66.next();
        if (r67.h == true) goto L110;
    L112:
        boolean r68 = false;
    L113:
        if (r68 == false) goto L106;
        boolean r225 = true;
    L116:
        r35.add(j.a((j) MapsKt.getValue(r65, ToolbarButtonType.MORE.getKey()), 0, 0, 0, r225, false, null, 479));
        goto L161
    L110:
        if (r67.f == false) goto L112;
        r68 = true;
    L115:
        r225 = false;
        goto L116
    L77:
        r216 = 2131241746;
        goto L78
    L73:
        r30 = r214.getApplication().getString(2131898799);
        Intrinsics.checkNotNull(r30);
        goto L74
    L69:
        r212 = 2131241758;
        goto L70
    L65:
        r210 = 2131241755;
        goto L66
    L61:
        r26 = 2131241756;
        goto L62
    L57:
        r25 = 2131241745;
        goto L58
    L53:
        r28 = 2131241740;
        goto L54
    L49:
        r24 = 2131241757;
        goto L50
    L45:
        r22 = false;
        goto L46
    L21:
        Boolean r69 = (Boolean) ((LinkedHashMap) this.s).get(r42.b);
        if (r69 == null) goto L25;
        boolean r70 = r69.booleanValue();
    L41:
        r110 = r70;
        goto L42
    L25:
        if (r42.e != r21) goto L39;
        xy8.b r71 = r42.c;
        if (r71 == null) goto L39;
        if (e(r71.a) == false) goto L33;
    L40:
        r70 = true;
        goto L41
    L33:
        if (e(r71.b) == true) goto L40;
        if (e(r71.c) == true) goto L40;
        if (e(r71.d) == true) goto L40;
    L39:
        r70 = false;
    L12:
        r6 = d(r42.a);
        goto L13
    L5:
        if (r2.k != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public final void g(xy8.d r4, p.k r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        ImageInfo r0 = r5.b;
        if (r0 != null) goto L5;
        Boolean r1 = null;
    L16:
        if (r1 == null) goto L28;
        boolean r2 = r1.booleanValue();
        if (r4 != null) goto L21;
        return;
    L21:
        if (r5.a == this.t) goto L23;
        return;
    L23:
        Map<String, Boolean> r6 = this.s;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        if (Intrinsics.areEqual(r7.get(r4.b), Boolean.valueOf(r2)) == false) goto L26;
        return;
    L26:
        Boolean r8 = Boolean.valueOf(r2);
        this.s.put(r4.b, r8);
        h(r4);
        return;
    L28:
        return;
    L5:
        ImageFormat r3 = r0.getImageFormat();
        boolean r9 = true;
        if (r0.getImageCount() <= 1) goto L8;
    L15:
        r1 = Boolean.valueOf(r9);
        goto L16
    L8:
        if (Intrinsics.areEqual(r3, DefaultImageFormats.GIF) == true) goto L15;
        if (Intrinsics.areEqual(r3, DefaultImageFormats.WEBP_ANIMATED) == true) goto L15;
        if (DefaultImageFormats.isHeifFormatAnimated(r3) == true) goto L15;
        r9 = false;
        goto L15
    }

    public final boolean f(ToolbarButtonType r5, xy8.d r6, boolean r7) {
        q r0 = this.k;
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r6.a == SourceType.CLOUD_DRIVE) goto L8;
        return true;
    L8:
        int r8 = b.a[r5.ordinal()];
        if (r8 != 5) goto L11;
        PreviewSourceAction r9 = PreviewSourceAction.SHARE;
    L22:
        if (r0.l(r9, r6.b) == true) goto L27;
        if (r7 == false) goto L28;
        return false;
    L28:
        return true;
    L27:
        return true;
    L11:
        if (r8 != 6) goto L13;
        r9 = PreviewSourceAction.DOWNLOAD;
        goto L22
    L13:
        if (r8 != 7) goto L15;
        r9 = PreviewSourceAction.RENAME;
        goto L22
    L15:
        if (r8 == 8) goto L17;
        return true;
    L17:
        r9 = PreviewSourceAction.MOVE;
        goto L22
    }

    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        r.a.a(r1, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.chat.gallery.impl.preview.toolbar.c, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.chat.gallery.impl.preview.toolbar.b] */
    public PreviewToolbarCoordinator(ToolbarLayoutMode r17, ToolbarVisualStyle r18, CoroutineScope r19, Function0 r20, Function0 r21, Function0 r22, Function0 r23, Function0 r24, PreviewCameraParamProvider r25, e0 r26, q r27, Boolean r28, Function1 r29, boolean r30, int r31) {
        if ((r31 & 2) == 0) goto L5;
        ToolbarVisualStyle r9 = ToolbarVisualStyle.LEGACY;
    L7:
        if ((r31 & 256) == 0) goto L9;
        PreviewCameraParamProvider r10 = null;
    L11:
        if ((r31 & 512) == 0) goto L13;
        e0 r12 = null;
    L15:
        if ((r31 & 1024) == 0) goto L17;
        q r13 = 0;
    L19:
        if ((r31 & 2048) == 0) goto L21;
        Boolean r14 = null;
    L23:
        if ((r31 & 4096) == 0) goto L25;
        Function1 r15 = null;
    L27:
        if ((r31 & 8192) == 0) goto L29;
        boolean r8 = false;
    L30:
        Intrinsics.checkNotNullParameter(r17, "layoutMode");
        Intrinsics.checkNotNullParameter(r9, "visualStyle");
        Intrinsics.checkNotNullParameter(r19, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r20, "contextProvider");
        Intrinsics.checkNotNullParameter(r21, "fragmentManagerProvider");
        Intrinsics.checkNotNullParameter(r22, "mediatorProvider");
        Intrinsics.checkNotNullParameter(r23, "dataProvider");
        Intrinsics.checkNotNullParameter(r24, "toolbarCapabilityProvider");
        this.a = r17;
        this.b = r9;
        this.c = r19;
        this.d = r20;
        this.e = r21;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        this.i = r10;
        this.j = r12;
        this.k = r13;
        this.l = r15;
        this.m = r8;
        Lazy r1 = LazyKt.lazy(new com.larus.chat.gallery.impl.preview.toolbar.a());
        this.n = r1;
        if (r14 == null) goto L33;
        boolean r2 = r14.booleanValue();
    L34:
        this.o = r2;
        boolean r3 = z2.a.getCreationPublishConfig().b();
        this.p = r3;
        ToolbarActionDispatcher r4 = new ToolbarActionDispatcher(r19, new com.larus.chat.gallery.impl.preview.toolbar.b(this));
        this.q = r4;
        this.s = new LinkedHashMap();
        this.t = -1;
        ?? r5 = new c(this);
        this.u = r5;
        o r6 = new com.larus.chat.gallery.impl.preview.toolbar.action.q();
        o r7 = new DownloadAction();
        o r11 = new DeleteAction();
        ToolbarButtonType r16 = ToolbarButtonType.SHARE;
        if (r13 == 0) goto L37;
        r6 = new SourceOwnerAction(r13, PreviewSourceAction.SHARE, r6);
    L37:
        r4.d(r16, r6);
        ToolbarButtonType r32 = ToolbarButtonType.DOWNLOAD;
        if (r13 == 0) goto L40;
        r7 = new SourceOwnerAction(r13, PreviewSourceAction.DOWNLOAD, r7);
    L40:
        r4.d(r32, r7);
        ToolbarButtonType r33 = ToolbarButtonType.MARK;
        r4.d(r33, a(r33));
        ToolbarButtonType r34 = ToolbarButtonType.CROP;
        r4.d(r34, a(r34));
        r4.d(ToolbarButtonType.PUBLISH, new PublishAction());
        r4.d(ToolbarButtonType.SET_PRIVATE, new SetPrivateAction());
        r4.d(ToolbarButtonType.VIEW_SOURCE, new n0());
        ToolbarButtonType r35 = ToolbarButtonType.DELETE;
        if (r13 == 0) goto L43;
        r11 = new SourceOwnerAction(r13, PreviewSourceAction.DELETE, r11);
    L43:
        r4.d(r35, r11);
        if (r13 == 0) goto L46;
        r4.d(ToolbarButtonType.RENAME, new SourceOwnerAction(r13, PreviewSourceAction.RENAME, null));
        r4.d(ToolbarButtonType.MOVE, new SourceOwnerAction(r13, PreviewSourceAction.MOVE, null));
    L46:
        r4.d(ToolbarButtonType.WATERMARK, new o0());
        if (r13 == 0) goto L49;
        r4.d(ToolbarButtonType.SELECT, new com.larus.chat.gallery.impl.preview.toolbar.action.v(r13));
    L49:
        if (r13 == 0) goto L51;
        r13.f(r5);
    L51:
        if (r3 == false) goto L54;
        com.larus.platform.service.e0.a.e1(this);
        return;
    L54:
        return;
    L33:
        r2 = ((sq9.e) r1.getValue()).e();
        goto L34
    L29:
        r8 = r30;
        goto L30
    L25:
        r15 = r29;
        goto L27
    L21:
        r14 = r28;
        goto L23
    L17:
        r13 = r27;
        goto L19
    L13:
        r12 = r26;
        goto L15
    L9:
        r10 = r25;
        goto L11
    L5:
        r9 = r18;
        goto L7
    }
}
