package com.bytedance.android.ec.common.impl.sku.model;

import android.os.SystemClock;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuAddCartGuideInfo;
import com.bytedance.android.ec.common.impl.sku.repository.dto.UpdateActionOption;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.android.ec.model.sku.SafeguardComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuTrustTags;
import com.bytedance.android.ec.model.sku.TopBannerComponent;
import com.bytedance.android.ec.model.sku.TradeModeComponent;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¿\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\bß\u0001\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0007\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010-\u001a\u00020*\u0012\b\b\u0002\u0010.\u001a\u00020\u0011\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u00100\u001a\u00020\u0011\u0012\b\b\u0002\u00101\u001a\u00020\u0011\u0012\b\b\u0002\u00102\u001a\u00020\u0011\u0012\b\b\u0002\u00103\u001a\u00020\u0011\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010@\u001a\u00020<\u0012\b\b\u0002\u0010A\u001a\u00020*\u0012\b\b\u0002\u0010B\u001a\u00020*\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0007\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e\u0012\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j¢\u0006\u0002\u0010kJ\u0016\u0010÷\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\n\u0010ø\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010ù\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010ú\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010û\u0001\u001a\u00020\u0015HÆ\u0003J\u0012\u0010ü\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\u0012\u0010ý\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010þ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0082\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\f\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u008a\u0002\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0002\u0010tJ\f\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010\u008d\u0002\u001a\u0004\u0018\u00010\nHÆ\u0003J\n\u0010\u008e\u0002\u001a\u00020*HÆ\u0003J\n\u0010\u008f\u0002\u001a\u00020\u0011HÆ\u0003J\f\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0091\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0092\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0093\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0094\u0002\u001a\u00020\u0011HÆ\u0003J\f\u0010\u0095\u0002\u001a\u0004\u0018\u000105HÆ\u0003J\f\u0010\u0096\u0002\u001a\u0004\u0018\u000107HÆ\u0003J\f\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0099\u0002\u001a\u0004\u0018\u000105HÆ\u0003J\u0011\u0010\u009a\u0002\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0002\u0010tJ\u0012\u0010\u009b\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\u0011\u0010\u009c\u0002\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0002\u0010tJ\f\u0010\u009d\u0002\u001a\u0004\u0018\u00010?HÆ\u0003J\n\u0010\u009e\u0002\u001a\u00020<HÆ\u0003J\n\u0010\u009f\u0002\u001a\u00020*HÆ\u0003J\n\u0010 \u0002\u001a\u00020*HÆ\u0003J\f\u0010¡\u0002\u001a\u0004\u0018\u00010DHÆ\u0003J\u0012\u0010¢\u0002\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0007HÆ\u0003J\f\u0010£\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¤\u0002\u001a\u0004\u0018\u00010HHÆ\u0003J\f\u0010¥\u0002\u001a\u0004\u0018\u00010JHÆ\u0003J\f\u0010¦\u0002\u001a\u0004\u0018\u00010LHÆ\u0003J\u0012\u0010§\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010¨\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010©\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010ª\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\f\u0010«\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010¬\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0018\u0010®\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¯\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010°\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\u0012\u0010±\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\f\u0010²\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010³\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\u0012\u0010´\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010µ\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¶\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010·\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\f\u0010¸\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0018\u0010¹\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010º\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\u0012\u0010»\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010¼\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010½\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010¾\u0002\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0002\u0010tJ\f\u0010¿\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010À\u0002\u001a\u0004\u0018\u00010eHÆ\u0003J\u0018\u0010Á\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Â\u0002\u001a\u0004\u0018\u00010hHÆ\u0003J\f\u0010Ã\u0002\u001a\u0004\u0018\u00010jHÆ\u0003J\u0018\u0010Ä\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Å\u0002\u001a\u00020\u0011HÆ\u0003Jî\u0007\u0010Æ\u0002\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010-\u001a\u00020*2\b\b\u0002\u0010.\u001a\u00020\u00112\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00100\u001a\u00020\u00112\b\b\u0002\u00101\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u00020\u00112\b\b\u0002\u00103\u001a\u00020\u00112\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00109\u001a\u0004\u0018\u0001052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020<2\b\b\u0002\u0010A\u001a\u00020*2\b\b\u0002\u0010B\u001a\u00020*2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u00072\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010P\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010U\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010b\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jHÆ\u0001¢\u0006\u0003\u0010Ç\u0002J\u0016\u0010È\u0002\u001a\u00020<2\n\u0010É\u0002\u001a\u0005\u0018\u00010Ê\u0002HÖ\u0003J\n\u0010Ë\u0002\u001a\u00020*HÖ\u0001J\u0007\u0010Ì\u0002\u001a\u00020<J\u0007\u0010Í\u0002\u001a\u00020<J\u0007\u0010Î\u0002\u001a\u00020<J\u0007\u0010Ï\u0002\u001a\u00020<J\u0007\u0010Ð\u0002\u001a\u00020<J\u0007\u0010Ñ\u0002\u001a\u00020<J\u0007\u0010Ò\u0002\u001a\u00020<J\u0007\u0010Ó\u0002\u001a\u00020<J\n\u0010Ô\u0002\u001a\u00020\u0004HÖ\u0001R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010g\u001a\u0004\u0018\u00010h¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0013\u00109\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\bp\u0010mR\u0013\u00108\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u001e\u0010b\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010w\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010rR\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010rR\u0013\u0010d\u001a\u0004\u0018\u00010e¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u001c\u00101\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u00100\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u007f\"\u0006\b\u0083\u0001\u0010\u0081\u0001R\u0016\u0010:\u001a\u0004\u0018\u00010*¢\u0006\u000b\n\u0002\u0010w\u001a\u0005\b\u0084\u0001\u0010tR\u0015\u0010I\u001a\u0004\u0018\u00010J¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010rR\u001b\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0007¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010rR\u0012\u0010.\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u007fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\r\n\u0003\u0010\u0090\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010rR\u0013\u0010B\u001a\u00020*¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0015\u0010G\u001a\u0004\u0018\u00010H¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R#\u0010M\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\b\u0096\u0001\u0010\u008f\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R#\u0010P\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001f\u0010N\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u009e\u0001\u0010r\"\u0006\b\u009f\u0001\u0010 \u0001R\u001f\u0010O\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¡\u0001\u0010r\"\u0006\b¢\u0001\u0010 \u0001R\u001f\u0010Q\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b£\u0001\u0010r\"\u0006\b¤\u0001\u0010 \u0001R\u0016\u0010=\u001a\u0004\u0018\u00010*¢\u0006\u000b\n\u0002\u0010w\u001a\u0005\b¥\u0001\u0010tR\u0018\u0010;\u001a\u0004\u0018\u00010<¢\u0006\r\n\u0003\u0010\u009d\u0001\u001a\u0006\b¦\u0001\u0010\u009a\u0001R#\u0010_\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\b§\u0001\u0010\u008f\u0001\"\u0006\b¨\u0001\u0010\u0098\u0001R#\u0010^\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\b©\u0001\u0010\u008f\u0001\"\u0006\bª\u0001\u0010\u0098\u0001R\u001f\u0010`\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b«\u0001\u0010r\"\u0006\b¬\u0001\u0010 \u0001R\u001f\u0010a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u00ad\u0001\u0010r\"\u0006\b®\u0001\u0010 \u0001R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001R\u0014\u0010/\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b±\u0001\u0010rR\u0014\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b²\u0001\u0010rR\u0015\u0010C\u001a\u0004\u0018\u00010D¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001R\u0013\u0010\u0016\u001a\u00020\u0015¢\u0006\n\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0012\u00103\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b·\u0001\u0010\u007fR\u0012\u0010\u0012\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b¸\u0001\u0010\u007fR\u0012\u0010\u0010\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b¹\u0001\u0010\u007fR\u001f\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bº\u0001\u0010r\"\u0006\b»\u0001\u0010 \u0001R\u0015\u0010K\u001a\u0004\u0018\u00010L¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001R \u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b¾\u0001\u0010zR\u0015\u00106\u001a\u0004\u0018\u000107¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\bÁ\u0001\u0010rR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u0011¢\u0006\r\n\u0003\u0010\u0090\u0001\u001a\u0006\bÂ\u0001\u0010\u008f\u0001R\u0014\u0010(\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\bÃ\u0001\u0010rR \u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0012\n\u0002\u0010w\u001a\u0005\bÄ\u0001\u0010t\"\u0005\bÅ\u0001\u0010vR#\u0010X\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\bÆ\u0001\u0010\u008f\u0001\"\u0006\bÇ\u0001\u0010\u0098\u0001R\u0014\u0010c\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\bÈ\u0001\u0010rR#\u0010Y\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\bÉ\u0001\u0010\u008f\u0001\"\u0006\bÊ\u0001\u0010\u0098\u0001R#\u0010\\\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\bË\u0001\u0010\u009a\u0001\"\u0006\bÌ\u0001\u0010\u009c\u0001R\u001f\u0010Z\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÍ\u0001\u0010r\"\u0006\bÎ\u0001\u0010 \u0001R\u001f\u0010[\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÏ\u0001\u0010r\"\u0006\bÐ\u0001\u0010 \u0001R\u001f\u0010]\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÑ\u0001\u0010r\"\u0006\bÒ\u0001\u0010 \u0001R\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0000\u001a\u0006\bÓ\u0001\u0010Ô\u0001R#\u0010R\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\bÕ\u0001\u0010\u008f\u0001\"\u0006\bÖ\u0001\u0010\u0098\u0001R\u0018\u0010V\u001a\u0004\u0018\u00010<¢\u0006\r\n\u0003\u0010\u009d\u0001\u001a\u0006\b×\u0001\u0010\u009a\u0001R#\u0010U\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\bØ\u0001\u0010\u009a\u0001\"\u0006\bÙ\u0001\u0010\u009c\u0001R\u001f\u0010S\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÚ\u0001\u0010r\"\u0006\bÛ\u0001\u0010 \u0001R\u001f\u0010T\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÜ\u0001\u0010r\"\u0006\bÝ\u0001\u0010 \u0001R\u001f\u0010W\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÞ\u0001\u0010r\"\u0006\bß\u0001\u0010 \u0001R\u0012\u00102\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\bà\u0001\u0010\u007fR\u0013\u0010A\u001a\u00020*¢\u0006\n\n\u0000\u001a\u0006\bá\u0001\u0010\u0093\u0001R\u0013\u0010@\u001a\u00020<¢\u0006\n\n\u0000\u001a\u0006\bâ\u0001\u0010ã\u0001R \u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\bä\u0001\u0010zR\u0015\u0010>\u001a\u0004\u0018\u00010?¢\u0006\n\n\u0000\u001a\u0006\bå\u0001\u0010æ\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\t\n\u0000\u001a\u0005\bç\u0001\u0010zR#\u0010,\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\bè\u0001\u0010\u008f\u0001\"\u0006\bé\u0001\u0010\u0098\u0001R \u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\bê\u0001\u0010zR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0000\u001a\u0006\bë\u0001\u0010\u008b\u0001R\u0013\u0010-\u001a\u00020*¢\u0006\n\n\u0000\u001a\u0006\bì\u0001\u0010\u0093\u0001R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0000\u001a\u0006\bí\u0001\u0010î\u0001R\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0000\u001a\u0006\bï\u0001\u0010ð\u0001R\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0000\u001a\u0006\bñ\u0001\u0010ò\u0001R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0011¢\u0006\r\n\u0003\u0010\u0090\u0001\u001a\u0006\bó\u0001\u0010\u008f\u0001R\u0015\u0010i\u001a\u0004\u0018\u00010j¢\u0006\n\n\u0000\u001a\u0006\bô\u0001\u0010õ\u0001R\u0013\u0010\u0014\u001a\u00020\u0015¢\u0006\n\n\u0000\u001a\u0006\bö\u0001\u0010¶\u0001¨\u0006Õ\u0002"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuInfoVO;", "Ljava/io/Serializable;", "skuList", "", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfoVO;", "specInfoList", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfo;", "clothesSizeAssistant", "Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "cover", "bigCover", "pictureMap", "bigPicMap", "smallPicMap", "minPrice", "", "maxPrice", "buttonLabel", "upperLimit", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "lowerLimit", "unUseMinPrice", "discountPrice", "discountPriceHeader", "presellType", "deliveryDelayDesc", "presellDelayDesc", "installmentInfo", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;", "tradeModeComponent", "Lcom/bytedance/android/ec/model/sku/TradeModeComponent;", "safeguardComponent", "Lcom/bytedance/android/ec/model/sku/SafeguardComponent;", "topBannerComponent", "Lcom/bytedance/android/ec/model/sku/TopBannerComponent;", "trustTags", "Lcom/bytedance/android/ec/model/sku/SkuTrustTags;", "logExtra", "priceHeader", "priceHeaderStyle", "", "newBonusText", "skuType", a.KEY_STATUS, "depositPrice", "limitText", "campaignStartTime", "campaignEndTime", "serverTime", "marketPrice", "activityIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "poiInfo", "Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "atmosphereHeader", "atmosphereBackground", "campaignSubType", "hasGivenProduct", "", "givenProductStock", "skuBanner", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;", "showStock", "showPriceStyle", "discountPriceStyleType", "logPb", "Lcom/bytedance/android/ec/model/api/LogPbData;", "defaultButtons", "Lcom/bytedance/android/ec/model/sku/SkuBottomButtons;", "displayConfig", "Lcom/bytedance/android/ec/model/sku/DisplayConfig;", "carAdaptComponent", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "orderComponent", "Lcom/bytedance/android/ec/model/sku/OrderComponent;", "firstPrice", "firstPricePrefix", "firstPriceSuffix", "firstPriceIsUnderline", "firstPriceSupplement", "secondPrice", "secondPricePrefix", "secondPriceSuffix", "secondPriceIsUnderline", "secondPriceIsReducePrice", "secondPriceSupplement", "priceType", "regularPrice", "regularPricePrefix", "regularPriceSuffix", "regularPriceIsUnderline", "regularPriceSupplement", "hotMinPrice", "hotMaxPrice", "hotPricePrefix", "hotPriceSupplement", "atmosphereStyle", "productExtra", "buttonTipComponent", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "showTrackParams", "addCartGuideInfo", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;", "updateActionOption", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;", "(Ljava/util/Map;Ljava/util/List;Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JJLjava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;Lcom/bytedance/android/ec/model/sku/TradeModeComponent;Lcom/bytedance/android/ec/model/sku/SafeguardComponent;Lcom/bytedance/android/ec/model/sku/TopBannerComponent;Lcom/bytedance/android/ec/model/sku/SkuTrustTags;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;IJLjava/lang/String;JJJJLcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;ZIILcom/bytedance/android/ec/model/api/LogPbData;Ljava/util/List;Lcom/bytedance/android/ec/model/sku/DisplayConfig;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/OrderComponent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/util/Map;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;)V", "getActivityIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getAddCartGuideInfo", "()Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;", "getAtmosphereBackground", "getAtmosphereHeader", "()Ljava/lang/String;", "getAtmosphereStyle", "()Ljava/lang/Integer;", "setAtmosphereStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBigCover", "getBigPicMap", "()Ljava/util/Map;", "getButtonLabel", "getButtonTipComponent", "()Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "getCampaignEndTime", "()J", "setCampaignEndTime", "(J)V", "getCampaignStartTime", "setCampaignStartTime", "getCampaignSubType", "getCarAdaptComponent", "()Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getClothesSizeAssistant", "()Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "getCover", "getDefaultButtons", "()Ljava/util/List;", "getDeliveryDelayDesc", "getDepositPrice", "getDiscountPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDiscountPriceHeader", "getDiscountPriceStyleType", "()I", "getDisplayConfig", "()Lcom/bytedance/android/ec/model/sku/DisplayConfig;", "getFirstPrice", "setFirstPrice", "(Ljava/lang/Long;)V", "getFirstPriceIsUnderline", "()Ljava/lang/Boolean;", "setFirstPriceIsUnderline", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getFirstPricePrefix", "setFirstPricePrefix", "(Ljava/lang/String;)V", "getFirstPriceSuffix", "setFirstPriceSuffix", "getFirstPriceSupplement", "setFirstPriceSupplement", "getGivenProductStock", "getHasGivenProduct", "getHotMaxPrice", "setHotMaxPrice", "getHotMinPrice", "setHotMinPrice", "getHotPricePrefix", "setHotPricePrefix", "getHotPriceSupplement", "setHotPriceSupplement", "getInstallmentInfo", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;", "getLimitText", "getLogExtra", "getLogPb", "()Lcom/bytedance/android/ec/model/api/LogPbData;", "getLowerLimit", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "getMarketPrice", "getMaxPrice", "getMinPrice", "getNewBonusText", "setNewBonusText", "getOrderComponent", "()Lcom/bytedance/android/ec/model/sku/OrderComponent;", "getPictureMap", "getPoiInfo", "()Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "getPresellDelayDesc", "getPresellType", "getPriceHeader", "getPriceHeaderStyle", "setPriceHeaderStyle", "getPriceType", "setPriceType", "getProductExtra", "getRegularPrice", "setRegularPrice", "getRegularPriceIsUnderline", "setRegularPriceIsUnderline", "getRegularPricePrefix", "setRegularPricePrefix", "getRegularPriceSuffix", "setRegularPriceSuffix", "getRegularPriceSupplement", "setRegularPriceSupplement", "getSafeguardComponent", "()Lcom/bytedance/android/ec/model/sku/SafeguardComponent;", "getSecondPrice", "setSecondPrice", "getSecondPriceIsReducePrice", "getSecondPriceIsUnderline", "setSecondPriceIsUnderline", "getSecondPricePrefix", "setSecondPricePrefix", "getSecondPriceSuffix", "setSecondPriceSuffix", "getSecondPriceSupplement", "setSecondPriceSupplement", "getServerTime", "getShowPriceStyle", "getShowStock", "()Z", "getShowTrackParams", "getSkuBanner", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;", "getSkuList", "getSkuType", "setSkuType", "getSmallPicMap", "getSpecInfoList", "getStatus", "getTopBannerComponent", "()Lcom/bytedance/android/ec/model/sku/TopBannerComponent;", "getTradeModeComponent", "()Lcom/bytedance/android/ec/model/sku/TradeModeComponent;", "getTrustTags", "()Lcom/bytedance/android/ec/model/sku/SkuTrustTags;", "getUnUseMinPrice", "getUpdateActionOption", "()Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;", "getUpperLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component8", "component9", "copy", "(Ljava/util/Map;Ljava/util/List;Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JJLjava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;Lcom/bytedance/android/ec/model/sku/TradeModeComponent;Lcom/bytedance/android/ec/model/sku/SafeguardComponent;Lcom/bytedance/android/ec/model/sku/TopBannerComponent;Lcom/bytedance/android/ec/model/sku/SkuTrustTags;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;IJLjava/lang/String;JJJJLcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;ZIILcom/bytedance/android/ec/model/api/LogPbData;Ljava/util/List;Lcom/bytedance/android/ec/model/sku/DisplayConfig;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/OrderComponent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/util/Map;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;)Lcom/bytedance/android/ec/common/impl/sku/model/SkuInfoVO;", "equals", "other", "", "hashCode", "isGroupBuyDefault", "isInActivityDefault", "isInDepositPresaleDefault", "isInPreSecKillDefault", "isInSecKillDefault", "isRangePrice", "isSoldOut", "isUnderStock", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuInfoVO implements Serializable {
    private final ECUrlModel activityIcon;
    private final SkuAddCartGuideInfo addCartGuideInfo;
    private final ECUrlModel atmosphereBackground;
    private final String atmosphereHeader;
    private Integer atmosphereStyle;
    private final String bigCover;
    private final Map<String, String> bigPicMap;
    private final String buttonLabel;
    private final ButtonTipComponent buttonTipComponent;
    private long campaignEndTime;
    private long campaignStartTime;
    private final Integer campaignSubType;
    private final CarAdaptComponent carAdaptComponent;
    private final ClothesSizeAssistantStruct clothesSizeAssistant;
    private final String cover;
    private final List<SkuBottomButtons> defaultButtons;
    private final String deliveryDelayDesc;
    private final long depositPrice;
    private final Long discountPrice;
    private final String discountPriceHeader;
    private final int discountPriceStyleType;
    private final DisplayConfig displayConfig;
    private Long firstPrice;
    private Boolean firstPriceIsUnderline;
    private String firstPricePrefix;
    private String firstPriceSuffix;
    private String firstPriceSupplement;
    private final Integer givenProductStock;
    private final Boolean hasGivenProduct;
    private Long hotMaxPrice;
    private Long hotMinPrice;
    private String hotPricePrefix;
    private String hotPriceSupplement;
    private final SkuInstallmentItemInfo installmentInfo;
    private final String limitText;
    private final String logExtra;
    private final LogPbData logPb;
    private final SkuLimit lowerLimit;
    private final long marketPrice;
    private final long maxPrice;
    private final long minPrice;
    private String newBonusText;
    private final OrderComponent orderComponent;
    private final Map<String, String> pictureMap;
    private final SkuPoiInfo poiInfo;
    private final String presellDelayDesc;
    private final Long presellType;
    private final String priceHeader;
    private Integer priceHeaderStyle;
    private Long priceType;
    private final String productExtra;
    private Long regularPrice;
    private Boolean regularPriceIsUnderline;
    private String regularPricePrefix;
    private String regularPriceSuffix;
    private String regularPriceSupplement;
    private final SafeguardComponent safeguardComponent;
    private Long secondPrice;
    private final Boolean secondPriceIsReducePrice;
    private Boolean secondPriceIsUnderline;
    private String secondPricePrefix;
    private String secondPriceSuffix;
    private String secondPriceSupplement;
    private final long serverTime;
    private final int showPriceStyle;
    private final boolean showStock;
    private final Map<String, String> showTrackParams;
    private final SkuBannerStruct skuBanner;
    private final Map<String, SkuItemInfoVO> skuList;
    private Long skuType;
    private final Map<String, String> smallPicMap;
    private final List<SpecInfo> specInfoList;
    private final int status;
    private final TopBannerComponent topBannerComponent;
    private final TradeModeComponent tradeModeComponent;
    private final SkuTrustTags trustTags;
    private final Long unUseMinPrice;
    private final UpdateActionOption updateActionOption;
    private final SkuLimit upperLimit;

    public SkuInfoVO() {
        this(null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, false, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuInfoVO copy$default(SkuInfoVO r24, Map r25, List r26, ClothesSizeAssistantStruct r27, String r28, String r29, Map r30, Map r31, Map r32, long r33, long r35, String r37, SkuLimit r38, SkuLimit r39, Long r40, Long r41, String r42, Long r43, String r44, String r45, SkuInstallmentItemInfo r46, TradeModeComponent r47, SafeguardComponent r48, TopBannerComponent r49, SkuTrustTags r50, String r51, String r52, Integer r53, String r54, Long r55, int r56, long r57, String r59, long r60, long r62, long r64, long r66, ECUrlModel r68, SkuPoiInfo r69, String r70, ECUrlModel r71, Integer r72, Boolean r73, Integer r74, SkuBannerStruct r75, boolean r76, int r77, int r78, LogPbData r79, List r80, DisplayConfig r81, CarAdaptComponent r82, OrderComponent r83, Long r84, String r85, String r86, Boolean r87, String r88, Long r89, String r90, String r91, Boolean r92, Boolean r93, String r94, Long r95, Long r96, String r97, String r98, Boolean r99, String r100, Long r101, Long r102, String r103, String r104, Integer r105, String r106, ButtonTipComponent r107, Map r108, SkuAddCartGuideInfo r109, UpdateActionOption r110, int r111, int r112, int r113, Object r114) {
        if ((r111 & 1) == 0) goto L5;
        Map r10 = r24.skuList;
    L7:
        if ((r111 & 2) == 0) goto L9;
        List r11 = r24.specInfoList;
    L11:
        if ((r111 & 4) == 0) goto L13;
        ClothesSizeAssistantStruct r12 = r24.clothesSizeAssistant;
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r13 = r24.cover;
    L19:
        if ((r111 & 16) == 0) goto L21;
        String r14 = r24.bigCover;
    L23:
        if ((r111 & 32) == 0) goto L25;
        Map r15 = r24.pictureMap;
    L27:
        if ((r111 & 64) == 0) goto L29;
        Map r16 = r24.bigPicMap;
    L31:
        if ((r111 & 128) == 0) goto L33;
        Map r17 = r24.smallPicMap;
    L35:
        if ((r111 & 256) == 0) goto L37;
        long r18 = r24.minPrice;
    L39:
        if ((r111 & 512) == 0) goto L41;
        long r19 = r24.maxPrice;
    L42:
        long r36 = r19;
        if ((r111 & 1024) == 0) goto L45;
        String r115 = r24.buttonLabel;
    L47:
        if ((r111 & 2048) == 0) goto L49;
        SkuLimit r116 = r24.upperLimit;
    L50:
        SkuLimit r310 = r116;
        if ((r111 & 4096) == 0) goto L53;
        SkuLimit r117 = r24.lowerLimit;
    L54:
        SkuLimit r311 = r117;
        if ((r111 & 8192) == 0) goto L57;
        Long r118 = r24.unUseMinPrice;
    L58:
        Long r410 = r118;
        if ((r111 & 16384) == 0) goto L61;
        Long r119 = r24.discountPrice;
    L62:
        Long r411 = r119;
        if ((r111 & 32768) == 0) goto L65;
        String r120 = r24.discountPriceHeader;
    L66:
        String r412 = r120;
        if ((r111 & 65536) == 0) goto L69;
        Long r121 = r24.presellType;
    L70:
        Long r413 = r121;
        if ((r111 & 131072) == 0) goto L73;
        String r122 = r24.deliveryDelayDesc;
    L74:
        String r414 = r122;
        if ((r111 & 262144) == 0) goto L77;
        String r123 = r24.presellDelayDesc;
    L78:
        String r415 = r123;
        if ((r111 & 524288) == 0) goto L81;
        SkuInstallmentItemInfo r124 = r24.installmentInfo;
    L82:
        SkuInstallmentItemInfo r416 = r124;
        if ((r111 & 1048576) == 0) goto L85;
        TradeModeComponent r125 = r24.tradeModeComponent;
    L86:
        TradeModeComponent r417 = r125;
        if ((r111 & 2097152) == 0) goto L89;
        SafeguardComponent r126 = r24.safeguardComponent;
    L90:
        SafeguardComponent r418 = r126;
        if ((r111 & 4194304) == 0) goto L93;
        TopBannerComponent r127 = r24.topBannerComponent;
    L94:
        TopBannerComponent r419 = r127;
        if ((r111 & 8388608) == 0) goto L97;
        SkuTrustTags r128 = r24.trustTags;
    L98:
        SkuTrustTags r58 = r128;
        if ((r111 & 16777216) == 0) goto L101;
        String r129 = r24.logExtra;
    L102:
        String r510 = r129;
        if ((r111 & 33554432) == 0) goto L105;
        String r130 = r24.priceHeader;
    L106:
        String r511 = r130;
        if ((r111 & 67108864) == 0) goto L109;
        Integer r131 = r24.priceHeaderStyle;
    L110:
        Integer r512 = r131;
        if ((r111 & 134217728) == 0) goto L113;
        String r132 = r24.newBonusText;
    L114:
        String r513 = r132;
        if ((r111 & 268435456) == 0) goto L117;
        Long r133 = r24.skuType;
    L118:
        Long r514 = r133;
        if ((r111 & 536870912) == 0) goto L121;
        int r134 = r24.status;
    L122:
        String r312 = r115;
        int r515 = r134;
        if ((r111 & 1073741824) == 0) goto L125;
        long r135 = r24.depositPrice;
    L127:
        if ((r111 & Integer.MIN_VALUE) == 0) goto L129;
        String r1 = r24.limitText;
    L130:
        long r516 = r135;
        if ((r112 & 1) == 0) goto L133;
        long r136 = r24.campaignStartTime;
    L134:
        long r61 = r136;
        if ((r112 & 2) == 0) goto L137;
        long r137 = r24.campaignEndTime;
    L138:
        long r63 = r137;
        if ((r112 & 4) == 0) goto L141;
        long r138 = r24.serverTime;
    L142:
        long r65 = r138;
        if ((r112 & 8) == 0) goto L145;
        long r139 = r24.marketPrice;
    L146:
        long r67 = r139;
        if ((r112 & 16) == 0) goto L149;
        ECUrlModel r140 = r24.activityIcon;
    L151:
        if ((r112 & 32) == 0) goto L153;
        SkuPoiInfo r141 = r24.poiInfo;
    L154:
        SkuPoiInfo r610 = r141;
        if ((r112 & 64) == 0) goto L157;
        String r142 = r24.atmosphereHeader;
    L158:
        String r710 = r142;
        if ((r112 & 128) == 0) goto L161;
        ECUrlModel r143 = r24.atmosphereBackground;
    L162:
        ECUrlModel r711 = r143;
        if ((r112 & 256) == 0) goto L165;
        Integer r144 = r24.campaignSubType;
    L166:
        Integer r712 = r144;
        if ((r112 & 512) == 0) goto L169;
        Boolean r145 = r24.hasGivenProduct;
    L170:
        Boolean r713 = r145;
        if ((r112 & 1024) == 0) goto L173;
        Integer r146 = r24.givenProductStock;
    L174:
        Integer r714 = r146;
        if ((r112 & 2048) == 0) goto L177;
        SkuBannerStruct r147 = r24.skuBanner;
    L178:
        SkuBannerStruct r715 = r147;
        if ((r112 & 4096) == 0) goto L181;
        boolean r148 = r24.showStock;
    L182:
        boolean r716 = r148;
        if ((r112 & 8192) == 0) goto L185;
        int r149 = r24.showPriceStyle;
    L186:
        int r717 = r149;
        if ((r112 & 16384) == 0) goto L189;
        int r150 = r24.discountPriceStyleType;
    L190:
        int r718 = r150;
        if ((r112 & 32768) == 0) goto L193;
        LogPbData r151 = r24.logPb;
    L194:
        LogPbData r719 = r151;
        if ((r112 & 65536) == 0) goto L197;
        List r152 = r24.defaultButtons;
    L198:
        List r810 = r152;
        if ((r112 & 131072) == 0) goto L201;
        DisplayConfig r153 = r24.displayConfig;
    L202:
        DisplayConfig r811 = r153;
        if ((r112 & 262144) == 0) goto L205;
        CarAdaptComponent r154 = r24.carAdaptComponent;
    L206:
        CarAdaptComponent r812 = r154;
        if ((r112 & 524288) == 0) goto L209;
        OrderComponent r155 = r24.orderComponent;
    L210:
        OrderComponent r813 = r155;
        if ((r112 & 1048576) == 0) goto L213;
        Long r156 = r24.firstPrice;
    L214:
        Long r814 = r156;
        if ((r112 & 2097152) == 0) goto L217;
        String r157 = r24.firstPricePrefix;
    L218:
        String r815 = r157;
        if ((r112 & 4194304) == 0) goto L221;
        String r158 = r24.firstPriceSuffix;
    L222:
        String r816 = r158;
        if ((r112 & 8388608) == 0) goto L225;
        Boolean r159 = r24.firstPriceIsUnderline;
    L226:
        Boolean r817 = r159;
        if ((r112 & 16777216) == 0) goto L229;
        String r160 = r24.firstPriceSupplement;
    L230:
        String r818 = r160;
        if ((r112 & 33554432) == 0) goto L233;
        Long r161 = r24.secondPrice;
    L234:
        Long r819 = r161;
        if ((r112 & 67108864) == 0) goto L237;
        String r162 = r24.secondPricePrefix;
    L238:
        String r910 = r162;
        if ((r112 & 134217728) == 0) goto L241;
        String r163 = r24.secondPriceSuffix;
    L242:
        String r911 = r163;
        if ((r112 & 268435456) == 0) goto L245;
        Boolean r164 = r24.secondPriceIsUnderline;
    L246:
        Boolean r912 = r164;
        if ((r112 & 536870912) == 0) goto L249;
        Boolean r165 = r24.secondPriceIsReducePrice;
    L250:
        Boolean r913 = r165;
        if ((r112 & 1073741824) == 0) goto L253;
        String r166 = r24.secondPriceSupplement;
    L255:
        if ((r112 & Integer.MIN_VALUE) == 0) goto L257;
        Long r20 = r24.priceType;
    L258:
        Long r914 = r20;
        if ((r113 & 1) == 0) goto L261;
        Long r21 = r24.regularPrice;
    L262:
        Long r915 = r21;
        if ((r113 & 2) == 0) goto L265;
        String r22 = r24.regularPricePrefix;
    L266:
        String r916 = r22;
        if ((r113 & 4) == 0) goto L269;
        String r23 = r24.regularPriceSuffix;
    L270:
        String r917 = r23;
        if ((r113 & 8) == 0) goto L273;
        Boolean r34 = r24.regularPriceIsUnderline;
    L274:
        Boolean r918 = r34;
        if ((r113 & 16) == 0) goto L277;
        String r167 = r24.regularPriceSupplement;
    L278:
        String r1010 = r167;
        if ((r113 & 32) == 0) goto L281;
        Long r168 = r24.hotMinPrice;
    L282:
        Long r1011 = r168;
        if ((r113 & 64) == 0) goto L285;
        Long r169 = r24.hotMaxPrice;
    L286:
        Long r1012 = r169;
        if ((r113 & 128) == 0) goto L289;
        String r170 = r24.hotPricePrefix;
    L290:
        String r1013 = r170;
        if ((r113 & 256) == 0) goto L293;
        String r171 = r24.hotPriceSupplement;
    L294:
        String r1014 = r171;
        if ((r113 & 512) == 0) goto L297;
        Integer r172 = r24.atmosphereStyle;
    L298:
        Integer r1015 = r172;
        if ((r113 & 1024) == 0) goto L301;
        String r173 = r24.productExtra;
    L302:
        String r1016 = r173;
        if ((r113 & 2048) == 0) goto L305;
        ButtonTipComponent r174 = r24.buttonTipComponent;
    L306:
        ButtonTipComponent r1017 = r174;
        if ((r113 & 4096) == 0) goto L309;
        Map r175 = r24.showTrackParams;
    L310:
        Map r1018 = r175;
        if ((r113 & 8192) == 0) goto L313;
        SkuAddCartGuideInfo r176 = r24.addCartGuideInfo;
    L315:
        if ((r113 & 16384) == 0) goto L317;
        UpdateActionOption r177 = r24.updateActionOption;
    L319:
        return r24.copy(r10, r11, r12, r13, r14, r15, r16, r17, r18, r36, r312, r310, r311, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r58, r510, r511, r512, r513, r514, r515, r516, r1, r61, r63, r65, r67, r140, r610, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r166, r914, r915, r916, r917, r918, r1010, r1011, r1012, r1013, r1014, r1015, r1016, r1017, r1018, r176, r177);
    L317:
        r177 = r110;
        goto L319
    L313:
        r176 = r109;
        goto L315
    L309:
        r175 = r108;
        goto L310
    L305:
        r174 = r107;
        goto L306
    L301:
        r173 = r106;
        goto L302
    L297:
        r172 = r105;
        goto L298
    L293:
        r171 = r104;
        goto L294
    L289:
        r170 = r103;
        goto L290
    L285:
        r169 = r102;
        goto L286
    L281:
        r168 = r101;
        goto L282
    L277:
        r167 = r100;
        goto L278
    L273:
        r34 = r99;
        goto L274
    L269:
        r23 = r98;
        goto L270
    L265:
        r22 = r97;
        goto L266
    L261:
        r21 = r96;
        goto L262
    L257:
        r20 = r95;
        goto L258
    L253:
        r166 = r94;
        goto L255
    L249:
        r165 = r93;
        goto L250
    L245:
        r164 = r92;
        goto L246
    L241:
        r163 = r91;
        goto L242
    L237:
        r162 = r90;
        goto L238
    L233:
        r161 = r89;
        goto L234
    L229:
        r160 = r88;
        goto L230
    L225:
        r159 = r87;
        goto L226
    L221:
        r158 = r86;
        goto L222
    L217:
        r157 = r85;
        goto L218
    L213:
        r156 = r84;
        goto L214
    L209:
        r155 = r83;
        goto L210
    L205:
        r154 = r82;
        goto L206
    L201:
        r153 = r81;
        goto L202
    L197:
        r152 = r80;
        goto L198
    L193:
        r151 = r79;
        goto L194
    L189:
        r150 = r78;
        goto L190
    L185:
        r149 = r77;
        goto L186
    L181:
        r148 = r76;
        goto L182
    L177:
        r147 = r75;
        goto L178
    L173:
        r146 = r74;
        goto L174
    L169:
        r145 = r73;
        goto L170
    L165:
        r144 = r72;
        goto L166
    L161:
        r143 = r71;
        goto L162
    L157:
        r142 = r70;
        goto L158
    L153:
        r141 = r69;
        goto L154
    L149:
        r140 = r68;
        goto L151
    L145:
        r139 = r66;
        goto L146
    L141:
        r138 = r64;
        goto L142
    L137:
        r137 = r62;
        goto L138
    L133:
        r136 = r60;
        goto L134
    L129:
        r1 = r59;
        goto L130
    L125:
        r135 = r57;
        goto L127
    L121:
        r134 = r56;
        goto L122
    L117:
        r133 = r55;
        goto L118
    L113:
        r132 = r54;
        goto L114
    L109:
        r131 = r53;
        goto L110
    L105:
        r130 = r52;
        goto L106
    L101:
        r129 = r51;
        goto L102
    L97:
        r128 = r50;
        goto L98
    L93:
        r127 = r49;
        goto L94
    L89:
        r126 = r48;
        goto L90
    L85:
        r125 = r47;
        goto L86
    L81:
        r124 = r46;
        goto L82
    L77:
        r123 = r45;
        goto L78
    L73:
        r122 = r44;
        goto L74
    L69:
        r121 = r43;
        goto L70
    L65:
        r120 = r42;
        goto L66
    L61:
        r119 = r41;
        goto L62
    L57:
        r118 = r40;
        goto L58
    L53:
        r117 = r39;
        goto L54
    L49:
        r116 = r38;
        goto L50
    L45:
        r115 = r37;
        goto L47
    L41:
        r19 = r35;
        goto L42
    L37:
        r18 = r33;
        goto L39
    L33:
        r17 = r32;
        goto L35
    L29:
        r16 = r31;
        goto L31
    L25:
        r15 = r30;
        goto L27
    L21:
        r14 = r29;
        goto L23
    L17:
        r13 = r28;
        goto L19
    L13:
        r12 = r27;
        goto L15
    L9:
        r11 = r26;
        goto L11
    L5:
        r10 = r25;
        goto L7
    }

    public final Map<String, SkuItemInfoVO> component1() {
        return this.skuList;
    }

    public final long component10() {
        return this.maxPrice;
    }

    public final String component11() {
        return this.buttonLabel;
    }

    public final SkuLimit component12() {
        return this.upperLimit;
    }

    public final SkuLimit component13() {
        return this.lowerLimit;
    }

    public final Long component14() {
        return this.unUseMinPrice;
    }

    public final Long component15() {
        return this.discountPrice;
    }

    public final String component16() {
        return this.discountPriceHeader;
    }

    public final Long component17() {
        return this.presellType;
    }

    public final String component18() {
        return this.deliveryDelayDesc;
    }

    public final String component19() {
        return this.presellDelayDesc;
    }

    public final List<SpecInfo> component2() {
        return this.specInfoList;
    }

    public final SkuInstallmentItemInfo component20() {
        return this.installmentInfo;
    }

    public final TradeModeComponent component21() {
        return this.tradeModeComponent;
    }

    public final SafeguardComponent component22() {
        return this.safeguardComponent;
    }

    public final TopBannerComponent component23() {
        return this.topBannerComponent;
    }

    public final SkuTrustTags component24() {
        return this.trustTags;
    }

    public final String component25() {
        return this.logExtra;
    }

    public final String component26() {
        return this.priceHeader;
    }

    public final Integer component27() {
        return this.priceHeaderStyle;
    }

    public final String component28() {
        return this.newBonusText;
    }

    public final Long component29() {
        return this.skuType;
    }

    public final ClothesSizeAssistantStruct component3() {
        return this.clothesSizeAssistant;
    }

    public final int component30() {
        return this.status;
    }

    public final long component31() {
        return this.depositPrice;
    }

    public final String component32() {
        return this.limitText;
    }

    public final long component33() {
        return this.campaignStartTime;
    }

    public final long component34() {
        return this.campaignEndTime;
    }

    public final long component35() {
        return this.serverTime;
    }

    public final long component36() {
        return this.marketPrice;
    }

    public final ECUrlModel component37() {
        return this.activityIcon;
    }

    public final SkuPoiInfo component38() {
        return this.poiInfo;
    }

    public final String component39() {
        return this.atmosphereHeader;
    }

    public final String component4() {
        return this.cover;
    }

    public final ECUrlModel component40() {
        return this.atmosphereBackground;
    }

    public final Integer component41() {
        return this.campaignSubType;
    }

    public final Boolean component42() {
        return this.hasGivenProduct;
    }

    public final Integer component43() {
        return this.givenProductStock;
    }

    public final SkuBannerStruct component44() {
        return this.skuBanner;
    }

    public final boolean component45() {
        return this.showStock;
    }

    public final int component46() {
        return this.showPriceStyle;
    }

    public final int component47() {
        return this.discountPriceStyleType;
    }

    public final LogPbData component48() {
        return this.logPb;
    }

    public final List<SkuBottomButtons> component49() {
        return this.defaultButtons;
    }

    public final String component5() {
        return this.bigCover;
    }

    public final DisplayConfig component50() {
        return this.displayConfig;
    }

    public final CarAdaptComponent component51() {
        return this.carAdaptComponent;
    }

    public final OrderComponent component52() {
        return this.orderComponent;
    }

    public final Long component53() {
        return this.firstPrice;
    }

    public final String component54() {
        return this.firstPricePrefix;
    }

    public final String component55() {
        return this.firstPriceSuffix;
    }

    public final Boolean component56() {
        return this.firstPriceIsUnderline;
    }

    public final String component57() {
        return this.firstPriceSupplement;
    }

    public final Long component58() {
        return this.secondPrice;
    }

    public final String component59() {
        return this.secondPricePrefix;
    }

    public final Map<String, String> component6() {
        return this.pictureMap;
    }

    public final String component60() {
        return this.secondPriceSuffix;
    }

    public final Boolean component61() {
        return this.secondPriceIsUnderline;
    }

    public final Boolean component62() {
        return this.secondPriceIsReducePrice;
    }

    public final String component63() {
        return this.secondPriceSupplement;
    }

    public final Long component64() {
        return this.priceType;
    }

    public final Long component65() {
        return this.regularPrice;
    }

    public final String component66() {
        return this.regularPricePrefix;
    }

    public final String component67() {
        return this.regularPriceSuffix;
    }

    public final Boolean component68() {
        return this.regularPriceIsUnderline;
    }

    public final String component69() {
        return this.regularPriceSupplement;
    }

    public final Map<String, String> component7() {
        return this.bigPicMap;
    }

    public final Long component70() {
        return this.hotMinPrice;
    }

    public final Long component71() {
        return this.hotMaxPrice;
    }

    public final String component72() {
        return this.hotPricePrefix;
    }

    public final String component73() {
        return this.hotPriceSupplement;
    }

    public final Integer component74() {
        return this.atmosphereStyle;
    }

    public final String component75() {
        return this.productExtra;
    }

    public final ButtonTipComponent component76() {
        return this.buttonTipComponent;
    }

    public final Map<String, String> component77() {
        return this.showTrackParams;
    }

    public final SkuAddCartGuideInfo component78() {
        return this.addCartGuideInfo;
    }

    public final UpdateActionOption component79() {
        return this.updateActionOption;
    }

    public final Map<String, String> component8() {
        return this.smallPicMap;
    }

    public final long component9() {
        return this.minPrice;
    }

    public final SkuInfoVO copy(Map<String, SkuItemInfoVO> r90, List<SpecInfo> r91, ClothesSizeAssistantStruct r92, String r93, String r94, Map<String, String> r95, Map<String, String> r96, Map<String, String> r97, long r98, long r100, String r102, SkuLimit r103, SkuLimit r104, Long r105, Long r106, String r107, Long r108, String r109, String r110, SkuInstallmentItemInfo r111, TradeModeComponent r112, SafeguardComponent r113, TopBannerComponent r114, SkuTrustTags r115, String r116, String r117, Integer r118, String r119, Long r120, int r121, long r122, String r124, long r125, long r127, long r129, long r131, ECUrlModel r133, SkuPoiInfo r134, String r135, ECUrlModel r136, Integer r137, Boolean r138, Integer r139, SkuBannerStruct r140, boolean r141, int r142, int r143, LogPbData r144, List<SkuBottomButtons> r145, DisplayConfig r146, CarAdaptComponent r147, OrderComponent r148, Long r149, String r150, String r151, Boolean r152, String r153, Long r154, String r155, String r156, Boolean r157, Boolean r158, String r159, Long r160, Long r161, String r162, String r163, Boolean r164, String r165, Long r166, Long r167, String r168, String r169, Integer r170, String r171, ButtonTipComponent r172, Map<String, String> r173, SkuAddCartGuideInfo r174, UpdateActionOption r175) {
        Intrinsics.checkNotNullParameter(r90, "skuList");
        Intrinsics.checkNotNullParameter(r91, "specInfoList");
        Intrinsics.checkNotNullParameter(r103, "upperLimit");
        Intrinsics.checkNotNullParameter(r104, "lowerLimit");
        return new SkuInfoVO(r90, r91, r92, r93, r94, r95, r96, r97, r98, r100, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r124, r125, r127, r129, r131, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof SkuInfoVO) == false) goto L164;
        SkuInfoVO r11 = (SkuInfoVO) r10;
        if (Intrinsics.areEqual(this.skuList, r11.skuList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.specInfoList, r11.specInfoList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clothesSizeAssistant, r11.clothesSizeAssistant) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cover, r11.cover) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bigCover, r11.bigCover) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.pictureMap, r11.pictureMap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bigPicMap, r11.bigPicMap) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.smallPicMap, r11.smallPicMap) == true) goto L22;
        return false;
    L22:
        if (this.minPrice == r11.minPrice) goto L24;
        return false;
    L24:
        if (this.maxPrice == r11.maxPrice) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.buttonLabel, r11.buttonLabel) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.upperLimit, r11.upperLimit) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lowerLimit, r11.lowerLimit) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.unUseMinPrice, r11.unUseMinPrice) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.discountPrice, r11.discountPrice) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.discountPriceHeader, r11.discountPriceHeader) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.presellType, r11.presellType) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.deliveryDelayDesc, r11.deliveryDelayDesc) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.presellDelayDesc, r11.presellDelayDesc) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.installmentInfo, r11.installmentInfo) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.tradeModeComponent, r11.tradeModeComponent) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.safeguardComponent, r11.safeguardComponent) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.topBannerComponent, r11.topBannerComponent) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.trustTags, r11.trustTags) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.logExtra, r11.logExtra) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.priceHeader, r11.priceHeader) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.priceHeaderStyle, r11.priceHeaderStyle) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.newBonusText, r11.newBonusText) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.skuType, r11.skuType) == true) goto L64;
        return false;
    L64:
        if (this.status == r11.status) goto L66;
        return false;
    L66:
        if (this.depositPrice == r11.depositPrice) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.limitText, r11.limitText) == true) goto L70;
        return false;
    L70:
        if (this.campaignStartTime == r11.campaignStartTime) goto L72;
        return false;
    L72:
        if (this.campaignEndTime == r11.campaignEndTime) goto L74;
        return false;
    L74:
        if (this.serverTime == r11.serverTime) goto L76;
        return false;
    L76:
        if (this.marketPrice == r11.marketPrice) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.activityIcon, r11.activityIcon) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.poiInfo, r11.poiInfo) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.atmosphereHeader, r11.atmosphereHeader) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.atmosphereBackground, r11.atmosphereBackground) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.campaignSubType, r11.campaignSubType) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.hasGivenProduct, r11.hasGivenProduct) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.givenProductStock, r11.givenProductStock) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.skuBanner, r11.skuBanner) == true) goto L94;
        return false;
    L94:
        if (this.showStock == r11.showStock) goto L96;
        return false;
    L96:
        if (this.showPriceStyle == r11.showPriceStyle) goto L98;
        return false;
    L98:
        if (this.discountPriceStyleType == r11.discountPriceStyleType) goto L100;
        return false;
    L100:
        if (Intrinsics.areEqual(this.logPb, r11.logPb) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.defaultButtons, r11.defaultButtons) == true) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.displayConfig, r11.displayConfig) == true) goto L106;
        return false;
    L106:
        if (Intrinsics.areEqual(this.carAdaptComponent, r11.carAdaptComponent) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.orderComponent, r11.orderComponent) == true) goto L110;
        return false;
    L110:
        if (Intrinsics.areEqual(this.firstPrice, r11.firstPrice) == true) goto L112;
        return false;
    L112:
        if (Intrinsics.areEqual(this.firstPricePrefix, r11.firstPricePrefix) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.firstPriceSuffix, r11.firstPriceSuffix) == true) goto L116;
        return false;
    L116:
        if (Intrinsics.areEqual(this.firstPriceIsUnderline, r11.firstPriceIsUnderline) == true) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.firstPriceSupplement, r11.firstPriceSupplement) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.secondPrice, r11.secondPrice) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.secondPricePrefix, r11.secondPricePrefix) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.secondPriceSuffix, r11.secondPriceSuffix) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.secondPriceIsUnderline, r11.secondPriceIsUnderline) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.secondPriceIsReducePrice, r11.secondPriceIsReducePrice) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.secondPriceSupplement, r11.secondPriceSupplement) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.priceType, r11.priceType) == true) goto L134;
        return false;
    L134:
        if (Intrinsics.areEqual(this.regularPrice, r11.regularPrice) == true) goto L136;
        return false;
    L136:
        if (Intrinsics.areEqual(this.regularPricePrefix, r11.regularPricePrefix) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.regularPriceSuffix, r11.regularPriceSuffix) == true) goto L140;
        return false;
    L140:
        if (Intrinsics.areEqual(this.regularPriceIsUnderline, r11.regularPriceIsUnderline) == true) goto L142;
        return false;
    L142:
        if (Intrinsics.areEqual(this.regularPriceSupplement, r11.regularPriceSupplement) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.hotMinPrice, r11.hotMinPrice) == true) goto L146;
        return false;
    L146:
        if (Intrinsics.areEqual(this.hotMaxPrice, r11.hotMaxPrice) == true) goto L148;
        return false;
    L148:
        if (Intrinsics.areEqual(this.hotPricePrefix, r11.hotPricePrefix) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.hotPriceSupplement, r11.hotPriceSupplement) == true) goto L152;
        return false;
    L152:
        if (Intrinsics.areEqual(this.atmosphereStyle, r11.atmosphereStyle) == true) goto L154;
        return false;
    L154:
        if (Intrinsics.areEqual(this.productExtra, r11.productExtra) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.buttonTipComponent, r11.buttonTipComponent) == true) goto L158;
        return false;
    L158:
        if (Intrinsics.areEqual(this.showTrackParams, r11.showTrackParams) == true) goto L160;
        return false;
    L160:
        if (Intrinsics.areEqual(this.addCartGuideInfo, r11.addCartGuideInfo) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.updateActionOption, r11.updateActionOption) == true) goto L247;
        return false;
    L247:
        return true;
    L164:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v121, types: [int] */
    /* JADX WARN: Type inference failed for: r2v249 */
    /* JADX WARN: Type inference failed for: r2v285 */
    public int hashCode() {
        Map<String, SkuItemInfoVO> r0 = this.skuList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        List<SpecInfo> r12 = this.specInfoList;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        ClothesSizeAssistantStruct r15 = this.clothesSizeAssistant;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.cover;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.bigCover;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        Map<String, String> r24 = this.pictureMap;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        Map<String, String> r27 = this.bigPicMap;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        Map<String, String> r30 = this.smallPicMap;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        long r33 = this.minPrice;
        int r34 = (r32 + ((int) (r33 ^ (r33 >>> 32)))) * 31;
        long r35 = this.maxPrice;
        int r36 = (r34 + ((int) (r35 ^ (r35 >>> 32)))) * 31;
        String r37 = this.buttonLabel;
        if (r37 == null) goto L37;
        int r38 = r37.hashCode();
    L38:
        int r39 = (r36 + r38) * 31;
        SkuLimit r40 = this.upperLimit;
        if (r40 == null) goto L41;
        int r41 = r40.hashCode();
    L42:
        int r42 = (r39 + r41) * 31;
        SkuLimit r43 = this.lowerLimit;
        if (r43 == null) goto L45;
        int r44 = r43.hashCode();
    L46:
        int r45 = (r42 + r44) * 31;
        Long r46 = this.unUseMinPrice;
        if (r46 == null) goto L49;
        int r47 = r46.hashCode();
    L50:
        int r48 = (r45 + r47) * 31;
        Long r49 = this.discountPrice;
        if (r49 == null) goto L53;
        int r50 = r49.hashCode();
    L54:
        int r51 = (r48 + r50) * 31;
        String r52 = this.discountPriceHeader;
        if (r52 == null) goto L57;
        int r53 = r52.hashCode();
    L58:
        int r54 = (r51 + r53) * 31;
        Long r55 = this.presellType;
        if (r55 == null) goto L61;
        int r56 = r55.hashCode();
    L62:
        int r57 = (r54 + r56) * 31;
        String r58 = this.deliveryDelayDesc;
        if (r58 == null) goto L65;
        int r59 = r58.hashCode();
    L66:
        int r60 = (r57 + r59) * 31;
        String r61 = this.presellDelayDesc;
        if (r61 == null) goto L69;
        int r62 = r61.hashCode();
    L70:
        int r63 = (r60 + r62) * 31;
        SkuInstallmentItemInfo r64 = this.installmentInfo;
        if (r64 == null) goto L73;
        int r65 = r64.hashCode();
    L74:
        int r66 = (r63 + r65) * 31;
        TradeModeComponent r67 = this.tradeModeComponent;
        if (r67 == null) goto L77;
        int r68 = r67.hashCode();
    L78:
        int r69 = (r66 + r68) * 31;
        SafeguardComponent r70 = this.safeguardComponent;
        if (r70 == null) goto L81;
        int r71 = r70.hashCode();
    L82:
        int r72 = (r69 + r71) * 31;
        TopBannerComponent r73 = this.topBannerComponent;
        if (r73 == null) goto L85;
        int r74 = r73.hashCode();
    L86:
        int r75 = (r72 + r74) * 31;
        SkuTrustTags r76 = this.trustTags;
        if (r76 == null) goto L89;
        int r77 = r76.hashCode();
    L90:
        int r78 = (r75 + r77) * 31;
        String r79 = this.logExtra;
        if (r79 == null) goto L93;
        int r80 = r79.hashCode();
    L94:
        int r81 = (r78 + r80) * 31;
        String r82 = this.priceHeader;
        if (r82 == null) goto L97;
        int r83 = r82.hashCode();
    L98:
        int r84 = (r81 + r83) * 31;
        Integer r85 = this.priceHeaderStyle;
        if (r85 == null) goto L101;
        int r86 = r85.hashCode();
    L102:
        int r87 = (r84 + r86) * 31;
        String r88 = this.newBonusText;
        if (r88 == null) goto L105;
        int r89 = r88.hashCode();
    L106:
        int r90 = (r87 + r89) * 31;
        Long r91 = this.skuType;
        if (r91 == null) goto L109;
        int r92 = r91.hashCode();
    L110:
        int r93 = (((r90 + r92) * 31) + this.status) * 31;
        long r94 = this.depositPrice;
        int r95 = (r93 + ((int) (r94 ^ (r94 >>> 32)))) * 31;
        String r96 = this.limitText;
        if (r96 == null) goto L113;
        int r97 = r96.hashCode();
    L114:
        int r98 = (r95 + r97) * 31;
        long r99 = this.campaignStartTime;
        int r100 = (r98 + ((int) (r99 ^ (r99 >>> 32)))) * 31;
        long r101 = this.campaignEndTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.serverTime;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.marketPrice;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        ECUrlModel r107 = this.activityIcon;
        if (r107 == null) goto L117;
        int r108 = r107.hashCode();
    L118:
        int r109 = (r106 + r108) * 31;
        SkuPoiInfo r110 = this.poiInfo;
        if (r110 == null) goto L121;
        int r111 = r110.hashCode();
    L122:
        int r112 = (r109 + r111) * 31;
        String r113 = this.atmosphereHeader;
        if (r113 == null) goto L125;
        int r114 = r113.hashCode();
    L126:
        int r115 = (r112 + r114) * 31;
        ECUrlModel r116 = this.atmosphereBackground;
        if (r116 == null) goto L129;
        int r117 = r116.hashCode();
    L130:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.campaignSubType;
        if (r119 == null) goto L133;
        int r120 = r119.hashCode();
    L134:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.hasGivenProduct;
        if (r122 == null) goto L137;
        int r123 = r122.hashCode();
    L138:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.givenProductStock;
        if (r125 == null) goto L141;
        int r126 = r125.hashCode();
    L142:
        int r127 = (r124 + r126) * 31;
        SkuBannerStruct r128 = this.skuBanner;
        if (r128 == null) goto L145;
        int r129 = r128.hashCode();
    L146:
        int r130 = (r127 + r129) * 31;
        boolean r131 = this.showStock;
        ?? r132 = r131;
        if (r131 == false) goto L149;
        r132 = 1;
    L149:
        int r133 = (((((r130 + r132) * 31) + this.showPriceStyle) * 31) + this.discountPriceStyleType) * 31;
        LogPbData r134 = this.logPb;
        if (r134 == null) goto L152;
        int r135 = r134.hashCode();
    L153:
        int r136 = (r133 + r135) * 31;
        List<SkuBottomButtons> r137 = this.defaultButtons;
        if (r137 == null) goto L156;
        int r138 = r137.hashCode();
    L157:
        int r139 = (r136 + r138) * 31;
        DisplayConfig r140 = this.displayConfig;
        if (r140 == null) goto L160;
        int r141 = r140.hashCode();
    L161:
        int r142 = (r139 + r141) * 31;
        CarAdaptComponent r143 = this.carAdaptComponent;
        if (r143 == null) goto L164;
        int r144 = r143.hashCode();
    L165:
        int r145 = (r142 + r144) * 31;
        OrderComponent r146 = this.orderComponent;
        if (r146 == null) goto L168;
        int r147 = r146.hashCode();
    L169:
        int r148 = (r145 + r147) * 31;
        Long r149 = this.firstPrice;
        if (r149 == null) goto L172;
        int r150 = r149.hashCode();
    L173:
        int r151 = (r148 + r150) * 31;
        String r152 = this.firstPricePrefix;
        if (r152 == null) goto L176;
        int r153 = r152.hashCode();
    L177:
        int r154 = (r151 + r153) * 31;
        String r155 = this.firstPriceSuffix;
        if (r155 == null) goto L180;
        int r156 = r155.hashCode();
    L181:
        int r157 = (r154 + r156) * 31;
        Boolean r158 = this.firstPriceIsUnderline;
        if (r158 == null) goto L184;
        int r159 = r158.hashCode();
    L185:
        int r160 = (r157 + r159) * 31;
        String r161 = this.firstPriceSupplement;
        if (r161 == null) goto L188;
        int r162 = r161.hashCode();
    L189:
        int r163 = (r160 + r162) * 31;
        Long r164 = this.secondPrice;
        if (r164 == null) goto L192;
        int r165 = r164.hashCode();
    L193:
        int r166 = (r163 + r165) * 31;
        String r167 = this.secondPricePrefix;
        if (r167 == null) goto L196;
        int r168 = r167.hashCode();
    L197:
        int r169 = (r166 + r168) * 31;
        String r170 = this.secondPriceSuffix;
        if (r170 == null) goto L200;
        int r171 = r170.hashCode();
    L201:
        int r172 = (r169 + r171) * 31;
        Boolean r173 = this.secondPriceIsUnderline;
        if (r173 == null) goto L204;
        int r174 = r173.hashCode();
    L205:
        int r175 = (r172 + r174) * 31;
        Boolean r176 = this.secondPriceIsReducePrice;
        if (r176 == null) goto L208;
        int r177 = r176.hashCode();
    L209:
        int r178 = (r175 + r177) * 31;
        String r179 = this.secondPriceSupplement;
        if (r179 == null) goto L212;
        int r180 = r179.hashCode();
    L213:
        int r181 = (r178 + r180) * 31;
        Long r182 = this.priceType;
        if (r182 == null) goto L216;
        int r183 = r182.hashCode();
    L217:
        int r184 = (r181 + r183) * 31;
        Long r185 = this.regularPrice;
        if (r185 == null) goto L220;
        int r186 = r185.hashCode();
    L221:
        int r187 = (r184 + r186) * 31;
        String r188 = this.regularPricePrefix;
        if (r188 == null) goto L224;
        int r189 = r188.hashCode();
    L225:
        int r190 = (r187 + r189) * 31;
        String r191 = this.regularPriceSuffix;
        if (r191 == null) goto L228;
        int r192 = r191.hashCode();
    L229:
        int r193 = (r190 + r192) * 31;
        Boolean r194 = this.regularPriceIsUnderline;
        if (r194 == null) goto L232;
        int r195 = r194.hashCode();
    L233:
        int r196 = (r193 + r195) * 31;
        String r197 = this.regularPriceSupplement;
        if (r197 == null) goto L236;
        int r198 = r197.hashCode();
    L237:
        int r199 = (r196 + r198) * 31;
        Long r200 = this.hotMinPrice;
        if (r200 == null) goto L240;
        int r201 = r200.hashCode();
    L241:
        int r202 = (r199 + r201) * 31;
        Long r203 = this.hotMaxPrice;
        if (r203 == null) goto L244;
        int r204 = r203.hashCode();
    L245:
        int r205 = (r202 + r204) * 31;
        String r206 = this.hotPricePrefix;
        if (r206 == null) goto L248;
        int r207 = r206.hashCode();
    L249:
        int r208 = (r205 + r207) * 31;
        String r209 = this.hotPriceSupplement;
        if (r209 == null) goto L252;
        int r210 = r209.hashCode();
    L253:
        int r211 = (r208 + r210) * 31;
        Integer r212 = this.atmosphereStyle;
        if (r212 == null) goto L256;
        int r213 = r212.hashCode();
    L257:
        int r214 = (r211 + r213) * 31;
        String r215 = this.productExtra;
        if (r215 == null) goto L260;
        int r216 = r215.hashCode();
    L261:
        int r217 = (r214 + r216) * 31;
        ButtonTipComponent r218 = this.buttonTipComponent;
        if (r218 == null) goto L264;
        int r219 = r218.hashCode();
    L265:
        int r220 = (r217 + r219) * 31;
        Map<String, String> r221 = this.showTrackParams;
        if (r221 == null) goto L268;
        int r222 = r221.hashCode();
    L269:
        int r223 = (r220 + r222) * 31;
        SkuAddCartGuideInfo r224 = this.addCartGuideInfo;
        if (r224 == null) goto L272;
        int r225 = r224.hashCode();
    L273:
        int r226 = (r223 + r225) * 31;
        UpdateActionOption r227 = this.updateActionOption;
        if (r227 == null) goto L277;
        r1 = r227.hashCode();
    L277:
        return r226 + r1;
    L272:
        r225 = 0;
        goto L273
    L268:
        r222 = 0;
        goto L269
    L264:
        r219 = 0;
        goto L265
    L260:
        r216 = 0;
        goto L261
    L256:
        r213 = 0;
        goto L257
    L252:
        r210 = 0;
        goto L253
    L248:
        r207 = 0;
        goto L249
    L244:
        r204 = 0;
        goto L245
    L240:
        r201 = 0;
        goto L241
    L236:
        r198 = 0;
        goto L237
    L232:
        r195 = 0;
        goto L233
    L228:
        r192 = 0;
        goto L229
    L224:
        r189 = 0;
        goto L225
    L220:
        r186 = 0;
        goto L221
    L216:
        r183 = 0;
        goto L217
    L212:
        r180 = 0;
        goto L213
    L208:
        r177 = 0;
        goto L209
    L204:
        r174 = 0;
        goto L205
    L200:
        r171 = 0;
        goto L201
    L196:
        r168 = 0;
        goto L197
    L192:
        r165 = 0;
        goto L193
    L188:
        r162 = 0;
        goto L189
    L184:
        r159 = 0;
        goto L185
    L180:
        r156 = 0;
        goto L181
    L176:
        r153 = 0;
        goto L177
    L172:
        r150 = 0;
        goto L173
    L168:
        r147 = 0;
        goto L169
    L164:
        r144 = 0;
        goto L165
    L160:
        r141 = 0;
        goto L161
    L156:
        r138 = 0;
        goto L157
    L152:
        r135 = 0;
        goto L153
    L145:
        r129 = 0;
        goto L146
    L141:
        r126 = 0;
        goto L142
    L137:
        r123 = 0;
        goto L138
    L133:
        r120 = 0;
        goto L134
    L129:
        r117 = 0;
        goto L130
    L125:
        r114 = 0;
        goto L126
    L121:
        r111 = 0;
        goto L122
    L117:
        r108 = 0;
        goto L118
    L113:
        r97 = 0;
        goto L114
    L109:
        r92 = 0;
        goto L110
    L105:
        r89 = 0;
        goto L106
    L101:
        r86 = 0;
        goto L102
    L97:
        r83 = 0;
        goto L98
    L93:
        r80 = 0;
        goto L94
    L89:
        r77 = 0;
        goto L90
    L85:
        r74 = 0;
        goto L86
    L81:
        r71 = 0;
        goto L82
    L77:
        r68 = 0;
        goto L78
    L73:
        r65 = 0;
        goto L74
    L69:
        r62 = 0;
        goto L70
    L65:
        r59 = 0;
        goto L66
    L61:
        r56 = 0;
        goto L62
    L57:
        r53 = 0;
        goto L58
    L53:
        r50 = 0;
        goto L54
    L49:
        r47 = 0;
        goto L50
    L45:
        r44 = 0;
        goto L46
    L41:
        r41 = 0;
        goto L42
    L37:
        r38 = 0;
        goto L38
    L33:
        r31 = 0;
        goto L34
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "SkuInfoVO(skuList=" + this.skuList + ", specInfoList=" + this.specInfoList + ", clothesSizeAssistant=" + this.clothesSizeAssistant + ", cover=" + this.cover + ", bigCover=" + this.bigCover + ", pictureMap=" + this.pictureMap + ", bigPicMap=" + this.bigPicMap + ", smallPicMap=" + this.smallPicMap + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", buttonLabel=" + this.buttonLabel + ", upperLimit=" + this.upperLimit + ", lowerLimit=" + this.lowerLimit + ", unUseMinPrice=" + this.unUseMinPrice + ", discountPrice=" + this.discountPrice + ", discountPriceHeader=" + this.discountPriceHeader + ", presellType=" + this.presellType + ", deliveryDelayDesc=" + this.deliveryDelayDesc + ", presellDelayDesc=" + this.presellDelayDesc + ", installmentInfo=" + this.installmentInfo + ", tradeModeComponent=" + this.tradeModeComponent + ", safeguardComponent=" + this.safeguardComponent + ", topBannerComponent=" + this.topBannerComponent + ", trustTags=" + this.trustTags + ", logExtra=" + this.logExtra + ", priceHeader=" + this.priceHeader + ", priceHeaderStyle=" + this.priceHeaderStyle + ", newBonusText=" + this.newBonusText + ", skuType=" + this.skuType + ", status=" + this.status + ", depositPrice=" + this.depositPrice + ", limitText=" + this.limitText + ", campaignStartTime=" + this.campaignStartTime + ", campaignEndTime=" + this.campaignEndTime + ", serverTime=" + this.serverTime + ", marketPrice=" + this.marketPrice + ", activityIcon=" + this.activityIcon + ", poiInfo=" + this.poiInfo + ", atmosphereHeader=" + this.atmosphereHeader + ", atmosphereBackground=" + this.atmosphereBackground + ", campaignSubType=" + this.campaignSubType + ", hasGivenProduct=" + this.hasGivenProduct + ", givenProductStock=" + this.givenProductStock + ", skuBanner=" + this.skuBanner + ", showStock=" + this.showStock + ", showPriceStyle=" + this.showPriceStyle + ", discountPriceStyleType=" + this.discountPriceStyleType + ", logPb=" + this.logPb + ", defaultButtons=" + this.defaultButtons + ", displayConfig=" + this.displayConfig + ", carAdaptComponent=" + this.carAdaptComponent + ", orderComponent=" + this.orderComponent + ", firstPrice=" + this.firstPrice + ", firstPricePrefix=" + this.firstPricePrefix + ", firstPriceSuffix=" + this.firstPriceSuffix + ", firstPriceIsUnderline=" + this.firstPriceIsUnderline + ", firstPriceSupplement=" + this.firstPriceSupplement + ", secondPrice=" + this.secondPrice + ", secondPricePrefix=" + this.secondPricePrefix + ", secondPriceSuffix=" + this.secondPriceSuffix + ", secondPriceIsUnderline=" + this.secondPriceIsUnderline + ", secondPriceIsReducePrice=" + this.secondPriceIsReducePrice + ", secondPriceSupplement=" + this.secondPriceSupplement + ", priceType=" + this.priceType + ", regularPrice=" + this.regularPrice + ", regularPricePrefix=" + this.regularPricePrefix + ", regularPriceSuffix=" + this.regularPriceSuffix + ", regularPriceIsUnderline=" + this.regularPriceIsUnderline + ", regularPriceSupplement=" + this.regularPriceSupplement + ", hotMinPrice=" + this.hotMinPrice + ", hotMaxPrice=" + this.hotMaxPrice + ", hotPricePrefix=" + this.hotPricePrefix + ", hotPriceSupplement=" + this.hotPriceSupplement + ", atmosphereStyle=" + this.atmosphereStyle + ", productExtra=" + this.productExtra + ", buttonTipComponent=" + this.buttonTipComponent + ", showTrackParams=" + this.showTrackParams + ", addCartGuideInfo=" + this.addCartGuideInfo + ", updateActionOption=" + this.updateActionOption + ")";
    }

    public final boolean isGroupBuyDefault() {
        Long r0 = this.skuType;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.longValue() != 120) goto L8;
        return true;
    }

    public final boolean isInDepositPresaleDefault() {
        Long r0 = this.skuType;
        if (r0 != null) goto L6;
    L13:
        return false;
    L6:
        if (r0.longValue() != 10) goto L13;
        long r1 = this.campaignStartTime;
        long r10 = this.campaignEndTime;
        long r11 = SystemClock.elapsedRealtime();
        if (r1 > r11) goto L13;
        if (r10 < r11) goto L13;
        return true;
    }

    public final boolean isInPreSecKillDefault() {
        Long r0 = this.skuType;
        if (r0 != null) goto L6;
    L10:
        return false;
    L6:
        if (r0.longValue() != 7) goto L10;
        if (SystemClock.elapsedRealtime() >= this.campaignStartTime) goto L10;
        return true;
    }

    public final boolean isInSecKillDefault() {
        Long r0 = this.skuType;
        if (r0 != null) goto L6;
    L13:
        return false;
    L6:
        if (r0.longValue() != 7) goto L13;
        long r1 = this.campaignStartTime;
        long r10 = this.campaignEndTime;
        long r11 = SystemClock.elapsedRealtime();
        if (r1 > r11) goto L13;
        if (r10 < r11) goto L13;
        return true;
    }

    public final boolean isRangePrice() {
        if (this.maxPrice <= this.minPrice) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSoldOut() {
        Iterator<T> r0 = this.skuList.values().iterator();
        long r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L7;
        r10 = r10 + ((SkuItemInfoVO) r0.next()).getStockNum();
        goto L4
    L7:
        if (r10 > 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isUnderStock() {
        Collection<SkuItemInfoVO> r0 = this.skuList.values();
        boolean r10 = false;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L17;
        SkuItemInfoVO r11 = (SkuItemInfoVO) r1.next();
        if (r11.getStockNum() < r11.getLowerLimit()) goto L13;
        boolean r12 = true;
    L14:
        if (r12 == false) goto L9;
        r10 = true;
        goto L17
    L13:
        r12 = false;
    L17:
        return !r10;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final boolean isInActivityDefault() {
        if (isInSecKillDefault() == false) goto L5;
    L10:
        return true;
    L5:
        if (isInPreSecKillDefault() == true) goto L10;
        if (isGroupBuyDefault() == true) goto L10;
        return false;
    }

    public final ECUrlModel getActivityIcon() {
        return this.activityIcon;
    }

    public final SkuAddCartGuideInfo getAddCartGuideInfo() {
        return this.addCartGuideInfo;
    }

    public final ECUrlModel getAtmosphereBackground() {
        return this.atmosphereBackground;
    }

    public final String getAtmosphereHeader() {
        return this.atmosphereHeader;
    }

    public final Integer getAtmosphereStyle() {
        return this.atmosphereStyle;
    }

    public final String getBigCover() {
        return this.bigCover;
    }

    public final Map<String, String> getBigPicMap() {
        return this.bigPicMap;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final ButtonTipComponent getButtonTipComponent() {
        return this.buttonTipComponent;
    }

    public final long getCampaignEndTime() {
        return this.campaignEndTime;
    }

    public final long getCampaignStartTime() {
        return this.campaignStartTime;
    }

    public final Integer getCampaignSubType() {
        return this.campaignSubType;
    }

    public final CarAdaptComponent getCarAdaptComponent() {
        return this.carAdaptComponent;
    }

    public final ClothesSizeAssistantStruct getClothesSizeAssistant() {
        return this.clothesSizeAssistant;
    }

    public final String getCover() {
        return this.cover;
    }

    public final List<SkuBottomButtons> getDefaultButtons() {
        return this.defaultButtons;
    }

    public final String getDeliveryDelayDesc() {
        return this.deliveryDelayDesc;
    }

    public final long getDepositPrice() {
        return this.depositPrice;
    }

    public final Long getDiscountPrice() {
        return this.discountPrice;
    }

    public final String getDiscountPriceHeader() {
        return this.discountPriceHeader;
    }

    public final int getDiscountPriceStyleType() {
        return this.discountPriceStyleType;
    }

    public final DisplayConfig getDisplayConfig() {
        return this.displayConfig;
    }

    public final Long getFirstPrice() {
        return this.firstPrice;
    }

    public final Boolean getFirstPriceIsUnderline() {
        return this.firstPriceIsUnderline;
    }

    public final String getFirstPricePrefix() {
        return this.firstPricePrefix;
    }

    public final String getFirstPriceSuffix() {
        return this.firstPriceSuffix;
    }

    public final String getFirstPriceSupplement() {
        return this.firstPriceSupplement;
    }

    public final Integer getGivenProductStock() {
        return this.givenProductStock;
    }

    public final Boolean getHasGivenProduct() {
        return this.hasGivenProduct;
    }

    public final Long getHotMaxPrice() {
        return this.hotMaxPrice;
    }

    public final Long getHotMinPrice() {
        return this.hotMinPrice;
    }

    public final String getHotPricePrefix() {
        return this.hotPricePrefix;
    }

    public final String getHotPriceSupplement() {
        return this.hotPriceSupplement;
    }

    public final SkuInstallmentItemInfo getInstallmentInfo() {
        return this.installmentInfo;
    }

    public final String getLimitText() {
        return this.limitText;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final LogPbData getLogPb() {
        return this.logPb;
    }

    public final SkuLimit getLowerLimit() {
        return this.lowerLimit;
    }

    public final long getMarketPrice() {
        return this.marketPrice;
    }

    public final long getMaxPrice() {
        return this.maxPrice;
    }

    public final long getMinPrice() {
        return this.minPrice;
    }

    public final String getNewBonusText() {
        return this.newBonusText;
    }

    public final OrderComponent getOrderComponent() {
        return this.orderComponent;
    }

    public final Map<String, String> getPictureMap() {
        return this.pictureMap;
    }

    public final SkuPoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    public final String getPresellDelayDesc() {
        return this.presellDelayDesc;
    }

    public final Long getPresellType() {
        return this.presellType;
    }

    public final String getPriceHeader() {
        return this.priceHeader;
    }

    public final Integer getPriceHeaderStyle() {
        return this.priceHeaderStyle;
    }

    public final Long getPriceType() {
        return this.priceType;
    }

    public final String getProductExtra() {
        return this.productExtra;
    }

    public final Long getRegularPrice() {
        return this.regularPrice;
    }

    public final Boolean getRegularPriceIsUnderline() {
        return this.regularPriceIsUnderline;
    }

    public final String getRegularPricePrefix() {
        return this.regularPricePrefix;
    }

    public final String getRegularPriceSuffix() {
        return this.regularPriceSuffix;
    }

    public final String getRegularPriceSupplement() {
        return this.regularPriceSupplement;
    }

    public final SafeguardComponent getSafeguardComponent() {
        return this.safeguardComponent;
    }

    public final Long getSecondPrice() {
        return this.secondPrice;
    }

    public final Boolean getSecondPriceIsReducePrice() {
        return this.secondPriceIsReducePrice;
    }

    public final Boolean getSecondPriceIsUnderline() {
        return this.secondPriceIsUnderline;
    }

    public final String getSecondPricePrefix() {
        return this.secondPricePrefix;
    }

    public final String getSecondPriceSuffix() {
        return this.secondPriceSuffix;
    }

    public final String getSecondPriceSupplement() {
        return this.secondPriceSupplement;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final int getShowPriceStyle() {
        return this.showPriceStyle;
    }

    public final boolean getShowStock() {
        return this.showStock;
    }

    public final Map<String, String> getShowTrackParams() {
        return this.showTrackParams;
    }

    public final SkuBannerStruct getSkuBanner() {
        return this.skuBanner;
    }

    public final Map<String, SkuItemInfoVO> getSkuList() {
        return this.skuList;
    }

    public final Long getSkuType() {
        return this.skuType;
    }

    public final Map<String, String> getSmallPicMap() {
        return this.smallPicMap;
    }

    public final List<SpecInfo> getSpecInfoList() {
        return this.specInfoList;
    }

    public final int getStatus() {
        return this.status;
    }

    public final TopBannerComponent getTopBannerComponent() {
        return this.topBannerComponent;
    }

    public final TradeModeComponent getTradeModeComponent() {
        return this.tradeModeComponent;
    }

    public final SkuTrustTags getTrustTags() {
        return this.trustTags;
    }

    public final Long getUnUseMinPrice() {
        return this.unUseMinPrice;
    }

    public final UpdateActionOption getUpdateActionOption() {
        return this.updateActionOption;
    }

    public final SkuLimit getUpperLimit() {
        return this.upperLimit;
    }

    public final void setAtmosphereStyle(Integer r1) {
        this.atmosphereStyle = r1;
    }

    public final void setCampaignEndTime(long r1) {
        this.campaignEndTime = r1;
    }

    public final void setCampaignStartTime(long r1) {
        this.campaignStartTime = r1;
    }

    public final void setFirstPrice(Long r1) {
        this.firstPrice = r1;
    }

    public final void setFirstPriceIsUnderline(Boolean r1) {
        this.firstPriceIsUnderline = r1;
    }

    public final void setFirstPricePrefix(String r1) {
        this.firstPricePrefix = r1;
    }

    public final void setFirstPriceSuffix(String r1) {
        this.firstPriceSuffix = r1;
    }

    public final void setFirstPriceSupplement(String r1) {
        this.firstPriceSupplement = r1;
    }

    public final void setHotMaxPrice(Long r1) {
        this.hotMaxPrice = r1;
    }

    public final void setHotMinPrice(Long r1) {
        this.hotMinPrice = r1;
    }

    public final void setHotPricePrefix(String r1) {
        this.hotPricePrefix = r1;
    }

    public final void setHotPriceSupplement(String r1) {
        this.hotPriceSupplement = r1;
    }

    public final void setNewBonusText(String r1) {
        this.newBonusText = r1;
    }

    public final void setPriceHeaderStyle(Integer r1) {
        this.priceHeaderStyle = r1;
    }

    public final void setPriceType(Long r1) {
        this.priceType = r1;
    }

    public final void setRegularPrice(Long r1) {
        this.regularPrice = r1;
    }

    public final void setRegularPriceIsUnderline(Boolean r1) {
        this.regularPriceIsUnderline = r1;
    }

    public final void setRegularPricePrefix(String r1) {
        this.regularPricePrefix = r1;
    }

    public final void setRegularPriceSuffix(String r1) {
        this.regularPriceSuffix = r1;
    }

    public final void setRegularPriceSupplement(String r1) {
        this.regularPriceSupplement = r1;
    }

    public final void setSecondPrice(Long r1) {
        this.secondPrice = r1;
    }

    public final void setSecondPriceIsUnderline(Boolean r1) {
        this.secondPriceIsUnderline = r1;
    }

    public final void setSecondPricePrefix(String r1) {
        this.secondPricePrefix = r1;
    }

    public final void setSecondPriceSuffix(String r1) {
        this.secondPriceSuffix = r1;
    }

    public final void setSecondPriceSupplement(String r1) {
        this.secondPriceSupplement = r1;
    }

    public final void setSkuType(Long r1) {
        this.skuType = r1;
    }

    public SkuInfoVO(Map<String, SkuItemInfoVO> r10, List<SpecInfo> r11, ClothesSizeAssistantStruct r12, String r13, String r14, Map<String, String> r15, Map<String, String> r16, Map<String, String> r17, long r18, long r19, String r110, SkuLimit r20, SkuLimit r21, Long r22, Long r23, String r24, Long r25, String r26, String r27, SkuInstallmentItemInfo r28, TradeModeComponent r29, SafeguardComponent r30, TopBannerComponent r31, SkuTrustTags r32, String r33, String r34, Integer r35, String r36, Long r37, int r38, long r39, String r41, long r42, long r44, long r46, long r48, ECUrlModel r50, SkuPoiInfo r51, String r52, ECUrlModel r53, Integer r54, Boolean r55, Integer r56, SkuBannerStruct r57, boolean r58, int r59, int r60, LogPbData r61, List<SkuBottomButtons> r62, DisplayConfig r63, CarAdaptComponent r64, OrderComponent r65, Long r66, String r67, String r68, Boolean r69, String r70, Long r71, String r72, String r73, Boolean r74, Boolean r75, String r76, Long r77, Long r78, String r79, String r80, Boolean r81, String r82, Long r83, Long r84, String r85, String r86, Integer r87, String r88, ButtonTipComponent r89, Map<String, String> r90, SkuAddCartGuideInfo r91, UpdateActionOption r92) {
        Intrinsics.checkNotNullParameter(r10, "skuList");
        Intrinsics.checkNotNullParameter(r11, "specInfoList");
        Intrinsics.checkNotNullParameter(r20, "upperLimit");
        Intrinsics.checkNotNullParameter(r21, "lowerLimit");
        this.skuList = r10;
        this.specInfoList = r11;
        this.clothesSizeAssistant = r12;
        this.cover = r13;
        this.bigCover = r14;
        this.pictureMap = r15;
        this.bigPicMap = r16;
        this.smallPicMap = r17;
        this.minPrice = r18;
        this.maxPrice = r19;
        this.buttonLabel = r110;
        this.upperLimit = r20;
        this.lowerLimit = r21;
        this.unUseMinPrice = r22;
        this.discountPrice = r23;
        this.discountPriceHeader = r24;
        this.presellType = r25;
        this.deliveryDelayDesc = r26;
        this.presellDelayDesc = r27;
        this.installmentInfo = r28;
        this.tradeModeComponent = r29;
        this.safeguardComponent = r30;
        this.topBannerComponent = r31;
        this.trustTags = r32;
        this.logExtra = r33;
        this.priceHeader = r34;
        this.priceHeaderStyle = r35;
        this.newBonusText = r36;
        this.skuType = r37;
        this.status = r38;
        this.depositPrice = r39;
        this.limitText = r41;
        this.campaignStartTime = r42;
        this.campaignEndTime = r44;
        this.serverTime = r46;
        this.marketPrice = r48;
        this.activityIcon = r50;
        this.poiInfo = r51;
        this.atmosphereHeader = r52;
        this.atmosphereBackground = r53;
        this.campaignSubType = r54;
        this.hasGivenProduct = r55;
        this.givenProductStock = r56;
        this.skuBanner = r57;
        this.showStock = r58;
        this.showPriceStyle = r59;
        this.discountPriceStyleType = r60;
        this.logPb = r61;
        this.defaultButtons = r62;
        this.displayConfig = r63;
        this.carAdaptComponent = r64;
        this.orderComponent = r65;
        this.firstPrice = r66;
        this.firstPricePrefix = r67;
        this.firstPriceSuffix = r68;
        this.firstPriceIsUnderline = r69;
        this.firstPriceSupplement = r70;
        this.secondPrice = r71;
        this.secondPricePrefix = r72;
        this.secondPriceSuffix = r73;
        this.secondPriceIsUnderline = r74;
        this.secondPriceIsReducePrice = r75;
        this.secondPriceSupplement = r76;
        this.priceType = r77;
        this.regularPrice = r78;
        this.regularPricePrefix = r79;
        this.regularPriceSuffix = r80;
        this.regularPriceIsUnderline = r81;
        this.regularPriceSupplement = r82;
        this.hotMinPrice = r83;
        this.hotMaxPrice = r84;
        this.hotPricePrefix = r85;
        this.hotPriceSupplement = r86;
        this.atmosphereStyle = r87;
        this.productExtra = r88;
        this.buttonTipComponent = r89;
        this.showTrackParams = r90;
        this.addCartGuideInfo = r91;
        this.updateActionOption = r92;
    }

    public /* synthetic */ SkuInfoVO(Map r84, List r85, ClothesSizeAssistantStruct r86, String r87, String r88, Map r89, Map r90, Map r91, long r92, long r94, String r96, SkuLimit r97, SkuLimit r98, Long r99, Long r100, String r101, Long r102, String r103, String r104, SkuInstallmentItemInfo r105, TradeModeComponent r106, SafeguardComponent r107, TopBannerComponent r108, SkuTrustTags r109, String r110, String r111, Integer r112, String r113, Long r114, int r115, long r116, String r118, long r119, long r121, long r123, long r125, ECUrlModel r127, SkuPoiInfo r128, String r129, ECUrlModel r130, Integer r131, Boolean r132, Integer r133, SkuBannerStruct r134, boolean r135, int r136, int r137, LogPbData r138, List r139, DisplayConfig r140, CarAdaptComponent r141, OrderComponent r142, Long r143, String r144, String r145, Boolean r146, String r147, Long r148, String r149, String r150, Boolean r151, Boolean r152, String r153, Long r154, Long r155, String r156, String r157, Boolean r158, String r159, Long r160, Long r161, String r162, String r163, Integer r164, String r165, ButtonTipComponent r166, Map r167, SkuAddCartGuideInfo r168, UpdateActionOption r169, int r170, int r171, int r172, DefaultConstructorMarker r173) {
        if ((r170 & 1) == 0) goto L5;
        Map r10 = new HashMap();
    L7:
        if ((r170 & 2) == 0) goto L9;
        List r11 = CollectionsKt.emptyList();
    L11:
        if ((r170 & 4) == 0) goto L13;
        ClothesSizeAssistantStruct r12 = null;
    L15:
        if ((r170 & 8) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r170 & 16) == 0) goto L21;
        String r14 = null;
    L23:
        if ((r170 & 32) == 0) goto L25;
        Map r15 = null;
    L27:
        if ((r170 & 64) == 0) goto L29;
        Map r16 = null;
    L31:
        if ((r170 & 128) == 0) goto L33;
        Map r17 = null;
    L35:
        if ((r170 & 256) == 0) goto L37;
        long r18 = 0;
    L39:
        if ((r170 & 512) == 0) goto L41;
        long r19 = 0;
    L43:
        if ((r170 & 1024) == 0) goto L45;
        String r117 = null;
    L47:
        if ((r170 & 2048) == 0) goto L49;
        SkuLimit r120 = new SkuLimit(Long.MAX_VALUE, null);
    L51:
        if ((r170 & 4096) == 0) goto L53;
        SkuLimit r122 = new SkuLimit(1, null);
    L55:
        if ((r170 & 8192) == 0) goto L57;
        Long r124 = null;
    L59:
        if ((r170 & 16384) == 0) goto L61;
        Long r126 = null;
    L63:
        if ((r170 & 32768) == 0) goto L65;
        String r21 = null;
    L67:
        if ((r170 & 65536) == 0) goto L69;
        Long r23 = null;
    L71:
        if ((r170 & 131072) == 0) goto L73;
        String r25 = null;
    L75:
        if ((r170 & 262144) == 0) goto L77;
        String r27 = null;
    L79:
        if ((r170 & 524288) == 0) goto L81;
        SkuInstallmentItemInfo r28 = null;
    L83:
        if ((r170 & 1048576) == 0) goto L85;
        TradeModeComponent r29 = null;
    L87:
        if ((r170 & 2097152) == 0) goto L89;
        SafeguardComponent r30 = null;
    L91:
        if ((r170 & 4194304) == 0) goto L93;
        TopBannerComponent r31 = null;
    L95:
        if ((r170 & 8388608) == 0) goto L97;
        SkuTrustTags r32 = null;
    L99:
        if ((r170 & 16777216) == 0) goto L101;
        String r33 = null;
    L103:
        if ((r170 & 33554432) == 0) goto L105;
        String r34 = null;
    L106:
        int r36 = 0;
        if ((r170 & 67108864) == 0) goto L109;
        Integer r35 = 0;
    L111:
        if ((r170 & 134217728) == 0) goto L113;
        String r37 = null;
    L115:
        if ((r170 & 268435456) == 0) goto L117;
        Long r38 = null;
    L119:
        if ((r170 & 536870912) == 0) goto L121;
        int r39 = 2;
    L123:
        if ((r170 & 1073741824) == 0) goto L125;
        long r40 = 0;
    L127:
        if ((r170 & Integer.MIN_VALUE) == 0) goto L129;
        String r0 = null;
    L131:
        if ((r171 & 1) == 0) goto L133;
        long r42 = 0;
    L135:
        if ((r171 & 2) == 0) goto L137;
        long r44 = 0;
    L139:
        if ((r171 & 4) == 0) goto L141;
        long r46 = 0;
    L143:
        if ((r171 & 8) == 0) goto L145;
        long r48 = 0;
    L147:
        if ((r171 & 16) == 0) goto L149;
        ECUrlModel r50 = null;
    L151:
        if ((r171 & 32) == 0) goto L153;
        SkuPoiInfo r51 = null;
    L155:
        if ((r171 & 64) == 0) goto L157;
        String r52 = null;
    L159:
        if ((r171 & 128) == 0) goto L161;
        ECUrlModel r20 = null;
    L162:
        ECUrlModel r174 = r20;
        if ((r171 & 256) == 0) goto L165;
        Integer r22 = null;
    L166:
        Integer r53 = r22;
        if ((r171 & 512) == 0) goto L169;
        Boolean r24 = null;
    L170:
        Boolean r54 = r24;
        if ((r171 & 1024) == 0) goto L173;
        Integer r26 = null;
    L174:
        Integer r55 = r26;
        if ((r171 & 2048) == 0) goto L177;
        SkuBannerStruct r41 = null;
    L178:
        SkuBannerStruct r56 = r41;
        if ((r171 & 4096) == 0) goto L181;
        boolean r43 = true;
    L182:
        boolean r57 = r43;
        if ((r171 & 8192) == 0) goto L185;
        int r45 = 0;
    L186:
        int r58 = r45;
        if ((r171 & 16384) != 0) goto L191;
        r36 = r137;
    L191:
        if ((r171 & 32768) == 0) goto L193;
        LogPbData r47 = null;
    L195:
        if ((r171 & 65536) == 0) goto L197;
        List r175 = null;
    L199:
        if ((r171 & 131072) == 0) goto L201;
        DisplayConfig r210 = null;
    L203:
        if ((r171 & 262144) == 0) goto L205;
        CarAdaptComponent r211 = null;
    L207:
        if ((r171 & 524288) == 0) goto L209;
        OrderComponent r212 = null;
    L211:
        if ((r171 & 1048576) == 0) goto L213;
        Long r59 = null;
    L215:
        if ((r171 & 2097152) == 0) goto L217;
        String r60 = null;
    L219:
        if ((r171 & 4194304) == 0) goto L221;
        String r61 = null;
    L223:
        if ((r171 & 8388608) == 0) goto L225;
        Boolean r62 = null;
    L227:
        if ((r171 & 16777216) == 0) goto L229;
        String r63 = null;
    L231:
        if ((r171 & 33554432) == 0) goto L233;
        Long r64 = null;
    L235:
        if ((r171 & 67108864) == 0) goto L237;
        String r65 = null;
    L239:
        if ((r171 & 134217728) == 0) goto L241;
        String r66 = null;
    L243:
        if ((r171 & 268435456) == 0) goto L245;
        Boolean r67 = null;
    L247:
        if ((r171 & 536870912) == 0) goto L249;
        Boolean r68 = null;
    L251:
        if ((r171 & 1073741824) == 0) goto L253;
        String r69 = null;
    L255:
        if ((r171 & Integer.MIN_VALUE) == 0) goto L257;
        Long r1 = null;
    L259:
        if ((r172 & 1) == 0) goto L261;
        Long r70 = null;
    L263:
        if ((r172 & 2) == 0) goto L265;
        String r71 = null;
    L267:
        if ((r172 & 4) == 0) goto L269;
        String r72 = null;
    L271:
        if ((r172 & 8) == 0) goto L273;
        Boolean r73 = null;
    L275:
        if ((r172 & 16) == 0) goto L277;
        String r74 = null;
    L279:
        if ((r172 & 32) == 0) goto L281;
        Long r75 = null;
    L283:
        if ((r172 & 64) == 0) goto L285;
        Long r76 = null;
    L286:
        Long r176 = r1;
        if ((r172 & 128) == 0) goto L289;
        String r49 = null;
    L290:
        String r77 = r49;
        if ((r172 & 256) == 0) goto L293;
        String r78 = null;
    L294:
        String r79 = r78;
        if ((r172 & 512) == 0) goto L297;
        Integer r80 = null;
    L298:
        Integer r710 = r80;
        if ((r172 & 1024) == 0) goto L301;
        String r81 = null;
    L302:
        String r82 = r81;
        if ((r172 & 2048) == 0) goto L305;
        ButtonTipComponent r83 = null;
    L306:
        ButtonTipComponent r810 = r83;
        if ((r172 & 4096) == 0) goto L309;
        Map r93 = null;
    L310:
        Map r811 = r93;
        if ((r172 & 8192) == 0) goto L313;
        SkuAddCartGuideInfo r95 = null;
    L315:
        if ((r172 & 16384) == 0) goto L317;
        UpdateActionOption r177 = null;
    L318:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r117, r120, r122, r124, r126, r21, r23, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r37, r38, r39, r40, r0, r42, r44, r46, r48, r50, r51, r52, r174, r53, r54, r55, r56, r57, r58, r36, r47, r175, r210, r211, r212, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r176, r70, r71, r72, r73, r74, r75, r76, r77, r79, r710, r82, r810, r811, r95, r177);
        return;
    L317:
        r177 = r169;
        goto L318
    L313:
        r95 = r168;
        goto L315
    L309:
        r93 = r167;
        goto L310
    L305:
        r83 = r166;
        goto L306
    L301:
        r81 = r165;
        goto L302
    L297:
        r80 = r164;
        goto L298
    L293:
        r78 = r163;
        goto L294
    L289:
        r49 = r162;
        goto L290
    L285:
        r76 = r161;
        goto L286
    L281:
        r75 = r160;
        goto L283
    L277:
        r74 = r159;
        goto L279
    L273:
        r73 = r158;
        goto L275
    L269:
        r72 = r157;
        goto L271
    L265:
        r71 = r156;
        goto L267
    L261:
        r70 = r155;
        goto L263
    L257:
        r1 = r154;
        goto L259
    L253:
        r69 = r153;
        goto L255
    L249:
        r68 = r152;
        goto L251
    L245:
        r67 = r151;
        goto L247
    L241:
        r66 = r150;
        goto L243
    L237:
        r65 = r149;
        goto L239
    L233:
        r64 = r148;
        goto L235
    L229:
        r63 = r147;
        goto L231
    L225:
        r62 = r146;
        goto L227
    L221:
        r61 = r145;
        goto L223
    L217:
        r60 = r144;
        goto L219
    L213:
        r59 = r143;
        goto L215
    L209:
        r212 = r142;
        goto L211
    L205:
        r211 = r141;
        goto L207
    L201:
        r210 = r140;
        goto L203
    L197:
        r175 = r139;
        goto L199
    L193:
        r47 = r138;
        goto L195
    L185:
        r45 = r136;
        goto L186
    L181:
        r43 = r135;
        goto L182
    L177:
        r41 = r134;
        goto L178
    L173:
        r26 = r133;
        goto L174
    L169:
        r24 = r132;
        goto L170
    L165:
        r22 = r131;
        goto L166
    L161:
        r20 = r130;
        goto L162
    L157:
        r52 = r129;
        goto L159
    L153:
        r51 = r128;
        goto L155
    L149:
        r50 = r127;
        goto L151
    L145:
        r48 = r125;
        goto L147
    L141:
        r46 = r123;
        goto L143
    L137:
        r44 = r121;
        goto L139
    L133:
        r42 = r119;
        goto L135
    L129:
        r0 = r118;
        goto L131
    L125:
        r40 = r116;
        goto L127
    L121:
        r39 = r115;
        goto L123
    L117:
        r38 = r114;
        goto L119
    L113:
        r37 = r113;
        goto L115
    L109:
        r35 = r112;
        goto L111
    L105:
        r34 = r111;
        goto L106
    L101:
        r33 = r110;
        goto L103
    L97:
        r32 = r109;
        goto L99
    L93:
        r31 = r108;
        goto L95
    L89:
        r30 = r107;
        goto L91
    L85:
        r29 = r106;
        goto L87
    L81:
        r28 = r105;
        goto L83
    L77:
        r27 = r104;
        goto L79
    L73:
        r25 = r103;
        goto L75
    L69:
        r23 = r102;
        goto L71
    L65:
        r21 = r101;
        goto L67
    L61:
        r126 = r100;
        goto L63
    L57:
        r124 = r99;
        goto L59
    L53:
        r122 = r98;
        goto L55
    L49:
        r120 = r97;
        goto L51
    L45:
        r117 = r96;
        goto L47
    L41:
        r19 = r94;
        goto L43
    L37:
        r18 = r92;
        goto L39
    L33:
        r17 = r91;
        goto L35
    L29:
        r16 = r90;
        goto L31
    L25:
        r15 = r89;
        goto L27
    L21:
        r14 = r88;
        goto L23
    L17:
        r13 = r87;
        goto L19
    L13:
        r12 = r86;
        goto L15
    L9:
        r11 = r85;
        goto L11
    L5:
        r10 = r84;
        goto L7
    }
}
