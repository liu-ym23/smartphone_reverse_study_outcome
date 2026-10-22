package com.lynx.tasm.behavior.shadow.text;

import ai.j0;
import androidx.annotation.Nullable;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import java.text.DecimalFormat;
import pm.a;
import zm.s;
import zm.t;

/* JADX INFO: loaded from: classes2.dex */
public class RawTextShadowNode extends ShadowNode {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f10362v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f10363w;

    public RawTextShadowNode() {
        this.f10362v = null;
        this.f10363w = false;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean m() {
        return true;
    }

    @c0(name = "pseudo")
    public void setPsuedo(@Nullable boolean r5) {
        this.f10363w = r5;
    }

    @c0(name = MessageIndication.CONTENT_TYPE_TEXT)
    public void setText(@Nullable a r10) {
        DecimalFormat r5 = t.f23539a;
        if (r10 == null) goto L15;
        int r11 = s.f23538a[r10.getType().ordinal()];
        if (r11 != 1) goto L8;
        String r12 = r10.asString();
    L28:
        this.f10362v = r12;
        n();
        return;
    L8:
        if (r11 != 2) goto L10;
        r12 = String.valueOf(r10.asInt());
        goto L28
    L10:
        if (r11 != 3) goto L12;
        r12 = String.valueOf(r10.asLong());
        goto L28
    L12:
        if (r11 != 4) goto L14;
        double r13 = r10.asDouble();
        if (r13 < 9.223372036854776E18d) goto L20;
    L24:
        r12 = t.f23539a.format(r13);
        goto L28
    L20:
        if (r13 <= (-9.223372036854776E18d)) goto L24;
        long r14 = (long) Math.floor(r13);
        if (r13 != r14) goto L24;
        r12 = String.valueOf(r14);
        goto L28
    L14:
        if (r11 != 5) goto L15;
        r12 = String.valueOf(r10.asBoolean());
    L15:
        r12 = null;
        goto L28
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        String r10 = this.f10346j;
        if (r10 == null) goto L7;
        r5.append(r10);
        r5.append(" [text: ");
        return j0.q(r5, this.f10362v, "]");
    L7:
        throw new AssertionError();
    }
}
