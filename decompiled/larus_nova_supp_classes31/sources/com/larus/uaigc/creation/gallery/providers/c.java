package com.larus.uaigc.creation.gallery.providers;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.utils.c4;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.home.impl.sdk.b1;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.e0;
import com.larus.platform.service.z2;
import com.larus.uaigc.impl.databinding.LarusGalleryCreationBottomBinding;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c extends com.larus.gallery.api.t<sz9.b> implements zp9.r, b0 {
    public final jy9.x f;
    public final jy9.e g;
    public LarusGalleryCreationBottomBinding h;
    public final Map<String, sz9.a> i;

    public static final class a implements rz9.d {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // rz9.d
        public final void c(String r3) {
            Intrinsics.checkNotNullParameter(r3, "creationKey");
            Map<String, UserCreationFromIM> r0 = this.a.z();
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.containsKey(r3) != true) goto L7;
        L8:
            if (r1 == true) goto L10;
            return;
        L10:
            Map<String, UserCreationFromIM> r2 = this.a.z();
            if (r2 == null) goto L13;
            UserCreationFromIM r4 = r2.remove(r3);
        L13:
            c.y(this.a, "deleteCreation");
            return;
        L7:
            r1 = false;
            goto L8
        }

        @Override // rz9.d
        public final void a(String r16, String r17, int r18) {
            Intrinsics.checkNotNullParameter(r16, "creationId");
            Intrinsics.checkNotNullParameter(r17, "creationKey");
            Map<String, UserCreationFromIM> r2 = this.a.z();
            if (r2 == null) goto L7;
            boolean r3 = true;
            if (r2.containsKey(r17) != true) goto L7;
        L8:
            if (r3 == true) goto L10;
            return;
        L10:
            Map<String, UserCreationFromIM> r4 = this.a.z();
            if (r4 == null) goto L14;
            UserCreationFromIM r5 = r4.get(r17);
            if (r5 == null) goto L14;
        L15:
            UserCreationFromIM r6 = UserCreationFromIM.copy$default(r5, r16, null, Integer.valueOf(r18), null, null, null, null, 122, null);
            Map<String, UserCreationFromIM> r7 = this.a.z();
            if (r7 == null) goto L18;
            UserCreationFromIM r1 = r7.put(r17, r6);
        L18:
            c.y(this.a, "updateCreationPrivacy");
            return;
        L14:
            r5 = new UserCreationFromIM(null, null, null, null, null, null, null, 127, null);
        L7:
            r3 = false;
            goto L8
        }

        @Override // rz9.d
        public final void b(String r16, String r17, int r18) {
            Intrinsics.checkNotNullParameter(r16, "creationKey");
            Intrinsics.checkNotNullParameter(r17, "creationId");
            Map<String, UserCreationFromIM> r2 = this.a.z();
            if (r2 == null) goto L6;
            UserCreationFromIM r3 = r2.get(r16);
            if (r3 == null) goto L6;
        L7:
            UserCreationFromIM r4 = UserCreationFromIM.copy$default(r3, r17, null, Integer.valueOf(r18), null, null, null, null, 122, null);
            Map<String, UserCreationFromIM> r5 = this.a.z();
            if (r5 == null) goto L10;
            r5.put(r16, r4);
        L10:
            c.y(this.a, "addCreation");
            return;
        L6:
            r3 = new UserCreationFromIM(null, null, null, null, null, null, null, 127, null);
            goto L7
        }
    }

    public final boolean m() {
        return false;
    }

    @Override // com.larus.uaigc.creation.gallery.providers.b0
    public final void d() {
        LarusGalleryCreationBottomBinding r0 = this.h;
        if (r0 == null) goto L8;
        CreationBottomView r1 = r0.b;
        if (r1 == null) goto L9;
        r1.c6();
        return;
    L9:
        return;
    }

    public final void t() {
        com.larus.gallery.api.w r0 = ((com.larus.gallery.api.t) this).e;
        if (r0 == null) goto L6;
        r0.Op(Reflection.getOrCreateKotlinClass(b0.class), this);
        return;
    }

    public final void u() {
        e0.a.c1(this);
        LarusGalleryCreationBottomBinding r0 = this.h;
        if (r0 == null) goto L8;
        CreationBottomView r1 = r0.b;
        if (r1 == null) goto L9;
        r1.a.d.onDestroy();
        return;
    L9:
        return;
    }

    public final Map<String, UserCreationFromIM> z() {
        sz9.b r0 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k;
    }

    public final int A(String r4) {
        sz9.b r0 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r0 == null) goto L14;
        Message r1 = r0.a;
        if (r1 == null) goto L14;
        String r2 = r1.getMessageId();
        if (r2 == null) goto L14;
        if (r2.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 != true) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
        return 0;
    L17:
        Map<String, UserCreationFromIM> r6 = z();
        if (r6 == null) goto L20;
        UserCreationFromIM r7 = r6.get(r4);
    L21:
        if (r7 != null) goto L23;
        return 1;
    L23:
        Integer r8 = r7.getPrivateStatus();
        if (r8 != null) goto L27;
    L29:
        if (r8 != null) goto L32;
        return 0;
    L32:
        if (r8.intValue() != 2) goto L36;
        return 2;
    L36:
        return 0;
    L27:
        if (r8.intValue() != 1) goto L29;
        return 3;
    L20:
        r7 = null;
        goto L21
    L11:
        r3 = false;
    L14:
        r5 = false;
        goto L15
    }

    public final String B(String r2) {
        Map<String, UserCreationFromIM> r0 = z();
        if (r0 == null) goto L8;
        UserCreationFromIM r3 = r0.get(r2);
        if (r3 == null) goto L8;
        String r4 = r3.getCreationId();
        if (r4 == null) goto L8;
        return r4;
    L8:
        return "";
    }

    @Override // zp9.r
    public final void X0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "creationId");
    }

    @Override // zp9.r
    public final void bZ(UserCreation r5) {
        Intrinsics.checkNotNullParameter(r5, "userCreation");
        FLogger.a.i(((com.larus.gallery.api.t) this).a, "onPublishSuccess, creationId: " + r5.a);
        String r6 = r5.a;
        if (r6 == null) goto L10;
        LarusGalleryCreationBottomBinding r0 = this.h;
        if (r0 == null) goto L11;
        CreationBottomView r1 = r0.b;
        if (r1 == null) goto L12;
        r1.n6(3, r6, "onPublishSuccess");
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.uaigc.creation.gallery.providers.b0
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        LarusGalleryCreationBottomBinding r0 = this.h;
        if (r0 == null) goto L8;
        CreationBottomView r1 = r0.b;
        if (r1 == null) goto L9;
        r1.i6(r2);
        return;
    L9:
        return;
    }

    @Override // com.larus.uaigc.creation.gallery.providers.b0
    public final boolean f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Map<String, UserCreationFromIM> r0 = z();
        if (r0 == null) goto L5;
        UserCreationFromIM r3 = r0.get(r2);
    L6:
        if (r3 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.uaigc.creation.gallery.providers.b0
    public final String h(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        CreationGalleryUtil r0 = CreationGalleryUtil.a;
        return CreationGalleryUtil.d(Integer.valueOf(A(r2)));
    }

    public final View p(ViewGroup r6) {
        boolean r2 = false;
        View r7 = LayoutInflater.from(getContext()).inflate(2131562443, r6, false);
        CreationBottomView r1 = (CreationBottomView) ViewBindings.findChildViewById(r7, 2131364398);
        if (r1 == null) goto L52;
        FrameLayout r8 = (FrameLayout) r7;
        this.h = new LarusGalleryCreationBottomBinding(r8, r1);
        if (r8 == null) goto L7;
        r8.setPadding(0, 0, 0, IChatGalleryService.a.c(getContext()));
    L7:
        LarusGalleryCreationBottomBinding r9 = this.h;
        if (r9 == null) goto L46;
        final CreationBottomView r10 = r9.b;
        if (r10 == null) goto L46;
        a r0 = new a(this);
        jy9.e r3 = this.g;
        final ic8.d r4 = r3.b;
        ic8.d r5 = r3.a;
        r10.c = r0;
        sq9.r r11 = z2.a.getCreationEditControlConfig().a();
        if (r11 == null) goto L19;
        Integer r12 = r11.b();
        if (r12 == null) goto L19;
        if (r12.intValue() != 1) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L34;
        if (r4 != null) goto L23;
    L25:
        boolean r14 = false;
    L26:
        if (r14 == true) goto L33;
        if (r5 != null) goto L29;
    L31:
        boolean r15 = false;
    L32:
        if (r15 == false) goto L34;
    L29:
        if (r5.a != true) goto L31;
        r15 = true;
    L33:
        boolean r16 = true;
    L35:
        if (r16 == true) goto L43;
        if (r4 != null) goto L38;
    L40:
        boolean r17 = false;
    L41:
        if (r17 == false) goto L43;
        r2 = true;
        goto L43
    L38:
        if (r4.a != true) goto L40;
        r17 = true;
    L43:
        if (r2 == false) goto L45;
        e1.x(r10.a.b);
        e1.d(r10.a.b, new j(r10, r4));
        goto L46
    L45:
        e1.o(r10.a.b);
        goto L46
    L23:
        if (r4.a != true) goto L25;
        r14 = true;
    L34:
        r16 = false;
    L19:
        r13 = false;
    L46:
        LarusGalleryCreationBottomBinding r18 = this.h;
        if (r18 != null) goto L53;
        return null;
    L53:
        return r18.a;
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(2131364398)));
    }

    public final void x(com.larus.gallery.api.p r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof com.larus.gallery.api.p.e) == false) goto L13;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L7;
        r3.D0();
        b1.a.c("creation_gallery_long_press_share");
    L7:
        LarusGalleryCreationBottomBinding r4 = this.h;
        if (r4 == null) goto L14;
        CreationBottomView r5 = r4.b;
        if (r5 == null) goto L15;
        r5.i6("long_press");
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // zp9.r
    public final void yE(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
    }

    public c(jy9.x r2, jy9.e r3) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        Intrinsics.checkNotNullParameter(r3, "aiEditParams");
        this.f = r2;
        this.g = r3;
        this.i = new LinkedHashMap();
        if (z2.a.getCreationPublishConfig().b() == false) goto L6;
        e0.a.e1(this);
        return;
    }

    public static final void y(c r4, String r5) {
        r4.getClass();
        String r6 = r5.concat(":");
        Map<String, UserCreationFromIM> r0 = r4.z();
        if (r0 == null) goto L21;
        Set<String> r1 = r0.keySet();
        if (r1 == null) goto L21;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L21;
        String r3 = (String) r2.next();
        StringBuilder r7 = new StringBuilder();
        r7.append(r6);
        r7.append("key:");
        r7.append(r3);
        r7.append(", value:[");
        Map<String, UserCreationFromIM> r8 = r4.z();
        Integer r9 = null;
        if (r8 == null) goto L14;
        UserCreationFromIM r10 = r8.get(r3);
        if (r10 == null) goto L14;
        String r11 = r10.getCreationId();
    L15:
        r7.append(r11);
        r7.append("$, ");
        Map<String, UserCreationFromIM> r12 = r4.z();
        if (r12 == null) goto L20;
        UserCreationFromIM r13 = r12.get(r3);
        if (r13 == null) goto L20;
        r9 = r13.getPrivateStatus();
    L20:
        r7.append(r9);
        r7.append("];;");
        r6 = r7.toString();
    L14:
        r11 = null;
    L21:
        FLogger.a.i(((com.larus.gallery.api.t) r4).a, r6);
    }

    public final void w(Object r61, int r62) {
        sz9.b r1 = (sz9.b) r61;
        Intrinsics.checkNotNullParameter(r1, "data");
        ((com.larus.gallery.api.t) this).d = r1;
        String r2 = sz9.d.a(r1);
        sz9.a r15 = (sz9.a) ((LinkedHashMap) this.i).get(r2);
        zo8.b r3 = r1.c;
        if (r3 == null) goto L34;
        n1 r5 = r3.a;
        CreationGalleryUtil r4 = CreationGalleryUtil.a;
        Intrinsics.checkNotNullParameter(r5, "image");
        if (Intrinsics.areEqual(r5.c, r5.a) == true) goto L7;
        Uri r6 = com.larus.image.loader.b0.a(r5.c, "creation.photo_dialog_download", false, false, 6);
    L8:
        Uri r7 = r6;
        Uri r8 = com.larus.image.loader.b0.a(r1.c.a.a, "common.photo_dialog_preview", false, false, 6);
        zo8.b r9 = r1.c;
        String r10 = r9.d;
        if (r10 != null) goto L11;
        r10 = "";
    L11:
        boolean r11 = r1.g;
        boolean r12 = r9.e;
        boolean r13 = this.f.r;
        Message r14 = r1.a;
        Boolean r16 = r1.b;
        if (r16 == null) goto L14;
        boolean r17 = r16.booleanValue();
    L15:
        Integer r18 = r1.m;
        boolean r19 = r1.f;
        String r110 = r1.c.c;
        String r111 = B(r2);
        Map<String, UserCreationFromIM> r112 = z();
        if (r112 == null) goto L27;
        UserCreationFromIM r113 = r112.get(r2);
        if (r113 == null) goto L27;
        boolean r114 = r19;
        Integer r22 = r18;
        if (Intrinsics.areEqual(r113.getCreationId(), B(r2)) == true) goto L23;
        r113 = null;
    L23:
        if (r113 == null) goto L28;
        Integer r20 = r113.getCreationType();
        if (r20 == null) goto L28;
    L29:
        Integer r115 = r20;
        int r23 = A(r2);
        sz9.b r21 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r21 == null) goto L32;
        JSONObject r29 = r21.i;
    L33:
        zo8.b r24 = r1.c;
        String r25 = r24.g;
        String r26 = r24.h;
        boolean r27 = r1.l;
        boolean r116 = r114;
        sz9.a r33 = r15;
        Integer r117 = r22;
        JSONObject r28 = r29;
        sz9.a r118 = new sz9.a(r5, r7, r8, r2, r10, r110, r115, r11, r12, r13, r116, r23, r117, r17, r111, r24.i, null, null, r28, r14, r25, r26, r27, r1.n, 851972);
    L58:
        if (r118 == null) goto L72;
        sz9.a r30 = r33;
        if (r30 == null) goto L73;
        int r31 = r30.c;
        String r32 = r30.p;
        if (r32.length() <= 0) goto L65;
        boolean r119 = true;
    L66:
        if (r119 == true) goto L69;
        r32 = null;
    L69:
        if (r32 != null) goto L71;
        r32 = r118.p;
    L71:
        int r34 = r30.m;
        n1 r35 = r118.a;
        Uri r36 = r118.b;
        Uri r37 = r118.d;
        String r38 = r118.e;
        String r39 = r118.f;
        String r40 = r118.g;
        Integer r41 = r118.h;
        boolean r42 = r118.i;
        boolean r43 = r118.j;
        boolean r44 = r118.k;
        boolean r45 = r118.l;
        Integer r46 = r118.n;
        boolean r47 = r118.o;
        com.larus.bmhome.bigimg.l r48 = r118.q;
        String r49 = r118.r;
        nr9.g r50 = r118.s;
        c4 r51 = r118.t;
        JSONObject r52 = r118.u;
        Message r53 = r118.v;
        String r54 = r118.w;
        String r55 = r118.x;
        boolean r56 = r118.y;
        Integer r57 = r118.z;
        Intrinsics.checkNotNullParameter(r38, "creationKey");
        Intrinsics.checkNotNullParameter(r39, "creationTaskId");
        Intrinsics.checkNotNullParameter(r32, "creationId");
        r118 = new sz9.a(r35, r36, r31, r37, r38, r39, r40, r41, r42, r43, r44, r45, r34, r46, r47, r32, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57);
        goto L73
    L65:
        r119 = false;
    L73:
        if (r118 == null) goto L75;
        this.i.put(r2, r118);
    L75:
        LarusGalleryCreationBottomBinding r58 = this.h;
        if (r58 == null) goto L80;
        CreationBottomView r59 = r58.b;
        if (r59 == null) goto L80;
        r59.Y5(r118);
    L80:
        if (r118 == null) goto L82;
        Integer r120 = r118.h;
    L83:
        sz9.b r60 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r60 == null) goto L95;
        zo8.b r63 = r60.c;
        if (r63 == null) goto L95;
        CreationGalleryUtil r64 = CreationGalleryUtil.a;
        if (CreationGalleryUtil.j(r120) == false) goto L95;
        sz9.b r65 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r65 == null) goto L92;
        zo8.b r121 = r65.c;
    L93:
        if (r121 == null) goto L95;
        List r66 = null;
        BuildersKt.launch$default(r(), null, null, new CreationBottomProvider$prefetchToCreationBitmapCache$1$1(r63, null), 3, null);
    L96:
        CreationNoWatermarkManager r122 = CreationNoWatermarkManager.a;
        Message r123 = r1.a;
        Function0<List<Message>> r67 = this.f.u;
        if (r67 == null) goto L102;
        List r68 = (List) r67.invoke();
        if (r68 == null) goto L102;
    L107:
        List r124 = r68;
    L109:
        r122.getClass();
        kq9.i r69 = CreationNoWatermarkManager.i0();
        if (r69.a() == true) goto L113;
        return;
    L113:
        if (CreationNoWatermarkManager.v == true) goto L115;
    L117:
        int r125 = r69.b();
        r122.N(r123, r124, r125, r125, "gallery_neighbor");
        return;
    L115:
        if (CreationNoWatermarkManager.u == true) goto L117;
        return;
    L102:
        q0.a r70 = this.f.b;
        if (r70 == null) goto L108;
        q0 r71 = r70.e();
        if (r71 == null) goto L108;
        r68 = r71.getCurrentList();
    L108:
        r124 = r66;
        goto L109
    L92:
        r121 = null;
    L95:
        r66 = null;
        goto L96
    L82:
        r120 = null;
        goto L83
    L72:
        r118 = null;
        goto L73
    L32:
        r29 = null;
    L28:
        r20 = r1.m;
    L27:
        r114 = r19;
        r22 = r18;
        goto L28
    L14:
        r17 = false;
        goto L15
    L7:
        r6 = com.larus.image.loader.b0.a(r5.a, "creation.photo_dialog_download", false, false, 6);
        goto L8
    L34:
        r33 = r15;
        zo8.e r72 = r1.d;
        if (r72 == null) goto L57;
        String r73 = r72.k;
        if (r73 != null) goto L39;
        String r74 = "";
    L40:
        boolean r126 = r1.g;
        boolean r127 = r72.l;
        boolean r128 = this.f.r;
        Message r129 = r1.a;
        Boolean r75 = r1.b;
        if (r75 == null) goto L43;
        boolean r130 = r75.booleanValue();
    L44:
        Integer r131 = r1.m;
        boolean r76 = r1.f;
        String r77 = r1.d.a;
        String r132 = B(r2);
        Map<String, UserCreationFromIM> r78 = z();
        if (r78 == null) goto L55;
        UserCreationFromIM r79 = r78.get(r2);
        if (r79 == null) goto L55;
        if (Intrinsics.areEqual(r79.getCreationId(), B(r2)) == true) goto L52;
        r79 = null;
    L52:
        if (r79 == null) goto L55;
        Integer r80 = r79.getCreationType();
        if (r80 == null) goto L55;
    L56:
        Integer r133 = r80;
        int r134 = A(r2);
        zo8.e r81 = r1.d;
        nr9.g r82 = r81.c;
        c4 r83 = r81.b;
        r118 = new sz9.a(null, null, null, r2, r74, r77, r133, r126, r127, r128, r76, r134, r131, r130, r132, null, r82, r83, r83.m, r129, null, null, false, r1.n, 29556751);
    L55:
        r80 = r1.m;
        goto L56
    L43:
        r130 = false;
        goto L44
    L39:
        r74 = r73;
        goto L40
    L57:
        r118 = null;
        goto L58
    }

    @Override // zp9.r
    public final void i20(UserCreation r1, long r2, long r4, String r6) {
        zp9.r.a.a(r1, r6);
    }
}
