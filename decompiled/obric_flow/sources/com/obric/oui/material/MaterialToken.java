package com.obric.oui.material;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.room.jarjarred.org.antlr.v4.gui.TestRig;
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
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bp\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0011J-\u0010\u0015\u001a\u00020\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0017\u001a\u00020\u000f2\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0017\u0010\u0016J!\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0018\u0010\u0011J!\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0019\u0010\u0011J9\u0010\u001b\u001a\u00020\u000f2\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u001a0\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001b\u0010\u0016J?\u0010\u001c\u001a\u00020\u000f2$\u0010\u0014\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a0\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001c\u0010\u0016J'\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u001a2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u001f\u0010\u001eJ#\u0010\u001d\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001d\u0010 J)\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001f\u0010\u000bJ\u0019\u0010#\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b#\u0010$J\u001b\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010%\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b&\u0010'J'\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020\t*\u00020\tH\u0002¢\u0006\u0004\b+\u0010'J\u0013\u0010,\u001a\u00020\t*\u00020\tH\u0002¢\u0006\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020!8\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010.R'\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R-\u00108\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R3\u0010;\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u001a008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R9\u0010>\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u00102\u001a\u0004\b=\u00104R\u0014\u0010?\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010@R\u0014\u0010B\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bB\u0010@R\u0014\u0010C\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010ER&\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010I\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010@R\u0014\u0010J\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bJ\u0010@R\u0014\u0010K\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010@R\u0014\u0010L\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bL\u0010@R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010ER\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010ER&\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010HR\u0014\u0010P\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010@R\u0014\u0010Q\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010@R\u0014\u0010R\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bR\u0010@R\u0014\u0010S\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010@R\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010ER\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010ER&\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010HR\u0014\u0010W\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010@R\u0014\u0010X\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bX\u0010@R \u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bY\u0010HR\u0014\u0010Z\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bZ\u0010@R\u0014\u0010[\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b[\u0010@R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010ER\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b]\u0010ER&\u0010^\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b^\u0010HR\u0014\u0010_\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b_\u0010@R\u0014\u0010`\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b`\u0010@R\u0014\u0010a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010@R\u0014\u0010b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bb\u0010@R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bc\u0010ER\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bd\u0010ER&\u0010e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\be\u0010HR\u0014\u0010f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bf\u0010@R\u0014\u0010g\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bg\u0010@R\u0014\u0010h\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u0010@R\u0014\u0010i\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bi\u0010@R\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bj\u0010ER\u001a\u0010k\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bk\u0010ER&\u0010l\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bl\u0010HR\u0014\u0010m\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u0010@R\u0014\u0010n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bn\u0010@R\u0014\u0010o\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bo\u0010@R\u0014\u0010p\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bp\u0010@R\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010ER\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010ER&\u0010s\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bs\u0010HR\u0014\u0010t\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bt\u0010@R\u0014\u0010u\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bu\u0010@R\u0014\u0010v\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bv\u0010@R\u0014\u0010w\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010@R\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bx\u0010ER\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\by\u0010ER&\u0010z\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bz\u0010HR\u001a\u0010{\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b{\u0010@\u0012\u0004\b|\u0010\u0003R\u001a\u0010}\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b}\u0010@\u0012\u0004\b~\u0010\u0003R\u001b\u0010\u007f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\r\n\u0004\b\u007f\u0010@\u0012\u0005\b\u0080\u0001\u0010\u0003R\u001d\u0010\u0081\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010@\u0012\u0005\b\u0082\u0001\u0010\u0003R#\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010E\u0012\u0005\b\u0084\u0001\u0010\u0003R#\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010E\u0012\u0005\b\u0086\u0001\u0010\u0003R/\u0010\u0087\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010H\u0012\u0005\b\u0088\u0001\u0010\u0003R\u0016\u0010\u0089\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010@R\u0016\u0010\u008a\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010@R\u0016\u0010\u008b\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010@R\u0016\u0010\u008c\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010@R\u001c\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010ER\u001c\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010ER(\u0010\u008f\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010HR\u0016\u0010\u0090\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010@R\u0016\u0010\u0091\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0091\u0001\u0010@R\u0016\u0010\u0092\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0092\u0001\u0010@R\u0016\u0010\u0093\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010@R\u001c\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010ER\u001c\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010ER(\u0010\u0096\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u001a8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010HR\u0016\u0010\u0097\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010@R\u0016\u0010\u0098\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0098\u0001\u0010@R\"\u0010\u0099\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u001a8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010HR\u0016\u0010\u009a\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010@R\u0016\u0010\u009b\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010@R\"\u0010\u009c\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u001a8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010HR\u0016\u0010\u009d\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010@R\u0016\u0010\u009e\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010@R\"\u0010\u009f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u001a8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010H¨\u0006 \u0001"}, d2 = {"Lcom/obric/oui/material/MaterialToken;", "", "<init>", "()V", "", "name", "", "isLight", "", "Lcom/obric/oui/material/c;", "resolveTokenForBuilder$OUI_standardRelease", "(Ljava/lang/String;Z)[Lcom/obric/oui/material/c;", "resolveTokenForBuilder", "customTokenOwner", "overrideExisting", "", "register", "(Ljava/lang/Object;Z)V", "registerSet", "", "customTokens", "registerTokens", "(Ljava/util/Map;Z)V", "registerTokenSets", "registerProvider", "registerSetProvider", "Lkotlin/Function1;", "registerProviderTokens", "registerSetProviderTokens", "parse", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "parseSet", "(Ljava/lang/String;Z)Lcom/obric/oui/material/c;", "", "requiredApiLevel", "isApiCompatible", "(I)Z", "config", "compatibleConfig", "(Lcom/obric/oui/material/c;)Lcom/obric/oui/material/c;", "configs", "compatibleConfigArray", "([Lcom/obric/oui/material/c;)[Lcom/obric/oui/material/c;", "toLegacyCompatibleConfig", "toApi3CompatibleConfig", "MATERIAL_TOKEN_API_LEVEL", "I", "MIN_SUPPORTED_MATERIAL_API_LEVEL", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", TestRig.LEXER_START_RULE_NAME, "tokenSets$delegate", "getTokenSets", "tokenSets", "providers$delegate", "getProviders", "providers", "setProviders$delegate", "getSetProviders", "setProviders", "OUI_Bg_Floating_Frost_Light", "Lcom/obric/oui/material/c;", "OUI_Bg_Floating_Frost_Dark", "OUI_Bg_Floating_Fluid_Light", "OUI_Bg_Floating_Fluid_Dark", "OUI_Bg_Floating_Light", "[Lcom/obric/oui/material/c;", "OUI_Bg_Floating_Dark", "OUI_Bg_Floating", "Lkotlin/jvm/functions/Function1;", "OUI_Bg_Floating_OnImage_Frost_Light", "OUI_Bg_Floating_OnImage_Frost_Dark", "OUI_Bg_Floating_OnImage_Fluid_Light", "OUI_Bg_Floating_OnImage_Fluid_Dark", "OUI_Bg_Floating_OnImage_Light", "OUI_Bg_Floating_OnImage_Dark", "OUI_Bg_Floating_OnImage", "OUI_Bg_Floating_Fill_Frost_Light", "OUI_Bg_Floating_Fill_Frost_Dark", "OUI_Bg_Floating_Fill_Fluid_Light", "OUI_Bg_Floating_Fill_Fluid_Dark", "OUI_Bg_Floating_Fill_Light", "OUI_Bg_Floating_Fill_Dark", "OUI_Bg_Floating_Fill", "OUI_Bg_Popup_Frost_Light", "OUI_Bg_Popup_Frost_Dark", "OUI_Bg_Popup_Frost", "OUI_Bg_Popup_Fluid_Light", "OUI_Bg_Popup_Fluid_Dark", "OUI_Bg_Popup_Light", "OUI_Bg_Popup_Dark", "OUI_Bg_Popup", "OUI_Bg_Popup_OnImage_Frost_Light", "OUI_Bg_Popup_OnImage_Frost_Dark", "OUI_Bg_Popup_OnImage_Fluid_Light", "OUI_Bg_Popup_OnImage_Fluid_Dark", "OUI_Bg_Popup_OnImage_Light", "OUI_Bg_Popup_OnImage_Dark", "OUI_Bg_Popup_OnImage", "OUI_Bg_Popup_Overlay_Frost_Light", "OUI_Bg_Popup_Overlay_Frost_Dark", "OUI_Bg_Popup_Overlay_Fluid_Light", "OUI_Bg_Popup_Overlay_Fluid_Dark", "OUI_Bg_Popup_Overlay_Light", "OUI_Bg_Popup_Overlay_Dark", "OUI_Bg_Popup_Overlay", "OUI_Bg_Modal_Frost_Light", "OUI_Bg_Modal_Frost_Dark", "OUI_Bg_Modal_Fluid_Light", "OUI_Bg_Modal_Fluid_Dark", "OUI_Bg_Modal_Light", "OUI_Bg_Modal_Dark", "OUI_Bg_Modal", "OUI_Bg_Floating_Overlay_Frost_Light", "OUI_Bg_Floating_Overlay_Frost_Dark", "OUI_Bg_Floating_Overlay_Fluid_Light", "OUI_Bg_Floating_Overlay_Fluid_Dark", "OUI_Bg_Floating_Overlay_Light", "OUI_Bg_Floating_Overlay_Dark", "OUI_Bg_Floating_Overlay", "OUI_Bg_Overlay_Search_Frost_Light", "getOUI_Bg_Overlay_Search_Frost_Light$annotations", "OUI_Bg_Overlay_Search_Frost_Dark", "getOUI_Bg_Overlay_Search_Frost_Dark$annotations", "OUI_Bg_Overlay_Search_Fluid_Light", "getOUI_Bg_Overlay_Search_Fluid_Light$annotations", "OUI_Bg_Overlay_Search_Fluid_Dark", "getOUI_Bg_Overlay_Search_Fluid_Dark$annotations", "OUI_Bg_Overlay_Search_Light", "getOUI_Bg_Overlay_Search_Light$annotations", "OUI_Bg_Overlay_Search_Dark", "getOUI_Bg_Overlay_Search_Dark$annotations", "OUI_Bg_Overlay_Search", "getOUI_Bg_Overlay_Search$annotations", "OUI_Bg_Floating_Frost_Tinted_Light", "OUI_Bg_Floating_Frost_Tinted_Dark", "OUI_Bg_Floating_Fluid_Tinted_Light", "OUI_Bg_Floating_Fluid_Tinted_Dark", "OUI_Bg_Floating_Tinted_Light", "OUI_Bg_Floating_Tinted_Dark", "OUI_Bg_Floating_Tinted", "OUI_Bg_Floating_Frost_Blue_Light", "OUI_Bg_Floating_Frost_Blue_Dark", "OUI_Bg_Floating_Fluid_Blue_Light", "OUI_Bg_Floating_Fluid_Blue_Dark", "OUI_Bg_Floating_Blue_Light", "OUI_Bg_Floating_Blue_Dark", "OUI_Bg_Floating_Blue", "OUI_Text_Primary_Light", "OUI_Text_Primary_Dark", "OUI_Text_Primary", "OUI_Text_Secondary_Light", "OUI_Text_Secondary_Dark", "OUI_Text_Secondary", "OUI_Text_Tertiary_Light", "OUI_Text_Tertiary_Dark", "OUI_Text_Tertiary", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaterialToken {
    public static final MaterialToken INSTANCE = null;
    public static final int MATERIAL_TOKEN_API_LEVEL = 4;
    public static final int MIN_SUPPORTED_MATERIAL_API_LEVEL = 1;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Floating = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Blue = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Blue_Dark = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Blue_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Dark = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Fill = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Fill_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fill_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fill_Fluid_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fill_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fill_Frost_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Fill_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fluid_Blue_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fluid_Blue_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fluid_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fluid_Tinted_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Fluid_Tinted_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_Frost_Blue_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Frost_Blue_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Frost_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_Frost_Tinted_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Frost_Tinted_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Light = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_OnImage = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_OnImage_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_OnImage_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_OnImage_Fluid_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_OnImage_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_OnImage_Frost_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_OnImage_Light = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Overlay = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Overlay_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Overlay_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Overlay_Fluid_Light = null;

    @JvmField
    public static final c OUI_Bg_Floating_Overlay_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Floating_Overlay_Frost_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Overlay_Light = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Floating_Tinted = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Tinted_Dark = null;

    @JvmField
    public static final c[] OUI_Bg_Floating_Tinted_Light = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Modal = null;

    @JvmField
    public static final c[] OUI_Bg_Modal_Dark = null;

    @JvmField
    public static final c OUI_Bg_Modal_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Modal_Fluid_Light = null;

    @JvmField
    public static final c OUI_Bg_Modal_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Modal_Frost_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Modal_Light = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Overlay_Search = null;

    @JvmField
    public static final c[] OUI_Bg_Overlay_Search_Dark = null;

    @JvmField
    public static final c OUI_Bg_Overlay_Search_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Overlay_Search_Fluid_Light = null;

    @JvmField
    public static final c OUI_Bg_Overlay_Search_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Overlay_Search_Frost_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Overlay_Search_Light = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Popup = null;

    @JvmField
    public static final c[] OUI_Bg_Popup_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_Fluid_Light = null;

    @JvmField
    public static final Function1<Boolean, c> OUI_Bg_Popup_Frost = null;

    @JvmField
    public static final c OUI_Bg_Popup_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_Frost_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Popup_Light = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Popup_OnImage = null;

    @JvmField
    public static final c[] OUI_Bg_Popup_OnImage_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_OnImage_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_OnImage_Fluid_Light = null;

    @JvmField
    public static final c OUI_Bg_Popup_OnImage_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_OnImage_Frost_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Popup_OnImage_Light = null;

    @JvmField
    public static final Function1<Boolean, c[]> OUI_Bg_Popup_Overlay = null;

    @JvmField
    public static final c[] OUI_Bg_Popup_Overlay_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_Overlay_Fluid_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_Overlay_Fluid_Light = null;

    @JvmField
    public static final c OUI_Bg_Popup_Overlay_Frost_Dark = null;

    @JvmField
    public static final c OUI_Bg_Popup_Overlay_Frost_Light = null;

    @JvmField
    public static final c[] OUI_Bg_Popup_Overlay_Light = null;

    @JvmField
    public static final Function1<Boolean, c> OUI_Text_Primary = null;

    @JvmField
    public static final c OUI_Text_Primary_Dark = null;

    @JvmField
    public static final c OUI_Text_Primary_Light = null;

    @JvmField
    public static final Function1<Boolean, c> OUI_Text_Secondary = null;

    @JvmField
    public static final c OUI_Text_Secondary_Dark = null;

    @JvmField
    public static final c OUI_Text_Secondary_Light = null;

    @JvmField
    public static final Function1<Boolean, c> OUI_Text_Tertiary = null;

    @JvmField
    public static final c OUI_Text_Tertiary_Dark = null;

    @JvmField
    public static final c OUI_Text_Tertiary_Light = null;
    private static final Lazy providers$delegate = null;
    private static final Lazy setProviders$delegate = null;
    private static final Lazy tokenSets$delegate = null;
    private static final Lazy tokens$delegate = null;

    /* JADX INFO: renamed from: com.obric.oui.material.MaterialToken$compatibleConfigArray$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<c, c> {
        public AnonymousClass1(Object r10) {
            super(1, r10, MaterialToken.class, "compatibleConfig", "compatibleConfig(Lcom/obric/oui/material/MaterialConfig;)Lcom/obric/oui/material/MaterialConfig;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final c invoke2(c r5) {
            return MaterialToken.compatibleConfig(r5);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ c invoke(c r5) {
            return invoke2(r5);
        }
    }

    static {
        INSTANCE = new MaterialToken();
        tokens$delegate = LazyKt.lazy(MaterialToken$tokens$2.INSTANCE);
        tokenSets$delegate = LazyKt.lazy(MaterialToken$tokenSets$2.INSTANCE);
        providers$delegate = LazyKt.lazy(MaterialToken$providers$2.INSTANCE);
        setProviders$delegate = LazyKt.lazy(MaterialToken$setProviders$2.INSTANCE);
        OUI_Bg_Floating_Frost_Light = e.f13615a;
        OUI_Bg_Floating_Frost_Dark = e.f13617b;
        OUI_Bg_Floating_Fluid_Light = e.f13619c;
        OUI_Bg_Floating_Fluid_Dark = e.d;
        OUI_Bg_Floating_Light = e.e;
        OUI_Bg_Floating_Dark = e.f;
        OUI_Bg_Floating = MaterialToken$OUI_Bg_Floating$1.INSTANCE;
        OUI_Bg_Floating_OnImage_Frost_Light = e.g;
        OUI_Bg_Floating_OnImage_Frost_Dark = e.f13624h;
        OUI_Bg_Floating_OnImage_Fluid_Light = e.f13626i;
        OUI_Bg_Floating_OnImage_Fluid_Dark = e.f13627j;
        OUI_Bg_Floating_OnImage_Light = e.f13629k;
        OUI_Bg_Floating_OnImage_Dark = e.f13631l;
        OUI_Bg_Floating_OnImage = MaterialToken$OUI_Bg_Floating_OnImage$1.INSTANCE;
        OUI_Bg_Floating_Fill_Frost_Light = e.f13632m;
        OUI_Bg_Floating_Fill_Frost_Dark = e.f13634n;
        OUI_Bg_Floating_Fill_Fluid_Light = e.f13636o;
        OUI_Bg_Floating_Fill_Fluid_Dark = e.f13638p;
        OUI_Bg_Floating_Fill_Light = e.f13640q;
        OUI_Bg_Floating_Fill_Dark = e.f13642r;
        OUI_Bg_Floating_Fill = MaterialToken$OUI_Bg_Floating_Fill$1.INSTANCE;
        OUI_Bg_Popup_Frost_Light = e.s;
        OUI_Bg_Popup_Frost_Dark = e.f13645t;
        OUI_Bg_Popup_Frost = MaterialToken$OUI_Bg_Popup_Frost$1.INSTANCE;
        OUI_Bg_Popup_Fluid_Light = e.f13647u;
        OUI_Bg_Popup_Fluid_Dark = e.f13648v;
        OUI_Bg_Popup_Light = e.f13649w;
        OUI_Bg_Popup_Dark = e.f13650x;
        OUI_Bg_Popup = MaterialToken$OUI_Bg_Popup$1.INSTANCE;
        OUI_Bg_Popup_OnImage_Frost_Light = e.f13651y;
        OUI_Bg_Popup_OnImage_Frost_Dark = e.f13652z;
        OUI_Bg_Popup_OnImage_Fluid_Light = e.A;
        OUI_Bg_Popup_OnImage_Fluid_Dark = e.B;
        OUI_Bg_Popup_OnImage_Light = e.C;
        OUI_Bg_Popup_OnImage_Dark = e.D;
        OUI_Bg_Popup_OnImage = MaterialToken$OUI_Bg_Popup_OnImage$1.INSTANCE;
        OUI_Bg_Popup_Overlay_Frost_Light = e.W;
        OUI_Bg_Popup_Overlay_Frost_Dark = e.X;
        OUI_Bg_Popup_Overlay_Fluid_Light = e.Y;
        OUI_Bg_Popup_Overlay_Fluid_Dark = e.Z;
        OUI_Bg_Popup_Overlay_Light = e.f13616a0;
        OUI_Bg_Popup_Overlay_Dark = e.f13618b0;
        OUI_Bg_Popup_Overlay = MaterialToken$OUI_Bg_Popup_Overlay$1.INSTANCE;
        OUI_Bg_Modal_Frost_Light = e.E;
        OUI_Bg_Modal_Frost_Dark = e.F;
        OUI_Bg_Modal_Fluid_Light = e.G;
        OUI_Bg_Modal_Fluid_Dark = e.H;
        OUI_Bg_Modal_Light = e.I;
        OUI_Bg_Modal_Dark = e.J;
        OUI_Bg_Modal = MaterialToken$OUI_Bg_Modal$1.INSTANCE;
        OUI_Bg_Floating_Overlay_Frost_Light = e.K;
        OUI_Bg_Floating_Overlay_Frost_Dark = e.L;
        OUI_Bg_Floating_Overlay_Fluid_Light = e.M;
        OUI_Bg_Floating_Overlay_Fluid_Dark = e.N;
        OUI_Bg_Floating_Overlay_Light = e.O;
        OUI_Bg_Floating_Overlay_Dark = e.P;
        OUI_Bg_Floating_Overlay = MaterialToken$OUI_Bg_Floating_Overlay$1.INSTANCE;
        OUI_Bg_Overlay_Search_Frost_Light = e.Q;
        OUI_Bg_Overlay_Search_Frost_Dark = e.R;
        OUI_Bg_Overlay_Search_Fluid_Light = e.S;
        OUI_Bg_Overlay_Search_Fluid_Dark = e.T;
        OUI_Bg_Overlay_Search_Light = e.U;
        OUI_Bg_Overlay_Search_Dark = e.V;
        OUI_Bg_Overlay_Search = MaterialToken$OUI_Bg_Overlay_Search$1.INSTANCE;
        OUI_Bg_Floating_Frost_Tinted_Light = e.f13620c0;
        OUI_Bg_Floating_Frost_Tinted_Dark = e.f13621d0;
        OUI_Bg_Floating_Fluid_Tinted_Light = e.f13622e0;
        OUI_Bg_Floating_Fluid_Tinted_Dark = e.f13623f0;
        OUI_Bg_Floating_Tinted_Light = e.g0;
        OUI_Bg_Floating_Tinted_Dark = e.f13625h0;
        OUI_Bg_Floating_Tinted = MaterialToken$OUI_Bg_Floating_Tinted$1.INSTANCE;
        OUI_Bg_Floating_Frost_Blue_Light = e.i0;
        OUI_Bg_Floating_Frost_Blue_Dark = e.f13628j0;
        OUI_Bg_Floating_Fluid_Blue_Light = e.f13630k0;
        OUI_Bg_Floating_Fluid_Blue_Dark = e.l0;
        OUI_Bg_Floating_Blue_Light = e.f13633m0;
        OUI_Bg_Floating_Blue_Dark = e.f13635n0;
        OUI_Bg_Floating_Blue = MaterialToken$OUI_Bg_Floating_Blue$1.INSTANCE;
        OUI_Text_Primary_Light = e.f13637o0;
        OUI_Text_Primary_Dark = e.f13639p0;
        OUI_Text_Primary = MaterialToken$OUI_Text_Primary$1.INSTANCE;
        OUI_Text_Secondary_Light = e.f13641q0;
        OUI_Text_Secondary_Dark = e.f13643r0;
        OUI_Text_Secondary = MaterialToken$OUI_Text_Secondary$1.INSTANCE;
        OUI_Text_Tertiary_Light = e.f13644s0;
        OUI_Text_Tertiary_Dark = e.f13646t0;
        OUI_Text_Tertiary = MaterialToken$OUI_Text_Tertiary$1.INSTANCE;
    }

    private MaterialToken() {
    }

    @JvmStatic
    public static final c compatibleConfig(c r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = n.b();
        if (r10 >= 1) goto L9;
        return null;
    L9:
        if (r10 < 4) goto L12;
        return r5.a();
    L12:
        if (r10 < 3) goto L15;
        return INSTANCE.toApi3CompatibleConfig(r5);
    L15:
        return INSTANCE.toLegacyCompatibleConfig(r5);
    }

    @JvmStatic
    public static final c[] compatibleConfigArray(c[] r10) {
        Object[] r5 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        boolean r11 = true;
        if (n.b() >= 1) goto L8;
        return null;
    L8:
        AnonymousClass1 r12 = new AnonymousClass1(INSTANCE);
        ArrayList r13 = new ArrayList();
        int r14 = r10.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L14;
        c r16 = r12.invoke(r10[r15]);
        if (r16 == null) goto L13;
        r13.add(r16);
    L13:
        r15 = r15 + 1;
        goto L9
    L14:
        Object[] r17 = r13.toArray(new c[0]);
        if (r17 == null) goto L25;
        if (((c[]) r17).length == 0) goto L20;
        r11 = false;
    L20:
        if (r11 == true) goto L23;
        r5 = r17;
    L23:
        return (c[]) r5;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
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
    public static final boolean isApiCompatible(int r5) {
        if (n.b() < r5) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean isApiCompatible$default(int r5, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r5 = 4;
    L6:
        return isApiCompatible(r5);
    }

    @JvmStatic
    public static final Function1<Boolean, c> parse(String r5) {
        ConcurrentHashMap<String, Function1<Boolean, c>> r10 = INSTANCE.getProviders();
        Intrinsics.checkNotNullParameter(r10, TestRig.LEXER_START_RULE_NAME);
        if (r5 != null) goto L5;
    L4:
        String r11 = null;
    L9:
        if (r11 != null) goto L11;
    L14:
        Function1<Boolean, c> r12 = null;
    L15:
        final Function1<Boolean, c> r13 = r12;
        if (r13 != null) goto L19;
        return null;
    L19:
        return new C01831(r13);
    L11:
        if (r11.length() == 0) goto L14;
        r12 = r10.get(r11);
        goto L15
    L5:
        String r14 = r5.toLowerCase(Locale.ROOT);
        if (r14 == null) goto L4;
        r11 = StringsKt.trim(r14).toString();
        goto L9
    }

    @JvmStatic
    public static final Function1<Boolean, c[]> parseSet(String r5) {
        ConcurrentHashMap<String, Function1<Boolean, c[]>> r10 = INSTANCE.getSetProviders();
        Intrinsics.checkNotNullParameter(r10, TestRig.LEXER_START_RULE_NAME);
        if (r5 != null) goto L5;
    L4:
        String r11 = null;
    L9:
        if (r11 != null) goto L11;
    L14:
        Function1<Boolean, c[]> r12 = null;
    L15:
        final Function1<Boolean, c[]> r13 = r12;
        if (r13 != null) goto L19;
        return null;
    L19:
        return new C01841(r13);
    L11:
        if (r11.length() == 0) goto L14;
        r12 = r10.get(r11);
        goto L15
    L5:
        String r14 = r5.toLowerCase(Locale.ROOT);
        if (r14 == null) goto L4;
        r11 = StringsKt.trim(r14).toString();
        goto L9
    }

    @JvmStatic
    public static final void register(Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "customTokenOwner");
        ConcurrentHashMap<String, c> r5 = INSTANCE.getTokens();
        LinkedHashMap r12 = new LinkedHashMap();
        Field[] r13 = r10.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r14 = r13.length;     // Catch: Exception -> L11
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L13;
        Field r16 = r13[r15];     // Catch: Exception -> L11
        r15 = r15 + 1;     // Catch: Exception -> L11
        if (c.class.isAssignableFrom(r16.getType()) == false) goto L4;
        r16.setAccessible(true);     // Catch: Exception -> L11
        Object r17 = r16.get(r10);     // Catch: Exception -> L11
        if ((r17 instanceof c) == false) goto L4;
        r12.put(r16.getName().toLowerCase(Locale.ROOT), r17);     // Catch: Exception -> L11
    L13:
        cl.a.K(r5, r12, r11);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r10.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void register$default(Object r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        register(r5, r10);
    }

    @JvmStatic
    public static final void registerProvider(Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "customTokenOwner");
        ConcurrentHashMap<String, Function1<Boolean, c>> r5 = INSTANCE.getProviders();
        LinkedHashMap r12 = new LinkedHashMap();
        Field[] r13 = r10.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r14 = r13.length;     // Catch: Exception -> L11
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L13;
        Field r16 = r13[r15];     // Catch: Exception -> L11
        r15 = r15 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r16.getType()) == false) goto L4;
        r16.setAccessible(true);     // Catch: Exception -> L11
        Object r17 = r16.get(r10);     // Catch: Exception -> L11
        if (TypeIntrinsics.isFunctionOfArity(r17, 1) == false) goto L4;
        r12.put(r16.getName().toLowerCase(Locale.ROOT), r17);     // Catch: Exception -> L11
    L13:
        cl.a.K(r5, r12, r11);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r10.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerProvider$default(Object r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerProvider(r5, r10);
    }

    @JvmStatic
    public static final void registerProviderTokens(Map<String, ? extends Function1<? super Boolean, c>> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        cl.a.K(INSTANCE.getProviders(), r5, r10);
    }

    public static /* synthetic */ void registerProviderTokens$default(Map r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerProviderTokens(r5, r10);
    }

    @JvmStatic
    public static final void registerSet(Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "customTokenOwner");
        ConcurrentHashMap<String, c[]> r5 = INSTANCE.getTokenSets();
        LinkedHashMap r12 = new LinkedHashMap();
        Field[] r13 = r10.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r14 = r13.length;     // Catch: Exception -> L11
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L13;
        Field r16 = r13[r15];     // Catch: Exception -> L11
        r15 = r15 + 1;     // Catch: Exception -> L11
        if (c[].class.isAssignableFrom(r16.getType()) == false) goto L4;
        r16.setAccessible(true);     // Catch: Exception -> L11
        Object r17 = r16.get(r10);     // Catch: Exception -> L11
        if ((r17 instanceof c[]) == false) goto L4;
        r12.put(r16.getName().toLowerCase(Locale.ROOT), r17);     // Catch: Exception -> L11
    L13:
        cl.a.K(r5, r12, r11);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r10.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerSet$default(Object r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerSet(r5, r10);
    }

    @JvmStatic
    public static final void registerSetProvider(Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "customTokenOwner");
        ConcurrentHashMap<String, Function1<Boolean, c[]>> r5 = INSTANCE.getSetProviders();
        LinkedHashMap r12 = new LinkedHashMap();
        Field[] r13 = r10.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r14 = r13.length;     // Catch: Exception -> L11
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L13;
        Field r16 = r13[r15];     // Catch: Exception -> L11
        r15 = r15 + 1;     // Catch: Exception -> L11
        if (Function1.class.isAssignableFrom(r16.getType()) == false) goto L4;
        r16.setAccessible(true);     // Catch: Exception -> L11
        Object r17 = r16.get(r10);     // Catch: Exception -> L11
        if (TypeIntrinsics.isFunctionOfArity(r17, 1) == false) goto L4;
        r12.put(r16.getName().toLowerCase(Locale.ROOT), r17);     // Catch: Exception -> L11
    L13:
        cl.a.K(r5, r12, r11);
        return;
    L11:
        e = move-exception;
        Log.e("TokenParser", Intrinsics.stringPlus("Failed to parse tokens from ", r10.getClass().getSimpleName()), e);
        goto L13
    }

    public static /* synthetic */ void registerSetProvider$default(Object r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerSetProvider(r5, r10);
    }

    @JvmStatic
    public static final void registerSetProviderTokens(Map<String, ? extends Function1<? super Boolean, c[]>> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        cl.a.K(INSTANCE.getSetProviders(), r5, r10);
    }

    public static /* synthetic */ void registerSetProviderTokens$default(Map r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerSetProviderTokens(r5, r10);
    }

    @JvmStatic
    public static final void registerTokenSets(Map<String, c[]> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        cl.a.K(INSTANCE.getTokenSets(), r5, r10);
    }

    public static /* synthetic */ void registerTokenSets$default(Map r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerTokenSets(r5, r10);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, c> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        cl.a.K(INSTANCE.getTokens(), r5, r10);
    }

    public static /* synthetic */ void registerTokens$default(Map r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerTokens(r5, r10);
    }

    private final c toApi3CompatibleConfig(c r5) {
        return r5.a();
    }

    private final c toLegacyCompatibleConfig(c r5) {
        c r10 = r5.a();
        com.obric.oui.color.a[] r11 = r10.f13611c;
        if (r11 != null) goto L8;
        cs.a r12 = r10.f13610b;
        if (r12 != null) goto L7;
        r11 = null;
        goto L8
    L7:
        r11 = r12.f16500a.f16503c;
    L8:
        r10.f13611c = r11;
        r10.f13610b = null;
        com.obric.oui.color.d r13 = r10.e;
        if (r13 != null) goto L14;
        cs.c r14 = r10.d;
        if (r14 != null) goto L13;
        r13 = null;
        goto L14
    L13:
        r13 = r14.f16506c;
    L14:
        r10.e = r13;
        r10.d = null;
        r10.f = null;
        r10.f13614j = null;
        return r10;
    }

    public final c[] resolveTokenForBuilder$OUI_standardRelease(String r10, boolean r11) {
        c[] r5 = (c[]) cl.a.J(r10, getTokenSets());
        String r12 = "_dark";
        if (r5 != null) goto L9;
        if (r11 == false) goto L6;
        Object r13 = "_light";
    L7:
        r5 = (c[]) cl.a.J(Intrinsics.stringPlus(r10, r13), getTokenSets());
        goto L9
    L6:
        r13 = "_dark";
    L9:
        if (r5 == null) goto L19;
        ArrayList r14 = new ArrayList(r5.length);
        int r15 = r5.length;
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L13;
        r14.add(r5[r16].a());
        r16 = r16 + 1;
        goto L11
    L13:
        Object[] r17 = r14.toArray(new c[0]);
        if (r17 == null) goto L18;
        return (c[]) r17;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L19:
        Function1 r18 = (Function1) cl.a.J(r10, getSetProviders());
        if (r18 != null) goto L35;
        c r19 = (c) cl.a.J(r10, getTokens());
        if (r19 != null) goto L26;
        if (r11 == false) goto L25;
        r12 = "_light";
    L25:
        r19 = (c) cl.a.J(Intrinsics.stringPlus(r10, r12), getTokens());
    L26:
        if (r19 != null) goto L28;
        Function1 r20 = (Function1) cl.a.J(r10, getProviders());
        if (r20 != null) goto L34;
        return null;
    L34:
        return new c[]{((c) r20.invoke(Boolean.valueOf(r11))).a()};
    L28:
        return new c[]{r19.a()};
    L35:
        Object[] r21 = (Object[]) r18.invoke(Boolean.valueOf(r11));
        ArrayList r22 = new ArrayList(r21.length);
        int r23 = r21.length;
        int r24 = 0;
    L36:
        if (r24 >= r23) goto L38;
        r22.add(((c) r21[r24]).a());
        r24 = r24 + 1;
        goto L36
    L38:
        Object[] r25 = r22.toArray(new c[0]);
        if (r25 == null) goto L43;
        return (c[]) r25;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @JvmStatic
    public static final c parse(String r10, boolean r11) {
        MaterialToken r5 = INSTANCE;
        ConcurrentHashMap<String, c> r12 = r5.getTokens();
        Intrinsics.checkNotNullParameter(r12, TestRig.LEXER_START_RULE_NAME);
        c r13 = null;
        if (r10 != null) goto L5;
    L4:
        String r14 = null;
    L9:
        if (r14 != null) goto L11;
    L14:
        c r15 = null;
    L15:
        c r16 = r15;
        if (r16 != null) goto L34;
        if (r11 == false) goto L19;
        String r17 = "_light";
    L20:
        String r18 = Intrinsics.stringPlus(r10, r17);
        ConcurrentHashMap<String, c> r19 = r5.getTokens();
        Intrinsics.checkNotNullParameter(r19, TestRig.LEXER_START_RULE_NAME);
        if (r18 != null) goto L23;
    L22:
        String r20 = null;
    L27:
        if (r20 != null) goto L29;
    L32:
        r16 = r13;
        goto L34
    L29:
        if (r20.length() == 0) goto L32;
        r13 = r19.get(r20);
        goto L32
    L23:
        String r21 = r18.toLowerCase(Locale.ROOT);
        if (r21 == null) goto L22;
        r20 = StringsKt.trim(r21).toString();
        goto L27
    L19:
        r17 = "_dark";
    L34:
        return compatibleConfig(r16);
    L11:
        if (r14.length() == 0) goto L14;
        r15 = r12.get(r14);
        goto L15
    L5:
        String r22 = r10.toLowerCase(Locale.ROOT);
        if (r22 == null) goto L4;
        r14 = StringsKt.trim(r22).toString();
        goto L9
    }

    @JvmStatic
    public static final c[] parseSet(String r10, boolean r11) {
        MaterialToken r5 = INSTANCE;
        ConcurrentHashMap<String, c[]> r12 = r5.getTokenSets();
        Intrinsics.checkNotNullParameter(r12, TestRig.LEXER_START_RULE_NAME);
        c[] r13 = null;
        if (r10 != null) goto L5;
    L4:
        String r14 = null;
    L9:
        if (r14 != null) goto L11;
    L14:
        c[] r15 = null;
    L15:
        c[] r16 = r15;
        if (r16 != null) goto L33;
        if (r11 == false) goto L19;
        String r17 = "_light";
    L20:
        String r18 = Intrinsics.stringPlus(r10, r17);
        ConcurrentHashMap<String, c[]> r19 = r5.getTokenSets();
        Intrinsics.checkNotNullParameter(r19, TestRig.LEXER_START_RULE_NAME);
        if (r18 != null) goto L23;
    L22:
        String r20 = null;
    L27:
        if (r20 != null) goto L29;
    L32:
        r16 = r13;
        goto L33
    L29:
        if (r20.length() == 0) goto L32;
        r13 = r19.get(r20);
        goto L32
    L23:
        String r21 = r18.toLowerCase(Locale.ROOT);
        if (r21 == null) goto L22;
        r20 = StringsKt.trim(r21).toString();
        goto L27
    L19:
        r17 = "_dark";
    L33:
        if (r16 != null) goto L38;
        c r22 = parse(r10, r11);
        if (r22 == null) goto L38;
        r16 = new c[]{r22};
    L38:
        return compatibleConfigArray(r16);
    L11:
        if (r14.length() == 0) goto L14;
        r15 = r12.get(r14);
        goto L15
    L5:
        String r23 = r10.toLowerCase(Locale.ROOT);
        if (r23 == null) goto L4;
        r14 = StringsKt.trim(r23).toString();
        goto L9
    }
}
