package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.FunctionN;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Stable
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J(\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0013\"\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/internal/ComposableLambdaNImpl;", "Landroidx/compose/runtime/internal/ComposableLambdaN;", STGroup.DICT_KEY, "", "tracked", "", "arity", "(IZI)V", "_block", "", "getArity", "()I", "getKey", "scope", "Landroidx/compose/runtime/RecomposeScope;", "scopes", "", "invoke", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "realParamCount", LynxResourceModule.PARAMS_KEY, "trackRead", "", "composer", "Landroidx/compose/runtime/Composer;", "trackWrite", "update", "block", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposableLambdaN.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposableLambdaN.jvm.kt\nandroidx/compose/runtime/internal/ComposableLambdaNImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,179:1\n37#2,2:180\n*S KotlinDebug\n*F\n+ 1 ComposableLambdaN.jvm.kt\nandroidx/compose/runtime/internal/ComposableLambdaNImpl\n*L\n111#1:180,2\n*E\n"})
public final class ComposableLambdaNImpl implements ComposableLambdaN {
    private Object _block;
    private final int arity;
    private final int key;
    private RecomposeScope scope;
    private List<RecomposeScope> scopes;
    private final boolean tracked;

    public ComposableLambdaNImpl(int r5, boolean r10, int r11) {
        this.key = r5;
        this.tracked = r10;
        this.arity = r11;
    }

    private final int realParamCount(int r5) {
        int r10 = r5 - 2;
        int r11 = 1;
    L4:
        if ((r11 * 10) >= r10) goto L6;
        r10 = r10 - 1;
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    private final void trackRead(Composer r5) {
        if (this.tracked == false) goto L23;
        RecomposeScope r10 = r5.getRecomposeScope();
        if (r10 == null) goto L24;
        r5.recordUsed(r10);
        if (ComposableLambdaKt.replacableWith(this.scope, r10) == false) goto L9;
        this.scope = r10;
        return;
    L9:
        List<RecomposeScope> r11 = this.scopes;
        if (r11 != null) goto L12;
        ArrayList r12 = new ArrayList();
        this.scopes = r12;
        r12.add(r10);
        return;
    L12:
        int r13 = r11.size();
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L19;
        if (ComposableLambdaKt.replacableWith(r11.get(r14), r10) == true) goto L16;
        r14 = r14 + 1;
        goto L13
    L16:
        r11.set(r14, r10);
        return;
    L19:
        r11.add(r10);
        return;
    L24:
        return;
    }

    private final void trackWrite() {
        if (this.tracked == false) goto L15;
        RecomposeScope r5 = this.scope;
        if (r5 == null) goto L7;
        r5.invalidate();
        this.scope = null;
    L7:
        List<RecomposeScope> r10 = this.scopes;
        if (r10 == null) goto L16;
        int r11 = r10.size();
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L12;
        r10.get(r12).invalidate();
        r12 = r12 + 1;
        goto L10
    L12:
        r10.clear();
        return;
    L16:
        return;
    }

    @Override // kotlin.jvm.functions.FunctionN, kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public final int getKey() {
        return this.key;
    }

    @Override // kotlin.jvm.functions.FunctionN
    public Object invoke(final Object... r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        final int r5 = realParamCount(r10.length);
        Object r11 = r10[r5];
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.compose.runtime.Composer");
        Object[] r12 = ArraysKt.slice(r10, RangesKt.until(0, r10.length - 1)).toArray(new Object[0]);
        Object r13 = r10[r10.length - 1];
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Int");
        int r14 = ((Integer) r13).intValue();
        Composer r15 = ((Composer) r11).startRestartGroup(this.key);
        trackRead(r15);
        if (r15.changed(this) == false) goto L5;
        int r16 = ComposableLambdaKt.differentBits(r5);
    L6:
        int r17 = r14 | r16;
        Object r18 = this._block;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.jvm.functions.FunctionN<*>");
        SpreadBuilder r19 = new SpreadBuilder(2);
        r19.addSpread(r12);
        r19.add(Integer.valueOf(r17));
        Object r20 = ((FunctionN) r18).invoke(r19.toArray(new Object[r19.size()]));
        ScopeUpdateScope r21 = r15.endRestartGroup();
        if (r21 == null) goto L9;
        r21.updateScope(new AnonymousClass1(r10, r5, this));
    L9:
        return r20;
    L5:
        r16 = ComposableLambdaKt.sameBits(r5);
        goto L6
    }

    public final void update(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
        if (Intrinsics.areEqual(r5, this._block) == false) goto L5;
        return;
    L5:
        if (this._block != null) goto L7;
        boolean r10 = true;
    L8:
        this._block = (FunctionN) r5;
        if (r10 == true) goto L13;
        trackWrite();
        return;
    L13:
        return;
    L7:
        r10 = false;
        goto L8
    }
}
