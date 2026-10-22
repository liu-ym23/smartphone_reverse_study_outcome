package com.obric.assistant.session.lifecycle;

import bga.i;
import bga.j;
import com.obric.assistant.session.model.ISessionMaintaining;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class a implements i {
    public String a;

    public a() {
    }

    public final String c() {
        return this.a + '-' + getClass();
    }

    @Override // bga.i
    public final void onInit() {
        Intrinsics.checkNotNullParameter("AiIslandVoiceInteractionSession", "tag");
        Intrinsics.checkNotNullParameter("AiIslandVoiceInteractionSession", "tag");
        this.a = "AiIslandVoiceInteractionSession";
    }

    public static String b() {
        ISessionMaintaining r0 = j.b();
        if (r0 == null) goto L6;
        String r1 = r0.w();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }
}
