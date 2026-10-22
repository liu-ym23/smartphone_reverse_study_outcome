package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import h18.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u0000 \u008a\u00022\u00020\u0001:\u0004\u008a\u0002\u008b\u0002B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010Ý\u0001\u001a\u00030Þ\u0001\"\u0011\b\u0000\u0010ß\u0001*\n\u0012\u0005\u0012\u0003Hß\u00010à\u00012\u000f\u0010á\u0001\u001a\n\u0012\u0005\u0012\u0003Hß\u00010à\u00012\u0007\u0010â\u0001\u001a\u00020\tH\u0017J\u0013\u0010ã\u0001\u001a\u00030Þ\u00012\u0007\u0010â\u0001\u001a\u00020\tH\u0016J\u001f\u0010ä\u0001\u001a\u00030Þ\u00012\u0007\u0010â\u0001\u001a\u00020\t2\n\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001H\u0016J\n\u0010ç\u0001\u001a\u00030Þ\u0001H\u0017J\n\u0010è\u0001\u001a\u00030Þ\u0001H\u0016J\t\u0010é\u0001\u001a\u00020\u0015H\u0015J\f\u0010ê\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\t\u0010ë\u0001\u001a\u00020\u0015H\u0015J\f\u0010ì\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\t\u0010í\u0001\u001a\u00020\u0015H\u0015J\f\u0010î\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\u0018\u0010ï\u0001\u001a\u00030Þ\u00012\f\u0010á\u0001\u001a\u0007\u0012\u0002\b\u00030à\u0001H\u0002J\t\u0010ð\u0001\u001a\u00020\u0015H\u0015J\f\u0010ñ\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0014J\n\u0010ò\u0001\u001a\u00030Þ\u0001H\u0002J\n\u0010ó\u0001\u001a\u00030ô\u0001H\u0002J\u000e\u0010õ\u0001\u001a\u00030ö\u0001*\u00020RH\u0002J\n\u0010÷\u0001\u001a\u00030Þ\u0001H\u0002J\r\u0010ø\u0001\u001a\u00020\u0015*\u00020RH\u0002J(\u0010ù\u0001\u001a\u00030Þ\u00012\b\u0010ú\u0001\u001a\u00030û\u00012\u0007\u0010ü\u0001\u001a\u00020\u00152\t\b\u0001\u0010ý\u0001\u001a\u00020\u0015H\u0004J8\u0010þ\u0001\u001a\u00030Þ\u00012\b\u0010ÿ\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u0080\u0002\u001a\u00020\u00152\u0007\u0010\u0081\u0002\u001a\u00020\u00152\u0007\u0010\u0082\u0002\u001a\u00020\u00152\u0007\u0010\u0083\u0002\u001a\u00020\u0015H\u0004J.\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0087\u00012\n\u0010ò\u0001\u001a\u0005\u0018\u00010\u0087\u00012\t\b\u0001\u0010\u0085\u0002\u001a\u00020\u00152\t\b\u0001\u0010\u0086\u0002\u001a\u00020\u0015H\u0004J\u001b\u0010\u0087\u0002\u001a\u00020R2\u0007\u0010\u0088\u0002\u001a\u00020R2\u0007\u0010\u0089\u0002\u001a\u00020\u0015H\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00158\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\u001a\u0010'\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001a\u0010*\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\u001a\u0010-\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u001a\u00100\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\u001a\u00103\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001c\u00106\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0011\"\u0004\b8\u0010\u0013R\u001a\u00109\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\u001e\u0010<\u001a\u00020\u00158\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0017\"\u0004\b>\u0010\u0019R\u001a\u0010?\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0017\"\u0004\bA\u0010\u0019R\u001a\u0010B\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0017\"\u0004\bD\u0010\u0019R\u001a\u0010E\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0017\"\u0004\bG\u0010\u0019R\u001a\u0010H\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0017\"\u0004\bJ\u0010\u0019R\u001a\u0010K\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u0019R\u001a\u0010N\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0017\"\u0004\bP\u0010\u0019R\u001a\u0010Q\u001a\u00020RX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020XX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020RX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010T\"\u0004\b_\u0010VR\u001a\u0010`\u001a\u00020RX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010T\"\u0004\bb\u0010VR\u001a\u0010c\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001e\u0010h\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bi\u0010 \"\u0004\bj\u0010\"R\u001e\u0010k\u001a\u0004\u0018\u00010\u001eX\u0084\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\bl\u0010 \"\u0004\bm\u0010\"R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010uX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0017\"\u0004\b|\u0010\u0019R\u001a\u0010}\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0017\"\u0004\b\u007f\u0010\u0019R\u001d\u0010\u0080\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0017\"\u0005\b\u0082\u0001\u0010\u0019R\u001d\u0010\u0083\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0017\"\u0005\b\u0085\u0001\u0010\u0019R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u0089\u0001\"\u0006\b\u008e\u0001\u0010\u008b\u0001R\"\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0089\u0001\"\u0006\b\u0091\u0001\u0010\u008b\u0001R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0089\u0001\"\u0006\b\u0094\u0001\u0010\u008b\u0001R\u001d\u0010\u0095\u0001\u001a\u00020\u001eX\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010e\"\u0005\b\u0097\u0001\u0010gR\u001d\u0010\u0098\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\u0017\"\u0005\b\u009a\u0001\u0010\u0019R\u001d\u0010\u009b\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u0017\"\u0005\b\u009d\u0001\u0010\u0019R\u001d\u0010\u009e\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009f\u0001\u0010\u0017\"\u0005\b \u0001\u0010\u0019R\u001d\u0010¡\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010\u0017\"\u0005\b£\u0001\u0010\u0019R\u001d\u0010¤\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010\u0017\"\u0005\b¦\u0001\u0010\u0019R\u001d\u0010§\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u0017\"\u0005\b©\u0001\u0010\u0019R\"\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R\u001d\u0010°\u0001\u001a\u00020RX\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010T\"\u0005\b²\u0001\u0010VR\u001d\u0010³\u0001\u001a\u00020\u0015X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010\u0017\"\u0005\bµ\u0001\u0010\u0019R \u0010¶\u0001\u001a\u00030·\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R\u001f\u0010¼\u0001\u001a\n\u0012\u0005\u0012\u00030¾\u00010½\u0001X\u0084\u0004¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001R,\u0010Á\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0005\u0012\u00030Ã\u00010Â\u00010½\u0001X\u0084\u0004¢\u0006\n\n\u0000\u001a\u0006\bÄ\u0001\u0010À\u0001R\"\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\u001d\u0010Ë\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÌ\u0001\u0010e\"\u0005\bÍ\u0001\u0010gR\u001d\u0010Î\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010e\"\u0005\bÐ\u0001\u0010gR\u001d\u0010Ñ\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010e\"\u0005\bÓ\u0001\u0010gR\u001d\u0010Ô\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÕ\u0001\u0010e\"\u0005\bÖ\u0001\u0010gR\u001d\u0010×\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bØ\u0001\u0010e\"\u0005\bÙ\u0001\u0010gR\u001d\u0010Ú\u0001\u001a\u00020\u001eX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÛ\u0001\u0010e\"\u0005\bÜ\u0001\u0010g¨\u0006\u008c\u0002"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialogController;", "Lcom/larksuite/component/universe_design/dialog/UDDialog$DialogCallback;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mDialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "getMDialog", "()Lcom/larksuite/component/universe_design/dialog/UDDialog;", "setMDialog", "(Lcom/larksuite/component/universe_design/dialog/UDDialog;)V", "mTitle", "", "getMTitle", "()Ljava/lang/CharSequence;", "setMTitle", "(Ljava/lang/CharSequence;)V", "mTitleSize", "", "getMTitleSize", "()I", "setMTitleSize", "(I)V", "mTitleTextColor", "getMTitleTextColor", "setMTitleTextColor", "mTitleTextStyleBold", "", "getMTitleTextStyleBold", "()Ljava/lang/Boolean;", "setMTitleTextStyleBold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "mTitleLineCount", "getMTitleLineCount", "setMTitleLineCount", "mTitleGravity", "getMTitleGravity", "setMTitleGravity", "mTitlePaddingLeft", "getMTitlePaddingLeft", "setMTitlePaddingLeft", "mTitlePaddingTop", "getMTitlePaddingTop", "setMTitlePaddingTop", "mTitlePaddingRight", "getMTitlePaddingRight", "setMTitlePaddingRight", "mTitlePaddingBottom", "getMTitlePaddingBottom", "setMTitlePaddingBottom", "mMessage", "getMMessage", "setMMessage", "mMessageSize", "getMMessageSize", "setMMessageSize", "mMessageTextColor", "getMMessageTextColor", "setMMessageTextColor", "mMessagePaddingLeft", "getMMessagePaddingLeft", "setMMessagePaddingLeft", "mMessagePaddingTop", "getMMessagePaddingTop", "setMMessagePaddingTop", "mMessagePaddingRight", "getMMessagePaddingRight", "setMMessagePaddingRight", "mMessagePaddingBottom", "getMMessagePaddingBottom", "setMMessagePaddingBottom", "mMessageGravity", "getMMessageGravity", "setMMessageGravity", "mGravity", "getMGravity", "setMGravity", "mWidth", "", "getMWidth", "()F", "setMWidth", "(F)V", "mMaxWidth", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "getMMaxWidth", "()Lcom/larksuite/component/universe_design/dimension/UDDimension;", "setMMaxWidth", "(Lcom/larksuite/component/universe_design/dimension/UDDimension;)V", "mHeight", "getMHeight", "setMHeight", "mMaxHeight", "getMMaxHeight", "setMMaxHeight", "mAutoDismiss", "getMAutoDismiss", "()Z", "setMAutoDismiss", "(Z)V", "mCancelable", "getMCancelable", "setMCancelable", "mCanceledOnTouchOutside", "getMCanceledOnTouchOutside", "setMCanceledOnTouchOutside", "mOnCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getMOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setMOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "getMOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setMOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "mHeaderLayoutRes", "getMHeaderLayoutRes", "setMHeaderLayoutRes", "mContentLayoutRes", "getMContentLayoutRes", "setMContentLayoutRes", "mFooterLayoutRes", "getMFooterLayoutRes", "setMFooterLayoutRes", "mRootLayoutRes", "getMRootLayoutRes", "setMRootLayoutRes", "mHeaderLayout", "Landroid/view/View;", "getMHeaderLayout", "()Landroid/view/View;", "setMHeaderLayout", "(Landroid/view/View;)V", "mContentLayout", "getMContentLayout", "setMContentLayout", "mFooterLayout", "getMFooterLayout", "setMFooterLayout", "mRootLayout", "getMRootLayout", "setMRootLayout", "mAllowContentScroll", "getMAllowContentScroll", "setMAllowContentScroll", "mMarginInDp", "getMMarginInDp", "setMMarginInDp", "mTranslationOnY", "getMTranslationOnY", "setMTranslationOnY", "mPaddingLeftInDp", "getMPaddingLeftInDp", "setMPaddingLeftInDp", "mPaddingTopInDp", "getMPaddingTopInDp", "setMPaddingTopInDp", "mPaddingRightInDp", "getMPaddingRightInDp", "setMPaddingRightInDp", "mPaddingBottomInDp", "getMPaddingBottomInDp", "setMPaddingBottomInDp", "mBackground", "Landroid/graphics/drawable/Drawable;", "getMBackground", "()Landroid/graphics/drawable/Drawable;", "setMBackground", "(Landroid/graphics/drawable/Drawable;)V", "mMaskAlpha", "getMMaskAlpha", "setMMaskAlpha", "mAnimStyle", "getMAnimStyle", "setMAnimStyle", "mActionButtonsOrientation", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "getMActionButtonsOrientation", "()Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "setMActionButtonsOrientation", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;)V", "mActionButtons", "", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionButtonInfo;", "getMActionButtons", "()Ljava/util/List;", "mViewClickInfos", "Landroid/util/Pair;", "Landroid/content/DialogInterface$OnClickListener;", "getMViewClickInfos", "mLifecycleCallback", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;", "getMLifecycleCallback", "()Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;", "setMLifecycleCallback", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$LifecycleCallback;)V", "isHeaderLayoutDefault", "isHeaderLayoutDefault$universe_ui_dialog_release", "setHeaderLayoutDefault$universe_ui_dialog_release", "isContentLayoutDefault", "isContentLayoutDefault$universe_ui_dialog_release", "setContentLayoutDefault$universe_ui_dialog_release", "isFooterLayoutDefault", "isFooterLayoutDefault$universe_ui_dialog_release", "setFooterLayoutDefault$universe_ui_dialog_release", "isHeaderVisible", "isHeaderVisible$universe_ui_dialog_release", "setHeaderVisible$universe_ui_dialog_release", "isContentVisible", "isContentVisible$universe_ui_dialog_release", "setContentVisible$universe_ui_dialog_release", "isFooterVisible", "isFooterVisible$universe_ui_dialog_release", "setFooterVisible$universe_ui_dialog_release", "apply", "", "T", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder;", "builder", "dialog", "beforeCreate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onShow", "onDismiss", "getDefaultHeaderRes", "onCreateHeader", "getDefaultContentRes", "onCreateContent", "getDefaultFooterRes", "onCreateFooter", "applyDialogConfig", "getDefaultRootRes", "createView", "initView", "createDialogFrame", "Landroid/view/ViewGroup;", "toSize", "Lcom/larksuite/component/universe_design/dialog/frame/DialogFrame$Size;", "adjustSize", "toLayoutSize", "setupTextView", "textView", "Landroid/widget/TextView;", "textSize", "textColor", "setupViewPadding", "view", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "getFinalView", "initRes", "defaultRes", "getSize", "dpValue", "fullSize", "Companion", "DialogFooter", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDDialogController implements UDDialog.DialogCallback {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final int DEFAULT_NO_MESSAGE_TITLE_PADDING_BOTTOM = 24;
    private static final int DEFAULT_NO_TITLE_MESSAGE_PADDING_TOP = 24;
    private final Context context;
    private boolean isContentLayoutDefault;
    private boolean isContentVisible;
    private boolean isFooterLayoutDefault;
    private boolean isFooterVisible;
    private boolean isHeaderLayoutDefault;
    private boolean isHeaderVisible;
    private final List<UDBaseDialogBuilder.a> mActionButtons;
    private UDBaseDialogBuilder.ActionBottomOrientation mActionButtonsOrientation;
    private boolean mAllowContentScroll;
    private int mAnimStyle;
    private boolean mAutoDismiss;
    private Drawable mBackground;
    private Boolean mCancelable;
    private Boolean mCanceledOnTouchOutside;
    private View mContentLayout;
    private int mContentLayoutRes;
    private UDDialog mDialog;
    private View mFooterLayout;
    private int mFooterLayoutRes;
    private int mGravity;
    private View mHeaderLayout;
    private int mHeaderLayoutRes;
    private float mHeight;
    private UDBaseDialogBuilder.c mLifecycleCallback;
    private int mMarginInDp;
    private float mMaskAlpha;
    private float mMaxHeight;
    private UDDimension mMaxWidth;
    private CharSequence mMessage;
    private int mMessageGravity;
    private int mMessagePaddingBottom;
    private int mMessagePaddingLeft;
    private int mMessagePaddingRight;
    private int mMessagePaddingTop;
    private int mMessageSize;
    private int mMessageTextColor;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private int mPaddingBottomInDp;
    private int mPaddingLeftInDp;
    private int mPaddingRightInDp;
    private int mPaddingTopInDp;
    private View mRootLayout;
    private int mRootLayoutRes;
    private CharSequence mTitle;
    private int mTitleGravity;
    private int mTitleLineCount;
    private int mTitlePaddingBottom;
    private int mTitlePaddingLeft;
    private int mTitlePaddingRight;
    private int mTitlePaddingTop;
    private int mTitleSize;
    private int mTitleTextColor;
    private Boolean mTitleTextStyleBold;
    private int mTranslationOnY;
    private final List<Pair<Integer, DialogInterface.OnClickListener>> mViewClickInfos;
    private float mWidth;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0002J(\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010$\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010%\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010 \u001a\u00020&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010'\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010(\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J(\u0010)\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010 \u001a\u00020&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J\f\u0010*\u001a\u00020\u0016*\u00020\u001fH\u0002R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDDialogController$DialogFooter;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "actionButtonOrientation", "getActionButtonOrientation", "()Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;", "setActionButtonOrientation", "(Lcom/larksuite/component/universe_design/dialog/UDBaseDialogBuilder$ActionBottomOrientation;)V", "initActions", "", "completeAutoCalc", "", "lastWidthMeasureSpec", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "changeToHorizontal", "changeToVertical", "ensureHorizontalConstraints", "primaryButton", "Landroid/widget/TextView;", "secondaryButton", "divider", "Landroid/view/View;", "topDivider", "ensureHorizontalDividers", "ensureHorizontalRadius", "Lcom/larksuite/component/universe_design/button/UDButton;", "ensureVerticalConstraints", "ensureVerticalDividers", "ensureVerticalRadius", "canNotDisplayAsSingleLine", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DialogFooter extends ConstraintLayout {
        public UDBaseDialogBuilder.ActionBottomOrientation a;
        public boolean b;
        public int c;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[UDBaseDialogBuilder.ActionBottomOrientation.values().length];
                r0[UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[UDBaseDialogBuilder.ActionBottomOrientation.AUTO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.Button, android.widget.TextView, com.larksuite.component.universe_design.button.UDButton] */
        /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.Button, android.widget.TextView, com.larksuite.component.universe_design.button.UDButton] */
        public final void R5() {
            ?? r0 = (UDButton) findViewById(2131391777);
            ?? r1 = (UDButton) findViewById(2131391778);
            View r2 = findViewById(2131391776);
            View r3 = findViewById(2131391797);
            ConstraintLayout.LayoutParams r4 = r1.getLayoutParams();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r6 = r4;
            r6.startToStart = 0;
            r6.startToEnd = -1;
            r6.endToStart = r2.getId();
            r6.endToEnd = -1;
            r6.topToTop = -1;
            r6.topToBottom = r3.getId();
            r6.bottomToTop = -1;
            r6.bottomToBottom = 0;
            r1.setLayoutParams(r4);
            ConstraintLayout.LayoutParams r5 = r2.getLayoutParams();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r7 = r5;
            ((ViewGroup.MarginLayoutParams) r7).width = h18.d.d(getContext(), 2131169378);
            ((ViewGroup.MarginLayoutParams) r7).height = 0;
            r7.startToStart = -1;
            r7.startToEnd = r1.getId();
            r7.endToStart = r0.getId();
            r7.endToEnd = -1;
            r7.topToTop = -1;
            r7.topToBottom = r3.getId();
            r7.bottomToTop = -1;
            r7.bottomToBottom = 0;
            r2.setLayoutParams(r5);
            ConstraintLayout.LayoutParams r8 = r0.getLayoutParams();
            Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r9 = r8;
            r9.startToStart = -1;
            r9.startToEnd = r2.getId();
            r9.endToStart = -1;
            r9.endToEnd = 0;
            r9.topToTop = -1;
            r9.topToBottom = r3.getId();
            r9.bottomToTop = -1;
            r9.bottomToBottom = 0;
            r0.setLayoutParams(r8);
            if (r0.getVisibility() == 0) goto L5;
        L7:
            r2.setVisibility(8);
        L9:
            if (r0.getVisibility() != 0) goto L11;
        L14:
            r3.setVisibility(0);
        L15:
            float r10 = UDRadius.L.getRadiusSize(getContext());
            if (r0.getVisibility() != 0) goto L21;
            if (r1.getVisibility() != 0) goto L21;
            r0.setCornerRadii(0.0f, 0.0f, 0.0f, r10);
            r1.setCornerRadii(0.0f, 0.0f, r10, 0.0f);
        L21:
            if (r0.getVisibility() != 0) goto L26;
            if (r1.getVisibility() != 8) goto L26;
            r0.setCornerRadii(0.0f, 0.0f, r10, r10);
            r1.setCornerRadii(0.0f, 0.0f, 0.0f, 0.0f);
        L26:
            if (r0.getVisibility() == 8) goto L28;
            return;
        L28:
            if (r1.getVisibility() != 0) goto L32;
            r0.setCornerRadii(0.0f, 0.0f, 0.0f, 0.0f);
            r1.setCornerRadii(0.0f, 0.0f, r10, r10);
            return;
        L32:
            return;
        L11:
            if (r1.getVisibility() == 0) goto L14;
            r3.setVisibility(8);
            goto L15
        L5:
            if (r1.getVisibility() != 0) goto L7;
            r2.setVisibility(0);
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void S5() {
            removeAllViews();
            UDBaseDialogBuilder.ActionBottomOrientation r0 = this.a;
            int r1 = a.a[r0.ordinal()];
            if (r1 != 1) goto L5;
        L11:
            LayoutInflater.from(getContext()).inflate(2131568087, this, true);
        L13:
            if (this.a != UDBaseDialogBuilder.ActionBottomOrientation.AUTO) goto L16;
            this.b = false;
            return;
        L16:
            return;
        L5:
            if (r1 == 2) goto L11;
            if (r1 != 3) goto L10;
            LayoutInflater.from(getContext()).inflate(2131568088, this, true);
            goto L13
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public final UDBaseDialogBuilder.ActionBottomOrientation getActionButtonOrientation() {
            return this.a;
        }

        public DialogFooter(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.a = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
            S5();
        }

        public final void setActionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            if (this.a == r2) goto L6;
            this.a = r2;
            S5();
            requestLayout();
            return;
        }

        public DialogFooter(Context r2, AttributeSet r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2, r3);
            this.a = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
            S5();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.Button, android.widget.TextView, com.larksuite.component.universe_design.button.UDButton] */
        /* JADX WARN: Type inference failed for: r1v6, types: [android.widget.Button, android.widget.TextView, com.larksuite.component.universe_design.button.UDButton] */
        public final void onMeasure(int r14, int r15) {
            UDBaseDialogBuilder.ActionBottomOrientation r0 = this.a;
            UDBaseDialogBuilder.ActionBottomOrientation r1 = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
            if (r0 == r1) goto L5;
        L7:
            super.onMeasure(r14, r15);
            if (this.a == r1) goto L10;
            return;
        L10:
            if (this.b == true) goto L47;
            TextView r2 = (TextView) findViewById(2131391777);
            TextView r4 = (TextView) findViewById(2131391778);
            if (r2.getVisibility() != 8) goto L15;
        L17:
            boolean r3 = false;
        L18:
            if (r3 == false) goto L20;
        L29:
            ?? r5 = (UDButton) findViewById(2131391777);
            ?? r6 = (UDButton) findViewById(2131391778);
            View r7 = findViewById(2131391776);
            View r8 = findViewById(2131391797);
            ConstraintLayout.LayoutParams r9 = r5.getLayoutParams();
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r10 = r9;
            r10.startToStart = 0;
            r10.startToEnd = -1;
            r10.endToStart = -1;
            r10.endToEnd = 0;
            r10.topToTop = -1;
            r10.topToBottom = r8.getId();
            r10.bottomToTop = r7.getId();
            r10.bottomToBottom = -1;
            r5.setLayoutParams(r9);
            ConstraintLayout.LayoutParams r11 = r7.getLayoutParams();
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r12 = r11;
            ((ViewGroup.MarginLayoutParams) r12).width = 0;
            ((ViewGroup.MarginLayoutParams) r12).height = h18.d.d(getContext(), 2131169378);
            r12.startToStart = 0;
            r12.startToEnd = -1;
            r12.endToStart = -1;
            r12.endToEnd = 0;
            r12.topToTop = -1;
            r12.topToBottom = r5.getId();
            r12.bottomToTop = r6.getId();
            r12.bottomToBottom = -1;
            r7.setLayoutParams(r11);
            ConstraintLayout.LayoutParams r13 = r6.getLayoutParams();
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams r16 = r13;
            r16.startToStart = 0;
            r16.startToEnd = -1;
            r16.endToStart = -1;
            r16.endToEnd = 0;
            r16.topToTop = -1;
            r16.topToBottom = r7.getId();
            r16.bottomToTop = -1;
            r16.bottomToBottom = 0;
            r6.setLayoutParams(r13);
            if (r5.getVisibility() != 0) goto L32;
            r8.setVisibility(0);
        L34:
            if (r6.getVisibility() != 0) goto L36;
            r7.setVisibility(0);
        L38:
            if (r5.getVisibility() == 0) goto L40;
            float r17 = UDRadius.L.getRadiusSize(getContext());
            r5.setCornerRadius(0.0f);
            r6.setCornerRadii(0.0f, 0.0f, r17, r17);
        L44:
            this.b = true;
            super.onMeasure(r14, r15);
            return;
        L40:
            if (r6.getVisibility() != 0) goto L42;
            float r19 = UDRadius.L.getRadiusSize(getContext());
            r5.setCornerRadius(0.0f);
            r6.setCornerRadii(0.0f, 0.0f, r19, r19);
            goto L44
        L42:
            float r20 = UDRadius.L.getRadiusSize(getContext());
            r5.setCornerRadii(0.0f, 0.0f, r20, r20);
            r6.setCornerRadius(0.0f);
            goto L44
        L36:
            r7.setVisibility(8);
            goto L38
        L32:
            r8.setVisibility(8);
            goto L34
        L20:
            if (r4.getVisibility() != 8) goto L23;
        L25:
            boolean r21 = false;
        L26:
            if (r21 == true) goto L29;
            R5();
            goto L44
        L23:
            if (r4.getLineCount() <= 1) goto L25;
            r21 = true;
            goto L26
        L15:
            if (r2.getLineCount() <= 1) goto L17;
            r3 = true;
            goto L18
        L47:
            return;
        L5:
            if (this.c == r14) goto L7;
            this.c = r14;
            R5();
            this.b = false;
            goto L7
        }

        public DialogFooter(Context r2, AttributeSet r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2, r3, r4);
            this.a = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
            S5();
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ UDDialogController a;

        public b(UDDialogController r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v5, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (Intrinsics.areEqual(this.a.getMCanceledOnTouchOutside(), Boolean.FALSE) == true) goto L23;
            ?? r5 = this.a.getMDialog();
            if (r5 == 0) goto L27;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r1 == null) goto L20;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
            goto L20
        L9:
            if (Looper.myLooper() == r0.getLooper()) goto L11;
            r0.post(DialogLancet.createDismissRunnable(r5));
            return;
        L27:
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ Pair<Integer, DialogInterface.OnClickListener> a;
        public final /* synthetic */ UDDialogController b;

        public c(Pair<Integer, DialogInterface.OnClickListener> r1, UDDialogController r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ((DialogInterface.OnClickListener) this.a.second).onClick(this.b.getMDialog(), ((Number) this.a.first).intValue());
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ UDBaseDialogBuilder.a a;
        public final /* synthetic */ UDDialogController b;

        public d(UDBaseDialogBuilder.a r1, UDDialogController r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            DialogInterface.OnClickListener r5 = this.a.i;
            if (r5 == null) goto L6;
            r5.onClick(this.b.getMDialog(), this.a.a);
        L6:
            if (this.b.getMAutoDismiss() == false) goto L26;
            ?? r6 = this.b.getMDialog();
            if (r6 == 0) goto L30;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r1 == null) goto L23;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r0.getLooper()) goto L14;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        L30:
            return;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    private final int toLayoutSize(float r2) {
        if (((int) r2) == (-1)) goto L7;
        return -2;
    L7:
        return -1;
    }

    public int getDefaultContentRes() {
        this.isContentLayoutDefault = true;
        return 2131568082;
    }

    public int getDefaultFooterRes() {
        this.isFooterLayoutDefault = true;
        return 2131568083;
    }

    public int getDefaultHeaderRes() {
        this.isHeaderLayoutDefault = true;
        return 2131568084;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public void onDismiss() {
    }

    private final void adjustSize() {
        AppCompatDialog r0 = this.mDialog;
        if (r0 == null) goto L9;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L10;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = toLayoutSize(this.mWidth);
        r2.height = toLayoutSize(this.mHeight);
        r2.gravity = this.mGravity;
        r2.y = (int) h18.d.b(this.context, this.mTranslationOnY);
        r1.setAttributes(r2);
        return;
    L10:
        return;
    }

    private final ViewGroup createDialogFrame() {
        s08.a r0 = new s08.a(this.context);
        r0.setId(2131391798);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, -1);
        r1.gravity = this.mGravity;
        r0.setLayoutParams(r1);
        r0.setOnClickListener(new b(this));
        int r2 = (int) h18.d.b(r0.getContext(), this.mMarginInDp);
        r0.setPadding(r2, r2, r2, r2);
        r0.setDialogWidth(toSize(this.mWidth));
        r0.setDialogHeight(toSize(this.mHeight));
        r0.setMaxWidth(new s08.a.AbstractC0123a.C0124a((int) this.mMaxWidth.toPixels(r0.getContext())));
        r0.setMaxHeight(toSize(this.mMaxHeight));
        return r0;
    }

    public View createView() {
        View r0 = getFinalView(this.mRootLayout, this.mRootLayoutRes, getDefaultRootRes());
        Window r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        setupViewPadding(r0, this.mPaddingLeftInDp, this.mPaddingTopInDp, this.mPaddingRightInDp, this.mPaddingBottomInDp);
        ViewGroup r2 = (ViewGroup) r0.findViewById(2131391799);
        ViewGroup r3 = (ViewGroup) r0.findViewById(2131391785);
        ViewGroup r4 = (ViewGroup) r0.findViewById(2131391796);
        View r5 = onCreateHeader();
        if (r5 == null) goto L9;
        if (r2 == null) goto L9;
        r2.addView(r5);
    L9:
        View r6 = onCreateContent();
        if (r6 == null) goto L13;
        if (r3 == null) goto L13;
        r3.addView(r6);
    L13:
        View r7 = onCreateFooter();
        if (r7 == null) goto L17;
        if (r4 == null) goto L17;
        r4.addView(r7);
    L17:
        Iterator<Pair<Integer, DialogInterface.OnClickListener>> r8 = this.mViewClickInfos.iterator();
    L19:
        if (r8.hasNext() == false) goto L24;
        Pair<Integer, DialogInterface.OnClickListener> r9 = r8.next();
        View r10 = r0.findViewById(((Number) r9.first).intValue());
        if (r9.second == null) goto L19;
        if (r10 == null) goto L19;
        r10.setOnClickListener(new c(r9, this));
        goto L19
    L24:
        Drawable r11 = this.mBackground;
        if (r11 == null) goto L27;
        r0.setBackground(r11);
    L27:
        AppCompatDialog r12 = this.mDialog;
        if (r12 == null) goto L30;
        r1 = r12.getWindow();
    L30:
        float r13 = this.mMaskAlpha;
        if (r13 != (-1.0f)) goto L33;
        boolean r14 = true;
    L34:
        if (r14 == true) goto L37;
        if (r1 == null) goto L37;
        r1.setDimAmount(r13);
    L37:
        return r0;
    L33:
        r14 = false;
        goto L34
    }

    public int getDefaultRootRes() {
        if (this.mAllowContentScroll == false) goto L5;
        return 2131568086;
    L5:
        return 2131568085;
    }

    public View onCreateContent() {
        View r0 = getFinalView(this.mContentLayout, this.mContentLayoutRes, getDefaultContentRes());
        if (r0 != null) goto L7;
        return null;
    L7:
        if ((!TextUtils.isEmpty(this.mMessage)) == false) goto L21;
        TextView r1 = (TextView) r0.findViewById(2131391794);
        if (r1 == null) goto L15;
        int r2 = this.mMessageGravity;
        if (r2 < 0) goto L13;
        r1.setGravity(r2);
    L13:
        r1.setText(this.mMessage);
        setupTextView(r1, this.mMessageSize, this.mMessageTextColor);
    L15:
        if (this.isHeaderVisible == false) goto L17;
    L19:
        setupViewPadding(r0, this.mMessagePaddingLeft, this.mMessagePaddingTop, this.mMessagePaddingRight, this.mMessagePaddingBottom);
    L27:
        return r0;
    L17:
        if (this.mMessagePaddingTop >= 0) goto L19;
        Context r3 = this.context;
        setupViewPadding(r0, this.mMessagePaddingLeft, h18.d.e(r3, (int) h18.d.c(r3, 2131169377)), this.mMessagePaddingRight, this.mMessagePaddingBottom);
        goto L27
    L21:
        if (this.mContentLayout != null) goto L27;
        if (this.mContentLayoutRes != 0) goto L27;
        if (this.isContentLayoutDefault == false) goto L27;
        r0.setVisibility(8);
        this.isContentVisible = false;
        goto L27
    }

    public View onCreateFooter() {
        View r0 = getFinalView(this.mFooterLayout, this.mFooterLayoutRes, getDefaultFooterRes());
        if (r0 != null) goto L6;
        return null;
    L6:
        DialogFooter r1 = (DialogFooter) r0.findViewById(2131391774);
        if (r1 == null) goto L9;
        r1.setActionButtonOrientation(this.mActionButtonsOrientation);
    L9:
        Iterator<UDBaseDialogBuilder.a> r2 = this.mActionButtons.iterator();
        int r3 = 0;
    L11:
        if (r2.hasNext() == false) goto L46;
        UDBaseDialogBuilder.a r4 = r2.next();
        TextView r8 = (TextView) r0.findViewById(r4.a);
        if (r8 == null) goto L11;
        r8.setVisibility(0);
        int r9 = r4.b;
        if (r9 == 0) goto L17;
        r8.setText(r9);
    L19:
        if (r4.e == 0) goto L21;
        r8.setTextColor(UDColorUtils.getColor(r8.getContext(), r4.e));
    L24:
        int r10 = r4.d;
        if (r10 == 0) goto L28;
        r8.setTextSize(r10);
    L28:
        if (r4.g == 0) goto L34;
        t08.a r11 = new t08.a();
        r11.setColor(UDColorUtils.getColorStateList(r8.getContext(), r4.g));
        if (r4.a != 2131391775) goto L32;
        UDRadius r12 = UDRadius.XXL;
    L33:
        r11.setCornerRadius(r12.getRadiusSize(r8.getContext()));
        r8.setBackground(r11);
    L37:
        r8.setOnClickListener(new d(r4, this));
        int r5 = r4.a;
        if (r5 == 2131391779) goto L39;
        if (r5 == 2131391778) goto L41;
        if (r5 == 2131391777) goto L43;
        if (r5 != 2131391775) goto L11;
        r3 = r3 | 8;
        goto L11
    L43:
        r3 = r3 | 4;
        goto L11
    L41:
        r3 = r3 | 2;
        goto L11
    L39:
        r3 = r3 | 1;
        goto L11
    L32:
        r12 = UDRadius.L;
        goto L33
    L34:
        int r13 = r4.h;
        if (r13 == 0) goto L37;
        r8.setBackgroundResource(r13);
        goto L37
    L21:
        int r14 = r4.f;
        if (r14 == 0) goto L24;
        r8.setTextColor(r14);
        goto L24
    L17:
        r8.setText(r4.c);
        goto L19
    L46:
        if (r3 <= 0) goto L51;
        View r6 = r0.findViewById(2131391797);
        if (r6 == null) goto L51;
        r6.setVisibility(0);
    L51:
        if (r3 != 6) goto L55;
        View r7 = r0.findViewById(2131391776);
        if (r7 == null) goto L55;
        r7.setVisibility(0);
    L55:
        int r15 = r3 & 1;
        if (r15 == 0) goto L60;
        View r16 = r0.findViewById(2131391807);
        if (r16 == null) goto L60;
        r16.setVisibility(0);
    L60:
        int r17 = r3 & 2;
        if (r17 == 0) goto L65;
        View r19 = r0.findViewById(2131391806);
        if (r19 == null) goto L65;
        r19.setVisibility(0);
    L65:
        int r20 = r3 & 4;
        if (r20 == 0) goto L70;
        View r21 = r0.findViewById(2131391801);
        if (r21 == null) goto L70;
        r21.setVisibility(0);
    L70:
        float r22 = UDRadius.L.getRadiusSize(this.context);
        UDBaseDialogBuilder.ActionBottomOrientation r110 = this.mActionButtonsOrientation;
        if (r110 != UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L83;
        if (r3 != 2) goto L78;
        UDButton r23 = (UDButton) r0.findViewById(2131391778);
        if (r23 == null) goto L78;
        r23.setCornerRadii(0.0f, 0.0f, r22, r22);
    L78:
        if (r3 != 4) goto L97;
        UDButton r24 = (UDButton) r0.findViewById(2131391777);
        if (r24 == null) goto L97;
        r24.setCornerRadii(0.0f, 0.0f, r22, r22);
    L97:
        if (TextUtils.isEmpty(this.mMessage) == true) goto L99;
    L105:
        return r0;
    L99:
        if (this.mContentLayout != null) goto L105;
        if (this.mContentLayoutRes != 0) goto L105;
        if (this.isContentLayoutDefault == false) goto L105;
        r0.setPadding(0, (int) h18.d.b(this.context, 12), 0, 0);
        goto L105
    L83:
        if (r110 != UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL) goto L97;
        if (r15 <= 0) goto L88;
        UDButton r25 = (UDButton) r0.findViewById(2131391779);
        if (r25 == null) goto L97;
        r25.setCornerRadii(0.0f, 0.0f, r22, r22);
        goto L97
    L88:
        if (r17 <= 0) goto L92;
        UDButton r26 = (UDButton) r0.findViewById(2131391778);
        if (r26 == null) goto L97;
        r26.setCornerRadii(0.0f, 0.0f, r22, r22);
        goto L97
    L92:
        if (r20 <= 0) goto L97;
        UDButton r27 = (UDButton) r0.findViewById(2131391777);
        if (r27 == null) goto L97;
        r27.setCornerRadii(0.0f, 0.0f, r22, r22);
        goto L97
    }

    public View onCreateHeader() {
        View r0 = getFinalView(this.mHeaderLayout, this.mHeaderLayoutRes, getDefaultHeaderRes());
        if (r0 != null) goto L7;
        return null;
    L7:
        if ((!TextUtils.isEmpty(this.mTitle)) == false) goto L19;
        TextView r1 = (TextView) r0.findViewById(2131391809);
        if (r1 == null) goto L17;
        r1.setMaxLines(this.mTitleLineCount);
        int r2 = this.mTitleGravity;
        if (r2 < 0) goto L13;
        r1.setGravity(r2);
    L13:
        r1.setText(this.mTitle);
        Boolean r3 = this.mTitleTextStyleBold;
        if (r3 == null) goto L16;
        boolean r4 = Intrinsics.areEqual(r3, Boolean.TRUE);
        int r5 = e.a;
        r1.setTypeface(e.b(r1.getContext(), r4 ? 1 : 0));
    L16:
        setupTextView(r1, this.mTitleSize, this.mTitleTextColor);
    L17:
        setupViewPadding(r0, this.mTitlePaddingLeft, this.mTitlePaddingTop, this.mTitlePaddingRight, this.mTitlePaddingBottom);
    L25:
        return r0;
    L19:
        if (this.mHeaderLayout != null) goto L25;
        if (this.mHeaderLayoutRes != 0) goto L25;
        if (this.isHeaderLayoutDefault == false) goto L25;
        r0.setVisibility(8);
        this.isHeaderVisible = false;
        goto L25
    }

    private final void initView() {
        View r0 = createView();
        ViewGroup r1 = createDialogFrame();
        if (r0 == null) goto L5;
        r1.addView(r0, -2, -2);
    L5:
        UDDialog r2 = this.mDialog;
        if (r2 == null) goto L9;
        r2.setContentView(r1);
        return;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<UDBaseDialogBuilder.a> getMActionButtons() {
        return this.mActionButtons;
    }

    public final UDBaseDialogBuilder.ActionBottomOrientation getMActionButtonsOrientation() {
        return this.mActionButtonsOrientation;
    }

    public final boolean getMAllowContentScroll() {
        return this.mAllowContentScroll;
    }

    public final int getMAnimStyle() {
        return this.mAnimStyle;
    }

    public final boolean getMAutoDismiss() {
        return this.mAutoDismiss;
    }

    public final Drawable getMBackground() {
        return this.mBackground;
    }

    public final Boolean getMCancelable() {
        return this.mCancelable;
    }

    public final Boolean getMCanceledOnTouchOutside() {
        return this.mCanceledOnTouchOutside;
    }

    public final View getMContentLayout() {
        return this.mContentLayout;
    }

    public final int getMContentLayoutRes() {
        return this.mContentLayoutRes;
    }

    public final UDDialog getMDialog() {
        return this.mDialog;
    }

    public final View getMFooterLayout() {
        return this.mFooterLayout;
    }

    public final int getMFooterLayoutRes() {
        return this.mFooterLayoutRes;
    }

    public final int getMGravity() {
        return this.mGravity;
    }

    public final View getMHeaderLayout() {
        return this.mHeaderLayout;
    }

    public final int getMHeaderLayoutRes() {
        return this.mHeaderLayoutRes;
    }

    public final float getMHeight() {
        return this.mHeight;
    }

    public final UDBaseDialogBuilder.c getMLifecycleCallback() {
        return this.mLifecycleCallback;
    }

    public final int getMMarginInDp() {
        return this.mMarginInDp;
    }

    public final float getMMaskAlpha() {
        return this.mMaskAlpha;
    }

    public final float getMMaxHeight() {
        return this.mMaxHeight;
    }

    public final UDDimension getMMaxWidth() {
        return this.mMaxWidth;
    }

    public final CharSequence getMMessage() {
        return this.mMessage;
    }

    public final int getMMessageGravity() {
        return this.mMessageGravity;
    }

    public final int getMMessagePaddingBottom() {
        return this.mMessagePaddingBottom;
    }

    public final int getMMessagePaddingLeft() {
        return this.mMessagePaddingLeft;
    }

    public final int getMMessagePaddingRight() {
        return this.mMessagePaddingRight;
    }

    public final int getMMessagePaddingTop() {
        return this.mMessagePaddingTop;
    }

    public final int getMMessageSize() {
        return this.mMessageSize;
    }

    public final int getMMessageTextColor() {
        return this.mMessageTextColor;
    }

    public final DialogInterface.OnCancelListener getMOnCancelListener() {
        return this.mOnCancelListener;
    }

    public final DialogInterface.OnDismissListener getMOnDismissListener() {
        return this.mOnDismissListener;
    }

    public final int getMPaddingBottomInDp() {
        return this.mPaddingBottomInDp;
    }

    public final int getMPaddingLeftInDp() {
        return this.mPaddingLeftInDp;
    }

    public final int getMPaddingRightInDp() {
        return this.mPaddingRightInDp;
    }

    public final int getMPaddingTopInDp() {
        return this.mPaddingTopInDp;
    }

    public final View getMRootLayout() {
        return this.mRootLayout;
    }

    public final int getMRootLayoutRes() {
        return this.mRootLayoutRes;
    }

    public final CharSequence getMTitle() {
        return this.mTitle;
    }

    public final int getMTitleGravity() {
        return this.mTitleGravity;
    }

    public final int getMTitleLineCount() {
        return this.mTitleLineCount;
    }

    public final int getMTitlePaddingBottom() {
        return this.mTitlePaddingBottom;
    }

    public final int getMTitlePaddingLeft() {
        return this.mTitlePaddingLeft;
    }

    public final int getMTitlePaddingRight() {
        return this.mTitlePaddingRight;
    }

    public final int getMTitlePaddingTop() {
        return this.mTitlePaddingTop;
    }

    public final int getMTitleSize() {
        return this.mTitleSize;
    }

    public final int getMTitleTextColor() {
        return this.mTitleTextColor;
    }

    public final Boolean getMTitleTextStyleBold() {
        return this.mTitleTextStyleBold;
    }

    public final int getMTranslationOnY() {
        return this.mTranslationOnY;
    }

    public final List<Pair<Integer, DialogInterface.OnClickListener>> getMViewClickInfos() {
        return this.mViewClickInfos;
    }

    public final float getMWidth() {
        return this.mWidth;
    }

    public final boolean isContentLayoutDefault$universe_ui_dialog_release() {
        return this.isContentLayoutDefault;
    }

    public final boolean isContentVisible$universe_ui_dialog_release() {
        return this.isContentVisible;
    }

    public final boolean isFooterLayoutDefault$universe_ui_dialog_release() {
        return this.isFooterLayoutDefault;
    }

    public final boolean isFooterVisible$universe_ui_dialog_release() {
        return this.isFooterVisible;
    }

    public final boolean isHeaderLayoutDefault$universe_ui_dialog_release() {
        return this.isHeaderLayoutDefault;
    }

    public final boolean isHeaderVisible$universe_ui_dialog_release() {
        return this.isHeaderVisible;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public void onShow() {
        adjustSize();
    }

    public UDDialogController(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.context = r3;
        this.mTitleSize = -1;
        this.mTitleTextColor = -1;
        this.mTitleLineCount = 2;
        this.mTitleGravity = -1;
        this.mTitlePaddingLeft = -1;
        this.mTitlePaddingTop = -1;
        this.mTitlePaddingRight = -1;
        this.mTitlePaddingBottom = -1;
        this.mMessageSize = -1;
        this.mMessageTextColor = -1;
        this.mMessagePaddingLeft = -1;
        this.mMessagePaddingTop = -1;
        this.mMessagePaddingRight = -1;
        this.mMessagePaddingBottom = -1;
        this.mMessageGravity = -1;
        this.mGravity = 17;
        this.mWidth = 1.0f;
        this.mMaxWidth = new UDDimension.a(LKUIToast.DURATION_MAX);
        this.mHeight = -2.0f;
        this.mMaxHeight = 1.0f;
        this.mAutoDismiss = true;
        this.mAllowContentScroll = true;
        this.mMaskAlpha = -1.0f;
        this.mActionButtonsOrientation = UDBaseDialogBuilder.ActionBottomOrientation.AUTO;
        this.mActionButtons = new ArrayList();
        this.mViewClickInfos = new ArrayList();
        this.isHeaderVisible = true;
        this.isContentVisible = true;
        this.isFooterVisible = true;
    }

    private final void applyDialogConfig(UDBaseDialogBuilder<?> r2) {
        if ((r2.getMGravity$universe_ui_dialog_release() & 80) == 80) goto L5;
        return;
    L5:
        if (this.mAnimStyle != 0) goto L9;
        UDDialog.Companion.getClass();
        UDDialog.access$getConfig$cp().getClass();
        this.mAnimStyle = 2131953921;
        return;
    }

    private final s08.a.AbstractC0123a toSize(float r3) {
        if (r3 <= 0.0f) goto L8;
        if (r3 > 1.0f) goto L8;
        return new s08.a.AbstractC0123a.b(r3);
    L8:
        if (r3 <= 1.0f) goto L11;
        return new s08.a.AbstractC0123a.C0124a((int) h18.d.a(this.context, r3));
    L11:
        return new s08.a.AbstractC0123a.C0124a((int) r3);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public void beforeCreate(UDDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        UDBaseDialogBuilder.c r0 = this.mLifecycleCallback;
        if (r0 == null) goto L6;
        r0.beforeCreate(r2);
        return;
    }

    public final void setContentLayoutDefault$universe_ui_dialog_release(boolean r1) {
        this.isContentLayoutDefault = r1;
    }

    public final void setContentVisible$universe_ui_dialog_release(boolean r1) {
        this.isContentVisible = r1;
    }

    public final void setFooterLayoutDefault$universe_ui_dialog_release(boolean r1) {
        this.isFooterLayoutDefault = r1;
    }

    public final void setFooterVisible$universe_ui_dialog_release(boolean r1) {
        this.isFooterVisible = r1;
    }

    public final void setHeaderLayoutDefault$universe_ui_dialog_release(boolean r1) {
        this.isHeaderLayoutDefault = r1;
    }

    public final void setHeaderVisible$universe_ui_dialog_release(boolean r1) {
        this.isHeaderVisible = r1;
    }

    public final void setMActionButtonsOrientation(UDBaseDialogBuilder.ActionBottomOrientation r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mActionButtonsOrientation = r2;
    }

    public final void setMAllowContentScroll(boolean r1) {
        this.mAllowContentScroll = r1;
    }

    public final void setMAnimStyle(int r1) {
        this.mAnimStyle = r1;
    }

    public final void setMAutoDismiss(boolean r1) {
        this.mAutoDismiss = r1;
    }

    public final void setMBackground(Drawable r1) {
        this.mBackground = r1;
    }

    public final void setMCancelable(Boolean r1) {
        this.mCancelable = r1;
    }

    public final void setMCanceledOnTouchOutside(Boolean r1) {
        this.mCanceledOnTouchOutside = r1;
    }

    public final void setMContentLayout(View r1) {
        this.mContentLayout = r1;
    }

    public final void setMContentLayoutRes(int r1) {
        this.mContentLayoutRes = r1;
    }

    public final void setMDialog(UDDialog r1) {
        this.mDialog = r1;
    }

    public final void setMFooterLayout(View r1) {
        this.mFooterLayout = r1;
    }

    public final void setMFooterLayoutRes(int r1) {
        this.mFooterLayoutRes = r1;
    }

    public final void setMGravity(int r1) {
        this.mGravity = r1;
    }

    public final void setMHeaderLayout(View r1) {
        this.mHeaderLayout = r1;
    }

    public final void setMHeaderLayoutRes(int r1) {
        this.mHeaderLayoutRes = r1;
    }

    public final void setMHeight(float r1) {
        this.mHeight = r1;
    }

    public final void setMLifecycleCallback(UDBaseDialogBuilder.c r1) {
        this.mLifecycleCallback = r1;
    }

    public final void setMMarginInDp(int r1) {
        this.mMarginInDp = r1;
    }

    public final void setMMaskAlpha(float r1) {
        this.mMaskAlpha = r1;
    }

    public final void setMMaxHeight(float r1) {
        this.mMaxHeight = r1;
    }

    public final void setMMaxWidth(UDDimension r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mMaxWidth = r2;
    }

    public final void setMMessage(CharSequence r1) {
        this.mMessage = r1;
    }

    public final void setMMessageGravity(int r1) {
        this.mMessageGravity = r1;
    }

    public final void setMMessagePaddingBottom(int r1) {
        this.mMessagePaddingBottom = r1;
    }

    public final void setMMessagePaddingLeft(int r1) {
        this.mMessagePaddingLeft = r1;
    }

    public final void setMMessagePaddingRight(int r1) {
        this.mMessagePaddingRight = r1;
    }

    public final void setMMessagePaddingTop(int r1) {
        this.mMessagePaddingTop = r1;
    }

    public final void setMMessageSize(int r1) {
        this.mMessageSize = r1;
    }

    public final void setMMessageTextColor(int r1) {
        this.mMessageTextColor = r1;
    }

    public final void setMOnCancelListener(DialogInterface.OnCancelListener r1) {
        this.mOnCancelListener = r1;
    }

    public final void setMOnDismissListener(DialogInterface.OnDismissListener r1) {
        this.mOnDismissListener = r1;
    }

    public final void setMPaddingBottomInDp(int r1) {
        this.mPaddingBottomInDp = r1;
    }

    public final void setMPaddingLeftInDp(int r1) {
        this.mPaddingLeftInDp = r1;
    }

    public final void setMPaddingRightInDp(int r1) {
        this.mPaddingRightInDp = r1;
    }

    public final void setMPaddingTopInDp(int r1) {
        this.mPaddingTopInDp = r1;
    }

    public final void setMRootLayout(View r1) {
        this.mRootLayout = r1;
    }

    public final void setMRootLayoutRes(int r1) {
        this.mRootLayoutRes = r1;
    }

    public final void setMTitle(CharSequence r1) {
        this.mTitle = r1;
    }

    public final void setMTitleGravity(int r1) {
        this.mTitleGravity = r1;
    }

    public final void setMTitleLineCount(int r1) {
        this.mTitleLineCount = r1;
    }

    public final void setMTitlePaddingBottom(int r1) {
        this.mTitlePaddingBottom = r1;
    }

    public final void setMTitlePaddingLeft(int r1) {
        this.mTitlePaddingLeft = r1;
    }

    public final void setMTitlePaddingRight(int r1) {
        this.mTitlePaddingRight = r1;
    }

    public final void setMTitlePaddingTop(int r1) {
        this.mTitlePaddingTop = r1;
    }

    public final void setMTitleSize(int r1) {
        this.mTitleSize = r1;
    }

    public final void setMTitleTextColor(int r1) {
        this.mTitleTextColor = r1;
    }

    public final void setMTitleTextStyleBold(Boolean r1) {
        this.mTitleTextStyleBold = r1;
    }

    public final void setMTranslationOnY(int r1) {
        this.mTranslationOnY = r1;
    }

    public final void setMWidth(float r1) {
        this.mWidth = r1;
    }

    public <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        this.mDialog = r3;
        r3.setCallback$universe_ui_dialog_release(this);
        this.mTitle = r2.getMTitle$universe_ui_dialog_release();
        this.mTitleSize = r2.getMTitleSize$universe_ui_dialog_release();
        this.mTitleTextColor = r2.getMTitleTextColor$universe_ui_dialog_release();
        this.mTitleTextStyleBold = r2.getMTitleTextStyleBold$universe_ui_dialog_release();
        this.mTitleLineCount = r2.getMTitleLineCount$universe_ui_dialog_release();
        this.mTitleGravity = r2.getMTitleGravity$universe_ui_dialog_release();
        this.mTitlePaddingLeft = r2.getMTitlePaddingLeft$universe_ui_dialog_release();
        this.mTitlePaddingTop = r2.getMTitlePaddingTop$universe_ui_dialog_release();
        this.mTitlePaddingRight = r2.getMTitlePaddingRight$universe_ui_dialog_release();
        this.mTitlePaddingBottom = r2.getMTitlePaddingBottom$universe_ui_dialog_release();
        this.mMessage = r2.getMMessage$universe_ui_dialog_release();
        this.mMessageSize = r2.getMMessageSize$universe_ui_dialog_release();
        this.mMessageTextColor = r2.getMMessageTextColor$universe_ui_dialog_release();
        this.mMessagePaddingLeft = r2.getMMessagePaddingLeft$universe_ui_dialog_release();
        this.mMessagePaddingTop = r2.getMMessagePaddingTop$universe_ui_dialog_release();
        this.mMessagePaddingRight = r2.getMMessagePaddingRight$universe_ui_dialog_release();
        this.mMessagePaddingBottom = r2.getMMessagePaddingBottom$universe_ui_dialog_release();
        this.mMessageGravity = r2.getMMessageGravity$universe_ui_dialog_release();
        this.mGravity = r2.getMGravity$universe_ui_dialog_release();
        this.mWidth = r2.getMWidth$universe_ui_dialog_release();
        this.mMaxWidth = r2.getMMaxWidth$universe_ui_dialog_release();
        this.mHeight = r2.getMHeight$universe_ui_dialog_release();
        this.mMaxHeight = r2.getMMaxHeight$universe_ui_dialog_release();
        this.mAutoDismiss = r2.getMAutoDismiss$universe_ui_dialog_release();
        this.mCancelable = r2.getMCancelable$universe_ui_dialog_release();
        this.mCanceledOnTouchOutside = r2.getMCanceledOnTouchOutside$universe_ui_dialog_release();
        this.mOnCancelListener = r2.getMOnCancelListener$universe_ui_dialog_release();
        this.mOnDismissListener = r2.getMOnDismissListener$universe_ui_dialog_release();
        this.mHeaderLayoutRes = r2.getMHeaderLayoutRes$universe_ui_dialog_release();
        this.mContentLayoutRes = r2.getMContentLayoutRes$universe_ui_dialog_release();
        this.mFooterLayoutRes = r2.getMFooterLayoutRes$universe_ui_dialog_release();
        this.mRootLayoutRes = r2.getMRootLayoutRes$universe_ui_dialog_release();
        this.mHeaderLayout = r2.getMHeaderLayout$universe_ui_dialog_release();
        this.mContentLayout = r2.getMContentLayout$universe_ui_dialog_release();
        this.mFooterLayout = r2.getMFooterLayout$universe_ui_dialog_release();
        this.mRootLayout = r2.getMRootLayout$universe_ui_dialog_release();
        this.mAllowContentScroll = r2.getMAllowContentScroll$universe_ui_dialog_release();
        this.mMarginInDp = r2.getMMarginInDp$universe_ui_dialog_release();
        this.mTranslationOnY = r2.getMTranslationOnY$universe_ui_dialog_release();
        this.mPaddingLeftInDp = r2.getMPaddingLeftInDp$universe_ui_dialog_release();
        this.mPaddingTopInDp = r2.getMPaddingTopInDp$universe_ui_dialog_release();
        this.mPaddingRightInDp = r2.getMPaddingRightInDp$universe_ui_dialog_release();
        this.mPaddingBottomInDp = r2.getMPaddingBottomInDp$universe_ui_dialog_release();
        this.mBackground = r2.getMBackground$universe_ui_dialog_release();
        this.mMaskAlpha = r2.getMMaskAlpha$universe_ui_dialog_release();
        this.mAnimStyle = r2.getMAnimStyle$universe_ui_dialog_release();
        this.mActionButtonsOrientation = r2.getMActionButtonsOrientation$universe_ui_dialog_release();
        this.mActionButtons.addAll(r2.getMActionButtons$universe_ui_dialog_release());
        this.mViewClickInfos.addAll(r2.getMViewClickInfos$universe_ui_dialog_release());
        this.mLifecycleCallback = r2.getMLifecycleCallback$universe_ui_dialog_release();
        if (this.mWidth != 1.0f) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
    L10:
        applyDialogConfig(r2);
        return;
    L8:
        if (this.mMarginInDp != 0) goto L10;
        this.mWidth = -1.0f;
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    public final float getSize(float r3, int r4) {
        if (r3 > 0.0f) goto L5;
        return 0.0f;
    L5:
        if (r3 > 1.0f) goto L8;
        return r4 * r3;
    L8:
        return h18.d.a(this.context, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public void onCreate(UDDialog r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Boolean r4 = this.mCancelable;
        if (r4 == null) goto L5;
        r2.setCancelable(r4.booleanValue());
    L5:
        Boolean r5 = this.mCanceledOnTouchOutside;
        if (r5 == null) goto L8;
        r2.setCanceledOnTouchOutside(r5.booleanValue());
    L8:
        DialogInterface.OnCancelListener r6 = this.mOnCancelListener;
        if (r6 == null) goto L11;
        r2.setOnCancelListener(r6);
    L11:
        DialogInterface.OnDismissListener r7 = this.mOnDismissListener;
        if (r7 == null) goto L14;
        r2.setOnDismissListener(r7);
    L14:
        Window r8 = r2.getWindow();
        int r0 = this.mAnimStyle;
        if (r0 == 0) goto L18;
        if (r8 == null) goto L18;
        r8.setWindowAnimations(r0);
    L18:
        initView();
        UDBaseDialogBuilder.c r9 = this.mLifecycleCallback;
        if (r9 == null) goto L22;
        r9.a(r2);
        return;
    }

    public final View getFinalView(View r1, int r2, int r3) {
        if (r1 != null) goto L12;
        if (r2 != 0) goto L8;
        r2 = r3;
    L8:
        if (r2 != 0) goto L10;
        return null;
    L10:
        return LayoutInflater.from(this.context).inflate(r2, null);
    L12:
        return r1;
    }

    public final void setupTextView(TextView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        if (r3 <= 0) goto L6;
        r2.setTextSize(2, r3);
    L6:
        if (r4 == (-1)) goto L9;
        r2.setTextColor(UDColorUtils.getColor(this.context, r4));
        return;
    }

    public final void setupViewPadding(View r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r5, "view");
        int r0 = (int) h18.d.b(this.context, r6);
        int r1 = (int) h18.d.b(this.context, r7);
        int r2 = (int) h18.d.b(this.context, r8);
        int r3 = (int) h18.d.b(this.context, r9);
        if (r6 >= 0) goto L5;
        r0 = r5.getPaddingLeft();
    L5:
        if (r7 >= 0) goto L7;
        r1 = r5.getPaddingTop();
    L7:
        if (r8 >= 0) goto L9;
        r2 = r5.getPaddingRight();
    L9:
        if (r9 >= 0) goto L11;
        r3 = r5.getPaddingBottom();
    L11:
        r5.setPadding(r0, r1, r2, r3);
    }
}
