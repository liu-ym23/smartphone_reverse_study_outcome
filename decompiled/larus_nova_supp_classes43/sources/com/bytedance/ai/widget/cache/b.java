package com.bytedance.ai.widget.cache;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.widget.contianer.m;
import com.bytedance.ai.widget.models.ConversationWidgetData;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b {
    Object a(Continuation<? super Widget> r1);

    void b(ConversationWidgetData r1);

    Object c(Continuation<? super TemplateBundle> r1);

    void d(String r1, String r10, String r11, String r12, String r13);

    TemplateData e();

    Uri f();

    Object g(Context r1, m r10, Continuation<? super Unit> r11);
}
