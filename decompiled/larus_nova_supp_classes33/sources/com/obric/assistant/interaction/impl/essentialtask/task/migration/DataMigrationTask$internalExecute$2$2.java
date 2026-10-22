package com.obric.assistant.interaction.impl.essentialtask.task.migration;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class DataMigrationTask$internalExecute$2$2 implements Function1<Throwable, Unit> {
    public static final DataMigrationTask$internalExecute$2$2 INSTANCE = null;

    static {
        INSTANCE = new DataMigrationTask$internalExecute$2$2();
    }

    public DataMigrationTask$internalExecute$2$2() {
    }

    public final void invoke(Throwable r3) {
        FLogger.a.e("data_migration", "Migration Cancellation");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }
}
