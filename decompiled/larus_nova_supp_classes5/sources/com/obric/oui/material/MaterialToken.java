package com.obric.oui.material;

import com.obric.oui.color.a;
import com.obric.oui.color.i0;
import com.obric.oui.color.j0;
import com.obric.oui.color.k0;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\br\bÇ\u0002\u0018\u00002\u00020\u0001B\n\b\u0002¢\u0006\u0005\b\u0099\u0001\u0010uJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J\u001a\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J&\u0010\f\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J,\u0010\u000e\u001a\u00020\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J2\u0010\u0012\u001a\u00020\u00052\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00110\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J8\u0010\u0013\u001a\u00020\u00052$\u0010\u000b\u001a \u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00110\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0007J&\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0003H\u0007J)\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0016\u0010\u0018J\u0012\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u0007J'\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rH\u0007¢\u0006\u0004\b\u001f\u0010 J\f\u0010!\u001a\u00020\n*\u00020\nH\u0002J\f\u0010\"\u001a\u00020\n*\u00020\nH\u0002J)\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0004\b#\u0010\u0018R\u0014\u0010%\u001a\u00020\u00198\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00198\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010&R'\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R-\u00100\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R3\u00103\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00110(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010,R9\u00106\u001a \u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00110(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b5\u0010,R\u0014\u00107\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b9\u00108R\u0014\u0010:\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u00108R\u0014\u0010;\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u00108R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010=R&\u0010?\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u00108R\u0014\u0010B\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bB\u00108R\u0014\u0010C\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u00108R\u0014\u0010D\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u00108R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bE\u0010=R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010=R&\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bG\u0010@R\u0014\u0010H\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u00108R\u0014\u0010I\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u00108R\u0014\u0010J\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u00108R\u0014\u0010K\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u00108R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bL\u0010=R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010=R&\u0010N\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010@R\u0014\u0010O\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u00108R\u0014\u0010P\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u00108R \u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010@R\u0014\u0010R\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u00108R\u0014\u0010S\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u00108R\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010=R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010=R&\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010@R\u0014\u0010W\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u00108R\u0014\u0010X\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bX\u00108R\u0014\u0010Y\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bY\u00108R\u0014\u0010Z\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u00108R\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b[\u0010=R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010=R&\u0010]\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010@R\u0014\u0010^\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b^\u00108R\u0014\u0010_\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b_\u00108R\u0014\u0010`\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b`\u00108R\u0014\u0010a\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u00108R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010=R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bc\u0010=R&\u0010d\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bd\u0010@R\u0014\u0010e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\be\u00108R\u0014\u0010f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bf\u00108R\u0014\u0010g\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bg\u00108R\u0014\u0010h\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u00108R\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bi\u0010=R\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bj\u0010=R&\u0010k\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bk\u0010@R\u0014\u0010l\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bl\u00108R\u0014\u0010m\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u00108R\u0014\u0010n\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bn\u00108R\u0014\u0010o\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bo\u00108R\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bp\u0010=R\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010=R&\u0010r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010@R\u001a\u0010s\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bs\u00108\u0012\u0004\bt\u0010uR\u001a\u0010v\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bv\u00108\u0012\u0004\bw\u0010uR\u001a\u0010x\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bx\u00108\u0012\u0004\by\u0010uR\u001a\u0010z\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bz\u00108\u0012\u0004\b{\u0010uR \u0010|\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b|\u0010=\u0012\u0004\b}\u0010uR \u0010~\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b~\u0010=\u0012\u0004\b\u007f\u0010uR/\u0010\u0080\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0080\u0001\u0010@\u0012\u0005\b\u0081\u0001\u0010uR\u0016\u0010\u0082\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u00108R\u0016\u0010\u0083\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u00108R\u0016\u0010\u0084\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u00108R\u0016\u0010\u0085\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0085\u0001\u00108R\u001c\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010=R\u001c\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010=R(\u0010\u0088\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010@R\u0016\u0010\u0089\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u00108R\u0016\u0010\u008a\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u00108R\u0016\u0010\u008b\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u00108R\u0016\u0010\u008c\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u00108R\u001c\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010=R\u001c\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010=R(\u0010\u008f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010@R\u0016\u0010\u0090\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0090\u0001\u00108R\u0016\u0010\u0091\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0091\u0001\u00108R\"\u0010\u0092\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010@R\u0016\u0010\u0093\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0093\u0001\u00108R\u0016\u0010\u0094\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0094\u0001\u00108R\"\u0010\u0095\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010@R\u0016\u0010\u0096\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0096\u0001\u00108R\u0016\u0010\u0097\u0001\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0097\u0001\u00108R\"\u0010\u0098\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00118\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010@¨\u0006\u009a\u0001"}, d2 = {"Lcom/obric/oui/material/MaterialToken;", "", "customTokenOwner", "", "overrideExisting", "", "register", "registerSet", "", "", "Lcom/obric/oui/material/c;", "customTokens", "registerTokens", "", "registerTokenSets", "registerProvider", "registerSetProvider", "Lkotlin/Function1;", "registerProviderTokens", "registerSetProviderTokens", DBDefinition.NAME, "parse", "parseSet", "isLight", "(Ljava/lang/String;Z)[Lcom/obric/oui/material/c;", "", "requiredApiLevel", "isApiCompatible", "config", "compatibleConfig", "configs", "compatibleConfigArray", "([Lcom/obric/oui/material/c;)[Lcom/obric/oui/material/c;", "toLegacyCompatibleConfig", "toApi3CompatibleConfig", "resolveTokenForBuilder$OUI_standardRelease", "resolveTokenForBuilder", "MATERIAL_TOKEN_API_LEVEL", "I", "MIN_SUPPORTED_MATERIAL_API_LEVEL", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens", "tokenSets$delegate", "getTokenSets", "tokenSets", "providers$delegate", "getProviders", "providers", "setProviders$delegate", "getSetProviders", "setProviders", "OUI_Bg_Floating_Frost_Light", "Lcom/obric/oui/material/c;", "OUI_Bg_Floating_Frost_Dark", "OUI_Bg_Floating_Fluid_Light", "OUI_Bg_Floating_Fluid_Dark", "OUI_Bg_Floating_Light", "[Lcom/obric/oui/material/c;", "OUI_Bg_Floating_Dark", "OUI_Bg_Floating", "Lkotlin/jvm/functions/Function1;", "OUI_Bg_Floating_OnImage_Frost_Light", "OUI_Bg_Floating_OnImage_Frost_Dark", "OUI_Bg_Floating_OnImage_Fluid_Light", "OUI_Bg_Floating_OnImage_Fluid_Dark", "OUI_Bg_Floating_OnImage_Light", "OUI_Bg_Floating_OnImage_Dark", "OUI_Bg_Floating_OnImage", "OUI_Bg_Floating_Fill_Frost_Light", "OUI_Bg_Floating_Fill_Frost_Dark", "OUI_Bg_Floating_Fill_Fluid_Light", "OUI_Bg_Floating_Fill_Fluid_Dark", "OUI_Bg_Floating_Fill_Light", "OUI_Bg_Floating_Fill_Dark", "OUI_Bg_Floating_Fill", "OUI_Bg_Popup_Frost_Light", "OUI_Bg_Popup_Frost_Dark", "OUI_Bg_Popup_Frost", "OUI_Bg_Popup_Fluid_Light", "OUI_Bg_Popup_Fluid_Dark", "OUI_Bg_Popup_Light", "OUI_Bg_Popup_Dark", "OUI_Bg_Popup", "OUI_Bg_Popup_OnImage_Frost_Light", "OUI_Bg_Popup_OnImage_Frost_Dark", "OUI_Bg_Popup_OnImage_Fluid_Light", "OUI_Bg_Popup_OnImage_Fluid_Dark", "OUI_Bg_Popup_OnImage_Light", "OUI_Bg_Popup_OnImage_Dark", "OUI_Bg_Popup_OnImage", "OUI_Bg_Popup_Overlay_Frost_Light", "OUI_Bg_Popup_Overlay_Frost_Dark", "OUI_Bg_Popup_Overlay_Fluid_Light", "OUI_Bg_Popup_Overlay_Fluid_Dark", "OUI_Bg_Popup_Overlay_Light", "OUI_Bg_Popup_Overlay_Dark", "OUI_Bg_Popup_Overlay", "OUI_Bg_Modal_Frost_Light", "OUI_Bg_Modal_Frost_Dark", "OUI_Bg_Modal_Fluid_Light", "OUI_Bg_Modal_Fluid_Dark", "OUI_Bg_Modal_Light", "OUI_Bg_Modal_Dark", "OUI_Bg_Modal", "OUI_Bg_Floating_Overlay_Frost_Light", "OUI_Bg_Floating_Overlay_Frost_Dark", "OUI_Bg_Floating_Overlay_Fluid_Light", "OUI_Bg_Floating_Overlay_Fluid_Dark", "OUI_Bg_Floating_Overlay_Light", "OUI_Bg_Floating_Overlay_Dark", "OUI_Bg_Floating_Overlay", "OUI_Bg_Overlay_Search_Frost_Light", "getOUI_Bg_Overlay_Search_Frost_Light$annotations", "()V", "OUI_Bg_Overlay_Search_Frost_Dark", "getOUI_Bg_Overlay_Search_Frost_Dark$annotations", "OUI_Bg_Overlay_Search_Fluid_Light", "getOUI_Bg_Overlay_Search_Fluid_Light$annotations", "OUI_Bg_Overlay_Search_Fluid_Dark", "getOUI_Bg_Overlay_Search_Fluid_Dark$annotations", "OUI_Bg_Overlay_Search_Light", "getOUI_Bg_Overlay_Search_Light$annotations", "OUI_Bg_Overlay_Search_Dark", "getOUI_Bg_Overlay_Search_Dark$annotations", "OUI_Bg_Overlay_Search", "getOUI_Bg_Overlay_Search$annotations", "OUI_Bg_Floating_Frost_Tinted_Light", "OUI_Bg_Floating_Frost_Tinted_Dark", "OUI_Bg_Floating_Fluid_Tinted_Light", "OUI_Bg_Floating_Fluid_Tinted_Dark", "OUI_Bg_Floating_Tinted_Light", "OUI_Bg_Floating_Tinted_Dark", "OUI_Bg_Floating_Tinted", "OUI_Bg_Floating_Frost_Blue_Light", "OUI_Bg_Floating_Frost_Blue_Dark", "OUI_Bg_Floating_Fluid_Blue_Light", "OUI_Bg_Floating_Fluid_Blue_Dark", "OUI_Bg_Floating_Blue_Light", "OUI_Bg_Floating_Blue_Dark", "OUI_Bg_Floating_Blue", "OUI_Text_Primary_Light", "OUI_Text_Primary_Dark", "OUI_Text_Primary", "OUI_Text_Secondary_Light", "OUI_Text_Secondary_Dark", "OUI_Text_Secondary", "OUI_Text_Tertiary_Light", "OUI_Text_Tertiary_Dark", "OUI_Text_Tertiary", "<init>", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
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

    private MaterialToken() {
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

    static {
        INSTANCE = new MaterialToken();
        tokens$delegate = LazyKt.lazy(MaterialToken$tokens$2.INSTANCE);
        tokenSets$delegate = LazyKt.lazy(MaterialToken$tokenSets$2.INSTANCE);
        providers$delegate = LazyKt.lazy(MaterialToken$providers$2.INSTANCE);
        setProviders$delegate = LazyKt.lazy(MaterialToken$setProviders$2.INSTANCE);
        OUI_Bg_Floating_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Frost_Light);
        OUI_Bg_Floating_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Frost_Dark);
        OUI_Bg_Floating_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Fluid_Light);
        OUI_Bg_Floating_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Fluid_Dark);
        OUI_Bg_Floating_Light = f.b(MaterialTokenCore.OUI_Bg_Floating_Light);
        OUI_Bg_Floating_Dark = f.b(MaterialTokenCore.OUI_Bg_Floating_Dark);
        OUI_Bg_Floating = MaterialToken$OUI_Bg_Floating$1.INSTANCE;
        OUI_Bg_Floating_OnImage_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_OnImage_Frost_Light);
        OUI_Bg_Floating_OnImage_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_OnImage_Frost_Dark);
        OUI_Bg_Floating_OnImage_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_OnImage_Fluid_Light);
        OUI_Bg_Floating_OnImage_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_OnImage_Fluid_Dark);
        OUI_Bg_Floating_OnImage_Light = f.b(MaterialTokenCore.OUI_Bg_Floating_OnImage_Light);
        OUI_Bg_Floating_OnImage_Dark = f.b(MaterialTokenCore.OUI_Bg_Floating_OnImage_Dark);
        OUI_Bg_Floating_OnImage = MaterialToken$OUI_Bg_Floating_OnImage$1.INSTANCE;
        OUI_Bg_Floating_Fill_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Fill_Frost_Light);
        OUI_Bg_Floating_Fill_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Fill_Frost_Dark);
        OUI_Bg_Floating_Fill_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Fill_Fluid_Light);
        OUI_Bg_Floating_Fill_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Fill_Fluid_Dark);
        OUI_Bg_Floating_Fill_Light = f.b(MaterialTokenCore.OUI_Bg_Floating_Fill_Light);
        OUI_Bg_Floating_Fill_Dark = f.b(MaterialTokenCore.OUI_Bg_Floating_Fill_Dark);
        OUI_Bg_Floating_Fill = MaterialToken$OUI_Bg_Floating_Fill$1.INSTANCE;
        OUI_Bg_Popup_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Popup_Frost_Light);
        OUI_Bg_Popup_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Popup_Frost_Dark);
        OUI_Bg_Popup_Frost = MaterialToken$OUI_Bg_Popup_Frost$1.INSTANCE;
        OUI_Bg_Popup_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Popup_Fluid_Light);
        OUI_Bg_Popup_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Popup_Fluid_Dark);
        OUI_Bg_Popup_Light = f.b(MaterialTokenCore.OUI_Bg_Popup_Light);
        OUI_Bg_Popup_Dark = f.b(MaterialTokenCore.OUI_Bg_Popup_Dark);
        OUI_Bg_Popup = MaterialToken$OUI_Bg_Popup$1.INSTANCE;
        OUI_Bg_Popup_OnImage_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Popup_OnImage_Frost_Light);
        OUI_Bg_Popup_OnImage_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Popup_OnImage_Frost_Dark);
        OUI_Bg_Popup_OnImage_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Popup_OnImage_Fluid_Light);
        OUI_Bg_Popup_OnImage_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Popup_OnImage_Fluid_Dark);
        OUI_Bg_Popup_OnImage_Light = f.b(MaterialTokenCore.OUI_Bg_Popup_OnImage_Light);
        OUI_Bg_Popup_OnImage_Dark = f.b(MaterialTokenCore.OUI_Bg_Popup_OnImage_Dark);
        OUI_Bg_Popup_OnImage = MaterialToken$OUI_Bg_Popup_OnImage$1.INSTANCE;
        OUI_Bg_Popup_Overlay_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Popup_Overlay_Frost_Light);
        OUI_Bg_Popup_Overlay_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Popup_Overlay_Frost_Dark);
        OUI_Bg_Popup_Overlay_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Popup_Overlay_Fluid_Light);
        OUI_Bg_Popup_Overlay_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Popup_Overlay_Fluid_Dark);
        OUI_Bg_Popup_Overlay_Light = f.b(MaterialTokenCore.OUI_Bg_Popup_Overlay_Light);
        OUI_Bg_Popup_Overlay_Dark = f.b(MaterialTokenCore.OUI_Bg_Popup_Overlay_Dark);
        OUI_Bg_Popup_Overlay = MaterialToken$OUI_Bg_Popup_Overlay$1.INSTANCE;
        OUI_Bg_Modal_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Modal_Frost_Light);
        OUI_Bg_Modal_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Modal_Frost_Dark);
        OUI_Bg_Modal_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Modal_Fluid_Light);
        OUI_Bg_Modal_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Modal_Fluid_Dark);
        OUI_Bg_Modal_Light = f.b(MaterialTokenCore.OUI_Bg_Modal_Light);
        OUI_Bg_Modal_Dark = f.b(MaterialTokenCore.OUI_Bg_Modal_Dark);
        OUI_Bg_Modal = MaterialToken$OUI_Bg_Modal$1.INSTANCE;
        OUI_Bg_Floating_Overlay_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Overlay_Frost_Light);
        OUI_Bg_Floating_Overlay_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Overlay_Frost_Dark);
        OUI_Bg_Floating_Overlay_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Overlay_Fluid_Light);
        OUI_Bg_Floating_Overlay_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Overlay_Fluid_Dark);
        OUI_Bg_Floating_Overlay_Light = f.b(MaterialTokenCore.OUI_Bg_Floating_Overlay_Light);
        OUI_Bg_Floating_Overlay_Dark = f.b(MaterialTokenCore.OUI_Bg_Floating_Overlay_Dark);
        OUI_Bg_Floating_Overlay = MaterialToken$OUI_Bg_Floating_Overlay$1.INSTANCE;
        OUI_Bg_Overlay_Search_Frost_Light = f.a(MaterialTokenCore.OUI_Bg_Overlay_Search_Frost_Light);
        OUI_Bg_Overlay_Search_Frost_Dark = f.a(MaterialTokenCore.OUI_Bg_Overlay_Search_Frost_Dark);
        OUI_Bg_Overlay_Search_Fluid_Light = f.a(MaterialTokenCore.OUI_Bg_Overlay_Search_Fluid_Light);
        OUI_Bg_Overlay_Search_Fluid_Dark = f.a(MaterialTokenCore.OUI_Bg_Overlay_Search_Fluid_Dark);
        OUI_Bg_Overlay_Search_Light = f.b(MaterialTokenCore.OUI_Bg_Overlay_Search_Light);
        OUI_Bg_Overlay_Search_Dark = f.b(MaterialTokenCore.OUI_Bg_Overlay_Search_Dark);
        OUI_Bg_Overlay_Search = MaterialToken$OUI_Bg_Overlay_Search$1.INSTANCE;
        OUI_Bg_Floating_Frost_Tinted_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Frost_Tinted_Light);
        OUI_Bg_Floating_Frost_Tinted_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Frost_Tinted_Dark);
        OUI_Bg_Floating_Fluid_Tinted_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Fluid_Tinted_Light);
        OUI_Bg_Floating_Fluid_Tinted_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Fluid_Tinted_Dark);
        OUI_Bg_Floating_Tinted_Light = f.b(MaterialTokenCore.OUI_Bg_Floating_Tinted_Light);
        OUI_Bg_Floating_Tinted_Dark = f.b(MaterialTokenCore.OUI_Bg_Floating_Tinted_Dark);
        OUI_Bg_Floating_Tinted = MaterialToken$OUI_Bg_Floating_Tinted$1.INSTANCE;
        OUI_Bg_Floating_Frost_Blue_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Frost_Blue_Light);
        OUI_Bg_Floating_Frost_Blue_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Frost_Blue_Dark);
        OUI_Bg_Floating_Fluid_Blue_Light = f.a(MaterialTokenCore.OUI_Bg_Floating_Fluid_Blue_Light);
        OUI_Bg_Floating_Fluid_Blue_Dark = f.a(MaterialTokenCore.OUI_Bg_Floating_Fluid_Blue_Dark);
        OUI_Bg_Floating_Blue_Light = f.b(MaterialTokenCore.OUI_Bg_Floating_Blue_Light);
        OUI_Bg_Floating_Blue_Dark = f.b(MaterialTokenCore.OUI_Bg_Floating_Blue_Dark);
        OUI_Bg_Floating_Blue = MaterialToken$OUI_Bg_Floating_Blue$1.INSTANCE;
        OUI_Text_Primary_Light = f.a(MaterialTokenCore.OUI_Text_Primary_Light);
        OUI_Text_Primary_Dark = f.a(MaterialTokenCore.OUI_Text_Primary_Dark);
        OUI_Text_Primary = MaterialToken$OUI_Text_Primary$1.INSTANCE;
        OUI_Text_Secondary_Light = f.a(MaterialTokenCore.OUI_Text_Secondary_Light);
        OUI_Text_Secondary_Dark = f.a(MaterialTokenCore.OUI_Text_Secondary_Dark);
        OUI_Text_Secondary = MaterialToken$OUI_Text_Secondary$1.INSTANCE;
        OUI_Text_Tertiary_Light = f.a(MaterialTokenCore.OUI_Text_Tertiary_Light);
        OUI_Text_Tertiary_Dark = f.a(MaterialTokenCore.OUI_Text_Tertiary_Dark);
        OUI_Text_Tertiary = MaterialToken$OUI_Text_Tertiary$1.INSTANCE;
    }

    private final ConcurrentHashMap<String, Function1<Boolean, c>> getProviders() {
        return (ConcurrentHashMap) providers$delegate.getValue();
    }

    private final ConcurrentHashMap<String, Function1<Boolean, c[]>> getSetProviders() {
        return (ConcurrentHashMap) setProviders$delegate.getValue();
    }

    private final ConcurrentHashMap<String, c[]> getTokenSets() {
        return (ConcurrentHashMap) tokenSets$delegate.getValue();
    }

    private final ConcurrentHashMap<String, c> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final c compatibleConfig(c r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r1 = OMaterialHelper.c();
        if (r1 >= 1) goto L9;
        return null;
    L9:
        if (r1 < 4) goto L12;
        return r3.a();
    L12:
        if (r1 < 3) goto L15;
        return INSTANCE.toApi3CompatibleConfig(r3);
    L15:
        return INSTANCE.toLegacyCompatibleConfig(r3);
    }

    @JvmStatic
    public static final c[] compatibleConfigArray(c[] r8) {
        Object[] r0 = null;
        if (r8 != null) goto L6;
        return null;
    L6:
        if (OMaterialHelper.c() >= 1) goto L8;
        return null;
    L8:
        compatibleConfigArray.1 r1 = new compatibleConfigArray.1(INSTANCE);
        ArrayList r3 = new ArrayList();
        int r4 = r8.length;
        boolean r5 = false;
        int r6 = 0;
    L9:
        if (r6 >= r4) goto L14;
        Object r7 = r1.invoke(r8[r6]);
        if (r7 == null) goto L13;
        r3.add(r7);
    L13:
        r6 = r6 + 1;
        goto L9
    L14:
        Object[] r9 = r3.toArray(new c[0]);
        if (r9 == null) goto L25;
        if (((c[]) r9).length != 0) goto L20;
        r5 = true;
    L20:
        if ((!r5) == false) goto L23;
        r0 = r9;
    L23:
        return (c[]) r0;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @JvmStatic
    public static final boolean isApiCompatible(int r1) {
        if (OMaterialHelper.c() < r1) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final Function1<Boolean, c> parse(String r1) {
        Function1 r2 = (Function1) s.c(r1, INSTANCE.getProviders());
        if (r2 != null) goto L7;
        return null;
    L7:
        return new parse.1(r2);
    }

    @JvmStatic
    public static final Function1<Boolean, c[]> parseSet(String r1) {
        Function1 r2 = (Function1) s.c(r1, INSTANCE.getSetProviders());
        if (r2 != null) goto L7;
        return null;
    L7:
        return new parseSet.1(r2);
    }

    private final c toApi3CompatibleConfig(c r1) {
        return r1.a();
    }

    private final c toLegacyCompatibleConfig(c r3) {
        c r4 = r3.a();
        a[] r0 = r4.c;
        if (r0 != null) goto L8;
        kma.a r1 = r4.b;
        if (r1 != null) goto L7;
        r0 = null;
        goto L8
    L7:
        r0 = com.obric.oui.color.c.a(r1.a.c);
    L8:
        r4.c = r0;
        r4.b = null;
        i0 r2 = r4.e;
        if (r2 != null) goto L17;
        kma.c r5 = r4.d;
        if (r5 != null) goto L13;
    L12:
        r2 = null;
        goto L17
    L13:
        j0 r6 = r5.a.c;
        if (r6 == null) goto L12;
        r2 = k0.a(r6);
    L17:
        r4.e = r2;
        r4.d = null;
        r4.f = null;
        r4.j = null;
        return r4;
    }

    @JvmStatic
    public static final c parse(String r2, boolean r3) {
        MaterialToken r0 = INSTANCE;
        c r1 = (c) s.c(r2, r0.getTokens());
        if (r1 != null) goto L9;
        if (r3 == false) goto L6;
        String r4 = "_light";
    L7:
        r1 = (c) s.c(Intrinsics.stringPlus(r2, r4), r0.getTokens());
        goto L9
    L6:
        r4 = "_dark";
    L9:
        return compatibleConfig(r1);
    }

    @JvmStatic
    public static final c[] parseSet(String r2, boolean r3) {
        MaterialToken r0 = INSTANCE;
        c[] r1 = (c[]) s.c(r2, r0.getTokenSets());
        if (r1 != null) goto L8;
        if (r3 == false) goto L6;
        String r4 = "_light";
    L7:
        r1 = (c[]) s.c(Intrinsics.stringPlus(r2, r4), r0.getTokenSets());
        goto L8
    L6:
        r4 = "_dark";
    L8:
        if (r1 != null) goto L13;
        c r5 = parse(r2, r3);
        if (r5 == null) goto L13;
        r1 = new c[]{r5};
    L13:
        return compatibleConfigArray(r1);
    }

    @JvmStatic
    public static final void register(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokenOwner");
        s.d(INSTANCE.getTokens(), r2, c.class, r3);
    }

    @JvmStatic
    public static final void registerProvider(Object r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "customTokenOwner");
        int r0 = r.a;
        ConcurrentHashMap<String, Function1<Boolean, c>> r1 = INSTANCE.getProviders();
        LinkedHashMap r2 = new LinkedHashMap();
        Field[] r3 = r9.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r4 = r3.length;     // Catch: Exception -> L11
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L12;
        Field r6 = r3[r5];     // Catch: Exception -> L11
        r5 = r5 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r6.getType()) == false) goto L4;
        r6.setAccessible(true);     // Catch: Exception -> L11
        Object r8 = r6.get(r9);     // Catch: Exception -> L11
        if (TypeIntrinsics.isFunctionOfArity(r8, 1) == false) goto L4;
        r2.put(r6.getName().toLowerCase(Locale.ROOT), r8);     // Catch: Exception -> L11
    L12:
        r.b(r1, r2, r10);
        return;
    L11:
        Intrinsics.stringPlus("Failed to parse tokens from ", r9.getClass().getSimpleName());
        goto L12
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends Function1<? super Boolean, c>> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        int r0 = r.a;
        r.b(INSTANCE.getProviders(), r1, r2);
    }

    @JvmStatic
    public static final void registerSet(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "customTokenOwner");
        s.d(INSTANCE.getTokenSets(), r2, c[].class, r3);
    }

    @JvmStatic
    public static final void registerSetProvider(Object r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "customTokenOwner");
        int r0 = r.a;
        ConcurrentHashMap<String, Function1<Boolean, c[]>> r1 = INSTANCE.getSetProviders();
        LinkedHashMap r2 = new LinkedHashMap();
        Field[] r3 = r9.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r4 = r3.length;     // Catch: Exception -> L11
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L12;
        Field r6 = r3[r5];     // Catch: Exception -> L11
        r5 = r5 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r6.getType()) == false) goto L4;
        r6.setAccessible(true);     // Catch: Exception -> L11
        Object r8 = r6.get(r9);     // Catch: Exception -> L11
        if (TypeIntrinsics.isFunctionOfArity(r8, 1) == false) goto L4;
        r2.put(r6.getName().toLowerCase(Locale.ROOT), r8);     // Catch: Exception -> L11
    L12:
        r.b(r1, r2, r10);
        return;
    L11:
        Intrinsics.stringPlus("Failed to parse tokens from ", r9.getClass().getSimpleName());
        goto L12
    }

    @JvmStatic
    public static final void registerSetProviderTokens(Map<String, ? extends Function1<? super Boolean, c[]>> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        int r0 = r.a;
        r.b(INSTANCE.getSetProviders(), r1, r2);
    }

    @JvmStatic
    public static final void registerTokenSets(Map<String, c[]> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        s.e(INSTANCE.getTokenSets(), r1, r2);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, c> r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "customTokens");
        s.e(INSTANCE.getTokens(), r1, r2);
    }

    public final c[] resolveTokenForBuilder$OUI_standardRelease(String r6, boolean r7) {
        int r0 = r.a;
        c[] r1 = (c[]) r.a(r6, getTokenSets());
        String r2 = "_light";
        if (r1 != null) goto L9;
        if (r7 == false) goto L6;
        Object r3 = "_light";
    L7:
        r1 = (c[]) r.a(Intrinsics.stringPlus(r6, r3), getTokenSets());
        goto L9
    L6:
        r3 = "_dark";
    L9:
        if (r1 == null) goto L19;
        ArrayList r8 = new ArrayList(r1.length);
        int r9 = r1.length;
        int r4 = 0;
    L11:
        if (r4 >= r9) goto L13;
        r8.add(r1[r4].a());
        r4 = r4 + 1;
        goto L11
    L13:
        Object[] r10 = r8.toArray(new c[0]);
        if (r10 == null) goto L18;
        return (c[]) r10;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L19:
        Function1 r5 = (Function1) r.a(r6, getSetProviders());
        if (r5 != null) goto L37;
        c r11 = (c) r.a(r6, getTokens());
        if (r11 != null) goto L28;
        if (r7 == true) goto L26;
        r2 = "_dark";
    L26:
        r11 = (c) r.a(Intrinsics.stringPlus(r6, r2), getTokens());
    L28:
        if (r11 != null) goto L30;
        Function1 r12 = (Function1) r.a(r6, getProviders());
        if (r12 != null) goto L36;
        return null;
    L36:
        return new c[]{((c) r12.invoke(Boolean.valueOf(r7))).a()};
    L30:
        return new c[]{r11.a()};
    L37:
        Object[] r13 = (Object[]) r5.invoke(Boolean.valueOf(r7));
        ArrayList r14 = new ArrayList(r13.length);
        int r15 = r13.length;
        int r16 = 0;
    L38:
        if (r16 >= r15) goto L40;
        r14.add(((c) r13[r16]).a());
        r16 = r16 + 1;
        goto L38
    L40:
        Object[] r17 = r14.toArray(new c[0]);
        if (r17 == null) goto L45;
        return (c[]) r17;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static /* synthetic */ boolean isApiCompatible$default(int r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = 4;
    L6:
        return isApiCompatible(r0);
    }

    public static /* synthetic */ void register$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        register(r0, r1);
    }

    public static /* synthetic */ void registerProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProvider(r0, r1);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerProviderTokens(r0, r1);
    }

    public static /* synthetic */ void registerSet$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSet(r0, r1);
    }

    public static /* synthetic */ void registerSetProvider$default(Object r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSetProvider(r0, r1);
    }

    public static /* synthetic */ void registerSetProviderTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerSetProviderTokens(r0, r1);
    }

    public static /* synthetic */ void registerTokenSets$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerTokenSets(r0, r1);
    }

    public static /* synthetic */ void registerTokens$default(Map r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        registerTokens(r0, r1);
    }
}
