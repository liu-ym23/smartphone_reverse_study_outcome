package com.larus.ugc.feed.impl.ability;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J1\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b \u0010!J\b\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001fH\u0016J(\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0017H\u0016J\u001a\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020/2\b\u0010-\u001a\u0004\u0018\u00010\u001fH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/ugc/feed/impl/ability/CreationFeedUiFeedbackFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ugc/feed/api/ability/IUiFeedbackAbility;", "<init>", "()V", "_menuState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/ugc/feed/api/ability/LongPressMenuState;", "menuState", "Lkotlinx/coroutines/flow/StateFlow;", "getMenuState", "()Lkotlinx/coroutines/flow/StateFlow;", "_loadingState", "Lcom/larus/ugc/feed/api/ability/LoadingState;", "loadingState", "getLoadingState", "_toastState", "Lcom/larus/ugc/feed/api/ability/ToastState;", "toastState", "getToastState", "toastIdCounter", "Lkotlinx/atomicfu/AtomicLong;", "showLongPressMenu", "", "offset", "Landroidx/compose/ui/unit/IntOffset;", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "position", "", "sourceTag", "", "showLongPressMenu-MLgxB_4", "(JLcom/larus/ugc/feed/api/model/UserCreationKmp;ILjava/lang/String;)V", "dismissLongPressMenu", "onMenuItemClick", "itemId", "computeItems", "", "Lcom/larus/ugc/feed/api/ability/LongPressMenuItem;", "feedAbility", "Lcom/larus/ugc/feed/api/ability/IKMPCreationFeedAbility;", "profileAbility", "Lcom/larus/ugc/feed/api/ability/IKMPProfileCreationAbility;", "toast", "message", "longDuration", "", "dismissToast", "setLoadingVisible", "visible", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationFeedUiFeedbackFeature extends ComponentFeature implements m1a.a {

    public static final class a {
    }

    static {
    }

    public CreationFeedUiFeedbackFeature() {
        kotlinx.coroutines.flow.e.b(j1.a(null));
        kotlinx.coroutines.flow.e.b(j1.a(null));
        kotlinx.coroutines.flow.e.b(j1.a(null));
        buc.b.c(0);
    }
}
