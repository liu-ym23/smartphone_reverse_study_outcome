package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.c.i;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.h;
import com.obric.oui.material.l;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ¿\u00032\u00020\u00012\u00020\u00022\u00020\u0003:\u0010½\u0003¾\u0003¿\u0003À\u0003Á\u0003Â\u0003Ã\u0003Ä\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010_\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\b\b\u0002\u0010a\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020.H\u0007J(\u0010_\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\b\u0010c\u001a\u0004\u0018\u00010dJ$\u0010_\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010_\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ$\u0010_\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010_\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ$\u0010h\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\b\b\u0002\u0010a\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020.H\u0007J(\u0010h\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\b\u0010c\u001a\u0004\u0018\u00010dJ$\u0010h\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010h\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ$\u0010h\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010h\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ$\u0010i\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\b\b\u0002\u0010a\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020.H\u0007J(\u0010i\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\b\u0010c\u001a\u0004\u0018\u00010dJ$\u0010i\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010i\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ$\u0010i\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010i\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ$\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020g2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020g2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ$\u0010l\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\b\b\u0002\u0010a\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020.H\u0007J(\u0010l\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\b\u0010c\u001a\u0004\u0018\u00010dJ$\u0010l\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010l\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ$\u0010l\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\b\b\u0002\u0010a\u001a\u00020\t2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ*\u0010l\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\u0006\u0010a\u001a\u00020\t2\u0006\u0010b\u001a\u00020.2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ\"\u0010m\u001a\u00020\r2\u0006\u0010n\u001a\u00020o2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\"\u0010q\u001a\u00020\r2\u0006\u0010r\u001a\u00020\t2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\b\u0010s\u001a\u00020\rH\u0002J.\u0010t\u001a\u00020\r2\u0006\u0010u\u001a\u00020\u00152\u000e\u0010v\u001a\n\u0012\u0004\u0012\u00020x\u0018\u00010w2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\u000f0wH\u0002J\u001a\u0010z\u001a\u00020\r2\b\u0010{\u001a\u0004\u0018\u00010)2\u0006\u0010y\u001a\u00020|H\u0002J\u0010\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020.H\u0016J\u0010\u0010\u007f\u001a\u00020\r2\u0006\u0010~\u001a\u00020.H\u0016J\t\u0010\u0080\u0001\u001a\u00020\rH\u0002J(\u0010\u0081\u0001\u001a\u00020\r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\b\u0002\u0010b\u001a\u00020.2\t\b\u0002\u0010\u0084\u0001\u001a\u00020.H\u0007J2\u0010\u0085\u0001\u001a\u00020\r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\b\u0002\u0010b\u001a\u00020.2\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0000¢\u0006\u0003\b\u0087\u0001J\u0013\u0010\u0088\u0001\u001a\u00020\r2\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J/\u0010\u008b\u0001\u001a\u00020\r2\u0006\u0010u\u001a\u00020\u00152\u0007\u0010\u008c\u0001\u001a\u00020\t2\u0013\u0010\u008d\u0001\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0OH\u0002J&\u0010\u008e\u0001\u001a\u00020\r2\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0092\u0001\u001a\u00020\tH\u0002J\u0013\u0010\u0093\u0001\u001a\u00020\r2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002J.\u0010\u0096\u0001\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.2\u0019\u0010\u0097\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0O¢\u0006\u0003\b\u0098\u0001H\u0007JJ\u0010\u0099\u0001\u001a\u00020.2\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010o2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010o2\u0007\u0010\u009e\u0001\u001a\u00020o2\u0007\u0010\u009f\u0001\u001a\u00020o2\u0007\u0010 \u0001\u001a\u00020\tH\u0002¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020\rH\u0002J\t\u0010£\u0001\u001a\u00020\rH\u0002J\u000f\u0010¤\u0001\u001a\u00020\rH\u0000¢\u0006\u0003\b¥\u0001J\t\u0010¦\u0001\u001a\u00020|H\u0002J\t\u0010§\u0001\u001a\u00020)H\u0002J\u0010\u0010¨\u0001\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b©\u0001J\n\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\t\u0010¬\u0001\u001a\u00020\tH\u0002J5\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020x0w2\r\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020x0w2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u0010\u0010°\u0001\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\b±\u0001J\u0011\u0010²\u0001\u001a\u00020\t2\u0006\u0010`\u001a\u00020\u000fH\u0002J\b\u0010³\u0001\u001a\u00030\u0083\u0001J\n\u0010´\u0001\u001a\u00030\u008a\u0001H\u0002J/\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020x0w2\u0006\u0010u\u001a\u00020\u00152\r\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020x0w2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u001d\u0010¶\u0001\u001a\u00020|2\u0007\u0010·\u0001\u001a\u00020)2\t\b\u0002\u0010¸\u0001\u001a\u00020.H\u0002JC\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\r\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020x0w2\u0007\u0010¯\u0001\u001a\u00020\t2\u000f\b\u0002\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\t\b\u0002\u0010¸\u0001\u001a\u00020.H\u0002J\u001b\u0010¼\u0001\u001a\u00020\u000f2\u0007\u0010\u0092\u0001\u001a\u00020\t2\u0007\u0010½\u0001\u001a\u00020\tH\u0002J(\u0010¾\u0001\u001a\u00030¿\u00012\r\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0wH\u0002J\u0019\u0010Â\u0001\u001a\u00020)2\u0006\u0010{\u001a\u00020)2\u0006\u0010y\u001a\u00020|H\u0002J\u001a\u0010Ã\u0001\u001a\u00020\u000f2\u0006\u0010e\u001a\u00020\t2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u001a\u0010Ä\u0001\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020g2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u001a\u0010Å\u0001\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020g2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J-\u0010Æ\u0001\u001a\u0004\u0018\u00010\u000f2\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010É\u0001\u001a\u00020\t2\r\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020x0wH\u0002J\u0017\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\u0006\u0010u\u001a\u00020\u0015H\u0002J\t\u0010Ì\u0001\u001a\u00020\rH\u0002J\u001c\u0010Í\u0001\u001a\u00030Î\u00012\u0007\u0010Ï\u0001\u001a\u00020.2\u0007\u0010Ð\u0001\u001a\u00020.H\u0002J-\u0010Ñ\u0001\u001a\u00020\r2\u0006\u0010r\u001a\u00020\t2\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0007\u0010Ô\u0001\u001a\u00020\rJ\u000f\u0010Õ\u0001\u001a\u00020gH\u0000¢\u0006\u0003\bÖ\u0001J\u0011\u0010×\u0001\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0003\bØ\u0001J\u0007\u0010Ù\u0001\u001a\u00020 J\t\u0010Ú\u0001\u001a\u00020\tH\u0002J\u0007\u0010Û\u0001\u001a\u00020 J\t\u0010Ü\u0001\u001a\u00020\u000fH\u0002J\u0018\u0010Ý\u0001\u001a\u00020\t2\r\u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0wH\u0002J\u0011\u0010ß\u0001\u001a\u00020\t2\u0006\u0010`\u001a\u00020\u000fH\u0002J\u0018\u0010ß\u0001\u001a\u00020\t2\r\u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0wH\u0002J'\u0010à\u0001\u001a\u00020\t2\r\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\r\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0wH\u0002J\t\u0010á\u0001\u001a\u00020\tH\u0002J\u0007\u0010â\u0001\u001a\u00020 J\u0007\u0010ã\u0001\u001a\u00020 J\t\u0010ä\u0001\u001a\u00020\tH\u0002J\u0013\u0010å\u0001\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010æ\u0001\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010ç\u0001\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010è\u0001\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0011\u0010é\u0001\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\t\u0010ê\u0001\u001a\u00020\rH\u0002J\t\u0010ë\u0001\u001a\u00020\rH\u0002J\u000f\u0010ì\u0001\u001a\u00020\rH\u0000¢\u0006\u0003\bí\u0001J\u001b\u0010î\u0001\u001a\u00020.2\u0007\u0010ï\u0001\u001a\u00020.2\u0007\u0010ð\u0001\u001a\u00020.H\u0002J\u0006\u0010F\u001a\u00020.J\t\u0010ñ\u0001\u001a\u00020.H\u0002J\t\u0010ò\u0001\u001a\u00020.H\u0002J\u0012\u0010ó\u0001\u001a\u00020.2\u0007\u0010ô\u0001\u001a\u00020.H\u0002J\t\u0010ô\u0001\u001a\u00020.H\u0002J\u000f\u0010õ\u0001\u001a\u00020.H\u0000¢\u0006\u0003\bö\u0001J\t\u0010÷\u0001\u001a\u00020.H\u0002J\u000f\u0010ø\u0001\u001a\u00020\rH\u0000¢\u0006\u0003\bù\u0001J\u000f\u0010ú\u0001\u001a\u00020\rH\u0000¢\u0006\u0003\bû\u0001J\u0018\u0010ü\u0001\u001a\u00020\r2\u0007\u0010ý\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\bþ\u0001J\u0018\u0010ÿ\u0001\u001a\u00020\r2\u0007\u0010ý\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b\u0080\u0002J\t\u0010\u0081\u0002\u001a\u00020\rH\u0014J\u0015\u0010\u0082\u0002\u001a\u00020\r2\n\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0084\u0002H\u0014J\t\u0010\u0085\u0002\u001a\u00020\rH\u0014J\t\u0010\u0086\u0002\u001a\u00020\rH\u0014J\u000f\u0010\u0087\u0002\u001a\u00020\rH\u0000¢\u0006\u0003\b\u0088\u0002J\u001a\u0010\u0089\u0002\u001a\u00020\r2\t\b\u0002\u0010\u008a\u0002\u001a\u00020.H\u0000¢\u0006\u0003\b\u008b\u0002J\u0018\u0010\u008c\u0002\u001a\u00020\r2\u0007\u0010\u008d\u0002\u001a\u00020.H\u0000¢\u0006\u0003\b\u008e\u0002J6\u0010\u008f\u0002\u001a\u00020\r2\u0007\u0010\u0090\u0002\u001a\u00020.2\u0007\u0010\u0091\u0002\u001a\u00020\t2\u0007\u0010\u0092\u0002\u001a\u00020\t2\u0007\u0010\u0093\u0002\u001a\u00020\t2\u0007\u0010\u0094\u0002\u001a\u00020\tH\u0014J\u001b\u0010\u0095\u0002\u001a\u00020\r2\u0007\u0010\u0096\u0002\u001a\u00020\t2\u0007\u0010\u0097\u0002\u001a\u00020\tH\u0014J\u0012\u0010\u0098\u0002\u001a\u00020\r2\u0007\u0010\u0099\u0002\u001a\u00020.H\u0016J\u0012\u0010\u009a\u0002\u001a\u00020\r2\u0007\u0010\u009b\u0002\u001a\u00020\tH\u0014J\u0007\u0010\u009c\u0002\u001a\u00020\rJ6\u0010\u009d\u0002\u001a\u00020\r2\u0007\u0010\u009e\u0002\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t2\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001c\u0010\u009f\u0002\u001a\u00020.2\u000b\b\u0002\u0010ý\u0001\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0003\b \u0002J\t\u0010¡\u0002\u001a\u00020\rH\u0002J\t\u0010¢\u0002\u001a\u00020\rH\u0002J\t\u0010£\u0002\u001a\u00020\rH\u0002J\u0013\u0010¤\u0002\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010¥\u0002\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010¦\u0002\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010§\u0002\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010¨\u0002\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u001b\u0010©\u0002\u001a\u00020\r2\u0006\u0010a\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0007\u0010ª\u0002\u001a\u00020\rJ\u0013\u0010«\u0002\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u001b\u0010¬\u0002\u001a\u00020\r2\u0006\u0010a\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010\u00ad\u0002\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u001b\u0010®\u0002\u001a\u00020\r2\u0006\u0010a\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010¯\u0002\u001a\u00020\r2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u001b\u0010°\u0002\u001a\u00020\r2\u0006\u0010a\u001a\u00020\t2\b\b\u0002\u0010b\u001a\u00020.H\u0007J\u0013\u0010±\u0002\u001a\u00020\r2\b\u0010²\u0002\u001a\u00030\u0090\u0001H\u0002J\u001e\u0010³\u0002\u001a\u00030Ó\u00012\b\u0010´\u0002\u001a\u00030¿\u00012\b\u0010µ\u0002\u001a\u00030¿\u0001H\u0002J'\u0010¶\u0002\u001a\u00030·\u00022\b\u0010´\u0002\u001a\u00030¿\u00012\b\u0010µ\u0002\u001a\u00030¿\u00012\u0007\u0010¸\u0002\u001a\u00020oH\u0002J\u0014\u0010¹\u0002\u001a\u00030º\u00022\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\u0013\u0010»\u0002\u001a\u0004\u0018\u00010g2\u0006\u0010e\u001a\u00020\tH\u0002J\u0014\u0010¼\u0002\u001a\u00030\u009b\u00012\b\u0010½\u0002\u001a\u00030·\u0002H\u0002J?\u0010¾\u0002\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010o0¿\u00022\b\u0010½\u0002\u001a\u00030·\u00022\b\u0010´\u0002\u001a\u00030¿\u00012\b\u0010µ\u0002\u001a\u00030¿\u00012\u0007\u0010¸\u0002\u001a\u00020oH\u0002¢\u0006\u0003\u0010À\u0002J'\u0010Á\u0002\u001a\u00020\r2\u0007\u0010·\u0001\u001a\u00020)2\u0007\u0010Â\u0002\u001a\u00020|2\n\u0010Ã\u0002\u001a\u0005\u0018\u00010Ä\u0002H\u0002J\u0019\u0010Å\u0002\u001a\u00020\r2\b\u0010\u0082\u0001\u001a\u00030Ä\u0002H\u0000¢\u0006\u0003\bÆ\u0002J\u0019\u0010Ç\u0002\u001a\u00020\r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0000¢\u0006\u0003\bÈ\u0002J\u0013\u0010É\u0002\u001a\u00020\r2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0018\u0010Ê\u0002\u001a\u00020\r2\r\u0010Ë\u0002\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002JV\u0010Ì\u0002\u001a\u00020\r2\b\u0010½\u0002\u001a\u00030·\u00022\b\u0010´\u0002\u001a\u00030¿\u00012\b\u0010µ\u0002\u001a\u00030¿\u00012\u0007\u0010¸\u0002\u001a\u00020o2\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0007\u0010 \u0001\u001a\u00020\t2\u0011\b\u0002\u0010\u0086\u0001\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0010\u0010Í\u0002\u001a\u00030Ä\u0002H\u0000¢\u0006\u0003\bÎ\u0002J \u0010Ï\u0002\u001a\u00020\r2\u000f\u0010Ð\u0002\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0000¢\u0006\u0003\bÑ\u0002J#\u0010Ò\u0002\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020.2\t\b\u0002\u0010\u008a\u0002\u001a\u00020.H\u0000¢\u0006\u0003\bÓ\u0002JL\u0010Ô\u0002\u001a\u00020\r2\u0006\u0010u\u001a\u00020\u00152\u0006\u0010a\u001a\u00020\t2\u0007\u0010Õ\u0002\u001a\u00020.2\r\u0010Ö\u0002\u001a\b\u0012\u0004\u0012\u00020x0w2\u0019\u0010×\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020x0w\u0012\u0004\u0012\u00020)0OH\u0002J\u0013\u0010Ø\u0002\u001a\u00020\r2\b\u0010`\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010Ù\u0002\u001a\u00020\r2\u0006\u0010a\u001a\u00020\t2\u0007\u0010Õ\u0002\u001a\u00020.J\u0010\u0010Ú\u0002\u001a\u00020\r2\u0007\u0010\u008c\u0001\u001a\u00020\tJ\u000f\u0010Û\u0002\u001a\u00020\r2\u0006\u0010`\u001a\u00020\u000fJ\u0010\u0010Ü\u0002\u001a\u00020\r2\u0007\u0010Ý\u0002\u001a\u00020\tJ\u0010\u0010Þ\u0002\u001a\u00020\r2\u0007\u0010ß\u0002\u001a\u00020\tJ\u0011\u0010à\u0002\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010gJ\u0010\u0010á\u0002\u001a\u00020\r2\u0007\u0010Ý\u0002\u001a\u00020\tJ\u0011\u0010á\u0002\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010gJ\u0010\u0010â\u0002\u001a\u00020\r2\u0007\u0010ß\u0002\u001a\u00020\tJ\t\u0010ã\u0002\u001a\u00020\rH\u0002J\t\u0010ä\u0002\u001a\u00020\rH\u0007J\u0018\u0010å\u0002\u001a\u00020\r2\u0006\u0010a\u001a\u00020\t2\u0007\u0010Õ\u0002\u001a\u00020.J\u0010\u0010æ\u0002\u001a\u00020\r2\u0007\u0010\u008c\u0001\u001a\u00020\tJ \u0010ç\u0002\u001a\u00020\r2\u000f\u0010è\u0002\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0000¢\u0006\u0003\bé\u0002J\u0010\u0010ê\u0002\u001a\u00020\r2\u0007\u0010Õ\u0002\u001a\u00020.J\u0012\u0010ë\u0002\u001a\u00020\r2\t\u0010è\u0002\u001a\u0004\u0018\u00010@J\u0018\u0010ì\u0002\u001a\u00020\r2\u0007\u0010í\u0002\u001a\u00020.H\u0000¢\u0006\u0003\bî\u0002J\u001a\u0010ï\u0002\u001a\u00020\r2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0003\u0010ð\u0002J\u0018\u0010ñ\u0002\u001a\u00020\r2\u0007\u0010ò\u0002\u001a\u00020.H\u0000¢\u0006\u0003\bó\u0002J\u0013\u0010ô\u0002\u001a\u00020\r2\b\u0010õ\u0002\u001a\u00030ö\u0002H\u0007J\u0010\u0010÷\u0002\u001a\u00020\r2\u0007\u0010ø\u0002\u001a\u00020oJ\u0018\u0010ù\u0002\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020.H\u0000¢\u0006\u0003\bú\u0002J\u0018\u0010û\u0002\u001a\u00020\r2\u0006\u0010a\u001a\u00020\t2\u0007\u0010Õ\u0002\u001a\u00020.J\u0010\u0010ü\u0002\u001a\u00020\r2\u0007\u0010\u008c\u0001\u001a\u00020\tJ\u0010\u0010ý\u0002\u001a\u00020\r2\u0007\u0010ß\u0002\u001a\u00020\tJ\u0010\u0010þ\u0002\u001a\u00020\r2\u0007\u0010Ý\u0002\u001a\u00020\tJ\u0011\u0010þ\u0002\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010gJ\u0010\u0010ÿ\u0002\u001a\u00020\r2\u0007\u0010Ý\u0002\u001a\u00020\tJ\u0011\u0010ÿ\u0002\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010gJ\u0010\u0010\u0080\u0003\u001a\u00020\r2\u0007\u0010ß\u0002\u001a\u00020\tJ\u0018\u0010\u0081\u0003\u001a\u00020\r2\u0006\u0010a\u001a\u00020\t2\u0007\u0010Õ\u0002\u001a\u00020.J\u0010\u0010\u0082\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0001\u001a\u00020\tJ\u0012\u0010\u0083\u0003\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020.H\u0002J\u0018\u0010\u0084\u0003\u001a\u00020\r2\u0007\u0010\u0085\u0003\u001a\u00020.H\u0000¢\u0006\u0003\b\u0086\u0003J\u0012\u0010\u0087\u0003\u001a\u00020\r2\t\u0010è\u0002\u001a\u0004\u0018\u00010^J\u0010\u0010\u0088\u0003\u001a\u00020\r2\u0007\u0010½\u0002\u001a\u00020\tJ\u001d\u0010\u0089\u0003\u001a\u00020.2\b\u0010´\u0002\u001a\u00030¿\u00012\b\u0010µ\u0002\u001a\u00030¿\u0001H\u0002J\u001d\u0010\u008a\u0003\u001a\u00020.2\b\u0010´\u0002\u001a\u00030¿\u00012\b\u0010µ\u0002\u001a\u00030¿\u0001H\u0002J\u0010\u0010\u008b\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.J\u0018\u0010\u008b\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.2\u0006\u0010b\u001a\u00020.J\u0010\u0010\u008d\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.J\u0010\u0010\u008e\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.J\u0018\u0010\u008e\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.2\u0006\u0010b\u001a\u00020.J\u0010\u0010\u008f\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.J\u0010\u0010\u0090\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.J\u0018\u0010\u0090\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.2\u0006\u0010b\u001a\u00020.J\u0010\u0010\u0091\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.J\u0018\u0010\u0091\u0003\u001a\u00020\r2\u0007\u0010\u008c\u0003\u001a\u00020.2\u0006\u0010b\u001a\u00020.JA\u0010\u0092\u0003\u001a\u00020\u001e2\u0007\u0010\u0093\u0003\u001a\u00020o2\u0006\u0010n\u001a\u00020o2\u0013\u0010\u0094\u0003\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020\r0O2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0011\u0010\u0095\u0003\u001a\u00020\r2\b\u0010\u0096\u0003\u001a\u00030\u0097\u0003J\u0011\u0010\u0098\u0003\u001a\u00020\r2\b\u0010\u0096\u0003\u001a\u00030\u0097\u0003JA\u0010\u0099\u0003\u001a\u00020\u001e2\u0007\u0010\u0093\u0003\u001a\u00020o2\u0006\u0010n\u001a\u00020o2\u0013\u0010\u0094\u0003\u001a\u000e\u0012\u0004\u0012\u00020o\u0012\u0004\u0012\u00020\r0O2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J:\u0010\u009a\u0003\u001a\u00020\r2\b\u0010´\u0002\u001a\u00030¿\u00012\b\u0010µ\u0002\u001a\u00030¿\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0011\b\u0002\u0010\u0086\u0001\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u001c\u0010\u009b\u0003\u001a\u00020\r2\u0007\u0010·\u0001\u001a\u00020)2\b\b\u0002\u0010b\u001a\u00020.H\u0007JL\u0010\u009b\u0003\u001a\u00020|2\b\u0010{\u001a\u0004\u0018\u00010)2\u0006\u0010y\u001a\u00020|2\u0006\u0010b\u001a\u00020.2\t\b\u0002\u0010\u0084\u0001\u001a\u00020.2\u0011\b\u0002\u0010\u0086\u0001\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\t\b\u0002\u0010\u009c\u0003\u001a\u00020.H\u0002JU\u0010\u009d\u0003\u001a\u00020|2\u000f\b\u0002\u0010\u009e\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\u000f\b\u0002\u0010\u009f\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\u000f\b\u0002\u0010 \u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\u000f\b\u0002\u0010¡\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0w2\u0006\u0010b\u001a\u00020.H\u0002JU\u0010¢\u0003\u001a\u00020|2\u000f\b\u0002\u0010\u009e\u0003\u001a\b\u0012\u0004\u0012\u00020x0w2\u000f\b\u0002\u0010\u009f\u0003\u001a\b\u0012\u0004\u0012\u00020x0w2\u000f\b\u0002\u0010 \u0003\u001a\b\u0012\u0004\u0012\u00020x0w2\u000f\b\u0002\u0010¡\u0003\u001a\b\u0012\u0004\u0012\u00020x0w2\u0006\u0010b\u001a\u00020.H\u0002J\u0012\u0010£\u0003\u001a\u00020\r2\u0007\u0010¤\u0003\u001a\u00020\tH\u0016J\u0011\u0010¥\u0003\u001a\u00020\r2\u0006\u0010H\u001a\u00020.H\u0016JB\u0010¦\u0003\u001a\u00020\r2\b\u0010´\u0002\u001a\u00030¿\u00012\b\u0010µ\u0002\u001a\u00030¿\u00012\u0006\u0010b\u001a\u00020.2\b\u0010Ò\u0001\u001a\u00030Ó\u00012\u0011\b\u0002\u0010\u0086\u0001\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0013\u0010§\u0003\u001a\u00020\r2\b\u0010µ\u0002\u001a\u00030¿\u0001H\u0002J\u001a\u0010¨\u0003\u001a\u00020\r2\u0006\u0010u\u001a\u00020\u00152\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u0010\u0010©\u0003\u001a\u00020\r2\u0007\u0010ª\u0003\u001a\u00020\tJA\u0010«\u0003\u001a\u00020\r2\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010o2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010o2\u0007\u0010\u009e\u0001\u001a\u00020o2\u0007\u0010\u009f\u0001\u001a\u00020oH\u0002¢\u0006\u0003\u0010¬\u0003J\u001c\u0010\u00ad\u0003\u001a\u00020\r2\b\u0010`\u001a\u0004\u0018\u00010\u000f2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u0017\u0010®\u0003\u001a\u00020\r2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0016\u0010¯\u0003\u001a\u0004\u0018\u00010d2\t\u0010è\u0002\u001a\u0004\u0018\u00010dH\u0002J*\u0010°\u0003\u001a\b\u0012\u0004\u0012\u00020x0w*\b\u0012\u0004\u0012\u00020x0w2\u0006\u0010a\u001a\u00020\t2\u0007\u0010±\u0003\u001a\u00020xH\u0002J)\u0010²\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0w*\b\u0012\u0004\u0012\u00020\u000f0w2\u0006\u0010a\u001a\u00020\t2\u0006\u0010`\u001a\u00020\u000fH\u0002J\u001b\u0010³\u0003\u001a\u00020\t*\b\u0012\u0004\u0012\u00020x0w2\u0006\u0010a\u001a\u00020\tH\u0002J\u001b\u0010´\u0003\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u000f0w2\u0006\u0010a\u001a\u00020\tH\u0002J!\u0010µ\u0003\u001a\b\u0012\u0004\u0012\u00020x0w*\b\u0012\u0004\u0012\u00020x0w2\u0006\u0010a\u001a\u00020\tH\u0002J\u0019\u0010¶\u0003\u001a\b\u0012\u0004\u0012\u00020x0w*\b\u0012\u0004\u0012\u00020x0wH\u0002J*\u0010Ô\u0002\u001a\b\u0012\u0004\u0012\u00020x0w*\b\u0012\u0004\u0012\u00020x0w2\u0006\u0010a\u001a\u00020\t2\u0007\u0010Õ\u0002\u001a\u00020.H\u0002J\u000e\u0010·\u0003\u001a\u00020x*\u00030¸\u0003H\u0002J\u0017\u0010¹\u0003\u001a\u00030¸\u0003*\u00020x2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u0016\u0010º\u0003\u001a\u00020x*\u00020x2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u0016\u0010»\u0003\u001a\u00020x*\u00020x2\u0007\u0010¼\u0003\u001a\u00020\u000fH\u0002R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\u000e\u00103\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u000e\u00108\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010ER\u000e\u0010F\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020,0OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0017\"\u0004\bT\u0010\u0019R\u000e\u0010U\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Å\u0003"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actionChangeInterruptCallback", "Lkotlin/Function0;", "", "backdropTarget", "Landroid/view/View;", "batchSetDepth", "boundActionHostRef", "Ljava/lang/ref/WeakReference;", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "centerButtonGroup", "Lcom/obric/oui/button/OButtonGroup;", "getCenterButtonGroup", "()Lcom/obric/oui/button/OButtonGroup;", "setCenterButtonGroup", "(Lcom/obric/oui/button/OButtonGroup;)V", "centerButtonGroupStyle", "centerContainer", "centerCustomContainer", "centerShiftAnimator", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "centerSubtitleView", "Lcom/obric/oui/text/OTextView;", "centerTintColor", "centerTitleContainer", "Landroid/widget/LinearLayout;", "centerTitleGapLargeFontPx", "centerTitleGapPx", "centerTitleHorizontalPaddingPx", "centerTitleView", "currentActionsState", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionsState;", "currentHostSyncActionsState", "currentMaskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "enableFloatingTransition", "", "endAreaTransitionGeneration", "endButtonGroup", "getEndButtonGroup", "setEndButtonGroup", "endButtonGroupStyle", "endContainer", "endSubButtonGroup", "getEndSubButtonGroup", "setEndSubButtonGroup", "endSubButtonGroupStyle", "endSubShiftAnimator", "endSubTintColor", "endTintColor", "floatingTransitionBridge", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;", "floatingTransitionDrawUpdateListener", "floatingTransitionEndListener", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$OnFloatingTransitionEndListener;", "floatingTransitionOwnerActive", "floatingWindowHelper", "Lcom/obric/oui/window/floating/OFloatingWindowHelper;", "freezeEndAreaWidth", "Ljava/lang/Integer;", "isActionContentVisible", "isActionTouchEventBlocked", "isBackdropView", "isCenterOverflow", "isNonActionContentVisible", "keepActionInteractiveWhenHidden", "mIsLargeFont", "mType", "maskMaterial", "Lkotlin/Function1;", "materialMask", "materialSrcType", "startButtonGroup", "getStartButtonGroup", "setStartButtonGroup", "startButtonGroupStyle", "startContainer", "startSubtitleView", "startTintColor", "startTitleContainer", "startTitleView", "subEndToEndGapPx", "titleBarContainer", "titleBarTransitionEndListener", "Lcom/obric/oui/titlebar/OFloatingTitleBar$OnTitleBarTransitionEndListener;", "addCenterAction", "view", "index", "animate", "onClick", "Landroid/view/View$OnClickListener;", "iconRes", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "addEndAction", "addStartAction", "addStartTitleArrowAction", "title", "addSubEndAction", "animateEndSubTranslationTo", TypedValues.AttributesType.S_TARGET, "", "onFinished", "animateFreezeEndAreaWidthTo", "targetWidth", "applyActionContentVisibility", "applyActionGroupEnabledState", "group", "targetActions", "", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionItem;", "targetViews", "applyActionGroupsEnabledState", "targetState", "Lcom/obric/oui/titlebar/OFloatingTitleBar$ActionTargetViews;", "applyContentMaterial", "apply", "applyMaskMaterial", "applyNonActionContentVisibility", "applyState", "state", "Lcom/obric/oui/titlebar/OFloatingTitleBarState;", "interruptForActionChange", "applyStateForFloatingTransition", "onTransitionEnd", "applyStateForFloatingTransition$OUI_standardRelease", "applyStyleState", "style", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$StyleState;", "applyStyleToGroup", "styleRes", "onTintColorChanged", "applyTitleWidthPlaceholder", "titleView", "Landroid/widget/TextView;", "subtitleView", "width", "applyTitleWidthPlaceholders", Params.CONTENT, "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ContentState;", "batchSet", "block", "Lkotlin/ExtensionFunctionType;", "bindSubEndShiftToEndRawAlphaIfNeeded", "binding", "Lcom/obric/oui/titlebar/OFloatingTitleBar$SubEndShiftEndRawAlphaBinding;", "subEndShiftStart", "subEndShiftTarget", "endRawAlphaStart", "endRawAlphaTarget", PendingPersonalInfoNotificationTask.KEY_GENERATION, "(Lcom/obric/oui/titlebar/OFloatingTitleBar$SubEndShiftEndRawAlphaBinding;Ljava/lang/Float;Ljava/lang/Float;FFI)Z", "cancelCenterShiftAnimation", "cancelEndAreaShiftAnimators", "cancelPendingFloatingTransitionSourceAnimation", "cancelPendingFloatingTransitionSourceAnimation$OUI_standardRelease", "captureActionTargetViews", "captureActionsState", "captureAnimationState", "captureAnimationState$OUI_standardRelease", "captureBoundsState", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$BoundsState;", "captureContentTopInset", "captureHostSyncActions", "sourceActions", "tintColor", "captureHostSyncState", "captureHostSyncState$OUI_standardRelease", "captureMeasuredWidth", "captureState", "captureStyleState", "captureVisibleActions", "createActionTargetViews", "actionsState", "applyEnabled", "createActionViews", "items", "reusableViews", "createCenterCustomPlaceholder", "height", "createEndAreaSnapshot", "Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaSnapshot;", "subEndViews", "endViews", "createHostSyncActionsState", "createIconActionView", "createTextActionView", "createTitleArrowActionView", "createViewForSavedAction", "itemState", "Lcom/obric/oui/button/OButtonGroup$ItemAnimationState;", "fallbackTintColor", "currentActions", "currentActionViews", "dispatchTitleBarTransitionEnd", "endAreaState", "Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaActionState;", "hasSubEnd", "hasEnd", "finishCenterForEndAreaTransition", "centerAvoidanceMode", "Lcom/obric/oui/titlebar/OFloatingTitleBar$CenterAvoidanceMode;", "finishFloatingTransitionForUserInteraction", "floatingTransitionDebugSummary", "floatingTransitionDebugSummary$OUI_standardRelease", "getBoundActionHost", "getBoundActionHost$OUI_standardRelease", "getCenterSubtitleView", "getCenterTitleGap", "getCenterTitleView", "getDefaultTargetView", "getEndActionTargetContentWidth", "views", "getEndActionTargetWidth", "getEndAreaTargetWidth", "getEndAreaWidthForCenter", "getStartSubtitleView", "getStartTitleView", "getSubEndToEndGap", "hideCenterAction", "hideEndAction", "hideStartAction", "hideSubEndAction", "initAttrs", "initViews", "interruptFloatingTransitionForActionChange", "interruptFloatingTransitionForHostTargetChange", "interruptFloatingTransitionForHostTargetChange$OUI_standardRelease", "isActionContentVisibilityApplied", "visible", "blockTouchEvent", "isCenterVis", "isDarkTheme", "isEndAreaOccupiedForCenter", "isEndVis", "isFloatingSurfaceTransitionRunning", "isFloatingSurfaceTransitionRunning$OUI_standardRelease", "isStartVis", "notifyFloatingTransitionDrawUpdate", "notifyFloatingTransitionDrawUpdate$OUI_standardRelease", "notifyFloatingTransitionStateChanged", "notifyFloatingTransitionStateChanged$OUI_standardRelease", "onActionHostBound", "host", "onActionHostBound$OUI_standardRelease", "onActionHostUnbound", "onActionHostUnbound$OUI_standardRelease", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "onFinishInflate", "onFloatingTransitionEnd", "onFloatingTransitionEnd$OUI_standardRelease", "onFloatingTransitionHideActions", "interactive", "onFloatingTransitionHideActions$OUI_standardRelease", "onFloatingTransitionRestoreTargetState", "keepHidden", "onFloatingTransitionRestoreTargetState$OUI_standardRelease", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onWindowFocusChanged", "hasWindowFocus", "onWindowVisibilityChanged", "visibility", "pauseActionAnimations", "prepareCenterForEndAreaTransition", "sourceWidth", "prepareFloatingTransitionLaunch", "prepareFloatingTransitionLaunch$OUI_standardRelease", "refreshDimensionCache", "refreshSubEndToEndGapForCurrentState", "releaseFreezeEndAreaWidth", "removeAllCenterAction", "removeAllEndAction", "removeAllStartAction", "removeAllSubEndAction", "removeCenterAction", "removeCenterActionAt", "removeCenterCustomView", "removeEndAction", "removeEndActionAt", "removeStartAction", "removeStartActionAt", "removeSubEndAction", "removeSubEndActionAt", "resetTitleVis", "txt", "resolveCenterAvoidanceMode", "previousEndArea", "targetEndArea", "resolveEndAreaTransitionType", "Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaTransitionType;", "currentSubEndShift", "resolveEndRawAlphaRange", "", "resolveIconResourceName", "resolveSubEndShiftEndRawAlphaBinding", "type", "resolveSubEndShiftRange", "", "(Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaTransitionType;Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaSnapshot;Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaSnapshot;F)[Ljava/lang/Float;", "restoreActionsInBatch", "actionViews", "animationState", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$AnimationState;", "restoreAnimationState", "restoreAnimationState$OUI_standardRelease", "restoreState", "restoreState$OUI_standardRelease", "restoreStateInBatch", "runBeforeNextDraw", "action", "runEndAreaTransition", "saveAnimationState", "saveAnimationState$OUI_standardRelease", "setActionChangeInterruptCallback", "callback", "setActionChangeInterruptCallback$OUI_standardRelease", "setActionContentVisible", "setActionContentVisible$OUI_standardRelease", "setActionItemEnabled", "enabled", "actions", "buildState", "setBackdropTarget", "setCenterActionEnabled", "setCenterButtonGroupStyle", "setCenterCustomView", "setCenterSubTitle", "resId", "setCenterSubTitleColor", TypedValues.Custom.S_COLOR, "setCenterSubtitle", "setCenterTitle", "setCenterTitleColor", "setDefaultBackdropTargetForChild", "setDefaultMaskBackground", "setEndActionEnabled", "setEndButtonGroupStyle", "setFloatingTransitionDrawUpdateListener", "listener", "setFloatingTransitionDrawUpdateListener$OUI_standardRelease", "setFloatingTransitionEnabled", "setFloatingTransitionEndListener", "setFloatingTransitionOwnerActive", "active", "setFloatingTransitionOwnerActive$OUI_standardRelease", "setFreezeEndAreaWidth", "(Ljava/lang/Integer;)V", "setKeepActionInteractiveWhenHidden", "keep", "setKeepActionInteractiveWhenHidden$OUI_standardRelease", "setMaskBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setMaskBlurRadius", "radius", "setNonActionContentVisible", "setNonActionContentVisible$OUI_standardRelease", "setStartActionEnabled", "setStartButtonGroupStyle", "setStartSubTitleColor", "setStartSubtitle", "setStartTitle", "setStartTitleColor", "setSubEndActionEnabled", "setSubEndButtonGroupStyle", "setSubEndToEndGapVisible", "setTitleBarContainerClickable", "clickable", "setTitleBarContainerClickable$OUI_standardRelease", "setTitleBarTransitionEndListener", "setTitleType", "shouldAvoidCenterForEndArea", "shouldFreezeCenterForEndArea", "showCenterAction", "show", "showCenterCustomView", "showEndAction", "showMask", "showStartAction", "showSubEndAction", "startCenterTranslationXSpring", "from", "onUpdate", "startFloatingTransitionSourceAnimation", "animation", "Landroid/animation/Animator;", "startFloatingTransitionTargetAnimation", "startTranslationXSpring", "transitionEndAreaActions", "updateAction", "notifyTitleBarTransitionEnd", "updateActionViews", CommonConsts.APM_INNER_EVENT_COST_START, "center", "subEnd", "end", "updateActionsState", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateEndAreaActions", "updateEndAreaActionsImmediately", "updateGroupItemsTint", "updateLayoutForInsetTop", "insetTop", "updateSubEndShiftByEndRawAlpha", "(Lcom/obric/oui/titlebar/OFloatingTitleBar$SubEndShiftEndRawAlphaBinding;Ljava/lang/Float;Ljava/lang/Float;FF)V", "updateViewTint", "waitForButtonGroupAnimationsEnd", "wrapActionClickListener", "addActionItem", "item", "addActionView", "getActionInsertIndex", "getActionViewInsertIndex", "removeActionItemAt", "removeLastActionItem", "toActionItem", "Lcom/obric/oui/titlebar/OFloatingTitleBarState$ActionKey;", "toActionKey", "toStateAction", "withFallbackClickListener", "sourceView", "ActionTargetViews", "CenterAvoidanceMode", "Companion", "EndAreaActionState", "EndAreaSnapshot", "EndAreaTransitionType", "OnTitleBarTransitionEndListener", "SubEndShiftEndRawAlphaBinding", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFloatingTitleBar extends FrameLayout implements com.obric.oui.material.b, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14735a = null;
    private static final Token.Bounce ai = null;
    private static final Token.Duration aj = null;
    private int A;
    private int B;
    private com.obric.common.oea.foundation.animation.d.d C;
    private com.obric.common.oea.foundation.animation.d.d D;
    private int E;
    private Integer F;
    private boolean G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f14736J;
    private int K;
    private int L;
    private boolean M;
    private com.obric.oui.titlebar.floating.a N;
    private boolean O;
    private d P;
    private com.obric.oui.titlebar.floating.a.c Q;
    private Function0<Unit> R;
    private Function0<Unit> S;
    private WeakReference<OFloatingTitleBarActionHost> T;
    private com.obric.oui.titlebar.a.c U;
    private com.obric.oui.titlebar.a.c V;
    private Function1<? super Boolean, com.obric.oui.material.c> W;
    private com.obric.oui.material.c aa;
    private int ab;
    private final com.obric.oui.window.b.a ac;
    private boolean ad;
    private boolean ae;
    private int af;
    private int ag;
    private int ah;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButtonGroup f14737b;
    public OButtonGroup c;
    public OButtonGroup d;
    public OButtonGroup e;
    private FrameLayout f;
    private LinearLayout g;
    private OTextView h;
    private OTextView i;
    private FrameLayout j;
    private FrameLayout k;
    private LinearLayout l;
    private OTextView m;
    private OTextView n;
    private LinearLayout o;
    private View p;
    private View q;
    private int r;
    private int s;
    private int t;
    private int u;
    private View v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$CenterAvoidanceMode;", "", "(Ljava/lang/String;I)V", "NONE", "FREEZE", "TRANSITION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum CenterAvoidanceMode extends Enum<CenterAvoidanceMode> {
        private static final /* synthetic */ CenterAvoidanceMode[] $VALUES = null;
        public static final CenterAvoidanceMode FREEZE = null;
        public static final CenterAvoidanceMode NONE = null;
        public static final CenterAvoidanceMode TRANSITION = null;

        private static final /* synthetic */ CenterAvoidanceMode[] $values() {
            return new CenterAvoidanceMode[]{NONE, FREEZE, TRANSITION};
        }

        static {
            NONE = new CenterAvoidanceMode("NONE", 0);
            FREEZE = new CenterAvoidanceMode("FREEZE", 1);
            TRANSITION = new CenterAvoidanceMode("TRANSITION", 2);
            $VALUES = $values();
        }

        private CenterAvoidanceMode(String r1, int r2) {
            super(r1, r2);
        }

        public static CenterAvoidanceMode valueOf(String r2) {
            return (CenterAvoidanceMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(CenterAvoidanceMode.class, r2), CenterAvoidanceMode.class, "com.obric.memorydata.plugin");
        }

        public static CenterAvoidanceMode[] values() {
            return (CenterAvoidanceMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CenterAvoidanceMode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaActionState;", "", "(Ljava/lang/String;I)V", "EMPTY", "SUB_ONLY", "END_ONLY", "BOTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum EndAreaActionState extends Enum<EndAreaActionState> {
        private static final /* synthetic */ EndAreaActionState[] $VALUES = null;
        public static final EndAreaActionState BOTH = null;
        public static final EndAreaActionState EMPTY = null;
        public static final EndAreaActionState END_ONLY = null;
        public static final EndAreaActionState SUB_ONLY = null;

        private static final /* synthetic */ EndAreaActionState[] $values() {
            return new EndAreaActionState[]{EMPTY, SUB_ONLY, END_ONLY, BOTH};
        }

        static {
            EMPTY = new EndAreaActionState("EMPTY", 0);
            SUB_ONLY = new EndAreaActionState("SUB_ONLY", 1);
            END_ONLY = new EndAreaActionState("END_ONLY", 2);
            BOTH = new EndAreaActionState("BOTH", 3);
            $VALUES = $values();
        }

        private EndAreaActionState(String r1, int r2) {
            super(r1, r2);
        }

        public static EndAreaActionState valueOf(String r2) {
            return (EndAreaActionState) ZeusTransformUtils.preCheckCast(Enum.valueOf(EndAreaActionState.class, r2), EndAreaActionState.class, "com.obric.memorydata.plugin");
        }

        public static EndAreaActionState[] values() {
            return (EndAreaActionState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EndAreaActionState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaTransitionType;", "", "(Ljava/lang/String;I)V", "NONE_OR_CONTENT_CHANGE", "SUB_ONLY_TO_BOTH", "BOTH_TO_SUB_ONLY", "SUB_ONLY_TO_END_ONLY", "END_ONLY_TO_SUB_ONLY", "INTERRUPTED_SHIFT_RETURN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum EndAreaTransitionType extends Enum<EndAreaTransitionType> {
        private static final /* synthetic */ EndAreaTransitionType[] $VALUES = null;
        public static final EndAreaTransitionType BOTH_TO_SUB_ONLY = null;
        public static final EndAreaTransitionType END_ONLY_TO_SUB_ONLY = null;
        public static final EndAreaTransitionType INTERRUPTED_SHIFT_RETURN = null;
        public static final EndAreaTransitionType NONE_OR_CONTENT_CHANGE = null;
        public static final EndAreaTransitionType SUB_ONLY_TO_BOTH = null;
        public static final EndAreaTransitionType SUB_ONLY_TO_END_ONLY = null;

        private static final /* synthetic */ EndAreaTransitionType[] $values() {
            return new EndAreaTransitionType[]{NONE_OR_CONTENT_CHANGE, SUB_ONLY_TO_BOTH, BOTH_TO_SUB_ONLY, SUB_ONLY_TO_END_ONLY, END_ONLY_TO_SUB_ONLY, INTERRUPTED_SHIFT_RETURN};
        }

        static {
            NONE_OR_CONTENT_CHANGE = new EndAreaTransitionType("NONE_OR_CONTENT_CHANGE", 0);
            SUB_ONLY_TO_BOTH = new EndAreaTransitionType("SUB_ONLY_TO_BOTH", 1);
            BOTH_TO_SUB_ONLY = new EndAreaTransitionType("BOTH_TO_SUB_ONLY", 2);
            SUB_ONLY_TO_END_ONLY = new EndAreaTransitionType("SUB_ONLY_TO_END_ONLY", 3);
            END_ONLY_TO_SUB_ONLY = new EndAreaTransitionType("END_ONLY_TO_SUB_ONLY", 4);
            INTERRUPTED_SHIFT_RETURN = new EndAreaTransitionType("INTERRUPTED_SHIFT_RETURN", 5);
            $VALUES = $values();
        }

        private EndAreaTransitionType(String r1, int r2) {
            super(r1, r2);
        }

        public static EndAreaTransitionType valueOf(String r2) {
            return (EndAreaTransitionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EndAreaTransitionType.class, r2), EndAreaTransitionType.class, "com.obric.memorydata.plugin");
        }

        public static EndAreaTransitionType[] values() {
            return (EndAreaTransitionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EndAreaTransitionType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$SubEndShiftEndRawAlphaBinding;", "", "(Ljava/lang/String;I)V", "NONE", "APPEARING", "DISAPPEARING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum SubEndShiftEndRawAlphaBinding extends Enum<SubEndShiftEndRawAlphaBinding> {
        private static final /* synthetic */ SubEndShiftEndRawAlphaBinding[] $VALUES = null;
        public static final SubEndShiftEndRawAlphaBinding APPEARING = null;
        public static final SubEndShiftEndRawAlphaBinding DISAPPEARING = null;
        public static final SubEndShiftEndRawAlphaBinding NONE = null;

        private static final /* synthetic */ SubEndShiftEndRawAlphaBinding[] $values() {
            return new SubEndShiftEndRawAlphaBinding[]{NONE, APPEARING, DISAPPEARING};
        }

        static {
            NONE = new SubEndShiftEndRawAlphaBinding("NONE", 0);
            APPEARING = new SubEndShiftEndRawAlphaBinding("APPEARING", 1);
            DISAPPEARING = new SubEndShiftEndRawAlphaBinding("DISAPPEARING", 2);
            $VALUES = $values();
        }

        private SubEndShiftEndRawAlphaBinding(String r1, int r2) {
            super(r1, r2);
        }

        public static SubEndShiftEndRawAlphaBinding valueOf(String r2) {
            return (SubEndShiftEndRawAlphaBinding) ZeusTransformUtils.preCheckCast(Enum.valueOf(SubEndShiftEndRawAlphaBinding.class, r2), SubEndShiftEndRawAlphaBinding.class, "com.obric.memorydata.plugin");
        }

        public static SubEndShiftEndRawAlphaBinding[] values() {
            return (SubEndShiftEndRawAlphaBinding[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SubEndShiftEndRawAlphaBinding[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JI\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$ActionTargetViews;", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "Landroid/view/View;", "center", "subEnd", "end", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCenter", "()Ljava/util/List;", "getEnd", "getStart", "getSubEnd", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<View> f14738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<View> f14739b;
        private final List<View> c;
        private final List<View> d;

        public a(List<? extends View> r3, List<? extends View> r4, List<? extends View> r5, List<? extends View> r6) {
            List<View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<View> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List<View> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, CommonConsts.APM_INNER_EVENT_COST_START);
            Intrinsics.checkNotNullParameter(r8, "center");
            Intrinsics.checkNotNullParameter(r9, "subEnd");
            Intrinsics.checkNotNullParameter(r10, "end");
            this.f14738a = r7;
            this.f14739b = r8;
            this.c = r9;
            this.d = r10;
        }

        public final List<View> a() {
            return this.f14738a;
        }

        public final List<View> b() {
            return this.f14739b;
        }

        public final List<View> c() {
            return this.c;
        }

        public final List<View> d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14738a, r6.f14738a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14739b, r6.f14739b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f14738a.hashCode() * 31) + this.f14739b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "ActionTargetViews(start=" + this.f14738a + ", center=" + this.f14739b + ", subEnd=" + this.c + ", end=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$Companion;", "", "()V", "AVOIDANCE_SHIFT_BOUNCE", "Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "AVOIDANCE_SHIFT_DURATION", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "CENTER_TITLE_GAP", "", "CENTER_TITLE_GAP_IN_LARGE_FONT", "CENTER_TITLE_HORIZONTAL_PADDING", "SUB_END_TO_END_GAP", "TAG", "", "TYPE_FLOATING", "TYPE_NORMAL", "TYPE_WINDOW", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000e¨\u0006("}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaSnapshot;", "", "state", "Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaActionState;", "subEndViews", "", "Landroid/view/View;", "endViews", "width", "", "endWidth", "endContentWidth", "(Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaActionState;Ljava/util/List;Ljava/util/List;III)V", "getEndContentWidth", "()I", "getEndViews", "()Ljava/util/List;", "getEndWidth", "hasEnd", "", "getHasEnd", "()Z", "hasSubEnd", "getHasSubEnd", "getState", "()Lcom/obric/oui/titlebar/OFloatingTitleBar$EndAreaActionState;", "getSubEndViews", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EndAreaActionState f14740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<View> f14741b;
        private final List<View> c;
        private final int d;
        private final int e;
        private final int f;

        public c(EndAreaActionState r3, List<? extends View> r4, List<? extends View> r5, int r6, int r7, int r8) {
            List<View> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            List<View> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r9, "subEndViews");
            Intrinsics.checkNotNullParameter(r10, "endViews");
            this.f14740a = r3;
            this.f14741b = r9;
            this.c = r10;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }

        public final EndAreaActionState a() {
            return this.f14740a;
        }

        public final List<View> b() {
            return this.f14741b;
        }

        public final List<View> c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (this.f14740a == r6.f14740a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14741b, r6.f14741b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int f() {
            return this.f;
        }

        public final boolean g() {
            if (this.f14740a != EndAreaActionState.SUB_ONLY) goto L5;
        L8:
            return true;
        L5:
            if (this.f14740a == EndAreaActionState.BOTH) goto L8;
            return false;
        }

        public final boolean h() {
            if (this.f14740a != EndAreaActionState.END_ONLY) goto L5;
        L8:
            return true;
        L5:
            if (this.f14740a == EndAreaActionState.BOTH) goto L8;
            return false;
        }

        public int hashCode() {
            return (((((((((this.f14740a.hashCode() * 31) + this.f14741b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
        }

        public String toString() {
            return "EndAreaSnapshot(state=" + this.f14740a + ", subEndViews=" + this.f14741b + ", endViews=" + this.c + ", width=" + this.d + ", endWidth=" + this.e + ", endContentWidth=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar$OnTitleBarTransitionEndListener;", "", "onTitleBarTransitionEnd", "", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
        void a(OFloatingTitleBar r1);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14742a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14743b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[EndAreaTransitionType.values().length];
            r0[EndAreaTransitionType.SUB_ONLY_TO_BOTH.ordinal()] = 1;
            r0[EndAreaTransitionType.BOTH_TO_SUB_ONLY.ordinal()] = 2;
            r0[EndAreaTransitionType.SUB_ONLY_TO_END_ONLY.ordinal()] = 3;
            r0[EndAreaTransitionType.END_ONLY_TO_SUB_ONLY.ordinal()] = 4;
            r0[EndAreaTransitionType.INTERRUPTED_SHIFT_RETURN.ordinal()] = 5;
            r0[EndAreaTransitionType.NONE_OR_CONTENT_CHANGE.ordinal()] = 6;
            f14742a = r0;
            int[] r1 = new int[SubEndShiftEndRawAlphaBinding.values().length];
            r1[SubEndShiftEndRawAlphaBinding.APPEARING.ordinal()] = 1;
            r1[SubEndShiftEndRawAlphaBinding.DISAPPEARING.ordinal()] = 2;
            r1[SubEndShiftEndRawAlphaBinding.NONE.ordinal()] = 3;
            f14743b = r1;
            int[] r2 = new int[CenterAvoidanceMode.values().length];
            r2[CenterAvoidanceMode.NONE.ordinal()] = 1;
            r2[CenterAvoidanceMode.FREEZE.ordinal()] = 2;
            r2[CenterAvoidanceMode.TRANSITION.ordinal()] = 3;
            c = r2;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/titlebar/OFloatingTitleBar$runBeforeNextDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver f14744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f14745b;
        final /* synthetic */ Function0<Unit> c;

        f(ViewTreeObserver r3, OFloatingTitleBar r4, Function0<Unit> r5) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            this.f14744a = r3;
            this.f14745b = r4;
            this.c = r6;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (this.f14744a.isAlive() == false) goto L6;
            ViewTreeObserver r0 = this.f14744a;
        L5:
            r0.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
            this.c.invoke();
            return true;
        L6:
            View r1 = OFloatingTitleBar.j(this.f14745b);
            if (r1 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
            r1 = null;
        L9:
            r0 = r1.getViewTreeObserver();
            goto L5
        }
    }

    static {
        f14735a = new b(null);
        ai = Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_1;
        aj = Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2;
    }

    public OFloatingTitleBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OFloatingTitleBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OFloatingTitleBar(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r12);
        this.w = true;
        this.x = 2;
        this.G = true;
        this.f14736J = true;
        this.O = true;
        this.U = new com.obric.oui.titlebar.a.c(null, null, null, null, 15, null);
        this.W = (Function1) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$maskMaterial$1(this), Function1.class, "com.obric.memorydata.plugin");
        com.obric.oui.window.b.a r0 = new com.obric.oui.window.b.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        this.ac = r0;
        this.ad = com.obric.oui.c.h.a(ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getConfiguration().fontScale);
        E();
        ZeusTransformUtils.inflate(LayoutInflater.from(r13), ZeusTransformUtils.mapRes(R.layout.o_floating_title_bar_layout, "layout", "o_floating_title_bar_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        setClipChildren(false);
        setClipToPadding(false);
        q();
        if (r14 == null) goto L5;
        a(r14);
    L5:
        r0.a(49);
    }

    public /* synthetic */ OFloatingTitleBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void A() {
        Integer r0 = this.F;
        if (r0 != null) goto L5;
        return;
    L5:
        final int r1 = r0.intValue();
        LinearLayout r2 = this.o;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r2 = null;
    L8:
        Integer r3 = Integer.valueOf(r2.getWidth());
        boolean r5 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 != null) goto L20;
        LinearLayout r6 = this.o;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r6 = null;
    L19:
        int r7 = r6.getMeasuredWidth();
    L22:
        if (getEndSubButtonGroup().d() == false) goto L24;
    L27:
        if (r7 <= r1) goto L31;
        if (r5 == false) goto L31;
        post(new $$Lambda$OFloatingTitleBar$ZI6CHZZqiU5XJHO6BfJsaLaEVsI(this, r1));
        return;
    L31:
        setFreezeEndAreaWidth(null);
        return;
    L24:
        if (getEndButtonGroup().d() == true) goto L27;
        r5 = false;
        goto L27
    L20:
        r7 = r3.intValue();
        goto L22
    L11:
        r4 = false;
        goto L12
    }

    private final void B() {
        View r0 = getDefaultTargetView();
        getStartButtonGroup().setBackdropTarget(r0);
        getCenterButtonGroup().setBackdropTarget(r0);
        getEndButtonGroup().setBackdropTarget(r0);
        getEndSubButtonGroup().setBackdropTarget(r0);
    }

    private final void C() {
        Function0<Unit> r0 = this.R;
        if (r0 != null) goto L5;
        Unit r1 = null;
    L6:
        if (r1 != null) goto L9;
        l();
        return;
    L9:
        return;
    L5:
        r0.invoke();
        r1 = Unit.INSTANCE;
        goto L6
    }

    private final void D() {
        d r0 = this.P;
        if (r0 == null) goto L7;
        r0.a(this);
        return;
    }

    private final void E() {
        this.af = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        this.ag = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        this.ah = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
        this.L = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
    }

    private final boolean F() {
        if (((View) ZeusTransformUtils.preCheckCast(getStartButtonGroup(), View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L27;
        OTextView r1 = this.h;
        OTextView r4 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r1 = null;
    L11:
        if (((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L28;
        OTextView r6 = this.i;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L20:
        if (((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L26;
        return true;
    L26:
        return false;
    L22:
        r7 = false;
        goto L23
    L18:
        r4 = r6;
        goto L20
    L28:
        return true;
    L13:
        r2 = false;
        goto L14
    L27:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean G() {
        if (((View) ZeusTransformUtils.preCheckCast(getCenterButtonGroup(), View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L35;
        OTextView r1 = this.m;
        FrameLayout r4 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r1 = null;
    L11:
        if (((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L36;
        OTextView r3 = this.n;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r3 = null;
    L19:
        if (((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == true) goto L37;
        FrameLayout r6 = this.k;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L28:
        if (((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == false) goto L34;
        return true;
    L34:
        return false;
    L30:
        r7 = false;
        goto L31
    L26:
        r4 = r6;
        goto L28
    L37:
        return true;
    L21:
        r5 = false;
        goto L22
    L36:
        return true;
    L13:
        r2 = false;
        goto L14
    L35:
        return true;
    L5:
        r0 = false;
        goto L6
    }

    private final boolean H() {
        if (((View) ZeusTransformUtils.preCheckCast(getEndButtonGroup(), View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (((View) ZeusTransformUtils.preCheckCast(getEndSubButtonGroup(), View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        return true;
    L14:
        return false;
    L10:
        r4 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private final boolean I() {
        OTextView r0 = this.h;
        String r1 = "startTitleView";
        OTextView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r0 = null;
    L5:
        boolean r3 = false;
        if (((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L15;
        OTextView r7 = this.h;
        if (r7 != null) goto L13;
    L12:
        Intrinsics.throwUninitializedPropertyAccessException(r1);
    L26:
        return !com.obric.oui.color.d.a(r2.getTextColors().getDefaultColor());
    L13:
        r2 = r7;
        goto L26
    L15:
        OTextView r5 = this.m;
        r1 = "centerTitleView";
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r5 = null;
    L19:
        if (((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L21;
        r3 = true;
    L21:
        if (r3 == false) goto L28;
        r7 = this.m;
        if (r7 != null) goto L13;
    L28:
        return i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L8:
        r4 = false;
        goto L9
    }

    private final int a(View r5) {
        boolean r0 = true;
        if (r5.getVisibility() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
        return 0;
    L8:
        Integer r6 = Integer.valueOf(r5.getMeasuredWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L12;
        r0 = false;
    L12:
        if (r0 == true) goto L15;
        r6 = null;
    L15:
        if (r6 != null) goto L18;
        return r5.getWidth();
    L18:
        return r6.intValue();
    L5:
        r4 = false;
        goto L6
    }

    private final int a(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L7;
        return 0;
    L7:
        return getEndButtonGroup().a(r4) + getSubEndToEndGap();
    }

    private final int a(List<? extends View> r2, int r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 < 0) goto L7;
        if (r3 > r1.size()) goto L7;
        return r3;
    L7:
        return r1.size();
    }

    private final View.OnClickListener a(View.OnClickListener r3) {
        final View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new $$Lambda$OFloatingTitleBar$eQQ1sLABETwyMJkoEh56gcYHorc(this, r4);
    }

    private final View a(int r7, int r8) {
        View r0 = new View((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setAlpha(0.0f);
        r0.setImportantForAccessibility(2);
        Integer r6 = Integer.valueOf(r7);
        boolean r2 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r9 = true;
    L6:
        Integer r4 = null;
        if (r9 == true) goto L10;
        r6 = null;
    L10:
        int r10 = -2;
        if (r6 != null) goto L13;
        int r11 = -2;
    L14:
        Integer r12 = Integer.valueOf(r8);
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L20;
        r4 = r12;
    L20:
        if (r4 == null) goto L23;
        r10 = r4.intValue();
    L23:
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(r11, r10), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return r0;
    L13:
        r11 = r6.intValue();
        goto L14
    L5:
        r9 = false;
        goto L6
    }

    private final View a(OButtonGroup.d r17, int r18, List<com.obric.oui.titlebar.a.C0783a> r19) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        Object r3 = r17.a();
        View.OnClickListener r5 = null;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.titlebar.a.b.class) == false) goto L5;
        com.obric.oui.titlebar.a.b r4 = (com.obric.oui.titlebar.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.titlebar.a.b.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        Integer r6 = Integer.valueOf(r4.c());
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L11;
        boolean r7 = true;
    L12:
        if (r7 == true) goto L15;
        r6 = null;
    L15:
        if (r6 != null) goto L17;
        int r8 = r18;
    L18:
        com.obric.oui.titlebar.a.b r9 = com.obric.oui.titlebar.a.b.a(r4, 0, 0, null, r8, null, null, 55, null);
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r2.hasNext() == false) goto L24;
        Object r10 = r2.next();
        if (Intrinsics.areEqual(b((com.obric.oui.titlebar.a.C0783a) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.titlebar.a.C0783a.class, "com.obric.memorydata.plugin"), r8), r9) == false) goto L20;
    L25:
        com.obric.oui.titlebar.a.C0783a r11 = (com.obric.oui.titlebar.a.C0783a) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.titlebar.a.C0783a.class, "com.obric.memorydata.plugin");
        int r12 = r4.getType();
        if (r12 == 1) goto L39;
        String r13 = "";
        if (r12 == 3) goto L34;
        String r14 = r4.b();
        if (r14 == null) goto L33;
        r13 = r14;
    L33:
        View r15 = a(r13, r8);
    L40:
        r15.setTag(r9);
        if (r11 == null) goto L44;
        r5 = r11.e();
    L44:
        r15.setOnClickListener(a(r5));
        if (r11 == null) goto L48;
        r15.setEnabled(r11.f());
    L48:
        return r15;
    L34:
        String r16 = r4.b();
        if (r16 == null) goto L38;
        r13 = r16;
    L38:
        r15 = b(r13, r8);
        goto L40
    L39:
        r15 = b(r4.a(), r8);
        goto L40
    L24:
        r10 = null;
        goto L25
    L17:
        r8 = r6.intValue();
        goto L18
    L11:
        r7 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public static /* synthetic */ View a(OFloatingTitleBar r1, int r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.a(r2, r3, r7);
    }

    public static /* synthetic */ View a(OFloatingTitleBar r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = false;
    L9:
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ View a(OFloatingTitleBar r2, OButtonGroup.d r3, int r4, List r5) {
        return r2.a(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ View a(OFloatingTitleBar r1, String r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.a(r2, r3, r7);
    }

    private final View a(String r19, int r20) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        OUIFrameLayout r8 = new OUIFrameLayout(r2, null, 0, null, 14, null);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.setMinimumHeight(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 36));
        r8.setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 7), 0, com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 7), 0);
        r8.setClickable(true);
        r8.setRadius(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 99));
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        OTextView r4 = new OTextView(r12, null, 0, null, 14, null);
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"));
        r4.setGravity(17);
        r4.setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 4), 0, com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 4), 0);
        r4.setSingleLine(true);
        r4.setMinHeight(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"), 22));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r4.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Button_2_Medium, "style", "Button_2_Medium"));
    L5:
        if (r20 == 0) goto L7;
        r4.setTextColor(r20);
    L7:
        View r0 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r8.addView(r0, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.common.oea.foundation.animation.d.d a(float r3, float r4, Function1<? super Float, Unit> r5, Function0<Unit> r6) {
        Function1<? super Float, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        return b(r3, r4, r7, (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$startCenterTranslationXSpring$1(this, r8), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ com.obric.common.oea.foundation.animation.d.d a(OFloatingTitleBar r2, float r3, float r4, Function1 r5, Function0 r6) {
        return r2.a(r3, r4, (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin"));
    }

    private final CenterAvoidanceMode a(c r2, c r3) {
        boolean r0 = b(r2, r3);
        boolean r1 = c(r2, r3);
        if (r0 == true) goto L9;
        if (r1 == false) goto L8;
        return CenterAvoidanceMode.FREEZE;
    L8:
        return CenterAvoidanceMode.NONE;
    L9:
        return CenterAvoidanceMode.TRANSITION;
    }

    private final EndAreaTransitionType a(c r4, c r5, float r6) {
        boolean r0 = true;
        if (r4.g() == true) goto L5;
    L11:
        boolean r3 = false;
    L13:
        if (r4.g() == true) goto L15;
    L21:
        boolean r2 = false;
    L22:
        if (r3 == true) goto L44;
        if (r2 == false) goto L27;
        return EndAreaTransitionType.BOTH_TO_SUB_ONLY;
    L27:
        if (r4.a() != EndAreaActionState.SUB_ONLY) goto L32;
        if (r5.a() != EndAreaActionState.END_ONLY) goto L32;
        return EndAreaTransitionType.SUB_ONLY_TO_END_ONLY;
    L32:
        if (r4.a() != EndAreaActionState.END_ONLY) goto L37;
        if (r5.a() != EndAreaActionState.SUB_ONLY) goto L37;
        return EndAreaTransitionType.END_ONLY_TO_SUB_ONLY;
    L37:
        if (r6 == 0.0f) goto L40;
        r0 = false;
    L40:
        if (r0 == true) goto L43;
        return EndAreaTransitionType.INTERRUPTED_SHIFT_RETURN;
    L43:
        return EndAreaTransitionType.NONE_OR_CONTENT_CHANGE;
    L44:
        return EndAreaTransitionType.SUB_ONLY_TO_BOTH;
    L15:
        if (r5.g() == false) goto L21;
        if (r4.h() == false) goto L21;
        if (r5.h() == true) goto L21;
        r2 = true;
        goto L22
    L5:
        if (r5.g() == false) goto L11;
        if (r4.h() == true) goto L11;
        if (r5.h() == false) goto L11;
        r3 = true;
        goto L13
    }

    private final SubEndShiftEndRawAlphaBinding a(EndAreaTransitionType r1) {
        int r0 = e.f14742a[r1.ordinal()];
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L11;
        return SubEndShiftEndRawAlphaBinding.NONE;
    L11:
        return SubEndShiftEndRawAlphaBinding.DISAPPEARING;
    L9:
        return SubEndShiftEndRawAlphaBinding.APPEARING;
    }

    static /* synthetic */ a a(OFloatingTitleBar r10, com.obric.oui.titlebar.a.c r11, a r12, boolean r13, boolean r14, Function0 r15, boolean r16, int r17, Object r18) {
        Function0<Unit> r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        if ((r17 & 8) == 0) goto L5;
        boolean r7 = true;
    L7:
        if ((r17 & 16) == 0) goto L9;
        r0 = null;
    L9:
        Function0<Unit> r8 = r0;
        if ((r17 & 32) == 0) goto L12;
        boolean r9 = true;
    L14:
        return r10.a(r11, r12, r13, r7, r8, r9);
    L12:
        r9 = r16;
        goto L14
    L5:
        r7 = r14;
        goto L7
    }

    static /* synthetic */ a a(OFloatingTitleBar r0, com.obric.oui.titlebar.a.c r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return r0.a(r1, r2);
    }

    static /* synthetic */ a a(OFloatingTitleBar r6, List r7, List r8, List r9, List r10, boolean r11, int r12, Object r13) {
        List<com.obric.oui.titlebar.a.C0783a> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<com.obric.oui.titlebar.a.C0783a> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<com.obric.oui.titlebar.a.C0783a> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<com.obric.oui.titlebar.a.C0783a> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r14 = r6.U.a();
    L5:
        List<com.obric.oui.titlebar.a.C0783a> r1 = r14;
        if ((r12 & 2) == 0) goto L8;
        r15 = r6.U.b();
    L8:
        List<com.obric.oui.titlebar.a.C0783a> r2 = r15;
        if ((r12 & 4) == 0) goto L11;
        r16 = r6.U.c();
    L11:
        List<com.obric.oui.titlebar.a.C0783a> r3 = r16;
        if ((r12 & 8) == 0) goto L15;
        r17 = r6.U.d();
    L15:
        return r6.a(r1, r2, r3, r17, r11);
    }

    private final a a(com.obric.oui.titlebar.a.c r16, a r17, boolean r18, boolean r19, Function0<Unit> r20, boolean r21) {
        final Function0 r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        if (r19 == true) goto L5;
    L7:
        b(r16, r17);
        boolean r1 = true;
        if (r18 == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r21 == true) goto L15;
    L19:
        final boolean r4 = false;
    L20:
        com.obric.oui.titlebar.a.c r5 = null;
        if (r0 != null) goto L25;
        if (r4 == true) goto L25;
        Object r2 = ZeusTransformUtils.preCheckCast(null, Function0.class, "com.obric.memorydata.plugin");
    L26:
        final Function0 r6 = (Function0) r2;
        c r7 = a(a(getEndSubButtonGroup()), a(getEndButtonGroup()));
        c r9 = a(r17.c(), r17.d());
        CenterAvoidanceMode r10 = a(r7, r9);
        if (r16 == null) goto L30;
        r5 = a(r16, r17);
    L30:
        if (r5 == null) goto L32;
        this.U.a(r5.a(), r5.b(), r5.c(), r5.d());
    L32:
        this.V = r5;
        getStartButtonGroup().a(r17.a(), r3);
        getCenterButtonGroup().a(r17.b(), r3);
        final Ref.BooleanRef r11 = new Ref.BooleanRef();
        if (r6 != null) goto L35;
        boolean r8 = true;
    L36:
        r11.element = r8;
        final Ref.BooleanRef r12 = new Ref.BooleanRef();
        if (r6 == null) goto L40;
        r1 = false;
    L40:
        r12.element = r1;
        final Ref.BooleanRef r13 = new Ref.BooleanRef();
        a(r7, r9, r3, r10, (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$updateAction$1(r12, r13, r11, r6), Function0.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L43;
        a((Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$updateAction$2(r11, r13, r12, r6), Function0.class, "com.obric.memorydata.plugin"));
    L43:
        b(r16, r17);
        w();
        o();
        return r17;
    L35:
        r8 = false;
    L25:
        r2 = ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$updateAction$transitionEndCallback$1(r0, r4, this), Function0.class, "com.obric.memorydata.plugin");
        goto L26
    L15:
        if (this.P == null) goto L19;
        if (this.K != 0) goto L19;
        r4 = true;
        goto L20
    L10:
        if (this.K != 0) goto L12;
        r3 = true;
        goto L13
    L5:
        if (this.K != 0) goto L7;
        C();
        goto L7
    }

    private final a a(com.obric.oui.titlebar.a.c r7, boolean r8) {
        return new a(a(r7.a(), this.r, a(getStartButtonGroup()), r8), a(r7.b(), this.s, a(getCenterButtonGroup()), r8), a(r7.c(), this.u, a(getEndSubButtonGroup()), r8), a(r7.d(), this.t, a(getEndButtonGroup()), r8));
    }

    private final a a(List<com.obric.oui.titlebar.a.C0783a> r10, List<com.obric.oui.titlebar.a.C0783a> r11, List<com.obric.oui.titlebar.a.C0783a> r12, List<com.obric.oui.titlebar.a.C0783a> r13, boolean r14) {
        com.obric.oui.titlebar.a.c r1 = new com.obric.oui.titlebar.a.c((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"));
        return a(this, r1, a(r1, false), r14, false, null, false, 56, null);
    }

    private final c a(List<? extends View> r10, List<? extends View> r11) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<? extends View> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        return new c(c(!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty(), !((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()), r4, r5, b(r4, r5), a(r5), b(r5));
    }

    private final com.obric.oui.titlebar.a.C0783a a(com.obric.oui.titlebar.a.C0783a r1, int r2) {
        return r1.a(r2).b(c(r1.a()));
    }

    private final com.obric.oui.titlebar.a.C0783a a(com.obric.oui.titlebar.a.C0783a r13, final View r14) {
        if (r13.e() == null) goto L8;
        int r2 = 0;
        int r3 = 0;
        String r4 = null;
        String r5 = null;
        int r6 = 0;
        View.OnClickListener r7 = a(r13.e());
    L6:
        return com.obric.oui.titlebar.a.C0783a.a(r13, r2, r3, r4, r5, r6, r7, false, null, 223, null);
    L8:
        if (r14.hasOnClickListeners() == true) goto L10;
        return r13;
    L10:
        r2 = 0;
        r3 = 0;
        r4 = null;
        r5 = null;
        r6 = 0;
        r7 = new $$Lambda$OFloatingTitleBar$abSvRyqcb2Pjx9xH5a7lJWfPVfA(this, r14);
        goto L6
    }

    private final com.obric.oui.titlebar.a.C0783a a(com.obric.oui.titlebar.a.b r5) {
        int r4 = r5.getType();
        if (r4 == 1) goto L16;
        String r3 = "";
        if (r4 == 3) goto L11;
        com.obric.oui.titlebar.a.C0783a.C0784a r6 = com.obric.oui.titlebar.a.C0783a.f14760a;
        String r0 = r5.b();
        if (r0 == null) goto L10;
        r3 = r0;
    L10:
        com.obric.oui.titlebar.a.C0783a r7 = com.obric.oui.titlebar.a.C0783a.C0784a.a(r6, r3, null, 2, null);
    L18:
        return r7.a(r5.d()).a(r5.c()).b(r5.e());
    L11:
        com.obric.oui.titlebar.a.C0783a.C0784a r8 = com.obric.oui.titlebar.a.C0783a.f14760a;
        String r1 = r5.b();
        if (r1 == null) goto L15;
        r3 = r1;
    L15:
        r7 = com.obric.oui.titlebar.a.C0783a.C0784a.b(r8, r3, null, 2, null);
        goto L18
    L16:
        r7 = com.obric.oui.titlebar.a.C0783a.C0784a.a(com.obric.oui.titlebar.a.C0783a.f14760a, r5.a(), null, 2, null);
        goto L18
    }

    public static final /* synthetic */ com.obric.oui.titlebar.a.c a(OFloatingTitleBar r0) {
        return r0.U;
    }

    private final com.obric.oui.titlebar.a.c a(com.obric.oui.titlebar.a.c r7, a r8) {
        return new com.obric.oui.titlebar.a.c(a(r7.a(), r8.a(), this.r), a(r7.b(), r8.b(), this.s), a(r7.c(), r8.c(), this.u), a(r7.d(), r8.d(), this.t));
    }

    private final List<View> a(OButtonGroup r4) {
        ArrayList r3 = new ArrayList(r4.getItemCount());
        int r0 = r4.getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        int r2 = r1 + 1;
        View r5 = r4.c(r1);
        if (r5 == null) goto L8;
        r3.add(r5);
    L8:
        r1 = r2;
        goto L3
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    }

    private final List<com.obric.oui.titlebar.a.C0783a> a(OButtonGroup r13, List<com.obric.oui.titlebar.a.C0783a> r14, int r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if (r13.getVisibility() != 0) goto L5;
        List<com.obric.oui.titlebar.a.C0783a> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r17 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin"));
        int r2 = r13.getItemCount();
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L38;
        int r5 = r4 + 1;
        View r6 = r13.c(r4);
        if (r6 == null) goto L37;
        if (r6.getVisibility() != 0) goto L37;
        Object r7 = r6.getTag();
        com.obric.oui.titlebar.a.C0783a r8 = null;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.titlebar.a.b.class) == false) goto L17;
        com.obric.oui.titlebar.a.b r9 = (com.obric.oui.titlebar.a.b) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.titlebar.a.b.class, "com.obric.memorydata.plugin");
    L18:
        if (r9 == null) goto L37;
        Iterator r10 = r17.iterator();
        int r11 = 0;
    L22:
        if (r10.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(b((com.obric.oui.titlebar.a.C0783a) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.oui.titlebar.a.C0783a.class, "com.obric.memorydata.plugin"), r15), r9) == true) goto L28;
        r11 = r11 + 1;
    L28:
        if (r11 < 0) goto L30;
        r8 = (com.obric.oui.titlebar.a.C0783a) ZeusTransformUtils.preCheckCast(r17.remove(r11), com.obric.oui.titlebar.a.C0783a.class, "com.obric.memorydata.plugin");
    L30:
        if (r8 != null) goto L32;
        boolean r12 = true;
    L33:
        if (r8 == null) goto L35;
        com.obric.oui.titlebar.a.C0783a r18 = a(a(r8, r15), r6).a(r12);
    L36:
        r0.add(r18);
        goto L37
    L35:
        r18 = a(a(r9), r6);
        goto L36
    L32:
        r12 = r8.f();
        goto L33
    L27:
        r11 = -1;
        goto L28
    L17:
        r9 = null;
    L37:
        r4 = r5;
        goto L7
    L38:
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    private final List<View> a(List<? extends View> r3, int r4, View r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<View> r0 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        r0.add(a(r6, r4), r5);
        return r0;
    }

    private final List<com.obric.oui.titlebar.a.C0783a> a(List<com.obric.oui.titlebar.a.C0783a> r3, int r4, com.obric.oui.titlebar.a.C0783a r5) {
        List<com.obric.oui.titlebar.a.C0783a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<com.obric.oui.titlebar.a.C0783a> r0 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin"));
        r0.add(b(r6, r4), r5);
        return r0;
    }

    private final List<View> a(List<com.obric.oui.titlebar.a.C0783a> r9, int r10, List<? extends View> r11, boolean r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r14 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L35;
        com.obric.oui.titlebar.a.C0783a r2 = (com.obric.oui.titlebar.a.C0783a) ZeusTransformUtils.preCheckCast(r16.next(), com.obric.oui.titlebar.a.C0783a.class, "com.obric.memorydata.plugin");
        com.obric.oui.titlebar.a.b r3 = b(r2, r10);
        int r4 = 0;
        Iterator r5 = r14.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((View) ZeusTransformUtils.preCheckCast(r5.next(), View.class, "com.obric.memorydata.plugin")).getTag(), r3) == true) goto L13;
        r4 = r4 + 1;
    L13:
        if (r4 < 0) goto L15;
        View r6 = (View) ZeusTransformUtils.preCheckCast(r14.remove(r4), View.class, "com.obric.memorydata.plugin");
    L30:
        r6.setTag(r3);
        r6.setOnClickListener(a(r2.e()));
        a(r6, r10);
        if (r12 == false) goto L33;
        r6.setEnabled(r2.f());
    L33:
        r0.add(r6);
        goto L4
    L15:
        int r7 = r2.getType();
        if (r7 == 1) goto L29;
        String r8 = "";
        if (r7 == 3) goto L24;
        String r17 = r2.b();
        if (r17 == null) goto L23;
        r8 = r17;
    L23:
        r6 = a(r8, r10);
        goto L30
    L24:
        String r18 = r2.b();
        if (r18 == null) goto L28;
        r8 = r18;
    L28:
        r6 = b(r8, r10);
        goto L30
    L29:
        r6 = b(r2.a(), r10);
        goto L30
    L12:
        r4 = -1;
        goto L13
    L35:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private final List<com.obric.oui.titlebar.a.C0783a> a(List<com.obric.oui.titlebar.a.C0783a> r9, List<? extends View> r10, int r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r13 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L33;
        com.obric.oui.titlebar.a.C0783a r2 = (com.obric.oui.titlebar.a.C0783a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.oui.titlebar.a.C0783a.class, "com.obric.memorydata.plugin");
        com.obric.oui.titlebar.a.b r3 = b(r2, r11);
        int r4 = 0;
        Iterator r5 = r13.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((View) ZeusTransformUtils.preCheckCast(r5.next(), View.class, "com.obric.memorydata.plugin")).getTag(), r3) == true) goto L13;
        r4 = r4 + 1;
    L13:
        com.obric.oui.titlebar.a.C0783a r6 = null;
        if (r4 < 0) goto L16;
        Object r7 = ZeusTransformUtils.preCheckCast(r13.remove(r4), View.class, "com.obric.memorydata.plugin");
    L17:
        View r8 = (View) r7;
        if (r8 != null) goto L20;
    L22:
        boolean r16 = r2.f();
        com.obric.oui.titlebar.a.C0783a r17 = a(r2, r11);
        if (r8 == null) goto L29;
        com.obric.oui.titlebar.a.C0783a r18 = a(r17, r8);
        if (r18 == null) goto L29;
        r17 = r18;
    L29:
        r6 = r17.a(r16);
    L30:
        if (r6 == null) goto L4;
        r0.add(r6);
        goto L4
    L20:
        if (r8.getVisibility() == 0) goto L22;
    L16:
        r7 = ZeusTransformUtils.preCheckCast(null, View.class, "com.obric.memorydata.plugin");
        goto L17
    L12:
        r4 = -1;
        goto L13
    L33:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    private final void a(float r6, Function0<Unit> r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        com.obric.common.oea.foundation.animation.d.d r0 = this.C;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.d.d.a(r0, false, 1, null);
    L6:
        this.C = b(getEndSubButtonGroup().getTranslationX(), r6, (Function1) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$animateEndSubTranslationTo$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$animateEndSubTranslationTo$2(this, r8), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final void a(int r4, int r5, CenterAvoidanceMode r6, Function0<Unit> r7) {
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        FrameLayout r0 = null;
        if (r6 != CenterAvoidanceMode.NONE) goto L14;
        FrameLayout r9 = this.j;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L8:
        r0.setTranslationX(0.0f);
        getCenterButtonGroup().setTranslationX(0.0f);
        A();
        if (r8 == null) goto L26;
        r8.invoke();
        return;
    L26:
        return;
    L7:
        r0 = r9;
        goto L8
    L14:
        if (r6 != CenterAvoidanceMode.FREEZE) goto L24;
        z();
        FrameLayout r10 = this.j;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L19:
        r0.setTranslationX(0.0f);
        getCenterButtonGroup().setTranslationX(0.0f);
        setFreezeEndAreaWidth(Integer.valueOf(r5));
        if (r8 == null) goto L27;
        r8.invoke();
        return;
    L27:
        return;
    L18:
        r0 = r10;
        goto L19
    L24:
        a(r5, r8);
    }

    private final void a(int r3, CenterAvoidanceMode r4, Function0<Unit> r5) {
        final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        int r7 = e.c[r4.ordinal()];
        if (r7 != 1) goto L5;
        FrameLayout r8 = this.j;
        if (r8 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r8 = null;
    L24:
        r8.setTranslationX(0.0f);
        getCenterButtonGroup().setTranslationX(0.0f);
        A();
        if (r6 == null) goto L28;
    L20:
        r6.invoke();
        return;
    L28:
        return;
    L5:
        if (r7 != 2) goto L7;
        A();
        if (r6 != null) goto L20;
        return;
    L7:
        if (r7 != 3) goto L29;
        Integer r9 = this.F;
        if (r9 != null) goto L12;
    L14:
        A();
        if (r6 != null) goto L20;
        return;
    L12:
        if (r9.intValue() == r3) goto L14;
        a(r3, (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$finishCenterForEndAreaTransition$1(this, r6), Function0.class, "com.obric.memorydata.plugin"));
        return;
    }

    private static final void a(int r2, OFloatingTitleBar r3, Ref.BooleanRef r4, c r5, CenterAvoidanceMode r6, Function0<Unit> r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        if (r2 == r3.E) goto L6;
        return;
    L6:
        if (r4.element == false) goto L8;
        return;
    L8:
        boolean r9 = true;
        r4.element = true;
        r3.getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        if (r5.g() == true) goto L11;
    L13:
        r9 = false;
    L14:
        r3.setSubEndToEndGapVisible(r9);
        r3.getEndSubButtonGroup().setTranslationX(0.0f);
        r3.a(r5.d(), r6, (Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$runEndAreaTransition$finishTransition$1(r8), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        if (r5.h() == false) goto L13;
        goto L13
    }

    private final void a(int r6, Function0<Unit> r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        FrameLayout r0 = this.j;
        FrameLayout r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r0 = null;
    L5:
        float r1 = r0.getX();
        FrameLayout r4 = this.j;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L9:
        final float r3 = r1 + (r2.getWidth() / 2.0f);
        z();
        setFreezeEndAreaWidth(Integer.valueOf(r6));
        b((Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$animateFreezeEndAreaWidthTo$1(this, r3, r8), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r2 = r4;
        goto L9
    }

    private final void a(AttributeSet r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        int[] r2 = R.styleable.OFloatingTitleBar;
        Intrinsics.checkNotNullExpressionValue(r2, "OFloatingTitleBar");
        TypedArray r12 = r0.obtainStyledAttributes(r11, r2, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r12, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_type, "styleable", "OFloatingTitleBar_oFloatingTitleBar_type")) == false) goto L6;
        setTitleType(r12.getInt(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_type, "styleable", "OFloatingTitleBar_oFloatingTitleBar_type"), 0));
    L6:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startTitle")) == false) goto L9;
        setStartTitle(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startTitle")));
    L9:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startTitleColor")) == false) goto L12;
        setStartTitleColor(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startTitleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
    L12:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startSubTitle")) == false) goto L15;
        setStartSubtitle(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startSubTitle")));
    L15:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor")) == false) goto L18;
        setStartSubTitleColor(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
    L18:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerTitle")) == false) goto L21;
        setCenterTitle(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerTitle")));
    L21:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerTitleColor")) == false) goto L24;
        setCenterTitleColor(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerTitleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1")));
    L24:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerSubTitle")) == false) goto L27;
        setCenterSubtitle(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerSubTitle")));
    L27:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor")) == false) goto L29;
        setCenterSubTitleColor(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
    L29:
        setStartButtonGroupStyle(r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_startButtonGroupStyle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_startButtonGroupStyle"), ZeusTransformUtils.mapRes(R.style.OFloatingTitleBar_Action_Standard, "style", "OFloatingTitleBar_Action_Standard")));
        setCenterButtonGroupStyle(r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_centerButtonGroupStyle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_centerButtonGroupStyle"), ZeusTransformUtils.mapRes(R.style.OFloatingTitleBar_Action_Standard, "style", "OFloatingTitleBar_Action_Standard")));
        setSubEndButtonGroupStyle(r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_endSubButtonGroupStyle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_endSubButtonGroupStyle"), ZeusTransformUtils.mapRes(R.style.OFloatingTitleBar_Action_Standard, "style", "OFloatingTitleBar_Action_Standard")));
        setEndButtonGroupStyle(r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_endButtonGroupStyle, "styleable", "OFloatingTitleBar_oFloatingTitleBar_endButtonGroupStyle"), ZeusTransformUtils.mapRes(R.style.OFloatingTitleBar_Action_Standard, "style", "OFloatingTitleBar_Action_Standard")));
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBackground")) == false) goto L37;
        Drawable r1 = r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBackground"));
        if (r1 != null) goto L35;
        r1 = (Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBackground"), 0)), Drawable.class, "com.obric.memorydata.plugin");
    L35:
        setMaskBackground(r1);
    L37:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground")) == false) goto L42;
        if (r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground, "styleable", "OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground"), false) == false) goto L42;
        k();
    L42:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetBlurColors, "styleable", "OFloatingTitleBar_oui_widgetBlurColors")) == false) goto L55;
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetBlurBlendModes, "styleable", "OFloatingTitleBar_oui_widgetBlurBlendModes")) == false) goto L55;
        int r3 = r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetBlurColors, "styleable", "OFloatingTitleBar_oui_widgetBlurColors"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_colors, "array", "oui_titlebar_blur_colors"));
        int r5 = r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetBlurBlendModes, "styleable", "OFloatingTitleBar_oui_widgetBlurBlendModes"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_blend_modes, "array", "oui_titlebar_blur_blend_modes"));
        com.obric.oui.material.c r6 = this.aa;
        if (r6 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r6 = null;
    L48:
        r6.a(OMaterialHelper.a(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin"), r3, r5));
        com.obric.oui.material.c r4 = this.aa;
        if (r4 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r4 = null;
    L52:
        if (r4.c() != null) goto L55;
        com.obric.oui.c.a.b.e("OFloatingTitleBar", "init get widget blur colors or modes error");
    L55:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetMaterialSrcType, "styleable", "OFloatingTitleBar_oui_widgetMaterialSrcType")) == false) goto L62;
        int r7 = ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetMaterialSrcType, "styleable", "OFloatingTitleBar_oui_widgetMaterialSrcType");
        if (this.ab != 2) goto L59;
        int r8 = 4;
    L60:
        this.x = r12.getInt(r7, r8);
        goto L62
    L59:
        r8 = 2;
    L62:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius")) == false) goto L65;
        setMaskBlurRadius(r12.getFloat(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius, "styleable", "OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius"), BlurToken.Blur_Progress_Thin));
    L65:
        if (r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oui_widgetFitInsetTop, "styleable", "OFloatingTitleBar_oui_widgetFitInsetTop"), r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_statusBarImmersion, "styleable", "OFloatingTitleBar_oFloatingTitleBar_statusBarImmersion"), false)) == true) goto L67;
    L69:
        boolean r9 = false;
    L70:
        this.ac.a(r9, (Function1) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$initAttrs$1$1(this), Function1.class, "com.obric.memorydata.plugin"));
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_enableFloatingTransition, "styleable", "OFloatingTitleBar_oFloatingTitleBar_enableFloatingTransition")) == false) goto L73;
        setFloatingTransitionEnabled(r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OFloatingTitleBar_oFloatingTitleBar_enableFloatingTransition, "styleable", "OFloatingTitleBar_oFloatingTitleBar_enableFloatingTransition"), false));
    L73:
        r12.recycle();
        return;
    L67:
        if (this.ab == 1) goto L69;
        r9 = true;
        goto L70
    }

    private final void a(View r14, int r15) {
        com.obric.oui.titlebar.a.b r0 = null;
        if (r14 != null) goto L5;
        Object r1 = null;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.titlebar.a.b.class) == false) goto L9;
        r0 = (com.obric.oui.titlebar.a.b) ZeusTransformUtils.preCheckCast(r1, com.obric.oui.titlebar.a.b.class, "com.obric.memorydata.plugin");
    L9:
        com.obric.oui.titlebar.a.b r4 = r0;
        if (r4 == null) goto L14;
        r14.setTag(com.obric.oui.titlebar.a.b.a(r4, 0, 0, null, r15, null, null, 55, null));
    L14:
        if (ZeusTransformUtils.instanceOf(r14, ViewGroup.class) == false) goto L19;
        int r2 = 0;
        int r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L16:
        if (r2 >= r3) goto L28;
        a(((ViewGroup) ZeusTransformUtils.preCheckCast(r14, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r2), r15);
        r2 = r2 + 1;
        goto L16
    L28:
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r14, ImageView.class) == false) goto L22;
        ((ImageView) ZeusTransformUtils.preCheckCast(r14, ImageView.class, "com.obric.memorydata.plugin")).setColorFilter(r15);
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r14, TextView.class) == false) goto L27;
        ((TextView) ZeusTransformUtils.preCheckCast(r14, TextView.class, "com.obric.memorydata.plugin")).setTextColor(r15);
        return;
    L27:
        return;
    L5:
        r1 = r14.getTag();
        goto L7
    }

    private final void a(TextView r4) {
        CharSequence r0 = r4.getText();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if ((!r2) == true) goto L13;
        r1 = 8;
    L13:
        r4.setVisibility(r1);
        requestLayout();
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    private final void a(TextView r4, TextView r5, int r6) {
        r4.setMinWidth(RangesKt.coerceAtLeast(r6, 0));
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        if (r6 <= 0) goto L5;
        int r7 = 0;
    L6:
        r4.setVisibility(r7);
        r5.setMinWidth(0);
        r5.setText(null);
        r5.setVisibility(8);
        return;
    L5:
        r7 = 8;
        goto L6
    }

    private final void a(OButtonGroup r4, int r5) {
        int r0 = r4.getItemCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r2 = r1 + 1;
        a(r4.c(r1), r5);
        r1 = r2;
        goto L3
    }

    private final void a(OButtonGroup r10, int r11, Function1<? super Integer, Unit> r12) {
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        if (r11 != 0) goto L5;
        return;
    L5:
        TypedArray r14 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r11, R.styleable.OShadowFrame);
        Intrinsics.checkNotNullExpressionValue(r14, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        int r0 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetBgColor, "styleable", "OShadowFrame_oui_widgetBgColor"), 0);
        int r4 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetPressColor, "styleable", "OShadowFrame_oui_widgetPressColor"), 0);
        int r5 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetBgColorDisabled, "styleable", "OShadowFrame_oui_widgetBgColorDisabled"), 0);
        int r3 = r14.getColor(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetTintColor, "styleable", "OShadowFrame_oui_widgetTintColor"), 0);
        String r6 = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterial, "styleable", "OShadowFrame_oui_widgetMaterial"));
        String r2 = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OShadowFrame_oui_widgetMaterialDisabled, "styleable", "OShadowFrame_oui_widgetMaterialDisabled"));
        r14.recycle();
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.oui_material_bg_floating, TypedValues.Custom.S_STRING, "oui_material_bg_floating"));
        Intrinsics.checkNotNullExpressionValue(r9, "context.getString(R.stri…oui_material_bg_floating)");
        if (StringsKt.contentEquals((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L8;
    L10:
        if (r0 == 0) goto L26;
        if (r6 == null) goto L17;
        if (r5 != 0) goto L15;
        r5 = r0;
    L15:
        r10.a(r0, r5, r6, r2);
        goto L26
    L17:
        if (com.obric.oui.color.d.c(r0) == false) goto L22;
        if (r5 == 0) goto L20;
        int r15 = r5;
    L21:
        r10.a(r0, r15, com.obric.oui.material.d.f14017a.a(MaterialToken.OUI_Bg_Floating_Tinted_Light, r0), com.obric.oui.material.d.f14017a.a(MaterialToken.OUI_Bg_Floating_Tinted_Light, r5));
        goto L26
    L20:
        r15 = r0;
        goto L21
    L22:
        if (r5 != 0) goto L25;
        r5 = r0;
    L25:
        r10.a(r0, r5, (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin"));
    L26:
        if (r4 == 0) goto L28;
        r10.setPressColor(r4);
    L28:
        if (r3 == 0) goto L31;
        r13.invoke(Integer.valueOf(r3));
        return;
    L31:
        return;
    L8:
        if (com.obric.oui.color.d.c(r0) == false) goto L10;
        r6 = null;
        goto L10
    }

    private final void a(OButtonGroup r5, List<com.obric.oui.titlebar.a.C0783a> r6, List<? extends View> r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        List r9 = null;
    L10:
        if (r9 != null) goto L16;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L13:
        if (r12.hasNext() == false) goto L15;
        r11.add(Boolean.valueOf(((View) ZeusTransformUtils.preCheckCast(r12.next(), View.class, "com.obric.memorydata.plugin")).isEnabled()));
        goto L13
    L15:
        r9 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
    L16:
        boolean r13 = true;
        if (r9.isEmpty() == true) goto L19;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == true) goto L25;
    L27:
        Iterator r15 = r14.iterator();
    L29:
        if (r15.hasNext() == false) goto L26;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r15.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L29;
    L32:
        r5.setEnabled(r13);
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L34:
        if (r16.hasNext() == false) goto L43;
        Object r17 = r16.next();
        int r18 = r2 + 1;
        if (r2 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        boolean r19 = ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        View r1 = r5.c(r2);
        if (r1 == null) goto L42;
        r1.setEnabled(r19);
    L42:
        r2 = r18;
        goto L34
    L43:
        return;
    L26:
        r13 = false;
        goto L32
    L25:
        if (((Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L27;
    L19:
        if (r5.getItemCount() != 0) goto L52;
        r5.setEnabled(true);
        return;
    L52:
        return;
    L5:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r20.iterator();
    L7:
        if (r21.hasNext() == false) goto L9;
        r3.add(Boolean.valueOf(((com.obric.oui.titlebar.a.C0783a) ZeusTransformUtils.preCheckCast(r21.next(), com.obric.oui.titlebar.a.C0783a.class, "com.obric.memorydata.plugin")).f()));
        goto L7
    L9:
        r9 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        goto L10
    }

    private final void a(final EndAreaTransitionType r28, final c r29, final c r30, float r31, final CenterAvoidanceMode r32, final int r33, Function0<Unit> r34) {
        final Function0 r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r34, Function0.class, "com.obric.memorydata.plugin");
        Float[] r0 = a(r28, r29, r30, r31);
        final Float r12 = r0[0];
        final Float r17 = r0[1];
        SubEndShiftEndRawAlphaBinding r9 = a(r28);
        float[] r1 = a(r9);
        float r10 = r1[0];
        float r18 = r1[1];
        if (r29.g() == false) goto L7;
        if (r29.h() == false) goto L7;
    L10:
        boolean r2 = true;
    L12:
        final Ref.IntRef r8 = new Ref.IntRef();
        final Ref.BooleanRef r19 = new Ref.BooleanRef();
        final Ref.BooleanRef r7 = new Ref.BooleanRef();
        final Ref.BooleanRef r6 = new Ref.BooleanRef();
        if (r12 == null) goto L16;
        if (r17 != null) goto L16;
        boolean r20 = true;
    L17:
        setSubEndToEndGapVisible(r2);
        if (r32 != CenterAvoidanceMode.TRANSITION) goto L20;
        r8.element++;
    L20:
        int r5 = r29.d();
        int r4 = r30.d();
        if (r32 != CenterAvoidanceMode.TRANSITION) goto L23;
        Object r3 = ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$runEndAreaTransition$1(r8, r7, r33, this, r19, r30, r32, r16), Function0.class, "com.obric.memorydata.plugin");
    L24:
        a(r5, r4, r32, (Function0) r3);
        final boolean r13 = a(r9, r12, r17, r10, r18, r33);
        getEndSubButtonGroup().a(r30.b(), true);
        getEndButtonGroup().a(r30.c(), true);
        if (getEndSubButtonGroup().d() == false) goto L27;
        r8.element++;
        Ref.IntRef r14 = r8;
        getEndSubButtonGroup().a((Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$runEndAreaTransition$2(r28, this, r6, r8, r29, r30, r7, r33, r19, r32, r16), Function0.class, "com.obric.memorydata.plugin"));
    L29:
        if (getEndButtonGroup().d() == false) goto L31;
        r14.element++;
        final Ref.IntRef r11 = r14;
        getEndButtonGroup().a((Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$runEndAreaTransition$3(r28, this, r6, r11, r29, r30, r7, r33, r19, r32, r16), Function0.class, "com.obric.memorydata.plugin"));
    L31:
        if (r12 != 0) goto L36;
        if (r17 != null) goto L36;
    L41:
        r7.element = true;
        a(r7, r14, r33, this, r19, r30, r32, r16);
        return;
    L36:
        if (r13 != 0) goto L39;
        if (r20 == true) goto L39;
        r14.element++;
        final Ref.BooleanRef r15 = r6;
        r15.element = true;
    L40:
        final boolean r21 = r20;
        final Ref.IntRef r22 = r14;
        b((Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$runEndAreaTransition$4(r33, this, r15, r13, r21, r12, r17, r28, r22, r29, r30, r7, r19, r32, r16), Function0.class, "com.obric.memorydata.plugin"));
    L39:
        r15 = r6;
        goto L40
    L27:
        r14 = r8;
        goto L29
    L23:
        r3 = ZeusTransformUtils.preCheckCast(null, Function0.class, "com.obric.memorydata.plugin");
    L16:
        r20 = false;
    L7:
        if (r30.g() == true) goto L9;
    L11:
        r2 = false;
        goto L12
    L9:
        if (r30.h() == false) goto L11;
        goto L10
    }

    private static final void a(EndAreaTransitionType r1, c r2, c r3, OFloatingTitleBar r4) {
        if (r1 != EndAreaTransitionType.SUB_ONLY_TO_END_ONLY) goto L5;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        return;
    L15:
        r4.getEndSubButtonGroup().setTranslationX(0.0f);
        return;
    L5:
        if (r1 == EndAreaTransitionType.INTERRUPTED_SHIFT_RETURN) goto L7;
    L11:
        r5 = false;
        goto L13
    L7:
        if (r2.g() == false) goto L11;
        if (r3.a() != EndAreaActionState.END_ONLY) goto L11;
        goto L11
    }

    private static final void a(EndAreaTransitionType r2, OFloatingTitleBar r3, Ref.BooleanRef r4, Ref.IntRef r5) {
        if (r2 != EndAreaTransitionType.BOTH_TO_SUB_ONLY) goto L5;
    L7:
        r3.getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        if (r4.element == false) goto L14;
        r4.element = false;
        com.obric.common.oea.foundation.animation.d.d r6 = r3.C;
        if (r6 == null) goto L13;
        com.obric.common.oea.foundation.animation.d.d.a(r6, false, 1, null);
    L13:
        r3.C = null;
        r5.element--;
    L14:
        r3.getEndSubButtonGroup().setTranslationX(0.0f);
        return;
    L5:
        if (r2 == EndAreaTransitionType.END_ONLY_TO_SUB_ONLY) goto L7;
    }

    public static final /* synthetic */ void a(EndAreaTransitionType r13, OFloatingTitleBar r14, Ref.BooleanRef r15, Ref.IntRef r16, c r17, c r18, Ref.BooleanRef r19, int r20, Ref.BooleanRef r21, CenterAvoidanceMode r22, Function0 r23, String r24) {
        b(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, (Function0) ZeusTransformUtils.wrapperContextForParams(r23, Function0.class, "com.obric.memorydata.plugin"), r24);
    }

    private final void a(SubEndShiftEndRawAlphaBinding r5, Float r6, Float r7, float r8, float r9) {
        float r0 = getEndButtonGroup().getRawGroupAlphaForTitleBarTransition$OUI_standardRelease();
        int r10 = e.f14743b[r5.ordinal()];
        float r3 = 0.0f;
        if (r10 != 1) goto L5;
        float r11 = r8 - r9;
        if (Math.abs(r11) < 0.001f) goto L30;
        if (r6 == null) goto L29;
        r3 = r6.floatValue();
    L29:
        r3 = r3 * ((r0 - r9) / r11);
    L30:
        getEndSubButtonGroup().setTranslationX(r3);
        e();
        return;
    L5:
        if (r10 != 2) goto L7;
        float r12 = r9 - r8;
        if (Math.abs(r12) >= 0.001f) goto L16;
        if (r7 == null) goto L30;
        r3 = r7.floatValue();
        goto L30
    L16:
        if (r6 != null) goto L18;
        float r13 = 0.0f;
    L19:
        if (r7 == null) goto L22;
        r3 = r7.floatValue();
    L22:
        r3 = ((r3 - r13) * ((RangesKt.coerceAtMost(r0, r8) - r8) / r12)) + r13;
        goto L30
    L18:
        r13 = r6.floatValue();
        goto L19
    L7:
        if (r10 != 3) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final void a(c r4) {
        FrameLayout r0 = null;
        setFreezeEndAreaWidth(null);
        FrameLayout r1 = this.j;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L6:
        r0.setTranslationX(0.0f);
        getEndSubButtonGroup().setTranslationX(0.0f);
        if (r4.g() == true) goto L9;
    L11:
        boolean r2 = false;
    L12:
        setSubEndToEndGapVisible(r2);
        getEndSubButtonGroup().a(r4.b(), false);
        getEndButtonGroup().a(r4.c(), false);
        return;
    L9:
        if (r4.h() == false) goto L11;
        r2 = true;
        goto L12
    L5:
        r0 = r1;
        goto L6
    }

    private final void a(c r9, c r10, CenterAvoidanceMode r11, Function0<Unit> r12) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        float r4 = getEndSubButtonGroup().getTranslationX();
        a(a(r9, r10, r4), r9, r10, r4, r11, this.E, r7);
    }

    private final void a(c r4, c r5, boolean r6, CenterAvoidanceMode r7, Function0<Unit> r8) {
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        y();
        this.E++;
        getEndSubButtonGroup().a();
        getEndButtonGroup().a();
        if (r7 != CenterAvoidanceMode.NONE) goto L8;
        FrameLayout r0 = this.j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r0 = null;
    L7:
        r0.setTranslationX(0.0f);
        setFreezeEndAreaWidth(null);
    L8:
        if (r6 == true) goto L14;
        a(r5);
        if (r9 == null) goto L16;
        r9.invoke();
        return;
    L16:
        return;
    L14:
        a(r4, r5, r7, r9);
    }

    public static final /* synthetic */ void a(OFloatingTitleBar r2, float r3, Function0 r4) {
        r2.a(r3, (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(OFloatingTitleBar r0, int r1) {
        r0.r = r1;
    }

    private static final void a(OFloatingTitleBar r2, View.OnClickListener r3, View r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.m();
        r5.onClick(r4);
    }

    private static final void a(OFloatingTitleBar r0, View r1, View r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r1, "$sourceView");
        r0.m();
        r1.performClick();
    }

    public static final /* synthetic */ void a(OFloatingTitleBar r0, com.obric.common.oea.foundation.animation.d.d r1) {
        r0.C = r1;
    }

    public static final /* synthetic */ void a(OFloatingTitleBar r0, OButtonGroup r1, int r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(OFloatingTitleBar r0, SubEndShiftEndRawAlphaBinding r1, Float r2, Float r3, float r4, float r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void a(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.b(r1);
    }

    public static /* synthetic */ void a(OFloatingTitleBar r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r1;
    L5:
        r0.a(r1, r2);
    }

    private final void a(com.obric.oui.titlebar.a.c r11, a r12, com.obric.oui.titlebar.a.d r13) {
        this.K++;
        a(this, r11, r12, false, false, null, false, 16, null);     // Catch: Throwable -> L9
        if (r13 == null) goto L7;
        a(r13);     // Catch: Throwable -> L9
    L7:
        this.K--;
        return;
    L9:
        th = move-exception;
        this.K--;
        throw th;
    }

    private final void a(com.obric.oui.titlebar.a.g r6) {
        OTextView r0 = this.h;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r0 = null;
    L5:
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r0, TextView.class, "com.obric.memorydata.plugin");
        OTextView r3 = this.i;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r3 = null;
    L8:
        a(r2, (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin"), r6.a());
        OTextView r4 = this.m;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r4 = null;
    L11:
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.memorydata.plugin");
        OTextView r7 = this.n;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L15:
        a(r5, (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin"), r6.b());
        return;
    L14:
        r1 = r7;
        goto L15
    }

    private final void a(com.obric.oui.titlebar.a.h r2) {
        if (r2.a() == 0) goto L6;
        setStartButtonGroupStyle(r2.a());
    L6:
        if (r2.b() == 0) goto L9;
        setCenterButtonGroupStyle(r2.b());
    L9:
        if (r2.c() == 0) goto L12;
        setSubEndButtonGroupStyle(r2.c());
    L12:
        if (r2.d() == 0) goto L15;
        setEndButtonGroupStyle(r2.d());
        return;
    }

    private final void a(Function0<Unit> r6) {
        final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r2 = r8.next();
        if (((OButtonGroup) ZeusTransformUtils.preCheckCast(r2, OButtonGroup.class, "com.obric.memorydata.plugin")).d() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == false) goto L12;
        r7.invoke();
        return;
    L12:
        final Ref.IntRef r1 = new Ref.IntRef();
        r1.element = r9.size();
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        ((OButtonGroup) ZeusTransformUtils.preCheckCast(r10.next(), OButtonGroup.class, "com.obric.memorydata.plugin")).a((Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$waitForButtonGroupAnimationsEnd$1$1(r1, r7), Function0.class, "com.obric.memorydata.plugin"));
        goto L14
    }

    public static final /* synthetic */ void a(Ref.BooleanRef r2, Ref.BooleanRef r3, Ref.BooleanRef r4, Function0 r5) {
        b(r2, r3, r4, (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(Ref.BooleanRef r6, Ref.IntRef r7, int r8, OFloatingTitleBar r9, Ref.BooleanRef r10, c r11, CenterAvoidanceMode r12, Function0<Unit> r13) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        if (r6.element == true) goto L5;
        return;
    L5:
        if (r7.element != 0) goto L9;
        a(r8, r9, r10, r11, r12, r5);
        return;
    }

    public static final /* synthetic */ void a(Ref.IntRef r8, Ref.BooleanRef r9, int r10, OFloatingTitleBar r11, Ref.BooleanRef r12, c r13, CenterAvoidanceMode r14, Function0 r15) {
        b(r8, r9, r10, r11, r12, r13, r14, (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(final SubEndShiftEndRawAlphaBinding r11, final Float r12, final Float r13, final float r14, final float r15, final int r16) {
        if (r11 != SubEndShiftEndRawAlphaBinding.NONE) goto L7;
        return false;
    L7:
        if (r11 != SubEndShiftEndRawAlphaBinding.APPEARING) goto L13;
        OButtonGroup r0 = getEndSubButtonGroup();
        if (r12 != null) goto L11;
        float r1 = 0.0f;
    L12:
        r0.setTranslationX(r1);
        goto L13
    L11:
        r1 = r12.floatValue();
    L13:
        getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease((Function0) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$bindSubEndShiftToEndRawAlphaIfNeeded$1(r16, this, r11, r12, r13, r14, r15), Function0.class, "com.obric.memorydata.plugin"));
        return true;
    }

    private final float[] a(SubEndShiftEndRawAlphaBinding r3) {
        int r4 = e.f14743b[r3.ordinal()];
        if (r4 == 1) goto L12;
        if (r4 == 2) goto L14;
        if (r4 != 3) goto L9;
        return new float[]{1.0f, 1.0f};
    L9:
        throw new NoWhenBranchMatchedException();
    L14:
        return new float[]{getEndButtonGroup().getRawGroupAlphaForTitleBarTransition$OUI_standardRelease(), 0.0f};
    L12:
        return new float[]{0.0f, 1.0f};
    }

    private final Float[] a(EndAreaTransitionType r9, c r10, c r11, float r12) {
        int r8 = e.f14742a[r9.ordinal()];
        Float r1 = Float.valueOf(0.0f);
        Float r3 = null;
        switch(r8) {
            case 1: goto L59;
            case 2: goto L50;
            case 3: goto L38;
            case 4: goto L26;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        Float[] r13 = {null, null};
    L60:
        Float[] r14 = new Float[2];
        Float r15 = r13[0];
        if (r15 != null) goto L64;
    L70:
        r14[0] = r3;
        r14[1] = r13[1];
        return r14;
    L64:
        if (((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).floatValue() != 0.0f) goto L66;
        boolean r16 = true;
    L68:
        if ((!r16) == false) goto L70;
        r3 = r15;
        goto L70
    L66:
        r16 = false;
        goto L68
    L7:
        r13 = new Float[2];
        if (r10.a() == EndAreaActionState.BOTH) goto L10;
    L12:
        Float r17 = Float.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.memorydata.plugin")).floatValue() != 0.0f) goto L15;
        boolean r6 = true;
    L17:
        if ((!r6) == true) goto L20;
        r17 = null;
    L20:
        r13[0] = r17;
        if (r10.g() == true) goto L23;
    L25:
        r13[1] = r1;
        goto L60
    L23:
        if (r11.a() != EndAreaActionState.END_ONLY) goto L25;
        r1 = null;
        goto L25
    L15:
        r6 = false;
        goto L17
    L10:
        if (r11.a() != EndAreaActionState.END_ONLY) goto L12;
        r17 = Float.valueOf(r11.e());
        goto L20
    L26:
        r13 = new Float[2];
        Float r18 = Float.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).floatValue() != 0.0f) goto L29;
        boolean r19 = true;
    L31:
        if ((!r19) == true) goto L34;
        r18 = null;
    L34:
        if (r18 != null) goto L36;
        float r110 = r10.f();
    L37:
        r13[0] = Float.valueOf(r110);
        r13[1] = null;
        goto L60
    L36:
        r110 = r18.floatValue();
        goto L37
    L29:
        r19 = false;
        goto L31
    L38:
        r13 = new Float[2];
        Float r111 = Float.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r111, Number.class, "com.obric.memorydata.plugin")).floatValue() != 0.0f) goto L41;
        boolean r112 = true;
    L43:
        if ((!r112) == true) goto L46;
        r111 = null;
    L46:
        if (r111 != null) goto L48;
        float r113 = r11.f();
    L49:
        r13[0] = Float.valueOf(r113);
        r13[1] = null;
        goto L60
    L48:
        r113 = r111.floatValue();
        goto L49
    L41:
        r112 = false;
        goto L43
    L50:
        r13 = new Float[2];
        Float r114 = Float.valueOf(r12);
        if (((Number) ZeusTransformUtils.preCheckCast(r114, Number.class, "com.obric.memorydata.plugin")).floatValue() != 0.0f) goto L53;
        boolean r115 = true;
    L55:
        if ((!r115) == true) goto L58;
        r114 = null;
    L58:
        r13[0] = r114;
        r13[1] = Float.valueOf(r10.e());
        goto L60
    L53:
        r115 = false;
        goto L55
    L59:
        r13 = new Float[]{Float.valueOf(r11.e()), r1};
        goto L60
    L5:
        throw new NoWhenBranchMatchedException();
    }

    private final int b(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L7;
        return 0;
    L7:
        return getEndButtonGroup().a(r4);
    }

    private final int b(List<com.obric.oui.titlebar.a.C0783a> r2, int r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 < 0) goto L7;
        if (r3 > r1.size()) goto L7;
        return r3;
    L7:
        return r1.size();
    }

    private final int b(List<? extends View> r4, List<? extends View> r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<? extends View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        r2 = 0 + getEndSubButtonGroup().a(r6);
    L6:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L8;
        return r2;
    L8:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L11;
        r2 = r2 + getSubEndToEndGap();
    L11:
        return r2 + getEndButtonGroup().a(r7);
    }

    private final View b(int r10, int r11) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        OUIFrameLayout r7 = new OUIFrameLayout(r1, null, 0, null, 14, null);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        r7.setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 7), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 7), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 7), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 7));
        r7.setClickable(true);
        r7.setRadius(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 99));
        ImageView r9 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r9.setImageResource(r10);
        if (r11 == 0) goto L5;
        r9.setColorFilter(r11);
    L5:
        View r12 = (View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 22), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), 22));
        r13.gravity = 17;
        Unit r14 = Unit.INSTANCE;
        r7.addView(r12, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ View b(OFloatingTitleBar r1, int r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.b(r2, r3, r7);
    }

    private final View b(String r19, int r20) {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        OUILinearLayout r8 = new OUILinearLayout(r2, null, 0, null, 14, null);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        r8.setMinimumHeight(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 36));
        r8.setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 7), 0, com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 8), 0);
        r8.setClickable(true);
        r8.setRadius(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 99));
        r8.setOrientation(0);
        r8.setGravity(16);
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        OTextView r5 = new OTextView(r12, null, 0, null, 14, null);
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"));
        r5.setGravity(16);
        r5.setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), 4), 0, 0, 0);
        r5.setSingleLine(true);
        r5.setMinHeight(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), 22));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r5.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Title_1_Bold, "style", "Title_1_Bold"));
    L5:
        if (r20 == 0) goto L7;
        r5.setTextColor(r20);
    L7:
        View r1 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.gravity = 16;
        Unit r4 = Unit.INSTANCE;
        r8.addView(r1, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ImageView r6 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r6.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_card_list_item_tail_icon_chevron, "drawable", "o_card_list_item_tail_icon_chevron"));
        if (r20 == 0) goto L10;
        r6.setColorFilter(r20);
    L10:
        View r0 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 20), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 20));
        r7.gravity = 16;
        r7.setMarginStart(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 4));
        Unit r9 = Unit.INSTANCE;
        r8.addView(r0, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.common.oea.foundation.animation.d.d b(float r10, final float r11, Function1<? super Float, Unit> r12, Function0<Unit> r13) {
        final Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        final Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        return com.obric.common.oea.foundation.animation.builder.c.a.a(new com.obric.common.oea.foundation.animation.builder.c.a(), r10, r11, com.obric.oui.common.util.a.a((com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(ai, aj, Token.Delay.OUI_ANIMATION_DELAY_NONE), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), 10.0f), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$startTranslationXSpring$1(r14, this), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$startTranslationXSpring$2(r14, r11, this, r15), Function2.class, "com.obric.memorydata.plugin")).a().a();
    }

    static /* synthetic */ a b(OFloatingTitleBar r6, List r7, List r8, List r9, List r10, boolean r11, int r12, Object r13) {
        List<View> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<View> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<View> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<View> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r14 = r6.a(r6.getStartButtonGroup());
    L5:
        List<View> r1 = r14;
        if ((r12 & 2) == 0) goto L8;
        r15 = r6.a(r6.getCenterButtonGroup());
    L8:
        List<View> r2 = r15;
        if ((r12 & 4) == 0) goto L11;
        r16 = r6.a(r6.getEndSubButtonGroup());
    L11:
        List<View> r3 = r16;
        if ((r12 & 8) == 0) goto L15;
        r17 = r6.a(r6.getEndButtonGroup());
    L15:
        return r6.b(r1, r2, r3, r17, r11);
    }

    private final a b(List<? extends View> r10, List<? extends View> r11, List<? extends View> r12, List<? extends View> r13, boolean r14) {
        return a(this, null, new a((List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin")), r14, false, null, false, 56, null);
    }

    private final com.obric.oui.titlebar.a.b b(com.obric.oui.titlebar.a.C0783a r9, int r10) {
        int r1 = r9.getType();
        int r2 = r9.a();
        String r3 = r9.b();
        String r5 = r9.c();
        String r0 = r9.g();
        if (r0 != null) goto L5;
        String r6 = c(r9.a());
    L7:
        return new com.obric.oui.titlebar.a.b(r1, r2, r3, r10, r5, r6);
    L5:
        r6 = r0;
        goto L7
    }

    private static final void b(EndAreaTransitionType r10, OFloatingTitleBar r11, Ref.BooleanRef r12, Ref.IntRef r13, c r14, c r15, Ref.BooleanRef r16, int r17, Ref.BooleanRef r18, CenterAvoidanceMode r19, Function0<Unit> r20, String r21) {
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r21, "end") == false) goto L6;
        a(r10, r11, r12, r13);
    L9:
        b(r13, r16, r17, r11, r18, r15, r19, r9);
        return;
    L6:
        if (Intrinsics.areEqual(r21, "subEnd") == false) goto L9;
        a(r10, r14, r15, r11);
        goto L9
    }

    public static final /* synthetic */ void b(OFloatingTitleBar r0) {
        r0.D();
    }

    public static final /* synthetic */ void b(OFloatingTitleBar r0, int r1) {
        r0.s = r1;
    }

    public static final /* synthetic */ void b(OFloatingTitleBar r0, com.obric.common.oea.foundation.animation.d.d r1) {
        r0.D = r1;
    }

    public static /* synthetic */ void b(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.c(r1);
    }

    private final void b(com.obric.oui.titlebar.a.c r5, a r6) {
        OButtonGroup r0 = getStartButtonGroup();
        List<com.obric.oui.titlebar.a.C0783a> r1 = null;
        if (r5 != null) goto L5;
        List<com.obric.oui.titlebar.a.C0783a> r2 = null;
    L6:
        a(r0, r2, r6.a());
        OButtonGroup r3 = getCenterButtonGroup();
        if (r5 != null) goto L9;
        List<com.obric.oui.titlebar.a.C0783a> r4 = null;
    L10:
        a(r3, r4, r6.b());
        OButtonGroup r7 = getEndSubButtonGroup();
        if (r5 != null) goto L13;
        List<com.obric.oui.titlebar.a.C0783a> r8 = null;
    L14:
        a(r7, r8, r6.c());
        OButtonGroup r9 = getEndButtonGroup();
        if (r5 == null) goto L18;
        r1 = r5.d();
    L18:
        a(r9, r1, r6.d());
        return;
    L13:
        r8 = r5.c();
        goto L14
    L9:
        r4 = r5.b();
        goto L10
    L5:
        r2 = r5.a();
        goto L6
    }

    private final void b(com.obric.oui.titlebar.a r2) {
        this.K++;
        a(r2);     // Catch: Throwable -> L6
        this.K--;
        return;
    L6:
        th = move-exception;
        this.K--;
        throw th;
    }

    private final void b(Function0<Unit> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        View r0 = this.q;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r0 = null;
    L5:
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        r1.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new f(r1, this, r5), ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
    }

    private static final void b(Ref.BooleanRef r2, Ref.BooleanRef r3, Ref.BooleanRef r4, Function0<Unit> r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if (r2.element == false) goto L5;
        return;
    L5:
        if (r3.element == true) goto L7;
        return;
    L7:
        if (r4.element == false) goto L15;
        r2.element = true;
        if (r6 == null) goto L16;
        r6.invoke();
        return;
    L16:
        return;
    }

    private static final void b(Ref.IntRef r8, Ref.BooleanRef r9, int r10, OFloatingTitleBar r11, Ref.BooleanRef r12, c r13, CenterAvoidanceMode r14, Function0<Unit> r15) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        r8.element--;
        a(r9, r8, r10, r11, r12, r13, r14, r7);
    }

    private final boolean b(c r8, c r9) {
        int r0 = getMeasuredWidth();
        if (r0 > 0) goto L5;
        return false;
    L5:
        FrameLayout r2 = this.j;
        View r4 = null;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r2 = null;
    L8:
        Integer r3 = Integer.valueOf(r2.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == true) goto L15;
        r3 = null;
    L15:
        if (r3 != null) goto L20;
        FrameLayout r6 = this.j;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r6 = null;
    L19:
        int r7 = r6.getMeasuredWidth();
    L21:
        if (r7 > 0) goto L23;
        return false;
    L23:
        int r10 = Math.max(r8.d(), r9.d());
        if (r10 > 0) goto L26;
        return false;
    L26:
        int r11 = getCenterTitleGap();
        View r12 = this.q;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r12 = null;
    L29:
        int r13 = r12.getPaddingLeft();
        View r14 = this.q;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L33:
        int r1 = r0 - r4.getPaddingRight();
        if ((r13 + (((r1 - r13) + r7) / 2)) > ((r1 - r10) - r11)) goto L36;
        return false;
    L36:
        return true;
    L32:
        r4 = r14;
        goto L33
    L20:
        r7 = r3.intValue();
        goto L21
    L11:
        r5 = false;
        goto L12
    }

    private final boolean b(boolean r7, boolean r8) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r6.iterator();
    L9:
        if (r9.hasNext() == false) goto L30;
        OButtonGroup r0 = (OButtonGroup) ZeusTransformUtils.preCheckCast(r9.next(), OButtonGroup.class, "com.obric.memorydata.plugin");
        if (r7 == true) goto L17;
        if (r0.getAlpha() == 0.0f) goto L23;
    L15:
        boolean r4 = false;
    L25:
        if (r0.b() != r8) goto L28;
        if (r4 == false) goto L28;
        boolean r1 = true;
    L29:
        if (r1 == true) goto L9;
        return false;
    L28:
        r1 = false;
    L23:
        r4 = true;
        goto L25
    L17:
        if (r0.d() == true) goto L23;
        if (r0.getAlpha() != 1.0f) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L15;
    L21:
        r5 = false;
    L30:
        return true;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ int c(OFloatingTitleBar r0) {
        return r0.r;
    }

    public static /* synthetic */ View c(OFloatingTitleBar r1, int r2, int r3, View.OnClickListener r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = null;
    L9:
        return r1.c(r2, r3, r7);
    }

    private final EndAreaActionState c(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        return EndAreaActionState.BOTH;
    L5:
        if (r1 == true) goto L12;
        if (r2 == false) goto L10;
        return EndAreaActionState.END_ONLY;
    L10:
        return EndAreaActionState.EMPTY;
    L12:
        return EndAreaActionState.SUB_ONLY;
    }

    private final String c(int r4) {
        if (r4 != 0) goto L9;
        return null;
    L9:
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getResourceTypeName(r4) + '/' + ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getResourceEntryName(r4);
    L8:
        return (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void c(OFloatingTitleBar r0, int r1) {
        r0.u = r1;
    }

    public static /* synthetic */ void c(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.d(r1);
    }

    private final boolean c(c r3, c r4) {
        if (r3.d() == r4.d()) goto L5;
    L14:
        return true;
    L5:
        if (r3.a() != r4.a()) goto L14;
        if (this.F != null) goto L14;
        if (getEndSubButtonGroup().d() == true) goto L14;
        if (getEndButtonGroup().d() == true) goto L14;
        return false;
    }

    public static final /* synthetic */ int d(OFloatingTitleBar r0) {
        return r0.s;
    }

    public static final /* synthetic */ void d(OFloatingTitleBar r0, int r1) {
        r0.t = r1;
    }

    public static /* synthetic */ void d(OFloatingTitleBar r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.e(r1);
    }

    public static final /* synthetic */ int e(OFloatingTitleBar r0) {
        return r0.u;
    }

    private static final void e(OFloatingTitleBar r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Integer r0 = r1.F;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != r2) goto L9;
        r1.A();
        return;
    }

    public static final /* synthetic */ int f(OFloatingTitleBar r0) {
        return r0.t;
    }

    public static final /* synthetic */ int g(OFloatingTitleBar r0) {
        return r0.E;
    }

    private final int getCenterTitleGap() {
        if (this.ad == false) goto L6;
        return this.ah;
    L6:
        return this.ag;
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.c() <= 1) goto L9;
        View r2 = this.q;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        return null;
    L10:
        return r2;
    L9:
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    }

    private final int getEndAreaWidthForCenter() {
        Integer r0 = this.F;
        if (r0 != null) goto L9;
        LinearLayout r1 = this.o;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
        r1 = null;
    L10:
        return r1.getMeasuredWidth();
    L9:
        return r0.intValue();
    }

    private final int getSubEndToEndGap() {
        return this.L;
    }

    public static final /* synthetic */ FrameLayout h(OFloatingTitleBar r0) {
        return r0.j;
    }

    public static final /* synthetic */ void i(OFloatingTitleBar r0) {
        r0.A();
    }

    private final boolean i(boolean r1) {
        if (r1 == false) goto L4;
    L7:
        return true;
    L4:
        if (this.F != null) goto L7;
        return false;
    }

    public static final /* synthetic */ View j(OFloatingTitleBar r0) {
        return r0.q;
    }

    private static final void k(OFloatingTitleBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.o();
    }

    public static /* synthetic */ void lambda$ZI6CHZZqiU5XJHO6BfJsaLaEVsI(OFloatingTitleBar r0, int r1) {
        e(r0, r1);
    }

    public static /* synthetic */ void lambda$abSvRyqcb2Pjx9xH5a7lJWfPVfA(OFloatingTitleBar r0, View r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$eQQ1sLABETwyMJkoEh56gcYHorc(OFloatingTitleBar r0, View.OnClickListener r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$irB2KrFCfo9zbdjLAlQv51Soqrk(OFloatingTitleBar r0) {
        m1386setFloatingTransitionOwnerActive$lambda66(r0);
    }

    public static /* synthetic */ void lambda$q57whpxKAZsthHRtqKA5zn5VOTI(OFloatingTitleBar r0) {
        m1385setFloatingTransitionEnabled$lambda65(r0);
    }

    public static /* synthetic */ void lambda$yDc3vANX2yZ1IuG3OHKqa9_tlzU(OFloatingTitleBar r0) {
        k(r0);
    }

    private final void q() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.start_container, OaidModel.KEY_ID, "start_container"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.start_container)");
        this.f = (FrameLayout) ZeusTransformUtils.preCheckCast(r0, FrameLayout.class, "com.obric.memorydata.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.start_button_group, OaidModel.KEY_ID, "start_button_group"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.start_button_group)");
        setStartButtonGroup((OButtonGroup) ZeusTransformUtils.preCheckCast(r1, OButtonGroup.class, "com.obric.memorydata.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.start_title_container, OaidModel.KEY_ID, "start_title_container"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.start_title_container)");
        this.g = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.start_title, OaidModel.KEY_ID, "start_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.start_title)");
        this.h = (OTextView) ZeusTransformUtils.preCheckCast(r3, OTextView.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.start_sub_title, OaidModel.KEY_ID, "start_sub_title"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.start_sub_title)");
        this.i = (OTextView) ZeusTransformUtils.preCheckCast(r4, OTextView.class, "com.obric.memorydata.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.center_container, OaidModel.KEY_ID, "center_container"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.center_container)");
        this.j = (FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.center_button_group, OaidModel.KEY_ID, "center_button_group"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.center_button_group)");
        setCenterButtonGroup((OButtonGroup) ZeusTransformUtils.preCheckCast(r6, OButtonGroup.class, "com.obric.memorydata.plugin"));
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.center_custom_container, OaidModel.KEY_ID, "center_custom_container"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.center_custom_container)");
        this.k = (FrameLayout) ZeusTransformUtils.preCheckCast(r7, FrameLayout.class, "com.obric.memorydata.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title_container, OaidModel.KEY_ID, "center_title_container"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.center_title_container)");
        this.l = (LinearLayout) ZeusTransformUtils.preCheckCast(r8, LinearLayout.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.center_title, OaidModel.KEY_ID, "center_title"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.center_title)");
        this.m = (OTextView) ZeusTransformUtils.preCheckCast(r9, OTextView.class, "com.obric.memorydata.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.center_sub_title, OaidModel.KEY_ID, "center_sub_title"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.center_sub_title)");
        this.n = (OTextView) ZeusTransformUtils.preCheckCast(r10, OTextView.class, "com.obric.memorydata.plugin");
        View r11 = null;
        if (Build.VERSION.SDK_INT < 28) goto L17;
        OTextView r12 = this.h;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r12 = null;
    L7:
        r12.setFallbackLineSpacing(false);
        OTextView r13 = this.i;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r13 = null;
    L10:
        r13.setFallbackLineSpacing(false);
        OTextView r14 = this.m;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r14 = null;
    L13:
        r14.setFallbackLineSpacing(false);
        OTextView r15 = this.n;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r15 = null;
    L16:
        r15.setFallbackLineSpacing(false);
    L17:
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.end_container, OaidModel.KEY_ID, "end_container"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.end_container)");
        this.o = (LinearLayout) ZeusTransformUtils.preCheckCast(r16, LinearLayout.class, "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.end_sub_button_group, OaidModel.KEY_ID, "end_sub_button_group"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.end_sub_button_group)");
        setEndSubButtonGroup((OButtonGroup) ZeusTransformUtils.preCheckCast(r17, OButtonGroup.class, "com.obric.memorydata.plugin"));
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.end_button_group, OaidModel.KEY_ID, "end_button_group"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.end_button_group)");
        setEndButtonGroup((OButtonGroup) ZeusTransformUtils.preCheckCast(r18, OButtonGroup.class, "com.obric.memorydata.plugin"));
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.material_mask, OaidModel.KEY_ID, "material_mask"));
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.material_mask)");
        this.p = r19;
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container"));
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.title_bar_container)");
        this.q = r20;
        if (r20 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L21:
        r11.setClickable(true);
        this.aa = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.W.invoke(Boolean.valueOf(true ^ I())), com.obric.oui.material.c.class, "com.obric.memorydata.plugin");
        B();
        return;
    L20:
        r11 = r20;
        goto L21
    }

    private final int r() {
        View r2 = this.q;
        ViewGroup.MarginLayoutParams r0 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r2 = null;
    L5:
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L8;
        r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L8:
        if (r0 != null) goto L11;
        return 0;
    L11:
        return r0.topMargin;
    }

    private final com.obric.oui.titlebar.a.e s() {
        int[] r0 = new int[2];
        if (isAttachedToWindow() == false) goto L6;
        getLocationOnScreen(r0);
    L6:
        return new com.obric.oui.titlebar.a.e(getWidth(), getHeight(), r0[0], r0[1]);
    }

    /* JADX INFO: renamed from: setFloatingTransitionEnabled$lambda-65, reason: not valid java name */
    private static final void m1385setFloatingTransitionEnabled$lambda65(OFloatingTitleBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.o();
    }

    /* JADX INFO: renamed from: setFloatingTransitionOwnerActive$lambda-66, reason: not valid java name */
    private static final void m1386setFloatingTransitionOwnerActive$lambda66(OFloatingTitleBar r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.o();
    }

    private final void setFreezeEndAreaWidth(Integer r2) {
        if (Intrinsics.areEqual(this.F, r2) == false) goto L5;
        return;
    L5:
        this.F = r2;
        requestLayout();
    }

    private final void setSubEndToEndGapVisible(boolean r4) {
        ViewGroup.LayoutParams r0 = getEndButtonGroup().getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        if (r4 == false) goto L10;
        int r5 = this.L;
    L12:
        if (r1.getMarginStart() != r5) goto L14;
        return;
    L14:
        r1.setMarginStart(r5);
        getEndButtonGroup().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        r5 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final com.obric.oui.titlebar.a.h t() {
        return new com.obric.oui.titlebar.a.h(this.y, this.z, this.A, this.B);
    }

    private final com.obric.oui.titlebar.a.c u() {
        return new com.obric.oui.titlebar.a.c(a(getStartButtonGroup(), this.U.a(), this.r), a(getCenterButtonGroup(), this.U.b(), this.s), a(getEndSubButtonGroup(), this.U.c(), this.u), a(getEndButtonGroup(), this.U.d(), this.t));
    }

    private final a v() {
        return new a(a(getStartButtonGroup()), a(getCenterButtonGroup()), a(getEndSubButtonGroup()), a(getEndButtonGroup()));
    }

    private final void w() {
        if (com.obric.oui.titlebar.floating.b.b() == false) goto L5;
        Log.d("lzr", Intrinsics.stringPlus("applyActionContentVisibility ", h()));
    L5:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        OButtonGroup r1 = (OButtonGroup) ZeusTransformUtils.preCheckCast(r0.next(), OButtonGroup.class, "com.obric.memorydata.plugin");
        r1.setTouchEventBlocked$OUI_standardRelease(this.H);
        if (this.G == false) goto L10;
        if (r1.d() == true) goto L7;
        float r3 = 1.0f;
    L11:
        r1.setAlpha(r3);
        goto L7
    L10:
        r3 = 0.0f;
        goto L11
    }

    private final void x() {
        if (this.f14736J == false) goto L5;
        float r0 = 1.0f;
    L6:
        ViewGroup[] r1 = new ViewGroup[3];
        LinearLayout r3 = this.g;
        FrameLayout r4 = null;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleContainer");
        r3 = null;
    L9:
        r1[0] = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.memorydata.plugin");
        LinearLayout r5 = this.l;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleContainer");
        r5 = null;
    L12:
        r1[1] = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
        FrameLayout r6 = this.k;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L16:
        r1[2] = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r1), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        ViewGroup r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r2.next(), ViewGroup.class, "com.obric.memorydata.plugin");
        r7.setAlpha(r0);
        r7.setEnabled(this.f14736J);
        r7.setClickable(this.f14736J);
        goto L18
    L20:
        return;
    L15:
        r4 = r6;
        goto L16
    L5:
        r0 = 0.0f;
        goto L6
    }

    private final void y() {
        com.obric.common.oea.foundation.animation.d.d r0 = this.C;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.d.d.a(r0, false, 1, null);
    L6:
        this.C = null;
        getEndButtonGroup().setGroupAlphaAnimationUpdateListener$OUI_standardRelease(null);
        z();
    }

    private final void z() {
        com.obric.common.oea.foundation.animation.d.d r0 = this.D;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.d.d.a(r0, false, 1, null);
    L6:
        this.D = null;
    }

    public final View a(int r3, int r4, View.OnClickListener r5) {
        return a(r3, r4, false, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    public final View a(int r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.memorydata.plugin");
        com.obric.oui.titlebar.a.C0783a r16 = com.obric.oui.titlebar.a.C0783a.f14760a.a(r11, r15);
        int r17 = b(this.U.a(), r12);
        return (View) ZeusTransformUtils.preCheckCast(a(this, a(this.U.a(), r12, r16), null, null, null, r13, 14, null).a().get(r17), View.class, "com.obric.memorydata.plugin");
    }

    public final View a(View r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return a(r2, r3, r4, null);
    }

    public final View a(View r9, int r10, boolean r11, View.OnClickListener r12) {
        View.OnClickListener r13 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "view");
        if (r13 == null) goto L6;
        r9.setOnClickListener(a(r13));
    L6:
        b(this, null, null, null, a(a(getEndButtonGroup()), r10, r9), r11, 7, null);
        return r9;
    }

    public final View a(String r3, int r4, View.OnClickListener r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return a(r3, r4, false, r6);
    }

    public final View a(String r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        com.obric.oui.titlebar.a.C0783a r16 = com.obric.oui.titlebar.a.C0783a.f14760a.a(r11, r15);
        int r17 = b(this.U.d(), r12);
        return (View) ZeusTransformUtils.preCheckCast(a(this, null, null, null, a(this.U.d(), r12, r16), r13, 7, null).d().get(r17), View.class, "com.obric.memorydata.plugin");
    }

    public final void a() {
        FrameLayout r0 = this.k;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        FrameLayout r3 = this.k;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L9:
        r1.setVisibility(8);
        return;
    L8:
        r1 = r3;
        goto L9
    }

    public final void a(int r9) {
        View r0 = this.p;
        View r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r0 = null;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        r1.height = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_title_bar_mask_height, "dimen", "oui_title_bar_mask_height")) + r9;
        View r3 = this.p;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r3 = null;
    L8:
        r3.setLayoutParams(r1);
        View r4 = this.q;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r4 = null;
    L11:
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r6.topMargin = r9;
        View r8 = this.q;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L15:
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        r2 = r8;
        goto L15
    }

    public final void a(OFloatingTitleBarActionHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.T = new WeakReference(r2);
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        com.obric.oui.titlebar.floating.a r1 = this.N;
        if (r1 == null) goto L10;
        r1.a(r2);
        return;
    }

    public final void a(com.obric.oui.titlebar.a.d r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        i();
        getStartButtonGroup().a(r6.a(), (Function1) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$restoreAnimationState$1(this), Function1.class, "com.obric.memorydata.plugin"));
        getCenterButtonGroup().a(r6.b(), (Function1) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$restoreAnimationState$2(this), Function1.class, "com.obric.memorydata.plugin"));
        getEndSubButtonGroup().a(r6.c(), (Function1) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$restoreAnimationState$3(this), Function1.class, "com.obric.memorydata.plugin"));
        getEndButtonGroup().a(r6.d(), (Function1) ZeusTransformUtils.preCheckCast(new OFloatingTitleBar$restoreAnimationState$4(this), Function1.class, "com.obric.memorydata.plugin"));
        getEndSubButtonGroup().setTranslationX(r6.e());
        setFreezeEndAreaWidth(r6.f());
        FrameLayout r5 = this.j;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r5 = null;
    L5:
        r5.setTranslationX(r6.g());
    }

    public final void a(com.obric.oui.titlebar.a r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        a(r2, false, false);
    }

    public final void a(com.obric.oui.titlebar.a r11, boolean r12, Function0<Unit> r13) {
        Function0<Unit> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "state");
        Intrinsics.checkNotNullParameter(r14, "onTransitionEnd");
        a(r11.d());
        if (this.f14736J == true) goto L6;
        a(r11.b());
    L6:
        if (r11.b().c() <= 0) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        a();
    L15:
        com.obric.oui.titlebar.a.c r4 = r11.c();
        a r1 = a(this, r11.c(), false, 2, null);
        if (r12 == true) goto L18;
    L20:
        boolean r6 = false;
    L22:
        if (r11.e() != null) goto L24;
        Function0<Unit> r8 = r14;
    L25:
        a(r4, r1, r6, false, r8, false);
        com.obric.oui.titlebar.a.d r15 = r11.e();
        if (r15 == null) goto L30;
        a(r15);
        r14.invoke();
        return;
    L30:
        return;
    L24:
        r8 = null;
        goto L25
    L18:
        if (r11.e() != null) goto L20;
        r6 = true;
        goto L22
    L14:
        setCenterCustomView(a(r11.b().c(), r11.b().d()));
        goto L15
    L8:
        if (r11.b().d() > 0) goto L11;
        r0 = false;
        goto L12
    }

    public final void a(com.obric.oui.titlebar.a r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "state");
        a(r13.d());
        if (this.f14736J == true) goto L6;
        a(r13.b());
    L6:
        if (r13.b().c() <= 0) goto L8;
    L11:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        a();
    L15:
        com.obric.oui.titlebar.a.c r4 = r13.c();
        a r5 = a(this, r13.c(), false, 2, null);
        if (r14 == true) goto L18;
    L20:
        boolean r6 = false;
    L22:
        if (r13.e() != null) goto L24;
        boolean r9 = true;
    L25:
        a(this, r4, r5, r6, r15, null, r9, 16, null);
        com.obric.oui.titlebar.a.d r16 = r13.e();
        if (r16 == null) goto L30;
        a(r16);
        return;
    L30:
        return;
    L24:
        r9 = false;
        goto L25
    L18:
        if (r13.e() != null) goto L20;
        r6 = true;
        goto L22
    L14:
        setCenterCustomView(a(r13.b().c(), r13.b().d()));
        goto L15
    L8:
        if (r13.b().d() > 0) goto L11;
        r0 = false;
        goto L12
    }

    @Override // com.obric.oui.material.b
    public void a(boolean r4) {
        if (this.x == (-1)) goto L6;
        com.obric.oui.material.i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, this.x);
        return;
    L6:
        com.obric.oui.material.i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4, this.w);
    }

    public final void a(boolean r13, Function1<? super OFloatingTitleBar, Unit> r14) {
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "block");
        if (this.K <= 0) goto L6;
        r15.invoke(this);
        return;
    L6:
        C();
        com.obric.oui.titlebar.a r0 = d();
        a r2 = v();
        this.K++;
        r15.invoke(this);     // Catch: Throwable -> L10
        this.K--;
        com.obric.oui.titlebar.a.c r4 = new com.obric.oui.titlebar.a.c(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.U.a(), Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.U.b(), Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.U.c(), Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.U.d(), Iterable.class, "com.obric.memorydata.plugin")));
        a r5 = v();
        a(r0.c(), r2, r0.e());
        a(this, r4, r5, r13, false, null, false, 56, null);
        return;
    L10:
        th = move-exception;
        this.K--;
        b(r0);
        throw th;
    }

    public final void a(boolean r3, boolean r4) {
        boolean r0 = true;
        if (r3 == false) goto L5;
    L9:
        if (r4 == true) goto L12;
        if (r3 == true) goto L12;
    L14:
        if (this.G == r3) goto L16;
    L20:
        this.G = r3;
        this.H = r0;
        w();
        return;
    L16:
        if (this.H != r0) goto L20;
        if (b(r3, r0) == false) goto L20;
        return;
    L12:
        r0 = false;
        goto L14
    L5:
        if (f() == false) goto L7;
    L8:
        r4 = true;
        goto L9
    L7:
        if (this.I == false) goto L9;
        goto L8
    }

    public final View b(int r3, int r4, View.OnClickListener r5) {
        return b(r3, r4, false, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    public final View b(int r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.memorydata.plugin");
        com.obric.oui.titlebar.a.C0783a r16 = com.obric.oui.titlebar.a.C0783a.f14760a.a(r11, r15);
        int r17 = b(this.U.d(), r12);
        return (View) ZeusTransformUtils.preCheckCast(a(this, null, null, null, a(this.U.d(), r12, r16), r13, 7, null).d().get(r17), View.class, "com.obric.memorydata.plugin");
    }

    public final com.obric.oui.titlebar.a b() {
        FrameLayout r0 = this.k;
        Integer r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r0 = null;
    L5:
        int r2 = 0;
        View r3 = r0.getChildAt(0);
        com.obric.oui.titlebar.a.e r4 = s();
        LinearLayout r5 = this.g;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleContainer");
        r5 = null;
    L8:
        int r8 = a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
        LinearLayout r6 = this.l;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleContainer");
        r6 = null;
    L11:
        int r9 = a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        boolean r7 = true;
        if (r3 != null) goto L14;
    L13:
        Integer r10 = null;
    L19:
        if (r10 != null) goto L23;
        if (r3 != null) goto L22;
        int r11 = 0;
    L24:
        if (r3 == null) goto L32;
        Integer r12 = Integer.valueOf(r3.getMeasuredHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L30;
        r7 = false;
    L30:
        if (r7 == false) goto L32;
        r1 = r12;
    L32:
        if (r1 != null) goto L36;
        if (r3 == null) goto L38;
        r2 = Integer.valueOf(r3.getHeight()).intValue();
    L38:
        return new com.obric.oui.titlebar.a(r4, new com.obric.oui.titlebar.a.g(r8, r9, r11, r2, r()), u(), t(), null, null, 48, null);
    L36:
        r2 = r1.intValue();
        goto L38
    L22:
        r10 = Integer.valueOf(r3.getWidth());
    L23:
        r11 = r10.intValue();
        goto L24
    L14:
        r10 = Integer.valueOf(r3.getMeasuredWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == false) goto L13;
    L17:
        r13 = false;
        goto L18
    }

    @Override // com.obric.oui.material.h
    public void b(int r4) {
        this.x = r4;
        com.obric.oui.material.i.a((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), Iterable.class, "com.obric.memorydata.plugin"), r4);
    }

    public final void b(OFloatingTitleBarActionHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        WeakReference<OFloatingTitleBarActionHost> r0 = this.T;
        if (r0 != null) goto L5;
        OFloatingTitleBarActionHost r1 = null;
    L6:
        if (r1 != r5) goto L9;
        this.T = null;
        return;
    L9:
        return;
    L5:
        r1 = (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(r0.get(), OFloatingTitleBarActionHost.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void b(boolean r9) {
        a(this, CollectionsKt.emptyList(), null, null, null, r9, 14, null);
    }

    public final View c(int r3, int r4, View.OnClickListener r5) {
        return c(r3, r4, false, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r5, View.OnClickListener.class, "com.obric.memorydata.plugin"));
    }

    public final View c(int r11, int r12, boolean r13, View.OnClickListener r14) {
        View.OnClickListener r15 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.memorydata.plugin");
        com.obric.oui.titlebar.a.C0783a r16 = com.obric.oui.titlebar.a.C0783a.f14760a.a(r11, r15);
        int r17 = b(this.U.c(), r12);
        return (View) ZeusTransformUtils.preCheckCast(a(this, null, null, a(this.U.c(), r12, r16), null, r13, 11, null).c().get(r17), View.class, "com.obric.memorydata.plugin");
    }

    public final com.obric.oui.titlebar.a c() {
        com.obric.oui.titlebar.a r0 = b();
        com.obric.oui.titlebar.a.c r1 = this.V;
        if (r1 != null) goto L5;
        com.obric.oui.titlebar.a.c r3 = u();
    L7:
        return com.obric.oui.titlebar.a.a(r0, null, null, r3, null, null, null, 59, null);
    L5:
        r3 = r1;
        goto L7
    }

    public final void c(boolean r9) {
        a(this, null, CollectionsKt.emptyList(), null, null, r9, 13, null);
    }

    public final boolean c(OFloatingTitleBarActionHost r5) {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L6;
        return false;
    L6:
        if (this.O == true) goto L9;
        return false;
    L9:
        if (this.M == true) goto L12;
        this.M = true;
    L12:
        if (this.N != null) goto L17;
        com.obric.oui.titlebar.floating.a r0 = new com.obric.oui.titlebar.floating.a(this);
        this.N = r0;
        if (r0 == null) goto L17;
        r0.a(this.Q);
    L17:
        com.obric.oui.titlebar.floating.a r1 = this.N;
        if (r1 == null) goto L22;
        r1.b(r5);
    L22:
        if (isAttachedToWindow() == true) goto L24;
        return false;
    L24:
        com.obric.oui.titlebar.floating.a r4 = this.N;
        if (r4 == null) goto L28;
        r4.a(true);
    L28:
        return true;
    }

    public final com.obric.oui.titlebar.a d() {
        return com.obric.oui.titlebar.a.a(b(), null, null, null, null, j(), null, 47, null);
    }

    public final void d(boolean r9) {
        a(this, null, null, null, CollectionsKt.emptyList(), r9, 7, null);
    }

    public final void e() {
        Function0<Unit> r0 = this.S;
        if (r0 == null) goto L7;
        r0.invoke();
        return;
    }

    public final void e(boolean r9) {
        a(this, null, null, CollectionsKt.emptyList(), null, r9, 11, null);
    }

    public final void f(boolean r1) {
        View r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("materialMask");
        r0 = null;
    L5:
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public final boolean f() {
        com.obric.oui.titlebar.floating.a r2 = this.N;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.d() == true) goto L8;
        return false;
    L8:
        return true;
    }

    public final void g(boolean r2) {
        a(false, r2);
    }

    public final boolean g() {
        return this.G;
    }

    public final OFloatingTitleBarActionHost getBoundActionHost$OUI_standardRelease() {
        WeakReference<OFloatingTitleBarActionHost> r2 = this.T;
        if (r2 != null) goto L6;
        return null;
    L6:
        return (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(r2.get(), OFloatingTitleBarActionHost.class, "com.obric.memorydata.plugin");
    }

    public final OButtonGroup getCenterButtonGroup() {
        OButtonGroup r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("centerButtonGroup");
        return null;
    }

    public final OTextView getCenterSubtitleView() {
        OTextView r0 = this.n;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getCenterTitleView() {
        OTextView r0 = this.m;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        return null;
    L6:
        return r0;
    }

    public final OButtonGroup getEndButtonGroup() {
        OButtonGroup r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("endButtonGroup");
        return null;
    }

    public final OButtonGroup getEndSubButtonGroup() {
        OButtonGroup r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("endSubButtonGroup");
        return null;
    }

    public final OButtonGroup getStartButtonGroup() {
        OButtonGroup r0 = this.f14737b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("startButtonGroup");
        return null;
    }

    public final OTextView getStartSubtitleView() {
        OTextView r0 = this.i;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        return null;
    L6:
        return r0;
    }

    public final OTextView getStartTitleView() {
        OTextView r0 = this.h;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        return null;
    L6:
        return r0;
    }

    public final String h() {
        WeakReference<OFloatingTitleBarActionHost> r0 = this.T;
        Integer r1 = null;
        if (r0 != null) goto L5;
        OFloatingTitleBarActionHost r2 = null;
    L6:
        StringBuilder r3 = new StringBuilder();
        r3.append("titleBar=").append(System.identityHashCode(this)).append(" vis=").append(getVisibility()).append(" shown=").append(isShown()).append(" attached=").append(isAttachedToWindow()).append(" laidOut=").append(isLaidOut()).append(" layoutRequested=").append(isLayoutRequested()).append(" size=").append(getWidth()).append('x').append(getHeight()).append(" alpha=").append(getAlpha()).append(" actionVisible=").append(this.G).append(" touchBlocked=").append(this.H).append(" nonActionVisible=");
        StringBuilder r4 = r3.append(this.f14736J).append(" enableFloating=").append(this.M).append(" ownerActive=").append(this.O).append(" hasBridge=");
        if (this.N == null) goto L9;
        boolean r5 = true;
    L10:
        StringBuilder r6 = r4.append(r5).append(" boundHost=");
        if (r2 == null) goto L14;
        r1 = Integer.valueOf(System.identityHashCode(r2));
    L14:
        r6.append(r1);
        return r3.toString();
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(r0.get(), OFloatingTitleBarActionHost.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void h(boolean r2) {
        i();
        if (r2 == false) goto L6;
        a(false, true);
        return;
    }

    public final void i() {
        y();
        getEndSubButtonGroup().a();
        getEndButtonGroup().a();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((OButtonGroup) ZeusTransformUtils.preCheckCast(r3.next(), OButtonGroup.class, "com.obric.memorydata.plugin")).c();
        goto L4
    }

    public final com.obric.oui.titlebar.a.d j() {
        OButtonGroup.b r1 = getStartButtonGroup().e();
        OButtonGroup.b r2 = getCenterButtonGroup().e();
        OButtonGroup.b r3 = getEndSubButtonGroup().e();
        OButtonGroup.b r4 = getEndButtonGroup().e();
        float r5 = getEndSubButtonGroup().getTranslationX();
        Integer r6 = this.F;
        FrameLayout r9 = this.j;
        if (r9 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r9 = null;
    L6:
        return new com.obric.oui.titlebar.a.d(r1, r2, r3, r4, r5, r6, r9.getTranslationX());
    }

    @Deprecated(message = "not support set default mask background")
    public final void k() {
    }

    public final void l() {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        com.obric.oui.titlebar.floating.a r1 = this.N;
        if (r1 == null) goto L10;
        r1.a();
        return;
    }

    public final void m() {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        com.obric.oui.titlebar.floating.a r1 = this.N;
        if (r1 == null) goto L10;
        r1.b();
        return;
    }

    public final void n() {
        com.obric.oui.titlebar.floating.a r0 = this.N;
        if (r0 == null) goto L7;
        r0.c();
        return;
    }

    public final void o() {
        if (this.K <= 0) goto L6;
        return;
    L6:
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L8;
        return;
    L8:
        if (this.M == true) goto L10;
        return;
    L10:
        if (isAttachedToWindow() == true) goto L12;
        return;
    L12:
        if (this.O == false) goto L22;
        com.obric.oui.titlebar.floating.a r1 = this.N;
        if (r1 == null) goto L23;
        r1.f();
        return;
    L23:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == true) goto L5;
    L13:
        this.ac.a();
        com.obric.oui.titlebar.floating.a r0 = this.N;
        if (r0 == null) goto L17;
        com.obric.oui.titlebar.floating.a.a(r0, false, 1, null);
    L17:
        com.obric.oui.titlebar.floating.a r1 = this.N;
        if (r1 == null) goto L21;
        r1.a("attached");
    L21:
        post(new $$Lambda$OFloatingTitleBar$yDc3vANX2yZ1IuG3OHKqa9_tlzU(this));
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(getParent(), com.obric.oui.material.b.class) == false) goto L8;
    L6:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        f(false);
        goto L13
    L8:
        if (ZeusTransformUtils.instanceOf(getParent().getParent(), com.obric.oui.material.b.class) == true) goto L6;
        r2 = false;
        goto L11
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r1);
        this.ad = com.obric.oui.c.h.a(r1.fontScale);
    L6:
        E();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.obric.oui.titlebar.floating.a r0 = this.N;
        if (r0 == null) goto L6;
        com.obric.oui.titlebar.floating.a.a(r0, false, false, 3, null);
    L6:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.x == (-1)) goto L6;
        com.obric.oui.material.i.a((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), Iterable.class, "com.obric.memorydata.plugin"), this.x);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        super.onLayout(r7, r8, r9, r10, r11);
        if (G() == true) goto L5;
        return;
    L5:
        int r12 = getMeasuredWidth();
        View r13 = this.q;
        FrameLayout r14 = null;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r13 = null;
    L8:
        int r15 = r13.getPaddingLeft();
        View r16 = this.q;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r16 = null;
    L11:
        int r17 = r16.getPaddingRight();
        int r0 = getCenterTitleGap();
        boolean r1 = i(H());
        int r2 = getEndAreaWidthForCenter();
        if (F() == false) goto L17;
        FrameLayout r3 = this.f;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r3 = null;
    L16:
        r15 = (r15 + r3.getMeasuredWidth()) + r0;
    L17:
        int r18 = r12 - r17;
        if (r1 == false) goto L20;
        r18 = (r18 - r2) - r0;
    L20:
        FrameLayout r4 = this.j;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r4 = null;
    L23:
        int r5 = r4.getMeasuredWidth();
        FrameLayout r6 = this.j;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r6 = null;
    L26:
        int r19 = r6.getMeasuredHeight();
        int r20 = (r12 - r5) / 2;
        int r21 = r20 + r5;
        int r22 = r18 - r15;
        if (r5 <= r22) goto L30;
        r20 = r15;
    L29:
        r21 = r18;
    L35:
        if (this.ae == false) goto L37;
        int r23 = (r22 - r5) / 2;
        r20 = r15 + r23;
        r21 = r18 - r23;
    L37:
        View r24 = this.q;
        if (r24 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r24 = null;
    L40:
        int r25 = r24.getPaddingTop();
        View r110 = this.q;
        if (r110 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r110 = null;
    L43:
        int r111 = r110.getMeasuredHeight();
        View r26 = this.q;
        if (r26 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r26 = null;
    L46:
        int r27 = r25 + ((((r111 - r26.getPaddingBottom()) - r25) - r19) / 2);
        int r28 = r19 + r27;
        FrameLayout r29 = this.j;
        if (r29 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L50:
        r14.layout(r20, r27, r21, r28);
        return;
    L49:
        r14 = r29;
        goto L50
    L30:
        if (r20 >= r15) goto L32;
        r21 = r15 + r5;
        r20 = r15;
        goto L35
    L32:
        if (r21 <= r18) goto L35;
        r20 = r18 - r5;
        goto L29
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r19, int r20) {
        this.ae = false;
        OTextView r2 = this.m;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r2 = null;
    L5:
        r2.setMaxWidth(Integer.MAX_VALUE);
        OTextView r3 = this.n;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r3 = null;
    L8:
        r3.setMaxWidth(Integer.MAX_VALUE);
        OTextView r4 = this.h;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r4 = null;
    L11:
        r4.setMaxWidth(Integer.MAX_VALUE);
        OTextView r5 = this.i;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r5 = null;
    L14:
        r5.setMaxWidth(Integer.MAX_VALUE);
        super.onMeasure(r19, r20);
        boolean r6 = F();
        boolean r7 = G();
        boolean r9 = i(H());
        int r10 = getEndAreaWidthForCenter();
        int r11 = getMeasuredWidth();
        View r12 = this.q;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r12 = null;
    L17:
        int r13 = r12.getPaddingLeft();
        View r14 = this.q;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r14 = null;
    L20:
        int r15 = r14.getPaddingRight();
        int r16 = getCenterTitleGap();
        if (r7 == false) goto L26;
        int r17 = r11 / 2;
        FrameLayout r8 = this.j;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r8 = null;
    L25:
        int r18 = (r17 - (r8.getMeasuredWidth() / 2)) - r16;
    L30:
        if (r6 == false) goto L35;
        int r110 = (r11 / 2) - r13;
        FrameLayout r1 = this.f;
        if (r1 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r1 = null;
    L34:
        int r21 = (r110 - r1.getMeasuredWidth()) - r16;
    L36:
        int r111 = (r11 / 2) - r15;
        if (r9 == false) goto L39;
        int r112 = (r111 - r10) - r16;
    L40:
        boolean r22 = true;
        if (r6 == false) goto L54;
        int r23 = Math.max(0, r18 - r13);
        FrameLayout r24 = this.f;
        if (r24 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
        r24 = null;
    L46:
        if (r24.getMeasuredWidth() <= r23) goto L54;
        OTextView r25 = this.h;
        if (r25 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r25 = null;
    L50:
        r25.setMaxWidth(r23);
        OTextView r26 = this.i;
        if (r26 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r26 = null;
    L53:
        r26.setMaxWidth(r23);
        boolean r27 = true;
    L55:
        if (r7 == false) goto L97;
        boolean r28 = false;
        int r29 = Math.max(0, Math.min(r21 * 2, r112 * 2));
        FrameLayout r30 = this.j;
        if (r30 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
        r30 = null;
    L60:
        if (r30.getMeasuredWidth() <= r29) goto L97;
        this.ae = true;
        int r31 = r21 + r112;
        OTextView r32 = this.m;
        if (r32 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r32 = null;
    L64:
        r32.setMaxWidth(r31);
        OTextView r33 = this.m;
        if (r33 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r33 = null;
    L68:
        if (r33.getMeasuredWidth() <= r29) goto L73;
        OTextView r34 = this.n;
        if (r34 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r34 = null;
    L72:
        r34.setMaxWidth(r31);
    L77:
        FrameLayout r35 = this.k;
        if (r35 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r35 = null;
    L81:
        if (((View) ZeusTransformUtils.preCheckCast(r35, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L83;
        r28 = true;
    L83:
        if (r28 == false) goto L98;
        FrameLayout r36 = this.k;
        if (r36 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r36 = null;
    L87:
        ViewGroup.LayoutParams r37 = r36.getLayoutParams();
        FrameLayout r38 = this.k;
        if (r38 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r38 = null;
    L91:
        if (r38.getMeasuredWidth() <= r31) goto L98;
        r37.width = r31;
        FrameLayout r39 = this.k;
        if (r39 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        FrameLayout r40 = null;
    L96:
        r40.setLayoutParams(r37);
        goto L98
    L95:
        r40 = r39;
    L98:
        if (r22 == false) goto L101;
        super.onMeasure(r19, r20);
        return;
    L101:
        return;
    L73:
        OTextView r41 = this.n;
        if (r41 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException(r6);
        r41 = null;
    L76:
        r41.setMaxWidth(r29);
    L97:
        r22 = r27;
    L54:
        r27 = false;
        goto L55
    L39:
        r112 = r111 - this.af;
        goto L40
    L35:
        r21 = ((r11 / 2) - r13) - this.af;
        goto L36
    L26:
        if (r9 == false) goto L28;
        r18 = ((r11 - r15) - r10) - r16;
        goto L30
    L28:
        r18 = r11 - r15;
        goto L30
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L9;
        com.obric.oui.titlebar.floating.a r0 = this.N;
        if (r0 == null) goto L10;
        r0.a("windowFocus");
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 != 0) goto L9;
        com.obric.oui.titlebar.floating.a r0 = this.N;
        if (r0 == null) goto L10;
        r0.a("windowVisible");
        return;
    L10:
        return;
    }

    public final void p() {
        a(this, true, false, 2, null);
    }

    public final void setActionChangeInterruptCallback$OUI_standardRelease(Function0<Unit> r3) {
        this.R = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r5) {
        this.v = r5;
        if (r5 != null) goto L6;
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        B();
        return;
    L6:
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r5);
        com.obric.oui.material.i.a((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndButtonGroup(), getEndSubButtonGroup()}), Iterable.class, "com.obric.memorydata.plugin"), r5);
    }

    public final void setCenterButtonGroup(OButtonGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setCenterButtonGroupStyle(int r5) {
        this.z = r5;
        a(getCenterButtonGroup(), r5, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void setCenterCustomView(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FrameLayout r0 = this.k;
        FrameLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r0 = null;
    L5:
        r0.removeAllViews();
        FrameLayout r2 = this.k;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
        r2 = null;
    L8:
        r2.addView(r4);
        FrameLayout r3 = this.k;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L12:
        r1.setVisibility(0);
        if (ZeusTransformUtils.instanceOf(r4, h.class) == false) goto L16;
        ((h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.memorydata.plugin")).setBackdropTarget(getDefaultTargetView());
        return;
    L16:
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final void setCenterSubTitle(int r2) {
        setCenterSubtitle(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2));
    }

    public final void setCenterSubTitleColor(int r1) {
        OTextView r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final void setCenterSubtitle(String r6) {
        OTextView r0 = this.n;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
        r0 = null;
    L5:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r7 = this.n;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L9:
        a((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin"));
        o();
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public final void setCenterTitle(int r2) {
        setCenterTitle(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2));
    }

    public final void setCenterTitle(String r6) {
        OTextView r0 = this.m;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r0 = null;
    L5:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r7 = this.m;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L9:
        a((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin"));
        o();
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public final void setCenterTitleColor(int r3) {
        OTextView r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
        r0 = null;
    L5:
        r0.setTextColor(r3);
        this.aa = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.W.invoke(Boolean.valueOf(I())), com.obric.oui.material.c.class, "com.obric.memorydata.plugin");
    }

    public final void setEndButtonGroup(OButtonGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setEndButtonGroupStyle(int r5) {
        this.B = r5;
        a(getEndButtonGroup(), r5, (Function1) ZeusTransformUtils.preCheckCast(new C12381(this), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void setEndSubButtonGroup(OButtonGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setFloatingTransitionDrawUpdateListener$OUI_standardRelease(Function0<Unit> r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        this.S = r6;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new OButtonGroup[]{getStartButtonGroup(), getCenterButtonGroup(), getEndSubButtonGroup(), getEndButtonGroup()}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((OButtonGroup) ZeusTransformUtils.preCheckCast(r4.next(), OButtonGroup.class, "com.obric.memorydata.plugin")).setAnimationUpdateListener$OUI_standardRelease(r6);
        goto L4
    }

    public final void setFloatingTransitionEnabled(boolean r4) {
        if (this.M != r4) goto L5;
        return;
    L5:
        this.M = r4;
        if (r4 == true) goto L8;
        com.obric.oui.titlebar.floating.a r5 = this.N;
        if (r5 == null) goto L29;
        com.obric.oui.titlebar.floating.a.a(r5, false, false, 3, null);
    L29:
        this.N = null;
        return;
    L8:
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L11;
        return;
    L11:
        if (this.N != null) goto L17;
        com.obric.oui.titlebar.floating.a r6 = new com.obric.oui.titlebar.floating.a(this);
        this.N = r6;
        if (r6 == null) goto L17;
        r6.a(this.Q);
    L17:
        if (isAttachedToWindow() == true) goto L19;
        return;
    L19:
        if (this.O == false) goto L32;
        com.obric.oui.titlebar.floating.a r7 = this.N;
        if (r7 == null) goto L24;
        com.obric.oui.titlebar.floating.a.a(r7, false, 1, null);
    L24:
        post(new $$Lambda$OFloatingTitleBar$q57whpxKAZsthHRtqKA5zn5VOTI(this));
        return;
    }

    public final void setFloatingTransitionEndListener(com.obric.oui.titlebar.floating.a.c r3) {
        com.obric.oui.titlebar.floating.a.c r4 = (com.obric.oui.titlebar.floating.a.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.titlebar.floating.a.c.class, "com.obric.memorydata.plugin");
        this.Q = r4;
        com.obric.oui.titlebar.floating.a r2 = this.N;
        if (r2 == null) goto L7;
        r2.a(r4);
        return;
    }

    public final void setFloatingTransitionOwnerActive$OUI_standardRelease(boolean r2) {
        if (this.O != r2) goto L5;
        return;
    L5:
        this.O = r2;
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L9;
        return;
    L9:
        if (this.M == true) goto L11;
        return;
    L11:
        if (isAttachedToWindow() == false) goto L26;
        if (r2 == false) goto L19;
        com.obric.oui.titlebar.floating.a r3 = this.N;
        if (r3 == null) goto L18;
        r3.a(true);
    L18:
        post(new $$Lambda$OFloatingTitleBar$irB2KrFCfo9zbdjLAlQv51Soqrk(this));
        return;
    L19:
        com.obric.oui.titlebar.floating.a r1 = this.N;
        if (r1 == null) goto L27;
        r1.a(false, false);
        return;
    L27:
        return;
    }

    public final void setKeepActionInteractiveWhenHidden$OUI_standardRelease(boolean r1) {
        this.I = r1;
    }

    @Deprecated(message = "not support set mask background")
    public final void setMaskBackground(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        f(true);
    }

    public final void setMaskBlurRadius(float r6) {
        com.obric.oui.material.c r0 = this.aa;
        com.obric.oui.material.c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
        r0 = null;
    L5:
        com.obric.oui.blur.a r2 = r0.g();
        if (r2 == null) goto L9;
        r2.a(r6);
    L9:
        com.obric.oui.window.b.a r3 = this.ac;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        com.obric.oui.material.c r5 = this.aa;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L13:
        r3.a(r4, r1, this.x);
        if (r6 != 0.0f) goto L16;
        boolean r7 = true;
    L17:
        f(!r7);
        return;
    L16:
        r7 = false;
        goto L17
    L12:
        r1 = r5;
        goto L13
    }

    public final void setNonActionContentVisible$OUI_standardRelease(boolean r2) {
        if (this.f14736J != r2) goto L5;
        return;
    L5:
        this.f14736J = r2;
        x();
    }

    public final void setStartButtonGroup(OButtonGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f14737b = r2;
    }

    public final void setStartButtonGroupStyle(int r5) {
        this.y = r5;
        a(getStartButtonGroup(), r5, (Function1) ZeusTransformUtils.preCheckCast(new C12391(this), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void setStartSubTitleColor(int r1) {
        OTextView r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r0 = null;
    L5:
        r0.setTextColor(r1);
    }

    public final void setStartSubtitle(int r2) {
        setStartSubtitle(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2));
    }

    public final void setStartSubtitle(String r6) {
        OTextView r0 = this.i;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
        r0 = null;
    L5:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r7 = this.i;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L9:
        a((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin"));
        o();
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public final void setStartTitle(int r2) {
        setStartTitle(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(r2));
    }

    public final void setStartTitle(String r6) {
        OTextView r0 = this.h;
        OTextView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r0 = null;
    L5:
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r7 = this.h;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L9:
        a((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin"));
        o();
        return;
    L8:
        r1 = r7;
        goto L9
    }

    public final void setStartTitleColor(int r3) {
        OTextView r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
        r0 = null;
    L5:
        r0.setTextColor(r3);
        this.aa = (com.obric.oui.material.c) ZeusTransformUtils.preCheckCast(this.W.invoke(Boolean.valueOf(I())), com.obric.oui.material.c.class, "com.obric.memorydata.plugin");
    }

    public final void setSubEndButtonGroupStyle(int r5) {
        this.A = r5;
        a(getEndSubButtonGroup(), r5, (Function1) ZeusTransformUtils.preCheckCast(new C12401(this), Function1.class, "com.obric.memorydata.plugin"));
    }

    public final void setTitleBarContainerClickable$OUI_standardRelease(boolean r1) {
        View r0 = this.q;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r0 = null;
    L5:
        r0.setClickable(r1);
    }

    public final void setTitleBarTransitionEndListener(d r3) {
        this.P = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public final void setTitleType(int r9) {
        this.ab = r9;
        com.obric.oui.window.b.a r0 = this.ac;
        if (r9 != 2) goto L5;
        boolean r3 = true;
    L6:
        r0.a(r3);
        View r6 = null;
        com.obric.oui.material.c r7 = null;
        View r8 = null;
        if (r9 == 0) goto L33;
        if (r9 == 1) goto L25;
        if (r9 != 2) goto L44;
        View r10 = this.q;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r10 = null;
    L14:
        r10.setMinimumHeight(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 56));
        View r11 = this.q;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r11 = null;
    L17:
        r11.setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8));
        com.obric.oui.material.c r12 = this.aa;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L21:
        com.obric.oui.blur.a r13 = r7.g();
        if (r13 == null) goto L45;
        setMaskBlurRadius(r13.a());
        return;
    L45:
        return;
    L20:
        r7 = r12;
        goto L21
    L44:
        return;
    L25:
        View r14 = this.q;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r14 = null;
    L28:
        r14.setMinimumHeight(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 64));
        View r15 = this.q;
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L32:
        r8.setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8));
        return;
    L31:
        r8 = r15;
        goto L32
    L33:
        View r16 = this.q;
        if (r16 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
        r16 = null;
    L36:
        r16.setMinimumHeight(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 56));
        View r17 = this.q;
        if (r17 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L40:
        r6.setPadding(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8));
        return;
    L39:
        r6 = r17;
        goto L40
    L5:
        r3 = false;
        goto L6
    }
}
