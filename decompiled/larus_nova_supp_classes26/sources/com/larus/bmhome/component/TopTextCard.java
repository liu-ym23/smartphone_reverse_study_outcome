package com.larus.bmhome.component;

import com.larus.bmhome.chat.list.cell.text.cells.top.TopTextCell;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature;
import ei9.f;
import ei9.g;
import gg8.h;
import hi9.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1a.b;
import xc8.i;
import xc8.j;
import xc8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\rR \u0010\u0003\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/component/TopTextCard;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentCard;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "cellClazz", "Ljava/lang/Class;", "Lcom/larus/ui/arch/component/external/delegate/BaseCellComponentFeature;", "matcher", "Lcom/larus/list/arch/multi/IMultipleType;", "Lcom/larus/list/arch/IFlowListCellState;", "stateTransformer", "Lcom/larus/list/arch/IFlowListCellStateTransformer;", "Lcom/larus/ui/arch/context/external/VCardData;", "<init>", "(Ljava/lang/Class;Lcom/larus/list/arch/multi/IMultipleType;Lcom/larus/list/arch/IFlowListCellStateTransformer;)V", "getCellClazz", "()Ljava/lang/Class;", "getMatcher", "()Lcom/larus/list/arch/multi/IMultipleType;", "getStateTransformer", "()Lcom/larus/list/arch/IFlowListCellStateTransformer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopTextCard extends ComponentFeature implements b {
    public final Class<? extends BaseCellComponentFeature<?>> h;
    public final a<? extends f> i;
    public final g<Object, ? extends f> j;

    public TopTextCard() {
        this(null);
    }

    public final g<Object, ? extends f> N() {
        return this.j;
    }

    public final a<? extends f> getMatcher() {
        return this.i;
    }

    public final Class<? extends BaseCellComponentFeature<?>> l1() {
        return this.h;
    }

    public TopTextCard(Object r4) {
        j r0 = new j();
        i r1 = k.a(new h());
        Intrinsics.checkNotNullParameter(TopTextCell.class, "cellClazz");
        Intrinsics.checkNotNullParameter(r0, "matcher");
        Intrinsics.checkNotNullParameter(r1, "stateTransformer");
        this.h = TopTextCell.class;
        this.i = r0;
        this.j = r1;
    }
}
