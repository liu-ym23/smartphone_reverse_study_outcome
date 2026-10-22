package com.ss.android.lark.flow.chat.page.flow.plugin.select;

import com.ss.android.eventbus.BaseEvent;
import com.ss.android.eventbus.BaseEventListener;
import com.ss.android.eventbus.EventBus;
import com.ss.android.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMessageSelectPlugin_Subscriber {

    public class a extends BaseEventListener {
        public final /* synthetic */ Object a;

        public a(Object r1) {
            this.a = r1;
        }

        public void onEvent(BaseEvent r2) {
            ((FlowMessageSelectPlugin) this.a).onMultiSelectActed((com.ss.android.lark.flow.chat.multi_select.c) r2);
        }
    }

    public FlowMessageSelectPlugin_Subscriber() {
    }

    public static void register(Object r4) {
        EventBus.getDefault().register(r4, com.ss.android.lark.flow.chat.multi_select.c.class, new a(r4), ThreadMode.MAIN);
    }
}
