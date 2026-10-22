package com.ss.android.lark.framework.assembly.manis;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import java.util.ArrayList;
import java.util.List;
import jrc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitManisTask extends AbstractLaunchTask {

    public class a implements jrc.a {
        public a() {
        }
    }

    public final List<Class<? extends ILaunchTask>> i() {
        return new ArrayList();
    }

    public InitManisTask() {
    }

    public final void a(Context r2) {
        b r3 = b.a.a;
        r3.c = new a();
        krc.b.a = new com.ss.android.lark.framework.assembly.manis.a();
    }
}
