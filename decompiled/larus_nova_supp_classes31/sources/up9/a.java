package up9;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.photopicker.v2.impl.MediaSelectorListFragment;
import com.larus.photopicker.v2.impl.model.MediaGalleryUIConfig;
import com.larus.photopicker.v2.impl.ui.ClickType;
import com.larus.photopicker.v2.impl.viewmodel.MediaGalleryLiveDataViewModel;
import com.larus.photopicker.v2.impl.viewmodel.MediaMobViewModel;
import com.larus.platform.api.g1$c;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class a implements g0.b {
    public final Fragment a;
    public final MediaGalleryLiveDataViewModel b;
    public final MediaMobViewModel c;

    /* JADX INFO: renamed from: up9.a$a, reason: collision with other inner class name */
    public static final class C0078a implements g1$c {
        public final /* synthetic */ a a;

        @Override // com.larus.platform.api.g1$b
        public final void onGoSettingsDialogDismiss(boolean r1) {
        }

        @Override // com.larus.platform.api.g1$b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1$b
        public final void onSettingPageReturn() {
        }

        public C0078a(a r1) {
            this.a = r1;
        }

        @Override // com.larus.platform.api.g1$c
        public final void onResult(boolean r5, List<String> r6, List<String> r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r6, "grantedList");
            Intrinsics.checkNotNullParameter(r7, "deniedList");
            Set r9 = CollectionsKt.toSet(CollectionsKt.filterNotNull(r6));
            boolean r10 = r9.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
            boolean r0 = r9.contains("android.permission.READ_MEDIA_IMAGES");
            boolean r11 = r9.contains("android.permission.READ_MEDIA_VIDEO");
            MediaGalleryLiveDataViewModel r1 = this.a.b;
            int r2 = 1;
            if (r1 == null) goto L9;
            MediaGalleryUIConfig r3 = r1.getUiConfig();
            if (r3 == null) goto L9;
            if (r3.g != true) goto L9;
            boolean r4 = true;
        L10:
            if (r4 == false) goto L15;
            if (r0 == false) goto L14;
            if (r11 == false) goto L14;
            r0 = true;
        L14:
            r0 = false;
        L15:
            if (r0 == true) goto L20;
            if (r10 == false) goto L19;
            r2 = 2;
            goto L20
        L19:
            r2 = 0;
        L20:
            com.larus.platform.service.o r12 = com.larus.platform.service.o.a;
            JSONObject r13 = new JSONObject();
            r13.put("result", r2);
            Unit r14 = Unit.INSTANCE;
            r12.reportEvent("rd_request_image_permission", r13);
            if (r6.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L25;
            FLogger.a.i("AbsMediaSelectorListState", "READ_MEDIA_VISUAL_USER_SELECTED granted");
            MediaGalleryLiveDataViewModel r15 = this.a.b;
            if (r15 == null) goto L27;
            r15.refreshMediaFoldersAfterPermissionChange();
            return;
        L27:
            return;
        L25:
            FLogger.a.i("AbsMediaSelectorListState", "registerForActivityResult false");
            return;
        L9:
            r4 = false;
            goto L10
        }
    }

    private final void requestPermissions(List<String> r8) {
        FragmentActivity r3 = this.a.getActivity();
        if (r3 == null) goto L6;
        i2 r1 = i2.b;
        Fragment r2 = this.a;
        C0078a r6 = new C0078a(this);
        JSONObject r5 = new JSONObject();
        r5.put("enter_method", "album");
        r1.j(r2, r3, r8, r5, r6);
        return;
    }

    public a(MediaSelectorListFragment r2, MediaGalleryLiveDataViewModel r3, MediaMobViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // up9.g0.b
    public void a(op9.d r9, int r10, ClickType r11) {
        Intrinsics.checkNotNullParameter(r9, "mediaItem");
        Intrinsics.checkNotNullParameter(r11, "type");
        boolean r12 = false;
        if (r11 != ClickType.ON_FIRST_IMAGE_LOAD_SUCCESS) goto L8;
        MediaMobViewModel r13 = this.c;
        if (r13 == null) goto L8;
        JSONObject r3 = new JSONObject();
        r3.put("first_frame_thumb_count", 1);
        r3.put("first_frame_error_count", 0);
        r13.loadFrameEnd(r3);
    L8:
        if (r11 != ClickType.ON_FIRST_IMAGE_LOAD_FAILURE) goto L13;
        MediaMobViewModel r14 = this.c;
        if (r14 == null) goto L13;
        JSONObject r4 = new JSONObject();
        r4.put("first_frame_thumb_count", 0);
        r4.put("first_frame_error_count", 1);
        r14.loadFrameEnd(r4);
    L13:
        if (r11 != ClickType.ADD_MORE_PHOTO) goto L28;
        int r15 = pp9.c.b;
        long r2 = System.currentTimeMillis();
        if ((r2 - pp9.c.a) >= 500) goto L17;
        r12 = true;
    L18:
        if (r12 == false) goto L21;
        return;
    L21:
        if (Build.VERSION.SDK_INT < 34) goto L26;
        requestPermissions(CollectionsKt.listOf(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}));
        MediaMobViewModel r16 = this.c;
        if (r16 == null) goto L25;
        r16.mobClickAddChosenPic();
    L25:
        FLogger.a.i("AbsMediaSelectorListState", "request beyond UPSIDE_DOWN_CAKE");
        return;
    L26:
        FLogger.a.i("AbsMediaSelectorListState", "request under UPSIDE_DOWN_CAKE");
        return;
    L17:
        pp9.c.a = r2;
        goto L18
    }
}
