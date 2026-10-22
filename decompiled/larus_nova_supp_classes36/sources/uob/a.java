package uob;

import android.text.Editable;
import android.text.TextWatcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.vote.DownVoteInputAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements TextWatcher {
    public final /* synthetic */ DownVoteInputAdapter a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public a(DownVoteInputAdapter r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
        this.a.getClass();
    }
}
