package com.larus.community.impl.component;

import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.download.ImageDownloadLoadingMgr;
import com.larus.bmhome.share.ShareScene;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.ICommunityService;
import com.larus.community.api.tracker.CreationFeedBehaviorTracker;
import com.larus.community.impl.adapter.CreationListAdapter;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.AiBeautifyUserContent;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.UserCreationUserAvatar;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import hq9.v1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.u3;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d0 implements g29.i {
    public final /* synthetic */ CreationFeedComponent a;

    @Override // g29.i
    public final void b() {
        if (NetworkUtils.isNetworkAvailable(this.a.getContext()) == false) goto L5;
        CreationFeedComponent r0 = this.a;
        int r1 = CreationFeedComponent.K;
        CreationFeedViewModel.fetchFirstScreenData$default(r0.C3(), false, true, false, 5, null);
        return;
    L5:
        t19.s.j(t19.s.a, AppHost.a.getApplication(), this.a.getContext().getString(2131908080), null, false, 28);
    }

    @Override // g29.i
    public final void e() {
        CreationFeedComponent r0 = this.a;
        int r1 = CreationFeedComponent.K;
        r0.C3().tryLoadMore(true);
    }

    public d0(CreationFeedComponent r1) {
        this.a = r1;
    }

    @Override // g29.i
    public final void a(int r21) {
        RecyclerView r2 = this.a.n.a();
        boolean r3 = false;
        if (r2 == null) goto L5;
        this.a.X3(r2, false, false);
    L5:
        CreationFeedComponent r4 = this.a;
        CreationFeedBehaviorTracker<UserCreation> r5 = r4.F;
        if (r5.f == true) goto L8;
    L10:
        if (r3 == false) goto L71;
        CreationListAdapter r6 = r4.s;
        if (r6 == null) goto L71;
        List<UserCreationModel> r7 = r6.b;
        if (r7 == null) goto L71;
        UserCreationModel r8 = (UserCreationModel) CollectionsKt.getOrNull(r7, r21);
        if (r8 == null) goto L71;
        List r9 = r8.b();
        if (r9 == null) goto L71;
        UserCreation r10 = (UserCreation) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L71;
        CreationFeedComponent r11 = this.a;
        r11.getClass();
        UserCreationTrackParams r12 = r10.n;
        String r13 = null;
        if (r12 == null) goto L25;
        String r14 = r12.g;
        if (r14 == null) goto L25;
    L30:
        String r15 = r14;
    L32:
        zp9.f r16 = r11.x;
        if (r16 == null) goto L37;
        zp9.g r17 = r16.e;
        if (r17 == null) goto L37;
        String r18 = r17.a;
    L38:
        if (r16 == null) goto L42;
        zp9.g r20 = r16.e;
        if (r20 == null) goto L42;
        String r22 = r20.i;
    L43:
        if (r12 == null) goto L45;
        Integer r110 = r12.b;
    L46:
        if (r16 == null) goto L50;
        zp9.g r23 = r16.e;
        if (r23 == null) goto L50;
        String r111 = r23.h;
    L51:
        if (r16 == null) goto L56;
        zp9.g r24 = r16.e;
        if (r24 == null) goto L56;
        String r25 = r24.j;
        if (r25 == null) goto L56;
    L60:
        String r112 = r25;
    L62:
        if (r16 == null) goto L66;
        zp9.g r26 = r16.e;
        if (r26 == null) goto L66;
        String r113 = r26.b;
    L67:
        String r114 = r10.a;
        String r115 = r10.i;
        if (r12 == null) goto L70;
        r13 = r12.a;
    L70:
        u3.i(r15, r18, r22, r110, r111, r112, r114, r115, r13, zp9.d.b(r10), zp9.d.c(r10), zp9.d.d(r10), r113);
    L66:
        r113 = null;
    L56:
        if (r16 == null) goto L61;
        zp9.g r27 = r16.e;
        if (r27 == null) goto L61;
        r25 = r27.b;
    L61:
        r112 = null;
    L50:
        r111 = null;
        goto L51
    L45:
        r110 = null;
    L42:
        r22 = null;
    L37:
        r18 = null;
    L25:
        zp9.f r28 = r11.x;
        if (r28 == null) goto L31;
        zp9.g r30 = r28.e;
        if (r30 == null) goto L31;
        r14 = r30.c;
    L31:
        r15 = null;
    L71:
        CreationFeedComponent.Y2(this.a, r21, "click_creation");
        return;
    L8:
        if (r5.g == false) goto L10;
        r3 = true;
        goto L10
    }

    @Override // g29.i
    public final void c(final UserCreation r90) {
        Intrinsics.checkNotNullParameter(r90, "userCreation");
        FragmentActivity r13 = null;
        if (r90.b != 1) goto L15;
        CreationFeedComponent r2 = this.a;
        if (r2.z != null) goto L15;
        r2.z = new FrameLayout(this.a.getContext());
        CreationFeedComponent r3 = this.a;
        FrameLayout r4 = r3.z;
        if (r4 == null) goto L15;
        View r5 = r3.F2();
        if ((r5 instanceof FrameLayout) == false) goto L11;
        FrameLayout r6 = (FrameLayout) r5;
    L12:
        if (r6 == null) goto L14;
        r6.addView(r4);
    L14:
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(i5.b(), i5.b());
        r7.gravity = 80;
        r4.setLayoutParams(r7);
        goto L15
    L11:
        r6 = null;
    L15:
        f r8 = (f) this.a.A.getValue();
        FragmentActivity r9 = this.a.getContext();
        CreationFeedComponent r10 = this.a;
        FrameLayout r11 = r10.z;
        zp9.f r12 = r10.x;
        if (r12 == null) goto L21;
        zp9.g r14 = r12.e;
        if (r14 == null) goto L21;
        String r15 = r14.a;
        if (r15 == null) goto L21;
    L22:
        if (r12 == null) goto L27;
        zp9.g r16 = r12.e;
        if (r16 == null) goto L27;
        String r17 = r16.b;
        if (r17 == null) goto L27;
    L28:
        LifecycleCoroutineScope r18 = LifecycleOwnerKt.getLifecycleScope(r10);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r90, "userCreation");
        Intrinsics.checkNotNullParameter(r15, "currentPage");
        Intrinsics.checkNotNullParameter(r17, "clickFrom");
        Intrinsics.checkNotNullParameter(r18, "scope");
        if (r9 == null) goto L312;
        int r1 = r90.b;
        if (r1 == 1) goto L276;
        switch(r1) {
            case 6: goto L39;
            case 7: goto L39;
            case 8: goto L39;
            case 9: goto L39;
            case 10: goto L39;
            case 11: goto L39;
            case 12: goto L39;
            default: goto L34;
        };
    L34:
        z2 r20 = z2.a;
        v1 r21 = r20.getCreationShareSettings().a();
        if (r21 != null) goto L37;
    L69:
        boolean r22 = false;
    L71:
        if (r22 == false) goto L204;
        v1 r23 = r20.getCreationShareSettings().a();
        if (r23 != null) goto L75;
    L77:
        boolean r24 = false;
    L79:
        if (r24 == true) goto L81;
        int r25 = r90.b;
        if (r25 == 3) goto L87;
        if (r25 == 2) goto L87;
    L86:
        boolean r26 = true;
    L88:
        if (r26 == false) goto L204;
        if ((r9 instanceof FragmentActivity) == false) goto L204;
        int r27 = r90.b;
        if (r27 == 2) goto L102;
        if (r27 != 4) goto L95;
        UserCreationContent r28 = r90.e;
        if (r28 == null) goto L107;
        AiBeautifyUserContent r30 = r28.d;
        if (r30 == null) goto L107;
        ImageInfo r31 = r30.a;
    L108:
        String r110 = r90.a;
        String r111 = zp9.d.d(r90);
        String r112 = zp9.d.b(r90);
        AuthorInfo r32 = r90.g;
        if (r32 == null) goto L111;
        String r113 = r32.b;
    L112:
        UserCreationTrackParams r33 = r90.n;
        if (r33 == null) goto L115;
        Integer r114 = r33.c;
    L116:
        if (r33 == null) goto L118;
        Integer r210 = r33.b;
    L119:
        if (r33 == null) goto L121;
        String r211 = r33.a;
    L122:
        if (r33 == null) goto L124;
        String r212 = r33.g;
    L125:
        if (r33 == null) goto L127;
        String r213 = r33.d;
    L128:
        if (r33 == null) goto L130;
        String r214 = r33.e;
    L131:
        if (r33 == null) goto L133;
        String r215 = r33.f;
    L134:
        u3.e(r110, r111, r112, r113, null, r114, r210, "click_download", r211, "personal_homepage_portfolio", r213, r215, r214, r212, null, null, null, null, null, null, null, null, null, 33538064);
        int r34 = r90.b;
        if (r34 != 3) goto L137;
        boolean r216 = true;
    L138:
        Integer r217 = Integer.valueOf(r34);
        String r35 = r90.a;
        String r218 = zp9.d.d(r90);
        String r219 = zp9.d.b(r90);
        UserCreationTrackParams r36 = r90.n;
        if (r36 == null) goto L141;
        String r220 = r36.a;
    L142:
        Long r37 = r90.f;
        if (r37 == null) goto L145;
        Integer r38 = Integer.valueOf((int) r37.longValue());
    L146:
        UserCreationTrackParams r40 = r90.n;
        if (r40 == null) goto L149;
        Integer r310 = r40.b;
    L150:
        AuthorInfo r41 = r90.g;
        if (r41 == null) goto L153;
        String r311 = r41.b;
    L154:
        com.larus.bmhome.share.panel.h r42 = new com.larus.bmhome.share.panel.h(null, null, null, null, null, null, null, null, null, r216, r217, r35, r218, r219, r220, null, null, null, Boolean.FALSE, null, null, null, r310, r38, r311, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r90.a, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -118618113, -4097, 1023);
        if (r31 == null) goto L308;
        FragmentManager r43 = r9.getSupportFragmentManager();
        ICommunityService.Companion r44 = ICommunityService.a;
        Intrinsics.checkNotNull(r43);
        Image r45 = r31.c;
        if (r45 == null) goto L159;
        String r46 = r45.a;
    L160:
        String r47 = String.valueOf(r46);
        Image r48 = r31.a;
        if (r48 == null) goto L163;
        String r50 = r48.a;
    L164:
        String r410 = String.valueOf(r50);
        Image r51 = r31.i;
        if (r51 == null) goto L167;
        String r411 = r51.a;
    L168:
        AuthorInfo r52 = r90.g;
        if (r52 == null) goto L171;
        String r53 = r52.b;
    L173:
        if (Intrinsics.areEqual(r53, AccountService.a.getUserId()) == false) goto L189;
        UserCreationRefContent r54 = r90.o;
        if (r54 == null) goto L177;
        boolean r55 = Intrinsics.areEqual(r54.b, Boolean.TRUE);
    L178:
        if (r55 == true) goto L189;
        UserCreationRefContent r56 = r90.o;
        if (r56 == null) goto L189;
        List r57 = r56.a();
        if (r57 == null) goto L189;
        ImageInfo r58 = (ImageInfo) ListProtector.get(r57, 0);
        if (r58 == null) goto L189;
        Image r60 = r58.c;
        if (r60 == null) goto L189;
        String r412 = r60.a;
    L190:
        ShareScene r413 = ShareScene.IMAGE_VIEWER_REPORT;
        Image r61 = r31.a;
        long r62 = -1;
        if (r61 == null) goto L193;
        long r115 = r61.c;
    L196:
        long r414 = r115;
    L198:
        if (r61 == null) goto L200;
        r62 = r61.d;
    L203:
        r44.Z0(r43, new sq9.j(null, r47, r410, r411, r412, null, r42, r413, r414, r62, new sq9.i("download", null, r90.a, 2), IUgcAIGCService.a.H(r90, null), 0, null, null, null, null, 127009));
        Unit r63 = Unit.INSTANCE;
        return;
    L200:
        Image r64 = r31.c;
        if (r64 == null) goto L203;
        r62 = r64.d;
        goto L203
    L193:
        Image r116 = r31.c;
        if (r116 == null) goto L197;
        r115 = r116.c;
        goto L196
    L197:
        r414 = -1;
        goto L198
    L177:
        r55 = false;
    L189:
        r412 = null;
        goto L190
    L171:
        r53 = null;
        goto L173
    L167:
        r411 = null;
        goto L168
    L163:
        r50 = null;
        goto L164
    L159:
        r46 = null;
        goto L160
    L308:
        return;
    L153:
        r311 = null;
        goto L154
    L149:
        r310 = null;
        goto L150
    L145:
        r38 = null;
        goto L146
    L141:
        r220 = null;
        goto L142
    L137:
        r216 = false;
        goto L138
    L133:
        r215 = null;
        goto L134
    L130:
        r214 = null;
        goto L131
    L127:
        r213 = null;
        goto L128
    L124:
        r212 = null;
        goto L125
    L121:
        r211 = null;
        goto L122
    L118:
        r210 = null;
        goto L119
    L115:
        r114 = null;
        goto L116
    L111:
        r113 = null;
    L107:
        r31 = null;
        goto L108
    L95:
        if (r27 == 5) goto L102;
        FLogger.a.i("CreationDownLoadHelper", "doShareAction: " + Integer.valueOf(r90.b));
    L102:
        UserCreationContent r65 = r90.e;
        if (r65 == null) goto L107;
        UserCreationImage r66 = r65.a;
        if (r66 == null) goto L107;
        r31 = r66.a;
    L87:
        r26 = false;
        goto L88
    L81:
        if (r90.b == 3) goto L87;
    L75:
        if (r23.f() != true) goto L77;
        r24 = true;
    L204:
        String r117 = r90.a;
        String r118 = zp9.d.d(r90);
        String r119 = zp9.d.b(r90);
        AuthorInfo r67 = r90.g;
        if (r67 == null) goto L207;
        String r120 = r67.b;
    L208:
        UserCreationTrackParams r68 = r90.n;
        if (r68 == null) goto L211;
        Integer r121 = r68.c;
    L212:
        if (r68 == null) goto L214;
        Integer r122 = r68.b;
    L215:
        if (r68 == null) goto L217;
        String r221 = r68.a;
    L218:
        if (r68 == null) goto L220;
        String r222 = r68.g;
    L221:
        if (r68 == null) goto L223;
        String r223 = r68.d;
    L224:
        if (r68 == null) goto L226;
        String r224 = r68.e;
    L227:
        if (r68 == null) goto L229;
        String r225 = r68.f;
    L230:
        u3.d(r117, r118, r119, r120, r121, r122, "click_download", r221, "personal_homepage_portfolio", r223, r225, r224, r222);
        int r70 = r90.b;
        if (r70 == 3) goto L251;
        if (r70 == 4) goto L242;
        UserCreationContent r71 = r90.e;
        if (r71 == null) goto L261;
        UserCreationImage r72 = r71.a;
        if (r72 == null) goto L261;
        ImageInfo r73 = r72.a;
        if (r73 == null) goto L261;
        Image r74 = r73.a;
        if (r74 == null) goto L261;
        String r75 = r74.a;
    L260:
        final String r76 = r75;
    L262:
        if (r76 != null) goto L265;
        return;
    L265:
        if (Build.VERSION.SDK_INT <= 29) goto L267;
    L274:
        ImageDownloadLoadingMgr r77 = ImageDownloadLoadingMgr.a;
        ImageDownloadLoadingMgr.c(r76, IUgcAIGCService.a.H(r90, null), new d(r90), true, null, 36);
    L275:
        Unit r78 = Unit.INSTANCE;
        return;
    L267:
        if (ContextCompat.checkSelfPermission(r9, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L274;
        if ((r9 instanceof FragmentActivity) == false) goto L271;
        r13 = r9;
    L271:
        if (r13 == null) goto L314;
        i2.b.a(r13, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), new c(r76, r90));
        goto L275
    L314:
        return;
    L261:
        r76 = null;
        goto L262
    L242:
        UserCreationContent r80 = r90.e;
        if (r80 == null) goto L261;
        AiBeautifyUserContent r81 = r80.d;
        if (r81 == null) goto L261;
        ImageInfo r82 = r81.a;
        if (r82 == null) goto L261;
        Image r83 = r82.a;
        if (r83 == null) goto L261;
        r75 = r83.a;
        goto L260
    L251:
        UserCreationContent r84 = r90.e;
        if (r84 == null) goto L261;
        UserCreationUserAvatar r85 = r84.c;
        if (r85 == null) goto L261;
        ImageInfo r86 = r85.a;
        if (r86 == null) goto L261;
        Image r87 = r86.a;
        if (r87 == null) goto L261;
        r75 = r87.a;
        goto L260
    L229:
        r225 = null;
        goto L230
    L226:
        r224 = null;
        goto L227
    L223:
        r223 = null;
        goto L224
    L220:
        r222 = null;
        goto L221
    L217:
        r221 = null;
        goto L218
    L214:
        r122 = null;
        goto L215
    L211:
        r121 = null;
        goto L212
    L207:
        r120 = null;
        goto L208
    L37:
        if (r21.b() != true) goto L69;
        r22 = true;
        goto L71
    L39:
        UserCreationContent r88 = r90.e;
        if (r88 == null) goto L305;
        VideoUserContent r91 = r88.e;
        if (r91 == null) goto L306;
        IUgcAIGCService.a.c(IUgcAIGCService.a, r9, UUID.randomUUID().toString(), os8.c.d(r91), r18, null, z2.a.Q3(), r90, new b(r90), null, 1616);
        String r123 = r90.a;
        String r124 = zp9.d.d(r90);
        String r125 = zp9.d.b(r90);
        AuthorInfo r92 = r90.g;
        if (r92 == null) goto L46;
        String r126 = r92.b;
    L47:
        UserCreationTrackParams r93 = r90.n;
        if (r93 == null) goto L50;
        Integer r127 = r93.c;
    L51:
        if (r93 == null) goto L53;
        Integer r226 = r93.b;
    L54:
        if (r93 == null) goto L56;
        String r227 = r93.a;
    L57:
        if (r93 == null) goto L59;
        String r228 = r93.g;
    L60:
        if (r93 == null) goto L62;
        String r229 = r93.d;
    L63:
        if (r93 == null) goto L65;
        String r230 = r93.e;
    L66:
        if (r93 == null) goto L68;
        r13 = r93.f;
    L68:
        u3.d(r123, r124, r125, r126, r127, r226, "click_download", r227, "personal_homepage_portfolio", r229, r13, r230, r228);
        Unit r94 = Unit.INSTANCE;
        return;
    L65:
        r230 = null;
        goto L66
    L62:
        r229 = null;
        goto L63
    L59:
        r228 = null;
        goto L60
    L56:
        r227 = null;
        goto L57
    L53:
        r226 = null;
        goto L54
    L50:
        r127 = null;
        goto L51
    L46:
        r126 = null;
        goto L47
    L306:
        return;
    L305:
        return;
    L276:
        if (r11 != null) goto L278;
        FLogger.a.i("CreationDownLoadHelper", "downloadSource: viewParent is null");
        return;
    L278:
        IAIChatUgcAIGCService.a.c0(r9, r11, UUID.randomUUID().toString(), r90, r15, r17, r18, true, new a());
        String r128 = r90.a;
        String r129 = zp9.d.d(r90);
        String r130 = zp9.d.b(r90);
        AuthorInfo r95 = r90.g;
        if (r95 == null) goto L281;
        String r131 = r95.b;
    L282:
        UserCreationTrackParams r96 = r90.n;
        if (r96 == null) goto L285;
        Integer r132 = r96.c;
    L286:
        if (r96 == null) goto L288;
        Integer r133 = r96.b;
    L289:
        if (r96 == null) goto L291;
        String r231 = r96.a;
    L292:
        if (r96 == null) goto L294;
        String r232 = r96.g;
    L295:
        if (r96 == null) goto L297;
        String r233 = r96.d;
    L298:
        if (r96 == null) goto L300;
        String r234 = r96.e;
    L301:
        if (r96 == null) goto L303;
        r13 = r96.f;
    L303:
        u3.d(r128, r129, r130, r131, r132, r133, "click_download", r231, "personal_homepage_portfolio", r233, r13, r234, r232);
        Unit r97 = Unit.INSTANCE;
        return;
    L300:
        r234 = null;
        goto L301
    L297:
        r233 = null;
        goto L298
    L294:
        r232 = null;
        goto L295
    L291:
        r231 = null;
        goto L292
    L288:
        r133 = null;
        goto L289
    L285:
        r132 = null;
        goto L286
    L281:
        r131 = null;
        goto L282
    L312:
        return;
    L27:
        r17 = "create_feed";
    L21:
        r15 = "";
        goto L22
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.community.impl.component.c0] */
    @Override // g29.i
    public final void d(final int r12) {
        if (z2.a.m() == true) goto L5;
        return;
    L5:
        CreationListAdapter r0 = this.a.s;
        String r1 = null;
        if (r0 == null) goto L14;
        List<UserCreationModel> r2 = r0.b;
        if (r2 == null) goto L14;
        UserCreationModel r3 = (UserCreationModel) CollectionsKt.getOrNull(r2, r12);
        if (r3 == null) goto L14;
        List r4 = r3.b();
        if (r4 == null) goto L14;
        final UserCreation r5 = (UserCreation) CollectionsKt.firstOrNull(r4);
    L15:
        if (r5 != null) goto L18;
        m29.a.b("CreationFeedComponent", "userCreation is null");
        return;
    L18:
        final CreationFeedComponent r6 = this.a;
        final ?? r7 = new c0(r6, r5, r12);
        r6.getClass();
        if (r5.a() == false) goto L53;
        zp9.e r13 = r6.y;
        if (r13 == null) goto L27;
        zp9.m r14 = r13.b;
        if (r14 == null) goto L27;
        if (r14.e() == true) goto L27;
        boolean r15 = true;
    L28:
        if (r15 == true) goto L53;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        FragmentActivity r16 = com.larus.ui.arch.component.internal.attach.a.b(r6, r6).getActivity();
        if (r16 == null) goto L53;
        Lazy r8 = com.larus.community.impl.quickmenu.doSame.e.a;
        JSONObject r9 = new JSONObject();
        zp9.f r10 = r6.x;
        if (r10 == null) goto L36;
        zp9.g r11 = r10.e;
        if (r11 == null) goto L36;
        String r17 = r11.b;
    L37:
        r9.putOpt("recommend_from", r17);
        r9.putOpt("show_from", "template_list");
        Unit r18 = Unit.INSTANCE;
        com.larus.community.impl.quickmenu.doSame.e.b(r16, r5, r9, new s(r7));
        zp9.f r110 = r6.x;
        if (r110 == null) goto L42;
        zp9.g r111 = r110.e;
        if (r111 == null) goto L42;
        String r20 = r111.b;
    L43:
        Boolean r21 = Boolean.valueOf(r5.D());
        UserCreationRefContent r112 = r5.o;
        if (r112 == null) goto L48;
        List r113 = r112.a();
        if (r113 == null) goto L48;
        Integer r22 = Integer.valueOf(r113.size());
    L49:
        AuthorInfo r114 = r5.g;
        if (r114 == null) goto L52;
        r1 = r114.b;
    L52:
        u3.o(r20, r21, r22, r1, r5.a, "template_list", zp9.d.c(r5), zp9.d.d(r5), zp9.d.e(r5));
        return;
    L48:
        r22 = null;
    L42:
        r20 = null;
    L36:
        r17 = null;
    L27:
        r15 = false;
    L53:
        r7.invoke(null);
        return;
    L14:
        r5 = null;
        goto L15
    }

    @Override // g29.i
    public final void f(int r3) {
        CreationFeedComponent.Y2(this.a, r3, "click_profile");
    }

    @Override // g29.i
    public final void g(View r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "longClickView");
        CreationListAdapter r0 = this.a.s;
        if (r0 == null) goto L46;
        List<UserCreationModel> r1 = r0.b;
        if (r1 == null) goto L54;
        UserCreationModel r2 = (UserCreationModel) CollectionsKt.getOrNull(r1, r9);
        if (r2 == null) goto L55;
        CreationFeedComponent r3 = this.a;
        zp9.e r4 = r3.y;
        if (r4 == null) goto L13;
        zp9.m r5 = r4.b;
        if (r5 == null) goto L13;
        r5.f(r2, r9);
        Boolean r6 = Boolean.FALSE;
    L15:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == true) goto L56;
        u1 r7 = r3.q;
        if (r7 != null) goto L19;
        return;
    L19:
        monitor-enter(r7);
        Intrinsics.checkNotNullParameter(r8, "longClickView");     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r2, "userCreationModel");     // Catch: Throwable -> L43
        View r10 = r7.b;     // Catch: Throwable -> L43
        if (r10 == null) goto L29;
        com.larus.bmhome.view.screenmenu.d r11 = com.larus.bmhome.view.screenmenu.d.a;     // Catch: Throwable -> L43
        if (com.larus.bmhome.view.screenmenu.d.d(r10) == null) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L29;
        monitor-exit(r7);
        return;
    L25:
        r12 = false;
    L29:
        r7.b = r8;     // Catch: Throwable -> L43
        FLogger.a.i("OpenLongClickMenuDialogHelper", "openMenuDialog " + r9);     // Catch: Throwable -> L43
        zp9.s r13 = r7.a.c;     // Catch: Throwable -> L43
        if (r13 == null) goto L39;
        List r14 = r13.a(r2);     // Catch: Throwable -> L43
        if (r14 == null) goto L39;
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L43
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L43
    L35:
        if (r16.hasNext() == false) goto L40;
        Object r17 = r16.next();     // Catch: Throwable -> L43
        if ((r17 instanceof com.larus.bmhome.view.screenmenu.l0) == false) goto L35;
        r15.add(r17);     // Catch: Throwable -> L43
    L40:
        r7.a(r2, r15, r8, null);     // Catch: Throwable -> L43
        monitor-exit(r7);
        return;
    L39:
        r15 = new ArrayList();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L56:
        return;
    L13:
        r6 = null;
        goto L15
    L55:
        return;
    L54:
        return;
    }
}
