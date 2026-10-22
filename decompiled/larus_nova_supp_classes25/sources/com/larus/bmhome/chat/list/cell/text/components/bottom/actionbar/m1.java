package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import com.larus.im.bean.bot.AnswerAction;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m1<T> implements Comparator {
    public m1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(((AnswerAction) r1).getPosition(), ((AnswerAction) r2).getPosition());
    }
}
