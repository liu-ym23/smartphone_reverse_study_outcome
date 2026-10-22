package com.obric.oui.material;

import android.util.Log;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\bt\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u008e\u0001\u001a\u0004\u0018\u00010\n2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\nH\u0007J(\u0010\u0090\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000f\u0010\u0091\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0003\u0010\u0092\u0001J\u0014\u0010\u0093\u0001\u001a\u00020\b2\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0004H\u0007J#\u0010\u0095\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0007J \u0010\u0095\u0001\u001a\u0004\u0018\u00010\n2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\u0097\u0001\u001a\u00020\bH\u0007J)\u0010\u0098\u0001\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00072\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0007J,\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\u0097\u0001\u001a\u00020\bH\u0007¢\u0006\u0003\u0010\u0099\u0001J\u001e\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\bH\u0007J\u001e\u0010\u009e\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\bH\u0007J8\u0010\u009f\u0001\u001a\u00030\u009b\u00012!\u0010 \u0001\u001a\u001c\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00070¡\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\bH\u0007J\u001e\u0010¢\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\bH\u0007J\u001e\u0010£\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\bH\u0007J>\u0010¤\u0001\u001a\u00030\u009b\u00012'\u0010 \u0001\u001a\"\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070¡\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\bH\u0007J2\u0010¥\u0001\u001a\u00030\u009b\u00012\u001b\u0010 \u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0080\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0¡\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\bH\u0007J,\u0010¦\u0001\u001a\u00030\u009b\u00012\u0015\u0010 \u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\n0¡\u00012\t\b\u0002\u0010\u009d\u0001\u001a\u00020\bH\u0007J/\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\u0097\u0001\u001a\u00020\bH\u0000¢\u0006\u0006\b¨\u0001\u0010\u0099\u0001J\r\u0010©\u0001\u001a\u00020\n*\u00020\nH\u0002J\r\u0010ª\u0001\u001a\u00020\n*\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0017\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010&\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010-\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u00102\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u00104\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u00109\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010<\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010>\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010C\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010D\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010E\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR(\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bK\u0010\u0002R\u001e\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u0012\u0004\bM\u0010\u0002R\u0016\u0010N\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bO\u0010\u0002R\u0016\u0010P\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bQ\u0010\u0002R\u0016\u0010R\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bS\u0010\u0002R\u0016\u0010T\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\bU\u0010\u0002R\u001e\u0010V\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u0012\u0004\bW\u0010\u0002R\"\u0010X\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010Z\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010_\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010`\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010a\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010g\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010h\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010i\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010m\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\"\u0010n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010o\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010p\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010s\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010t\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R8\u0010~\u001a\u001b\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u00070\u007f8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R?\u0010\u0085\u0001\u001a!\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\u007f8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0084\u0001\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001R3\u0010\u0088\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u0080\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u007f8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u0084\u0001\u001a\u0006\b\u0089\u0001\u0010\u0082\u0001R-\u0010\u008b\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\n0\u007f8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u0084\u0001\u001a\u0006\b\u008c\u0001\u0010\u0082\u0001¨\u0006«\u0001"}, d2 = {"Lcom/obric/oui/material/MaterialToken;", "", "()V", "MATERIAL_TOKEN_API_LEVEL", "", "MIN_SUPPORTED_MATERIAL_API_LEVEL", "OUI_Bg_Floating", "Lkotlin/Function1;", "", "", "Lcom/obric/oui/material/MaterialConfig;", "OUI_Bg_Floating_Blue", "OUI_Bg_Floating_Blue_Dark", "[Lcom/obric/oui/material/MaterialConfig;", "OUI_Bg_Floating_Blue_Light", "OUI_Bg_Floating_Dark", "OUI_Bg_Floating_Fill", "OUI_Bg_Floating_Fill_Dark", "OUI_Bg_Floating_Fill_Fluid_Dark", "OUI_Bg_Floating_Fill_Fluid_Light", "OUI_Bg_Floating_Fill_Frost_Dark", "OUI_Bg_Floating_Fill_Frost_Light", "OUI_Bg_Floating_Fill_Light", "OUI_Bg_Floating_Fluid_Blue_Dark", "OUI_Bg_Floating_Fluid_Blue_Light", "OUI_Bg_Floating_Fluid_Dark", "OUI_Bg_Floating_Fluid_Light", "OUI_Bg_Floating_Fluid_Tinted_Dark", "OUI_Bg_Floating_Fluid_Tinted_Light", "OUI_Bg_Floating_Frost_Blue_Dark", "OUI_Bg_Floating_Frost_Blue_Light", "OUI_Bg_Floating_Frost_Dark", "OUI_Bg_Floating_Frost_Light", "OUI_Bg_Floating_Frost_Tinted_Dark", "OUI_Bg_Floating_Frost_Tinted_Light", "OUI_Bg_Floating_Light", "OUI_Bg_Floating_OnImage", "OUI_Bg_Floating_OnImage_Dark", "OUI_Bg_Floating_OnImage_Fluid_Dark", "OUI_Bg_Floating_OnImage_Fluid_Light", "OUI_Bg_Floating_OnImage_Frost_Dark", "OUI_Bg_Floating_OnImage_Frost_Light", "OUI_Bg_Floating_OnImage_Light", "OUI_Bg_Floating_Overlay", "OUI_Bg_Floating_Overlay_Dark", "OUI_Bg_Floating_Overlay_Fluid_Dark", "OUI_Bg_Floating_Overlay_Fluid_Light", "OUI_Bg_Floating_Overlay_Frost_Dark", "OUI_Bg_Floating_Overlay_Frost_Light", "OUI_Bg_Floating_Overlay_Light", "OUI_Bg_Floating_Ring", "OUI_Bg_Floating_Ring_Dark", "OUI_Bg_Floating_Ring_Fluid_Dark", "OUI_Bg_Floating_Ring_Fluid_Light", "OUI_Bg_Floating_Ring_Frost_Dark", "OUI_Bg_Floating_Ring_Frost_Light", "OUI_Bg_Floating_Ring_Light", "OUI_Bg_Floating_Tinted", "OUI_Bg_Floating_Tinted_Dark", "OUI_Bg_Floating_Tinted_Light", "OUI_Bg_Modal", "OUI_Bg_Modal_Dark", "OUI_Bg_Modal_Fluid_Dark", "OUI_Bg_Modal_Fluid_Light", "OUI_Bg_Modal_Frost_Dark", "OUI_Bg_Modal_Frost_Light", "OUI_Bg_Modal_Light", "OUI_Bg_Modal_Variant", "OUI_Bg_Modal_Variant_Dark", "OUI_Bg_Modal_Variant_Fluid_Dark", "OUI_Bg_Modal_Variant_Fluid_Light", "OUI_Bg_Modal_Variant_Frost_Dark", "OUI_Bg_Modal_Variant_Frost_Light", "OUI_Bg_Modal_Variant_Light", "OUI_Bg_Overlay_Search", "getOUI_Bg_Overlay_Search$annotations", "OUI_Bg_Overlay_Search_Dark", "getOUI_Bg_Overlay_Search_Dark$annotations", "OUI_Bg_Overlay_Search_Fluid_Dark", "getOUI_Bg_Overlay_Search_Fluid_Dark$annotations", "OUI_Bg_Overlay_Search_Fluid_Light", "getOUI_Bg_Overlay_Search_Fluid_Light$annotations", "OUI_Bg_Overlay_Search_Frost_Dark", "getOUI_Bg_Overlay_Search_Frost_Dark$annotations", "OUI_Bg_Overlay_Search_Frost_Light", "getOUI_Bg_Overlay_Search_Frost_Light$annotations", "OUI_Bg_Overlay_Search_Light", "getOUI_Bg_Overlay_Search_Light$annotations", "OUI_Bg_Popup", "OUI_Bg_Popup_Dark", "OUI_Bg_Popup_Fluid_Dark", "OUI_Bg_Popup_Fluid_Light", "OUI_Bg_Popup_Frost", "OUI_Bg_Popup_Frost_Dark", "OUI_Bg_Popup_Frost_Light", "OUI_Bg_Popup_Light", "OUI_Bg_Popup_OnImage", "OUI_Bg_Popup_OnImage_Dark", "OUI_Bg_Popup_OnImage_Fluid_Dark", "OUI_Bg_Popup_OnImage_Fluid_Light", "OUI_Bg_Popup_OnImage_Frost_Dark", "OUI_Bg_Popup_OnImage_Frost_Light", "OUI_Bg_Popup_OnImage_Light", "OUI_Bg_Popup_Overlay", "OUI_Bg_Popup_Overlay_Dark", "OUI_Bg_Popup_Overlay_Fluid_Dark", "OUI_Bg_Popup_Overlay_Fluid_Light", "OUI_Bg_Popup_Overlay_Frost_Dark", "OUI_Bg_Popup_Overlay_Frost_Light", "OUI_Bg_Popup_Overlay_Light", "OUI_Bg_Scrim", "OUI_Bg_Scrim_Dark", "OUI_Bg_Scrim_Fluid_Dark", "OUI_Bg_Scrim_Fluid_Light", "OUI_Bg_Scrim_Frost_Dark", "OUI_Bg_Scrim_Frost_Light", "OUI_Bg_Scrim_Light", "OUI_Text_Primary", "OUI_Text_Primary_Dark", "OUI_Text_Primary_Light", "OUI_Text_Secondary", "OUI_Text_Secondary_Dark", "OUI_Text_Secondary_Light", "OUI_Text_Tertiary", "OUI_Text_Tertiary_Dark", "OUI_Text_Tertiary_Light", "providers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getProviders", "()Ljava/util/concurrent/ConcurrentHashMap;", "providers$delegate", "Lkotlin/Lazy;", "setProviders", "getSetProviders", "setProviders$delegate", "tokenSets", "getTokenSets", "tokenSets$delegate", "tokens", "getTokens", "tokens$delegate", "compatibleConfig", "config", "compatibleConfigArray", "configs", "([Lcom/obric/oui/material/MaterialConfig;)[Lcom/obric/oui/material/MaterialConfig;", "isApiCompatible", "requiredApiLevel", "parse", ActivityLifecycle.NAME, "isLight", "parseSet", "(Ljava/lang/String;Z)[Lcom/obric/oui/material/MaterialConfig;", "register", "", "customTokenOwner", "overrideExisting", "registerProvider", "registerProviderTokens", "customTokens", "", "registerSet", "registerSetProvider", "registerSetProviderTokens", "registerTokenSets", "registerTokens", "resolveTokenForBuilder", "resolveTokenForBuilder$OUI_standardRelease", "toApi3CompatibleConfig", "toLegacyCompatibleConfig", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialToken {
    public static final MaterialToken INSTANCE = null;
    public static final int MATERIAL_TOKEN_API_LEVEL = 4;
    public static final int MIN_SUPPORTED_MATERIAL_API_LEVEL = 1;
    public static final Function1<Boolean, c[]> OUI_Bg_Floating = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Blue = null;
    public static final c[] OUI_Bg_Floating_Blue_Dark = null;
    public static final c[] OUI_Bg_Floating_Blue_Light = null;
    public static final c[] OUI_Bg_Floating_Dark = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Fill = null;
    public static final c[] OUI_Bg_Floating_Fill_Dark = null;
    public static final c OUI_Bg_Floating_Fill_Fluid_Dark = null;
    public static final c OUI_Bg_Floating_Fill_Fluid_Light = null;
    public static final c OUI_Bg_Floating_Fill_Frost_Dark = null;
    public static final c OUI_Bg_Floating_Fill_Frost_Light = null;
    public static final c[] OUI_Bg_Floating_Fill_Light = null;
    public static final c OUI_Bg_Floating_Fluid_Blue_Dark = null;
    public static final c OUI_Bg_Floating_Fluid_Blue_Light = null;
    public static final c OUI_Bg_Floating_Fluid_Dark = null;
    public static final c OUI_Bg_Floating_Fluid_Light = null;
    public static final c OUI_Bg_Floating_Fluid_Tinted_Dark = null;
    public static final c OUI_Bg_Floating_Fluid_Tinted_Light = null;
    public static final c OUI_Bg_Floating_Frost_Blue_Dark = null;
    public static final c OUI_Bg_Floating_Frost_Blue_Light = null;
    public static final c OUI_Bg_Floating_Frost_Dark = null;
    public static final c OUI_Bg_Floating_Frost_Light = null;
    public static final c OUI_Bg_Floating_Frost_Tinted_Dark = null;
    public static final c OUI_Bg_Floating_Frost_Tinted_Light = null;
    public static final c[] OUI_Bg_Floating_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_OnImage = null;
    public static final c[] OUI_Bg_Floating_OnImage_Dark = null;
    public static final c OUI_Bg_Floating_OnImage_Fluid_Dark = null;
    public static final c OUI_Bg_Floating_OnImage_Fluid_Light = null;
    public static final c OUI_Bg_Floating_OnImage_Frost_Dark = null;
    public static final c OUI_Bg_Floating_OnImage_Frost_Light = null;
    public static final c[] OUI_Bg_Floating_OnImage_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Overlay = null;
    public static final c[] OUI_Bg_Floating_Overlay_Dark = null;
    public static final c OUI_Bg_Floating_Overlay_Fluid_Dark = null;
    public static final c OUI_Bg_Floating_Overlay_Fluid_Light = null;
    public static final c OUI_Bg_Floating_Overlay_Frost_Dark = null;
    public static final c OUI_Bg_Floating_Overlay_Frost_Light = null;
    public static final c[] OUI_Bg_Floating_Overlay_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Ring = null;
    public static final c[] OUI_Bg_Floating_Ring_Dark = null;
    public static final c OUI_Bg_Floating_Ring_Fluid_Dark = null;
    public static final c OUI_Bg_Floating_Ring_Fluid_Light = null;
    public static final c OUI_Bg_Floating_Ring_Frost_Dark = null;
    public static final c OUI_Bg_Floating_Ring_Frost_Light = null;
    public static final c[] OUI_Bg_Floating_Ring_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Tinted = null;
    public static final c[] OUI_Bg_Floating_Tinted_Dark = null;
    public static final c[] OUI_Bg_Floating_Tinted_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Modal = null;
    public static final c[] OUI_Bg_Modal_Dark = null;
    public static final c OUI_Bg_Modal_Fluid_Dark = null;
    public static final c OUI_Bg_Modal_Fluid_Light = null;
    public static final c OUI_Bg_Modal_Frost_Dark = null;
    public static final c OUI_Bg_Modal_Frost_Light = null;
    public static final c[] OUI_Bg_Modal_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Modal_Variant = null;
    public static final c[] OUI_Bg_Modal_Variant_Dark = null;
    public static final c OUI_Bg_Modal_Variant_Fluid_Dark = null;
    public static final c OUI_Bg_Modal_Variant_Fluid_Light = null;
    public static final c OUI_Bg_Modal_Variant_Frost_Dark = null;
    public static final c OUI_Bg_Modal_Variant_Frost_Light = null;
    public static final c[] OUI_Bg_Modal_Variant_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Overlay_Search = null;
    public static final c[] OUI_Bg_Overlay_Search_Dark = null;
    public static final c OUI_Bg_Overlay_Search_Fluid_Dark = null;
    public static final c OUI_Bg_Overlay_Search_Fluid_Light = null;
    public static final c OUI_Bg_Overlay_Search_Frost_Dark = null;
    public static final c OUI_Bg_Overlay_Search_Frost_Light = null;
    public static final c[] OUI_Bg_Overlay_Search_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Popup = null;
    public static final c[] OUI_Bg_Popup_Dark = null;
    public static final c OUI_Bg_Popup_Fluid_Dark = null;
    public static final c OUI_Bg_Popup_Fluid_Light = null;
    public static final Function1<Boolean, c> OUI_Bg_Popup_Frost = null;
    public static final c OUI_Bg_Popup_Frost_Dark = null;
    public static final c OUI_Bg_Popup_Frost_Light = null;
    public static final c[] OUI_Bg_Popup_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Popup_OnImage = null;
    public static final c[] OUI_Bg_Popup_OnImage_Dark = null;
    public static final c OUI_Bg_Popup_OnImage_Fluid_Dark = null;
    public static final c OUI_Bg_Popup_OnImage_Fluid_Light = null;
    public static final c OUI_Bg_Popup_OnImage_Frost_Dark = null;
    public static final c OUI_Bg_Popup_OnImage_Frost_Light = null;
    public static final c[] OUI_Bg_Popup_OnImage_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Popup_Overlay = null;
    public static final c[] OUI_Bg_Popup_Overlay_Dark = null;
    public static final c OUI_Bg_Popup_Overlay_Fluid_Dark = null;
    public static final c OUI_Bg_Popup_Overlay_Fluid_Light = null;
    public static final c OUI_Bg_Popup_Overlay_Frost_Dark = null;
    public static final c OUI_Bg_Popup_Overlay_Frost_Light = null;
    public static final c[] OUI_Bg_Popup_Overlay_Light = null;
    public static final Function1<Boolean, c[]> OUI_Bg_Scrim = null;
    public static final c[] OUI_Bg_Scrim_Dark = null;
    public static final c OUI_Bg_Scrim_Fluid_Dark = null;
    public static final c OUI_Bg_Scrim_Fluid_Light = null;
    public static final c OUI_Bg_Scrim_Frost_Dark = null;
    public static final c OUI_Bg_Scrim_Frost_Light = null;
    public static final c[] OUI_Bg_Scrim_Light = null;
    public static final Function1<Boolean, c> OUI_Text_Primary = null;
    public static final c OUI_Text_Primary_Dark = null;
    public static final c OUI_Text_Primary_Light = null;
    public static final Function1<Boolean, c> OUI_Text_Secondary = null;
    public static final c OUI_Text_Secondary_Dark = null;
    public static final c OUI_Text_Secondary_Light = null;
    public static final Function1<Boolean, c> OUI_Text_Tertiary = null;
    public static final c OUI_Text_Tertiary_Dark = null;
    public static final c OUI_Text_Tertiary_Light = null;
    private static final Lazy providers$delegate = null;
    private static final Lazy setProviders$delegate = null;
    private static final Lazy tokenSets$delegate = null;
    private static final Lazy tokens$delegate = null;

    /* JADX INFO: renamed from: com.obric.oui.material.MaterialToken$compatibleConfigArray$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<c, c> {
        AnonymousClass1(Object r8) {
            super(1, r8, MaterialToken.class, "compatibleConfig", "compatibleConfig(Lcom/obric/oui/material/MaterialConfig;)Lcom/obric/oui/material/MaterialConfig;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final c invoke2(c r1) {
            return MaterialToken.compatibleConfig(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ c invoke(c r3) {
            return invoke2((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        INSTANCE = new MaterialToken();
        tokens$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MaterialToken$tokens$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        tokenSets$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MaterialToken$tokenSets$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        providers$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MaterialToken$providers$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        setProviders$delegate = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(MaterialToken$setProviders$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        e r0 = MaterialTokenCore.OUI_Bg_Floating_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r0, "OUI_Bg_Floating_Frost_Light");
        OUI_Bg_Floating_Frost_Light = f.a(r0);
        e r1 = MaterialTokenCore.OUI_Bg_Floating_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r1, "OUI_Bg_Floating_Frost_Dark");
        OUI_Bg_Floating_Frost_Dark = f.a(r1);
        e r2 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r2, "OUI_Bg_Floating_Fluid_Light");
        OUI_Bg_Floating_Fluid_Light = f.a(r2);
        e r3 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r3, "OUI_Bg_Floating_Fluid_Dark");
        OUI_Bg_Floating_Fluid_Dark = f.a(r3);
        e[] r4 = MaterialTokenCore.OUI_Bg_Floating_Light;
        Intrinsics.checkNotNullExpressionValue(r4, "OUI_Bg_Floating_Light");
        OUI_Bg_Floating_Light = f.a(r4);
        e[] r5 = MaterialTokenCore.OUI_Bg_Floating_Dark;
        Intrinsics.checkNotNullExpressionValue(r5, "OUI_Bg_Floating_Dark");
        OUI_Bg_Floating_Dark = f.a(r5);
        OUI_Bg_Floating = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Floating$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r6 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r6, "OUI_Bg_Floating_OnImage_Frost_Light");
        OUI_Bg_Floating_OnImage_Frost_Light = f.a(r6);
        e r7 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r7, "OUI_Bg_Floating_OnImage_Frost_Dark");
        OUI_Bg_Floating_OnImage_Frost_Dark = f.a(r7);
        e r8 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r8, "OUI_Bg_Floating_OnImage_Fluid_Light");
        OUI_Bg_Floating_OnImage_Fluid_Light = f.a(r8);
        e r9 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r9, "OUI_Bg_Floating_OnImage_Fluid_Dark");
        OUI_Bg_Floating_OnImage_Fluid_Dark = f.a(r9);
        e[] r10 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Light;
        Intrinsics.checkNotNullExpressionValue(r10, "OUI_Bg_Floating_OnImage_Light");
        OUI_Bg_Floating_OnImage_Light = f.a(r10);
        e[] r11 = MaterialTokenCore.OUI_Bg_Floating_OnImage_Dark;
        Intrinsics.checkNotNullExpressionValue(r11, "OUI_Bg_Floating_OnImage_Dark");
        OUI_Bg_Floating_OnImage_Dark = f.a(r11);
        OUI_Bg_Floating_OnImage = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Floating_OnImage$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r12 = MaterialTokenCore.OUI_Bg_Floating_Fill_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r12, "OUI_Bg_Floating_Fill_Frost_Light");
        OUI_Bg_Floating_Fill_Frost_Light = f.a(r12);
        e r13 = MaterialTokenCore.OUI_Bg_Floating_Fill_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r13, "OUI_Bg_Floating_Fill_Frost_Dark");
        OUI_Bg_Floating_Fill_Frost_Dark = f.a(r13);
        e r14 = MaterialTokenCore.OUI_Bg_Floating_Fill_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r14, "OUI_Bg_Floating_Fill_Fluid_Light");
        OUI_Bg_Floating_Fill_Fluid_Light = f.a(r14);
        e r15 = MaterialTokenCore.OUI_Bg_Floating_Fill_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r15, "OUI_Bg_Floating_Fill_Fluid_Dark");
        OUI_Bg_Floating_Fill_Fluid_Dark = f.a(r15);
        e[] r16 = MaterialTokenCore.OUI_Bg_Floating_Fill_Light;
        Intrinsics.checkNotNullExpressionValue(r16, "OUI_Bg_Floating_Fill_Light");
        OUI_Bg_Floating_Fill_Light = f.a(r16);
        e[] r17 = MaterialTokenCore.OUI_Bg_Floating_Fill_Dark;
        Intrinsics.checkNotNullExpressionValue(r17, "OUI_Bg_Floating_Fill_Dark");
        OUI_Bg_Floating_Fill_Dark = f.a(r17);
        OUI_Bg_Floating_Fill = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Floating_Fill$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r18 = MaterialTokenCore.OUI_Bg_Popup_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r18, "OUI_Bg_Popup_Frost_Light");
        OUI_Bg_Popup_Frost_Light = f.a(r18);
        e r19 = MaterialTokenCore.OUI_Bg_Popup_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r19, "OUI_Bg_Popup_Frost_Dark");
        OUI_Bg_Popup_Frost_Dark = f.a(r19);
        OUI_Bg_Popup_Frost = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Popup_Frost$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r20 = MaterialTokenCore.OUI_Bg_Popup_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r20, "OUI_Bg_Popup_Fluid_Light");
        OUI_Bg_Popup_Fluid_Light = f.a(r20);
        e r21 = MaterialTokenCore.OUI_Bg_Popup_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r21, "OUI_Bg_Popup_Fluid_Dark");
        OUI_Bg_Popup_Fluid_Dark = f.a(r21);
        e[] r22 = MaterialTokenCore.OUI_Bg_Popup_Light;
        Intrinsics.checkNotNullExpressionValue(r22, "OUI_Bg_Popup_Light");
        OUI_Bg_Popup_Light = f.a(r22);
        e[] r23 = MaterialTokenCore.OUI_Bg_Popup_Dark;
        Intrinsics.checkNotNullExpressionValue(r23, "OUI_Bg_Popup_Dark");
        OUI_Bg_Popup_Dark = f.a(r23);
        OUI_Bg_Popup = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Popup$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r24 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r24, "OUI_Bg_Popup_OnImage_Frost_Light");
        OUI_Bg_Popup_OnImage_Frost_Light = f.a(r24);
        e r25 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r25, "OUI_Bg_Popup_OnImage_Frost_Dark");
        OUI_Bg_Popup_OnImage_Frost_Dark = f.a(r25);
        e r26 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r26, "OUI_Bg_Popup_OnImage_Fluid_Light");
        OUI_Bg_Popup_OnImage_Fluid_Light = f.a(r26);
        e r27 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r27, "OUI_Bg_Popup_OnImage_Fluid_Dark");
        OUI_Bg_Popup_OnImage_Fluid_Dark = f.a(r27);
        e[] r28 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Light;
        Intrinsics.checkNotNullExpressionValue(r28, "OUI_Bg_Popup_OnImage_Light");
        OUI_Bg_Popup_OnImage_Light = f.a(r28);
        e[] r29 = MaterialTokenCore.OUI_Bg_Popup_OnImage_Dark;
        Intrinsics.checkNotNullExpressionValue(r29, "OUI_Bg_Popup_OnImage_Dark");
        OUI_Bg_Popup_OnImage_Dark = f.a(r29);
        OUI_Bg_Popup_OnImage = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Popup_OnImage$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r30 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r30, "OUI_Bg_Popup_Overlay_Frost_Light");
        OUI_Bg_Popup_Overlay_Frost_Light = f.a(r30);
        e r31 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r31, "OUI_Bg_Popup_Overlay_Frost_Dark");
        OUI_Bg_Popup_Overlay_Frost_Dark = f.a(r31);
        e r32 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r32, "OUI_Bg_Popup_Overlay_Fluid_Light");
        OUI_Bg_Popup_Overlay_Fluid_Light = f.a(r32);
        e r33 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r33, "OUI_Bg_Popup_Overlay_Fluid_Dark");
        OUI_Bg_Popup_Overlay_Fluid_Dark = f.a(r33);
        e[] r34 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Light;
        Intrinsics.checkNotNullExpressionValue(r34, "OUI_Bg_Popup_Overlay_Light");
        OUI_Bg_Popup_Overlay_Light = f.a(r34);
        e[] r35 = MaterialTokenCore.OUI_Bg_Popup_Overlay_Dark;
        Intrinsics.checkNotNullExpressionValue(r35, "OUI_Bg_Popup_Overlay_Dark");
        OUI_Bg_Popup_Overlay_Dark = f.a(r35);
        OUI_Bg_Popup_Overlay = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Popup_Overlay$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r36 = MaterialTokenCore.OUI_Bg_Modal_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r36, "OUI_Bg_Modal_Frost_Light");
        OUI_Bg_Modal_Frost_Light = f.a(r36);
        e r37 = MaterialTokenCore.OUI_Bg_Modal_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r37, "OUI_Bg_Modal_Frost_Dark");
        OUI_Bg_Modal_Frost_Dark = f.a(r37);
        e r38 = MaterialTokenCore.OUI_Bg_Modal_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r38, "OUI_Bg_Modal_Fluid_Light");
        OUI_Bg_Modal_Fluid_Light = f.a(r38);
        e r39 = MaterialTokenCore.OUI_Bg_Modal_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r39, "OUI_Bg_Modal_Fluid_Dark");
        OUI_Bg_Modal_Fluid_Dark = f.a(r39);
        e[] r40 = MaterialTokenCore.OUI_Bg_Modal_Light;
        Intrinsics.checkNotNullExpressionValue(r40, "OUI_Bg_Modal_Light");
        OUI_Bg_Modal_Light = f.a(r40);
        e[] r41 = MaterialTokenCore.OUI_Bg_Modal_Dark;
        Intrinsics.checkNotNullExpressionValue(r41, "OUI_Bg_Modal_Dark");
        OUI_Bg_Modal_Dark = f.a(r41);
        OUI_Bg_Modal = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Modal$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r42 = MaterialTokenCore.OUI_Bg_Modal_Variant_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r42, "OUI_Bg_Modal_Variant_Frost_Light");
        OUI_Bg_Modal_Variant_Frost_Light = f.a(r42);
        e r43 = MaterialTokenCore.OUI_Bg_Modal_Variant_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r43, "OUI_Bg_Modal_Variant_Frost_Dark");
        OUI_Bg_Modal_Variant_Frost_Dark = f.a(r43);
        e r44 = MaterialTokenCore.OUI_Bg_Modal_Variant_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r44, "OUI_Bg_Modal_Variant_Fluid_Light");
        OUI_Bg_Modal_Variant_Fluid_Light = f.a(r44);
        e r45 = MaterialTokenCore.OUI_Bg_Modal_Variant_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r45, "OUI_Bg_Modal_Variant_Fluid_Dark");
        OUI_Bg_Modal_Variant_Fluid_Dark = f.a(r45);
        e[] r46 = MaterialTokenCore.OUI_Bg_Modal_Variant_Light;
        Intrinsics.checkNotNullExpressionValue(r46, "OUI_Bg_Modal_Variant_Light");
        OUI_Bg_Modal_Variant_Light = f.a(r46);
        e[] r47 = MaterialTokenCore.OUI_Bg_Modal_Variant_Dark;
        Intrinsics.checkNotNullExpressionValue(r47, "OUI_Bg_Modal_Variant_Dark");
        OUI_Bg_Modal_Variant_Dark = f.a(r47);
        OUI_Bg_Modal_Variant = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Modal_Variant$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r48 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r48, "OUI_Bg_Floating_Overlay_Frost_Light");
        OUI_Bg_Floating_Overlay_Frost_Light = f.a(r48);
        e r49 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r49, "OUI_Bg_Floating_Overlay_Frost_Dark");
        OUI_Bg_Floating_Overlay_Frost_Dark = f.a(r49);
        e r50 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r50, "OUI_Bg_Floating_Overlay_Fluid_Light");
        OUI_Bg_Floating_Overlay_Fluid_Light = f.a(r50);
        e r51 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r51, "OUI_Bg_Floating_Overlay_Fluid_Dark");
        OUI_Bg_Floating_Overlay_Fluid_Dark = f.a(r51);
        e[] r52 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Light;
        Intrinsics.checkNotNullExpressionValue(r52, "OUI_Bg_Floating_Overlay_Light");
        OUI_Bg_Floating_Overlay_Light = f.a(r52);
        e[] r53 = MaterialTokenCore.OUI_Bg_Floating_Overlay_Dark;
        Intrinsics.checkNotNullExpressionValue(r53, "OUI_Bg_Floating_Overlay_Dark");
        OUI_Bg_Floating_Overlay_Dark = f.a(r53);
        OUI_Bg_Floating_Overlay = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Floating_Overlay$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r54 = MaterialTokenCore.OUI_Bg_Scrim_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r54, "OUI_Bg_Scrim_Frost_Light");
        OUI_Bg_Scrim_Frost_Light = f.a(r54);
        e r55 = MaterialTokenCore.OUI_Bg_Scrim_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r55, "OUI_Bg_Scrim_Frost_Dark");
        OUI_Bg_Scrim_Frost_Dark = f.a(r55);
        e r56 = MaterialTokenCore.OUI_Bg_Scrim_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r56, "OUI_Bg_Scrim_Fluid_Light");
        OUI_Bg_Scrim_Fluid_Light = f.a(r56);
        e r57 = MaterialTokenCore.OUI_Bg_Scrim_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r57, "OUI_Bg_Scrim_Fluid_Dark");
        OUI_Bg_Scrim_Fluid_Dark = f.a(r57);
        e[] r58 = MaterialTokenCore.OUI_Bg_Scrim_Light;
        Intrinsics.checkNotNullExpressionValue(r58, "OUI_Bg_Scrim_Light");
        OUI_Bg_Scrim_Light = f.a(r58);
        e[] r59 = MaterialTokenCore.OUI_Bg_Scrim_Dark;
        Intrinsics.checkNotNullExpressionValue(r59, "OUI_Bg_Scrim_Dark");
        OUI_Bg_Scrim_Dark = f.a(r59);
        OUI_Bg_Scrim = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Scrim$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r60 = MaterialTokenCore.OUI_Bg_Floating_Ring_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r60, "OUI_Bg_Floating_Ring_Frost_Light");
        OUI_Bg_Floating_Ring_Frost_Light = f.a(r60);
        e r61 = MaterialTokenCore.OUI_Bg_Floating_Ring_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r61, "OUI_Bg_Floating_Ring_Frost_Dark");
        OUI_Bg_Floating_Ring_Frost_Dark = f.a(r61);
        e r62 = MaterialTokenCore.OUI_Bg_Floating_Ring_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r62, "OUI_Bg_Floating_Ring_Fluid_Light");
        OUI_Bg_Floating_Ring_Fluid_Light = f.a(r62);
        e r63 = MaterialTokenCore.OUI_Bg_Floating_Ring_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r63, "OUI_Bg_Floating_Ring_Fluid_Dark");
        OUI_Bg_Floating_Ring_Fluid_Dark = f.a(r63);
        e[] r64 = MaterialTokenCore.OUI_Bg_Floating_Ring_Light;
        Intrinsics.checkNotNullExpressionValue(r64, "OUI_Bg_Floating_Ring_Light");
        OUI_Bg_Floating_Ring_Light = f.a(r64);
        e[] r65 = MaterialTokenCore.OUI_Bg_Floating_Ring_Dark;
        Intrinsics.checkNotNullExpressionValue(r65, "OUI_Bg_Floating_Ring_Dark");
        OUI_Bg_Floating_Ring_Dark = f.a(r65);
        OUI_Bg_Floating_Ring = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Floating_Ring$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r66 = MaterialTokenCore.OUI_Bg_Overlay_Search_Frost_Light;
        Intrinsics.checkNotNullExpressionValue(r66, "OUI_Bg_Overlay_Search_Frost_Light");
        OUI_Bg_Overlay_Search_Frost_Light = f.a(r66);
        e r67 = MaterialTokenCore.OUI_Bg_Overlay_Search_Frost_Dark;
        Intrinsics.checkNotNullExpressionValue(r67, "OUI_Bg_Overlay_Search_Frost_Dark");
        OUI_Bg_Overlay_Search_Frost_Dark = f.a(r67);
        e r68 = MaterialTokenCore.OUI_Bg_Overlay_Search_Fluid_Light;
        Intrinsics.checkNotNullExpressionValue(r68, "OUI_Bg_Overlay_Search_Fluid_Light");
        OUI_Bg_Overlay_Search_Fluid_Light = f.a(r68);
        e r69 = MaterialTokenCore.OUI_Bg_Overlay_Search_Fluid_Dark;
        Intrinsics.checkNotNullExpressionValue(r69, "OUI_Bg_Overlay_Search_Fluid_Dark");
        OUI_Bg_Overlay_Search_Fluid_Dark = f.a(r69);
        e[] r70 = MaterialTokenCore.OUI_Bg_Overlay_Search_Light;
        Intrinsics.checkNotNullExpressionValue(r70, "OUI_Bg_Overlay_Search_Light");
        OUI_Bg_Overlay_Search_Light = f.a(r70);
        e[] r71 = MaterialTokenCore.OUI_Bg_Overlay_Search_Dark;
        Intrinsics.checkNotNullExpressionValue(r71, "OUI_Bg_Overlay_Search_Dark");
        OUI_Bg_Overlay_Search_Dark = f.a(r71);
        OUI_Bg_Overlay_Search = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Overlay_Search$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r72 = MaterialTokenCore.OUI_Bg_Floating_Frost_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r72, "OUI_Bg_Floating_Frost_Tinted_Light");
        OUI_Bg_Floating_Frost_Tinted_Light = f.a(r72);
        e r73 = MaterialTokenCore.OUI_Bg_Floating_Frost_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r73, "OUI_Bg_Floating_Frost_Tinted_Dark");
        OUI_Bg_Floating_Frost_Tinted_Dark = f.a(r73);
        e r74 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r74, "OUI_Bg_Floating_Fluid_Tinted_Light");
        OUI_Bg_Floating_Fluid_Tinted_Light = f.a(r74);
        e r75 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r75, "OUI_Bg_Floating_Fluid_Tinted_Dark");
        OUI_Bg_Floating_Fluid_Tinted_Dark = f.a(r75);
        e[] r76 = MaterialTokenCore.OUI_Bg_Floating_Tinted_Light;
        Intrinsics.checkNotNullExpressionValue(r76, "OUI_Bg_Floating_Tinted_Light");
        OUI_Bg_Floating_Tinted_Light = f.a(r76);
        e[] r77 = MaterialTokenCore.OUI_Bg_Floating_Tinted_Dark;
        Intrinsics.checkNotNullExpressionValue(r77, "OUI_Bg_Floating_Tinted_Dark");
        OUI_Bg_Floating_Tinted_Dark = f.a(r77);
        OUI_Bg_Floating_Tinted = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Floating_Tinted$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r78 = MaterialTokenCore.OUI_Bg_Floating_Frost_Blue_Light;
        Intrinsics.checkNotNullExpressionValue(r78, "OUI_Bg_Floating_Frost_Blue_Light");
        OUI_Bg_Floating_Frost_Blue_Light = f.a(r78);
        e r79 = MaterialTokenCore.OUI_Bg_Floating_Frost_Blue_Dark;
        Intrinsics.checkNotNullExpressionValue(r79, "OUI_Bg_Floating_Frost_Blue_Dark");
        OUI_Bg_Floating_Frost_Blue_Dark = f.a(r79);
        e r80 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Blue_Light;
        Intrinsics.checkNotNullExpressionValue(r80, "OUI_Bg_Floating_Fluid_Blue_Light");
        OUI_Bg_Floating_Fluid_Blue_Light = f.a(r80);
        e r81 = MaterialTokenCore.OUI_Bg_Floating_Fluid_Blue_Dark;
        Intrinsics.checkNotNullExpressionValue(r81, "OUI_Bg_Floating_Fluid_Blue_Dark");
        OUI_Bg_Floating_Fluid_Blue_Dark = f.a(r81);
        e[] r82 = MaterialTokenCore.OUI_Bg_Floating_Blue_Light;
        Intrinsics.checkNotNullExpressionValue(r82, "OUI_Bg_Floating_Blue_Light");
        OUI_Bg_Floating_Blue_Light = f.a(r82);
        e[] r83 = MaterialTokenCore.OUI_Bg_Floating_Blue_Dark;
        Intrinsics.checkNotNullExpressionValue(r83, "OUI_Bg_Floating_Blue_Dark");
        OUI_Bg_Floating_Blue_Dark = f.a(r83);
        OUI_Bg_Floating_Blue = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Bg_Floating_Blue$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r84 = MaterialTokenCore.OUI_Text_Primary_Light;
        Intrinsics.checkNotNullExpressionValue(r84, "OUI_Text_Primary_Light");
        OUI_Text_Primary_Light = f.a(r84);
        e r85 = MaterialTokenCore.OUI_Text_Primary_Dark;
        Intrinsics.checkNotNullExpressionValue(r85, "OUI_Text_Primary_Dark");
        OUI_Text_Primary_Dark = f.a(r85);
        OUI_Text_Primary = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Text_Primary$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r86 = MaterialTokenCore.OUI_Text_Secondary_Light;
        Intrinsics.checkNotNullExpressionValue(r86, "OUI_Text_Secondary_Light");
        OUI_Text_Secondary_Light = f.a(r86);
        e r87 = MaterialTokenCore.OUI_Text_Secondary_Dark;
        Intrinsics.checkNotNullExpressionValue(r87, "OUI_Text_Secondary_Dark");
        OUI_Text_Secondary_Dark = f.a(r87);
        OUI_Text_Secondary = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Text_Secondary$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        e r88 = MaterialTokenCore.OUI_Text_Tertiary_Light;
        Intrinsics.checkNotNullExpressionValue(r88, "OUI_Text_Tertiary_Light");
        OUI_Text_Tertiary_Light = f.a(r88);
        e r89 = MaterialTokenCore.OUI_Text_Tertiary_Dark;
        Intrinsics.checkNotNullExpressionValue(r89, "OUI_Text_Tertiary_Dark");
        OUI_Text_Tertiary_Dark = f.a(r89);
        OUI_Text_Tertiary = (Function1) ZeusTransformUtils.preCheckCast(MaterialToken$OUI_Text_Tertiary$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    }

    private MaterialToken() {
    }

    @JvmStatic
    public static final c compatibleConfig(c r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        int r1 = OMaterialHelper.e();
        MaterialToken r2 = INSTANCE;
        if (r1 >= 1) goto L9;
        return null;
    L9:
        if (r1 < 4) goto L12;
        return r4.l();
    L12:
        if (r1 < 3) goto L15;
        return r2.toApi3CompatibleConfig(r4);
    L15:
        return r2.toLegacyCompatibleConfig(r4);
    }

    @JvmStatic
    public static final c[] compatibleConfigArray(c[] r9) {
        Object[] r0 = null;
        if (r9 != null) goto L5;
        return null;
    L5:
        int r1 = OMaterialHelper.e();
        MaterialToken r2 = INSTANCE;
        if (r1 >= 1) goto L8;
        return null;
    L8:
        Function1 r3 = (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2), Function1.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r5 = r9.length;
        boolean r6 = false;
        int r7 = 0;
    L9:
        if (r7 >= r5) goto L14;
        Object r8 = r3.invoke(r9[r7]);
        if (r8 == null) goto L13;
        r4.add(r8);
    L13:
        r7 = r7 + 1;
        goto L9
    L14:
        Object[] r10 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new c[0]);
        Objects.requireNonNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        if (((c[]) ZeusTransformUtils.preCheckCast(r10, c[].class, "com.obric.memorydata.plugin")).length != 0) goto L18;
        r6 = true;
    L18:
        if ((!r6) == false) goto L21;
        r0 = r10;
    L21:
        return (c[]) ZeusTransformUtils.preCheckCast(r0, c[].class, "com.obric.memorydata.plugin");
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Fluid_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Fluid_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Fluid_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Fluid_Light$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Frost_Dark instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Frost_Dark$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Frost_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Frost_Light$annotations() {
    }

    @Deprecated(message = "Use MaterialToken.OUI_Bg_Floating_Overlay_Light instead")
    public static /* synthetic */ void getOUI_Bg_Overlay_Search_Light$annotations() {
    }

    private final ConcurrentHashMap<String, Function1<Boolean, c>> getProviders() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(providers$delegate.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    private final ConcurrentHashMap<String, Function1<Boolean, c[]>> getSetProviders() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(setProviders$delegate.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    private final ConcurrentHashMap<String, c[]> getTokenSets() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokenSets$delegate.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    private final ConcurrentHashMap<String, c> getTokens() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(tokens$delegate.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final boolean isApiCompatible(int r1) {
        if (OMaterialHelper.e() < r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean isApiCompatible$default(int r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = 4;
    L6:
        return isApiCompatible(r0);
    }

    @JvmStatic
    public static final c parse(String r4, boolean r5) {
        MaterialToken r0 = INSTANCE;
        c r1 = (c) ZeusTransformUtils.preCheckCast(o.a(r4, (Map) ZeusTransformUtils.preCheckCast(r0.getTokens(), Map.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        if (r5 == false) goto L6;
        String r6 = "_light";
    L7:
        r1 = (c) ZeusTransformUtils.preCheckCast(o.a(Intrinsics.stringPlus(r4, r6), (Map) ZeusTransformUtils.preCheckCast(r0.getTokens(), Map.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin");
        goto L9
    L6:
        r6 = "_dark";
    L9:
        return compatibleConfig(r1);
    }

    @JvmStatic
    public static final Function1<Boolean, c> parse(String r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.preCheckCast(o.a(r3, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getProviders(), Map.class, "com.obric.memorydata.plugin")), Function1.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return (Function1) ZeusTransformUtils.preCheckCast(new C12301(r4), Function1.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final Function1<Boolean, c[]> parseSet(String r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.preCheckCast(o.a(r3, (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getSetProviders(), Map.class, "com.obric.memorydata.plugin")), Function1.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return (Function1) ZeusTransformUtils.preCheckCast(new C12311(r4), Function1.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final c[] parseSet(String r4, boolean r5) {
        MaterialToken r0 = INSTANCE;
        c[] r1 = (c[]) ZeusTransformUtils.preCheckCast(o.a(r4, (Map) ZeusTransformUtils.preCheckCast(r0.getTokenSets(), Map.class, "com.obric.memorydata.plugin")), c[].class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        if (r5 == false) goto L6;
        String r2 = "_light";
    L7:
        r1 = (c[]) ZeusTransformUtils.preCheckCast(o.a(Intrinsics.stringPlus(r4, r2), (Map) ZeusTransformUtils.preCheckCast(r0.getTokenSets(), Map.class, "com.obric.memorydata.plugin")), c[].class, "com.obric.memorydata.plugin");
        goto L8
    L6:
        r2 = "_dark";
    L8:
        if (r1 != null) goto L13;
        c r6 = parse(r4, r5);
        if (r6 == null) goto L13;
        r1 = new c[]{r6};
    L13:
        return compatibleConfigArray(r1);
    }

    @JvmStatic
    public static final void register(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokenOwner");
        o.a(INSTANCE.getTokens(), r2, c.class, r3);
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
        if (Function1.class.isAssignableFrom(r8.getType()) == false) goto L4;
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
    public static final void registerProviderTokens(Map<String, ? extends Function1<? super Boolean, c>> r4, boolean r5) {
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
    public static final void registerSet(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokenOwner");
        o.a(INSTANCE.getTokenSets(), r2, c[].class, r3);
    }

    public static /* synthetic */ void registerSet$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSet(r0, r1);
    }

    @JvmStatic
    public static final void registerSetProvider(Object r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "customTokenOwner");
        n r0 = n.f14027a;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(INSTANCE.getSetProviders(), Map.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Field[] r5 = r12.getClass().getDeclaredFields();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r5, "fields");     // Catch: Exception -> L11
        int r6 = 0;
        int r7 = r5.length;     // Catch: Exception -> L11
    L4:
        if (r6 >= r7) goto L13;
        Field r8 = r5[r6];     // Catch: Exception -> L11
        r6 = r6 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r8.getType()) == false) goto L4;
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

    public static /* synthetic */ void registerSetProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSetProvider(r0, r1);
    }

    @JvmStatic
    public static final void registerSetProviderTokens(Map<String, ? extends Function1<? super Boolean, c[]>> r4, boolean r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "customTokens");
        n.f14027a.a((Map) ZeusTransformUtils.preCheckCast(INSTANCE.getSetProviders(), Map.class, "com.obric.memorydata.plugin"), r6, r5);
    }

    public static /* synthetic */ void registerSetProviderTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerSetProviderTokens(r5, r2);
    }

    @JvmStatic
    public static final void registerTokenSets(Map<String, c[]> r2, boolean r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "customTokens");
        o.a(INSTANCE.getTokenSets(), r4, r3);
    }

    public static /* synthetic */ void registerTokenSets$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokenSets(r5, r2);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, c> r2, boolean r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "customTokens");
        o.a(INSTANCE.getTokens(), r4, r3);
    }

    public static /* synthetic */ void registerTokens$default(Map r1, boolean r2, int r3, Object r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r1, Map.class, "com.obric.memorydata.plugin");
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        registerTokens(r5, r2);
    }

    private final c toApi3CompatibleConfig(c r1) {
        return r1.l();
    }

    private final c toLegacyCompatibleConfig(c r2) {
        c r1 = r2.l();
        com.obric.oui.color.a[] r3 = r1.c();
        if (r3 != null) goto L8;
        com.obric.oui.b.a r4 = r1.b();
        if (r4 != null) goto L7;
        r3 = null;
        goto L8
    L7:
        r3 = r4.a();
    L8:
        r1.a(r3);
        r1.a(null);
        com.obric.oui.color.e r5 = r1.e();
        if (r5 != null) goto L14;
        com.obric.oui.b.c r6 = r1.d();
        if (r6 != null) goto L13;
        r5 = null;
        goto L14
    L13:
        r5 = r6.a();
    L14:
        r1.a(r5);
        r1.a(null);
        r1.b(null);
        r1.a(null);
        return r1;
    }

    public final c[] resolveTokenForBuilder$OUI_standardRelease(String r9, boolean r10) {
        c[] r0 = (c[]) ZeusTransformUtils.preCheckCast(n.f14027a.a(r9, (Map) ZeusTransformUtils.preCheckCast(getTokenSets(), Map.class, "com.obric.memorydata.plugin")), c[].class, "com.obric.memorydata.plugin");
        String r1 = "_light";
        if (r0 != null) goto L10;
        n r2 = n.f14027a;
        if (r10 == false) goto L7;
        Object r4 = "_light";
    L8:
        r0 = (c[]) ZeusTransformUtils.preCheckCast(r2.a(Intrinsics.stringPlus(r9, r4), (Map) ZeusTransformUtils.preCheckCast(getTokenSets(), Map.class, "com.obric.memorydata.plugin")), c[].class, "com.obric.memorydata.plugin");
        goto L10
    L7:
        r4 = "_dark";
    L10:
        if (r0 == null) goto L16;
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r0.length), Collection.class, "com.obric.memorydata.plugin");
        int r11 = r0.length;
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L14;
        r8.add(r0[r12].l());
        r12 = r12 + 1;
        goto L12
    L14:
        Object[] r13 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new c[0]);
        Objects.requireNonNull(r13, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (c[]) ZeusTransformUtils.preCheckCast(r13, c[].class, "com.obric.memorydata.plugin");
    L16:
        Function1 r3 = (Function1) ZeusTransformUtils.preCheckCast(n.f14027a.a(r9, (Map) ZeusTransformUtils.preCheckCast(getSetProviders(), Map.class, "com.obric.memorydata.plugin")), Function1.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L35;
        c r5 = (c) ZeusTransformUtils.preCheckCast(n.f14027a.a(r9, (Map) ZeusTransformUtils.preCheckCast(getTokens(), Map.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L26;
        n r6 = n.f14027a;
        if (r10 == true) goto L24;
        r1 = "_dark";
    L24:
        r5 = (c) ZeusTransformUtils.preCheckCast(r6.a(Intrinsics.stringPlus(r9, r1), (Map) ZeusTransformUtils.preCheckCast(getTokens(), Map.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin");
    L26:
        if (r5 != null) goto L28;
        Function1 r14 = (Function1) ZeusTransformUtils.preCheckCast(n.f14027a.a(r9, (Map) ZeusTransformUtils.preCheckCast(getProviders(), Map.class, "com.obric.memorydata.plugin")), Function1.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L34;
        return null;
    L34:
        return new c[]{((c) ZeusTransformUtils.preCheckCast(r14.invoke(Boolean.valueOf(r10)), c.class, "com.obric.memorydata.plugin")).l()};
    L28:
        return new c[]{r5.l()};
    L35:
        Object[] r15 = (Object[]) ZeusTransformUtils.preCheckCast(r3.invoke(Boolean.valueOf(r10)), Object[].class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.memorydata.plugin");
        int r17 = r15.length;
        int r7 = 0;
    L36:
        if (r7 >= r17) goto L38;
        r16.add(((c) ZeusTransformUtils.preCheckCast(r15[r7], c.class, "com.obric.memorydata.plugin")).l());
        r7 = r7 + 1;
        goto L36
    L38:
        Object[] r18 = ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new c[0]);
        Objects.requireNonNull(r18, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (c[]) ZeusTransformUtils.preCheckCast(r18, c[].class, "com.obric.memorydata.plugin");
    }
}
