package com.obric.oui.color;

import android.util.Log;
import androidx.core.view.ViewCompat;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.graphic.BlendMode;
import com.obric.oui.material.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0003\b¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010³\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00042\n\u0010´\u0001\u001a\u0005\u0018\u00010«\u0001H\u0007J,\u0010³\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\u0010´\u0001\u001a\u0005\u0018\u00010«\u00012\u0007\u0010µ\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0003\u0010¶\u0001J\u001e\u0010·\u0001\u001a\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u00012\t\b\u0002\u0010º\u0001\u001a\u00020\u0005H\u0007J\u001e\u0010»\u0001\u001a\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u00012\t\b\u0002\u0010º\u0001\u001a\u00020\u0005H\u0007J>\u0010¼\u0001\u001a\u00030¸\u00012'\u0010½\u0001\u001a\"\u0012\u0005\u0012\u00030«\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040¾\u00012\t\b\u0002\u0010º\u0001\u001a\u00020\u0005H\u0007J2\u0010¿\u0001\u001a\u00030¸\u00012\u001b\u0010½\u0001\u001a\u0016\u0012\u0005\u0012\u00030«\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060¾\u00012\t\b\u0002\u0010º\u0001\u001a\u00020\u0005H\u0007R.\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\nR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\nR\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\nR\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\nR\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0002\u001a\u0004\b$\u0010\nR\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\nR\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0002\u001a\u0004\b.\u0010\nR\u0018\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0002\u001a\u0004\b3\u0010\nR\u0018\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u00105\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u0002\u001a\u0004\b8\u0010\nR\u0018\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u0002\u001a\u0004\b=\u0010\nR\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0002\u001a\u0004\bB\u0010\nR\u0018\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bF\u0010\u0002\u001a\u0004\bG\u0010\nR\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010\u0002\u001a\u0004\bL\u0010\nR\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010Q\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\u0002\u001a\u0004\bS\u0010\nR\u0018\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bW\u0010\u0002\u001a\u0004\bX\u0010\nR\u0018\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010[\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\\\u0010\u0002\u001a\u0004\b]\u0010\nR\u0018\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010`\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\ba\u0010\u0002\u001a\u0004\bb\u0010\nR\u0018\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010e\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bf\u0010\u0002\u001a\u0004\bg\u0010\nR\u0018\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010l\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bm\u0010\u0002\u001a\u0004\bn\u0010\nR\u0018\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010q\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\br\u0010\u0002\u001a\u0004\bs\u0010\nR\u0018\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010v\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bw\u0010\u0002\u001a\u0004\bx\u0010\nR\u0018\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR.\u0010{\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010\u0002\u001a\u0004\b}\u0010\nR\u0018\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u0080\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0081\u0001\u0010\u0002\u001a\u0005\b\u0082\u0001\u0010\nR\u0019\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u0085\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0086\u0001\u0010\u0002\u001a\u0005\b\u0087\u0001\u0010\nR\u0019\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u008a\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u008b\u0001\u0010\u0002\u001a\u0005\b\u008c\u0001\u0010\nR\u0019\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u008f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0090\u0001\u0010\u0002\u001a\u0005\b\u0091\u0001\u0010\nR\u0019\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u0094\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u0095\u0001\u0010\u0002\u001a\u0005\b\u0096\u0001\u0010\nR\u0019\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u0099\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u009a\u0001\u0010\u0002\u001a\u0005\b\u009b\u0001\u0010\nR\u0019\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR1\u0010\u009e\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0000\u0012\u0005\b\u009f\u0001\u0010\u0002\u001a\u0005\b \u0001\u0010\nR\u0019\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0019\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010¥\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010¦\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010§\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010¨\u0001\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R@\u0010©\u0001\u001a\"\u0012\u0005\u0012\u00030«\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040ª\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R4\u0010°\u0001\u001a\u0016\u0012\u0005\u0012\u00030«\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060ª\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b²\u0001\u0010¯\u0001\u001a\u0006\b±\u0001\u0010\u00ad\u0001¨\u0006À\u0001"}, d2 = {"Lcom/obric/oui/color/BlendToken;", "", "()V", "Blend_Base_Regular", "Lkotlin/Function1;", "", "", "Lcom/obric/oui/color/BlendConfig;", "getBlend_Base_Regular$annotations", "getBlend_Base_Regular", "()Lkotlin/jvm/functions/Function1;", "Blend_Base_Regular_Dark", "[Lcom/obric/oui/color/BlendConfig;", "Blend_Base_Regular_Light", "Blend_Base_Thick", "getBlend_Base_Thick$annotations", "getBlend_Base_Thick", "Blend_Base_Thick_Dark", "Blend_Base_Thick_Light", "Blend_Blue_4", "getBlend_Blue_4$annotations", "getBlend_Blue_4", "Blend_Blue_4_Dark", "Blend_Blue_4_Light", "Blend_Blue_6", "getBlend_Blue_6$annotations", "getBlend_Blue_6", "Blend_Blue_6_Dark", "Blend_Blue_6_Light", "Blend_Fill_Element_2", "getBlend_Fill_Element_2$annotations", "getBlend_Fill_Element_2", "Blend_Fill_Element_2_Dark", "Blend_Fill_Element_2_Light", "Blend_Fluid_Thin", "getBlend_Fluid_Thin$annotations", "getBlend_Fluid_Thin", "Blend_Fluid_Thin_Dark", "Blend_Fluid_Thin_Light", "Blend_Green_4", "getBlend_Green_4$annotations", "getBlend_Green_4", "Blend_Green_4_Dark", "Blend_Green_4_Light", "Blend_Green_6", "getBlend_Green_6$annotations", "getBlend_Green_6", "Blend_Green_6_Dark", "Blend_Green_6_Light", "Blend_Red_4", "getBlend_Red_4$annotations", "getBlend_Red_4", "Blend_Red_4_Dark", "Blend_Red_4_Light", "Blend_Red_6", "getBlend_Red_6$annotations", "getBlend_Red_6", "Blend_Red_6_Dark", "Blend_Red_6_Light", "Blend_Yellow_4", "getBlend_Yellow_4$annotations", "getBlend_Yellow_4", "Blend_Yellow_4_Dark", "Blend_Yellow_4_Light", "Blend_Yellow_6", "getBlend_Yellow_6$annotations", "getBlend_Yellow_6", "Blend_Yellow_6_Dark", "Blend_Yellow_6_Light", "OUI_Color_Blend_Blue_Regular", "getOUI_Color_Blend_Blue_Regular$annotations", "getOUI_Color_Blend_Blue_Regular", "OUI_Color_Blend_Blue_Regular_Dark", "OUI_Color_Blend_Blue_Regular_Light", "OUI_Color_Blend_Blue_Thin", "getOUI_Color_Blend_Blue_Thin$annotations", "getOUI_Color_Blend_Blue_Thin", "OUI_Color_Blend_Blue_Thin_Dark", "OUI_Color_Blend_Blue_Thin_Light", "OUI_Color_Blend_Fill_Tinted_Dark", "OUI_Color_Blend_Fill_Tinted_Light", "OUI_Color_Blend_Fluid_Regular", "getOUI_Color_Blend_Fluid_Regular$annotations", "getOUI_Color_Blend_Fluid_Regular", "OUI_Color_Blend_Fluid_Regular_Dark", "OUI_Color_Blend_Fluid_Regular_Light", "OUI_Color_Blend_Fluid_Thick", "getOUI_Color_Blend_Fluid_Thick$annotations", "getOUI_Color_Blend_Fluid_Thick", "OUI_Color_Blend_Fluid_Thick_Dark", "OUI_Color_Blend_Fluid_Thick_Light", "OUI_Color_Blend_Fluid_Thin", "getOUI_Color_Blend_Fluid_Thin$annotations", "getOUI_Color_Blend_Fluid_Thin", "OUI_Color_Blend_Fluid_Thin_Dark", "OUI_Color_Blend_Fluid_Thin_Light", "OUI_Color_Blend_Fluid_UltraThin", "getOUI_Color_Blend_Fluid_UltraThin$annotations", "getOUI_Color_Blend_Fluid_UltraThin", "OUI_Color_Blend_Fluid_UltraThin_Dark", "OUI_Color_Blend_Fluid_UltraThin_Light", "OUI_Color_Blend_Frost_Regular", "getOUI_Color_Blend_Frost_Regular$annotations", "getOUI_Color_Blend_Frost_Regular", "OUI_Color_Blend_Frost_Regular_Dark", "OUI_Color_Blend_Frost_Regular_Light", "OUI_Color_Blend_Frost_Thick_Dark", "OUI_Color_Blend_Frost_Thick_Light", "OUI_Color_Blend_Frost_Thin", "getOUI_Color_Blend_Frost_Thin$annotations", "getOUI_Color_Blend_Frost_Thin", "OUI_Color_Blend_Frost_Thin_Dark", "OUI_Color_Blend_Frost_Thin_Light", "OUI_Color_Blend_Frost_UltraThin", "getOUI_Color_Blend_Frost_UltraThin$annotations", "getOUI_Color_Blend_Frost_UltraThin", "OUI_Color_Blend_Frost_UltraThin_Dark", "OUI_Color_Blend_Frost_UltraThin_Light", "OUI_Color_Blend_Green_Regular", "getOUI_Color_Blend_Green_Regular$annotations", "getOUI_Color_Blend_Green_Regular", "OUI_Color_Blend_Green_Regular_Dark", "OUI_Color_Blend_Green_Regular_Light", "OUI_Color_Blend_Green_Thin", "getOUI_Color_Blend_Green_Thin$annotations", "getOUI_Color_Blend_Green_Thin", "OUI_Color_Blend_Green_Thin_Dark", "OUI_Color_Blend_Green_Thin_Light", "OUI_Color_Blend_Red_Regular", "getOUI_Color_Blend_Red_Regular$annotations", "getOUI_Color_Blend_Red_Regular", "OUI_Color_Blend_Red_Regular_Dark", "OUI_Color_Blend_Red_Regular_Light", "OUI_Color_Blend_Red_Thin", "getOUI_Color_Blend_Red_Thin$annotations", "getOUI_Color_Blend_Red_Thin", "OUI_Color_Blend_Red_Thin_Dark", "OUI_Color_Blend_Red_Thin_Light", "OUI_Color_Blend_Text_Primary", "getOUI_Color_Blend_Text_Primary$annotations", "getOUI_Color_Blend_Text_Primary", "OUI_Color_Blend_Text_Primary_Dark", "OUI_Color_Blend_Text_Primary_Light", "OUI_Color_Blend_Text_Secondary", "getOUI_Color_Blend_Text_Secondary$annotations", "getOUI_Color_Blend_Text_Secondary", "OUI_Color_Blend_Text_Secondary_Dark", "OUI_Color_Blend_Text_Secondary_Light", "OUI_Color_Blend_Text_Tertiary", "getOUI_Color_Blend_Text_Tertiary$annotations", "getOUI_Color_Blend_Text_Tertiary", "OUI_Color_Blend_Text_Tertiary_Dark", "OUI_Color_Blend_Text_Tertiary_Light", "OUI_Color_Blend_Yellow_Regular", "getOUI_Color_Blend_Yellow_Regular$annotations", "getOUI_Color_Blend_Yellow_Regular", "OUI_Color_Blend_Yellow_Regular_Dark", "OUI_Color_Blend_Yellow_Regular_Light", "OUI_Color_Blend_Yellow_Thin", "getOUI_Color_Blend_Yellow_Thin$annotations", "getOUI_Color_Blend_Yellow_Thin", "OUI_Color_Blend_Yellow_Thin_Dark", "OUI_Color_Blend_Yellow_Thin_Light", "OUI_Color_Fills_Thick_Dark", "OUI_Color_Fills_Thick_Light", "OUI_Color_State_Active_Dark", "OUI_Color_State_Active_Light", "OUI_Color_State_Press_Dark", "OUI_Color_State_Press_Light", "providers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getProviders", "()Ljava/util/concurrent/ConcurrentHashMap;", "providers$delegate", "Lkotlin/Lazy;", "tokens", "getTokens", "tokens$delegate", "parse", ActivityLifecycle.NAME, "isLight", "(Ljava/lang/String;Z)[Lcom/obric/oui/color/BlendConfig;", "register", "", "customTokenOwner", "overrideExisting", "registerProvider", "registerProviderTokens", "customTokens", "", "registerTokens", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlendToken {
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Base_Regular = null;
    public static final a[] Blend_Base_Regular_Dark = null;
    public static final a[] Blend_Base_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Base_Thick = null;
    public static final a[] Blend_Base_Thick_Dark = null;
    public static final a[] Blend_Base_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Blue_4 = null;
    public static final a[] Blend_Blue_4_Dark = null;
    public static final a[] Blend_Blue_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Blue_6 = null;
    public static final a[] Blend_Blue_6_Dark = null;
    public static final a[] Blend_Blue_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Fill_Element_2 = null;
    public static final a[] Blend_Fill_Element_2_Dark = null;
    public static final a[] Blend_Fill_Element_2_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Fluid_Thin = null;
    public static final a[] Blend_Fluid_Thin_Dark = null;
    public static final a[] Blend_Fluid_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Green_4 = null;
    public static final a[] Blend_Green_4_Dark = null;
    public static final a[] Blend_Green_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Green_6 = null;
    public static final a[] Blend_Green_6_Dark = null;
    public static final a[] Blend_Green_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Red_4 = null;
    public static final a[] Blend_Red_4_Dark = null;
    public static final a[] Blend_Red_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Red_6 = null;
    public static final a[] Blend_Red_6_Dark = null;
    public static final a[] Blend_Red_6_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Yellow_4 = null;
    public static final a[] Blend_Yellow_4_Dark = null;
    public static final a[] Blend_Yellow_4_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> Blend_Yellow_6 = null;
    public static final a[] Blend_Yellow_6_Dark = null;
    public static final a[] Blend_Yellow_6_Light = null;
    public static final BlendToken INSTANCE = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Blue_Regular = null;
    public static final a[] OUI_Color_Blend_Blue_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Blue_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Blue_Thin = null;
    public static final a[] OUI_Color_Blend_Blue_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Blue_Thin_Light = null;
    public static final a[] OUI_Color_Blend_Fill_Tinted_Dark = null;
    public static final a[] OUI_Color_Blend_Fill_Tinted_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Regular = null;
    public static final a[] OUI_Color_Blend_Fluid_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Fluid_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Thick = null;
    public static final a[] OUI_Color_Blend_Fluid_Thick_Dark = null;
    public static final a[] OUI_Color_Blend_Fluid_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Thin = null;
    public static final a[] OUI_Color_Blend_Fluid_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Fluid_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Fluid_UltraThin = null;
    public static final a[] OUI_Color_Blend_Fluid_UltraThin_Dark = null;
    public static final a[] OUI_Color_Blend_Fluid_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Frost_Regular = null;
    public static final a[] OUI_Color_Blend_Frost_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Frost_Regular_Light = null;
    public static final a[] OUI_Color_Blend_Frost_Thick_Dark = null;
    public static final a[] OUI_Color_Blend_Frost_Thick_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Frost_Thin = null;
    public static final a[] OUI_Color_Blend_Frost_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Frost_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Frost_UltraThin = null;
    public static final a[] OUI_Color_Blend_Frost_UltraThin_Dark = null;
    public static final a[] OUI_Color_Blend_Frost_UltraThin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Green_Regular = null;
    public static final a[] OUI_Color_Blend_Green_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Green_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Green_Thin = null;
    public static final a[] OUI_Color_Blend_Green_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Green_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Red_Regular = null;
    public static final a[] OUI_Color_Blend_Red_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Red_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Red_Thin = null;
    public static final a[] OUI_Color_Blend_Red_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Red_Thin_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Text_Primary = null;
    public static final a[] OUI_Color_Blend_Text_Primary_Dark = null;
    public static final a[] OUI_Color_Blend_Text_Primary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Text_Secondary = null;
    public static final a[] OUI_Color_Blend_Text_Secondary_Dark = null;
    public static final a[] OUI_Color_Blend_Text_Secondary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Text_Tertiary = null;
    public static final a[] OUI_Color_Blend_Text_Tertiary_Dark = null;
    public static final a[] OUI_Color_Blend_Text_Tertiary_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Yellow_Regular = null;
    public static final a[] OUI_Color_Blend_Yellow_Regular_Dark = null;
    public static final a[] OUI_Color_Blend_Yellow_Regular_Light = null;
    private static final kotlin.jvm.functions.Function1<Boolean, a[]> OUI_Color_Blend_Yellow_Thin = null;
    public static final a[] OUI_Color_Blend_Yellow_Thin_Dark = null;
    public static final a[] OUI_Color_Blend_Yellow_Thin_Light = null;
    public static final a[] OUI_Color_Fills_Thick_Dark = null;
    public static final a[] OUI_Color_Fills_Thick_Light = null;
    public static final a OUI_Color_State_Active_Dark = null;
    public static final a OUI_Color_State_Active_Light = null;
    public static final a OUI_Color_State_Press_Dark = null;
    public static final a OUI_Color_State_Press_Light = null;
    private static final Lazy providers$delegate = null;
    private static final Lazy tokens$delegate = null;

    static {
        INSTANCE = new BlendToken();
        tokens$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(BlendToken$tokens$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        providers$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(BlendToken$providers$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        Blend_Base_Thick_Light = new a[]{new a(-1726013665, BlendMode.COLOR_DODGE), new a(-604571914, BlendMode.SRC_OVER)};
        Blend_Base_Thick_Dark = new a[]{new a(-3355444, BlendMode.COLOR_BURN), new a(-618388444, BlendMode.SRC_OVER)};
        Blend_Base_Thick = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Base_Thick$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Base_Regular_Light = new a[]{new a(-14737633, BlendMode.COLOR_DODGE), new a(-855638017, BlendMode.SRC_OVER)};
        Blend_Base_Regular_Dark = new a[]{new a(-3355444, BlendMode.COLOR_BURN), new a(-666746302, BlendMode.SRC_OVER)};
        Blend_Base_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Base_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Frost_Regular_Light = new a[]{new a(-14737633, BlendMode.COLOR_DODGE), new a(-855638017, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular_Dark = new a[]{new a(-3355444, BlendMode.COLOR_BURN), new a(-868072894, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Frost_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Fluid_Regular_Light = new a[]{new a(1722987186, BlendMode.LUMINOSITY), new a(-13421773, BlendMode.COLOR_DODGE), new a(872415231, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular_Dark = new a[]{new a(-2137483112, BlendMode.LUMINOSITY), new a(-1716210508, BlendMode.COLOR_BURN), new a(352321535, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Fluid_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Frost_UltraThin_Light = new a[]{new a(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new a[]{new a(-14737633, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Frost_UltraThin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Frost_UltraThin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Fluid_UltraThin_Light = new a[]{new a(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new a[]{new a(-15461356, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Fluid_UltraThin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Fluid_UltraThin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Frost_Thin_Light = new a[]{new a(1722329256, BlendMode.LUMINOSITY), new a(-13421773, BlendMode.COLOR_DODGE), new a(-1711276033, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thin_Dark = new a[]{new a(-2137417319, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Frost_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Frost_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Fluid_Thin_Light = new a[]{new a(869059788, BlendMode.LUMINOSITY), new a(-1724697805, BlendMode.COLOR_DODGE), new a(352321535, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thin_Dark = new a[]{new a(1721342361, BlendMode.LUMINOSITY)};
        OUI_Color_Blend_Fluid_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Fluid_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Frost_Thick_Light = new a[]{new a(-1726013665, BlendMode.COLOR_DODGE), new a(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Frost_Thick_Dark = new a[]{new a(-3355444, BlendMode.COLOR_BURN), new a(-618059479, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Light = new a[]{new a(-1726013665, BlendMode.COLOR_DODGE), new a(-604506121, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick_Dark = new a[]{new a(-858993460, BlendMode.COLOR_BURN), new a(-869717719, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Fluid_Thick = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Fluid_Thick$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Fills_Thick_Light = new a[]{new a(251658240, BlendMode.SRC_OVER)};
        OUI_Color_Fills_Thick_Dark = new a[]{new a(620756991, BlendMode.SRC_OVER)};
        OUI_Color_Blend_Text_Primary_Light = new a[]{new a(-13421773, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Primary_Dark = new a[]{new a(-2500135, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Primary = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Text_Primary$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Text_Secondary_Light = new a[]{new a(-6710887, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Secondary_Dark = new a[]{new a(-9211021, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Secondary = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Text_Secondary$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Text_Tertiary_Light = new a[]{new a(-4342339, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Text_Tertiary_Dark = new a[]{new a(-10921639, BlendMode.PLUS_LIGHTER)};
        OUI_Color_Blend_Text_Tertiary = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Text_Tertiary$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Fill_Tinted_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-1, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Fill_Tinted_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(ViewCompat.MEASURED_STATE_MASK, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-10049793, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Blue_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Blue_Regular_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-14253569, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Blue_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Blue_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Red_Thin_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-30841, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Red_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Red_Regular_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-45747, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Red_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Red_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Green_Thin_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-8917601, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Green_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Green_Regular_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-15415472, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Green_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Green_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Yellow_Thin_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-11671, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Yellow_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_Blend_Yellow_Regular_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-15078, BlendMode.PLUS_DARKER)};
        OUI_Color_Blend_Yellow_Regular = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$OUI_Color_Blend_Yellow_Regular$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        OUI_Color_State_Press_Light = new a(-13421773, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Press_Dark = new a(-1724697805, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Light = new a(-6710887, BlendMode.PLUS_LIGHTER);
        OUI_Color_State_Active_Dark = new a(-6710887, BlendMode.PLUS_LIGHTER);
        Blend_Blue_6_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-15042049, BlendMode.PLUS_DARKER)};
        Blend_Blue_6 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Blue_6$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Blue_4_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-10049793, BlendMode.PLUS_DARKER)};
        Blend_Blue_4 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Blue_4$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Yellow_6_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-873984, BlendMode.PLUS_DARKER)};
        Blend_Yellow_6 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Yellow_6$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Yellow_4_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-11671, BlendMode.PLUS_DARKER)};
        Blend_Yellow_4 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Yellow_4$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Green_6_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-16722873, BlendMode.PLUS_DARKER)};
        Blend_Green_6 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Green_6$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Green_4_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-8917601, BlendMode.PLUS_DARKER)};
        Blend_Green_4 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Green_4$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Red_6_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-53971, BlendMode.PLUS_DARKER)};
        Blend_Red_6 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Red_6$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Red_4_Light = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4_Dark = new a[]{new a(-2130706433, BlendMode.SRC_OVER), new a(-3355444, BlendMode.OVERLAY), new a(-30841, BlendMode.PLUS_DARKER)};
        Blend_Red_4 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Red_4$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Fill_Element_2_Light = new a[]{new a(167772160, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2_Dark = new a[]{new a(536870911, BlendMode.SRC_OVER)};
        Blend_Fill_Element_2 = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Fill_Element_2$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
        Blend_Fluid_Thin_Light = new a[]{new a(-13421773, BlendMode.COLOR_DODGE), new a(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin_Dark = new a[]{new a(-13421773, BlendMode.COLOR_DODGE), new a(1088018905, BlendMode.SRC_OVER)};
        Blend_Fluid_Thin = (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(BlendToken$Blend_Fluid_Thin$1.INSTANCE, kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
    }

    private BlendToken() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Base_Regular() {
        return Blend_Base_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Base_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Base_Thick() {
        return Blend_Base_Thick;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Base_Thick$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Blue_4() {
        return Blend_Blue_4;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Blue_4$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Blue_6() {
        return Blend_Blue_6;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Blue_6$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Fill_Element_2() {
        return Blend_Fill_Element_2;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Fill_Element_2$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Fluid_Thin() {
        return Blend_Fluid_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Fluid_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Green_4() {
        return Blend_Green_4;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Green_4$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Green_6() {
        return Blend_Green_6;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Green_6$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Red_4() {
        return Blend_Red_4;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Red_4$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Red_6() {
        return Blend_Red_6;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Red_6$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Yellow_4() {
        return Blend_Yellow_4;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Yellow_4$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getBlend_Yellow_6() {
        return Blend_Yellow_6;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Yellow_6$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Blue_Regular() {
        return OUI_Color_Blend_Blue_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Blue_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Blue_Thin() {
        return OUI_Color_Blend_Blue_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Blue_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Regular() {
        return OUI_Color_Blend_Fluid_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Thick() {
        return OUI_Color_Blend_Fluid_Thick;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thick$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Thin() {
        return OUI_Color_Blend_Fluid_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_UltraThin() {
        return OUI_Color_Blend_Fluid_UltraThin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_UltraThin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Frost_Regular() {
        return OUI_Color_Blend_Frost_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Frost_Thin() {
        return OUI_Color_Blend_Frost_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Frost_UltraThin() {
        return OUI_Color_Blend_Frost_UltraThin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_UltraThin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Green_Regular() {
        return OUI_Color_Blend_Green_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Green_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Green_Thin() {
        return OUI_Color_Blend_Green_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Green_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Red_Regular() {
        return OUI_Color_Blend_Red_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Red_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Red_Thin() {
        return OUI_Color_Blend_Red_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Red_Thin$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Text_Primary() {
        return OUI_Color_Blend_Text_Primary;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Primary$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Text_Secondary() {
        return OUI_Color_Blend_Text_Secondary;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Secondary$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Text_Tertiary() {
        return OUI_Color_Blend_Text_Tertiary;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Tertiary$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Yellow_Regular() {
        return OUI_Color_Blend_Yellow_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Regular$annotations() {
    }

    public static final kotlin.jvm.functions.Function1<Boolean, a[]> getOUI_Color_Blend_Yellow_Thin() {
        return OUI_Color_Blend_Yellow_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Thin$annotations() {
    }

    private final ConcurrentHashMap<String, kotlin.jvm.functions.Function1<Boolean, a[]>> getProviders() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(providers$delegate.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    private final ConcurrentHashMap<String, a[]> getTokens() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokens$delegate.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final kotlin.jvm.functions.Function1<Boolean, a[]> parse(String r4) {
        return (kotlin.jvm.functions.Function1) ZeusTransformUtils.preCheckCast(n.f14027a.a(r4, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.memorydata.plugin")), kotlin.jvm.functions.Function1.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final a[] parse(String r5, boolean r6) {
        n r0 = n.f14027a;
        BlendToken r1 = INSTANCE;
        if (((a[]) ZeusTransformUtils.preCheckCast(r0.a(r5, (Map) ZeusTransformUtils.preCheckCast(r1.getTokens(), Map.class, "com.obric.memorydata.plugin")), a[].class, "com.obric.memorydata.plugin")) != null) goto L10;
        n r2 = n.f14027a;
        if (r6 == false) goto L7;
        String r7 = "_light";
    L8:
        a[] r8 = (a[]) ZeusTransformUtils.preCheckCast(r2.a(Intrinsics.stringPlus(r5, r7), (Map) ZeusTransformUtils.preCheckCast(r1.getTokens(), Map.class, "com.obric.memorydata.plugin")), a[].class, "com.obric.memorydata.plugin");
        goto L10
    L7:
        r7 = "_dark";
    L10:
        return (a[]) ZeusTransformUtils.preCheckCast(n.f14027a.a(r5, (Map) ZeusTransformUtils.preCheckCast(r1.getTokens(), Map.class, "com.obric.memorydata.plugin")), a[].class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final void register(Object r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "customTokenOwner");
        n r0 = n.f14027a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (a[].class.isAssignableFrom(r8.getType()) == false) goto L4;
        r8.setAccessible(true);     // Catch: Exception -> L11
        Object r9 = r8.get(r12);     // Catch: Exception -> L11
        if ((r9 instanceof a[]) == false) goto L4;
        String r10 = r8.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, "field.name");     // Catch: Exception -> L11
        Locale r11 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r11, "ROOT");     // Catch: Exception -> L11
        String r14 = r10.toLowerCase(r11);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        r4.put(r14, r9);     // Catch: Exception -> L11
    L13:
        r0.a(r1, r4, r13);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r12.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L13
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    @JvmStatic
    public static final void registerProvider(Object r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "customTokenOwner");
        n r0 = n.f14027a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (kotlin.jvm.functions.Function1.class.isAssignableFrom(r8.getType()) == false) goto L4;
        r8.setAccessible(true);     // Catch: Exception -> L11
        Object r10 = r8.get(r12);     // Catch: Exception -> L11
        if (TypeIntrinsics.isFunctionOfArity(r10, 1) == false) goto L4;
        String r9 = r8.getName();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r9, "field.name");     // Catch: Exception -> L11
        Locale r11 = Locale.ROOT;     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r11, "ROOT");     // Catch: Exception -> L11
        String r14 = r9.toLowerCase(r11);     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toLowerCase(locale)");     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r10, EventBody.KEY_VALUE);     // Catch: Exception -> L11
        r4.put(r14, r10);     // Catch: Exception -> L11
    L13:
        r0.a(r1, r4, r13);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r12.getClass().getSimpleName()), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L13
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends kotlin.jvm.functions.Function1<? super Boolean, a[]>> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "customTokens");
        n.f14027a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.memorydata.plugin"), r6, r5);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerProviderTokens(r5, r2);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, a[]> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "customTokens");
        n.f14027a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getTokens(), Map.class, "com.obric.memorydata.plugin"), r6, r5);
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }
}
