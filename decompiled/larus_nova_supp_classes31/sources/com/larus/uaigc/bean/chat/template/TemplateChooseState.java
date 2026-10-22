package com.larus.uaigc.bean.chat.template;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import w1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/bean/chat/template/TemplateChooseState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "foo", "", "<init>", "(Z)V", "getFoo", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TemplateChooseState implements b {
    private final boolean foo;

    public TemplateChooseState() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ TemplateChooseState copy$default(TemplateChooseState r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.foo;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.foo;
    }

    public final TemplateChooseState copy(boolean r2) {
        return new TemplateChooseState(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof TemplateChooseState) == true) goto L9;
        return false;
    L9:
        if (this.foo == ((TemplateChooseState) r4).foo) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.foo == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "TemplateChooseState(foo=" + this.foo + ')';
    }

    public final boolean getFoo() {
        return this.foo;
    }

    public TemplateChooseState(boolean r1) {
        this.foo = r1;
    }

    public /* synthetic */ TemplateChooseState(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }
}
