package com.larus.photopicker.v2.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.photopicker.impl.ui.PhotoPickerFragment;
import com.larus.photopicker.v2.api.IInnerPhotoPickerService;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaNonUISettings;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.MediaEntry;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u00020\u0016*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0017"}, d2 = {"Lcom/larus/photopicker/v2/impl/InnerInnerPhotoPickerServiceImpl;", "Lcom/larus/photopicker/v2/api/IInnerPhotoPickerService;", "<init>", "()V", "getPhotoPickActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "getAddPartImageManager", "Lcom/larus/photopicker/v2/api/IAddPartImageManager;", "goPhotoPickerSettingPermissionActivity", "", "fragment", "Landroidx/fragment/app/Fragment;", "getAlbumFastInputConfig", "Lcom/larus/photopicker/v2/api/IAlbumFastInputConfig;", "loadFrameStart", "getBottomPhotoPickerPage", "Lcom/larus/platform/api/IBottomPhotoPickerPage;", "pageConfig", "Lcom/larus/platform/model/BottomPhotoPickerPageConfig;", "applyPageConfig", "Lcom/larus/photopicker/v2/impl/BottomPhotoPickerFragmentV2;", "Lcom/larus/photopicker/v2/impl/BottomPhotoPickerFragmentV3;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class InnerInnerPhotoPickerServiceImpl implements IInnerPhotoPickerService {
    public InnerInnerPhotoPickerServiceImpl() {
    }

    @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
    public final void c() {
        pp9.i.a().c((pp9.i.c) pp9.i.d.getValue());
    }

    @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
    public final lp9.b b() {
        return wp9.d.a;
    }

    @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
    public final Class<? extends Activity> d() {
        return PhotoPickerActivityV2.class;
    }

    @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
    public final lp9.a e() {
        return kp9.b.a;
    }

    @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
    public final com.larus.platform.api.a0 f(hq9.b0 r15) {
        Intrinsics.checkNotNullParameter(r15, "pageConfig");
        AlbumSettingConfig r0 = r15.d;
        if (r0 == null) goto L5;
        int r1 = r0.getMaxSelectCount();
    L6:
        AlbumSettingConfig r2 = r15.d;
        if (r2 == null) goto L9;
        int r3 = r2.getSpanCount();
    L10:
        AlbumSettingConfig r4 = r15.d;
        boolean r5 = false;
        if (r4 == null) goto L13;
        boolean r6 = r4.getSupportVideo();
    L14:
        if (r6 == false) goto L16;
        List<? extends MediaTab> r7 = CollectionsKt.listOf(new MediaTab[]{MediaTab.ALL, MediaTab.VIDEO, MediaTab.IMAGE});
    L17:
        AlbumSettingConfig r8 = r15.d;
        if (r8 == null) goto L20;
        boolean r9 = r8.isMultiPick();
    L21:
        String r10 = null;
        if (r8 == null) goto L24;
        AlbumInputState r11 = r8.getInitialInputState();
    L25:
        dr9.g r12 = dr9.g.a;
        if (r11 == null) goto L28;
        String r13 = r11.getInputSnapshotId();
    L29:
        InputDraftSnapshot r14 = dr9.g.d(r13);
        if (r11 == null) goto L32;
        String r16 = r11.getInputSnapshotId();
    L33:
        if (r16 != null) goto L35;
    L38:
        boolean r17 = true;
    L39:
        if (r17 == true) goto L42;
        if (r14 != null) goto L42;
        boolean r18 = true;
    L43:
        if (r14 == null) goto L49;
        List<AttachmentSnapshot> r19 = r14.getAttachments();
        if (r19 == null) goto L49;
        if ((!r19.isEmpty()) != true) goto L49;
        boolean r110 = true;
    L50:
        if (r110 == true) goto L61;
        if (r11 == null) goto L57;
        List<String> r111 = r11.getAttachmentUris();
        if (r111 == null) goto L57;
        if ((!r111.isEmpty()) != true) goto L57;
        boolean r112 = true;
    L58:
        if (r112 == true) goto L61;
        boolean r113 = false;
    L63:
        if (uy8.b.c() == false) goto L71;
        if (r8 != null) goto L66;
    L68:
        boolean r114 = false;
    L69:
        if (r114 == false) goto L71;
        boolean r115 = true;
    L72:
        if (r115 == true) goto L75;
        if (r1 != 0) goto L80;
    L74:
        r1 = 1;
    L80:
        MediaGalleryUIConfig.a r116 = new MediaGalleryUIConfig.a();
        MediaPickerUIMode r117 = r15.l;
        Intrinsics.checkNotNullParameter(r117, "mode");
        r116.e = r117;
        Intrinsics.checkNotNullParameter(r7, "tabs");
        r116.a = r7;
        r116.b = r3;
        r116.c = !r9;
        r116.d = r1;
        r116.g = r6;
        r116.j = i5.b();
        AlbumSettingConfig r20 = r15.d;
        if (r20 != null) goto L83;
    L85:
        boolean r21 = false;
    L86:
        if (r21 == false) goto L89;
        if (r18 == true) goto L89;
        boolean r22 = true;
    L90:
        r116.p = r22;
        AlbumSettingConfig r23 = r15.d;
        if (r23 == null) goto L93;
        String r24 = r23.getSuggestedActionProvider();
    L94:
        r116.q = r24;
        if (r11 == null) goto L97;
        String r25 = r11.getText();
    L98:
        r116.r = r25;
        if (r11 == null) goto L104;
        String r26 = r11.getInputSnapshotId();
        if (r26 == null) goto L104;
        if (r18 == true) goto L104;
    L105:
        r116.s = r26;
        if (r11 == null) goto L108;
        String r27 = r11.getSourceNodeId();
    L109:
        String r28 = "";
        if (r27 != null) goto L112;
        r27 = "";
    L112:
        r116.t = r27;
        if (r11 == null) goto L115;
        List<String> r29 = r11.getAttachmentUris();
    L116:
        if (r29 != null) goto L118;
        r29 = CollectionsKt.emptyList();
    L118:
        Intrinsics.checkNotNullParameter(r29, "value");
        r116.u = r29;
        if (r8 == null) goto L121;
        String r30 = r8.getAlbumNodeId();
    L122:
        if (r30 != null) goto L124;
        r30 = "";
    L124:
        Intrinsics.checkNotNullParameter(r30, "value");
        r116.v = r30;
        if (r8 == null) goto L127;
        String r31 = r8.getUpstreamAlbumNodeId();
    L128:
        if (r31 == null) goto L131;
        r28 = r31;
    L131:
        Intrinsics.checkNotNullParameter(r28, "value");
        r116.w = r28;
        AlbumSettingConfig r32 = r15.d;
        if (r32 != null) goto L134;
    L136:
        boolean r33 = false;
    L137:
        if (r33 == false) goto L140;
        if (r18 == true) goto L140;
        boolean r34 = true;
    L141:
        r116.x = r34;
        if (r8 != null) goto L144;
    L146:
        boolean r35 = false;
    L147:
        if (r35 == false) goto L150;
        if (r18 == true) goto L150;
        boolean r36 = true;
    L151:
        r116.z = r36;
        AlbumSettingConfig r37 = r15.d;
        if (r37 == null) goto L154;
        MediaEntry r38 = r37.getUnifiedPreviewEntry();
    L155:
        r116.A = r38;
        if (r8 == null) goto L158;
        Boolean r39 = r8.getUseUnifiedMediaCanvas();
    L159:
        r116.y = r39;
        AlbumSettingConfig r40 = r15.d;
        if (r40 != null) goto L162;
    L164:
        boolean r41 = false;
    L165:
        r116.B = r41;
        if (r15.k == false) goto L168;
        int r42 = 0;
    L169:
        r116.D = r42;
        r116.h = r15.g;
        AlbumSettingConfig r43 = r15.d;
        if (r43 == null) goto L174;
        Integer r44 = r43.getStartNavigationBarColor();
        if (r44 == null) goto L174;
        int r45 = r44.intValue();
    L175:
        r116.i = r45;
        AlbumSettingConfig r46 = r15.d;
        if (r46 == null) goto L178;
        boolean r47 = r46.getSupportOriginalImage();
    L179:
        r116.E = r47;
        AlbumSettingConfig r48 = r15.d;
        if (r48 == null) goto L184;
        Integer r49 = r48.getLandingTabIndex();
        if (r49 == null) goto L184;
        int r50 = r49.intValue();
    L185:
        r116.F = r50;
        AlbumSettingConfig r51 = r15.d;
        if (r51 == null) goto L190;
        Long r52 = r51.getMaxVideoDuration();
        if (r52 == null) goto L190;
        long r53 = r52.longValue();
    L191:
        AlbumSettingConfig r54 = r15.d;
        if (r54 == null) goto L194;
        r10 = r54.getClickFrom();
    L194:
        MediaNonUISettings r55 = new MediaNonUISettings(r53, r10, 7);
        MediaPickerUIMode r56 = r15.l;
        MediaPickerUIMode r57 = MediaPickerUIMode.COLLAPSED_BOTTOM_SHEET;
        if (r56 != r57) goto L204;
        r116.l = Integer.valueOf(i5.r0());
        r116.m = Integer.valueOf(i5.b());
        r116.k = i5.h();
        if (com.larus.platform.service.e2.a.isPad() == false) goto L199;
        int r58 = i5.h();
    L200:
        r116.n = Integer.valueOf(r58);
        AlbumSettingConfig r59 = r15.d;
        if (r59 == null) goto L203;
        r5 = r59.getEnableMultiSelectConfirmed();
    L203:
        r116.o = r5;
        goto L204
    L199:
        r58 = 0;
    L204:
        MediaGalleryUIConfig r60 = r116.a();
        if (r15.p == true) goto L207;
    L217:
        int r61 = BottomPhotoPickerFragmentV2.C;
        BottomPhotoPickerFragmentV2 r62 = BottomPhotoPickerFragmentV2.a.a(r60, LazyLoadConfig.e, r55);
        WeakReference<Fragment> r63 = r15.a;
        if (r63 == null) goto L225;
        Fragment r64 = r63.get();
        if (r64 == null) goto L225;
        Bundle r65 = r62.getArguments();
        if (r65 != null) goto L224;
        r65 = new Bundle();
    L224:
        r65.putBoolean("quick_album_requires_live_input_owner", true);
        r62.setArguments(r65);
        r62.y = new op8.k(r64);
    L225:
        r62.d = r15.b;
        String r66 = r15.e;
        Intrinsics.checkNotNullParameter(r66, "<set-?>");
        r62.f = r66;
        r62.g = r15.f;
        r62.i = r15.i;
        r62.e = r15.c;
        r62.h = r15.h;
        r62.j = r15.j;
        r62.k = r15.m;
        r62.l = r15.q;
        com.larus.platform.api.a0 r67 = r62;
    L226:
        return r67;
    L207:
        if (r15.l != r57) goto L217;
        int r68 = BottomPhotoPickerFragmentV3.C;
        LazyLoadConfig r69 = LazyLoadConfig.e;
        Intrinsics.checkNotNullParameter(r60, "uiConfig");
        Intrinsics.checkNotNullParameter(r69, "lazyLoadConfig");
        Intrinsics.checkNotNullParameter(r55, "nonUiSettings");
        BottomPhotoPickerFragmentV3 r70 = new BottomPhotoPickerFragmentV3();
        Bundle r71 = new Bundle();
        r71.putParcelable("ui_config", r60);
        r71.putParcelable("lazy_load_config", r69);
        r71.putParcelable("non_ui_settings", r55);
        r70.setArguments(r71);
        WeakReference<Fragment> r72 = r15.a;
        if (r72 == null) goto L216;
        Fragment r73 = r72.get();
        if (r73 == null) goto L216;
        Bundle r74 = r70.getArguments();
        if (r74 != null) goto L215;
        r74 = new Bundle();
    L215:
        r74.putBoolean("quick_album_requires_live_input_owner", true);
        r70.setArguments(r74);
        r70.w = new op8.k(r73);
    L216:
        r70.d = r15.b;
        String r75 = r15.e;
        Intrinsics.checkNotNullParameter(r75, "<set-?>");
        r70.f = r75;
        r70.g = r15.f;
        r70.i = r15.i;
        r70.e = r15.c;
        r70.h = r15.h;
        r70.j = r15.j;
        r70.k = r15.m;
        r70.l = r15.q;
        r67 = r70;
    L190:
        r53 = 0;
    L184:
        r50 = 0;
        goto L185
    L178:
        r47 = false;
    L174:
        r45 = 0;
        goto L175
    L168:
        r42 = r15.g;
        goto L169
    L162:
        if (r40.getHideAlbumEntranceInInjectedInput() != true) goto L164;
        r41 = true;
        goto L165
    L158:
        r39 = null;
        goto L159
    L154:
        r38 = null;
    L150:
        r36 = false;
        goto L151
    L144:
        if (r8.getMobilePreviewHostEnabled() != true) goto L146;
        r35 = true;
    L140:
        r34 = false;
        goto L141
    L134:
        if (r32.getAllowUnifiedPreview() != true) goto L136;
        r33 = true;
        goto L137
    L127:
        r31 = null;
        goto L128
    L121:
        r30 = null;
        goto L122
    L115:
        r29 = null;
        goto L116
    L108:
        r27 = null;
    L104:
        r26 = null;
        goto L105
    L97:
        r25 = null;
        goto L98
    L93:
        r24 = null;
    L89:
        r22 = false;
        goto L90
    L83:
        if (r20.getEnableInjectInput() != true) goto L85;
        r21 = true;
        goto L86
    L75:
        if (r9 == true) goto L79;
        if (r113 == false) goto L79;
        if (r1 == 0) goto L74;
    L79:
        r1 = RangesKt.coerceAtLeast(r1, 0);
        goto L80
    L66:
        if (r8.getEnableInjectInput() != true) goto L68;
        r114 = true;
    L71:
        r115 = false;
    L57:
        r112 = false;
    L61:
        r113 = true;
    L49:
        r110 = false;
    L42:
        r18 = false;
        goto L43
    L35:
        if (StringsKt.isBlank(r16) == true) goto L38;
        r17 = false;
        goto L39
    L32:
        r16 = null;
        goto L33
    L28:
        r13 = null;
        goto L29
    L24:
        r11 = null;
        goto L25
    L20:
        r9 = false;
        goto L21
    L16:
        r7 = CollectionsKt.listOf(MediaTab.IMAGE);
        goto L17
    L13:
        r6 = false;
        goto L14
    L9:
        r3 = 4;
        goto L10
    L5:
        r1 = 1;
        goto L6
    }

    @Override // com.larus.photopicker.v2.api.IInnerPhotoPickerService
    public final void g(PhotoPickerFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        r4.startActivity(new Intent(r4.getContext(), PhotoPickerSettingPermissionActivity.class));
    }
}
