package com.obric.assistant.card.entity;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapterExtKt;
import com.larus.im.bean.message.block.OSearchReferenceInCollection;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.block.search.local.adapter.SearchLocalItemAdapter;
import com.obric.assistant.block.search.local.adapter.SearchLocalRowAdapter;
import com.obric.assistant.card.utils.AppEntityEx;
import com.obric.assistant.entity.IObricEntityNavigationService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jca.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zda.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/card/entity/ObricEntityNavigationServiceImpl;", "Lcom/obric/assistant/entity/IObricEntityNavigationService;", "<init>", "()V", "showEntity", NameKeys.UnloadStrategy_No_Strategy, "packageName", NameKeys.UnloadStrategy_No_Strategy, "type", "id", "createLocalImageRow", "Landroid/view/View;", "context", "Landroid/content/Context;", "images", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/entity/ObricSearchImage;", "showLocalImageAggregation", "isEntityTypeJumpable", NameKeys.UnloadStrategy_No_Strategy, "entityType", "openReferenceUrl", LynxEventReporter.PROP_NAME_URL, "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEntityNavigationServiceImpl implements IObricEntityNavigationService {
    public ObricEntityNavigationServiceImpl() {
    }

    public final void a(List<c> r3) {
        Intrinsics.checkNotNullParameter(r3, "images");
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        OSearchReferenceInCollection r1 = a.a((c) r4.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L11;
        return;
    L11:
        SearchLocalRowAdapter r5 = new SearchLocalRowAdapter();
        r5.y2(r0, false);
        r5.z2(null, false);
    }

    public final boolean b(String r2) {
        Set<Integer> r0 = SearchLocalItemAdapter.c;
        if (r2 == null) goto L7;
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L7;
        int r4 = r3.intValue();
        return SearchLocalItemAdapter.c.contains(Integer.valueOf(r4));
    L7:
        return false;
    }

    public final RecyclerView c(Context r4, List r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "images");
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        OSearchReferenceInCollection r1 = a.a((c) r6.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L11;
        return null;
    L11:
        SearchLocalRowAdapter r7 = new SearchLocalRowAdapter();
        r7.y2(r0, false);
        if (r7.getItemCount() > 0) goto L14;
        return null;
    L14:
        RecyclerView r2 = new RecyclerView(r4);
        r2.setHasFixedSize(true);
        r2.setLayoutManager(new LinearLayoutManager(r4, 0, false));
        r2.setAdapter(r7);
        return r2;
    }

    public final void d(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, LynxEventReporter.PROP_NAME_URL);
        if (StringsKt.isBlank(r4) == false) goto L6;
        FLogger.a.w("ObricEntityNavigationService", "openReferenceUrl: url is blank");
        return;
    L6:
        MessageAdapterExtKt.a(r4, r3, NameKeys.UnloadStrategy_No_Strategy, null);
    }

    public final void e(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "id");
        int r0 = AppEntityEx.a;
        AppEntityEx.c(new AppEntityEx.a(r2, r3, r4));
    }
}
