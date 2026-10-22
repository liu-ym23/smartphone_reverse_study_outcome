package com.obric.oui.color;

import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.view.ViewCompat;
import androidx.room.jarjarred.org.antlr.v4.gui.TestRig;
import com.obric.oui.graphic.BlendMode;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0003\b\u00ad\u0001\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ3\u0010\u000f\u001a\u00020\u00072\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\tJ?\u0010\u0013\u001a\u00020\u00072$\u0010\u000e\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00120\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0013\u0010\u0010J-\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0015\u0010\u0018R-\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR9\u0010!\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00120\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010#R2\u0010%\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010\u0003\u001a\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010#R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010#R2\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b,\u0010&\u0012\u0004\b.\u0010\u0003\u001a\u0004\b-\u0010(R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u0010#R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010#R2\u00101\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b1\u0010&\u0012\u0004\b3\u0010\u0003\u001a\u0004\b2\u0010(R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b4\u0010#R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u0010#R2\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b6\u0010&\u0012\u0004\b8\u0010\u0003\u001a\u0004\b7\u0010(R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b9\u0010#R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b:\u0010#R2\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b;\u0010&\u0012\u0004\b=\u0010\u0003\u001a\u0004\b<\u0010(R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010#R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010#R2\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b@\u0010&\u0012\u0004\bB\u0010\u0003\u001a\u0004\bA\u0010(R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010#R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010#R2\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bE\u0010&\u0012\u0004\bG\u0010\u0003\u001a\u0004\bF\u0010(R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bH\u0010#R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010#R2\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bJ\u0010&\u0012\u0004\bL\u0010\u0003\u001a\u0004\bK\u0010(R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bM\u0010#R\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bN\u0010#R\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010#R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010#R2\u0010Q\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bQ\u0010&\u0012\u0004\bS\u0010\u0003\u001a\u0004\bR\u0010(R\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bT\u0010#R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bU\u0010#R\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010#R\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bW\u0010#R2\u0010X\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bX\u0010&\u0012\u0004\bZ\u0010\u0003\u001a\u0004\bY\u0010(R\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b[\u0010#R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\\\u0010#R2\u0010]\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b]\u0010&\u0012\u0004\b_\u0010\u0003\u001a\u0004\b^\u0010(R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b`\u0010#R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010#R2\u0010b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bb\u0010&\u0012\u0004\bd\u0010\u0003\u001a\u0004\bc\u0010(R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\be\u0010#R\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bf\u0010#R\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bg\u0010#R\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bh\u0010#R2\u0010i\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bi\u0010&\u0012\u0004\bk\u0010\u0003\u001a\u0004\bj\u0010(R\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bl\u0010#R\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bm\u0010#R2\u0010n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bn\u0010&\u0012\u0004\bp\u0010\u0003\u001a\u0004\bo\u0010(R\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010#R\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\br\u0010#R2\u0010s\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bs\u0010&\u0012\u0004\bu\u0010\u0003\u001a\u0004\bt\u0010(R\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bv\u0010#R\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010#R2\u0010x\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bx\u0010&\u0012\u0004\bz\u0010\u0003\u001a\u0004\by\u0010(R\u001a\u0010{\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b{\u0010#R\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b|\u0010#R2\u0010}\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b}\u0010&\u0012\u0004\b\u007f\u0010\u0003\u001a\u0004\b~\u0010(R\u001c\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010#R\u001c\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010#R6\u0010\u0082\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010&\u0012\u0005\b\u0084\u0001\u0010\u0003\u001a\u0005\b\u0083\u0001\u0010(R\u001c\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010#R\u001c\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010#R6\u0010\u0087\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010&\u0012\u0005\b\u0089\u0001\u0010\u0003\u001a\u0005\b\u0088\u0001\u0010(R\u001c\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010#R\u001c\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010#R6\u0010\u008c\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010&\u0012\u0005\b\u008e\u0001\u0010\u0003\u001a\u0005\b\u008d\u0001\u0010(R\u0017\u0010\u008f\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0017\u0010\u0091\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0090\u0001R\u0017\u0010\u0092\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0090\u0001R\u0017\u0010\u0093\u0001\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0090\u0001R\u001c\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010#R\u001c\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0095\u0001\u0010#R6\u0010\u0096\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010&\u0012\u0005\b\u0098\u0001\u0010\u0003\u001a\u0005\b\u0097\u0001\u0010(R\u001c\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010#R\u001c\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010#R6\u0010\u009b\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b\u009b\u0001\u0010&\u0012\u0005\b\u009d\u0001\u0010\u0003\u001a\u0005\b\u009c\u0001\u0010(R\u001c\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009e\u0001\u0010#R\u001c\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010#R6\u0010 \u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b \u0001\u0010&\u0012\u0005\b¢\u0001\u0010\u0003\u001a\u0005\b¡\u0001\u0010(R\u001c\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b£\u0001\u0010#R\u001c\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¤\u0001\u0010#R6\u0010¥\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b¥\u0001\u0010&\u0012\u0005\b§\u0001\u0010\u0003\u001a\u0005\b¦\u0001\u0010(R\u001c\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¨\u0001\u0010#R\u001c\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b©\u0001\u0010#R6\u0010ª\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\bª\u0001\u0010&\u0012\u0005\b¬\u0001\u0010\u0003\u001a\u0005\b«\u0001\u0010(R\u001c\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010#R\u001c\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b®\u0001\u0010#R6\u0010¯\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b¯\u0001\u0010&\u0012\u0005\b±\u0001\u0010\u0003\u001a\u0005\b°\u0001\u0010(R\u001c\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b²\u0001\u0010#R\u001c\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b³\u0001\u0010#R6\u0010´\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b´\u0001\u0010&\u0012\u0005\b¶\u0001\u0010\u0003\u001a\u0005\bµ\u0001\u0010(R\u001c\u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b·\u0001\u0010#R\u001c\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¸\u0001\u0010#R6\u0010¹\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b¹\u0001\u0010&\u0012\u0005\b»\u0001\u0010\u0003\u001a\u0005\bº\u0001\u0010(R\u001c\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b¼\u0001\u0010#R\u001c\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\b½\u0001\u0010#R6\u0010¾\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\b¾\u0001\u0010&\u0012\u0005\bÀ\u0001\u0010\u0003\u001a\u0005\b¿\u0001\u0010(R\u001c\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bÁ\u0001\u0010#R\u001c\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u0007\n\u0005\bÂ\u0001\u0010#R6\u0010Ã\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006X\u0087\u0004¢\u0006\u0015\n\u0005\bÃ\u0001\u0010&\u0012\u0005\bÅ\u0001\u0010\u0003\u001a\u0005\bÄ\u0001\u0010(¨\u0006Æ\u0001"}, d2 = {"Lcom/obric/oui/color/BlendToken;", "", "<init>", "()V", "customTokenOwner", "", "overrideExisting", "", "register", "(Ljava/lang/Object;Z)V", "", "", "", "Lcom/obric/oui/color/a;", "customTokens", "registerTokens", "(Ljava/util/Map;Z)V", "registerProvider", "Lkotlin/Function1;", "registerProviderTokens", "name", "parse", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "isLight", "(Ljava/lang/String;Z)[Lcom/obric/oui/color/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", TestRig.LEXER_START_RULE_NAME, "providers$delegate", "getProviders", "providers", "Blend_Base_Thick_Light", "[Lcom/obric/oui/color/a;", "Blend_Base_Thick_Dark", "Blend_Base_Thick", "Lkotlin/jvm/functions/Function1;", "getBlend_Base_Thick", "()Lkotlin/jvm/functions/Function1;", "getBlend_Base_Thick$annotations", "Blend_Base_Regular_Light", "Blend_Base_Regular_Dark", "Blend_Base_Regular", "getBlend_Base_Regular", "getBlend_Base_Regular$annotations", "OUI_Color_Blend_Frost_Regular_Light", "OUI_Color_Blend_Frost_Regular_Dark", "OUI_Color_Blend_Frost_Regular", "getOUI_Color_Blend_Frost_Regular", "getOUI_Color_Blend_Frost_Regular$annotations", "OUI_Color_Blend_Fluid_Regular_Light", "OUI_Color_Blend_Fluid_Regular_Dark", "OUI_Color_Blend_Fluid_Regular", "getOUI_Color_Blend_Fluid_Regular", "getOUI_Color_Blend_Fluid_Regular$annotations", "OUI_Color_Blend_Frost_UltraThin_Light", "OUI_Color_Blend_Frost_UltraThin_Dark", "OUI_Color_Blend_Frost_UltraThin", "getOUI_Color_Blend_Frost_UltraThin", "getOUI_Color_Blend_Frost_UltraThin$annotations", "OUI_Color_Blend_Fluid_UltraThin_Light", "OUI_Color_Blend_Fluid_UltraThin_Dark", "OUI_Color_Blend_Fluid_UltraThin", "getOUI_Color_Blend_Fluid_UltraThin", "getOUI_Color_Blend_Fluid_UltraThin$annotations", "OUI_Color_Blend_Frost_Thin_Light", "OUI_Color_Blend_Frost_Thin_Dark", "OUI_Color_Blend_Frost_Thin", "getOUI_Color_Blend_Frost_Thin", "getOUI_Color_Blend_Frost_Thin$annotations", "OUI_Color_Blend_Fluid_Thin_Light", "OUI_Color_Blend_Fluid_Thin_Dark", "OUI_Color_Blend_Fluid_Thin", "getOUI_Color_Blend_Fluid_Thin", "getOUI_Color_Blend_Fluid_Thin$annotations", "OUI_Color_Blend_Frost_Thick_Light", "OUI_Color_Blend_Frost_Thick_Dark", "OUI_Color_Blend_Fluid_Thick_Light", "OUI_Color_Blend_Fluid_Thick_Dark", "OUI_Color_Blend_Fluid_Thick", "getOUI_Color_Blend_Fluid_Thick", "getOUI_Color_Blend_Fluid_Thick$annotations", "OUI_Color_Fills_Thick_Light", "OUI_Color_Fills_Thick_Dark", "OUI_Color_Blend_Text_Primary_Light", "OUI_Color_Blend_Text_Primary_Dark", "OUI_Color_Blend_Text_Primary", "getOUI_Color_Blend_Text_Primary", "getOUI_Color_Blend_Text_Primary$annotations", "OUI_Color_Blend_Text_Secondary_Light", "OUI_Color_Blend_Text_Secondary_Dark", "OUI_Color_Blend_Text_Secondary", "getOUI_Color_Blend_Text_Secondary", "getOUI_Color_Blend_Text_Secondary$annotations", "OUI_Color_Blend_Text_Tertiary_Light", "OUI_Color_Blend_Text_Tertiary_Dark", "OUI_Color_Blend_Text_Tertiary", "getOUI_Color_Blend_Text_Tertiary", "getOUI_Color_Blend_Text_Tertiary$annotations", "OUI_Color_Blend_Fill_Tinted_Light", "OUI_Color_Blend_Fill_Tinted_Dark", "OUI_Color_Blend_Blue_Thin_Light", "OUI_Color_Blend_Blue_Thin_Dark", "OUI_Color_Blend_Blue_Thin", "getOUI_Color_Blend_Blue_Thin", "getOUI_Color_Blend_Blue_Thin$annotations", "OUI_Color_Blend_Blue_Regular_Light", "OUI_Color_Blend_Blue_Regular_Dark", "OUI_Color_Blend_Blue_Regular", "getOUI_Color_Blend_Blue_Regular", "getOUI_Color_Blend_Blue_Regular$annotations", "OUI_Color_Blend_Red_Thin_Light", "OUI_Color_Blend_Red_Thin_Dark", "OUI_Color_Blend_Red_Thin", "getOUI_Color_Blend_Red_Thin", "getOUI_Color_Blend_Red_Thin$annotations", "OUI_Color_Blend_Red_Regular_Light", "OUI_Color_Blend_Red_Regular_Dark", "OUI_Color_Blend_Red_Regular", "getOUI_Color_Blend_Red_Regular", "getOUI_Color_Blend_Red_Regular$annotations", "OUI_Color_Blend_Green_Thin_Light", "OUI_Color_Blend_Green_Thin_Dark", "OUI_Color_Blend_Green_Thin", "getOUI_Color_Blend_Green_Thin", "getOUI_Color_Blend_Green_Thin$annotations", "OUI_Color_Blend_Green_Regular_Light", "OUI_Color_Blend_Green_Regular_Dark", "OUI_Color_Blend_Green_Regular", "getOUI_Color_Blend_Green_Regular", "getOUI_Color_Blend_Green_Regular$annotations", "OUI_Color_Blend_Yellow_Thin_Light", "OUI_Color_Blend_Yellow_Thin_Dark", "OUI_Color_Blend_Yellow_Thin", "getOUI_Color_Blend_Yellow_Thin", "getOUI_Color_Blend_Yellow_Thin$annotations", "OUI_Color_Blend_Yellow_Regular_Light", "OUI_Color_Blend_Yellow_Regular_Dark", "OUI_Color_Blend_Yellow_Regular", "getOUI_Color_Blend_Yellow_Regular", "getOUI_Color_Blend_Yellow_Regular$annotations", "OUI_Color_State_Press_Light", "Lcom/obric/oui/color/a;", "OUI_Color_State_Press_Dark", "OUI_Color_State_Active_Light", "OUI_Color_State_Active_Dark", "Blend_Blue_6_Light", "Blend_Blue_6_Dark", "Blend_Blue_6", "getBlend_Blue_6", "getBlend_Blue_6$annotations", "Blend_Blue_4_Light", "Blend_Blue_4_Dark", "Blend_Blue_4", "getBlend_Blue_4", "getBlend_Blue_4$annotations", "Blend_Yellow_6_Light", "Blend_Yellow_6_Dark", "Blend_Yellow_6", "getBlend_Yellow_6", "getBlend_Yellow_6$annotations", "Blend_Yellow_4_Light", "Blend_Yellow_4_Dark", "Blend_Yellow_4", "getBlend_Yellow_4", "getBlend_Yellow_4$annotations", "Blend_Green_6_Light", "Blend_Green_6_Dark", "Blend_Green_6", "getBlend_Green_6", "getBlend_Green_6$annotations", "Blend_Green_4_Light", "Blend_Green_4_Dark", "Blend_Green_4", "getBlend_Green_4", "getBlend_Green_4$annotations", "Blend_Red_6_Light", "Blend_Red_6_Dark", "Blend_Red_6", "getBlend_Red_6", "getBlend_Red_6$annotations", "Blend_Red_4_Light", "Blend_Red_4_Dark", "Blend_Red_4", "getBlend_Red_4", "getBlend_Red_4$annotations", "Blend_Fill_Element_2_Light", "Blend_Fill_Element_2_Dark", "Blend_Fill_Element_2", "getBlend_Fill_Element_2", "getBlend_Fill_Element_2$annotations", "Blend_Fluid_Thin_Light", "Blend_Fluid_Thin_Dark", "Blend_Fluid_Thin", "getBlend_Fluid_Thin", "getBlend_Fluid_Thin$annotations", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlendToken {
    private static final Function1<Boolean, a[]> Blend_Base_Regular = null;

    @JvmField
    public static final a[] Blend_Base_Regular_Dark = null;

    @JvmField
    public static final a[] Blend_Base_Regular_Light = null;
    private static final Function1<Boolean, a[]> Blend_Base_Thick = null;

    @JvmField
    public static final a[] Blend_Base_Thick_Dark = null;

    @JvmField
    public static final a[] Blend_Base_Thick_Light = null;
    private static final Function1<Boolean, a[]> Blend_Blue_4 = null;

    @JvmField
    public static final a[] Blend_Blue_4_Dark = null;

    @JvmField
    public static final a[] Blend_Blue_4_Light = null;
    private static final Function1<Boolean, a[]> Blend_Blue_6 = null;

    @JvmField
    public static final a[] Blend_Blue_6_Dark = null;

    @JvmField
    public static final a[] Blend_Blue_6_Light = null;
    private static final Function1<Boolean, a[]> Blend_Fill_Element_2 = null;

    @JvmField
    public static final a[] Blend_Fill_Element_2_Dark = null;

    @JvmField
    public static final a[] Blend_Fill_Element_2_Light = null;
    private static final Function1<Boolean, a[]> Blend_Fluid_Thin = null;

    @JvmField
    public static final a[] Blend_Fluid_Thin_Dark = null;

    @JvmField
    public static final a[] Blend_Fluid_Thin_Light = null;
    private static final Function1<Boolean, a[]> Blend_Green_4 = null;

    @JvmField
    public static final a[] Blend_Green_4_Dark = null;

    @JvmField
    public static final a[] Blend_Green_4_Light = null;
    private static final Function1<Boolean, a[]> Blend_Green_6 = null;

    @JvmField
    public static final a[] Blend_Green_6_Dark = null;

    @JvmField
    public static final a[] Blend_Green_6_Light = null;
    private static final Function1<Boolean, a[]> Blend_Red_4 = null;

    @JvmField
    public static final a[] Blend_Red_4_Dark = null;

    @JvmField
    public static final a[] Blend_Red_4_Light = null;
    private static final Function1<Boolean, a[]> Blend_Red_6 = null;

    @JvmField
    public static final a[] Blend_Red_6_Dark = null;

    @JvmField
    public static final a[] Blend_Red_6_Light = null;
    private static final Function1<Boolean, a[]> Blend_Yellow_4 = null;

    @JvmField
    public static final a[] Blend_Yellow_4_Dark = null;

    @JvmField
    public static final a[] Blend_Yellow_4_Light = null;
    private static final Function1<Boolean, a[]> Blend_Yellow_6 = null;

    @JvmField
    public static final a[] Blend_Yellow_6_Dark = null;

    @JvmField
    public static final a[] Blend_Yellow_6_Light = null;
    public static final BlendToken INSTANCE = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Blue_Regular = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Blue_Regular_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Blue_Regular_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Blue_Thin = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Blue_Thin_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Blue_Thin_Light = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fill_Tinted_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fill_Tinted_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Regular = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fluid_Regular_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fluid_Regular_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Thick = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fluid_Thick_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fluid_Thick_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Fluid_Thin = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fluid_Thin_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fluid_Thin_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Fluid_UltraThin = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fluid_UltraThin_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Fluid_UltraThin_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Frost_Regular = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Frost_Regular_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Frost_Regular_Light = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Frost_Thick_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Frost_Thick_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Frost_Thin = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Frost_Thin_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Frost_Thin_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Frost_UltraThin = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Frost_UltraThin_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Frost_UltraThin_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Green_Regular = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Green_Regular_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Green_Regular_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Green_Thin = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Green_Thin_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Green_Thin_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Red_Regular = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Red_Regular_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Red_Regular_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Red_Thin = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Red_Thin_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Red_Thin_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Text_Primary = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Text_Primary_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Text_Primary_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Text_Secondary = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Text_Secondary_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Text_Secondary_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Text_Tertiary = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Text_Tertiary_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Text_Tertiary_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Yellow_Regular = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Yellow_Regular_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Yellow_Regular_Light = null;
    private static final Function1<Boolean, a[]> OUI_Color_Blend_Yellow_Thin = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Yellow_Thin_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Blend_Yellow_Thin_Light = null;

    @JvmField
    public static final a[] OUI_Color_Fills_Thick_Dark = null;

    @JvmField
    public static final a[] OUI_Color_Fills_Thick_Light = null;

    @JvmField
    public static final a OUI_Color_State_Active_Dark = null;

    @JvmField
    public static final a OUI_Color_State_Active_Light = null;

    @JvmField
    public static final a OUI_Color_State_Press_Dark = null;

    @JvmField
    public static final a OUI_Color_State_Press_Light = null;
    private static final Lazy providers$delegate = null;
    private static final Lazy tokens$delegate = null;

    static {
        INSTANCE = new BlendToken();
        tokens$delegate = LazyKt.lazy(BlendToken$tokens$2.INSTANCE);
        providers$delegate = LazyKt.lazy(BlendToken$providers$2.INSTANCE);
        BlendMode r5 = BlendMode.COLOR_DODGE;
        a r10 = new a(-1726013665, r5);
        BlendMode r11 = BlendMode.SRC_OVER;
        Blend_Base_Thick_Light = new a[]{r10, new a(-604571914, r11)};
        BlendMode r12 = BlendMode.COLOR_BURN;
        Blend_Base_Thick_Dark = new a[]{new a(-3355444, r12), new a(-618388444, r11)};
        Blend_Base_Thick = BlendToken$Blend_Base_Thick$1.INSTANCE;
        Blend_Base_Regular_Light = new a[]{new a(-14737633, r5), new a(-855638017, r11)};
        Blend_Base_Regular_Dark = new a[]{new a(-3355444, r12), new a(-666746302, r11)};
        Blend_Base_Regular = BlendToken$Blend_Base_Regular$1.INSTANCE;
        OUI_Color_Blend_Frost_Regular_Light = new a[]{new a(-14737633, r5), new a(-855638017, r11)};
        OUI_Color_Blend_Frost_Regular_Dark = new a[]{new a(-3355444, r12), new a(-868072894, r11)};
        OUI_Color_Blend_Frost_Regular = BlendToken$OUI_Color_Blend_Frost_Regular$1.INSTANCE;
        BlendMode r13 = BlendMode.LUMINOSITY;
        OUI_Color_Blend_Fluid_Regular_Light = new a[]{new a(1722987186, r13), new a(-13421773, r5), new a(872415231, r11)};
        OUI_Color_Blend_Fluid_Regular_Dark = new a[]{new a(-2137483112, r13), new a(-1716210508, r12), new a(352321535, r11)};
        OUI_Color_Blend_Fluid_Regular = BlendToken$OUI_Color_Blend_Fluid_Regular$1.INSTANCE;
        BlendMode r14 = BlendMode.PLUS_LIGHTER;
        OUI_Color_Blend_Frost_UltraThin_Light = new a[]{new a(-14737633, r14)};
        OUI_Color_Blend_Frost_UltraThin_Dark = new a[]{new a(-14737633, r14)};
        OUI_Color_Blend_Frost_UltraThin = BlendToken$OUI_Color_Blend_Frost_UltraThin$1.INSTANCE;
        OUI_Color_Blend_Fluid_UltraThin_Light = new a[]{new a(-15461356, r14)};
        OUI_Color_Blend_Fluid_UltraThin_Dark = new a[]{new a(-15461356, r14)};
        OUI_Color_Blend_Fluid_UltraThin = BlendToken$OUI_Color_Blend_Fluid_UltraThin$1.INSTANCE;
        OUI_Color_Blend_Frost_Thin_Light = new a[]{new a(1722329256, r13), new a(-13421773, r5), new a(-1711276033, r11)};
        OUI_Color_Blend_Frost_Thin_Dark = new a[]{new a(-2137417319, r13)};
        OUI_Color_Blend_Frost_Thin = BlendToken$OUI_Color_Blend_Frost_Thin$1.INSTANCE;
        OUI_Color_Blend_Fluid_Thin_Light = new a[]{new a(869059788, r13), new a(-1724697805, r5), new a(352321535, r11)};
        OUI_Color_Blend_Fluid_Thin_Dark = new a[]{new a(1721342361, r13)};
        OUI_Color_Blend_Fluid_Thin = BlendToken$OUI_Color_Blend_Fluid_Thin$1.INSTANCE;
        OUI_Color_Blend_Frost_Thick_Light = new a[]{new a(-1726013665, r5), new a(-604506121, r11)};
        OUI_Color_Blend_Frost_Thick_Dark = new a[]{new a(-3355444, r12), new a(-618059479, r11)};
        OUI_Color_Blend_Fluid_Thick_Light = new a[]{new a(-1726013665, r5), new a(-604506121, r11)};
        OUI_Color_Blend_Fluid_Thick_Dark = new a[]{new a(-858993460, r12), new a(-869717719, r11)};
        OUI_Color_Blend_Fluid_Thick = BlendToken$OUI_Color_Blend_Fluid_Thick$1.INSTANCE;
        OUI_Color_Fills_Thick_Light = new a[]{new a(251658240, r11)};
        OUI_Color_Fills_Thick_Dark = new a[]{new a(620756991, r11)};
        BlendMode r15 = BlendMode.PLUS_DARKER;
        OUI_Color_Blend_Text_Primary_Light = new a[]{new a(-13421773, r15)};
        OUI_Color_Blend_Text_Primary_Dark = new a[]{new a(-2500135, r14)};
        OUI_Color_Blend_Text_Primary = BlendToken$OUI_Color_Blend_Text_Primary$1.INSTANCE;
        OUI_Color_Blend_Text_Secondary_Light = new a[]{new a(-6710887, r15)};
        OUI_Color_Blend_Text_Secondary_Dark = new a[]{new a(-9211021, r14)};
        OUI_Color_Blend_Text_Secondary = BlendToken$OUI_Color_Blend_Text_Secondary$1.INSTANCE;
        OUI_Color_Blend_Text_Tertiary_Light = new a[]{new a(-4342339, r15)};
        OUI_Color_Blend_Text_Tertiary_Dark = new a[]{new a(-10921639, r14)};
        OUI_Color_Blend_Text_Tertiary = BlendToken$OUI_Color_Blend_Text_Tertiary$1.INSTANCE;
        a r16 = new a(-2130706433, r11);
        BlendMode r17 = BlendMode.OVERLAY;
        OUI_Color_Blend_Fill_Tinted_Light = new a[]{r16, new a(-3355444, r17), new a(-1, r15)};
        OUI_Color_Blend_Fill_Tinted_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(ViewCompat.MEASURED_STATE_MASK, r15)};
        OUI_Color_Blend_Blue_Thin_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-10049793, r15)};
        OUI_Color_Blend_Blue_Thin_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-10049793, r15)};
        OUI_Color_Blend_Blue_Thin = BlendToken$OUI_Color_Blend_Blue_Thin$1.INSTANCE;
        OUI_Color_Blend_Blue_Regular_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-14253569, r15)};
        OUI_Color_Blend_Blue_Regular_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-14253569, r15)};
        OUI_Color_Blend_Blue_Regular = BlendToken$OUI_Color_Blend_Blue_Regular$1.INSTANCE;
        OUI_Color_Blend_Red_Thin_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-30841, r15)};
        OUI_Color_Blend_Red_Thin_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-30841, r15)};
        OUI_Color_Blend_Red_Thin = BlendToken$OUI_Color_Blend_Red_Thin$1.INSTANCE;
        OUI_Color_Blend_Red_Regular_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-45747, r15)};
        OUI_Color_Blend_Red_Regular_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-45747, r15)};
        OUI_Color_Blend_Red_Regular = BlendToken$OUI_Color_Blend_Red_Regular$1.INSTANCE;
        OUI_Color_Blend_Green_Thin_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-8917601, r15)};
        OUI_Color_Blend_Green_Thin_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-8917601, r15)};
        OUI_Color_Blend_Green_Thin = BlendToken$OUI_Color_Blend_Green_Thin$1.INSTANCE;
        OUI_Color_Blend_Green_Regular_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-15415472, r15)};
        OUI_Color_Blend_Green_Regular_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-15415472, r15)};
        OUI_Color_Blend_Green_Regular = BlendToken$OUI_Color_Blend_Green_Regular$1.INSTANCE;
        OUI_Color_Blend_Yellow_Thin_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-11671, r15)};
        OUI_Color_Blend_Yellow_Thin_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-11671, r15)};
        OUI_Color_Blend_Yellow_Thin = BlendToken$OUI_Color_Blend_Yellow_Thin$1.INSTANCE;
        OUI_Color_Blend_Yellow_Regular_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-15078, r15)};
        OUI_Color_Blend_Yellow_Regular_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-15078, r15)};
        OUI_Color_Blend_Yellow_Regular = BlendToken$OUI_Color_Blend_Yellow_Regular$1.INSTANCE;
        OUI_Color_State_Press_Light = new a(-13421773, r14);
        OUI_Color_State_Press_Dark = new a(-1724697805, r14);
        OUI_Color_State_Active_Light = new a(-6710887, r14);
        OUI_Color_State_Active_Dark = new a(-6710887, r14);
        Blend_Blue_6_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-15042049, r15)};
        Blend_Blue_6_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-15042049, r15)};
        Blend_Blue_6 = BlendToken$Blend_Blue_6$1.INSTANCE;
        Blend_Blue_4_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-10049793, r15)};
        Blend_Blue_4_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-10049793, r15)};
        Blend_Blue_4 = BlendToken$Blend_Blue_4$1.INSTANCE;
        Blend_Yellow_6_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-873984, r15)};
        Blend_Yellow_6_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-873984, r15)};
        Blend_Yellow_6 = BlendToken$Blend_Yellow_6$1.INSTANCE;
        Blend_Yellow_4_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-11671, r15)};
        Blend_Yellow_4_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-11671, r15)};
        Blend_Yellow_4 = BlendToken$Blend_Yellow_4$1.INSTANCE;
        Blend_Green_6_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-16722873, r15)};
        Blend_Green_6_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-16722873, r15)};
        Blend_Green_6 = BlendToken$Blend_Green_6$1.INSTANCE;
        Blend_Green_4_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-8917601, r15)};
        Blend_Green_4_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-8917601, r15)};
        Blend_Green_4 = BlendToken$Blend_Green_4$1.INSTANCE;
        Blend_Red_6_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-53971, r15)};
        Blend_Red_6_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-53971, r15)};
        Blend_Red_6 = BlendToken$Blend_Red_6$1.INSTANCE;
        Blend_Red_4_Light = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-30841, r15)};
        Blend_Red_4_Dark = new a[]{new a(-2130706433, r11), new a(-3355444, r17), new a(-30841, r15)};
        Blend_Red_4 = BlendToken$Blend_Red_4$1.INSTANCE;
        Blend_Fill_Element_2_Light = new a[]{new a(167772160, r11)};
        Blend_Fill_Element_2_Dark = new a[]{new a(536870911, r11)};
        Blend_Fill_Element_2 = BlendToken$Blend_Fill_Element_2$1.INSTANCE;
        Blend_Fluid_Thin_Light = new a[]{new a(-13421773, r5), new a(1088018905, r11)};
        Blend_Fluid_Thin_Dark = new a[]{new a(-13421773, r5), new a(1088018905, r11)};
        Blend_Fluid_Thin = BlendToken$Blend_Fluid_Thin$1.INSTANCE;
    }

    private BlendToken() {
    }

    public static final Function1<Boolean, a[]> getBlend_Base_Regular() {
        return Blend_Base_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Base_Regular$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Base_Thick() {
        return Blend_Base_Thick;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Base_Thick$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Blue_4() {
        return Blend_Blue_4;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Blue_4$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Blue_6() {
        return Blend_Blue_6;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Blue_6$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Fill_Element_2() {
        return Blend_Fill_Element_2;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Fill_Element_2$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Fluid_Thin() {
        return Blend_Fluid_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Fluid_Thin$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Green_4() {
        return Blend_Green_4;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Green_4$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Green_6() {
        return Blend_Green_6;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Green_6$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Red_4() {
        return Blend_Red_4;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Red_4$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Red_6() {
        return Blend_Red_6;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Red_6$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Yellow_4() {
        return Blend_Yellow_4;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Yellow_4$annotations() {
    }

    public static final Function1<Boolean, a[]> getBlend_Yellow_6() {
        return Blend_Yellow_6;
    }

    @JvmStatic
    public static /* synthetic */ void getBlend_Yellow_6$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Blue_Regular() {
        return OUI_Color_Blend_Blue_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Blue_Regular$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Blue_Thin() {
        return OUI_Color_Blend_Blue_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Blue_Thin$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Regular() {
        return OUI_Color_Blend_Fluid_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Regular$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Thick() {
        return OUI_Color_Blend_Fluid_Thick;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thick$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_Thin() {
        return OUI_Color_Blend_Fluid_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_Thin$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Fluid_UltraThin() {
        return OUI_Color_Blend_Fluid_UltraThin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Fluid_UltraThin$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Frost_Regular() {
        return OUI_Color_Blend_Frost_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_Regular$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Frost_Thin() {
        return OUI_Color_Blend_Frost_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_Thin$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Frost_UltraThin() {
        return OUI_Color_Blend_Frost_UltraThin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Frost_UltraThin$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Green_Regular() {
        return OUI_Color_Blend_Green_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Green_Regular$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Green_Thin() {
        return OUI_Color_Blend_Green_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Green_Thin$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Red_Regular() {
        return OUI_Color_Blend_Red_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Red_Regular$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Red_Thin() {
        return OUI_Color_Blend_Red_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Red_Thin$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Text_Primary() {
        return OUI_Color_Blend_Text_Primary;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Primary$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Text_Secondary() {
        return OUI_Color_Blend_Text_Secondary;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Secondary$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Text_Tertiary() {
        return OUI_Color_Blend_Text_Tertiary;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Text_Tertiary$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Yellow_Regular() {
        return OUI_Color_Blend_Yellow_Regular;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Regular$annotations() {
    }

    public static final Function1<Boolean, a[]> getOUI_Color_Blend_Yellow_Thin() {
        return OUI_Color_Blend_Yellow_Thin;
    }

    @JvmStatic
    public static /* synthetic */ void getOUI_Color_Blend_Yellow_Thin$annotations() {
    }

    private final ConcurrentHashMap<String, Function1<Boolean, a[]>> getProviders() {
        return (ConcurrentHashMap) providers$delegate.getValue();
    }

    private final ConcurrentHashMap<String, a[]> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final Function1<Boolean, a[]> parse(String r5) {
        ConcurrentHashMap<String, Function1<Boolean, a[]>> r10 = INSTANCE.getProviders();
        Intrinsics.checkNotNullParameter(r10, TestRig.LEXER_START_RULE_NAME);
        Function1<Boolean, a[]> r11 = null;
        if (r5 != null) goto L5;
    L4:
        String r12 = null;
    L9:
        if (r12 == null) goto L15;
        if (r12.length() == 0) goto L15;
        r11 = r10.get(r12);
    L15:
        return r11;
    L5:
        String r13 = r5.toLowerCase(Locale.ROOT);
        if (r13 == null) goto L4;
        r12 = StringsKt.trim(r13).toString();
        goto L9
    }

    @JvmStatic
    public static final void register(Object r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "customTokenOwner");
        ConcurrentHashMap<String, a[]> r5 = INSTANCE.getTokens();
        LinkedHashMap r12 = new LinkedHashMap();
        Field[] r13 = r10.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r14 = r13.length;     // Catch: Exception -> L11
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L13;
        Field r16 = r13[r15];     // Catch: Exception -> L11
        r15 = r15 + 1;     // Catch: Exception -> L11
        if (a[].class.isAssignableFrom(r16.getType()) == false) goto L4;
        r16.setAccessible(true);     // Catch: Exception -> L11
        Object r17 = r16.get(r10);     // Catch: Exception -> L11
        if ((r17 instanceof a[]) == false) goto L4;
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
        ConcurrentHashMap<String, Function1<Boolean, a[]>> r5 = INSTANCE.getProviders();
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
    public static final void registerProviderTokens(Map<String, ? extends Function1<? super Boolean, a[]>> r5, boolean r10) {
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
    public static final void registerTokens(Map<String, a[]> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "customTokens");
        cl.a.K(INSTANCE.getTokens(), r5, r10);
    }

    public static /* synthetic */ void registerTokens$default(Map r5, boolean r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = true;
    L5:
        registerTokens(r5, r10);
    }

    @JvmStatic
    public static final a[] parse(String r5, boolean r10) {
        BlendToken r11 = INSTANCE;
        if (((a[]) cl.a.J(r5, r11.getTokens())) != null) goto L9;
        if (r10 == false) goto L6;
        String r12 = "_light";
    L7:
        a[] r13 = (a[]) cl.a.J(Intrinsics.stringPlus(r5, r12), r11.getTokens());
        goto L9
    L6:
        r12 = "_dark";
    L9:
        return (a[]) cl.a.J(r5, r11.getTokens());
    }
}
