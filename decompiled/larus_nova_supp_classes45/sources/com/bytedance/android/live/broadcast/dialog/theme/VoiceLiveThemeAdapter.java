package com.bytedance.android.live.broadcast.dialog.theme;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeDownloadManager;
import com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.c;
import com.bytedance.android.live.liveinteract.bgComponent.theme.i;
import com.bytedance.android.live.liveinteract.bgComponent.theme.j;
import com.bytedance.android.live.liveinteract.utils.l0;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.ui.o;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.ul0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.ntp.e;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IAnimatedBgInfo;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcast/dialog/theme/VoiceLiveThemeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceLiveThemeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<IVoiceLiveTheme> a;
    public int b;
    public boolean c;
    public final Context d;
    public final j e;
    public final com.bytedance.android.live.broadcast.dialog.theme.a f;
    public int g;
    public final String h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VoiceLiveThemeAdapter a;
        public final /* synthetic */ RecyclerView.ViewHolder b;
        public final /* synthetic */ int c;

        public a(VoiceLiveThemeAdapter r1, RecyclerView.ViewHolder r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r18) {
            VoiceLiveThemeAdapter r1 = this.a;
            List r2 = CollectionsKt.toList(r1.a);
            LiveThemeViewHolder r3 = (LiveThemeViewHolder) this.b;
            int r4 = this.c;
            Intrinsics.checkNotNullParameter(r3, "holder");
            if (r2 == null) goto L79;
            if (r4 >= 0) goto L6;
            return;
        L6:
            if (r4 >= r2.size()) goto L90;
            IVoiceLiveTheme r5 = (IVoiceLiveTheme) ListProtector.get(r2, r4);
            Iterator r6 = r2.iterator();
            int r7 = 0;
            boolean r8 = false;
        L10:
            if (r6.hasNext() == false) goto L19;
            Object r9 = r6.next();
            int r11 = r7 + 1;
            if (r7 >= 0) goto L15;
            CollectionsKt.throwIndexOverflow();
        L15:
            if (IVoiceLiveThemeKt.isConfig((IVoiceLiveTheme) r9) == false) goto L17;
            r8 = true;
        L17:
            r7 = r11;
            goto L10
        L19:
            if (r5.getImageType() != (-1)) goto L23;
            com.bytedance.android.live.broadcast.dialog.theme.a r12 = r1.f;
            if (r12 == null) goto L81;
            r12.s0();
            return;
        L81:
            return;
        L23:
            String r13 = null;
            if (r8 == true) goto L26;
        L33:
            int r14 = i.a;
            String r15 = r1.h;
            Intrinsics.checkNotNullParameter(r5, FileUtils.PICTURE_THEME);
            LinkedHashMap r16 = new LinkedHashMap();
            r16.put("anchor_id", k.n(IMiddlewareUserService.class).user().n());
            r16.put("pic_uri", r5.getImageUri());
            r16.put("template_id", String.valueOf(r5.getId()));
            r16.put("play_mode", w.a());
            c.c(r16);
            l0.a.getClass();
            l0.d(r16);
            int r17 = r5.getFormatType();
            String r19 = "";
            if (r17 == 1) goto L38;
            if (r17 == 2) goto L37;
            String r21 = "";
        L39:
            r16.put("pic_type", r21);
            String r22 = k.n(IInteractService.class).getFunctionType2();
            if (r22 == null) goto L43;
            r19 = r22;
        L43:
            r16.put("function_type2", r19);
            r16.put("template_id", String.valueOf(r5.getId()));
            m r23 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            if (r23 == null) goto L47;
            r13 = (IRoom) r23.getValue();
        L47:
            if (r13 == null) goto L49;
            r16.put("event_page", "live_take_detail");
            j0.l().sendLog("livesdk_anchor_theme_click", r16, new Object[]{IRoom.class});
        L59:
            if (r1.b != r4) goto L63;
            com.bytedance.android.live.broadcast.dialog.theme.a r24 = r1.f;
            if (r24 == null) goto L85;
            r24.onError(4);
            return;
        L85:
            return;
        L63:
            long r25 = e.a() / ((long) 1000);
            long r110 = r5.getStartTime();
            long r111 = r5.getEndTime();
            if (r111 != 0) goto L66;
        L72:
            r1.b = r3.getAdapterPosition();
            com.bytedance.android.live.broadcast.dialog.theme.a r26 = r1.f;
            if (r26 == null) goto L89;
            r26.p0(r5);
            return;
        L89:
            return;
        L66:
            if (r110 <= r25) goto L68;
        L69:
            f2.c("当前主题已过期", 0);
            com.bytedance.android.live.broadcast.dialog.theme.a r27 = r1.f;
            if (r27 == null) goto L87;
            r27.onError(1);
            return;
        L87:
            return;
        L68:
            if (r111 > r25) goto L72;
        L49:
            int r28 = r5.getBgType();
            if (r28 == 3) goto L53;
            if (r28 == 4) goto L53;
            String r29 = "voice_live";
        L54:
            r16.put("live_type", r29);
            if (r15 != null) goto L57;
            r15 = "live_take_page";
        L57:
            r16.put("event_page", r15);
            j0.l().sendLog("livesdk_anchor_theme_click", r16, new Object[0]);
        L53:
            r29 = "video_live";
            goto L54
        L37:
            r21 = "dynamic";
            goto L39
        L38:
            r21 = "static";
            goto L39
        L26:
            if (IVoiceLiveThemeKt.isConfig(r5) == true) goto L33;
            Resources r31 = r1.d.getResources();
            if (r31 == null) goto L30;
            r13 = r31.getString(2131922874);
        L30:
            f2.c(r13, 0);
            com.bytedance.android.live.broadcast.dialog.theme.a r32 = r1.f;
            if (r32 == null) goto L83;
            r32.onError(2);
            return;
        L83:
            return;
        L90:
            return;
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public static IVoiceLiveTheme y2(ArrayList r3) {
        Intrinsics.checkNotNullParameter(r3, "themeList");
        Object r1 = null;
        if (r3.size() > 0) goto L5;
        return null;
    L5:
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        Object r0 = r4.next();
        if (((IVoiceLiveTheme) r0).getPlayMode() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L7;
        r1 = r0;
        goto L15
    L11:
        r2 = false;
    L15:
        return (IVoiceLiveTheme) r1;
    }

    public final int getItemViewType(int r1) {
        return this.g;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        if ((r11 instanceof LiveThemeViewHolder) == false) goto L171;
        final IVoiceLiveTheme r0 = (IVoiceLiveTheme) ListProtector.get(this.a, r12);
        LiveThemeViewHolder r1 = (LiveThemeViewHolder) r11;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "liveTheme");
        r1.k = r0;
        boolean r4 = false;
        String r5 = "";
        if (TextUtils.isEmpty(r0.getThemeTag()) == true) goto L7;
        r1.e.setVisibility(0);
        r1.f.setText(r0.getThemeTag());
    L8:
        IVoiceLiveTheme r2 = r1.k;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L12:
        if (r2.getThemeLabel() == null) goto L25;
        IVoiceLiveTheme r3 = r1.k;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L16:
        String r6 = r3.getThemeLabel();
        Intrinsics.checkNotNull(r6);
        if (r6.length() <= 0) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == false) goto L25;
        TextView r8 = r1.g;
        IVoiceLiveTheme r9 = r1.k;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L24:
        String r13 = r9.getThemeLabel();
        Intrinsics.checkNotNull(r13);
        r8.setText(r13);
    L35:
        TextView r14 = (TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131388548);
        IVoiceLiveTheme r15 = r1.k;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L39:
        if (r15.getBgStatus() != 1) goto L41;
        int r16 = 0;
    L42:
        r14.setVisibility(r16);
        UtilityKotlinExtentionsKt.t(r1.i);
        r1.j.setVisibility(8);
        r1.h.c();
        r1.h.hide();
        String r17 = null;
        if (r0.isUgcImage() == false) goto L136;
        IVoiceLiveTheme r18 = r1.k;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L48:
        if (r18.getAnimatedBgInfo() == null) goto L98;
        r1.a.setVisibility(8);
        r1.h.show();
        o r19 = r1.h;
        IVoiceLiveTheme r21 = r1.k;
        if (r21 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L52:
        IAnimatedBgInfo r22 = r21.getAnimatedBgInfo();
        if (r22 == null) goto L55;
        IThemeShowArea r23 = r22.getThemeShowArea();
    L56:
        r19.setShowArea(r23);
        IVoiceLiveTheme r24 = r1.k;
        if (r24 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L60:
        if (IVoiceLiveThemeKt.isLocalUgcTheme(r24) == false) goto L65;
        IVoiceLiveTheme r25 = r1.k;
        if (r25 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L64:
        String r26 = r25.getLocalPath();
    L76:
        IVoiceLiveTheme r27 = r1.k;
        if (r27 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L80:
        if (IVoiceLiveThemeKt.isLocalUgcTheme(r27) == true) goto L93;
        IVoiceLiveTheme r28 = r1.k;
        if (r28 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L85:
        IAnimatedBgInfo r29 = r28.getAnimatedBgInfo();
        if (r29 == null) goto L93;
        py.k r31 = r29.getAnimatedBg();
        if (r31 == null) goto L93;
        String r32 = r31.getUri();
        if (r32 == null) goto L93;
        r5 = r32;
    L93:
        if (r26 == null) goto L134;
        Lazy r33 = VideoThemeDownloadManager.a;
        Intrinsics.checkNotNullParameter(r5, "id");
        if (VideoThemeDownloadManager.b.containsKey(r5) == false) goto L97;
        r1.j.setVisibility(0);
        VideoThemeDownloadManager.f(r5, r1.l);
        goto L134
    L97:
        ALogger.d("VideoThemeView", "bind: 开始播放");
        r1.h.d(r26, r5, null);
    L134:
        UtilityKotlinExtentionsKt.w(r1.d);
    L164:
        if (r12 != this.b) goto L166;
        r1.g.setTextColor(ColorProtector.parseColor("#FACE15"));
        UtilityKotlinExtentionsKt.w(r1.c);
    L167:
        r11.itemView.setOnClickListener(new a(this, r11, r12));
        if (r0.isUgcImage() == false) goto L172;
        ((LiveThemeViewHolder) r11).d.setOnClickListener(x0.a(new AnonymousClass2(this, r0)));
        return;
    L172:
        return;
    L166:
        r1.g.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        UtilityKotlinExtentionsKt.u(r1.c);
        goto L167
    L65:
        IVoiceLiveTheme r34 = r1.k;
        if (r34 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L68:
        IAnimatedBgInfo r35 = r34.getAnimatedBgInfo();
        if (r35 == null) goto L75;
        py.k r36 = r35.getAnimatedBg();
        if (r36 == null) goto L75;
        List<String> r37 = r36.getUrls();
        if (r37 == null) goto L75;
        r26 = (String) ListProtector.get(r37, 0);
    L75:
        r26 = null;
        goto L76
    L55:
        r23 = null;
        goto L56
    L98:
        UtilityKotlinExtentionsKt.w(r1.a);
        IVoiceLiveTheme r38 = r1.k;
        if (r38 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L101:
        String r39 = r38.getLocalPath();
        if (r39 != null) goto L104;
    L105:
        r4 = true;
    L106:
        if (r4 == true) goto L116;
        IVoiceLiveTheme r41 = r1.k;
        if (r41 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L111:
        if (r41.getThumbnailBackground() != null) goto L116;
        HSImageView r42 = r1.a;
        IVoiceLiveTheme r43 = r1.k;
        if (r43 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L115:
        ImageLoader.loadSdcardImage(r42, r43.getLocalPath());
    L116:
        IVoiceLiveTheme r44 = r1.k;
        if (r44 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L120:
        if (r44.getThumbnailBackground() == null) goto L125;
        HSImageView r45 = r1.a;
        IVoiceLiveTheme r46 = r1.k;
        if (r46 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L124:
        ImageLoader.bindImage(r45, r46.getThumbnailBackground());
        goto L134
    L125:
        IVoiceLiveTheme r47 = r1.k;
        if (r47 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L129:
        if (r47.getStaticBackground() == null) goto L134;
        HSImageView r48 = r1.a;
        IVoiceLiveTheme r49 = r1.k;
        if (r49 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L133:
        ImageLoader.bindImage(r48, r49.getStaticBackground());
        goto L134
    L104:
        if (r39.length() != 0) goto L106;
    L136:
        if (r0.getImageType() != (-1)) goto L138;
        UtilityKotlinExtentionsKt.w(r1.i);
        UtilityKotlinExtentionsKt.t(r1.a);
        UtilityKotlinExtentionsKt.t(r1.d);
        goto L164
    L138:
        UtilityKotlinExtentionsKt.w(r1.a);
        IVoiceLiveTheme r51 = r1.k;
        if (r51 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L141:
        py.k r52 = r51.getThumbnailBackground();
        if (r52 == null) goto L144;
        List<String> r53 = r52.getUrls();
    L145:
        List<String> r54 = r53;
        if (r54 != null) goto L148;
    L151:
        boolean r55 = true;
    L152:
        if (r55 == true) goto L162;
        HSImageView r56 = r1.a;
        PipelineDraweeControllerBuilder r57 = Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true);
        IVoiceLiveTheme r58 = r1.k;
        if (r58 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L156:
        py.k r59 = r58.getThumbnailBackground();
        if (r59 == null) goto L161;
        List<String> r61 = r59.getUrls();
        if (r61 == null) goto L161;
        r17 = (String) ListProtector.get(r61, 0);
    L161:
        r56.setController(r57.setUri(UriProtector.parse(r17)).build());
    L162:
        UtilityKotlinExtentionsKt.t(r1.d);
        goto L164
    L148:
        if (r54.isEmpty() == true) goto L151;
        r55 = false;
        goto L152
    L144:
        r53 = null;
        goto L145
    L41:
        r16 = 8;
        goto L42
    L19:
        r7 = false;
    L25:
        IVoiceLiveTheme r62 = r1.k;
        if (r62 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException(FileUtils.PICTURE_THEME);
    L29:
        if (r62.isUgcImage() == false) goto L34;
        r1.g.setText(((RecyclerView.ViewHolder) r1).itemView.getContext().getResources().getString(2131918824));
        if (((Boolean) ul0.a.getValue()).booleanValue() == false) goto L33;
        r1.b.setVisibility(0);
        goto L35
    L33:
        r1.b.setVisibility(8);
        goto L35
    L34:
        r1.g.setText(((RecyclerView.ViewHolder) r1).itemView.getContext().getResources().getString(2131922875));
        r1.b.setVisibility(8);
        goto L35
    L7:
        r1.e.setVisibility(8);
        r1.f.setText("");
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new LiveThemeViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131566441, r3, false));
    }

    public VoiceLiveThemeAdapter(Context r2, j r3, com.bytedance.android.live.broadcast.dialog.theme.a r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "themeManager");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        ArrayList r7 = new ArrayList();
        this.a = r7;
        r7.clear();
        IVoiceLiveTheme r8 = y2(r3.v(this.g));
        if (r8 == null) goto L6;
        r8.getPlayMode();
        return;
    }
}
