package com.larus.photopicker.v2.impl.viewmodel;

import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pp9.i;
import tx9.a1;
import tx9.c0;
import tx9.d2;
import tx9.u2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001d\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\tH\u0000¢\u0006\u0002\b J\u0006\u0010!\u001a\u00020\u000bJ\u001a\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J \u0010\"\u001a\u00020\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0'2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J\u0012\u0010(\u001a\u00020\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J\u0016\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tJ\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0005J\u0006\u00100\u001a\u00020\u000bJ\u0018\u00101\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\b\u00103\u001a\u0004\u0018\u00010\u0005J\b\u00104\u001a\u0004\u0018\u00010\u0005J\u0014\u00105\u001a\u00020\u000b2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/photopicker/v2/impl/viewmodel/MediaMobViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "currentPage", "", "uiConfig", "Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "isFirstLandingTab", "", "init", "", "loadDataStart", "hasLoaded", "loadDataEnd", "dataSize", "", "hasLoadedFrameEnd", "loadFrameEnd", "extraAttributes", "Lorg/json/JSONObject;", "mobClickAuth", "mobClickAddChosenPic", "mobClickTab", "mediaTab", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "mobClickItemInSingleMode", "mediaItem", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "mobClickItemInMultipleMode", "mobClickSelectInMultipleMode", "wasSelected", "mobClickSelectInMultipleMode$impl_mainlandRelease", "mobClickNext", "mobFinishAlbumChoose", "chooseCnt", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "selectedItems", "", "mobEnterPage", "mobPhotoPickerPageShow", "isBottomPhotoPicker", "isFromFeishu", "mobClickUploadEntrance", "mobOnTabFirstShow", "tabName", "mobOnTabSelected", "resetLandingTabForMob", "mobAlbumTabShow", "isLandingTab", "getActualEnterMethod", "getActualClickFrom", "mobClickAlbumButtonEventHelper", "buttonName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class MediaMobViewModel extends ViewModel {
    private String currentPage;
    private boolean hasLoaded;
    private boolean hasLoadedFrameEnd;
    private boolean isFirstLandingTab;
    private MediaGalleryUIConfig uiConfig;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaTab.values().length];
            r0[MediaTab.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MediaTab.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MediaTab.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static /* synthetic */ JSONObject yo() {
        return loadDataStart$lambda$2();
    }

    public final void resetLandingTabForMob() {
        this.isFirstLandingTab = true;
    }

    private static final JSONObject loadDataStart$lambda$2() {
        JSONObject r0 = new JSONObject();
        kq9.e r1 = lp9.d.a;
        kq9.e r2 = lp9.d.a;
        if (r2 == null) goto L18;
        String r3 = r2.a;
        String r4 = "";
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.put("bot_id", r3);
        String r5 = r2.d;
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r0.put("chat_type", r5);
        String r6 = r2.e;
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r0.put("previous_page", r6);
        String r7 = r2.f;
        if (r7 == null) goto L17;
        r4 = r7;
    L17:
        r0.put("enter_method", r4);
    L18:
        return r0;
    }

    public final String getActualClickFrom() {
        IAIChatRenderTraceService.Companion r0 = IAIChatRenderTraceService.a;
        Map<String, String> r1 = r0.i();
        boolean r3 = true;
        if (r1 == null) goto L9;
        String r2 = r1.get("key_click_from");
        if (r2 == null) goto L9;
        if (o0.d(r2) != true) goto L9;
        boolean r4 = true;
    L10:
        Map<String, String> r5 = r0.i();
        if (r5 == null) goto L13;
        String r6 = r5.get("key_has_album_pocket");
    L14:
        boolean r7 = Intrinsics.areEqual(r6, "1");
        Map<String, String> r8 = r0.i();
        if (r8 == null) goto L17;
        String r9 = r8.get("key_overview_click_form_addition");
    L18:
        boolean r10 = Intrinsics.areEqual(r9, "1");
        if (r4 == false) goto L22;
        if (r7 == false) goto L22;
    L23:
        if (r10 == false) goto L25;
        return "addition_menu";
    L25:
        if (r3 == false) goto L29;
        Map<String, String> r11 = r0.i();
        if (r11 != null) goto L35;
        return null;
    L35:
        return r11.get("key_click_from");
    L29:
        kq9.e r12 = lp9.d.a;
        kq9.e r13 = lp9.d.a;
        if (r13 != null) goto L32;
        return null;
    L32:
        return r13.f;
    L22:
        r3 = false;
        goto L23
    L17:
        r9 = null;
        goto L18
    L13:
        r6 = null;
    L9:
        r4 = false;
        goto L10
    }

    public final String getActualEnterMethod() {
        IAIChatRenderTraceService.Companion r0 = IAIChatRenderTraceService.a;
        Map<String, String> r1 = r0.i();
        boolean r3 = true;
        if (r1 == null) goto L9;
        String r2 = r1.get("key_enter_method");
        if (r2 == null) goto L9;
        if (o0.d(r2) != true) goto L9;
        boolean r4 = true;
    L10:
        Map<String, String> r5 = r0.i();
        if (r5 == null) goto L13;
        String r6 = r5.get("key_has_album_pocket");
    L14:
        boolean r7 = Intrinsics.areEqual(r6, "1");
        if (r4 == false) goto L18;
        if (r7 == false) goto L18;
    L19:
        if (r3 == false) goto L23;
        Map<String, String> r8 = r0.i();
        if (r8 != null) goto L28;
        return null;
    L28:
        return r8.get("key_enter_method");
    L23:
        kq9.e r9 = lp9.d.a;
        kq9.e r10 = lp9.d.a;
        if (r10 != null) goto L26;
        return null;
    L26:
        return r10.f;
    L18:
        r3 = false;
        goto L19
    L13:
        r6 = null;
    L9:
        r4 = false;
        goto L10
    }

    public final void loadDataStart() {
        i.b = new c();
        i.a().c((i.b) i.c.getValue());
    }

    public final void mobClickAddChosenPic() {
        mobClickAlbumButtonEventHelper("add_chosen_pic");
    }

    public final void mobClickAuth() {
        mobClickAlbumButtonEventHelper("authorization_guide");
    }

    public final void mobClickNext() {
        mobClickAlbumButtonEventHelper("next_step");
    }

    public final void mobClickUploadEntrance() {
        String r6 = this.currentPage;
        kq9.e r1 = lp9.d.a;
        if (r1 == null) goto L5;
        String r5 = r1.a;
    L6:
        if (r1 == null) goto L8;
        String r12 = r1.d;
    L9:
        if (r1 == null) goto L11;
        String r13 = r1.g;
    L12:
        if (r1 == null) goto L14;
        String r25 = r1.h;
    L15:
        c0.H(r5, "chat_album_preview_slide", null, null, r12, r6, null, null, null, null, null, r13, r25, 0, null, null, null, null, null, null, null, null, null, 33548236);
        return;
    L14:
        r25 = null;
        goto L15
    L11:
        r13 = null;
        goto L12
    L8:
        r12 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public MediaMobViewModel() {
        this.currentPage = "album";
        Parcelable.Creator<MediaGalleryUIConfig> r0 = MediaGalleryUIConfig.CREATOR;
        this.uiConfig = MediaGalleryUIConfig.G.a();
        this.isFirstLandingTab = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    private final void mobClickAlbumButtonEventHelper(String r15) {
        kq9.e r0 = lp9.d.a;
        IAIChatRenderTraceService.Companion r1 = IAIChatRenderTraceService.a;
        Map<String, String> r2 = r1.i();
        ?? r4 = 0;
        if (r2 == null) goto L9;
        String r3 = r2.get("key_current_page");
        if (r3 == null) goto L9;
        boolean r5 = true;
        if (o0.d(r3) != true) goto L9;
    L10:
        String r6 = null;
        if (r5 == false) goto L16;
        Map<String, String> r7 = r1.i();
        if (r7 == null) goto L15;
        String r8 = r7.get("key_current_page");
    L17:
        String r10 = r8;
    L18:
        d2 r9 = d2.a;
        if (r0 == null) goto L21;
        String r11 = r0.a;
    L22:
        if (r0 == null) goto L24;
        String r12 = r0.d;
    L25:
        String r13 = getActualClickFrom();
        if (r0 == null) goto L28;
        r6 = r0.e;
    L28:
        String r14 = r6;
        if (this.uiConfig.d == true) goto L31;
        String r16 = "1";
    L32:
        String r17 = r16;
        if (r0 == null) goto L35;
        r4 = Intrinsics.areEqual(r0.j, Boolean.TRUE);
    L35:
        d2.b(r9, r11, r12, r13, r15, r10, r14, r17, Integer.valueOf(r4));
        return;
    L31:
        r16 = "0";
        goto L32
    L24:
        r12 = null;
        goto L25
    L21:
        r11 = null;
        goto L22
    L15:
        r10 = null;
        goto L18
    L16:
        r8 = this.currentPage;
    L9:
        r5 = false;
        goto L10
    }

    public final void loadDataEnd(int r4) {
        if (this.hasLoaded == false) goto L5;
        return;
    L5:
        this.hasLoaded = true;
        Lazy r1 = i.a;
        JSONObject r2 = new JSONObject();
        r2.put("notify_times", 1);
        r2.put("album_size", r4);
        r2.put("data_type", "media");
        Intrinsics.checkNotNullParameter(r2, "extraAttributes");
        i.a().a((i.b) i.c.getValue(), r2);
    }

    public final void loadFrameEnd(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "extraAttributes");
        if (this.hasLoadedFrameEnd == false) goto L5;
        return;
    L5:
        this.hasLoadedFrameEnd = true;
        Lazy r1 = i.a;
        Intrinsics.checkNotNullParameter(r3, "extraAttributes");
        i.a().a((i.c) i.d.getValue(), r3);
    }

    public final void mobClickItemInMultipleMode(op9.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mediaItem");
        if (r2.a.getType() != MediaType.VIDEO) goto L5;
        String r3 = "check_choose_video";
    L6:
        mobClickAlbumButtonEventHelper(r3);
        return;
    L5:
        r3 = "check_choose_pic";
        goto L6
    }

    public final void mobClickItemInSingleMode(op9.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mediaItem");
        if (r2.a.getType() != MediaType.VIDEO) goto L5;
        String r3 = "click_video";
    L6:
        mobClickAlbumButtonEventHelper(r3);
        return;
    L5:
        r3 = "click_pic";
        goto L6
    }

    public final void mobClickTab(MediaTab r2) {
        Intrinsics.checkNotNullParameter(r2, "mediaTab");
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
        String r4 = "click_all_tab";
    L13:
        mobClickAlbumButtonEventHelper(r4);
        return;
    L5:
        if (r3 != 2) goto L7;
        r4 = "click_video_tab";
        goto L13
    L7:
        if (r3 != 3) goto L10;
        r4 = "click_pic_tab";
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void mobEnterPage(by7.e r57) {
        String r9 = this.currentPage;
        kq9.e r1 = lp9.d.a;
        if (r1 == null) goto L5;
        String r17 = r1.e;
    L6:
        if (r1 == null) goto L8;
        String r16 = r1.f;
    L9:
        if (r1 == null) goto L11;
        String r4 = r1.a;
    L12:
        if (r1 == null) goto L14;
        String r39 = r1.d;
    L15:
        if (r1 == null) goto L17;
        String r45 = r1.i;
    L18:
        a1.c(r4, null, null, r39, null, null, null, null, r16, null, null, null, null, null, null, r9, r17, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r45, null, null, null, null, null, r57, null, null, null, null, null, null, null, -1573923, -17039361, 7);
        return;
    L17:
        r45 = null;
        goto L18
    L14:
        r39 = null;
        goto L15
    L11:
        r4 = null;
        goto L12
    L8:
        r16 = null;
        goto L9
    L5:
        r17 = null;
        goto L6
    }

    public final void mobOnTabFirstShow(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tabName");
        if (this.isFirstLandingTab == true) goto L5;
        return;
    L5:
        mobAlbumTabShow(r2, "1");
        this.isFirstLandingTab = false;
    }

    public final void mobOnTabSelected(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tabName");
        if (this.isFirstLandingTab == false) goto L5;
        String r0 = "1";
    L6:
        mobAlbumTabShow(r2, r0);
        this.isFirstLandingTab = false;
        return;
    L5:
        r0 = "0";
        goto L6
    }

    private final void mobAlbumTabShow(String r13, String r14) {
        kq9.e r0 = lp9.d.a;
        String r1 = this.currentPage;
        String r2 = null;
        if (r0 == null) goto L5;
        String r3 = r0.f;
    L6:
        Map<String, String> r4 = IAIChatRenderTraceService.a.i();
        if (r4 == null) goto L34;
        String r5 = r4.get("key_current_page");
        if (r5 != null) goto L11;
    L16:
        String r6 = r4.get("key_click_from");
        if (r6 != null) goto L19;
    L24:
        String r7 = r4.get("spring_guide_card_id");
        if (r7 != null) goto L27;
    L32:
        r7 = null;
    L33:
        String r8 = r1;
        String r9 = r3;
        String r11 = r7;
    L35:
        d2 r10 = d2.a;
        if (r0 == null) goto L38;
        r2 = r0.a;
    L38:
        d2.a(r10, r8, r9, r2, r13, r14, r11);
        return;
    L27:
        if (o0.d(r7) == true) goto L30;
        r7 = null;
    L30:
        if (r7 == null) goto L32;
    L19:
        if (o0.d(r6) == true) goto L22;
        r6 = null;
    L22:
        if (r6 == null) goto L24;
        r3 = r6;
        goto L24
    L11:
        if (o0.d(r5) == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        r1 = r5;
        goto L16
    L34:
        r8 = r1;
        r11 = null;
        r9 = r3;
        goto L35
    L5:
        r3 = null;
        goto L6
    }

    public final void init(String r2, MediaGalleryUIConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "uiConfig");
        this.currentPage = r2;
        this.uiConfig = r3;
    }

    public final void mobClickSelectInMultipleMode$impl_mainlandRelease(op9.d r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "mediaItem");
        if (r3 == false) goto L6;
        String r4 = "multi_choose_cancel";
    L9:
        mobClickAlbumButtonEventHelper(r4);
        return;
    L6:
        if (r2.a.getType() != MediaType.VIDEO) goto L8;
        r4 = "click_video";
        goto L9
    L8:
        r4 = "click_pic";
        goto L9
    }

    public final void mobFinishAlbumChoose(List<op9.d> r9, by7.e r10) {
        Intrinsics.checkNotNullParameter(r9, "selectedItems");
        List<op9.d> r0 = r9;
        boolean r1 = r0 instanceof Collection;
        int r3 = 0;
        if (r1 == true) goto L5;
    L7:
        Iterator<T> r4 = r0.iterator();
        int r5 = 0;
    L9:
        if (r4.hasNext() == false) goto L18;
        if (((op9.d) r4.next()).a.getType() == MediaType.VIDEO) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
        r5 = r5 + 1;
        if (r5 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r6 = false;
    L18:
        if (r1 == true) goto L20;
    L22:
        Iterator<T> r2 = r0.iterator();
        int r7 = 0;
    L24:
        if (r2.hasNext() == false) goto L33;
        if (((op9.d) r2.next()).a.getType() != MediaType.VIDEO) goto L28;
        boolean r8 = true;
    L29:
        if (r8 == false) goto L24;
        r7 = r7 + 1;
        if (r7 >= 0) goto L24;
        CollectionsKt.throwCountOverflow();
        goto L24
    L28:
        r8 = false;
        goto L29
    L33:
        r3 = r7;
    L34:
        Integer r11 = Integer.valueOf(r9.size());
        JSONObject r12 = new JSONObject();
        r12.put("choose_pic_cnt", r5);
        r12.put("choose_video_cnt", r3);
        kq9.e r13 = lp9.d.a;
        kq9.e r14 = lp9.d.a;
        if (r14 == null) goto L50;
        String r15 = r14.a;
        String r16 = "";
        if (r15 != null) goto L39;
        r15 = "";
    L39:
        r12.put("bot_id", r15);
        String r17 = r14.d;
        if (r17 != null) goto L42;
        r17 = "";
    L42:
        r12.put("chat_type", r17);
        String r18 = r14.f;
        if (r18 != null) goto L45;
        r18 = "";
    L45:
        r12.put("click_from", r18);
        Boolean r19 = r14.j;
        Boolean r20 = Boolean.TRUE;
        r12.put("is_ai_doc", Intrinsics.areEqual(r19, r20) ? 1 : 0);
        r12.put("is_replica_create", Intrinsics.areEqual(r14.k, r20) ? 1 : 0);
        String r21 = r14.l;
        if (r21 == null) goto L49;
        r16 = r21;
    L49:
        r12.put("replica_create_id", r16);
    L50:
        u2.b(r11, r12, r10);
        return;
    L20:
        if (r0.isEmpty() == false) goto L22;
    L5:
        if (r0.isEmpty() == false) goto L7;
        r5 = 0;
        goto L18
    }

    public final void mobPhotoPickerPageShow(boolean r3, boolean r4) {
        d2 r0 = d2.a;
        JSONObject r1 = lp9.d.a();
        r0.getClass();
        d2.d(true, r3, r4, r1);
    }

    public final void mobFinishAlbumChoose(int r7, by7.e r8) {
        Integer r9 = Integer.valueOf(r7);
        JSONObject r0 = new JSONObject();
        kq9.e r1 = lp9.d.a;
        kq9.e r2 = lp9.d.a;
        if (r2 == null) goto L18;
        String r3 = r2.a;
        String r4 = "";
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.put("bot_id", r3);
        String r5 = r2.d;
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r0.put("chat_type", r5);
        String r6 = r2.f;
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r0.put("click_from", r6);
        Boolean r10 = r2.j;
        Boolean r11 = Boolean.TRUE;
        r0.put("is_ai_doc", Intrinsics.areEqual(r10, r11) ? 1 : 0);
        r0.put("is_replica_create", Intrinsics.areEqual(r2.k, r11) ? 1 : 0);
        String r12 = r2.l;
        if (r12 == null) goto L17;
        r4 = r12;
    L17:
        r0.put("replica_create_id", r4);
    L18:
        u2.b(r9, r0, r8);
    }

    public static /* synthetic */ void mobClickAlbumButtonEventHelper$default(MediaMobViewModel r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.mobClickAlbumButtonEventHelper(r1);
    }

    public static /* synthetic */ void mobEnterPage$default(MediaMobViewModel r0, by7.e r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.mobEnterPage(r1);
    }

    public static /* synthetic */ void mobFinishAlbumChoose$default(MediaMobViewModel r0, int r1, by7.e r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.mobFinishAlbumChoose(r1, r2);
    }

    public static /* synthetic */ void mobFinishAlbumChoose$default(MediaMobViewModel r0, List r1, by7.e r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.mobFinishAlbumChoose(r1, r2);
    }
}
