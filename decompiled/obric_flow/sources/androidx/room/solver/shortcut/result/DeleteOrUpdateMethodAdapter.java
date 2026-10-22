package androidx.room.solver.shortcut.result;

import ai.j0;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.ext.KotlinTypeNames;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.solver.CodeGenScope;
import androidx.room.vo.ShortcutQueryParameter;
import com.squareup.javapoet.g;
import com.squareup.javapoet.m;
import com.squareup.javapoet.x;
import com.squareup.javapoet.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\bJK\u0010\u0018\u001a\u00020\u00172\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u001e\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000e2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/room/solver/shortcut/result/DeleteOrUpdateMethodAdapter;", "", "Landroidx/room/compiler/processing/XType;", "returnType", "<init>", "(Landroidx/room/compiler/processing/XType;)V", "", "hasResultValue", "(Landroidx/room/compiler/processing/XType;)Z", "hasNullReturn", "hasUnitReturn", "", "Landroidx/room/vo/ShortcutQueryParameter;", "parameters", "", "", "Lkotlin/Pair;", "Lcom/squareup/javapoet/m;", "Lcom/squareup/javapoet/z;", "adapters", "dbField", "Landroidx/room/solver/CodeGenScope;", "scope", "", "createDeleteOrUpdateMethodBody", "(Ljava/util/List;Ljava/util/Map;Lcom/squareup/javapoet/m;Landroidx/room/solver/CodeGenScope;)V", "Landroidx/room/compiler/processing/XType;", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeleteOrUpdateMethodAdapter {
    public static final Companion Companion = null;
    private final XType returnType;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Landroidx/room/solver/shortcut/result/DeleteOrUpdateMethodAdapter$Companion;", "", "()V", "create", "Landroidx/room/solver/shortcut/result/DeleteOrUpdateMethodAdapter;", "returnType", "Landroidx/room/compiler/processing/XType;", "isDeleteOrUpdateValid", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final boolean isDeleteOrUpdateValid(XType r5) {
            if (XTypeKt.isVoid(r5) == false) goto L5;
        L12:
            return true;
        L5:
            if (XTypeKt.isInt(r5) == true) goto L12;
            if (XTypeKt.isVoidObject(r5) == true) goto L12;
            if (XTypeKt.isKotlinUnit(r5) == true) goto L12;
            return false;
        }

        public final DeleteOrUpdateMethodAdapter create(XType r5) {
            Intrinsics.checkNotNullParameter(r5, "returnType");
            DefaultConstructorMarker r10 = null;
            if (isDeleteOrUpdateValid(r5) == true) goto L5;
            return null;
        L5:
            return new DeleteOrUpdateMethodAdapter(r5, r10);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ DeleteOrUpdateMethodAdapter(XType r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    private final boolean hasNullReturn(XType r5) {
        return XTypeKt.isVoidObject(r5);
    }

    private final boolean hasResultValue(XType r5) {
        if (XTypeKt.isVoid(r5) == false) goto L5;
    L9:
        return false;
    L5:
        if (XTypeKt.isVoidObject(r5) == true) goto L9;
        if (XTypeKt.isKotlinUnit(r5) == true) goto L9;
        return true;
    }

    private final boolean hasUnitReturn(XType r5) {
        return XTypeKt.isKotlinUnit(r5);
    }

    public final void createDeleteOrUpdateMethodBody(List<ShortcutQueryParameter> r12, Map<String, Pair<m, z>> r13, m r14, CodeGenScope r15) {
        Intrinsics.checkNotNullParameter(r12, "parameters");
        Intrinsics.checkNotNullParameter(r13, "adapters");
        Intrinsics.checkNotNullParameter(r14, "dbField");
        Intrinsics.checkNotNullParameter(r15, "scope");
        if (hasResultValue(this.returnType) == false) goto L5;
        String r5 = r15.getTmpVar("_total");
    L6:
        g r16 = r15.builder();
        if (r5 == null) goto L9;
        r16.c(a.q(Javapoet_extKt.getT(), " ", Javapoet_extKt.getL(), " = 0"), new Object[]{x.f15023h, r5});
    L9:
        r16.c(j0.j(Javapoet_extKt.getN(), ".beginTransaction()"), new Object[]{r14});
        r16.e("try", new Object[0]);
        Iterator<T> r17 = r12.iterator();
    L11:
        if (r17.hasNext() == false) goto L21;
        ShortcutQueryParameter r10 = (ShortcutQueryParameter) r17.next();
        Pair<m, z> r11 = r13.get(r10.getName());
        if (r11 == null) goto L15;
        m r18 = r11.getFirst();
    L16:
        String r19 = Javapoet_extKt.getL();
        String r20 = Javapoet_extKt.getN();
        String r21 = Javapoet_extKt.getL();
        String r22 = j0.q(a.y(r19, r20, ".", r21, "("), Javapoet_extKt.getL(), ")");
        if (r5 != null) goto L19;
        String r23 = "";
    L20:
        r16.c(r22, new Object[]{r23, r18, r10.handleMethodName(), r10.getName()});
        goto L11
    L19:
        r23 = r5.concat(" +=");
        goto L20
    L15:
        r18 = null;
        goto L16
    L21:
        r16.c(j0.j(Javapoet_extKt.getN(), ".setTransactionSuccessful()"), new Object[]{r14});
        if (r5 == null) goto L25;
        r16.c(j0.C("return ", Javapoet_extKt.getL()), new Object[]{r5});
    L30:
        r16.h("finally", new Object[0]);
        r16.c(j0.j(Javapoet_extKt.getN(), ".endTransaction()"), new Object[]{r14});
        r16.g();
        return;
    L25:
        if (hasNullReturn(this.returnType) == false) goto L28;
        r16.c("return null", new Object[0]);
        goto L30
    L28:
        if (hasUnitReturn(this.returnType) == false) goto L30;
        r16.c(j0.k("return ", Javapoet_extKt.getT(), ".INSTANCE"), new Object[]{KotlinTypeNames.INSTANCE.getUNIT()});
        goto L30
    L5:
        r5 = null;
        goto L6
    }

    private DeleteOrUpdateMethodAdapter(XType r5) {
        this.returnType = r5;
    }
}
