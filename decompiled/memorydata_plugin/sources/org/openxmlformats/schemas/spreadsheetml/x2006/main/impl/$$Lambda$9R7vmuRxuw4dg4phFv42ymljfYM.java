package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.-$$Lambda$9R7vmuRxuw4dg4phFv42ymljfYM, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$9R7vmuRxuw4dg4phFv42ymljfYM implements Consumer {
    public final /* synthetic */ CTAuthorsImpl f$0;

    public /* synthetic */ $$Lambda$9R7vmuRxuw4dg4phFv42ymljfYM(CTAuthorsImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeAuthor(((Integer) r1).intValue());
    }
}
