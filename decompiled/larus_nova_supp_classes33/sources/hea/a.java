package hea;

import com.obric.assistant.interaction.impl.hook.utils.ActivityThreadHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Object a;

    public /* synthetic */ a(Object r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityThreadHelper.a(this.a);
    }
}
