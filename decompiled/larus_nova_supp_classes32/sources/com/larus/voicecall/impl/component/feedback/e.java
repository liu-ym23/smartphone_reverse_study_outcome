package com.larus.voicecall.impl.component.feedback;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface e extends t1a.a {
    Object R90(Message r1, Continuation<? super Message> r2);

    Object eE(Message r1, Continuation<? super Message> r2);

    Object fL(Message r1, Continuation<? super Message> r2);

    void j60();

    void no(FragmentActivity r1, FragmentManager r2, a r3, d r4);

    Object rH(Message r1, int r2, String r3, List<Integer> r4, Continuation<? super Message> r5);
}
