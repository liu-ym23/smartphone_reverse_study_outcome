package com.obric.assistant.entity;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.List;
import kotlin.Metadata;
import zda.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\u0016\u0010\u000f\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0005H&¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/entity/IObricEntityNavigationService;", "", "showEntity", "", "packageName", "", "type", "id", "createLocalImageRow", "Landroid/view/View;", "context", "Landroid/content/Context;", "images", "", "Lcom/obric/assistant/entity/ObricSearchImage;", "showLocalImageAggregation", "isEntityTypeJumpable", "", "entityType", "openReferenceUrl", MemorySourceLinkType.URL, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricEntityNavigationService {
    void a(List<c> r1);

    boolean b(String r1);

    RecyclerView c(Context r1, List r2);

    void d(Context r1, String r2);

    void e(String r1, String r2, String r3);
}
