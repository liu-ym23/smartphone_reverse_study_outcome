package com.obric.aiagent.ipc.idl;

import java.io.File;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ FilePath a;
    public final /* synthetic */ File b;

    public /* synthetic */ d(FilePath r1, File r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return FileIDLStubImpl.a(this.a, this.b, (File) r3);
    }
}
