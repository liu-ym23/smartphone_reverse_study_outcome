package com.obric.memorydata.ui.larus.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Size;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.d.c;
import com.obric.memorydata.larus_ui.databinding.LarusDialogCommonBinding;
import com.obric.memorydata.larus_ui.databinding.LarusDialogCommonShadowBinding;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u000209H\u0016J$\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u001a\u0010B\u001a\u0002092\u0006\u0010C\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010D\u001a\u000209H\u0002J\u0018\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0010J\b\u0010I\u001a\u000209H\u0002J\b\u0010J\u001a\u000209H\u0002J\u0010\u0010K\u001a\u0002092\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u0002092\u0006\u0010L\u001a\u00020MH\u0016J\b\u0010O\u001a\u000209H\u0002J\u0018\u0010P\u001a\u0002092\u0006\u0010C\u001a\u0002072\u0006\u0010Q\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0004\n\u0002\u00104R\u000e\u00105\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/obric/memorydata/ui/larus/dialog/LarusCommonDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/larus_ui/databinding/LarusDialogCommonBinding;", "mTitle", "", "mShowMessage", "", "mMessage", "mMessageColor", "", "Ljava/lang/Integer;", "mMessageGravity", "mConfirmText", "", "mConfirmTextColor", "mConfirmBold", "mCancelBold", "mConfirmClickListener", "Lcom/dialog/ConfirmClickListener;", "getMConfirmClickListener", "()Lcom/dialog/ConfirmClickListener;", "setMConfirmClickListener", "(Lcom/dialog/ConfirmClickListener;)V", "mEarlyConfirmClickListener", "getMEarlyConfirmClickListener", "setMEarlyConfirmClickListener", "mCancelText", "mCancelClickListener", "Lcom/dialog/CancelClickListener;", "mWhiteClickListener", "Lcom/dialog/WhiteClickListener;", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mButtonTrim", "mCanceledOnTouchOutside", "backListener", "Lkotlin/Function0;", "mMessageTestStyle", "Lcom/obric/memorydata/ui/larus/dialog/CommonDialogTextStyleConfig;", "mConfirmTextStyle", "mCancelTextStyle", "needSetWindowTransparent", "useShadow", "mTopImageUrl", "Landroid/net/Uri;", "mTopImageSize", "Landroid/util/Size;", "mTopImageRadius", "", "Ljava/lang/Float;", "needResumeVisible", "dialogView", "Landroid/view/View;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setUpMessageTextStyle", "showAllowingStateLoss", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", LocationMonitorConst.TAG, "setUpConfirmTextStyle", "setUpCancelTextStyle", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "setupView", "updateBottomButtonVisibility", "visibility", "Builder", "larus_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LarusCommonDialog extends DialogFragment {
    private Function0<Boolean> backListener;
    private LarusDialogCommonBinding binding;
    private View dialogView;
    private boolean mButtonTrim;
    private boolean mCancelBold;
    private com.d.a mCancelClickListener;
    private String mCancelText;
    private com.obric.memorydata.ui.larus.dialog.a mCancelTextStyle;
    private boolean mCanceledOnTouchOutside;
    private boolean mConfirmBold;
    private com.d.b mConfirmClickListener;
    private String mConfirmText;
    private int mConfirmTextColor;
    private com.obric.memorydata.ui.larus.dialog.a mConfirmTextStyle;
    private com.d.b mEarlyConfirmClickListener;
    private CharSequence mMessage;
    private Integer mMessageColor;
    private Integer mMessageGravity;
    private com.obric.memorydata.ui.larus.dialog.a mMessageTestStyle;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShowMessage;
    private CharSequence mTitle;
    private Float mTopImageRadius;
    private Size mTopImageSize;
    private Uri mTopImageUrl;
    private c mWhiteClickListener;
    private boolean needResumeVisible;
    private boolean needSetWindowTransparent;
    private boolean useShadow;

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b-\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020.J\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u0012J\u000e\u00104\u001a\u00020.2\u0006\u00103\u001a\u00020\u0012J\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020(J\u000e\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u00020(J\u000e\u0010:\u001a\u00020\u00002\u0006\u00108\u001a\u00020(J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0005J\u0010\u0010=\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\rJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\tJ\u000e\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u0000J\u000e\u0010E\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0012J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0012J$\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u00192\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010K\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0016J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0007J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u0007J\u001a\u0010Q\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u001e2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0016J\u000e\u0010S\u001a\u00020\u00002\u0006\u0010I\u001a\u00020 J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010I\u001a\u00020#J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\u0007J\u0014\u0010Y\u001a\u00020\u00002\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00070&R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/obric/memorydata/ui/larus/dialog/LarusCommonDialog$Builder;", "", "<init>", "()V", "mTitle", "", "mShowMessage", "", "mTopImageRadius", "", "Ljava/lang/Float;", "needResumeVisible", "mTopImageUrl", "Landroid/net/Uri;", "mTopImageSize", "Landroid/util/Size;", "mMessage", "mMessageColor", "", "Ljava/lang/Integer;", "mMessageGravity", "mConfirmText", "", "mConfirmBold", "mConfirmClickListener", "Lcom/dialog/ConfirmClickListener;", "mEarlyConfirmClickListener", "mCancelText", "mCancelBold", "mCancelClickListener", "Lcom/dialog/CancelClickListener;", "mWhiteClickListener", "Lcom/dialog/WhiteClickListener;", "mButtonTrim", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mCanceledOnTouchOutside", "backListener", "Lkotlin/Function0;", "mMessageTestStyle", "Lcom/obric/memorydata/ui/larus/dialog/CommonDialogTextStyleConfig;", "mConfirmTextStyle", "mCancelTextStyle", "needSetWindowTransparent", "useShadow", "build", "Lcom/obric/memorydata/ui/larus/dialog/LarusCommonDialog;", "buildNoMessage", "setNeedResumeVisible", "setmShowMessage", "buildInfoWithColor", TypedValues.Custom.S_COLOR, "buildNoMessageInfoWithColor", "setTitle", "title", "setMessageTextStyle", "commonDialogTextStyleConfig", "setConfirmTextStyle", "setCancelTextStyle", "setMessage", "message", "setTopImageUrl", "uri", "setTopImageRadius", "radius", "setTopImageSize", "size", "setWindowTransparent", "windowTransparent", "setMessageColor", "setMessageGravity", "gravity", "setConfirmButton", "listener", "confirmText", "isEarlyListener", "setConfirmText", "setConfirmBold", "confirmBold", "setCancelBold", "cancelBold", "setCancelButton", "cancelText", "setWhiteClickListener", "setButtonTrim", "trim", "setOnDismissListener", "setCanceledOnTouchOutside", "canceled", "setBackListener", "callback", "larus_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f13012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13013b;
        private Float c;
        private boolean d;
        private Uri e;
        private Size f;
        private CharSequence g;
        private Integer h;
        private Integer i;
        private String j;
        private boolean k;
        private com.d.b l;
        private com.d.b m;
        private String n;
        private boolean o;
        private com.d.a p;
        private c q;
        private boolean r;
        private DialogInterface.OnDismissListener s;
        private boolean t;
        private Function0<Boolean> u;
        private com.obric.memorydata.ui.larus.dialog.a v;
        private com.obric.memorydata.ui.larus.dialog.a w;
        private com.obric.memorydata.ui.larus.dialog.a x;
        private boolean y;
        private boolean z;

        public a() {
            this.f13013b = true;
            this.i = 1;
            this.t = true;
            this.y = true;
        }

        public static /* synthetic */ a a(a r1, com.d.b r2, String r3, boolean r4, int r5, Object r6) {
            com.d.b r7 = (com.d.b) ZeusTransformUtils.wrapperContextForParams(r2, com.d.b.class, "com.obric.memorydata.plugin");
            if ((r5 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L9;
            r4 = false;
        L9:
            return r1.a(r7, r3, r4);
        }

        public final a a(int r1) {
            this.i = Integer.valueOf(r1);
            return this;
        }

        public final a a(com.d.a r3, String r4) {
            com.d.a r5 = (com.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.d.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "listener");
            this.n = r4;
            this.p = r5;
            return this;
        }

        public final a a(com.d.b r3, String r4, boolean r5) {
            com.d.b r6 = (com.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.d.b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "listener");
            this.j = r4;
            if (r5 == false) goto L5;
            this.m = r6;
        L6:
            return this;
        L5:
            this.l = r6;
            goto L6
        }

        public final a a(com.obric.memorydata.ui.larus.dialog.a r2) {
            Intrinsics.checkNotNullParameter(r2, "commonDialogTextStyleConfig");
            this.w = r2;
            return this;
        }

        public final a a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "title");
            this.f13012a = r4;
            return this;
        }

        public final a a(boolean r1) {
            this.t = r1;
            return this;
        }

        public final LarusCommonDialog a() {
            LarusCommonDialog r0 = new LarusCommonDialog();
            LarusCommonDialog.access$setMTitle$p(r0, this.f13012a);
            LarusCommonDialog.access$setMMessage$p(r0, this.g);
            LarusCommonDialog.access$setMMessageColor$p(r0, this.h);
            LarusCommonDialog.access$setMMessageGravity$p(r0, this.i);
            LarusCommonDialog.access$setMConfirmText$p(r0, this.j);
            r0.setMConfirmClickListener(this.l);
            r0.setMEarlyConfirmClickListener(this.m);
            LarusCommonDialog.access$setMConfirmBold$p(r0, this.k);
            LarusCommonDialog.access$setMCancelBold$p(r0, this.o);
            LarusCommonDialog.access$setMCancelText$p(r0, this.n);
            LarusCommonDialog.access$setMCancelClickListener$p(r0, this.p);
            LarusCommonDialog.access$setMWhiteClickListener$p(r0, this.q);
            LarusCommonDialog.access$setMButtonTrim$p(r0, this.r);
            LarusCommonDialog.access$setMOnDismissListener$p(r0, this.s);
            LarusCommonDialog.access$setMCanceledOnTouchOutside$p(r0, this.t);
            LarusCommonDialog.access$setBackListener$p(r0, this.u);
            LarusCommonDialog.access$setMMessageTestStyle$p(r0, this.v);
            LarusCommonDialog.access$setMConfirmTextStyle$p(r0, this.w);
            LarusCommonDialog.access$setMCancelTextStyle$p(r0, this.x);
            LarusCommonDialog.access$setNeedSetWindowTransparent$p(r0, this.y);
            LarusCommonDialog.access$setUseShadow$p(r0, this.z);
            LarusCommonDialog.access$setMTopImageUrl$p(r0, this.e);
            LarusCommonDialog.access$setMTopImageSize$p(r0, this.f);
            LarusCommonDialog.access$setMTopImageRadius$p(r0, this.c);
            LarusCommonDialog.access$setNeedResumeVisible$p(r0, this.d);
            LarusCommonDialog.access$setMShowMessage$p(r0, this.f13013b);
            return r0;
        }

        public final a b(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "message");
            this.g = r4;
            return this;
        }
    }

    public LarusCommonDialog() {
        this.mTitle = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        this.mShowMessage = true;
        this.mMessage = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        this.mMessageGravity = 1;
        this.mCanceledOnTouchOutside = true;
        this.needSetWindowTransparent = true;
    }

    public static final /* synthetic */ void access$setBackListener$p(LarusCommonDialog r2, Function0 r3) {
        r2.backListener = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setMButtonTrim$p(LarusCommonDialog r0, boolean r1) {
        r0.mButtonTrim = r1;
    }

    public static final /* synthetic */ void access$setMCancelBold$p(LarusCommonDialog r0, boolean r1) {
        r0.mCancelBold = r1;
    }

    public static final /* synthetic */ void access$setMCancelClickListener$p(LarusCommonDialog r2, com.d.a r3) {
        r2.mCancelClickListener = (com.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.d.a.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setMCancelText$p(LarusCommonDialog r0, String r1) {
        r0.mCancelText = r1;
    }

    public static final /* synthetic */ void access$setMCancelTextStyle$p(LarusCommonDialog r0, com.obric.memorydata.ui.larus.dialog.a r1) {
        r0.mCancelTextStyle = r1;
    }

    public static final /* synthetic */ void access$setMCanceledOnTouchOutside$p(LarusCommonDialog r0, boolean r1) {
        r0.mCanceledOnTouchOutside = r1;
    }

    public static final /* synthetic */ void access$setMConfirmBold$p(LarusCommonDialog r0, boolean r1) {
        r0.mConfirmBold = r1;
    }

    public static final /* synthetic */ void access$setMConfirmText$p(LarusCommonDialog r0, String r1) {
        r0.mConfirmText = r1;
    }

    public static final /* synthetic */ void access$setMConfirmTextColor$p(LarusCommonDialog r0, int r1) {
        r0.mConfirmTextColor = r1;
    }

    public static final /* synthetic */ void access$setMConfirmTextStyle$p(LarusCommonDialog r0, com.obric.memorydata.ui.larus.dialog.a r1) {
        r0.mConfirmTextStyle = r1;
    }

    public static final /* synthetic */ void access$setMMessage$p(LarusCommonDialog r2, CharSequence r3) {
        r2.mMessage = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setMMessageColor$p(LarusCommonDialog r0, Integer r1) {
        r0.mMessageColor = r1;
    }

    public static final /* synthetic */ void access$setMMessageGravity$p(LarusCommonDialog r0, Integer r1) {
        r0.mMessageGravity = r1;
    }

    public static final /* synthetic */ void access$setMMessageTestStyle$p(LarusCommonDialog r0, com.obric.memorydata.ui.larus.dialog.a r1) {
        r0.mMessageTestStyle = r1;
    }

    public static final /* synthetic */ void access$setMOnDismissListener$p(LarusCommonDialog r2, DialogInterface.OnDismissListener r3) {
        r2.mOnDismissListener = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setMShowMessage$p(LarusCommonDialog r0, boolean r1) {
        r0.mShowMessage = r1;
    }

    public static final /* synthetic */ void access$setMTitle$p(LarusCommonDialog r2, CharSequence r3) {
        r2.mTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setMTopImageRadius$p(LarusCommonDialog r0, Float r1) {
        r0.mTopImageRadius = r1;
    }

    public static final /* synthetic */ void access$setMTopImageSize$p(LarusCommonDialog r0, Size r1) {
        r0.mTopImageSize = r1;
    }

    public static final /* synthetic */ void access$setMTopImageUrl$p(LarusCommonDialog r0, Uri r1) {
        r0.mTopImageUrl = r1;
    }

    public static final /* synthetic */ void access$setMWhiteClickListener$p(LarusCommonDialog r2, c r3) {
        r2.mWhiteClickListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setNeedResumeVisible$p(LarusCommonDialog r0, boolean r1) {
        r0.needResumeVisible = r1;
    }

    public static final /* synthetic */ void access$setNeedSetWindowTransparent$p(LarusCommonDialog r0, boolean r1) {
        r0.needSetWindowTransparent = r1;
    }

    public static final /* synthetic */ void access$setUseShadow$p(LarusCommonDialog r0, boolean r1) {
        r0.useShadow = r1;
    }

    /* JADX INFO: renamed from: lambda$SwBFYf-apbjQWs1dBz4ea_7m9wA, reason: not valid java name */
    public static /* synthetic */ boolean m1220lambda$SwBFYfapbjQWs1dBz4ea_7m9wA(LarusCommonDialog r0, View r1, MotionEvent r2) {
        return onViewCreated$lambda$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Wqo3bqY-rfll-shoRdo0to_FcGc, reason: not valid java name */
    public static /* synthetic */ boolean m1221lambda$Wqo3bqYrfllshoRdo0to_FcGc(Function0 r0, DialogInterface r1, int r2, KeyEvent r3) {
        return onResume$lambda$2$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$cOurfFKn1NgNwYnpKQc2WBd0DLo(LarusCommonDialog r0, View r1) {
        setupView$lambda$22(r0, r1);
    }

    public static /* synthetic */ void lambda$jrAuhENI1HuuPPtyMUGembcwNv8(LarusCommonDialog r0, View r1) {
        setupView$lambda$21(r0, r1);
    }

    private static final boolean onResume$lambda$2$lambda$1(Function0 r2, DialogInterface r3, int r4, KeyEvent r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        DialogInterface r7 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r5.getAction() == 1) goto L5;
        return false;
    L5:
        if (r4 == 4) goto L7;
        return false;
    L7:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static final boolean onViewCreated$lambda$5(LarusCommonDialog r0, View r1, MotionEvent r2) {
        if (r2.getAction() != 0) goto L9;
        c r3 = r0.mWhiteClickListener;
        if (r3 == null) goto L10;
        r3.a();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    private final void setUpCancelTextStyle() {
        com.obric.memorydata.ui.larus.dialog.a r0 = this.mCancelTextStyle;
        if (r0 == null) goto L24;
        Integer r1 = r0.a();
        LarusDialogCommonBinding r3 = null;
        if (r1 == null) goto L10;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue();
        LarusDialogCommonBinding r5 = this.binding;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L9:
        r5.cancel.setTextSize(r2);
    L10:
        Integer r4 = r0.b();
        if (r4 == null) goto L16;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        LarusDialogCommonBinding r7 = this.binding;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L15:
        r7.cancel.setTextColor(r6);
    L16:
        Typeface r8 = r0.c();
        if (r8 == null) goto L25;
        LarusDialogCommonBinding r9 = this.binding;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r3.cancel.setTypeface(r8);
        return;
    L21:
        r3 = r9;
        goto L22
    L25:
        return;
    }

    private final void setUpConfirmTextStyle() {
        com.obric.memorydata.ui.larus.dialog.a r0 = this.mConfirmTextStyle;
        if (r0 == null) goto L24;
        Integer r1 = r0.a();
        LarusDialogCommonBinding r3 = null;
        if (r1 == null) goto L10;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue();
        LarusDialogCommonBinding r5 = this.binding;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L9:
        r5.confirm.setTextSize(r2);
    L10:
        Integer r4 = r0.b();
        if (r4 == null) goto L16;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        LarusDialogCommonBinding r7 = this.binding;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L15:
        r7.confirm.setTextColor(r6);
    L16:
        Typeface r8 = r0.c();
        if (r8 == null) goto L25;
        LarusDialogCommonBinding r9 = this.binding;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r3.confirm.setTypeface(r8);
        return;
    L21:
        r3 = r9;
        goto L22
    L25:
        return;
    }

    private final void setUpMessageTextStyle() {
        com.obric.memorydata.ui.larus.dialog.a r0 = this.mMessageTestStyle;
        if (r0 == null) goto L24;
        Integer r1 = r0.a();
        LarusDialogCommonBinding r3 = null;
        if (r1 == null) goto L10;
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue();
        LarusDialogCommonBinding r5 = this.binding;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L9:
        r5.dialogMessage.setTextSize(r2);
    L10:
        Integer r4 = r0.b();
        if (r4 == null) goto L16;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
        LarusDialogCommonBinding r7 = this.binding;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L15:
        r7.dialogMessage.setTextColor(r6);
    L16:
        Typeface r8 = r0.c();
        if (r8 == null) goto L25;
        LarusDialogCommonBinding r9 = this.binding;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L22:
        r3.dialogMessage.setTypeface(r8);
        return;
    L21:
        r3 = r9;
        goto L22
    L25:
        return;
    }

    private final void setupView() {
        LarusDialogCommonBinding r0 = this.binding;
        LarusDialogCommonBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.dialogTitle.setText(this.mTitle);
        LarusDialogCommonBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        TextView r3 = r2.dialogMessage;
        boolean r5 = false;
        if (this.mShowMessage == false) goto L11;
        int r4 = 0;
    L12:
        r3.setVisibility(r4);
        LarusDialogCommonBinding r6 = this.binding;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L15:
        r6.dialogMessage.setText(this.mMessage);
        CharSequence r7 = this.mTitle;
        if (r7 != null) goto L18;
    L21:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L32;
        LarusDialogCommonBinding r9 = this.binding;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L27:
        r9.dialogTitle.setVisibility(8);
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, -2);
        r10.topMargin = b.a((Number) ZeusTransformUtils.preCheckCast(24, Number.class, "com.obric.memorydata.plugin"));
        r10.leftMargin = b.a((Number) ZeusTransformUtils.preCheckCast(20, Number.class, "com.obric.memorydata.plugin"));
        r10.rightMargin = b.a((Number) ZeusTransformUtils.preCheckCast(20, Number.class, "com.obric.memorydata.plugin"));
        LarusDialogCommonBinding r11 = this.binding;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L30:
        r11.dialogMessage.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L32:
        if (ZeusTransformUtils.instanceOf(this.mMessage, SpannableString.class) == false) goto L40;
        LarusDialogCommonBinding r12 = this.binding;
        if (r12 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L36:
        r12.dialogMessage.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogCommonBinding r13 = this.binding;
        if (r13 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L39:
        r13.dialogMessage.setHighlightColor(0);
    L40:
        Integer r14 = this.mMessageColor;
        if (r14 == null) goto L46;
        int r15 = ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).intValue();
        LarusDialogCommonBinding r16 = this.binding;
        if (r16 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L45:
        r16.dialogMessage.setTextColor(r15);
    L46:
        Integer r17 = this.mMessageGravity;
        if (r17 == null) goto L52;
        int r18 = ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).intValue();
        LarusDialogCommonBinding r19 = this.binding;
        if (r19 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L51:
        r19.dialogMessage.setGravity(r18);
    L52:
        CharSequence r20 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mConfirmText, CharSequence.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L55;
    L58:
        boolean r21 = true;
    L59:
        if (r21 == true) goto L65;
        LarusDialogCommonBinding r22 = this.binding;
        if (r22 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L63:
        r22.confirm.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.mConfirmText, CharSequence.class, "com.obric.memorydata.plugin"));
    L65:
        if (this.mConfirmTextColor != 0) goto L72;
        Context r23 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L77;
        LarusDialogCommonBinding r24 = this.binding;
        if (r24 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L71:
        r24.confirm.setTextColor(ContextCompat.getColor(r23, ZeusTransformUtils.mapRes(R.color.larus_danger_50, TypedValues.Custom.S_COLOR, "larus_danger_50")));
    L77:
        if (this.mConfirmBold == false) goto L83;
        LarusDialogCommonBinding r25 = this.binding;
        if (r25 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L81:
        r25.confirm.setTypeface(Typeface.DEFAULT_BOLD);
    L83:
        if (this.mCancelBold == false) goto L88;
        LarusDialogCommonBinding r26 = this.binding;
        if (r26 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L87:
        r26.cancel.setTypeface(Typeface.DEFAULT_BOLD);
    L88:
        LarusDialogCommonBinding r27 = this.binding;
        if (r27 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L91:
        r27.confirm.setOnClickListener(new $$Lambda$LarusCommonDialog$jrAuhENI1HuuPPtyMUGembcwNv8(this));
        if (this.mCancelClickListener != null) goto L97;
        LarusDialogCommonBinding r28 = this.binding;
        if (r28 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L96:
        TextView r29 = r28.cancel;
        Intrinsics.checkNotNullExpressionValue(r29, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        updateBottomButtonVisibility((View) ZeusTransformUtils.preCheckCast(r29, View.class, "com.obric.memorydata.plugin"), 8);
    L114:
        if (this.mButtonTrim == false) goto L154;
        CharSequence r30 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mConfirmText, CharSequence.class, "com.obric.memorydata.plugin");
        if (r30 != null) goto L118;
    L121:
        boolean r31 = true;
    L122:
        if (r31 == true) goto L131;
        CharSequence r32 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mCancelText, CharSequence.class, "com.obric.memorydata.plugin");
        if (r32 != null) goto L126;
    L129:
        boolean r33 = true;
    L130:
        if (r33 == false) goto L154;
    L126:
        if (r32.length() == 0) goto L129;
        r33 = false;
    L131:
        CharSequence r34 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mConfirmText, CharSequence.class, "com.obric.memorydata.plugin");
        if (r34 != null) goto L134;
    L137:
        boolean r35 = true;
    L138:
        if (r35 == false) goto L143;
        LarusDialogCommonBinding r36 = this.binding;
        if (r36 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r36 = null;
    L142:
        TextView r37 = r36.confirm;
        Intrinsics.checkNotNullExpressionValue(r37, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM);
        updateBottomButtonVisibility((View) ZeusTransformUtils.preCheckCast(r37, View.class, "com.obric.memorydata.plugin"), 8);
    L143:
        CharSequence r38 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mCancelText, CharSequence.class, "com.obric.memorydata.plugin");
        if (r38 != null) goto L146;
    L147:
        r5 = true;
    L148:
        if (r5 == false) goto L154;
        LarusDialogCommonBinding r39 = this.binding;
        if (r39 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L153:
        TextView r40 = r1.cancel;
        Intrinsics.checkNotNullExpressionValue(r40, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL);
        updateBottomButtonVisibility((View) ZeusTransformUtils.preCheckCast(r40, View.class, "com.obric.memorydata.plugin"), 8);
        goto L154
    L152:
        r1 = r39;
        goto L153
    L146:
        if (r38.length() != 0) goto L148;
    L134:
        if (r34.length() == 0) goto L137;
        r35 = false;
        goto L138
    L118:
        if (r30.length() == 0) goto L121;
        r31 = false;
    L154:
        setUpMessageTextStyle();
        setUpConfirmTextStyle();
        setUpCancelTextStyle();
        return;
    L97:
        CharSequence r41 = (CharSequence) ZeusTransformUtils.preCheckCast(this.mCancelText, CharSequence.class, "com.obric.memorydata.plugin");
        if (r41 != null) goto L100;
    L103:
        boolean r42 = true;
    L104:
        if (r42 == true) goto L109;
        LarusDialogCommonBinding r43 = this.binding;
        if (r43 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r43 = null;
    L108:
        r43.cancel.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.mCancelText, CharSequence.class, "com.obric.memorydata.plugin"));
    L109:
        LarusDialogCommonBinding r44 = this.binding;
        if (r44 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r44 = null;
    L112:
        r44.cancel.setOnClickListener(new $$Lambda$LarusCommonDialog$cOurfFKn1NgNwYnpKQc2WBd0DLo(this));
        goto L114
    L100:
        if (r41.length() == 0) goto L103;
        r42 = false;
        goto L104
    L72:
        LarusDialogCommonBinding r45 = this.binding;
        if (r45 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r45 = null;
    L75:
        r45.confirm.setTextColor(this.mConfirmTextColor);
        goto L77
    L55:
        if (r20.length() == 0) goto L58;
        r21 = false;
        goto L59
    L18:
        if (r7.length() == 0) goto L21;
        r8 = false;
        goto L23
    L11:
        r4 = 8;
        goto L12
    }

    private static final void setupView$lambda$21(LarusCommonDialog r0, View r1) {
        com.d.b r2 = r0.mEarlyConfirmClickListener;
        if (r2 == null) goto L5;
        r2.a();
    L5:
        r0.dismissAllowingStateLoss();
        com.d.b r3 = r0.mConfirmClickListener;
        if (r3 == null) goto L9;
        r3.a();
        return;
    }

    private static final void setupView$lambda$22(LarusCommonDialog r0, View r1) {
        r0.dismissAllowingStateLoss();
        com.d.a r2 = r0.mCancelClickListener;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    private final void updateBottomButtonVisibility(View r3, int r4) {
        r3.setVisibility(r4);
        LarusDialogCommonBinding r2 = this.binding;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        String r5 = "larus_bg_down_selector";
        if (r2.confirm.getVisibility() != 8) goto L12;
        r2.divider.setVisibility(8);
        TextView r6 = r2.cancel;
        if (r6 == null) goto L22;
    L9:
        int r7 = R.drawable.larus_bg_down_selector;
    L10:
        r6.setBackgroundResource(ZeusTransformUtils.mapRes(r7, "drawable", r5));
        return;
    L22:
        return;
    L12:
        if (r2.cancel.getVisibility() != 8) goto L16;
        r2.divider.setVisibility(8);
        r6 = r2.confirm;
        if (r6 != null) goto L9;
        return;
    L16:
        r2.divider.setVisibility(0);
        TextView r8 = r2.confirm;
        if (r8 == null) goto L19;
        r8.setBackgroundResource(ZeusTransformUtils.mapRes(R.drawable.larus_bg_leftdown_selector, "drawable", "larus_bg_leftdown_selector"));
    L19:
        r6 = r2.cancel;
        if (r6 == null) goto L25;
        r7 = R.drawable.larus_bg_rightdown_selector;
        r5 = "larus_bg_rightdown_selector";
        goto L10
    }

    public final com.d.b getMConfirmClickListener() {
        return this.mConfirmClickListener;
    }

    public final com.d.b getMEarlyConfirmClickListener() {
        return this.mEarlyConfirmClickListener;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dialog");
        super.onCancel(r4);
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        setStyle(0, ZeusTransformUtils.mapRes(R.style.Theme_LarusOApp_LarusCommonDialog, "style", "Theme_LarusOApp_LarusCommonDialog"));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        if (this.useShadow == false) goto L6;
        LarusDialogCommonShadowBinding r8 = LarusDialogCommonShadowBinding.inflate(r5, r6, false);
        Intrinsics.checkNotNullExpressionValue(r8, "inflate(...)");
        LarusDialogCommonBinding r9 = LarusDialogCommonBinding.bind(r8.getRoot().getChildAt(0));
        Intrinsics.checkNotNullExpressionValue(r9, "bind(...)");
        this.binding = r9;
        Object r10 = r8.getRoot();
    L5:
        Intrinsics.checkNotNullExpressionValue(r10, "getRoot(...)");
        View r11 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin");
        if (this.needSetWindowTransparent == false) goto L17;
        Dialog r12 = getDialog();
        if (r12 == null) goto L24;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L24;
        r13.setBackgroundDrawable((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(0), Drawable.class, "com.obric.memorydata.plugin"));
    L24:
        this.dialogView = r11;
        if (this.needResumeVisible == false) goto L28;
        if (r11 == null) goto L28;
        b.b(r11);
    L28:
        return r11;
    L17:
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L24;
        Dialog r15 = getDialog();
        if (r15 == null) goto L24;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L24;
        r16.setBackgroundDrawable(ContextCompat.getDrawable(r14, ZeusTransformUtils.mapRes(R.drawable.larus_bg_round_full, "drawable", "larus_bg_round_full")));
        goto L24
    L6:
        LarusDialogCommonBinding r17 = LarusDialogCommonBinding.inflate(r5, r6, false);
        Intrinsics.checkNotNullExpressionValue(r17, "inflate(...)");
        this.binding = r17;
        if (r17 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L9:
        r10 = r17.getRoot();
        goto L5
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dialog");
        super.onDismiss(r4);
        DialogInterface.OnDismissListener r2 = this.mOnDismissListener;
        if (r2 == null) goto L6;
        r2.onDismiss(r4);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = ZeusTransformUtils.getResources(r1.getWindowStyle(), "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels - (b.a((Number) ZeusTransformUtils.preCheckCast(48, Number.class, "com.obric.memorydata.plugin")) * 2);
        if (r2.width <= b.a((Number) ZeusTransformUtils.preCheckCast(294, Number.class, "com.obric.memorydata.plugin"))) goto L9;
        r2.width = b.a((Number) ZeusTransformUtils.preCheckCast(294, Number.class, "com.obric.memorydata.plugin"));
    L9:
        r1.setAttributes(r2);
    L11:
        if (this.needResumeVisible == false) goto L15;
        View r3 = this.dialogView;
        if (r3 == null) goto L15;
        b.a(r3);
    L15:
        final Function0<Boolean> r4 = this.backListener;
        if (r4 == null) goto L21;
        Dialog r7 = getDialog();
        if (r7 == null) goto L22;
        r7.setOnKeyListener(new $$Lambda$LarusCommonDialog$Wqo3bqYrfllshoRdo0to_FcGc(r4));
        return;
    L22:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        setupView();
        Dialog r4 = getDialog();
        if (r4 == null) goto L5;
        r4.setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
    L5:
        Dialog r5 = getDialog();
        if (r5 == null) goto L13;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L14;
        View r7 = r6.getDecorView();
        if (r7 == null) goto L15;
        r7.setOnTouchListener(new $$Lambda$LarusCommonDialog$SwBFYfapbjQWs1dBz4ea_7m9wA(this));
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void setMConfirmClickListener(com.d.b r3) {
        this.mConfirmClickListener = (com.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.d.b.class, "com.obric.memorydata.plugin");
    }

    public final void setMEarlyConfirmClickListener(com.d.b r3) {
        this.mEarlyConfirmClickListener = (com.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.d.b.class, "com.obric.memorydata.plugin");
    }

    public final void showAllowingStateLoss(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        FragmentTransaction r5 = r3.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r5, "beginTransaction(...)");
        r5.add((Fragment) ZeusTransformUtils.preCheckCast(this, Fragment.class, "com.obric.memorydata.plugin"), r4);
        r5.commitAllowingStateLoss();
    }
}
