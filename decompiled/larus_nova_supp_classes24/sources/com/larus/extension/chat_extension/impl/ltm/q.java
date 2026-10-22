package com.larus.extension.chat_extension.impl.ltm;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.extension.chat_extension.impl.databinding.LarusLayoutChatLtmInputBinding;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.utils.e1;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q implements TextWatcher {
    public final /* synthetic */ ChatLtmInputFragment a;
    public final /* synthetic */ LarusLayoutChatLtmInputBinding b;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r9) {
        String r10 = String.valueOf(r9);
        if (StringsKt.trim(r10).toString().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L23;
        ChatLtmInputFragment.S90(this.a, this.b.g);
        ChatLtmViewModel r1 = this.a.U90();
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L21;
        ChatLtmViewModel r3 = this.a.U90();
        if (r3 == null) goto L25;
        BotMemoryConfig r4 = r3.getConfig();
        if (r4 == null) goto L26;
        Integer r5 = r4.getBotMemorySizeLimit();
        if (r5 == null) goto L27;
        LarusLayoutChatLtmInputBinding r6 = this.b;
        ChatLtmInputFragment r7 = this.a;
        int r8 = r5.intValue();
        e1.x(r6.c);
        AppCompatTextView r11 = r6.d;
        StringCompanionObject r12 = StringCompanionObject.INSTANCE;
        r11.setText(String.format(r7.getString(2131907361), Arrays.copyOf(new Object[]{Integer.valueOf(r8)}, 1)));
        String r13 = r10.substring(0, r8);
        r6.e.removeTextChangedListener(this);
        r6.e.setText(r13);
        r6.e.setSelection(r13.length());
        r6.e.addTextChangedListener(this);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L21:
        e1.o(this.b.c);
        return;
    L10:
        if (r1.isOverSize(r10) != true) goto L12;
        r2 = true;
        goto L13
    L23:
        this.b.g.setAlpha(0.3f);
        this.b.g.setOnClickListener(null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public q(ChatLtmInputFragment r1, LarusLayoutChatLtmInputBinding r2) {
        this.a = r1;
        this.b = r2;
    }
}
