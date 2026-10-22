package com.larus.bmhome.taskskill.network;

import com.larus.bmhome.taskskill.model.TaskSkill;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p<T> implements Comparator {
    public p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        TaskSkillRepository r0 = TaskSkillRepository.a;
        return ComparisonsKt.compareValues(Integer.valueOf(TaskSkillRepository.b(((TaskSkill) r2).getType())), Integer.valueOf(TaskSkillRepository.b(((TaskSkill) r3).getType())));
    }
}
