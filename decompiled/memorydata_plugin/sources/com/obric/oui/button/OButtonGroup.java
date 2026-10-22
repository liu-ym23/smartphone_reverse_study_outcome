package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.style.k;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 Ô\u00012\u00020\u0001:\fÒ\u0001Ó\u0001Ô\u0001Õ\u0001Ö\u0001×\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ \u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u0015H\u0002J\u001b\u0010.\u001a\u00020\r2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0000¢\u0006\u0002\b0J\u001b\u00101\u001a\u00020\r2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0000¢\u0006\u0002\b2J\u0016\u00103\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0007J\u0016\u00103\u001a\u00020\r2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u000207J\u001e\u00103\u001a\u00020\r2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007J&\u00103\u001a\u00020\r2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020&J \u0010:\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0#2\b\b\u0002\u0010<\u001a\u00020&H\u0002J\u0016\u0010=\u001a\u00020\r2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\"\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020&2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J*\u0010B\u001a\u00020\r2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010D\u001a\u00020&2\b\b\u0002\u0010E\u001a\u00020&H\u0002J(\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020&2\u0006\u00109\u001a\u00020&2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\b\u0010H\u001a\u00020\u0015H\u0002J\b\u0010I\u001a\u00020\rH\u0002J\u0016\u0010J\u001a\u00020\r2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J \u0010L\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u00152\u0006\u0010N\u001a\u00020\u00152\u0006\u0010O\u001a\u00020\u0015H\u0002J\u0010\u0010P\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0015H\u0014J\u0010\u0010Q\u001a\u00020\r2\u0006\u0010R\u001a\u00020(H\u0002J8\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0T2\u0006\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0TH\u0002J\u0006\u0010V\u001a\u00020\rJ\u0012\u0010W\u001a\u00020\r2\b\b\u0002\u0010X\u001a\u00020&H\u0002J\b\u0010Y\u001a\u00020\rH\u0002J\b\u0010Z\u001a\u00020\rH\u0002J\b\u0010[\u001a\u00020\rH\u0002J\b\u0010\\\u001a\u00020\u0015H\u0002J\b\u0010]\u001a\u00020\rH\u0002J\u0010\u0010^\u001a\u00020\u00152\u0006\u0010_\u001a\u00020(H\u0002J\r\u0010`\u001a\u00020\rH\u0000¢\u0006\u0002\baJ\u0010\u0010b\u001a\u00020&2\u0006\u0010R\u001a\u00020(H\u0002J\u000e\u0010c\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\b\u0010d\u001a\u00020\u0015H\u0002J\b\u0010e\u001a\u00020\rH\u0002J\b\u0010f\u001a\u00020\rH\u0002J\u0010\u0010g\u001a\u00020&2\u0006\u0010h\u001a\u00020iH\u0016J&\u0010j\u001a\u00020\r2\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u00072\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\u0010\u0010m\u001a\u00020\r2\u0006\u0010R\u001a\u00020(H\u0002J\b\u0010n\u001a\u00020\rH\u0002J&\u0010o\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0#2\u0006\u0010p\u001a\u00020&2\u0006\u0010q\u001a\u00020&H\u0002J\u0010\u0010r\u001a\u00020\r2\u0006\u0010s\u001a\u00020\u0007H\u0002J\b\u0010t\u001a\u00020\u0015H\u0014J\u0006\u0010u\u001a\u00020\u0007J\u0010\u0010v\u001a\u0004\u0018\u00010(2\u0006\u00108\u001a\u00020\u0007J\r\u0010w\u001a\u00020\u0015H\u0000¢\u0006\u0002\bxJ\u0010\u0010y\u001a\u00020\u00152\u0006\u0010R\u001a\u00020(H\u0002J$\u0010z\u001a\u00020\r2\b\b\u0002\u00109\u001a\u00020&2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007J,\u0010{\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010|\u001a\u00020}2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010~\u001a\u0004\u0018\u00010\u007fH\u0016J\u0007\u0010\u0080\u0001\u001a\u00020&J\u0011\u0010\u0081\u0001\u001a\u00020&2\u0006\u0010_\u001a\u00020(H\u0002J\t\u0010\u0082\u0001\u001a\u00020&H\u0002J\t\u0010\u0083\u0001\u001a\u00020&H\u0002J\u000f\u0010\u0084\u0001\u001a\u00020&H\u0000¢\u0006\u0003\b\u0085\u0001J \u0010\u0086\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#2\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\t\u0010\u0088\u0001\u001a\u00020\rH\u0002J\u0018\u0010\u0089\u0001\u001a\u00020\u00072\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\u0016\u0010\u008a\u0001\u001a\u00020\u00072\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020(0#J\u0018\u0010\u008b\u0001\u001a\u00020\u00072\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\t\u0010\u008c\u0001\u001a\u00020&H\u0002J\t\u0010\u008d\u0001\u001a\u00020&H\u0002J\u0018\u0010\u008e\u0001\u001a\u00020\r2\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\u0007\u0010\u0090\u0001\u001a\u00020\rJ\u000f\u0010\u0090\u0001\u001a\u00020\r2\u0006\u00109\u001a\u00020&J\u0007\u0010\u0091\u0001\u001a\u00020\rJ\u000f\u0010\u0091\u0001\u001a\u00020\r2\u0006\u00109\u001a\u00020&J\u000f\u0010\u0092\u0001\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0007J\u0017\u0010\u0092\u0001\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020&J\u0018\u0010\u0093\u0001\u001a\u00020\r2\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\u0017\u0010\u0094\u0001\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\u0011\u0010\u0095\u0001\u001a\u00020\r2\u0006\u0010_\u001a\u00020(H\u0002J\t\u0010\u0096\u0001\u001a\u00020\rH\u0002J\t\u0010\u0097\u0001\u001a\u00020\rH\u0002J)\u0010\u0098\u0001\u001a\u00020\r2\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0016\u0010\u009b\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0006\u0012\u0004\u0018\u00010(0TJ\t\u0010\u009d\u0001\u001a\u00020\rH\u0002J\u0013\u0010\u009e\u0001\u001a\u00020\r2\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020\rH\u0002J\b\u0010 \u0001\u001a\u00030\u009a\u0001J\u001f\u0010¡\u0001\u001a\u00020\r2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0000¢\u0006\u0003\b¢\u0001J\u0012\u0010£\u0001\u001a\u00020\r2\u0007\u0010¤\u0001\u001a\u00020&H\u0016J\u0011\u0010¥\u0001\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u0015H\u0002J\u001f\u0010¦\u0001\u001a\u00020\r2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0000¢\u0006\u0003\b§\u0001J\u0012\u0010¨\u0001\u001a\u00020\r2\u0007\u0010©\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010ª\u0001\u001a\u00020\r2\u0007\u0010©\u0001\u001a\u00020\u0015H\u0002J\u0011\u0010«\u0001\u001a\u00020\r2\u0006\u0010N\u001a\u00020\u0015H\u0002J\u0018\u0010¬\u0001\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00072\u0007\u0010¤\u0001\u001a\u00020&J\u0018\u0010\u00ad\u0001\u001a\u00020\r2\u0007\u0010®\u0001\u001a\u00020&H\u0000¢\u0006\u0003\b¯\u0001J\u0011\u0010°\u0001\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0018\u0010±\u0001\u001a\u00020\r2\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\u0012\u0010²\u0001\u001a\u00020&2\u0007\u0010³\u0001\u001a\u00020&H\u0014J$\u0010G\u001a\u00020\r2\b\b\u0002\u00109\u001a\u00020&2\u0010\b\u0002\u0010A\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007J3\u0010´\u0001\u001a\u00020\r2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u001a\u0010µ\u0001\u001a\u0015\u0012\u0005\u0012\u00030¶\u0001\u0012\u0004\u0012\u00020\r0T¢\u0006\u0003\b·\u0001H\u0002JF\u0010¸\u0001\u001a\u00020\r2\u0006\u0010_\u001a\u00020(2\u0006\u0010-\u001a\u00020\u00152\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150º\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\f2\r\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0002JG\u0010¼\u0001\u001a\u00020\r2\u0006\u0010_\u001a\u00020(2\u0007\u0010½\u0001\u001a\u00020\u00152\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150º\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\f2\r\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0002J\u0012\u0010¾\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020\u0011H\u0002J%\u0010¿\u0001\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0#2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002JV\u0010À\u0001\u001a\u00020\u00132\u0007\u0010Á\u0001\u001a\u00020\u00152\u0007\u0010Â\u0001\u001a\u00020\u00152\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150º\u00012\u0007\u0010Ã\u0001\u001a\u00020\u00152\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0T2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J@\u0010Ä\u0001\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00152\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150º\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000f\b\u0002\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0002JA\u0010Å\u0001\u001a\u00020\r2\u0007\u0010Æ\u0001\u001a\u00020\u00152\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150º\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000f\b\u0002\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0002JA\u0010Ç\u0001\u001a\u00020\r2\u0007\u0010½\u0001\u001a\u00020\u00152\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150º\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000f\b\u0002\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0002J>\u0010È\u0001\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00152\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150º\u00012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\f2\r\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0002J)\u0010É\u0001\u001a\u00020\r2\u0007\u0010Ê\u0001\u001a\u00020\u00072\u0007\u0010Ë\u0001\u001a\u00020\u00072\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0017\u0010Ì\u0001\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\u0017\u0010Í\u0001\u001a\u00020\r2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020(0#H\u0002J\t\u0010Î\u0001\u001a\u00020\rH\u0002J\t\u0010Ï\u0001\u001a\u00020\rH\u0002J\"\u0010Ð\u0001\u001a\u00020\r2\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020(0#2\b\b\u0002\u00109\u001a\u00020&H\u0007J\t\u0010Ñ\u0001\u001a\u00020\rH\u0002R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010$\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ø\u0001"}, d2 = {"Lcom/obric/oui/button/OButtonGroup;", "Lcom/obric/oui/button/OShadowFrame;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "animationEndListeners", "", "Lkotlin/Function0;", "", "animationUpdateListener", "capacity", "contentAnimationState", "Lcom/obric/oui/button/OButtonGroup$ContentAnimationState;", "contentAnimators", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "currentGroupBlur", "", "groupAlphaAnimationEndListeners", "groupAlphaAnimationUpdateListener", "groupAnimationState", "Lcom/obric/oui/button/OButtonGroup$GroupAnimationState;", "groupAnimators", "groupScaleForAnimation", "itemContainer", "Landroid/widget/LinearLayout;", "itemMargin", "minWidth", "pressScaleForAnimation", "rawGroupAlpha", "runningTargetItemKeys", "", "", "singleItemSuppressPressEffectApplied", "", "singleItemView", "Landroid/view/View;", "touchEventBlocked", "accelerateBoundedAlpha", EventBody.KEY_VALUE, "startAlpha", "targetAlpha", "addAnimationEndListener", "listener", "addAnimationEndListener$OUI_standardRelease", "addGroupAlphaAnimationEndListener", "addGroupAlphaAnimationEndListener$OUI_standardRelease", "addItemView", "layoutRes", "itemView", "layoutParams", "Landroid/view/ViewGroup$MarginLayoutParams;", "index", "animate", "animateContentChange", "newViews", "includeGroupAppear", "animateContentSettle", "currentViews", "animateGroupAppear", "resetToAppearStart", "onFinished", "animateGroupDisappear", "onGone", "resetOnGone", "animateChildren", "animateGroupVisible", "show", "appearBlurRadius", "applyCombinedGroupScale", "applyCurrentItemEnabledStates", "targetViews", "applyGroupVisualState", "alpha", "scale", "blur", "applyPressScaleForAnimation", "applySingleItemPressEffectSuppression", "view", "boundedAlphaUpdater", "Lkotlin/Function1;", "onUpdate", "cancelAnimation", "cancelAnimationInternal", "clearRunningTarget", "cancelContentAnimationInternal", "cancelGroupAnimationInternal", "cancelPressAnimationForGroupTransition", "changeBlurRadius", "checkVisibility", "childTargetAlpha", "child", "clearGroupAlphaAnimationEndListeners", "clearGroupAlphaAnimationEndListeners$OUI_standardRelease", "containsTextView", "currentItemViews", "disappearBlurRadius", "dispatchAnimationEndIfIdle", "dispatchGroupAlphaAnimationEnd", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "dispatchTransition", "oldCount", "newCount", "ensureItemMinimumWidth", "finishContentAnimation", "finishContentChangeIfReady", "widthFinished", "inFinished", "freezeGroupWidth", "width", "getCurrentPressScaleForAnimation", "getItemCount", "getItemViewAt", "getRawGroupAlphaForTitleBarTransition", "getRawGroupAlphaForTitleBarTransition$OUI_standardRelease", "hiddenContentScale", "hide", "initContent", "contentView", "Landroid/widget/FrameLayout;", "typedArray", "Landroid/content/res/TypedArray;", "isAnimating", "isChildAlphaSettled", "isCurrentTargetVisuallySettled", "isSingleItemPressEnabled", "isTouchEventBlocked", "isTouchEventBlocked$OUI_standardRelease", "itemKeys", "views", "markCurrentTargetReached", "measureTargetContentWidth", "measureTargetItemViewsWidth", "measureTargetWidth", "needsContentVisibleRecovery", "needsGroupVisibleRecovery", "prepareChildrenForAppear", "children", "removeAllItemViews", "removeItemView", "removeItemViewAt", "replaceItems", "replaceItemsForFadeIn", "resetChildAlpha", "resetChildrenVisualState", "resetVisualState", "restoreAnimationState", "state", "Lcom/obric/oui/button/OButtonGroup$AnimationState;", "itemFactory", "Lcom/obric/oui/button/OButtonGroup$ItemAnimationState;", "restoreSingleItemViewState", "restoreVisualStateOnly", "resumeCurrentTargetAnimation", "saveAnimationState", "setAnimationUpdateListener", "setAnimationUpdateListener$OUI_standardRelease", "setEnabled", "enabled", "setGroupAlpha", "setGroupAlphaAnimationUpdateListener", "setGroupAlphaAnimationUpdateListener$OUI_standardRelease", "setGroupBlur", "radius", "setGroupBlurForAnimation", "setGroupScaleForAnimation", "setItemEnabled", "setTouchEventBlocked", "blocked", "setTouchEventBlocked$OUI_standardRelease", "setWidthMin", "settleChildrenVisualState", "shouldHandlePressAnimation", "pressed", "startAnimationBatch", "block", "Lcom/obric/oui/button/OButtonGroup$AnimationBatch;", "Lkotlin/ExtensionFunctionType;", "startChildAlphaAnimation", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "targetList", "startChildScaleAnimation", "targetScale", "startContentAnimation", "startContentFadeInPhase", "startFloatAnimation", "initialValue", "targetValue", LocationMonitorConst.ACCURACY, "startGroupAlphaAnimation", "startGroupBlurAnimation", "targetBlur", "startGroupScaleAnimation", "startGroupShadowAnimation", "startWidthChangeAnimation", "startWidth", "targetWidth", "transitionBetweenNonEmpty", "transitionFromEmpty", "transitionToEmpty", "updateGroupEnabledByItems", "updateItemViews", "updateSingleItemDelegateMode", "AnimationBatch", "AnimationState", "Companion", "ContentAnimationState", "GroupAnimationState", "ItemAnimationState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OButtonGroup extends OShadowFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13379a = null;
    private LinearLayout e;
    private int f;
    private int g;
    private int h;
    private View i;
    private boolean j;
    private final List<com.obric.common.oea.foundation.animation.d.d> k;
    private final List<com.obric.common.oea.foundation.animation.d.d> l;
    private ContentAnimationState m;
    private float n;
    private List<? extends Object> o;
    private Function0<Unit> p;
    private Function0<Unit> q;
    private final List<Function0<Unit>> r;
    private final List<Function0<Unit>> s;
    private float t;
    private float u;
    private float v;
    private boolean w;
    private GroupAnimationState x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$ContentAnimationState;", "", "(Ljava/lang/String;I)V", "IDLE", "OUT", "IN", "SETTLING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum ContentAnimationState extends Enum<ContentAnimationState> {
        private static final /* synthetic */ ContentAnimationState[] $VALUES = null;
        public static final ContentAnimationState IDLE = null;
        public static final ContentAnimationState IN = null;
        public static final ContentAnimationState OUT = null;
        public static final ContentAnimationState SETTLING = null;

        private static final /* synthetic */ ContentAnimationState[] $values() {
            return new ContentAnimationState[]{IDLE, OUT, IN, SETTLING};
        }

        static {
            IDLE = new ContentAnimationState("IDLE", 0);
            OUT = new ContentAnimationState("OUT", 1);
            IN = new ContentAnimationState("IN", 2);
            SETTLING = new ContentAnimationState("SETTLING", 3);
            $VALUES = $values();
        }

        private ContentAnimationState(String r1, int r2) {
            super(r1, r2);
        }

        public static ContentAnimationState valueOf(String r2) {
            return (ContentAnimationState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ContentAnimationState.class, r2), ContentAnimationState.class, "com.obric.memorydata.plugin");
        }

        public static ContentAnimationState[] values() {
            return (ContentAnimationState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ContentAnimationState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$GroupAnimationState;", "", "(Ljava/lang/String;I)V", "IDLE", "APPEARING", "DISAPPEARING", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final enum GroupAnimationState extends Enum<GroupAnimationState> {
        private static final /* synthetic */ GroupAnimationState[] $VALUES = null;
        public static final GroupAnimationState APPEARING = null;
        public static final GroupAnimationState DISAPPEARING = null;
        public static final GroupAnimationState IDLE = null;

        private static final /* synthetic */ GroupAnimationState[] $values() {
            return new GroupAnimationState[]{IDLE, APPEARING, DISAPPEARING};
        }

        static {
            IDLE = new GroupAnimationState("IDLE", 0);
            APPEARING = new GroupAnimationState("APPEARING", 1);
            DISAPPEARING = new GroupAnimationState("DISAPPEARING", 2);
            $VALUES = $values();
        }

        private GroupAnimationState(String r1, int r2) {
            super(r1, r2);
        }

        public static GroupAnimationState valueOf(String r2) {
            return (GroupAnimationState) ZeusTransformUtils.preCheckCast(Enum.valueOf(GroupAnimationState.class, r2), GroupAnimationState.class, "com.obric.memorydata.plugin");
        }

        public static GroupAnimationState[] values() {
            return (GroupAnimationState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GroupAnimationState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u000e\u001a\u00020\u00042\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\rJ\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$AnimationBatch;", "", "onFinished", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "finished", "", "remaining", "", "started", "starters", "", "Lkotlin/Function1;", "add", "starter", "done", "finish", CommonConsts.APM_INNER_EVENT_COST_START, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function0<Unit> f13380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Function1<Function0<Unit>, Unit>> f13381b;
        private int c;
        private boolean d;
        private boolean e;

        public a(Function0<Unit> r3) {
            Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "onFinished");
            this.f13380a = r4;
            this.f13381b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ void a(a r0) {
            r0.b();
        }

        private final void b() {
            if (this.d == true) goto L5;
            return;
        L5:
            if (this.e == true) goto L13;
            int r0 = this.c - 1;
            this.c = r0;
            if (r0 != 0) goto L12;
            c();
            return;
        L12:
            return;
        }

        private final void c() {
            if (this.e == false) goto L5;
            return;
        L5:
            this.e = true;
            this.f13380a.invoke();
        }

        public final void a() {
            if (this.f13381b.isEmpty() == false) goto L6;
            c();
            return;
        L6:
            this.c = this.f13381b.size();
            this.d = true;
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f13381b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            ((Function1) ZeusTransformUtils.preCheckCast(r0.next(), Function1.class, "com.obric.memorydata.plugin")).invoke(new OButtonGroup$AnimationBatch$start$1$1(this));
            goto L8
        }

        public final void a(Function1<? super Function0<Unit>, Unit> r3) {
            Function1<Function0<Unit>, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "starter");
            this.f13381b.add(r4);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JU\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006&"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$AnimationState;", "", "visibility", "", "alpha", "", "scaleX", "scaleY", "groupBlur", "groupWidth", "items", "", "Lcom/obric/oui/button/OButtonGroup$ItemAnimationState;", "(IFFFFILjava/util/List;)V", "getAlpha", "()F", "getGroupBlur", "getGroupWidth", "()I", "getItems", "()Ljava/util/List;", "getScaleX", "getScaleY", "getVisibility", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f13383b;
        private final float c;
        private final float d;
        private final float e;
        private final int f;
        private final List<d> g;

        public b(int r3, float r4, float r5, float r6, float r7, int r8, List<d> r9) {
            List<d> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "items");
            this.f13382a = r3;
            this.f13383b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r10;
        }

        public static /* synthetic */ b a(b r9, int r10, float r11, float r12, float r13, float r14, int r15, List r16, int r17, Object r18) {
            List<d> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
            if ((r17 & 1) == 0) goto L5;
            int r2 = r9.f13382a;
        L7:
            if ((r17 & 2) == 0) goto L9;
            float r3 = r9.f13383b;
        L11:
            if ((r17 & 4) == 0) goto L13;
            float r4 = r9.c;
        L15:
            if ((r17 & 8) == 0) goto L17;
            float r5 = r9.d;
        L19:
            if ((r17 & 16) == 0) goto L21;
            float r6 = r9.e;
        L23:
            if ((r17 & 32) == 0) goto L25;
            int r7 = r9.f;
        L27:
            if ((r17 & 64) == 0) goto L30;
            r1 = r9.g;
        L30:
            return r9.a(r2, r3, r4, r5, r6, r7, r1);
        L25:
            r7 = r15;
            goto L27
        L21:
            r6 = r14;
            goto L23
        L17:
            r5 = r13;
            goto L19
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r11;
            goto L11
        L5:
            r2 = r10;
            goto L7
        }

        public final int a() {
            return this.f13382a;
        }

        public final b a(int r9, float r10, float r11, float r12, float r13, int r14, List<d> r15) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "items");
            return new b(r9, r10, r11, r12, r13, r14, r7);
        }

        public final float b() {
            return this.f13383b;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public final float e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (this.f13382a == r6.f13382a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f13383b), Float.valueOf(r6.f13383b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r6.d)) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int f() {
            return this.f;
        }

        public final List<d> g() {
            return this.g;
        }

        public int hashCode() {
            return (((((((((((Integer.hashCode(this.f13382a) * 31) + Float.hashCode(this.f13383b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + this.g.hashCode();
        }

        public String toString() {
            return "AnimationState(visibility=" + this.f13382a + ", alpha=" + this.f13383b + ", scaleX=" + this.c + ", scaleY=" + this.d + ", groupBlur=" + this.e + ", groupWidth=" + this.f + ", items=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$Companion;", "", "()V", "ALPHA_ACCELERATION_FACTOR", "", "DEFAULT_CAPACITY", "", "TAG", "", "AnimationTuning", "SpringTokenConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c {

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\bV\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010`\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010a\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010b\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010c\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010d\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010e\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u0004J\u000e\u0010f\u001a\u00020\u000e2\u0006\u0010g\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0011\u0010\u001f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u0011\u0010!\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0010R\u0011\u0010#\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0010R\u001a\u0010%\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u0011\u0010(\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0010R\u0011\u0010*\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0010R\u0011\u0010,\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0010R\u0011\u0010.\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0010R\u0011\u00100\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0010R\u0011\u00102\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0010R\u001a\u00104\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R\u0011\u00107\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0010R\u0011\u00109\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0010R\u0011\u0010;\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0010R\u0011\u0010=\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0010R\u0011\u0010?\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0010R\u0011\u0010A\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0010R\u0011\u0010C\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0010R\u0011\u0010E\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0010R\u001a\u0010G\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R\u001a\u0010J\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010\u0016R\u001a\u0010M\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0014\"\u0004\bO\u0010\u0016R\u001a\u0010P\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0014\"\u0004\bR\u0010\u0016R\u001a\u0010S\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0014\"\u0004\bU\u0010\u0016R\u0011\u0010V\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0010R\u0011\u0010X\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0010R\u0011\u0010Z\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0010R\u0011\u0010\\\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0010¨\u0006h"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$Companion$AnimationTuning;", "", "()V", "WIDTH_THRESHOLD_PX", "", "appearBlurRadiusFigma", "getAppearBlurRadiusFigma", "()I", "setAppearBlurRadiusFigma", "(I)V", "changeBlurRadiusFigma", "getChangeBlurRadiusFigma", "setChangeBlurRadiusFigma", "childAppearAlpha", "Lcom/obric/oui/button/OButtonGroup$Companion$SpringTokenConfig;", "getChildAppearAlpha", "()Lcom/obric/oui/button/OButtonGroup$Companion$SpringTokenConfig;", "childAppearDisappearHiddenScale", "", "getChildAppearDisappearHiddenScale", "()F", "setChildAppearDisappearHiddenScale", "(F)V", "childAppearScale", "getChildAppearScale", "childChangeInAlpha", "getChildChangeInAlpha", "childChangeInScale", "getChildChangeInScale", "childChangeOutAlpha", "getChildChangeOutAlpha", "childChangeOutScale", "getChildChangeOutScale", "childDisappearAlpha", "getChildDisappearAlpha", "childDisappearScale", "getChildDisappearScale", "disappearBlurRadiusFigma", "getDisappearBlurRadiusFigma", "setDisappearBlurRadiusFigma", "groupAppearAlphaLong", "getGroupAppearAlphaLong", "groupAppearAlphaShort", "getGroupAppearAlphaShort", "groupAppearBlurLong", "getGroupAppearBlurLong", "groupAppearBlurShort", "getGroupAppearBlurShort", "groupAppearScaleLong", "getGroupAppearScaleLong", "groupAppearScaleShort", "getGroupAppearScaleShort", "groupAppearScaleTarget", "getGroupAppearScaleTarget", "setGroupAppearScaleTarget", "groupChangeInBlur", "getGroupChangeInBlur", "groupChangeOutBlur", "getGroupChangeOutBlur", "groupDisappearAlphaLong", "getGroupDisappearAlphaLong", "groupDisappearAlphaShort", "getGroupDisappearAlphaShort", "groupDisappearBlurLong", "getGroupDisappearBlurLong", "groupDisappearBlurShort", "getGroupDisappearBlurShort", "groupDisappearScaleLong", "getGroupDisappearScaleLong", "groupDisappearScaleShort", "getGroupDisappearScaleShort", "groupDisappearScaleTargetLong", "getGroupDisappearScaleTargetLong", "setGroupDisappearScaleTargetLong", "groupDisappearScaleTargetShort", "getGroupDisappearScaleTargetShort", "setGroupDisappearScaleTargetShort", "groupExpandedScale", "getGroupExpandedScale", "setGroupExpandedScale", "iconChangeHiddenScale", "getIconChangeHiddenScale", "setIconChangeHiddenScale", "textChangeHiddenScale", "getTextChangeHiddenScale", "setTextChangeHiddenScale", "widthChangeLong", "getWidthChangeLong", "widthChangeShort", "getWidthChangeShort", "widthExpandScale", "getWidthExpandScale", "widthSettleScale", "getWidthSettleScale", "groupAppearAlphaFor", "startWidth", "groupAppearBlurFor", "groupAppearScaleFor", "groupDisappearAlphaFor", "groupDisappearBlurFor", "groupDisappearScaleFor", "groupDisappearScaleTargetFor", "widthChangeFor", "targetWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            private static final b A = null;
            private static final b B = null;
            private static final b C = null;
            private static final b D = null;
            private static final b E = null;
            private static final b F = null;
            private static final b G = null;
            private static final b H = null;
            private static final b I = null;

            /* JADX INFO: renamed from: J, reason: collision with root package name */
            private static final b f13384J = null;
            private static final b K = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f13385a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static float f13386b;
            private static int c;
            private static float d;
            private static float e;
            private static float f;
            private static int g;
            private static float h;
            private static float i;
            private static float j;
            private static int k;
            private static final b l = null;
            private static final b m = null;
            private static final b n = null;
            private static final b o = null;
            private static final b p = null;
            private static final b q = null;
            private static final b r = null;
            private static final b s = null;
            private static final b t = null;
            private static final b u = null;
            private static final b v = null;
            private static final b w = null;
            private static final b x = null;
            private static final b y = null;
            private static final b z = null;

            static {
                f13385a = new a();
                f13386b = 1.1f;
                c = 7;
                d = 1.04f;
                e = 1.03f;
                f = 1.5f;
                g = 7;
                h = 1.05f;
                i = 1.5f;
                j = 1.2f;
                k = 7;
                l = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                m = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
                n = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_1, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                o = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_1, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
                p = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                q = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
                r = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1);
                s = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_2);
                t = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                u = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
                v = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_1, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                w = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_1, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
                x = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                y = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
                z = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                A = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                B = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_2);
                C = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                D = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_2, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4);
                E = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_2, Token.Duration.OUI_ANIMATION_DURATION_LONG_1);
                F = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_2);
                G = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_2);
                H = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_SHORT_2);
                I = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
                f13384J = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_BOUNCY_4, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1);
                K = new b(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2);
            }

            private a() {
            }

            public final float a() {
                return f13386b;
            }

            public final float a(int r1) {
                if (r1 >= 150) goto L6;
                return d;
            L6:
                return e;
            }

            public final int b() {
                return c;
            }

            public final b b(int r1) {
                if (r1 >= 150) goto L6;
                return l;
            L6:
                return m;
            }

            public final float c() {
                return f;
            }

            public final b c(int r1) {
                if (r1 >= 150) goto L6;
                return n;
            L6:
                return o;
            }

            public final int d() {
                return g;
            }

            public final b d(int r1) {
                if (r1 >= 150) goto L6;
                return p;
            L6:
                return q;
            }

            public final float e() {
                return h;
            }

            public final b e(int r1) {
                if (r1 >= 150) goto L6;
                return t;
            L6:
                return u;
            }

            public final float f() {
                return i;
            }

            public final b f(int r1) {
                if (r1 >= 150) goto L6;
                return v;
            L6:
                return w;
            }

            public final float g() {
                return j;
            }

            public final b g(int r1) {
                if (r1 >= 150) goto L6;
                return x;
            L6:
                return y;
            }

            public final int h() {
                return k;
            }

            public final b h(int r1) {
                if (r1 >= 150) goto L6;
                return D;
            L6:
                return E;
            }

            public final b i() {
                return r;
            }

            public final b j() {
                return s;
            }

            public final b k() {
                return z;
            }

            public final b l() {
                return A;
            }

            public final b m() {
                return B;
            }

            public final b n() {
                return C;
            }

            public final b o() {
                return F;
            }

            public final b p() {
                return G;
            }

            public final b q() {
                return H;
            }

            public final b r() {
                return I;
            }

            public final b s() {
                return f13384J;
            }

            public final b t() {
                return K;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$Companion$SpringTokenConfig;", "", "bounce", "Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "duration", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "(Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;Lcom/obric/common/oea/foundation/animation/token/Token$Duration;)V", "getBounce", "()Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "setBounce", "(Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;)V", "getDuration", "()Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "setDuration", "(Lcom/obric/common/oea/foundation/animation/token/Token$Duration;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Token.Bounce f13387a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Token.Duration f13388b;

            public b(Token.Bounce r2, Token.Duration r3) {
                Intrinsics.checkNotNullParameter(r2, "bounce");
                Intrinsics.checkNotNullParameter(r3, "duration");
                this.f13387a = r2;
                this.f13388b = r3;
            }

            public final com.obric.common.oea.foundation.animation.spec.a<Float> a() {
                return (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.preCheckCast(com.obric.common.oea.foundation.animation.spec.b.a(this.f13387a, this.f13388b, Token.Delay.OUI_ANIMATION_DELAY_NONE), com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
                if (this.f13387a == r6.f13387a) goto L12;
                return false;
            L12:
                if (this.f13388b == r6.f13388b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f13387a.hashCode() * 31) + this.f13388b.hashCode();
            }

            public String toString() {
                return "SpringTokenConfig(bounce=" + this.f13387a + ", duration=" + this.f13388b + ')';
            }
        }

        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/button/OButtonGroup$ItemAnimationState;", "", "key", "visibility", "", "alpha", "", "scaleX", "scaleY", "(Ljava/lang/Object;IFFF)V", "getAlpha", "()F", "getKey", "()Ljava/lang/Object;", "getScaleX", "getScaleY", "getVisibility", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f13389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13390b;
        private final float c;
        private final float d;
        private final float e;

        public d(Object r1, int r2, float r3, float r4, float r5) {
            this.f13389a = r1;
            this.f13390b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public static /* synthetic */ d a(d r3, Object r4, int r5, float r6, float r7, float r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.f13389a;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.f13390b;
        L8:
            int r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.c;
        L11:
            float r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.d;
        L14:
            float r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.e;
        L17:
            Object r12 = r4;
            return r3.a(r12, r11, r0, r1, r8);
        }

        public final d a(Object r7, int r8, float r9, float r10, float r11) {
            return new d(r7, r8, r9, r10, r11);
        }

        public final Object a() {
            return this.f13389a;
        }

        public final int b() {
            return this.f13390b;
        }

        public final float c() {
            return this.c;
        }

        public final float d() {
            return this.d;
        }

        public final float e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13389a, r6.f13389a) == true) goto L12;
            return false;
        L12:
            if (this.f13390b == r6.f13390b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.d), Float.valueOf(r6.d)) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            Object r0 = this.f13389a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((((r1 * 31) + Integer.hashCode(this.f13390b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Float.hashCode(this.e);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "ItemAnimationState(key=" + this.f13389a + ", visibility=" + this.f13390b + ", alpha=" + this.c + ", scaleX=" + this.d + ", scaleY=" + this.e + ')';
        }
    }

    static {
        f13379a = new c(null);
    }

    public OButtonGroup(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OButtonGroup(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OButtonGroup(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OButtonGroup(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r11, 0, 8, null);
        this.h = 5;
        this.k = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.l = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.m = ContentAnimationState.IDLE;
        this.r = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.s = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.t = 1.0f;
        this.u = 1.0f;
        this.v = 1.0f;
        this.x = GroupAnimationState.IDLE;
        setClipChildren(false);
        setClipToPadding(false);
        int[] r0 = R.styleable.OButtonGroup;
        Intrinsics.checkNotNullExpressionValue(r0, "OButtonGroup");
        TypedArray r15 = r13.obtainStyledAttributes(r14, r0, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r15, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.g = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OButtonGroup_oui_widgetMinWidth, "styleable", "OButtonGroup_oui_widgetMinWidth"), 0);
        this.f = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OButtonGroup_oui_widgetInnerItemMargin, "styleable", "OButtonGroup_oui_widgetInnerItemMargin"), 0);
        this.h = r15.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OButtonGroup_oui_OButtonGroupCapacity, "styleable", "OButtonGroup_oui_OButtonGroupCapacity"), 5);
        r15.recycle();
    }

    public /* synthetic */ OButtonGroup(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    private final void A() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.k, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.common.oea.foundation.animation.d.d.a((com.obric.common.oea.foundation.animation.d.d) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.common.oea.foundation.animation.d.d.class, "com.obric.memorydata.plugin"), false, 1, null);
        goto L4
    L6:
        this.k.clear();
        this.x = GroupAnimationState.IDLE;
    }

    private final void B() {
        getContentView().setPressed(false);
        g();
    }

    private final boolean C() {
        if (getContentView().getAlpha() < 1.0f) goto L17;
        if (getScaleX() != 1.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L17;
        if (getScaleY() != 1.0f) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L17;
        if (this.n > 0.0f) goto L17;
        return false;
    L12:
        r1 = false;
        goto L13
    L7:
        r0 = false;
    L17:
        return true;
    }

    private final float D() {
        return c.a.f13385a.b();
    }

    private final float E() {
        return c.a.f13385a.d();
    }

    private final float F() {
        return c.a.f13385a.h();
    }

    private final void G() {
        float r0 = this.u * this.v;
        setScaleX(r0);
        setScaleY(r0);
    }

    private final void H() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.r, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        List r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.r, Iterable.class, "com.obric.memorydata.plugin"));
        this.r.clear();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        ((Function0) ZeusTransformUtils.preCheckCast(r3.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
        goto L6
    L10:
        return;
    }

    private final void I() {
        if (d() == false) goto L5;
        return;
    L5:
        if (this.s.isEmpty() == true) goto L13;
        List r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.s, Iterable.class, "com.obric.memorydata.plugin"));
        this.s.clear();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        ((Function0) ZeusTransformUtils.preCheckCast(r3.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
        goto L9
    L14:
        return;
    }

    public static final /* synthetic */ float a(OButtonGroup r0, View r1) {
        return r0.c(r1);
    }

    private final com.obric.common.oea.foundation.animation.d.d a(float r10, float r11, com.obric.common.oea.foundation.animation.spec.a<Float> r12, float r13, Function1<? super Float, Unit> r14, Function0<Unit> r15) {
        com.obric.common.oea.foundation.animation.spec.a r16 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        final Function1 r17 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        final Function0 r18 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        return com.obric.common.oea.foundation.animation.builder.c.a.a(new com.obric.common.oea.foundation.animation.builder.c.a(), r10, r11, com.obric.oui.common.util.a.a(r16, r13), null, 8, null).a((Function3) ZeusTransformUtils.preCheckCast(new OButtonGroup$startFloatAnimation$1(r17, this), Function3.class, "com.obric.memorydata.plugin")).a((Function2) ZeusTransformUtils.preCheckCast(new OButtonGroup$startFloatAnimation$2(r18), Function2.class, "com.obric.memorydata.plugin")).a().a();
    }

    private final Function1<Float, Unit> a(final float r11, float r12, Function1<? super Float, Unit> r13) {
        final Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        final float r4 = RangesKt.coerceIn(r12, 0.0f, 1.0f);
        if (r4 != 1.0f) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L8;
    L10:
        final boolean r5 = false;
    L12:
        if (r4 != 0.0f) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == true) goto L17;
    L19:
        final boolean r6 = false;
    L20:
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        return (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$boundedAlphaUpdater$1(r3, r4, r5, r6, this, r11, r9), Function1.class, "com.obric.memorydata.plugin");
    L17:
        if (r11 <= r4) goto L19;
        r6 = true;
        goto L20
    L14:
        r15 = false;
        goto L15
    L8:
        if (r11 >= r4) goto L10;
        r5 = true;
        goto L12
    L5:
        r14 = false;
        goto L6
    }

    private final void a(float r1, float r2, float r3) {
        setGroupAlpha(r1);
        this.u = r2;
        G();
        setGroupBlurForAnimation(r3);
    }

    private final void a(final float r14, com.obric.common.oea.foundation.animation.spec.a<Float> r15, Function0<Unit> r16, List<com.obric.common.oea.foundation.animation.d.d> r17) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r15, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r16, Function0.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        final float r11 = getContentView().getAlpha();
        final List<k> r4 = j();
        final List<k> r5 = b(r14);
        final Function1<Float, Unit> r0 = a(r11, r14, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startGroupAlphaAnimation$updateAlpha$1(this, r14, r11, r4, r5), Function1.class, "com.obric.memorydata.plugin"));
        r10.add(a(r11, r14, r8, 0.390625f, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startGroupAlphaAnimation$1(this, r0), Function1.class, "com.obric.memorydata.plugin"), r9));
    }

    private final void a(int r3, int r4, List<? extends View> r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r4 != 0) goto L6;
        z();
        return;
    L6:
        if (r3 != 0) goto L9;
        e(r6);
        return;
    L9:
        f(r6);
    }

    private final void a(int r10, final int r11, Function0<Unit> r12) {
        final Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        this.l.add(a(r10, r11, c.a.f13385a.h(r11).a(), 10.0f, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startWidthChangeAnimation$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$startWidthChangeAnimation$2(this, r11, r13), Function0.class, "com.obric.memorydata.plugin")));
    }

    private final void a(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.common.style.a.class) == false) goto L5;
        com.obric.oui.common.style.a r4 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.common.style.a.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        r4.setChangeAlphaWhenPress(false);
        this.j = true;
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void a(final View r10, float r11, com.obric.common.oea.foundation.animation.spec.a<Float> r12, Function0<Unit> r13, List<com.obric.common.oea.foundation.animation.d.d> r14) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r5 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        final Function1<Float, Unit> r16 = a(r10.getAlpha(), r11, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startChildAlphaAnimation$updateAlpha$1(r10), Function1.class, "com.obric.memorydata.plugin"));
        r15.add(a(r10.getAlpha(), r11, r5, 0.390625f, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startChildAlphaAnimation$1(r16), Function1.class, "com.obric.memorydata.plugin"), r8));
    }

    private final void a(ContentAnimationState r1) {
        this.m = r1;
        this.l.clear();
    }

    private final void a(b r6) {
        setVisibility(r6.a());
        a(r6.b(), r6.c(), r6.e());
        d(r6.f());
        LinearLayout r5 = this.e;
        if (r5 == null) goto L16;
        int r0 = 0;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6.g(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r7.hasNext() == false) goto L20;
        Object r2 = r7.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.memorydata.plugin");
        View r1 = r5.getChildAt(r0);
        if (r1 == null) goto L15;
        r1.setVisibility(r4.b());
        r1.setAlpha(r4.c());
        r1.setScaleX(r4.d());
        r1.setScaleY(r4.e());
    L15:
        r0 = r3;
        goto L7
    L20:
        return;
    }

    public static final /* synthetic */ void a(OButtonGroup r0) {
        r0.r();
    }

    public static final /* synthetic */ void a(OButtonGroup r0, float r1) {
        r0.setGroupBlurForAnimation(r1);
    }

    public static final /* synthetic */ void a(OButtonGroup r0, float r1, float r2, float r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(OButtonGroup r2, float r3, com.obric.common.oea.foundation.animation.spec.a r4, Function0 r5, List r6) {
        r2.a(r3, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(OButtonGroup r1, float r2, com.obric.common.oea.foundation.animation.spec.a r3, Function0 r4, List r5, int r6, Object r7) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        List<com.obric.common.oea.foundation.animation.d.d> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = r1.k;
    L5:
        r1.a(r2, r8, r9, r10);
    }

    public static final /* synthetic */ void a(OButtonGroup r0, int r1) {
        r0.d(r1);
    }

    public static final /* synthetic */ void a(OButtonGroup r2, int r3, int r4, Function0 r5) {
        r2.a(r3, r4, (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(OButtonGroup r8, View r9, float r10, com.obric.common.oea.foundation.animation.spec.a r11, Function0 r12, List r13) {
        r8.a(r9, r10, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(OButtonGroup r0, GroupAnimationState r1) {
        r0.x = r1;
    }

    public static final /* synthetic */ void a(OButtonGroup r2, List r3) {
        r2.d((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(OButtonGroup r2, List r3, Function0 r4) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(OButtonGroup r2, List r3, boolean r4, boolean r5) {
        r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    static /* synthetic */ void a(OButtonGroup r1, Function0 r2, boolean r3, boolean r4, int r5, Object r6) {
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = true;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = true;
    L8:
        r1.a(r7, r3, r4);
    }

    static /* synthetic */ void a(OButtonGroup r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.c(r1);
    }

    static /* synthetic */ void a(OButtonGroup r1, boolean r2, Function0 r3, int r4, Object r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.a(r2, r6);
    }

    private final void a(List<? extends View> r3, Function0<Unit> r4) {
        final List<? extends View> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        g(r5);
        this.m = ContentAnimationState.IN;
        a(r6, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startContentFadeInPhase$1(r5, this), Function1.class, "com.obric.memorydata.plugin"));
    }

    private final void a(List<? extends View> r3, boolean r4, boolean r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L8;
        if (r5 == false) goto L9;
        y();
        settleChildrenVisualState(r6);
        d(-2);
        setGroupScaleForAnimation(1.0f);
        setGroupBlurForAnimation(0.0f);
        r();
        I();
        return;
    L9:
        return;
    }

    private final void a(Function0<Unit> r2, Function1<? super a, Unit> r3) {
        Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        a r5 = new a(r1);
        r4.invoke(r5);
        r5.a();
    }

    private final void a(Function0<Unit> r5, final boolean r6, boolean r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        LinearLayout r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r2 = Integer.valueOf(r0.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r2 = null;
    L12:
        if (r2 != null) goto L14;
        final int r1 = r0.getMeasuredWidth();
    L15:
        if (r7 == false) goto L17;
        final List<View> r9 = q();
    L18:
        B();
        this.x = GroupAnimationState.DISAPPEARING;
        this.k.clear();
        a((Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateGroupDisappear$1(this, r8, r6), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateGroupDisappear$2(r9, this, r1), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L17:
        r9 = CollectionsKt.emptyList();
        goto L18
    L14:
        r1 = r2.intValue();
        goto L15
    L8:
        r3 = false;
        goto L9
    }

    private final void a(final boolean r6, Function0<Unit> r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        B();
        if (getContentView().getAlpha() > 0.0f) goto L5;
        i();
    L5:
        boolean r0 = false;
        setVisibility(0);
        if (r6 == false) goto L8;
        a(0.0f, c.a.f13385a.a(), D());
        k(q());
    L8:
        LinearLayout r2 = this.e;
        if (r2 != null) goto L11;
        return;
    L11:
        Integer r3 = Integer.valueOf(r2.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L14;
        r0 = true;
    L14:
        if (r0 == true) goto L17;
        r3 = null;
    L17:
        if (r3 != null) goto L19;
        final int r1 = r2.getMeasuredWidth();
    L20:
        if (r6 == false) goto L22;
        final List<View> r4 = q();
    L23:
        this.x = GroupAnimationState.APPEARING;
        this.k.clear();
        a((Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateGroupAppear$1(this, r6, r4, r8), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateGroupAppear$2(r4, this, r1), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L22:
        r4 = CollectionsKt.emptyList();
        goto L23
    L19:
        r1 = r3.intValue();
        goto L20
    }

    private final float b(float r4, float r5, float r6) {
        float r3 = r6 - r5;
        if (r3 != 0.0f) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        float r7 = RangesKt.coerceIn((r4 - r5) / r3, 0.0f, 1.0f);
        return RangesKt.coerceIn(r5 + (r3 * RangesKt.coerceIn(r7 + (((1.0f - r7) * r7) * 0.7f), 0.0f, 1.0f)), 0.0f, 1.0f);
    L9:
        return RangesKt.coerceIn(r6, 0.0f, 1.0f);
    L5:
        r1 = false;
        goto L7
    }

    public static final /* synthetic */ float b(OButtonGroup r0, float r1, float r2, float r3) {
        return r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ float b(OButtonGroup r0, View r1) {
        return r0.f(r1);
    }

    public static final /* synthetic */ List b(OButtonGroup r0) {
        return r0.k;
    }

    private final void b(float r10, com.obric.common.oea.foundation.animation.spec.a<Float> r11, Function0<Unit> r12, List<com.obric.common.oea.foundation.animation.d.d> r13) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r5 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        final Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        ((List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin")).add(a(this.u, r10, r5, 0.390625f, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startGroupScaleAnimation$1(this), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$startGroupScaleAnimation$2(r14), Function0.class, "com.obric.memorydata.plugin")));
    }

    private final void b(View r1) {
        if (r1.isEnabled() == false) goto L5;
        r1.setAlpha(1.0f);
        return;
    L5:
        r1.setEnabled(false);
    }

    private final void b(final View r10, float r11, com.obric.common.oea.foundation.animation.spec.a<Float> r12, Function0<Unit> r13, List<com.obric.common.oea.foundation.animation.d.d> r14) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r5 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        final Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        ((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin")).add(a(r10.getScaleX(), r11, r5, 0.390625f, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startChildScaleAnimation$1(r10), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$startChildScaleAnimation$2(r15), Function0.class, "com.obric.memorydata.plugin")));
    }

    public static final /* synthetic */ void b(OButtonGroup r0, float r1) {
        r0.t = r1;
    }

    public static final /* synthetic */ void b(OButtonGroup r2, float r3, com.obric.common.oea.foundation.animation.spec.a r4, Function0 r5, List r6) {
        r2.c(r3, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void b(OButtonGroup r1, float r2, com.obric.common.oea.foundation.animation.spec.a r3, Function0 r4, List r5, int r6, Object r7) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        List<com.obric.common.oea.foundation.animation.d.d> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = r1.k;
    L5:
        r1.b(r2, r8, r9, r10);
    }

    public static final /* synthetic */ void b(OButtonGroup r8, View r9, float r10, com.obric.common.oea.foundation.animation.spec.a r11, Function0 r12, List r13) {
        r8.b(r9, r10, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void b(OButtonGroup r2, List r3) {
        r2.settleChildrenVisualState((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private final void b(List<? extends View> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        LinearLayout r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        int r3 = Math.min(r0.getChildCount(), r9.size());
    L6:
        if (r2 >= r3) goto L8;
        int r4 = r2 + 1;
        r0.getChildAt(r2).setEnabled(((View) ZeusTransformUtils.preCheckCast(r9.get(r2), View.class, "com.obric.memorydata.plugin")).isEnabled());
        r2 = r4;
        goto L6
    L8:
        l();
        n();
    }

    private final void b(List<? extends View> r10, final boolean r11) {
        final List<? extends View> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        final List<View> r5 = q();
        Integer r0 = Integer.valueOf(getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        int r1 = getMeasuredWidth();
    L12:
        final int r7 = i(r12);
        d(r1);
        a(ContentAnimationState.OUT);
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        final Ref.BooleanRef r4 = new Ref.BooleanRef();
        a(r1, r7, (Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateContentChange$1(r3, this, r12, r4), Function0.class, "com.obric.memorydata.plugin"));
        if (r11 == false) goto L15;
        setVisibility(0);
    L15:
        final boolean r6 = !r11;
        a((Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateContentChange$2(this, r12, r4, r3), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateContentChange$3(r11, r6, r5, this, r7), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r1 = r0.intValue();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    private final float c(View r2) {
        if (r2.isEnabled() == false) goto L6;
        return 1.0f;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.common.style.a.class) == true) goto L8;
        return 1.0f;
    L8:
        float r1 = r2.getAlpha();
        r2.setAlpha(1.0f);
        r2.setEnabled(false);
        float r0 = r2.getAlpha();
        r2.setAlpha(r1);
        return r0;
    }

    private final List<Object> c(List<? extends View> r4) {
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.memorydata.plugin");
        Object r2 = r1.getTag();
        if (r2 == null) goto L9;
        r1 = r2;
    L9:
        r5.add(r1);
        goto L4
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    }

    private final void c(final float r10, com.obric.common.oea.foundation.animation.spec.a<Float> r11, Function0<Unit> r12, List<com.obric.common.oea.foundation.animation.d.d> r13) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r5 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        final List<k> r15 = j();
        final List<k> r16 = b(r10);
        final Function1<Float, Unit> r17 = a(0.0f, 1.0f, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startGroupShadowAnimation$updateFraction$1(this, r10, r15, r16), Function1.class, "com.obric.memorydata.plugin"));
        r14.add(a(0.0f, 1.0f, r5, 0.390625f, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startGroupShadowAnimation$1(r17), Function1.class, "com.obric.memorydata.plugin"), r8));
    }

    public static final /* synthetic */ void c(OButtonGroup r0) {
        r0.H();
    }

    public static final /* synthetic */ void c(OButtonGroup r0, float r1) {
        r0.setGroupScaleForAnimation(r1);
    }

    public static final /* synthetic */ void c(OButtonGroup r2, float r3, com.obric.common.oea.foundation.animation.spec.a r4, Function0 r5, List r6) {
        r2.b(r3, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void c(OButtonGroup r1, float r2, com.obric.common.oea.foundation.animation.spec.a r3, Function0 r4, List r5, int r6, Object r7) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        List<com.obric.common.oea.foundation.animation.d.d> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = r1.k;
    L5:
        r1.d(r2, r8, r9, r10);
    }

    private final void c(boolean r2) {
        A();
        x();
        this.r.clear();
        this.s.clear();
        if (r2 == false) goto L6;
        this.o = null;
        return;
    }

    private final void d(float r10, com.obric.common.oea.foundation.animation.spec.a<Float> r11, Function0<Unit> r12, List<com.obric.common.oea.foundation.animation.d.d> r13) {
        com.obric.common.oea.foundation.animation.spec.a<Float> r5 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        ((List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin")).add(a(this.n, r10, r5, 10.0f, (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$startGroupBlurAnimation$1(this), Function1.class, "com.obric.memorydata.plugin"), r8));
    }

    private final void d(int r2) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.width = r2;
        setLayoutParams(r0);
    }

    public static final /* synthetic */ void d(OButtonGroup r0) {
        r0.I();
    }

    public static final /* synthetic */ void d(OButtonGroup r2, float r3, com.obric.common.oea.foundation.animation.spec.a r4, Function0 r5, List r6) {
        r2.d(r3, (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"));
    }

    private final void d(List<? extends View> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        LinearLayout r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllViews();
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r3 = 0;
    L7:
        if (r12.hasNext() == false) goto L27;
        Object r4 = r12.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        ViewParent r7 = r6.getParent();
        ViewGroup.MarginLayoutParams r8 = null;
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L14;
        ViewGroup r9 = (ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin");
    L15:
        if (r9 == null) goto L18;
        r9.removeView(r6);
    L18:
        e(r6);
        ViewGroup.LayoutParams r13 = r6.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r13, ViewGroup.MarginLayoutParams.class) == false) goto L21;
        r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L21:
        if (r8 != null) goto L23;
        r8 = new ViewGroup.MarginLayoutParams(-2, -2);
    L23:
        if (r3 != 0) goto L25;
        int r14 = 0;
    L26:
        r8.setMarginStart(r14);
        r0.addView(r6, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r3 = r5;
        goto L7
    L25:
        r14 = this.f;
        goto L26
    L14:
        r9 = null;
        goto L15
    L27:
        l();
        n();
        m();
    }

    private final boolean d(View r2) {
        if (Math.abs(r2.getAlpha() - c(r2)) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    private final void e(View r2) {
        int r1 = r2.getMinimumHeight();
        if (r1 > 0) goto L5;
        return;
    L5:
        if (r2.getMinimumWidth() >= r1) goto L9;
        r2.setMinimumWidth(r1);
        return;
    }

    public static final /* synthetic */ void e(OButtonGroup r0) {
        r0.s();
    }

    private final void e(List<? extends View> r5) {
        List<? extends View> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        a(this, false, 1, null);
        d(r6);
        a(true, (Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$transitionFromEmpty$1(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final float f(View r1) {
        if (g(r1) == false) goto L6;
        return c.a.f13385a.g();
    L6:
        return c.a.f13385a.f();
    }

    public static final /* synthetic */ float f(OButtonGroup r0) {
        return r0.E();
    }

    private final void f(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (this.x == GroupAnimationState.IDLE) goto L5;
        A();
    L5:
        x();
        b(r4, C());
    }

    public static final /* synthetic */ List g(OButtonGroup r0) {
        return r0.l;
    }

    private final void g(List<? extends View> r4) {
        List<? extends View> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        d(r5);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(r6.next(), View.class, "com.obric.memorydata.plugin");
        r0.setAlpha(0.0f);
        float r2 = f(r0);
        r0.setScaleX(r2);
        r0.setScaleY(r2);
        goto L4
    }

    private final boolean g(View r8) {
        if (ZeusTransformUtils.instanceOf(r8, TextView.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == false) goto L13;
        int r0 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
        int r4 = 0;
    L8:
        if (r4 >= r0) goto L13;
        int r5 = r4 + 1;
        View r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r4);
        Intrinsics.checkNotNullExpressionValue(r6, "view.getChildAt(index)");
        if (g(r6) == true) goto L11;
        r4 = r5;
        goto L8
    L11:
        return true;
    L13:
        return false;
    }

    public static final /* synthetic */ float h(OButtonGroup r0) {
        return r0.F();
    }

    private final void h(List<? extends View> r6) {
        final List<? extends View> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Integer r0 = Integer.valueOf(getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        final int r1 = getMeasuredWidth();
    L12:
        final int r3 = i(r7);
        d(r1);
        a(ContentAnimationState.SETTLING);
        a((Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateContentSettle$1(this, r7), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new OButtonGroup$animateContentSettle$2(r7, this, r1, r3), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r1 = r0.intValue();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    private final int i(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L6;
        return 0;
    L6:
        int r0 = getContentContainer().getPaddingLeft() + getContentContainer().getPaddingRight();
        return Math.max(j(r4) + r0, this.g);
    }

    public static final /* synthetic */ void i(OButtonGroup r0) {
        r0.y();
    }

    private final int j(List<? extends View> r9) {
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r10.hasNext() == false) goto L12;
        Object r4 = r10.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r6 = (View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin");
        e(r6);
        r6.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r2 = r2 + r6.getMeasuredWidth();
        if (r3 <= 0) goto L11;
        r2 = r2 + this.f;
    L11:
        r3 = r5;
        goto L4
    L12:
        return r2;
    }

    public static final /* synthetic */ Function0 j(OButtonGroup r0) {
        return r0.q;
    }

    public static final /* synthetic */ Function0 k(OButtonGroup r0) {
        return r0.p;
    }

    private final void k(List<? extends View> r3) {
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2.next(), View.class, "com.obric.memorydata.plugin");
        r4.setAlpha(0.0f);
        r4.setScaleX(c.a.f13385a.c());
        r4.setScaleY(c.a.f13385a.c());
        goto L4
    }

    private final void l() {
        List<View> r0 = q();
        boolean r2 = true;
        if (r0.isEmpty() == true) goto L19;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L7;
    L9:
        Iterator r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L8;
        if (((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.memorydata.plugin")).isEnabled() == false) goto L11;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L19;
        r2 = false;
    L8:
        r4 = false;
        goto L15
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
    L19:
        if (isEnabled() != r2) goto L22;
        return;
    L22:
        if (d() == false) goto L24;
        b r5 = e();
    L25:
        super.setEnabled(r2);
        LinearLayout r6 = this.e;
        if (r6 == null) goto L29;
        r6.setEnabled(r2);
    L29:
        if (r5 == null) goto L36;
        a(r5);
        return;
    L36:
        return;
    L24:
        r5 = null;
        goto L25
    }

    private final void m() {
        if (getItemCount() != 0) goto L5;
        int r0 = 8;
    L6:
        setVisibility(r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private final void n() {
        LinearLayout r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (r0.getChildCount() != 1) goto L17;
        View r1 = r0.getChildAt(0);
        if (this.i == r1) goto L10;
        o();
        this.i = r1;
    L10:
        Intrinsics.checkNotNullExpressionValue(r1, "only");
        a(r1);
        OUIFrameLayout r3 = getContentView();
        if (isEnabled() == true) goto L13;
    L15:
        r2 = false;
    L16:
        r3.setChangeAlphaWhenPress(r2);
        return;
    L13:
        if (r1.isEnabled() == false) goto L15;
    L17:
        getContentView().setChangeAlphaWhenPress(false);
        o();
    }

    private final void o() {
        View r0 = this.i;
        if (r0 != null) goto L5;
    L13:
        this.i = null;
        this.j = false;
        return;
    L5:
        if (this.j == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.common.style.a.class) == false) goto L9;
        com.obric.oui.common.style.a r1 = (com.obric.oui.common.style.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.common.style.a.class, "com.obric.memorydata.plugin");
    L10:
        if (r1 == null) goto L13;
        r1.setChangeAlphaWhenPress(true);
        goto L13
    L9:
        r1 = null;
        goto L10
    }

    private final boolean p() {
        if (getItemCount() != 1) goto L12;
        View r3 = c(0);
        if (r3 != null) goto L8;
    L6:
        boolean r4 = false;
    L10:
        if (r4 == true) goto L12;
        return false;
    L8:
        if (r3.isEnabled() != true) goto L6;
        r4 = true;
    L12:
        return true;
    }

    private final List<View> q() {
        LinearLayout r4 = this.e;
        if (r4 == null) goto L5;
        ArrayList r0 = new ArrayList(r4.getChildCount());
        int r1 = 0;
        int r2 = r4.getChildCount();
    L7:
        if (r1 >= r2) goto L10;
        int r3 = r1 + 1;
        r0.add(r4.getChildAt(r1));
        r1 = r3;
        goto L7
    L10:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    private final void r() {
        this.o = null;
    }

    private final void s() {
        a(1.0f, 1.0f, 0.0f);
        t();
    }

    private final void setGroupAlpha(float r2) {
        this.t = r2;
        getContentView().setAlpha(r2);
        setContentShadowAlphaProgress(r2);
    }

    private final void setGroupBlur(float r1) {
        setContentSelfBlur(r1);
    }

    private final void setGroupBlurForAnimation(float r1) {
        this.n = r1;
        setGroupBlur(r1);
    }

    private final void setGroupScaleForAnimation(float r1) {
        this.u = r1;
        G();
    }

    private final void settleChildrenVisualState(List<? extends View> r4) {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        View r0 = (View) ZeusTransformUtils.preCheckCast(r5.next(), View.class, "com.obric.memorydata.plugin");
        b(r0);
        r0.setScaleX(1.0f);
        r0.setScaleY(1.0f);
        goto L4
    }

    private final void t() {
        d(-2);
        LinearLayout r0 = this.e;
        if (r0 == null) goto L8;
        int r1 = 0;
        int r2 = r0.getChildCount();
    L6:
        if (r1 >= r2) goto L10;
        int r3 = r1 + 1;
        View r4 = r0.getChildAt(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "child");
        b(r4);
        r4.setScaleX(1.0f);
        r4.setScaleY(1.0f);
        r1 = r3;
        goto L6
    L10:
        return;
    }

    private final boolean u() {
        if (getItemCount() == 0) goto L5;
        LinearLayout r0 = this.e;
        if (r0 != null) goto L13;
        return true;
    L13:
        if (getVisibility() == 0) goto L15;
    L41:
        return false;
    L15:
        if (C() == true) goto L41;
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if (r3 != null) goto L20;
        int r4 = -2;
    L21:
        if (r4 == (-2)) goto L23;
        return false;
    L23:
        int r5 = r0.getChildCount();
        int r6 = 0;
    L24:
        if (r6 >= r5) goto L40;
        int r7 = r6 + 1;
        View r8 = r0.getChildAt(r6);
        Intrinsics.checkNotNullExpressionValue(r8, "child");
        if (d(r8) == false) goto L39;
        if (r8.getScaleX() != 1.0f) goto L30;
        boolean r9 = true;
    L31:
        if (r9 == false) goto L39;
        if (r8.getScaleY() != 1.0f) goto L35;
        boolean r10 = true;
    L36:
        if (r10 == false) goto L39;
        r6 = r7;
        goto L24
    L35:
        r10 = false;
        goto L36
    L30:
        r9 = false;
    L39:
        return false;
    L40:
        return true;
    L20:
        r4 = r3.width;
        goto L21
    L5:
        if (getVisibility() == 0) goto L8;
        return true;
    L8:
        return false;
    }

    private final void v() {
        List<View> r0 = q();
        if (r0.isEmpty() == false) goto L6;
        s();
        m();
        return;
    L6:
        a(this, false, 1, null);
        if (C() == false) goto L9;
    L10:
        a(this, false, null, 2, null);
    L12:
        if (w() == false) goto L15;
        h(r0);
        return;
    L15:
        return;
    L9:
        if (getVisibility() == 0) goto L12;
        goto L10
    }

    private final boolean w() {
        LinearLayout r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2 != null) goto L8;
        int r3 = -2;
    L10:
        if (r3 == (-2)) goto L12;
        return true;
    L12:
        int r4 = r0.getChildCount();
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L29;
        int r6 = r5 + 1;
        View r7 = r0.getChildAt(r5);
        Intrinsics.checkNotNullExpressionValue(r7, "child");
        if (d(r7) == false) goto L28;
        if (r7.getScaleX() != 1.0f) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L28;
        if (r7.getScaleY() != 1.0f) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L28;
        r5 = r6;
        goto L13
    L24:
        r9 = false;
        goto L25
    L19:
        r8 = false;
    L28:
        return true;
    L29:
        return false;
    L8:
        r3 = r2.width;
        goto L10
    }

    private final void x() {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.l, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.obric.common.oea.foundation.animation.d.d.a((com.obric.common.oea.foundation.animation.d.d) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.common.oea.foundation.animation.d.d.class, "com.obric.memorydata.plugin"), false, 1, null);
        goto L4
    L6:
        y();
    }

    private final void y() {
        this.l.clear();
        this.m = ContentAnimationState.IDLE;
    }

    private final void z() {
        if (this.x != GroupAnimationState.DISAPPEARING) goto L5;
        return;
    L5:
        x();
        A();
        a(this, (Function0) ZeusTransformUtils.preCheckCast(new OButtonGroup$transitionToEmpty$1(this), Function0.class, "com.obric.memorydata.plugin"), false, false, 6, null);
    }

    public final int a(List<? extends View> r3) {
        List<? extends View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "views");
        return i(r4);
    }

    public final View a(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        View r7 = ZeusTransformUtils.inflate(LayoutInflater.from(r6), r5, null, false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "itemView");
        a(r7, new ViewGroup.MarginLayoutParams(-2, -2));
        return r7;
    }

    public final void a() {
        this.r.clear();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void a(float r1) {
        this.v = r1;
        G();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void a(Context r3, FrameLayout r4, AttributeSet r5, TypedArray r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r4, "contentView");
        if (r6 != null) goto L5;
        return;
    L5:
        r4.removeAllViews();
        setChangeAlphaWhenPress(false);
        getContentView().setDuplicateParentStateEnabled(false);
        LinearLayout r0 = new LinearLayout(r7);
        r0.setOrientation(0);
        r0.setGravity(17);
        this.e = r0;
        r4.addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        setWidthMin(this.g);
        getContentView().setWidthMin(this.g);
        n();
        m();
        if (getEnableMaterial() == false) goto L9;
        a(r7, r6);
        return;
    }

    public final void a(View r2, ViewGroup.MarginLayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "layoutParams");
        a(r2, r3, -1);
    }

    public final void a(View r2, ViewGroup.MarginLayoutParams r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "layoutParams");
        a(r2, r3, r4, false);
    }

    public final void a(View r3, ViewGroup.MarginLayoutParams r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "layoutParams");
        r3.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        List<? extends View> r7 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(q(), Collection.class, "com.obric.memorydata.plugin"));
        if (r5 >= 0) goto L5;
    L6:
        r5 = r7.size();
    L7:
        r7.add(r5, r3);
        a(r7, r6);
        return;
    L5:
        if (r5 <= r7.size()) goto L7;
        goto L6
    }

    public final void a(b r7, Function1<? super d, ? extends View> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r9, "itemFactory");
        c(true);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7.g(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1.next(), d.class, "com.obric.memorydata.plugin");
        View r4 = (View) ZeusTransformUtils.preCheckCast(r9.invoke(r3), View.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r4 = null;
    L9:
        if (r4 == null) goto L4;
        r2.add(r4);
        goto L4
    L8:
        r4.setVisibility(r3.b());
        r4.setAlpha(r3.c());
        r4.setScaleX(r3.d());
        r4.setScaleY(r3.e());
        goto L9
    L11:
        d((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
        r();
        d(r7.f());
        setVisibility(r7.a());
        a(r7.b(), r7.c(), r7.e());
        n();
    }

    public final void a(List<? extends View> r6, boolean r7) {
        List<? extends View> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "views");
        LinearLayout r0 = this.e;
        if (r0 != null) goto L7;
        OButtonGroup r5 = (OButtonGroup) ZeusTransformUtils.preCheckCast(this, OButtonGroup.class, "com.obric.memorydata.plugin");
        com.obric.oui.c.a.b.e("OButtonGroup", "itemContainer is null");
        return;
    L7:
        if (r8.size() <= this.h) goto L9;
        com.obric.oui.c.a.b.d("OButtonGroup", "views size exceeds capacity: " + this.h + ", truncated");
        r8 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), this.h);
    L9:
        int r1 = r0.getChildCount();
        int r2 = r8.size();
        List<? extends Object> r3 = c(r8);
        List<Object> r4 = c(q());
        if (Intrinsics.areEqual(r3, r4) == false) goto L16;
        if (u() == false) goto L16;
        b(r8);
        return;
    L16:
        if (d() == true) goto L18;
    L21:
        if (r7 == true) goto L24;
        c(true);
        d(r8);
        s();
        m();
        r();
        return;
    L24:
        this.o = r3;
        if (Intrinsics.areEqual(r3, r4) == true) goto L27;
    L30:
        a(r1, r2, r8);
        return;
    L27:
        if (u() == true) goto L30;
        v();
        return;
    L18:
        if (Intrinsics.areEqual(r3, this.o) == false) goto L21;
        b(r8);
    }

    public final void a(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (d() == true) goto L6;
        r4.invoke();
        return;
    L6:
        this.s.add(r4);
    }

    public final boolean b() {
        return this.w;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public boolean b(boolean r2) {
        if (this.x == GroupAnimationState.IDLE) goto L5;
    L9:
        return false;
    L5:
        if (this.t < 1.0f) goto L9;
        if (p() == false) goto L9;
        return true;
    }

    public final View c(int r1) {
        LinearLayout r0 = this.e;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getChildAt(r1);
    }

    public final void c() {
        c(true);
    }

    public final boolean d() {
        if (this.x == GroupAnimationState.IDLE) goto L5;
    L8:
        return true;
    L5:
        if (this.m != ContentAnimationState.IDLE) goto L8;
        return false;
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        boolean r1 = true;
        if (this.w == false) goto L6;
        return true;
    L6:
        if (getItemCount() != 1) goto L8;
        boolean r0 = true;
    L9:
        boolean r3 = super.dispatchTouchEvent(r8);
        if (r0 == false) goto L37;
        boolean r2 = b(true);
        int r4 = r8.getActionMasked();
        if (r4 == 0) goto L36;
        if (r4 != 1) goto L15;
    L35:
        getContentView().setPressed(false);
        goto L37
    L15:
        if (r4 == 2) goto L20;
        if (r4 == 3) goto L35;
    L20:
        if (r8.getX() >= 0.0f) goto L22;
    L28:
        boolean r9 = false;
    L29:
        OUIFrameLayout r7 = getContentView();
        if (r2 == false) goto L33;
        if (r9 == false) goto L33;
    L34:
        r7.setPressed(r1);
    L33:
        r1 = false;
        goto L34
    L22:
        if (r8.getX() >= getWidth()) goto L28;
        if (r8.getY() < 0.0f) goto L28;
        if (r8.getY() >= getHeight()) goto L28;
        r9 = true;
        goto L29
    L36:
        getContentView().setPressed(r2);
    L37:
        return r3;
    L8:
        r0 = false;
        goto L9
    }

    public final b e() {
        LinearLayout r1 = this.e;
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        int r2 = 0;
        int r3 = r1.getChildCount();
    L5:
        if (r2 >= r3) goto L7;
        int r4 = r2 + 1;
        View r5 = r1.getChildAt(r2);
        r10.add(new d(r5.getTag(), r5.getVisibility(), r5.getAlpha(), r5.getScaleX(), r5.getScaleY()));
        r2 = r4;
    L7:
        int r6 = getVisibility();
        float r7 = getContentView().getAlpha();
        float r8 = this.u;
        float r9 = this.n;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L10;
        int r11 = -2;
    L12:
        return new b(r6, r7, r8, r8, r9, r11, r10);
    L10:
        r11 = r0.width;
        goto L12
    }

    @Override // com.obric.oui.button.OShadowFrame
    public float getCurrentPressScaleForAnimation() {
        return this.v;
    }

    public final int getItemCount() {
        LinearLayout r0 = this.e;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getChildCount();
    }

    public final float getRawGroupAlphaForTitleBarTransition$OUI_standardRelease() {
        return this.t;
    }

    public final void setAnimationUpdateListener$OUI_standardRelease(Function0<Unit> r3) {
        this.p = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.button.OShadowFrame, com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r3) {
        if (d() == false) goto L5;
        b r0 = e();
    L6:
        super.setEnabled(r3);
        LinearLayout r1 = this.e;
        if (r1 == null) goto L10;
        r1.setEnabled(r3);
    L10:
        n();
        if (r0 == null) goto L15;
        a(r0);
        return;
    L15:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void setGroupAlphaAnimationUpdateListener$OUI_standardRelease(Function0<Unit> r3) {
        this.q = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    public final void setTouchEventBlocked$OUI_standardRelease(boolean r1) {
        this.w = r1;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public void setWidthMin(int r1) {
        getLayoutHelper().setWidthMin(r1);
    }
}
