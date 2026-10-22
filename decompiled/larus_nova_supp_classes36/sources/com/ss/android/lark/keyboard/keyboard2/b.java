package com.ss.android.lark.keyboard.keyboard2;

import android.widget.EditText;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b extends c {
    public static final a K1 = null;

    public static final class a implements c.a<b> {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        K1 = a.a;
    }

    EditText c();

    InputSupportType getInputType();

    void setEnable(boolean r1);
}
