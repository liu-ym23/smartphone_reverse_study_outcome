package androidx.room.preconditions;

import androidx.room.compiler.processing.XElement;
import androidx.room.log.RLog;
import com.squareup.javapoet.a0;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J9\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\"\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0004\b\u000e\u0010\u0012JA\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\"\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\"\u00020\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ;\u0010\u001e\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\n2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\"\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 ¨\u0006!"}, d2 = {"Landroidx/room/preconditions/Checks;", "", "Landroidx/room/log/RLog;", "logger", "<init>", "(Landroidx/room/log/RLog;)V", "", "predicate", "Landroidx/room/compiler/processing/XElement;", "element", "", "errorMsg", "", "args", "check", "(ZLandroidx/room/compiler/processing/XElement;Ljava/lang/String;[Ljava/lang/Object;)Z", "Lkotlin/Function0;", "errorMsgProducer", "(ZLandroidx/room/compiler/processing/XElement;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/reflect/KClass;", "", "annotation", "hasAnnotation", "(Landroidx/room/compiler/processing/XElement;Lkotlin/reflect/KClass;Ljava/lang/String;[Ljava/lang/Object;)Z", "Lcom/squareup/javapoet/x;", "typeName", "notUnbound", "(Lcom/squareup/javapoet/x;Landroidx/room/compiler/processing/XElement;Ljava/lang/String;[Ljava/lang/Object;)Z", "value", "msg", "notBlank", "(Ljava/lang/String;Landroidx/room/compiler/processing/XElement;Ljava/lang/String;[Ljava/lang/Object;)Z", "Landroidx/room/log/RLog;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Checks {
    private final RLog logger;

    public Checks(RLog r5) {
        Intrinsics.checkNotNullParameter(r5, "logger");
        this.logger = r5;
    }

    public final boolean check(boolean r5, XElement r10, String r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        Intrinsics.checkNotNullParameter(r12, "args");
        if (r5 == true) goto L5;
        this.logger.e(r10, r11, new Object[]{r12});
    L5:
        return r5;
    }

    public final boolean hasAnnotation(XElement r5, KClass<? extends Annotation> r10, String r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "annotation");
        Intrinsics.checkNotNullParameter(r11, "errorMsg");
        Intrinsics.checkNotNullParameter(r12, "args");
        if (r5.hasAnnotation(r10) == true) goto L5;
        this.logger.e(r5, r11, new Object[]{r12});
        return false;
    L5:
        return true;
    }

    public final boolean notBlank(String r5, XElement r10, String r11, Object... r12) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter(r12, "args");
        if (r5 != null) goto L5;
    L7:
        boolean r13 = false;
    L9:
        return check(r13, r10, r11, new Object[]{r12});
    L5:
        if (StringsKt.isBlank(r5) == true) goto L7;
        r13 = true;
        goto L9
    }

    public final boolean notUnbound(x r10, XElement r11, String r12, Object... r13) {
        Intrinsics.checkNotNullParameter(r10, "typeName");
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "errorMsg");
        Intrinsics.checkNotNullParameter(r13, "args");
        boolean r5 = check(!(r10 instanceof a0), r11, r12, new Object[]{r13});
        if ((r10 instanceof v) == false) goto L21;
        List r14 = ((v) r10).f15022y;
        if (r14 != null) goto L7;
    L9:
        Iterator r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L8;
        if (notUnbound((x) r15.next(), r11, r12, new Object[]{r13}) == false) goto L11;
        boolean r16 = true;
    L15:
        if (r5 == true) goto L19;
        if (r16 == true) goto L19;
        return true;
    L19:
        return false;
    L8:
        r16 = false;
        goto L15
    L7:
        if (r14.isEmpty() == false) goto L9;
    L21:
        return !r5;
    }

    public final boolean check(boolean r5, XElement r10, Function0<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "errorMsgProducer");
        if (r5 == true) goto L5;
        this.logger.e(r10, r11.invoke(), new Object[0]);
    L5:
        return r5;
    }
}
