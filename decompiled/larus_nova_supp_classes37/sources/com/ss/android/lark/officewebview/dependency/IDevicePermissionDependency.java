package com.ss.android.lark.officewebview.dependency;

import com.ss.android.lark.officesdk.di.core.b;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface IDevicePermissionDependency extends b {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officewebview/dependency/IDevicePermissionDependency$CameraPermissionScene;", "", "<init>", "(Ljava/lang/String;I)V", "FILE_CHOOSE_V2", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum CameraPermissionScene extends Enum<CameraPermissionScene> {
        public static final CameraPermissionScene FILE_CHOOSE_V2 = null;
        public static final /* synthetic */ CameraPermissionScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CameraPermissionScene> getEntries() {
            return b;
        }

        static {
            CameraPermissionScene r0 = new CameraPermissionScene();
            FILE_CHOOSE_V2 = r0;
            CameraPermissionScene[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public CameraPermissionScene() {
            super("FILE_CHOOSE_V2", 0);
        }

        public static CameraPermissionScene[] values() {
            return (CameraPermissionScene[]) a.clone();
        }

        public static CameraPermissionScene valueOf(String r1) {
            return (CameraPermissionScene) a.a(CameraPermissionScene.class, r1);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officewebview/dependency/IDevicePermissionDependency$MediaScannerAction;", "", "<init>", "(Ljava/lang/String;I)V", "FILE_CHOOSE_V2", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum MediaScannerAction extends Enum<MediaScannerAction> {
        public static final MediaScannerAction FILE_CHOOSE_V2 = null;
        public static final /* synthetic */ MediaScannerAction[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<MediaScannerAction> getEntries() {
            return b;
        }

        static {
            MediaScannerAction r0 = new MediaScannerAction();
            FILE_CHOOSE_V2 = r0;
            MediaScannerAction[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public MediaScannerAction() {
            super("FILE_CHOOSE_V2", 0);
        }

        public static MediaScannerAction[] values() {
            return (MediaScannerAction[]) a.clone();
        }

        public static MediaScannerAction valueOf(String r1) {
            return (MediaScannerAction) a.a(MediaScannerAction.class, r1);
        }
    }

    String m0();

    boolean o0();
}
