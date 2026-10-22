package com.larus.drive.sdk.impl.view.chat.fileselect;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common_ui.widget.ChatFileSelectorView;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.DrivePickerScene;
import com.larus.drive.sdk.api.IDriveSdkService;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.databinding.LarusDialogDriveFileSelectBinding;
import com.larus.platform.api.DriveFileSelectScene;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import com.larus.platform.api.fileselect.SelectDialogParam;
import com.larus.platform.model.OfficeAskDoubaoType;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ý\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001'\u0018\u0000 \u0083\u00012\u00020\u0001:\u0006\u0083\u0001\u0084\u0001\u0085\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010=\u001a\u000203H\u0016J1\u0010>\u001a\u0002032)\u0010?\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020/0\u0014¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u000203\u0018\u00010.J\u000e\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020\"J\u001a\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020\u0017H\u0002J\u0010\u0010E\u001a\u00020\u00172\u0006\u0010C\u001a\u00020/H\u0002J\u0010\u0010F\u001a\u0002032\u0006\u0010C\u001a\u00020/H\u0002J\u0018\u0010G\u001a\u0002032\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0015H\u0002J\b\u0010K\u001a\u000203H\u0002J\b\u0010L\u001a\u000203H\u0002J\b\u0010M\u001a\u000203H\u0002J \u0010N\u001a\u0002032\b\u0010O\u001a\u0004\u0018\u00010\u00122\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0014H\u0002J\"\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020Q2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020\u001bH\u0002J\u0014\u0010W\u001a\u0004\u0018\u00010\u00122\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0014\u0010X\u001a\u0004\u0018\u00010\u00122\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\b\u0010Y\u001a\u000203H\u0002J\b\u0010Z\u001a\u000203H\u0002J\b\u0010[\u001a\u000203H\u0002J\b\u0010\\\u001a\u000203H\u0002J\n\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0010\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u000bH\u0002J\u001c\u0010a\u001a\u00020b2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0014H\u0082@¢\u0006\u0002\u0010cJ\u0016\u0010d\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020/H\u0082@¢\u0006\u0002\u0010eJ(\u0010d\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u00122\u0006\u0010g\u001a\u00020\u001b2\b\b\u0002\u0010h\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010iJ\u0010\u0010j\u001a\u00020\u00172\u0006\u0010C\u001a\u00020/H\u0002J\u0010\u0010k\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020/H\u0002J\u0010\u0010l\u001a\u0002032\u0006\u0010C\u001a\u00020/H\u0002J\u0010\u0010m\u001a\u0002032\u0006\u0010C\u001a\u00020/H\u0002J\u0010\u0010n\u001a\u0002032\u0006\u0010C\u001a\u00020/H\u0002J\u001a\u0010o\u001a\u00020p2\u0006\u0010C\u001a\u00020/2\b\b\u0002\u0010q\u001a\u00020\u0017H\u0002J\u0012\u0010r\u001a\u0004\u0018\u00010I2\u0006\u0010s\u001a\u00020QH\u0002J\u001a\u0010t\u001a\u0004\u0018\u00010I2\u0006\u0010s\u001a\u00020Q2\u0006\u0010u\u001a\u00020\u000bH\u0002J\f\u0010v\u001a\u00020\u0017*\u00020QH\u0002J\u000e\u0010w\u001a\u0004\u0018\u00010x*\u00020\u001bH\u0002J\u0014\u0010y\u001a\u00020z*\u00020\u001b2\u0006\u0010{\u001a\u00020\u0012H\u0002J\f\u0010|\u001a\u00020\u0012*\u00020IH\u0002J\f\u0010v\u001a\u00020\u0017*\u00020/H\u0002J\u0014\u0010}\u001a\u00020/*\u00020/2\u0006\u0010u\u001a\u00020\u000bH\u0002J\u000e\u0010~\u001a\u0004\u0018\u00010/*\u00020QH\u0002J\u001f\u0010\u007f\u001a\u00020Q*\u00020/2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0003\u0010\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0012*\u00020QH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00170$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\t\u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010-\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020/0\u0014¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u000203\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Lcom/larus/drive/sdk/impl/view/chat/fileselect/DriveFileSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "larkDriveConfig", "Lcom/larus/platform/model/LarkDriveConfig;", "getLarkDriveConfig", "()Lcom/larus/platform/model/LarkDriveConfig;", "larkDriveConfig$delegate", "Lkotlin/Lazy;", "picMaxSize", "", "getPicMaxSize", "()J", "picMaxSize$delegate", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogDriveFileSelectBinding;", "titleText", "", "allowFileTypeList", "", "Lcom/larus/platform/api/FlowDriveFileType;", "allowFile", "", "existingSelectedTypes", "", "currentSize", "", "scene", "Lcom/larus/platform/api/DriveFileSelectScene;", "hasShownAnim", "dialogParam", "Lcom/larus/platform/api/fileselect/SelectDialogParam;", "selectionStore", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore;", "fileSizeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "resolvingFileTokens", "pickerCallback", "com/larus/drive/sdk/impl/view/chat/fileselect/DriveFileSelectDialog$pickerCallback$2$1", "getPickerCallback", "()Lcom/larus/drive/sdk/impl/view/chat/fileselect/DriveFileSelectDialog$pickerCallback$2$1;", "pickerCallback$delegate", "pickerController", "Lcom/larus/drive/sdk/api/file/picker/IDrivePickerController;", "onFileSelectionDoneCallback", "Lkotlin/Function1;", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Lkotlin/ParameterName;", "name", "fileList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "setOnFileSelectionDoneCallback", "callback", "setSelectionStore", "store", "isFileAllowed", "file", "needToast", "isSupportedByAskDoubaoConfig", "toastDriveEntryReject", "toastReject", "reason", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore$RejectionReason;", "incomingType", "startEnterAnimation", "setupView", "initFileSelector", "dispatchChatFileSelection", "tag", "selectedList", "Lcom/larus/platform/api/FlowSelectedFileItem;", "mobUploadAttachmentStatus", "select", "source", "Lcom/larus/platform/api/fileselect/IChatFileSelectionStore$Source;", "selectedCount", "resolveUploadFrom", "resolveUploadWay", "initPicker", "hideKeyboard", "dismissChatFileSelectDialog", "initStore", "getHostScope", "Lkotlinx/coroutines/CoroutineScope;", "getFileVisitTimeString", "visitTime", "resolveSelectedDriveFileSizes", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/DriveFileSelectDialog$SelectionResolveResult;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDriveFileSize", "(Lcom/larus/drive/sdk/api/file/DriveFileItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileToken", "driveObjType", "knownSize", "(Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldResolveBeforeSelection", "getResolvedDriveFileSize", "warmUpDriveFileSize", "selectAfterResolvingSize", "selectResolvedFile", "validateDriveSelection", "Lcom/larus/drive/sdk/impl/view/chat/fileselect/DriveFileSelectDialog$DriveSelectionValidation;", "shouldValidateSize", "validateAgainstExistingSelectedTypes", "item", "validateResolvedDriveSize", "size", "isLarkDocType", "toOfficeAskDoubaoType", "Lcom/larus/platform/model/OfficeAskDoubaoType;", "toDriveFileType", "Lcom/larus/drive/biz/api/model/DriveFileType;", "fileName", "toLogString", "withResolvedSize", "toDriveFileItem", "toSelectedFileItem", "resolvedSize", "(Lcom/larus/drive/sdk/api/file/DriveFileItem;Ljava/lang/Long;)Lcom/larus/platform/api/FlowSelectedFileItem;", "toDriveFileExtraJson", "Companion", "SelectionResolveResult", "DriveSelectionValidation", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveFileSelectDialog extends DialogFragment {
    public static final /* synthetic */ int t = 0;
    public final Lazy d;
    public final Lazy e;
    public LarusDialogDriveFileSelectBinding f;
    public String g;
    public List<? extends FlowDriveFileType> h;
    public Set<? extends FlowDriveFileType> i;
    public int j;
    public DriveFileSelectScene k;
    public boolean l;
    public SelectDialogParam m;
    public IChatFileSelectionStore n;
    public final ConcurrentHashMap<String, Long> o;
    public final ConcurrentHashMap<String, Boolean> p;
    public final Lazy q;
    public w79.b r;
    public Function1<? super List<DriveFileItem>, Unit> s;

    public static final class a {
    }

    public static final class b {
        public final com.larus.platform.api.u a;
        public final IChatFileSelectionStore.b b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "DriveSelectionValidation(selectedItem=" + this.a + ", result=" + this.b + ')';
        }

        public b(com.larus.platform.api.u r2, IChatFileSelectionStore.b r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedItem");
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c {
        public final List<com.larus.platform.api.u> a;
        public final IChatFileSelectionStore.a b;
        public final FlowDriveFileType c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            IChatFileSelectionStore.a r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "SelectionResolveResult(selectedList=" + this.a + ", rejectionReason=" + this.b + ", rejectedType=" + this.c + ')';
        }

        public c(List<com.larus.platform.api.u> r2, IChatFileSelectionStore.a r3, FlowDriveFileType r4) {
            Intrinsics.checkNotNullParameter(r2, "selectedList");
            Intrinsics.checkNotNullParameter(r4, "rejectedType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.AI_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[DriveFileType.AI_SLIDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L45:
            r0[DriveFileType.AI_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[DriveFileType.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[DriveFileType.MINDNOTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[DriveFileType.AUDIO.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L37:
            r0[DriveFileType.IMAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L39:
            r0[DriveFileType.VIDEO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L12:
            a = r0;
            int[] r1 = new int[IChatFileSelectionStore.Source.values().length];
            r1[IChatFileSelectionStore.Source.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L29:
            r1[IChatFileSelectionStore.Source.DRIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L15:
            b = r1;
        }
    }

    static {
    }

    public DriveFileSelectDialog() {
        this.d = LazyKt.lazy(new s());
        this.e = LazyKt.lazy(new t(this));
        this.i = SetsKt.emptySet();
        this.k = DriveFileSelectScene.UNKNOWN;
        this.n = new com.larus.platform.api.fileselect.a();
        this.o = new ConcurrentHashMap();
        this.p = new ConcurrentHashMap();
        this.q = LazyKt.lazy(new u(this));
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L18;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L18;
        r1.setLayout(-1, -1);
        r1.setGravity(80);
        r1.clearFlags(2);
        LarusDialogDriveFileSelectBinding r2 = this.f;
        if (r2 == null) goto L11;
        ConstraintLayout r3 = r2.a;
        if (r3 == null) goto L11;
    L16:
        new WindowInsetsControllerCompat(r1, r3).setAppearanceLightStatusBars(false);
    L11:
        r3 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L16;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L16;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L18:
        if (this.l == true) goto L31;
        this.l = true;
        LarusDialogDriveFileSelectBinding r5 = this.f;
        if (r5 == null) goto L30;
        final View r6 = r5.i;
        if (r6 == null) goto L32;
        final ConstraintLayout r7 = r5.f;
        if (r7 == null) goto L33;
        r6.setAlpha(0.0f);
        r7.post(new r(this, r7, r6));
        return;
    L33:
        return;
    L32:
        return;
    L30:
        return;
    }

    public static boolean X90(DriveFileItem r1) {
        int r0 = bq9.a.a;
        return l1.k(r1.j.getValue());
    }

    public static DriveFileItem Z90(com.larus.platform.api.u r21) {
        String r1 = r21.b;
        String r2 = r21.a;
        int r4 = r21.h;
        String r5 = r21.g;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        long r7 = r21.i;
        long r9 = r21.j;
        int r11 = r21.e;
        String r12 = r21.k;
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        if (r4 != 2) goto L11;
    L24:
        DriveFileType r6 = DriveFileType.AI_DOC;
    L25:
        DriveFileType r14 = r6;
        int r8 = r21.l;
        int r13 = r21.h;
        Map r10 = r21.m;
        String r15 = r21.g;
        String r18 = r12;
        if (r13 != 8) goto L36;
        if (r10 == null) goto L34;
        String r16 = (String) r10.get("originBaseBizType");
        if (r16 == null) goto L34;
        Integer r17 = StringsKt.toIntOrNull(r16);
        if (r17 == null) goto L34;
    L38:
        if (r21.h != 8) goto L42;
        if (r17 == null) goto L42;
        String r110 = new JSONObject().put("originBaseBizType", r17.intValue()).toString();
    L44:
        return new DriveFileItem(r1, r2, "", r4, r5, r7, r9, r11, r18, r14, r8, r110);
    L42:
        r110 = null;
    L34:
        if (bq9.b.b(r15) == false) goto L36;
        r17 = 1;
    L36:
        r17 = null;
        goto L38
    L11:
        if (r4 == 3) goto L23;
        if (r4 != 8) goto L14;
        r6 = DriveFileType.BITABLE;
        goto L25
    L14:
        if (r4 != 11) goto L16;
        r6 = DriveFileType.MINDNOTE;
        goto L25
    L16:
        if (r4 == 22) goto L24;
        if (r4 == 30) goto L20;
        DriveFileType.Companion.getClass();
        r6 = DriveFileType.a.b(r1);
        goto L25
    L20:
        r6 = DriveFileType.AI_SLIDES;
        goto L25
    L23:
        r6 = DriveFileType.AI_SHEET;
        goto L25
    }

    public final long V90(DriveFileItem r6) {
        Long r0 = this.o.get(r6.b);
        if (r0 == null) goto L5;
        long r3 = r0.longValue();
    L7:
        if (r3 <= 0) goto L10;
        return r3;
    L10:
        return r6.e();
    L5:
        r3 = 0;
        goto L7
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        if (r6 != null) goto L71;
        setStyle(2, 2131952391);
        Bundle r7 = getArguments();
        Set<? extends FlowDriveFileType> r0 = null;
        if (r7 == null) goto L14;
        String r1 = r7.getString("arg_title");
    L15:
        this.g = r1;
        DriveFileSelectScene.a r2 = DriveFileSelectScene.Companion;
        if (r7 == null) goto L18;
        String r3 = r7.getString("arg_scene");
    L19:
        r2.getClass();
        Iterator r4 = DriveFileSelectScene.getEntries().iterator();
    L21:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((DriveFileSelectScene) r5).getValue(), r3) == false) goto L21;
    L26:
        DriveFileSelectScene r8 = (DriveFileSelectScene) r5;
        if (r8 != null) goto L29;
        r8 = DriveFileSelectScene.UNKNOWN;
    L29:
        this.k = r8;
        if (r7 == null) goto L32;
        ArrayList<String> r9 = r7.getStringArrayList("arg_allow_file_type_list");
    L33:
        if (r9 == null) goto L48;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L36:
        if (r11.hasNext() == false) goto L49;
        String r12 = (String) r11.next();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L40
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L40
        Object r14 = Result.constructor-impl(FlowDriveFileType.valueOf(r12));     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r14) == false) goto L45;
        r14 = null;
    L45:
        FlowDriveFileType r15 = (FlowDriveFileType) r14;
        if (r15 == null) goto L36;
        r10.add(r15);
    L40:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L49:
        this.h = r10;
        int r17 = 0;
        if (r7 == null) goto L52;
        r7.getBoolean("arg_allow_file", false);
    L52:
        if (r7 == null) goto L54;
        r17 = r7.getInt("arg_current_size", 0);
    L54:
        this.j = r17;
        if (r7 == null) goto L57;
        Serializable r18 = r7.getSerializable("arg_dialog_param");
    L59:
        if ((r18 instanceof SelectDialogParam) == false) goto L61;
        SelectDialogParam r20 = (SelectDialogParam) r18;
    L62:
        this.m = r20;
        if (r20 == null) goto L67;
        List r21 = r20.getExistingSelectedTypes();
        if (r21 == null) goto L67;
        r0 = CollectionsKt.toSet(r21);
    L67:
        if (r0 != null) goto L69;
        r0 = SetsKt.emptySet();
    L69:
        this.i = r0;
        setCancelable(true);
        return;
    L61:
        r20 = null;
        goto L62
    L57:
        r18 = null;
        goto L59
    L48:
        r10 = null;
        goto L49
    L32:
        r9 = null;
        goto L33
    L25:
        r5 = null;
        goto L26
    L18:
        r3 = null;
        goto L19
    L14:
        r1 = null;
        goto L15
    L71:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r22 = DialogFragmentLancet.sLastShowStack;
        if (r22 == null) goto L83;
        com.bytedance.crash.d.d(r22, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final void U90(DriveFileSelectDialog r3, DriveFileItem r4) {
        b r0 = r3.ca0(r4, true);
        IChatFileSelectionStore.b.b r1 = r0.b;
        if ((r1 instanceof IChatFileSelectionStore.b.b) == false) goto L5;
        r3.ba0(r1.a, r0.a.f);
        return;
    L5:
        w79.b r5 = r3.r;
        if (r5 == null) goto L10;
        r5.selectItem(CollectionsKt.listOf(r4));
        return;
    }

    public static DriveFileItem ea0(DriveFileItem r3, long r4) {
        if (r4 > 0) goto L5;
        return r3;
    L5:
        if (r3.e() == r4) goto L23;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        String r1 = r3.l;     // Catch: Throwable -> L12
        if (r1 != null) goto L10;
        r1 = "{}";
    L10:
        Object r2 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L12
    L15:
        if (Result.exceptionOrNull-impl(r2) == null) goto L18;
        r2 = new JSONObject();
    L18:
        JSONObject r5 = (JSONObject) r2;
        r5.put("size", r4);
        return DriveFileItem.a(r3, null, null, r5.toString(), 2047);
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L23:
        return r3;
    }

    public final boolean W90(DriveFileItem r11, boolean r12) {
        DriveFileType r0 = r11.j;
        int[] r1 = d.a;
        int r2 = r1[r0.ordinal()];
        boolean r3 = true;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L11;
        if (r2 == 3) goto L11;
        if (r2 == 4) goto L11;
        if (r2 == 5) goto L11;
    L60:
        boolean r6 = r3;
    L61:
        if (r6 == true) goto L71;
        if (r12 == false) goto L71;
        int r13 = r1[r11.j.ordinal()];
        if (r13 != 6) goto L66;
        int r14 = 2131909177;
    L70:
        t19.s r15 = t19.s.a;
        Context r4 = getContext();
        r15.getClass();
        t19.s.s(r4, r14);
        goto L71
    L66:
        if (r13 == 7) goto L68;
        r14 = 2131900750;
        goto L70
    L68:
        r14 = 2131909178;
    L71:
        return r6;
    L11:
        Intrinsics.checkNotNullParameter(r11, "<this>");
        r6 = false;
        if (r11.d != 8) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L22;
        int r7 = bq9.b.a;
        if (bq9.b.a(com.larus.drive.sdk.impl.utils.a.a(r11), r11.e) == false) goto L22;
        boolean r8 = true;
    L24:
        if (r8 == false) goto L26;
        Integer r9 = com.larus.drive.sdk.impl.utils.a.b(r11);
        FLogger.a.i("DriveFileSelectDialog", "[isSupportedByAskDoubaoConfig] bitable app is not supported, driveObjType=" + r11.d + ", fileType=" + r11.j + ", baseBizType=" + r9);
        goto L61
    L26:
        int r10 = r11.d;
        String r16 = null;
        if (r10 == 2) goto L44;
        if (r10 == 3) goto L43;
        if (r10 != 8) goto L31;
        OfficeAskDoubaoType r17 = OfficeAskDoubaoType.BITABLE;
    L45:
        if (r17 != null) goto L47;
    L49:
        boolean r18 = false;
    L50:
        boolean r20 = AccountService.a.isLogin().booleanValue();
        if (r18 == false) goto L54;
        if (r20 == false) goto L54;
    L55:
        if (r3 == true) goto L60;
        FLogger r21 = FLogger.a;
        StringBuilder r22 = new StringBuilder("[isSupportedByAskDoubaoConfig] askDoubaoType=");
        if (r17 == null) goto L59;
        r16 = r17.getConfigValue();
    L59:
        r22.append(r16);
        r22.append(", askDoubaoEnabled=");
        r22.append(r18);
        r22.append(", isLogin=");
        r22.append(r20);
        r21.i("DriveFileSelectDialog", r22.toString());
    L54:
        r3 = false;
        goto L55
    L47:
        if (z2.a.getLarkDriveConfigV2().f(r17) != true) goto L49;
        r18 = true;
        goto L50
    L31:
        if (r10 == 22) goto L44;
        if (r10 != 30) goto L35;
        r17 = OfficeAskDoubaoType.PPT;
        goto L45
    L35:
        if (r10 != 11) goto L37;
        r17 = OfficeAskDoubaoType.MINDNOTE;
        goto L45
    L37:
        if (r10 == 12) goto L39;
        r17 = null;
        goto L45
    L39:
        r17 = OfficeAskDoubaoType.FILE;
        goto L45
    L43:
        r17 = OfficeAskDoubaoType.SHEET;
    L44:
        r17 = OfficeAskDoubaoType.DOC;
    L22:
        r8 = false;
        goto L24
    L14:
        if (r11.j == DriveFileType.BITABLE) goto L17;
        r5 = false;
        goto L18
    }

    public final com.larus.platform.api.u aa0(DriveFileItem r22, Long r23) {
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("originFileTypeString", r22.j.getValue()), TuplesKt.to("originUrl", r22.e), TuplesKt.to("upload_from", "drive"), TuplesKt.to("upload_way", "input_ai_space")});
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Integer r2 = com.larus.drive.sdk.impl.utils.a.b(r22);
        if (r2 == null) goto L5;
        Map r3 = MapsKt.mapOf(TuplesKt.to("originBaseBizType", String.valueOf(r2.intValue())));
    L6:
        r1.putAll(r3);
        String r5 = r22.b;
        String r6 = r22.a;
        if (r23 == null) goto L9;
        long r7 = r23.longValue();
    L13:
        String r4 = com.larus.drive.sdk.impl.utils.m.a(r22.f);
        Context r9 = getContext();
        if (r9 == null) goto L20;
        String r11 = r9.getString(2131905307);
        if (r11 == null) goto L20;
        String r10 = StringsKt.replace$default(r11, "%s", r4, false, 4, null);
        if (r10 == null) goto L20;
    L21:
        int r12 = r22.h;
        int r8 = d.a[r22.j.ordinal()];
        if (r8 != 6) goto L24;
        FlowDriveFileType r13 = FlowDriveFileType.AUDIO;
    L32:
        return new com.larus.platform.api.u(r5, r6, r7, r10, r12, r13, r22.e, r22.d, r22.f, r22.g, r22.i, r22.k, r1);
    L24:
        if (r8 != 7) goto L26;
        r13 = FlowDriveFileType.IMAGE;
        goto L32
    L26:
        if (r8 == 8) goto L28;
        r13 = FlowDriveFileType.FILE;
        goto L32
    L28:
        r13 = FlowDriveFileType.VIDEO;
    L20:
        r10 = r4;
        goto L21
    L9:
        Long r14 = this.o.get(r5);
        if (r14 == null) goto L12;
        r7 = r14.longValue();
        goto L13
    L12:
        r7 = r22.e();
        goto L13
    L5:
        r3 = MapsKt.emptyMap();
        goto L6
    }

    public final void ba0(IChatFileSelectionStore.a r9, FlowDriveFileType r10) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("toastReject: incomingType=");
        r2.append(r10);
        r2.append(", reason=");
        boolean r3 = r9 instanceof IChatFileSelectionStore.a.d;
        if (r3 == false) goto L9;
        StringBuilder r5 = new StringBuilder("MixedTypeNotSupported(selectedType=");
        IChatFileSelectionStore.a.d r6 = (IChatFileSelectionStore.a.d) r9;
        r5.append(r6.a);
        r5.append(", incomingType=");
        r5.append(r6.b);
        r5.append(')');
        String r4 = r5.toString();
    L20:
        r2.append(r4);
        r2.append(", allowFileTypeList=");
        r2.append(this.h);
        r2.append(", currentSize=");
        r2.append(this.j);
        r2.append(", existingSelectedTypes=");
        r2.append(this.i);
        r1.i("DriveFileSelectDialog", r2.toString());
        if (r3 == false) goto L45;
        IChatFileSelectionStore.a.d r11 = (IChatFileSelectionStore.a.d) r9;
        FlowDriveFileType r12 = r11.a;
        FlowDriveFileType r7 = FlowDriveFileType.VIDEO;
        if (r12 == r7) goto L43;
        FlowDriveFileType r13 = r11.b;
        if (r13 == r7) goto L43;
        FlowDriveFileType r8 = FlowDriveFileType.AUDIO;
        if (r12 == r8) goto L42;
        if (r13 == r8) goto L42;
        FlowDriveFileType r14 = FlowDriveFileType.IMAGE;
        if (r12 == r14) goto L41;
        if (r13 == r14) goto L41;
        FlowDriveFileType r15 = FlowDriveFileType.FILE;
        if (r12 == r15) goto L40;
        if (r13 == r15) goto L40;
        String r16 = r0.getString(2131900750);
    L66:
        if (r16 == null) goto L71;
        t19.s.a.getClass();
        t19.s.t(r0, r16);
        return;
    L71:
        return;
    L40:
        r16 = r0.getString(2131900813);
    L41:
        r16 = r0.getString(2131909178);
    L42:
        r16 = r0.getString(2131909177);
    L43:
        r16 = r0.getString(2131909178);
        goto L66
    L45:
        if ((r9 instanceof IChatFileSelectionStore.a.e) == false) goto L47;
    L65:
        r16 = r0.getString(2131900750);
        goto L66
    L47:
        if (Intrinsics.areEqual(r9, IChatFileSelectionStore.a.b.a) == true) goto L65;
        if ((r9 instanceof IChatFileSelectionStore.a.c) == false) goto L57;
        if (r10 != FlowDriveFileType.IMAGE) goto L54;
        int r17 = 2131907895;
    L55:
        r16 = r0.getString(r17, new Object[]{String.valueOf(((IChatFileSelectionStore.a.c) r9).a)});
        goto L66
    L54:
        r17 = 2131907892;
        goto L55
    L57:
        if ((r9 instanceof IChatFileSelectionStore.a.a) == false) goto L64;
        if (r10 != FlowDriveFileType.IMAGE) goto L61;
        int r18 = 2131907896;
    L62:
        StringBuilder r20 = new StringBuilder();
        long r21 = 1024;
        r20.append((((IChatFileSelectionStore.a.a) r9).a / r21) / r21);
        r20.append("MB");
        r16 = r0.getString(r18, new Object[]{r20.toString()});
        goto L66
    L61:
        r18 = 2131907893;
        goto L62
    L64:
        throw new NoWhenBranchMatchedException();
    L9:
        if ((r9 instanceof IChatFileSelectionStore.a.c) == false) goto L12;
        r4 = "MaxCountReached(maxCount=" + ((IChatFileSelectionStore.a.c) r9).a + ')';
        goto L20
    L12:
        if ((r9 instanceof IChatFileSelectionStore.a.e) == false) goto L15;
        r4 = "TypeNotAllowed(type=" + ((IChatFileSelectionStore.a.e) r9).getType() + ')';
        goto L20
    L15:
        if ((r9 instanceof IChatFileSelectionStore.a.a) == false) goto L18;
        r4 = "FileSizeNotAllowed(maxFileSize=" + ((IChatFileSelectionStore.a.a) r9).a + ')';
        goto L20
    L18:
        if (Intrinsics.areEqual(r9, IChatFileSelectionStore.a.b.a) == false) goto L70;
        r4 = "InvalidExistingSelection";
        goto L20
    L70:
        throw new NoWhenBranchMatchedException();
    }

    public final b ca0(DriveFileItem r5, boolean r6) {
        long r0 = V90(r5);
        com.larus.platform.api.u r7 = aa0(ea0(r5, r0), Long.valueOf(r0));
        if (r6 == false) goto L8;
        IChatFileSelectionStore.a.a r8 = da0(r7, r0);
        if (r8 == null) goto L8;
        return new b(r7, new IChatFileSelectionStore.b.b(r8));
    L8:
        boolean r9 = UploadFilePolicy.a;
        if (UploadFilePolicy.b == false) goto L11;
    L46:
        IChatFileSelectionStore.a.d r1 = null;
    L47:
        if (r1 == null) goto L51;
        return new b(r7, new IChatFileSelectionStore.b.b(r1));
    L51:
        return new b(r7, this.n.b(r7, IChatFileSelectionStore.Source.DRIVE));
    L11:
        if (this.i.isEmpty() == true) goto L46;
        Set<? extends FlowDriveFileType> r10 = this.i;
        boolean r2 = false;
        if ((r10 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r11 = r10.iterator();
    L20:
        if (r11.hasNext() == false) goto L24;
        if (((FlowDriveFileType) r11.next()).isMediaType() == false) goto L20;
        boolean r12 = true;
    L25:
        Set<? extends FlowDriveFileType> r3 = this.i;
        if ((r3 instanceof Collection) == true) goto L28;
    L30:
        Iterator<T> r4 = r3.iterator();
    L32:
        if (r4.hasNext() == false) goto L36;
        if ((!((FlowDriveFileType) r4.next()).isMediaType()) == false) goto L32;
        r2 = true;
    L36:
        boolean r13 = r7.f.isMediaType();
        if (r13 == false) goto L39;
        if (r2 == false) goto L39;
    L42:
        if (r12 == false) goto L44;
        FlowDriveFileType r14 = FlowDriveFileType.IMAGE;
    L45:
        r1 = new IChatFileSelectionStore.a.d(r14, r7.f.toMixCategory());
        goto L47
    L44:
        r14 = FlowDriveFileType.FILE;
    L39:
        if (r13 == true) goto L46;
        if (r12 == false) goto L46;
    L28:
        if (r3.isEmpty() == false) goto L30;
    L24:
        r12 = false;
        goto L25
    L16:
        if (r10.isEmpty() == false) goto L18;
        goto L18
    }

    public final IChatFileSelectionStore.a.a da0(com.larus.platform.api.u r5, long r6) {
        int r0 = bq9.a.a;
        Map r1 = r5.m;
        if (r1 == null) goto L5;
        String r2 = (String) r1.get("originFileTypeString");
    L7:
        if (l1.k(r2) == false) goto L10;
        return null;
    L10:
        if (r5.f != FlowDriveFileType.IMAGE) goto L18;
        if (r6 <= 0) goto L16;
        if (r6 <= ((Number) this.e.getValue()).longValue()) goto L18;
    L16:
        return new IChatFileSelectionStore.a.a(((Number) this.e.getValue()).longValue());
    L18:
        if (UploadFilePolicy.f(r6) == false) goto L20;
        return null;
    L20:
        return new IChatFileSelectionStore.a.a(UploadFilePolicy.d());
    L5:
        r2 = null;
        goto L7
    }

    public static final Object S90(DriveFileSelectDialog r6, DriveFileItem r7, Continuation r8) {
        r6.getClass();
        return r6.Y90(r7.b, r7.d, r7.e(), r8);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00a5 -> B:31:0x00aa). Please report as a decompilation issue!!! */
    public static final Object T90(DriveFileSelectDialog r13, List r14, Continuation r15) {
        r13.getClass();
        if ((r15 instanceof DriveFileSelectDialog$resolveSelectedDriveFileSizes$1) == false) goto L7;
        DriveFileSelectDialog$resolveSelectedDriveFileSizes$1 r0 = (DriveFileSelectDialog$resolveSelectedDriveFileSizes$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        com.larus.platform.api.u r17 = (com.larus.platform.api.u) r0.L$3;
        Iterator r4 = (Iterator) r0.L$2;
        List r5 = (List) r0.L$1;
        List r6 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L31:
        long r7 = ((Number) r16).longValue();
        com.larus.platform.api.u r18 = com.larus.platform.api.u.a(r17, r7, null, 8187);
        IChatFileSelectionStore.a.a r110 = r13.da0(r18, r7);
        if (r110 != null) goto L45;
        r5.add(r18);
        List r111 = r5;
        r14 = r6;
    L16:
        if (r4.hasNext() == false) goto L36;
        com.larus.platform.api.u r11 = (com.larus.platform.api.u) r4.next();
        if (r13.n.e(r11.a) != IChatFileSelectionStore.Source.DRIVE) goto L19;
        int r8 = bq9.a.a;
        Map r9 = r11.m;
        if (r9 == null) goto L23;
        String r10 = (String) r9.get("originFileTypeString");
    L25:
        if (l1.k(r10) == false) goto L27;
        r111.add(r11);
        goto L16
    L27:
        String r12 = r11.a;
        int r20 = r11.h;
        long r21 = r11.c;
        r0.L$0 = r14;
        r0.L$1 = r111;
        r0.L$2 = r4;
        r0.L$3 = r11;
        r0.label = 1;
        Object r22 = r13.Y90(r12, r20, r21, r0);
        if (r22 == r2) goto L46;
        r6 = r14;
        r17 = r11;
        r5 = r111;
        r16 = r22;
        goto L31
    L46:
        return r2;
    L23:
        r10 = null;
        goto L25
    L19:
        r111.add(r11);
        goto L16
    L36:
        return new c(r111, null, FlowDriveFileType.FILE);
    L45:
        return new c(r6, r110, r18.f);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r111 = new ArrayList();
        r4 = r14.iterator();
    L7:
        r0 = new DriveFileSelectDialog$resolveSelectedDriveFileSizes$1(r13, r15);
        goto L8
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        ConstraintLayout r1 = r17.inflate(2131562063, r18, false);
        int r2 = 2131370260;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r1, 2131370260);
        if (r7 == null) goto L80;
        r2 = 2131370261;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r1, 2131370261);
        if (r8 == null) goto L80;
        r2 = 2131370262;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131370262);
        if (r9 == null) goto L80;
        r2 = 2131370263;
        View r10 = ViewBindings.findChildViewById(r1, 2131370263);
        if (r10 == null) goto L80;
        r2 = 2131370264;
        ConstraintLayout r11 = ViewBindings.findChildViewById(r1, 2131370264);
        if (r11 == null) goto L80;
        r2 = 2131370265;
        ChatFileSelectorView r12 = (ChatFileSelectorView) ViewBindings.findChildViewById(r1, 2131370265);
        if (r12 == null) goto L80;
        r2 = 2131370266;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r1, 2131370266);
        if (r13 == null) goto L80;
        r2 = 2131370267;
        if (ViewBindings.findChildViewById(r1, 2131370267) == null) goto L80;
        r2 = 2131370290;
        View r14 = ViewBindings.findChildViewById(r1, 2131370290);
        if (r14 == null) goto L80;
        this.f = new LarusDialogDriveFileSelectBinding(r1, r7, r8, r9, r10, r11, r12, r13, r14);
        Dialog r3 = getDialog();
        if (r3 == null) goto L25;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L25;
        r4.setBackgroundDrawable(new ColorDrawable(0));
        WindowCompat.setDecorFitsSystemWindows(r4, false);
    L25:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L28;
        int r6 = com.larus.utils.u.c(r5);
    L29:
        LarusDialogDriveFileSelectBinding r15 = this.f;
        if (r15 == null) goto L34;
        ConstraintLayout r16 = r15.f;
        if (r16 == null) goto L34;
        r16.setPadding(0, r6, 0, 0);
    L34:
        LarusDialogDriveFileSelectBinding r20 = this.f;
        if (r20 == null) goto L39;
        TextView r21 = r20.h;
        if (r21 == null) goto L39;
        r21.setText(this.g);
    L39:
        LarusDialogDriveFileSelectBinding r22 = this.f;
        if (r22 == null) goto L44;
        ImageView r23 = r22.c;
        if (r23 == null) goto L44;
        e1.d(r23, new p(this));
    L44:
        LarusDialogDriveFileSelectBinding r24 = this.f;
        if (r24 == null) goto L49;
        ImageView r25 = r24.b;
        if (r25 == null) goto L49;
        e1.d(r25, new q(this));
    L49:
        IChatFileSelectionStore r26 = this.n;
        List<? extends FlowDriveFileType> r27 = this.h;
        if (r27 == null) goto L52;
        Set r28 = CollectionsKt.toSet(r27);
    L53:
        int r30 = this.j;
        ImFileUtil.a.getClass();
        r26.d(new aq9.f(r28, r30, ImFileUtil.k(), ImFileUtil.n(), ImFileUtil.l()));
        LarusDialogDriveFileSelectBinding r31 = this.f;
        if (r31 == null) goto L58;
        ChatFileSelectorView r32 = r31.g;
        if (r32 == null) goto L58;
        r32.a(new ChatFileSelectorView.b(getTag(), this.n.snapshot(), new DriveFileSelectDialog$initFileSelector$1(this)));
    L58:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DriveFileSelectDialog$initFileSelector$2(this, null), 3, null);
        FragmentActivity r33 = getActivity();
        if (r33 == null) goto L75;
        LarusDialogDriveFileSelectBinding r34 = this.f;
        if (r34 == null) goto L75;
        FrameLayout r35 = r34.d;
        if (r35 == null) goto L75;
        IDriveSdkService r36 = (IDriveSdkService) ServiceManager.get().getService(IDriveSdkService.class);
        if (r36 == null) goto L73;
        DrivePickerScene r37 = DrivePickerScene.FILE_SELECTOR;
        DriveFileSelectDialog$pickerCallback$2$1 r38 = (DriveFileSelectDialog$pickerCallback$2$1) this.q.getValue();
        List r40 = this.n.snapshot();
        ArrayList r41 = new ArrayList();
        Iterator r42 = r40.iterator();
    L70:
        if (r42.hasNext() == false) goto L72;
        r41.add(Z90((com.larus.platform.api.u) r42.next()));
        goto L70
    L72:
        w79.b r43 = r36.A(r37, r33, r35, r38, r41);
    L74:
        this.r = r43;
        goto L75
    L73:
        r43 = null;
    L75:
        LarusDialogDriveFileSelectBinding r44 = this.f;
        if (r44 != null) goto L78;
        return null;
    L78:
        return r44.a;
    L52:
        r28 = null;
        goto L53
    L28:
        r6 = 0;
    L80:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }

    public final Object Y90(String r10, int r11, long r12, Continuation<? super Long> r14) {
        if ((r14 instanceof DriveFileSelectDialog$resolveDriveFileSize$2) == false) goto L7;
        DriveFileSelectDialog$resolveDriveFileSize$2 r0 = (DriveFileSelectDialog$resolveDriveFileSize$2) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L35:
        DriveFileItem r16 = (DriveFileItem) r15;
        if (r16 == null) goto L38;
        long r13 = r16.e();
    L40:
        if (r13 <= 0) goto L43;
        this.o.put(r10, Boxing.boxLong(r13));
    L43:
        return Boxing.boxLong(r13);
    L38:
        r13 = 0;
        goto L40
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        Long r17 = this.o.get(r10);
        if (r17 == null) goto L27;
        if (r17.longValue() <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == true) goto L23;
        r17 = null;
    L23:
        if (r17 == null) goto L27;
        return Boxing.boxLong(r17.longValue());
    L19:
        r6 = false;
    L27:
        if (r12 <= 0) goto L30;
        this.o.put(r10, Boxing.boxLong(r12));
        return Boxing.boxLong(r12);
    L30:
        Reflection.getOrCreateKotlinClass(IDriveSdkService.class);
        IDriveSdkService r18 = (IDriveSdkService) ServiceManager.get().getService(IDriveSdkService.class);
        if (r18 == null) goto L38;
        r0.L$0 = r10;
        r0.label = 1;
        r15 = r18.b(r10, r11, false, r0);
        if (r15 != r2) goto L35;
        return r2;
    L7:
        r0 = new DriveFileSelectDialog$resolveDriveFileSize$2(this, r14);
        goto L8
    }
}
