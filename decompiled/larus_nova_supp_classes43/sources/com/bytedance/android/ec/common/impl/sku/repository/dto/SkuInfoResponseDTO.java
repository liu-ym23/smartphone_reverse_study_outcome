package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.bytedance.android.ec.common.impl.sku.model.ClothesSizeAssistantStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuBannerStruct;
import com.bytedance.android.ec.common.impl.sku.model.SkuInstallmentItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfo;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.android.ec.model.sku.PriceComponent;
import com.bytedance.android.ec.model.sku.SafeguardComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuTrustTags;
import com.bytedance.android.ec.model.sku.TopBannerComponent;
import com.bytedance.android.ec.model.sku.TradeModeComponent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b£\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B»\u0006\u0012\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010%\u001a\u00020\"\u0012\b\b\u0002\u0010&\u001a\u00020\u0010\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000108\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010<\u001a\u00020\"\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010?\u001a\u000208\u0012\b\b\u0002\u0010@\u001a\u00020\"\u0012\b\b\u0002\u0010A\u001a\u00020\"\u0012\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\b\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R\u0012\u0010\b\u0002\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\b\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V\u0012\u0016\b\u0002\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010Y\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010[¢\u0006\u0002\u0010\\J\u0018\u0010¼\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010¾\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010¿\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Â\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Å\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010Ç\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\f\u0010È\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010É\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Ì\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010Í\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Î\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\n\u0010Ï\u0001\u001a\u00020\"HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0010HÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Ô\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Ö\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\f\u0010×\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\f\u0010Ø\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\u0011\u0010Ú\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010sJ\u0011\u0010Û\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010Þ\u0001\u001a\u0004\u0018\u00010-HÆ\u0003J\u0011\u0010ß\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010sJ\u0012\u0010à\u0001\u001a\u0004\u0018\u000108HÆ\u0003¢\u0006\u0003\u0010\u0088\u0001J\u0011\u0010á\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010â\u0001\u001a\u0004\u0018\u00010;HÆ\u0003J\n\u0010ã\u0001\u001a\u00020\"HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010>HÆ\u0003J\n\u0010å\u0001\u001a\u000208HÆ\u0003J\n\u0010æ\u0001\u001a\u00020\"HÆ\u0003J\n\u0010ç\u0001\u001a\u00020\"HÆ\u0003J\u0018\u0010è\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0012\u0010é\u0001\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\bHÆ\u0003J\f\u0010ê\u0001\u001a\u0004\u0018\u00010EHÆ\u0003J\f\u0010ë\u0001\u001a\u0004\u0018\u00010GHÆ\u0003J\f\u0010ì\u0001\u001a\u0004\u0018\u00010IHÆ\u0003J\f\u0010í\u0001\u001a\u0004\u0018\u00010KHÆ\u0003J\f\u0010î\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010ï\u0001\u001a\u0004\u0018\u00010NHÆ\u0003J\f\u0010ð\u0001\u001a\u0004\u0018\u00010PHÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010RHÆ\u0003J\u0012\u0010ò\u0001\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\bHÆ\u0003J\u0018\u0010ó\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\f\u0010ô\u0001\u001a\u0004\u0018\u00010VHÆ\u0003J\u0018\u0010õ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\f\u0010ö\u0001\u001a\u0004\u0018\u00010YHÆ\u0003J\f\u0010÷\u0001\u001a\u0004\u0018\u00010[HÆ\u0003J\u0018\u0010ø\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u0011\u0010ù\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010ú\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010oJÆ\u0006\u0010û\u0001\u001a\u00020\u00002\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\u00102\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\"2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\"2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u00010-2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\"2\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\n\b\u0002\u00109\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0002\u0010<\u001a\u00020\"2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010?\u001a\u0002082\b\b\u0002\u0010@\u001a\u00020\"2\b\b\u0002\u0010A\u001a\u00020\"2\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\b2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010R2\u0010\b\u0002\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\b2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010V2\u0016\b\u0002\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010X\u001a\u0004\u0018\u00010Y2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010[HÆ\u0001¢\u0006\u0003\u0010ü\u0001J\u0016\u0010ý\u0001\u001a\u0002082\n\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u0001HÖ\u0003J\n\u0010\u0080\u0002\u001a\u00020\"HÖ\u0001J\n\u0010\u0081\u0002\u001a\u00020\u0005HÖ\u0001R\u0018\u0010,\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0018\u0010X\u001a\u0004\u0018\u00010Y8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0018\u00105\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010^R\u0018\u00104\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0018\u0010:\u001a\u0004\u0018\u00010;8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0016\u0010<\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010cR$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010cR\u0018\u0010U\u001a\u0004\u0018\u00010V8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u001a\u0010)\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010p\u001a\u0004\bn\u0010oR\u001a\u0010(\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010p\u001a\u0004\bq\u0010oR\u001a\u00106\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010t\u001a\u0004\br\u0010sR\u0018\u0010F\u001a\u0004\u0018\u00010G8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0018\u0010=\u001a\u0004\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010p\u001a\u0004\by\u0010oR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010cR\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u001a\u00103\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010t\u001a\u0004\b}\u0010sR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010cR\u0017\u0010&\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u0081\u0001\u0010oR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010cR\u0017\u0010A\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010gR\u001a\u0010D\u001a\u0004\u0018\u00010E8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u00109\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u0086\u0001\u0010sR\u001d\u00107\u001a\u0004\u0018\u0001088\u0006X\u0087\u0004¢\u0006\r\n\u0003\u0010\u0089\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0019\u0010'\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010cR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010cR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010cR\u001a\u00100\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001b\u0010+\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u0091\u0001\u0010oR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u0092\u0001\u0010oR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010cR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u0094\u0001\u0010oR#\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0095\u0001\u0010c\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001a\u0010H\u001a\u0004\u0018\u00010I8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R%\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010jR\u001a\u0010.\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001b\u00102\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010t\u001a\u0005\b\u009d\u0001\u0010sR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010cR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u009f\u0001\u0010oR\u001a\u0010J\u001a\u0004\u0018\u00010K8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001R\u0019\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010cR%\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0013\n\u0002\u0010t\u001a\u0005\b£\u0001\u0010s\"\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010L\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010cR\u001f\u0010S\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b§\u0001\u0010|R\u001b\u0010*\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b¨\u0001\u0010oR\u0017\u0010@\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010gR\u0018\u0010?\u001a\u0002088\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001R%\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¬\u0001\u0010jR\u001b\u0010$\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u00ad\u0001\u0010oR%\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b®\u0001\u0010jR%\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¯\u0001\u0010jR\u001f\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b°\u0001\u0010|R\u0017\u0010%\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b±\u0001\u0010gR\u001a\u0010O\u001a\u0004\u0018\u00010P8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001R\u001a\u0010M\u001a\u0004\u0018\u00010N8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010Q\u001a\u0004\u0018\u00010R8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b¸\u0001\u0010oR\u001a\u0010Z\u001a\u0004\u0018\u00010[8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b»\u0001\u0010o¨\u0006\u0082\u0002"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuInfoResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "skus", "", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfo;", "specList", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfo;", "cover", "bigCover", "pictureMap", "bigPic", "smallPic", "minPrice", "", "maxPrice", "buttonLabel", "comboLimit", "userMinLimit", "limitToast", "minLimitToast", "unUseMinPrice", "discountPrice", "discountPriceHeader", "presellType", "deliveryDelayDesc", "presellDelayDesc", "installmentInfo", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;", "logExtra", "priceHeader", "priceHeaderStyle", "", "newBonusText", "skuType", a.KEY_STATUS, "depositPrice", "limitText", "campaignStartTime", "campaignEndTime", "serverTime", "marketPrice", "activityIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "poiInfo", "Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "logPb", "Lcom/bytedance/android/ec/model/api/LogPbData;", "presellDelayDay", "deliveryDelayDay", "atmosphereHeader", "atmosphereBackground", "campaignSubType", "hasGivenProduct", "", "givenProductStock", "banner", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;", "benefitLabelTextStyle", "clothesSizeAssistant", "Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "showStock", "showPriceStyle", "discountPriceStyleType", "defaultButtons", "Lcom/bytedance/android/ec/model/sku/SkuBottomButtons;", "displayConfig", "Lcom/bytedance/android/ec/model/sku/DisplayConfig;", "carAdaptComponent", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "orderComponent", "Lcom/bytedance/android/ec/model/sku/OrderComponent;", "priceComponent", "Lcom/bytedance/android/ec/model/sku/PriceComponent;", "productExtra", "tradeModeComponent", "Lcom/bytedance/android/ec/model/sku/TradeModeComponent;", "topBannerComponent", "Lcom/bytedance/android/ec/model/sku/TopBannerComponent;", "trustTags", "Lcom/bytedance/android/ec/model/sku/SkuTrustTags;", "safeguardComponents", "Lcom/bytedance/android/ec/model/sku/SafeguardComponent;", "buttonTipComponent", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "showTrackParams", "addCartGuideInfo", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;", "updateActionOption", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;IJLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;Lcom/bytedance/android/ec/model/api/LogPbData;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;ILcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;ZIILjava/util/List;Lcom/bytedance/android/ec/model/sku/DisplayConfig;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/OrderComponent;Lcom/bytedance/android/ec/model/sku/PriceComponent;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/TradeModeComponent;Lcom/bytedance/android/ec/model/sku/TopBannerComponent;Lcom/bytedance/android/ec/model/sku/SkuTrustTags;Ljava/util/List;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/util/Map;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;)V", "getActivityIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getAddCartGuideInfo", "()Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;", "getAtmosphereBackground", "getAtmosphereHeader", "()Ljava/lang/String;", "getBanner", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;", "getBenefitLabelTextStyle", "()I", "getBigCover", "getBigPic", "()Ljava/util/Map;", "getButtonLabel", "getButtonTipComponent", "()Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "getCampaignEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCampaignStartTime", "getCampaignSubType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCarAdaptComponent", "()Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getClothesSizeAssistant", "()Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "getComboLimit", "getCover", "getDefaultButtons", "()Ljava/util/List;", "getDeliveryDelayDay", "getDeliveryDelayDesc", "getDepositPrice", "()J", "getDiscountPrice", "getDiscountPriceHeader", "getDiscountPriceStyleType", "getDisplayConfig", "()Lcom/bytedance/android/ec/model/sku/DisplayConfig;", "getGivenProductStock", "getHasGivenProduct", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getInstallmentInfo", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;", "getLimitText", "getLimitToast", "getLogExtra", "getLogPb", "()Lcom/bytedance/android/ec/model/api/LogPbData;", "getMarketPrice", "getMaxPrice", "getMinLimitToast", "getMinPrice", "getNewBonusText", "setNewBonusText", "(Ljava/lang/String;)V", "getOrderComponent", "()Lcom/bytedance/android/ec/model/sku/OrderComponent;", "getPictureMap", "getPoiInfo", "()Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "getPresellDelayDay", "getPresellDelayDesc", "getPresellType", "getPriceComponent", "()Lcom/bytedance/android/ec/model/sku/PriceComponent;", "getPriceHeader", "getPriceHeaderStyle", "setPriceHeaderStyle", "(Ljava/lang/Integer;)V", "getProductExtra", "getSafeguardComponents", "getServerTime", "getShowPriceStyle", "getShowStock", "()Z", "getShowTrackParams", "getSkuType", "getSkus", "getSmallPic", "getSpecList", "getStatus", "getTopBannerComponent", "()Lcom/bytedance/android/ec/model/sku/TopBannerComponent;", "getTradeModeComponent", "()Lcom/bytedance/android/ec/model/sku/TradeModeComponent;", "getTrustTags", "()Lcom/bytedance/android/ec/model/sku/SkuTrustTags;", "getUnUseMinPrice", "getUpdateActionOption", "()Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;", "getUserMinLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component7", "component8", "component9", "copy", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;IJLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;Lcom/bytedance/android/ec/model/api/LogPbData;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;ILcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;ZIILjava/util/List;Lcom/bytedance/android/ec/model/sku/DisplayConfig;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/OrderComponent;Lcom/bytedance/android/ec/model/sku/PriceComponent;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/TradeModeComponent;Lcom/bytedance/android/ec/model/sku/TopBannerComponent;Lcom/bytedance/android/ec/model/sku/SkuTrustTags;Ljava/util/List;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/util/Map;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;)Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuInfoResponseDTO;", "equals", "other", "", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuInfoResponseDTO extends CommerceBaseResponse {

    @SerializedName("activity_icon")
    private final ECUrlModel activityIcon;

    @SerializedName("sku_add_cart_guide_info")
    private final SkuAddCartGuideInfo addCartGuideInfo;

    @SerializedName("atmosphere_background")
    private final ECUrlModel atmosphereBackground;

    @SerializedName("atmosphere_header")
    private final String atmosphereHeader;

    @SerializedName("banner")
    private final SkuBannerStruct banner;

    @SerializedName("benefit_label_text_style")
    private final int benefitLabelTextStyle;

    @SerializedName("big_cover")
    private final String bigCover;

    @SerializedName("big_pic")
    private final Map<String, String> bigPic;

    @SerializedName("button_label")
    private final String buttonLabel;

    @SerializedName("button_tip")
    private final ButtonTipComponent buttonTipComponent;

    @SerializedName("campaign_end_time")
    private final Long campaignEndTime;

    @SerializedName("campaign_start_time")
    private final Long campaignStartTime;

    @SerializedName("campaign_sub_type")
    private final Integer campaignSubType;

    @SerializedName("car_adapt_component")
    private final CarAdaptComponent carAdaptComponent;

    @SerializedName("clothes_size_assistant")
    private final ClothesSizeAssistantStruct clothesSizeAssistant;

    @SerializedName("combo_limit")
    private final Long comboLimit;

    @SerializedName("cover")
    private final String cover;

    @SerializedName("default_buttons")
    private final List<SkuBottomButtons> defaultButtons;

    @SerializedName("delivery_delay_day")
    private final Integer deliveryDelayDay;

    @SerializedName("delivery_delay_desc")
    private final String deliveryDelayDesc;

    @SerializedName("deposit_price")
    private final long depositPrice;

    @SerializedName("discount_price")
    private final Long discountPrice;

    @SerializedName("discount_price_header")
    private final String discountPriceHeader;

    @SerializedName("discount_price_header_style")
    private final int discountPriceStyleType;

    @SerializedName("display_config")
    private final DisplayConfig displayConfig;

    @SerializedName("given_product_stock")
    private final Integer givenProductStock;

    @SerializedName("has_given_product")
    private final Boolean hasGivenProduct;

    @SerializedName("installment_info")
    private final SkuInstallmentItemInfo installmentInfo;

    @SerializedName("limit_text")
    private final String limitText;

    @SerializedName("limit_toast")
    private final String limitToast;

    @SerializedName(a.KEY_LOG_EXTRA)
    private final String logExtra;

    @SerializedName(a.KEY_LOG_PB)
    private final LogPbData logPb;

    @SerializedName(a.KEY_REGULAR_PRICE)
    private final Long marketPrice;

    @SerializedName("max_price")
    private final Long maxPrice;

    @SerializedName("min_limit_toast")
    private final String minLimitToast;

    @SerializedName("min_price")
    private final Long minPrice;

    @SerializedName("new_bonus_text")
    private String newBonusText;

    @SerializedName("order_component")
    private final OrderComponent orderComponent;

    @SerializedName("pic")
    private final Map<String, String> pictureMap;

    @SerializedName("poi_info")
    private final SkuPoiInfo poiInfo;

    @SerializedName("presell_delay_day")
    private final Integer presellDelayDay;

    @SerializedName("presell_delay_desc")
    private final String presellDelayDesc;

    @SerializedName("presell_type")
    private final Long presellType;

    @SerializedName("price_component")
    private final PriceComponent priceComponent;

    @SerializedName("price_header")
    private final String priceHeader;

    @SerializedName("price_header_style")
    private Integer priceHeaderStyle;

    @SerializedName("product_extra")
    private final String productExtra;

    @SerializedName("decision_infos")
    private final List<SafeguardComponent> safeguardComponents;

    @SerializedName("server_time")
    private final Long serverTime;

    @SerializedName("show_price_style")
    private final int showPriceStyle;

    @SerializedName("show_stock")
    private final boolean showStock;

    @SerializedName("show_event_track")
    private final Map<String, String> showTrackParams;

    @SerializedName("sku_type")
    private final Long skuType;

    @SerializedName("skus")
    private final Map<String, SkuItemInfo> skus;

    @SerializedName("small_pic")
    private final Map<String, String> smallPic;

    @SerializedName("specs")
    private final List<SpecInfo> specList;

    @SerializedName(a.KEY_STATUS)
    private final int status;

    @SerializedName("top_banner")
    private final TopBannerComponent topBannerComponent;

    @SerializedName("trade_mode_component")
    private final TradeModeComponent tradeModeComponent;

    @SerializedName("trust_tags")
    private final SkuTrustTags trustTags;

    @SerializedName("unuse_min_price")
    private final Long unUseMinPrice;

    @SerializedName("update_action_option")
    private final UpdateActionOption updateActionOption;

    @SerializedName("user_min_limit")
    private final Long userMinLimit;

    public SkuInfoResponseDTO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, false, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuInfoResponseDTO copy$default(SkuInfoResponseDTO r24, Map r25, List r26, String r27, String r28, Map r29, Map r30, Map r31, Long r32, Long r33, String r34, Long r35, Long r36, String r37, String r38, Long r39, Long r40, String r41, Long r42, String r43, String r44, SkuInstallmentItemInfo r45, String r46, String r47, Integer r48, String r49, Long r50, int r51, long r52, String r54, Long r55, Long r56, Long r57, Long r58, ECUrlModel r59, SkuPoiInfo r60, LogPbData r61, Integer r62, Integer r63, String r64, ECUrlModel r65, Integer r66, Boolean r67, Integer r68, SkuBannerStruct r69, int r70, ClothesSizeAssistantStruct r71, boolean r72, int r73, int r74, List r75, DisplayConfig r76, CarAdaptComponent r77, OrderComponent r78, PriceComponent r79, String r80, TradeModeComponent r81, TopBannerComponent r82, SkuTrustTags r83, List r84, ButtonTipComponent r85, Map r86, SkuAddCartGuideInfo r87, UpdateActionOption r88, int r89, int r90, Object r91) {
        if ((r89 & 1) == 0) goto L5;
        Map r10 = r24.skus;
    L7:
        if ((r89 & 2) == 0) goto L9;
        List r11 = r24.specList;
    L11:
        if ((r89 & 4) == 0) goto L13;
        String r12 = r24.cover;
    L15:
        if ((r89 & 8) == 0) goto L17;
        String r13 = r24.bigCover;
    L19:
        if ((r89 & 16) == 0) goto L21;
        Map r14 = r24.pictureMap;
    L23:
        if ((r89 & 32) == 0) goto L25;
        Map r15 = r24.bigPic;
    L27:
        if ((r89 & 64) == 0) goto L29;
        Map r16 = r24.smallPic;
    L31:
        if ((r89 & 128) == 0) goto L33;
        Long r17 = r24.minPrice;
    L35:
        if ((r89 & 256) == 0) goto L37;
        Long r18 = r24.maxPrice;
    L39:
        if ((r89 & 512) == 0) goto L41;
        String r19 = r24.buttonLabel;
    L43:
        if ((r89 & 1024) == 0) goto L45;
        Long r110 = r24.comboLimit;
    L47:
        if ((r89 & 2048) == 0) goto L49;
        Long r111 = r24.userMinLimit;
    L51:
        if ((r89 & 4096) == 0) goto L53;
        String r112 = r24.limitToast;
    L54:
        String r310 = r112;
        if ((r89 & 8192) == 0) goto L57;
        String r113 = r24.minLimitToast;
    L58:
        String r311 = r113;
        if ((r89 & 16384) == 0) goto L61;
        Long r114 = r24.unUseMinPrice;
    L62:
        Long r312 = r114;
        if ((r89 & 32768) == 0) goto L65;
        Long r115 = r24.discountPrice;
    L66:
        Long r410 = r115;
        if ((r89 & 65536) == 0) goto L69;
        String r116 = r24.discountPriceHeader;
    L70:
        String r411 = r116;
        if ((r89 & 131072) == 0) goto L73;
        Long r117 = r24.presellType;
    L74:
        Long r412 = r117;
        if ((r89 & 262144) == 0) goto L77;
        String r118 = r24.deliveryDelayDesc;
    L78:
        String r413 = r118;
        if ((r89 & 524288) == 0) goto L81;
        String r119 = r24.presellDelayDesc;
    L82:
        String r414 = r119;
        if ((r89 & 1048576) == 0) goto L85;
        SkuInstallmentItemInfo r120 = r24.installmentInfo;
    L86:
        SkuInstallmentItemInfo r415 = r120;
        if ((r89 & 2097152) == 0) goto L89;
        String r121 = r24.logExtra;
    L90:
        String r416 = r121;
        if ((r89 & 4194304) == 0) goto L93;
        String r122 = r24.priceHeader;
    L94:
        String r417 = r122;
        if ((r89 & 8388608) == 0) goto L97;
        Integer r123 = r24.priceHeaderStyle;
    L98:
        Integer r418 = r123;
        if ((r89 & 16777216) == 0) goto L101;
        String r124 = r24.newBonusText;
    L102:
        String r419 = r124;
        if ((r89 & 33554432) == 0) goto L105;
        Long r125 = r24.skuType;
    L106:
        Long r53 = r125;
        if ((r89 & 67108864) == 0) goto L109;
        int r126 = r24.status;
    L110:
        Long r313 = r111;
        int r510 = r126;
        if ((r89 & 134217728) == 0) goto L113;
        long r127 = r24.depositPrice;
    L114:
        long r511 = r127;
        if ((r89 & 268435456) == 0) goto L117;
        String r128 = r24.limitText;
    L119:
        if ((536870912 & r89) == 0) goto L121;
        Long r129 = r24.campaignStartTime;
    L122:
        Long r512 = r129;
        if ((r89 & 1073741824) == 0) goto L125;
        Long r130 = r24.campaignEndTime;
    L127:
        if ((r89 & Integer.MIN_VALUE) == 0) goto L129;
        Long r1 = r24.serverTime;
    L130:
        Long r513 = r1;
        if ((r90 & 1) == 0) goto L133;
        Long r20 = r24.marketPrice;
    L134:
        Long r514 = r20;
        if ((r90 & 2) == 0) goto L137;
        ECUrlModel r21 = r24.activityIcon;
    L138:
        ECUrlModel r515 = r21;
        if ((r90 & 4) == 0) goto L141;
        SkuPoiInfo r22 = r24.poiInfo;
    L142:
        SkuPoiInfo r610 = r22;
        if ((r90 & 8) == 0) goto L145;
        LogPbData r23 = r24.logPb;
    L146:
        LogPbData r611 = r23;
        if ((r90 & 16) == 0) goto L149;
        Integer r92 = r24.presellDelayDay;
    L150:
        Integer r612 = r92;
        if ((r90 & 32) == 0) goto L153;
        Integer r93 = r24.deliveryDelayDay;
    L154:
        Integer r613 = r93;
        if ((r90 & 64) == 0) goto L157;
        String r94 = r24.atmosphereHeader;
    L158:
        String r614 = r94;
        if ((r90 & 128) == 0) goto L161;
        ECUrlModel r95 = r24.atmosphereBackground;
    L162:
        ECUrlModel r615 = r95;
        if ((r90 & 256) == 0) goto L165;
        Integer r96 = r24.campaignSubType;
    L166:
        Integer r616 = r96;
        if ((r90 & 512) == 0) goto L169;
        Boolean r97 = r24.hasGivenProduct;
    L170:
        Boolean r617 = r97;
        if ((r90 & 1024) == 0) goto L173;
        Integer r98 = r24.givenProductStock;
    L174:
        Integer r618 = r98;
        if ((r90 & 2048) == 0) goto L177;
        SkuBannerStruct r99 = r24.banner;
    L178:
        SkuBannerStruct r619 = r99;
        if ((r90 & 4096) == 0) goto L181;
        int r100 = r24.benefitLabelTextStyle;
    L182:
        int r710 = r100;
        if ((r90 & 8192) == 0) goto L185;
        ClothesSizeAssistantStruct r101 = r24.clothesSizeAssistant;
    L186:
        ClothesSizeAssistantStruct r711 = r101;
        if ((r90 & 16384) == 0) goto L189;
        boolean r102 = r24.showStock;
    L190:
        boolean r712 = r102;
        if ((r90 & 32768) == 0) goto L193;
        int r103 = r24.showPriceStyle;
    L194:
        int r713 = r103;
        if ((r90 & 65536) == 0) goto L197;
        int r104 = r24.discountPriceStyleType;
    L198:
        int r714 = r104;
        if ((r90 & 131072) == 0) goto L201;
        List r105 = r24.defaultButtons;
    L202:
        List r715 = r105;
        if ((r90 & 262144) == 0) goto L205;
        DisplayConfig r106 = r24.displayConfig;
    L206:
        DisplayConfig r716 = r106;
        if ((r90 & 524288) == 0) goto L209;
        CarAdaptComponent r107 = r24.carAdaptComponent;
    L210:
        CarAdaptComponent r717 = r107;
        if ((r90 & 1048576) == 0) goto L213;
        OrderComponent r108 = r24.orderComponent;
    L214:
        OrderComponent r718 = r108;
        if ((r90 & 2097152) == 0) goto L217;
        PriceComponent r109 = r24.priceComponent;
    L218:
        PriceComponent r719 = r109;
        if ((r90 & 4194304) == 0) goto L221;
        String r131 = r24.productExtra;
    L222:
        String r810 = r131;
        if ((r90 & 8388608) == 0) goto L225;
        TradeModeComponent r132 = r24.tradeModeComponent;
    L226:
        TradeModeComponent r811 = r132;
        if ((r90 & 16777216) == 0) goto L229;
        TopBannerComponent r133 = r24.topBannerComponent;
    L230:
        TopBannerComponent r812 = r133;
        if ((r90 & 33554432) == 0) goto L233;
        SkuTrustTags r134 = r24.trustTags;
    L234:
        SkuTrustTags r813 = r134;
        if ((r90 & 67108864) == 0) goto L237;
        List r135 = r24.safeguardComponents;
    L238:
        List r814 = r135;
        if ((r90 & 134217728) == 0) goto L241;
        ButtonTipComponent r136 = r24.buttonTipComponent;
    L242:
        ButtonTipComponent r815 = r136;
        if ((r90 & 268435456) == 0) goto L245;
        Map r137 = r24.showTrackParams;
    L246:
        Map r816 = r137;
        if ((r90 & 536870912) == 0) goto L249;
        SkuAddCartGuideInfo r138 = r24.addCartGuideInfo;
    L251:
        if ((r90 & 1073741824) == 0) goto L253;
        UpdateActionOption r139 = r24.updateActionOption;
    L255:
        return r24.copy(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r313, r310, r311, r312, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r53, r510, r511, r128, r512, r130, r513, r514, r515, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r138, r139);
    L253:
        r139 = r88;
        goto L255
    L249:
        r138 = r87;
        goto L251
    L245:
        r137 = r86;
        goto L246
    L241:
        r136 = r85;
        goto L242
    L237:
        r135 = r84;
        goto L238
    L233:
        r134 = r83;
        goto L234
    L229:
        r133 = r82;
        goto L230
    L225:
        r132 = r81;
        goto L226
    L221:
        r131 = r80;
        goto L222
    L217:
        r109 = r79;
        goto L218
    L213:
        r108 = r78;
        goto L214
    L209:
        r107 = r77;
        goto L210
    L205:
        r106 = r76;
        goto L206
    L201:
        r105 = r75;
        goto L202
    L197:
        r104 = r74;
        goto L198
    L193:
        r103 = r73;
        goto L194
    L189:
        r102 = r72;
        goto L190
    L185:
        r101 = r71;
        goto L186
    L181:
        r100 = r70;
        goto L182
    L177:
        r99 = r69;
        goto L178
    L173:
        r98 = r68;
        goto L174
    L169:
        r97 = r67;
        goto L170
    L165:
        r96 = r66;
        goto L166
    L161:
        r95 = r65;
        goto L162
    L157:
        r94 = r64;
        goto L158
    L153:
        r93 = r63;
        goto L154
    L149:
        r92 = r62;
        goto L150
    L145:
        r23 = r61;
        goto L146
    L141:
        r22 = r60;
        goto L142
    L137:
        r21 = r59;
        goto L138
    L133:
        r20 = r58;
        goto L134
    L129:
        r1 = r57;
        goto L130
    L125:
        r130 = r56;
        goto L127
    L121:
        r129 = r55;
        goto L122
    L117:
        r128 = r54;
        goto L119
    L113:
        r127 = r52;
        goto L114
    L109:
        r126 = r51;
        goto L110
    L105:
        r125 = r50;
        goto L106
    L101:
        r124 = r49;
        goto L102
    L97:
        r123 = r48;
        goto L98
    L93:
        r122 = r47;
        goto L94
    L89:
        r121 = r46;
        goto L90
    L85:
        r120 = r45;
        goto L86
    L81:
        r119 = r44;
        goto L82
    L77:
        r118 = r43;
        goto L78
    L73:
        r117 = r42;
        goto L74
    L69:
        r116 = r41;
        goto L70
    L65:
        r115 = r40;
        goto L66
    L61:
        r114 = r39;
        goto L62
    L57:
        r113 = r38;
        goto L58
    L53:
        r112 = r37;
        goto L54
    L49:
        r111 = r36;
        goto L51
    L45:
        r110 = r35;
        goto L47
    L41:
        r19 = r34;
        goto L43
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

    public final Map<String, SkuItemInfo> component1() {
        return this.skus;
    }

    public final String component10() {
        return this.buttonLabel;
    }

    public final Long component11() {
        return this.comboLimit;
    }

    public final Long component12() {
        return this.userMinLimit;
    }

    public final String component13() {
        return this.limitToast;
    }

    public final String component14() {
        return this.minLimitToast;
    }

    public final Long component15() {
        return this.unUseMinPrice;
    }

    public final Long component16() {
        return this.discountPrice;
    }

    public final String component17() {
        return this.discountPriceHeader;
    }

    public final Long component18() {
        return this.presellType;
    }

    public final String component19() {
        return this.deliveryDelayDesc;
    }

    public final List<SpecInfo> component2() {
        return this.specList;
    }

    public final String component20() {
        return this.presellDelayDesc;
    }

    public final SkuInstallmentItemInfo component21() {
        return this.installmentInfo;
    }

    public final String component22() {
        return this.logExtra;
    }

    public final String component23() {
        return this.priceHeader;
    }

    public final Integer component24() {
        return this.priceHeaderStyle;
    }

    public final String component25() {
        return this.newBonusText;
    }

    public final Long component26() {
        return this.skuType;
    }

    public final int component27() {
        return this.status;
    }

    public final long component28() {
        return this.depositPrice;
    }

    public final String component29() {
        return this.limitText;
    }

    public final String component3() {
        return this.cover;
    }

    public final Long component30() {
        return this.campaignStartTime;
    }

    public final Long component31() {
        return this.campaignEndTime;
    }

    public final Long component32() {
        return this.serverTime;
    }

    public final Long component33() {
        return this.marketPrice;
    }

    public final ECUrlModel component34() {
        return this.activityIcon;
    }

    public final SkuPoiInfo component35() {
        return this.poiInfo;
    }

    public final LogPbData component36() {
        return this.logPb;
    }

    public final Integer component37() {
        return this.presellDelayDay;
    }

    public final Integer component38() {
        return this.deliveryDelayDay;
    }

    public final String component39() {
        return this.atmosphereHeader;
    }

    public final String component4() {
        return this.bigCover;
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
        return this.banner;
    }

    public final int component45() {
        return this.benefitLabelTextStyle;
    }

    public final ClothesSizeAssistantStruct component46() {
        return this.clothesSizeAssistant;
    }

    public final boolean component47() {
        return this.showStock;
    }

    public final int component48() {
        return this.showPriceStyle;
    }

    public final int component49() {
        return this.discountPriceStyleType;
    }

    public final Map<String, String> component5() {
        return this.pictureMap;
    }

    public final List<SkuBottomButtons> component50() {
        return this.defaultButtons;
    }

    public final DisplayConfig component51() {
        return this.displayConfig;
    }

    public final CarAdaptComponent component52() {
        return this.carAdaptComponent;
    }

    public final OrderComponent component53() {
        return this.orderComponent;
    }

    public final PriceComponent component54() {
        return this.priceComponent;
    }

    public final String component55() {
        return this.productExtra;
    }

    public final TradeModeComponent component56() {
        return this.tradeModeComponent;
    }

    public final TopBannerComponent component57() {
        return this.topBannerComponent;
    }

    public final SkuTrustTags component58() {
        return this.trustTags;
    }

    public final List<SafeguardComponent> component59() {
        return this.safeguardComponents;
    }

    public final Map<String, String> component6() {
        return this.bigPic;
    }

    public final ButtonTipComponent component60() {
        return this.buttonTipComponent;
    }

    public final Map<String, String> component61() {
        return this.showTrackParams;
    }

    public final SkuAddCartGuideInfo component62() {
        return this.addCartGuideInfo;
    }

    public final UpdateActionOption component63() {
        return this.updateActionOption;
    }

    public final Map<String, String> component7() {
        return this.smallPic;
    }

    public final Long component8() {
        return this.minPrice;
    }

    public final Long component9() {
        return this.maxPrice;
    }

    public final SkuInfoResponseDTO copy(Map<String, SkuItemInfo> r67, List<SpecInfo> r68, String r69, String r70, Map<String, String> r71, Map<String, String> r72, Map<String, String> r73, Long r74, Long r75, String r76, Long r77, Long r78, String r79, String r80, Long r81, Long r82, String r83, Long r84, String r85, String r86, SkuInstallmentItemInfo r87, String r88, String r89, Integer r90, String r91, Long r92, int r93, long r94, String r96, Long r97, Long r98, Long r99, Long r100, ECUrlModel r101, SkuPoiInfo r102, LogPbData r103, Integer r104, Integer r105, String r106, ECUrlModel r107, Integer r108, Boolean r109, Integer r110, SkuBannerStruct r111, int r112, ClothesSizeAssistantStruct r113, boolean r114, int r115, int r116, List<SkuBottomButtons> r117, DisplayConfig r118, CarAdaptComponent r119, OrderComponent r120, PriceComponent r121, String r122, TradeModeComponent r123, TopBannerComponent r124, SkuTrustTags r125, List<SafeguardComponent> r126, ButtonTipComponent r127, Map<String, String> r128, SkuAddCartGuideInfo r129, UpdateActionOption r130) {
        return new SkuInfoResponseDTO(r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof SkuInfoResponseDTO) == false) goto L132;
        SkuInfoResponseDTO r11 = (SkuInfoResponseDTO) r10;
        if (Intrinsics.areEqual(this.skus, r11.skus) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.specList, r11.specList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cover, r11.cover) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bigCover, r11.bigCover) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.pictureMap, r11.pictureMap) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.bigPic, r11.bigPic) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.smallPic, r11.smallPic) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.minPrice, r11.minPrice) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.maxPrice, r11.maxPrice) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonLabel, r11.buttonLabel) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.comboLimit, r11.comboLimit) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.userMinLimit, r11.userMinLimit) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.limitToast, r11.limitToast) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.minLimitToast, r11.minLimitToast) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.unUseMinPrice, r11.unUseMinPrice) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.discountPrice, r11.discountPrice) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.discountPriceHeader, r11.discountPriceHeader) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.presellType, r11.presellType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.deliveryDelayDesc, r11.deliveryDelayDesc) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.presellDelayDesc, r11.presellDelayDesc) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.installmentInfo, r11.installmentInfo) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.logExtra, r11.logExtra) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.priceHeader, r11.priceHeader) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.priceHeaderStyle, r11.priceHeaderStyle) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.newBonusText, r11.newBonusText) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.skuType, r11.skuType) == true) goto L58;
        return false;
    L58:
        if (this.status == r11.status) goto L60;
        return false;
    L60:
        if (this.depositPrice == r11.depositPrice) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.limitText, r11.limitText) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.campaignStartTime, r11.campaignStartTime) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.campaignEndTime, r11.campaignEndTime) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.serverTime, r11.serverTime) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.marketPrice, r11.marketPrice) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.activityIcon, r11.activityIcon) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.poiInfo, r11.poiInfo) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.logPb, r11.logPb) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.presellDelayDay, r11.presellDelayDay) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.deliveryDelayDay, r11.deliveryDelayDay) == true) goto L82;
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
        if (Intrinsics.areEqual(this.banner, r11.banner) == true) goto L94;
        return false;
    L94:
        if (this.benefitLabelTextStyle == r11.benefitLabelTextStyle) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.clothesSizeAssistant, r11.clothesSizeAssistant) == true) goto L98;
        return false;
    L98:
        if (this.showStock == r11.showStock) goto L100;
        return false;
    L100:
        if (this.showPriceStyle == r11.showPriceStyle) goto L102;
        return false;
    L102:
        if (this.discountPriceStyleType == r11.discountPriceStyleType) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.defaultButtons, r11.defaultButtons) == true) goto L106;
        return false;
    L106:
        if (Intrinsics.areEqual(this.displayConfig, r11.displayConfig) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.carAdaptComponent, r11.carAdaptComponent) == true) goto L110;
        return false;
    L110:
        if (Intrinsics.areEqual(this.orderComponent, r11.orderComponent) == true) goto L112;
        return false;
    L112:
        if (Intrinsics.areEqual(this.priceComponent, r11.priceComponent) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.productExtra, r11.productExtra) == true) goto L116;
        return false;
    L116:
        if (Intrinsics.areEqual(this.tradeModeComponent, r11.tradeModeComponent) == true) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.topBannerComponent, r11.topBannerComponent) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.trustTags, r11.trustTags) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.safeguardComponents, r11.safeguardComponents) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.buttonTipComponent, r11.buttonTipComponent) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.showTrackParams, r11.showTrackParams) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.addCartGuideInfo, r11.addCartGuideInfo) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.updateActionOption, r11.updateActionOption) == true) goto L199;
        return false;
    L199:
        return true;
    L132:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v131, types: [int] */
    /* JADX WARN: Type inference failed for: r2v187 */
    /* JADX WARN: Type inference failed for: r2v230 */
    public int hashCode() {
        Map<String, SkuItemInfo> r0 = this.skus;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        List<SpecInfo> r12 = this.specList;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.cover;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.bigCover;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        Map<String, String> r21 = this.pictureMap;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        Map<String, String> r24 = this.bigPic;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        Map<String, String> r27 = this.smallPic;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        Long r30 = this.minPrice;
        if (r30 == null) goto L33;
        int r31 = r30.hashCode();
    L34:
        int r32 = (r29 + r31) * 31;
        Long r33 = this.maxPrice;
        if (r33 == null) goto L37;
        int r34 = r33.hashCode();
    L38:
        int r35 = (r32 + r34) * 31;
        String r36 = this.buttonLabel;
        if (r36 == null) goto L41;
        int r37 = r36.hashCode();
    L42:
        int r38 = (r35 + r37) * 31;
        Long r39 = this.comboLimit;
        if (r39 == null) goto L45;
        int r40 = r39.hashCode();
    L46:
        int r41 = (r38 + r40) * 31;
        Long r42 = this.userMinLimit;
        if (r42 == null) goto L49;
        int r43 = r42.hashCode();
    L50:
        int r44 = (r41 + r43) * 31;
        String r45 = this.limitToast;
        if (r45 == null) goto L53;
        int r46 = r45.hashCode();
    L54:
        int r47 = (r44 + r46) * 31;
        String r48 = this.minLimitToast;
        if (r48 == null) goto L57;
        int r49 = r48.hashCode();
    L58:
        int r50 = (r47 + r49) * 31;
        Long r51 = this.unUseMinPrice;
        if (r51 == null) goto L61;
        int r52 = r51.hashCode();
    L62:
        int r53 = (r50 + r52) * 31;
        Long r54 = this.discountPrice;
        if (r54 == null) goto L65;
        int r55 = r54.hashCode();
    L66:
        int r56 = (r53 + r55) * 31;
        String r57 = this.discountPriceHeader;
        if (r57 == null) goto L69;
        int r58 = r57.hashCode();
    L70:
        int r59 = (r56 + r58) * 31;
        Long r60 = this.presellType;
        if (r60 == null) goto L73;
        int r61 = r60.hashCode();
    L74:
        int r62 = (r59 + r61) * 31;
        String r63 = this.deliveryDelayDesc;
        if (r63 == null) goto L77;
        int r64 = r63.hashCode();
    L78:
        int r65 = (r62 + r64) * 31;
        String r66 = this.presellDelayDesc;
        if (r66 == null) goto L81;
        int r67 = r66.hashCode();
    L82:
        int r68 = (r65 + r67) * 31;
        SkuInstallmentItemInfo r69 = this.installmentInfo;
        if (r69 == null) goto L85;
        int r70 = r69.hashCode();
    L86:
        int r71 = (r68 + r70) * 31;
        String r72 = this.logExtra;
        if (r72 == null) goto L89;
        int r73 = r72.hashCode();
    L90:
        int r74 = (r71 + r73) * 31;
        String r75 = this.priceHeader;
        if (r75 == null) goto L93;
        int r76 = r75.hashCode();
    L94:
        int r77 = (r74 + r76) * 31;
        Integer r78 = this.priceHeaderStyle;
        if (r78 == null) goto L97;
        int r79 = r78.hashCode();
    L98:
        int r80 = (r77 + r79) * 31;
        String r81 = this.newBonusText;
        if (r81 == null) goto L101;
        int r82 = r81.hashCode();
    L102:
        int r83 = (r80 + r82) * 31;
        Long r84 = this.skuType;
        if (r84 == null) goto L105;
        int r85 = r84.hashCode();
    L106:
        int r86 = (((r83 + r85) * 31) + this.status) * 31;
        long r87 = this.depositPrice;
        int r88 = (r86 + ((int) (r87 ^ (r87 >>> 32)))) * 31;
        String r89 = this.limitText;
        if (r89 == null) goto L109;
        int r90 = r89.hashCode();
    L110:
        int r91 = (r88 + r90) * 31;
        Long r92 = this.campaignStartTime;
        if (r92 == null) goto L113;
        int r93 = r92.hashCode();
    L114:
        int r94 = (r91 + r93) * 31;
        Long r95 = this.campaignEndTime;
        if (r95 == null) goto L117;
        int r96 = r95.hashCode();
    L118:
        int r97 = (r94 + r96) * 31;
        Long r98 = this.serverTime;
        if (r98 == null) goto L121;
        int r99 = r98.hashCode();
    L122:
        int r100 = (r97 + r99) * 31;
        Long r101 = this.marketPrice;
        if (r101 == null) goto L125;
        int r102 = r101.hashCode();
    L126:
        int r103 = (r100 + r102) * 31;
        ECUrlModel r104 = this.activityIcon;
        if (r104 == null) goto L129;
        int r105 = r104.hashCode();
    L130:
        int r106 = (r103 + r105) * 31;
        SkuPoiInfo r107 = this.poiInfo;
        if (r107 == null) goto L133;
        int r108 = r107.hashCode();
    L134:
        int r109 = (r106 + r108) * 31;
        LogPbData r110 = this.logPb;
        if (r110 == null) goto L137;
        int r111 = r110.hashCode();
    L138:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.presellDelayDay;
        if (r113 == null) goto L141;
        int r114 = r113.hashCode();
    L142:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.deliveryDelayDay;
        if (r116 == null) goto L145;
        int r117 = r116.hashCode();
    L146:
        int r118 = (r115 + r117) * 31;
        String r119 = this.atmosphereHeader;
        if (r119 == null) goto L149;
        int r120 = r119.hashCode();
    L150:
        int r121 = (r118 + r120) * 31;
        ECUrlModel r122 = this.atmosphereBackground;
        if (r122 == null) goto L153;
        int r123 = r122.hashCode();
    L154:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.campaignSubType;
        if (r125 == null) goto L157;
        int r126 = r125.hashCode();
    L158:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.hasGivenProduct;
        if (r128 == null) goto L161;
        int r129 = r128.hashCode();
    L162:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.givenProductStock;
        if (r131 == null) goto L165;
        int r132 = r131.hashCode();
    L166:
        int r133 = (r130 + r132) * 31;
        SkuBannerStruct r134 = this.banner;
        if (r134 == null) goto L169;
        int r135 = r134.hashCode();
    L170:
        int r136 = (((r133 + r135) * 31) + this.benefitLabelTextStyle) * 31;
        ClothesSizeAssistantStruct r137 = this.clothesSizeAssistant;
        if (r137 == null) goto L173;
        int r138 = r137.hashCode();
    L174:
        int r139 = (r136 + r138) * 31;
        boolean r140 = this.showStock;
        ?? r141 = r140;
        if (r140 == false) goto L177;
        r141 = 1;
    L177:
        int r142 = (((((r139 + r141) * 31) + this.showPriceStyle) * 31) + this.discountPriceStyleType) * 31;
        List<SkuBottomButtons> r143 = this.defaultButtons;
        if (r143 == null) goto L180;
        int r144 = r143.hashCode();
    L181:
        int r145 = (r142 + r144) * 31;
        DisplayConfig r146 = this.displayConfig;
        if (r146 == null) goto L184;
        int r147 = r146.hashCode();
    L185:
        int r148 = (r145 + r147) * 31;
        CarAdaptComponent r149 = this.carAdaptComponent;
        if (r149 == null) goto L188;
        int r150 = r149.hashCode();
    L189:
        int r151 = (r148 + r150) * 31;
        OrderComponent r152 = this.orderComponent;
        if (r152 == null) goto L192;
        int r153 = r152.hashCode();
    L193:
        int r154 = (r151 + r153) * 31;
        PriceComponent r155 = this.priceComponent;
        if (r155 == null) goto L196;
        int r156 = r155.hashCode();
    L197:
        int r157 = (r154 + r156) * 31;
        String r158 = this.productExtra;
        if (r158 == null) goto L200;
        int r159 = r158.hashCode();
    L201:
        int r160 = (r157 + r159) * 31;
        TradeModeComponent r161 = this.tradeModeComponent;
        if (r161 == null) goto L204;
        int r162 = r161.hashCode();
    L205:
        int r163 = (r160 + r162) * 31;
        TopBannerComponent r164 = this.topBannerComponent;
        if (r164 == null) goto L208;
        int r165 = r164.hashCode();
    L209:
        int r166 = (r163 + r165) * 31;
        SkuTrustTags r167 = this.trustTags;
        if (r167 == null) goto L212;
        int r168 = r167.hashCode();
    L213:
        int r169 = (r166 + r168) * 31;
        List<SafeguardComponent> r170 = this.safeguardComponents;
        if (r170 == null) goto L216;
        int r171 = r170.hashCode();
    L217:
        int r172 = (r169 + r171) * 31;
        ButtonTipComponent r173 = this.buttonTipComponent;
        if (r173 == null) goto L220;
        int r174 = r173.hashCode();
    L221:
        int r175 = (r172 + r174) * 31;
        Map<String, String> r176 = this.showTrackParams;
        if (r176 == null) goto L224;
        int r177 = r176.hashCode();
    L225:
        int r178 = (r175 + r177) * 31;
        SkuAddCartGuideInfo r179 = this.addCartGuideInfo;
        if (r179 == null) goto L228;
        int r180 = r179.hashCode();
    L229:
        int r181 = (r178 + r180) * 31;
        UpdateActionOption r182 = this.updateActionOption;
        if (r182 == null) goto L233;
        r1 = r182.hashCode();
    L233:
        return r181 + r1;
    L228:
        r180 = 0;
        goto L229
    L224:
        r177 = 0;
        goto L225
    L220:
        r174 = 0;
        goto L221
    L216:
        r171 = 0;
        goto L217
    L212:
        r168 = 0;
        goto L213
    L208:
        r165 = 0;
        goto L209
    L204:
        r162 = 0;
        goto L205
    L200:
        r159 = 0;
        goto L201
    L196:
        r156 = 0;
        goto L197
    L192:
        r153 = 0;
        goto L193
    L188:
        r150 = 0;
        goto L189
    L184:
        r147 = 0;
        goto L185
    L180:
        r144 = 0;
        goto L181
    L173:
        r138 = 0;
        goto L174
    L169:
        r135 = 0;
        goto L170
    L165:
        r132 = 0;
        goto L166
    L161:
        r129 = 0;
        goto L162
    L157:
        r126 = 0;
        goto L158
    L153:
        r123 = 0;
        goto L154
    L149:
        r120 = 0;
        goto L150
    L145:
        r117 = 0;
        goto L146
    L141:
        r114 = 0;
        goto L142
    L137:
        r111 = 0;
        goto L138
    L133:
        r108 = 0;
        goto L134
    L129:
        r105 = 0;
        goto L130
    L125:
        r102 = 0;
        goto L126
    L121:
        r99 = 0;
        goto L122
    L117:
        r96 = 0;
        goto L118
    L113:
        r93 = 0;
        goto L114
    L109:
        r90 = 0;
        goto L110
    L105:
        r85 = 0;
        goto L106
    L101:
        r82 = 0;
        goto L102
    L97:
        r79 = 0;
        goto L98
    L93:
        r76 = 0;
        goto L94
    L89:
        r73 = 0;
        goto L90
    L85:
        r70 = 0;
        goto L86
    L81:
        r67 = 0;
        goto L82
    L77:
        r64 = 0;
        goto L78
    L73:
        r61 = 0;
        goto L74
    L69:
        r58 = 0;
        goto L70
    L65:
        r55 = 0;
        goto L66
    L61:
        r52 = 0;
        goto L62
    L57:
        r49 = 0;
        goto L58
    L53:
        r46 = 0;
        goto L54
    L49:
        r43 = 0;
        goto L50
    L45:
        r40 = 0;
        goto L46
    L41:
        r37 = 0;
        goto L42
    L37:
        r34 = 0;
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
        return "SkuInfoResponseDTO(skus=" + this.skus + ", specList=" + this.specList + ", cover=" + this.cover + ", bigCover=" + this.bigCover + ", pictureMap=" + this.pictureMap + ", bigPic=" + this.bigPic + ", smallPic=" + this.smallPic + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", buttonLabel=" + this.buttonLabel + ", comboLimit=" + this.comboLimit + ", userMinLimit=" + this.userMinLimit + ", limitToast=" + this.limitToast + ", minLimitToast=" + this.minLimitToast + ", unUseMinPrice=" + this.unUseMinPrice + ", discountPrice=" + this.discountPrice + ", discountPriceHeader=" + this.discountPriceHeader + ", presellType=" + this.presellType + ", deliveryDelayDesc=" + this.deliveryDelayDesc + ", presellDelayDesc=" + this.presellDelayDesc + ", installmentInfo=" + this.installmentInfo + ", logExtra=" + this.logExtra + ", priceHeader=" + this.priceHeader + ", priceHeaderStyle=" + this.priceHeaderStyle + ", newBonusText=" + this.newBonusText + ", skuType=" + this.skuType + ", status=" + this.status + ", depositPrice=" + this.depositPrice + ", limitText=" + this.limitText + ", campaignStartTime=" + this.campaignStartTime + ", campaignEndTime=" + this.campaignEndTime + ", serverTime=" + this.serverTime + ", marketPrice=" + this.marketPrice + ", activityIcon=" + this.activityIcon + ", poiInfo=" + this.poiInfo + ", logPb=" + this.logPb + ", presellDelayDay=" + this.presellDelayDay + ", deliveryDelayDay=" + this.deliveryDelayDay + ", atmosphereHeader=" + this.atmosphereHeader + ", atmosphereBackground=" + this.atmosphereBackground + ", campaignSubType=" + this.campaignSubType + ", hasGivenProduct=" + this.hasGivenProduct + ", givenProductStock=" + this.givenProductStock + ", banner=" + this.banner + ", benefitLabelTextStyle=" + this.benefitLabelTextStyle + ", clothesSizeAssistant=" + this.clothesSizeAssistant + ", showStock=" + this.showStock + ", showPriceStyle=" + this.showPriceStyle + ", discountPriceStyleType=" + this.discountPriceStyleType + ", defaultButtons=" + this.defaultButtons + ", displayConfig=" + this.displayConfig + ", carAdaptComponent=" + this.carAdaptComponent + ", orderComponent=" + this.orderComponent + ", priceComponent=" + this.priceComponent + ", productExtra=" + this.productExtra + ", tradeModeComponent=" + this.tradeModeComponent + ", topBannerComponent=" + this.topBannerComponent + ", trustTags=" + this.trustTags + ", safeguardComponents=" + this.safeguardComponents + ", buttonTipComponent=" + this.buttonTipComponent + ", showTrackParams=" + this.showTrackParams + ", addCartGuideInfo=" + this.addCartGuideInfo + ", updateActionOption=" + this.updateActionOption + ")";
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

    public final SkuBannerStruct getBanner() {
        return this.banner;
    }

    public final int getBenefitLabelTextStyle() {
        return this.benefitLabelTextStyle;
    }

    public final String getBigCover() {
        return this.bigCover;
    }

    public final Map<String, String> getBigPic() {
        return this.bigPic;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final ButtonTipComponent getButtonTipComponent() {
        return this.buttonTipComponent;
    }

    public final Long getCampaignEndTime() {
        return this.campaignEndTime;
    }

    public final Long getCampaignStartTime() {
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

    public final Long getComboLimit() {
        return this.comboLimit;
    }

    public final String getCover() {
        return this.cover;
    }

    public final List<SkuBottomButtons> getDefaultButtons() {
        return this.defaultButtons;
    }

    public final Integer getDeliveryDelayDay() {
        return this.deliveryDelayDay;
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

    public final Integer getGivenProductStock() {
        return this.givenProductStock;
    }

    public final Boolean getHasGivenProduct() {
        return this.hasGivenProduct;
    }

    public final SkuInstallmentItemInfo getInstallmentInfo() {
        return this.installmentInfo;
    }

    public final String getLimitText() {
        return this.limitText;
    }

    public final String getLimitToast() {
        return this.limitToast;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final LogPbData getLogPb() {
        return this.logPb;
    }

    public final Long getMarketPrice() {
        return this.marketPrice;
    }

    public final Long getMaxPrice() {
        return this.maxPrice;
    }

    public final String getMinLimitToast() {
        return this.minLimitToast;
    }

    public final Long getMinPrice() {
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

    public final Integer getPresellDelayDay() {
        return this.presellDelayDay;
    }

    public final String getPresellDelayDesc() {
        return this.presellDelayDesc;
    }

    public final Long getPresellType() {
        return this.presellType;
    }

    public final PriceComponent getPriceComponent() {
        return this.priceComponent;
    }

    public final String getPriceHeader() {
        return this.priceHeader;
    }

    public final Integer getPriceHeaderStyle() {
        return this.priceHeaderStyle;
    }

    public final String getProductExtra() {
        return this.productExtra;
    }

    public final List<SafeguardComponent> getSafeguardComponents() {
        return this.safeguardComponents;
    }

    public final Long getServerTime() {
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

    public final Long getSkuType() {
        return this.skuType;
    }

    public final Map<String, SkuItemInfo> getSkus() {
        return this.skus;
    }

    public final Map<String, String> getSmallPic() {
        return this.smallPic;
    }

    public final List<SpecInfo> getSpecList() {
        return this.specList;
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

    public final Long getUserMinLimit() {
        return this.userMinLimit;
    }

    public final void setNewBonusText(String r1) {
        this.newBonusText = r1;
    }

    public final void setPriceHeaderStyle(Integer r1) {
        this.priceHeaderStyle = r1;
    }

    public SkuInfoResponseDTO(Map<String, SkuItemInfo> r10, List<SpecInfo> r11, String r12, String r13, Map<String, String> r14, Map<String, String> r15, Map<String, String> r16, Long r17, Long r18, String r19, Long r110, Long r111, String r112, String r113, Long r114, Long r115, String r20, Long r21, String r22, String r23, SkuInstallmentItemInfo r24, String r25, String r26, Integer r27, String r28, Long r29, int r30, long r31, String r33, Long r34, Long r35, Long r36, Long r37, ECUrlModel r38, SkuPoiInfo r39, LogPbData r40, Integer r41, Integer r42, String r43, ECUrlModel r44, Integer r45, Boolean r46, Integer r47, SkuBannerStruct r48, int r49, ClothesSizeAssistantStruct r50, boolean r51, int r52, int r53, List<SkuBottomButtons> r54, DisplayConfig r55, CarAdaptComponent r56, OrderComponent r57, PriceComponent r58, String r59, TradeModeComponent r60, TopBannerComponent r61, SkuTrustTags r62, List<SafeguardComponent> r63, ButtonTipComponent r64, Map<String, String> r65, SkuAddCartGuideInfo r66, UpdateActionOption r67) {
        this.skus = r10;
        this.specList = r11;
        this.cover = r12;
        this.bigCover = r13;
        this.pictureMap = r14;
        this.bigPic = r15;
        this.smallPic = r16;
        this.minPrice = r17;
        this.maxPrice = r18;
        this.buttonLabel = r19;
        this.comboLimit = r110;
        this.userMinLimit = r111;
        this.limitToast = r112;
        this.minLimitToast = r113;
        this.unUseMinPrice = r114;
        this.discountPrice = r115;
        this.discountPriceHeader = r20;
        this.presellType = r21;
        this.deliveryDelayDesc = r22;
        this.presellDelayDesc = r23;
        this.installmentInfo = r24;
        this.logExtra = r25;
        this.priceHeader = r26;
        this.priceHeaderStyle = r27;
        this.newBonusText = r28;
        this.skuType = r29;
        this.status = r30;
        this.depositPrice = r31;
        this.limitText = r33;
        this.campaignStartTime = r34;
        this.campaignEndTime = r35;
        this.serverTime = r36;
        this.marketPrice = r37;
        this.activityIcon = r38;
        this.poiInfo = r39;
        this.logPb = r40;
        this.presellDelayDay = r41;
        this.deliveryDelayDay = r42;
        this.atmosphereHeader = r43;
        this.atmosphereBackground = r44;
        this.campaignSubType = r45;
        this.hasGivenProduct = r46;
        this.givenProductStock = r47;
        this.banner = r48;
        this.benefitLabelTextStyle = r49;
        this.clothesSizeAssistant = r50;
        this.showStock = r51;
        this.showPriceStyle = r52;
        this.discountPriceStyleType = r53;
        this.defaultButtons = r54;
        this.displayConfig = r55;
        this.carAdaptComponent = r56;
        this.orderComponent = r57;
        this.priceComponent = r58;
        this.productExtra = r59;
        this.tradeModeComponent = r60;
        this.topBannerComponent = r61;
        this.trustTags = r62;
        this.safeguardComponents = r63;
        this.buttonTipComponent = r64;
        this.showTrackParams = r65;
        this.addCartGuideInfo = r66;
        this.updateActionOption = r67;
    }

    public /* synthetic */ SkuInfoResponseDTO(Map r65, List r66, String r67, String r68, Map r69, Map r70, Map r71, Long r72, Long r73, String r74, Long r75, Long r76, String r77, String r78, Long r79, Long r80, String r81, Long r82, String r83, String r84, SkuInstallmentItemInfo r85, String r86, String r87, Integer r88, String r89, Long r90, int r91, long r92, String r94, Long r95, Long r96, Long r97, Long r98, ECUrlModel r99, SkuPoiInfo r100, LogPbData r101, Integer r102, Integer r103, String r104, ECUrlModel r105, Integer r106, Boolean r107, Integer r108, SkuBannerStruct r109, int r110, ClothesSizeAssistantStruct r111, boolean r112, int r113, int r114, List r115, DisplayConfig r116, CarAdaptComponent r117, OrderComponent r118, PriceComponent r119, String r120, TradeModeComponent r121, TopBannerComponent r122, SkuTrustTags r123, List r124, ButtonTipComponent r125, Map r126, SkuAddCartGuideInfo r127, UpdateActionOption r128, int r129, int r130, DefaultConstructorMarker r131) {
        if ((r129 & 1) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r129 & 2) == 0) goto L9;
        List r11 = null;
    L11:
        if ((r129 & 4) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r129 & 8) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r129 & 16) == 0) goto L21;
        Map r14 = null;
    L23:
        if ((r129 & 32) == 0) goto L25;
        Map r15 = null;
    L27:
        if ((r129 & 64) == 0) goto L29;
        Map r16 = null;
    L31:
        if ((r129 & 128) == 0) goto L33;
        Long r17 = null;
    L35:
        if ((r129 & 256) == 0) goto L37;
        Long r18 = null;
    L39:
        if ((r129 & 512) == 0) goto L41;
        String r19 = null;
    L43:
        if ((r129 & 1024) == 0) goto L45;
        Long r132 = null;
    L47:
        if ((r129 & 2048) == 0) goto L49;
        Long r133 = null;
    L51:
        if ((r129 & 4096) == 0) goto L53;
        String r134 = null;
    L55:
        if ((r129 & 8192) == 0) goto L57;
        String r20 = null;
    L58:
        String r135 = r20;
        if ((r129 & 16384) == 0) goto L61;
        Long r21 = null;
    L63:
        if ((r129 & 32768) == 0) goto L65;
        Long r136 = null;
    L67:
        if ((r129 & 65536) == 0) goto L69;
        String r22 = null;
    L71:
        if ((r129 & 131072) == 0) goto L73;
        Long r23 = null;
    L75:
        if ((r129 & 262144) == 0) goto L77;
        String r24 = null;
    L79:
        if ((r129 & 524288) == 0) goto L81;
        String r26 = null;
    L83:
        if ((r129 & 1048576) == 0) goto L85;
        SkuInstallmentItemInfo r27 = null;
    L87:
        if ((r129 & 2097152) == 0) goto L89;
        String r28 = null;
    L91:
        if ((r129 & 4194304) == 0) goto L93;
        String r29 = null;
    L94:
        int r31 = 0;
        if ((r129 & 8388608) == 0) goto L97;
        Integer r30 = 0;
    L99:
        if ((r129 & 16777216) == 0) goto L101;
        String r32 = null;
    L103:
        if ((r129 & 33554432) == 0) goto L105;
        Long r33 = null;
    L106:
        int r35 = 2;
        if ((r129 & 67108864) == 0) goto L109;
        int r34 = 2;
    L111:
        if ((r129 & 134217728) == 0) goto L113;
        long r36 = 0;
    L115:
        if ((r129 & 268435456) == 0) goto L117;
        String r38 = null;
    L119:
        if ((r129 & 536870912) == 0) goto L121;
        Long r39 = null;
    L123:
        if ((r129 & 1073741824) == 0) goto L125;
        Long r40 = null;
    L127:
        if ((r129 & Integer.MIN_VALUE) == 0) goto L129;
        Long r0 = null;
    L131:
        if ((r130 & 1) == 0) goto L133;
        Long r41 = null;
    L135:
        if ((r130 & 2) == 0) goto L137;
        ECUrlModel r42 = null;
    L139:
        if ((r130 & 4) == 0) goto L141;
        SkuPoiInfo r43 = null;
    L143:
        if ((r130 & 8) == 0) goto L145;
        LogPbData r44 = null;
    L147:
        if ((r130 & 16) == 0) goto L149;
        Integer r45 = null;
    L151:
        if ((r130 & 32) == 0) goto L153;
        Integer r46 = null;
    L155:
        if ((r130 & 64) == 0) goto L157;
        String r47 = null;
    L158:
        Long r1210 = r0;
        if ((r130 & 128) == 0) goto L161;
        ECUrlModel r1 = null;
    L162:
        ECUrlModel r48 = r1;
        if ((r130 & 256) == 0) goto L165;
        Integer r25 = null;
    L166:
        Integer r49 = r25;
        if ((r130 & 512) == 0) goto L169;
        Boolean r37 = null;
    L170:
        Boolean r50 = r37;
        if ((r130 & 1024) == 0) goto L173;
        Integer r51 = null;
    L174:
        Integer r52 = r51;
        if ((r130 & 2048) == 0) goto L177;
        SkuBannerStruct r53 = null;
    L178:
        SkuBannerStruct r54 = r53;
        if ((r130 & 4096) != 0) goto L183;
        r35 = r110;
    L183:
        if ((r130 & 8192) == 0) goto L185;
        ClothesSizeAssistantStruct r55 = null;
    L186:
        ClothesSizeAssistantStruct r56 = r55;
        if ((r130 & 16384) == 0) goto L189;
        boolean r57 = true;
    L191:
        if ((r130 & 32768) == 0) goto L193;
        int r137 = 0;
    L195:
        if ((r130 & 65536) != 0) goto L199;
        r31 = r114;
    L199:
        if ((r130 & 131072) == 0) goto L201;
        List r138 = null;
    L203:
        if ((r130 & 262144) == 0) goto L205;
        DisplayConfig r210 = null;
    L207:
        if ((r130 & 524288) == 0) goto L209;
        CarAdaptComponent r211 = null;
    L211:
        if ((r130 & 1048576) == 0) goto L213;
        OrderComponent r212 = null;
    L215:
        if ((r130 & 2097152) == 0) goto L217;
        PriceComponent r58 = null;
    L219:
        if ((r130 & 4194304) == 0) goto L221;
        String r59 = null;
    L223:
        if ((r130 & 8388608) == 0) goto L225;
        TradeModeComponent r510 = null;
    L227:
        if ((r130 & 16777216) == 0) goto L229;
        TopBannerComponent r511 = null;
    L231:
        if ((r130 & 33554432) == 0) goto L233;
        SkuTrustTags r512 = null;
    L235:
        if ((r130 & 67108864) == 0) goto L237;
        List r513 = null;
    L239:
        if ((r130 & 134217728) == 0) goto L241;
        ButtonTipComponent r60 = null;
    L243:
        if ((r130 & 268435456) == 0) goto L245;
        Map r61 = null;
    L247:
        if ((r130 & 536870912) == 0) goto L249;
        SkuAddCartGuideInfo r62 = null;
    L251:
        if ((r130 & 1073741824) == 0) goto L253;
        UpdateActionOption r63 = null;
    L254:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r132, r133, r134, r135, r21, r136, r22, r23, r24, r26, r27, r28, r29, r30, r32, r33, r34, r36, r38, r39, r40, r1210, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r52, r54, r35, r56, r57, r137, r31, r138, r210, r211, r212, r58, r59, r510, r511, r512, r513, r60, r61, r62, r63);
        return;
    L253:
        r63 = r128;
        goto L254
    L249:
        r62 = r127;
        goto L251
    L245:
        r61 = r126;
        goto L247
    L241:
        r60 = r125;
        goto L243
    L237:
        r513 = r124;
        goto L239
    L233:
        r512 = r123;
        goto L235
    L229:
        r511 = r122;
        goto L231
    L225:
        r510 = r121;
        goto L227
    L221:
        r59 = r120;
        goto L223
    L217:
        r58 = r119;
        goto L219
    L213:
        r212 = r118;
        goto L215
    L209:
        r211 = r117;
        goto L211
    L205:
        r210 = r116;
        goto L207
    L201:
        r138 = r115;
        goto L203
    L193:
        r137 = r113;
        goto L195
    L189:
        r57 = r112;
        goto L191
    L185:
        r55 = r111;
        goto L186
    L177:
        r53 = r109;
        goto L178
    L173:
        r51 = r108;
        goto L174
    L169:
        r37 = r107;
        goto L170
    L165:
        r25 = r106;
        goto L166
    L161:
        r1 = r105;
        goto L162
    L157:
        r47 = r104;
        goto L158
    L153:
        r46 = r103;
        goto L155
    L149:
        r45 = r102;
        goto L151
    L145:
        r44 = r101;
        goto L147
    L141:
        r43 = r100;
        goto L143
    L137:
        r42 = r99;
        goto L139
    L133:
        r41 = r98;
        goto L135
    L129:
        r0 = r97;
        goto L131
    L125:
        r40 = r96;
        goto L127
    L121:
        r39 = r95;
        goto L123
    L117:
        r38 = r94;
        goto L119
    L113:
        r36 = r92;
        goto L115
    L109:
        r34 = r91;
        goto L111
    L105:
        r33 = r90;
        goto L106
    L101:
        r32 = r89;
        goto L103
    L97:
        r30 = r88;
        goto L99
    L93:
        r29 = r87;
        goto L94
    L89:
        r28 = r86;
        goto L91
    L85:
        r27 = r85;
        goto L87
    L81:
        r26 = r84;
        goto L83
    L77:
        r24 = r83;
        goto L79
    L73:
        r23 = r82;
        goto L75
    L69:
        r22 = r81;
        goto L71
    L65:
        r136 = r80;
        goto L67
    L61:
        r21 = r79;
        goto L63
    L57:
        r20 = r78;
        goto L58
    L53:
        r134 = r77;
        goto L55
    L49:
        r133 = r76;
        goto L51
    L45:
        r132 = r75;
        goto L47
    L41:
        r19 = r74;
        goto L43
    L37:
        r18 = r73;
        goto L39
    L33:
        r17 = r72;
        goto L35
    L29:
        r16 = r71;
        goto L31
    L25:
        r15 = r70;
        goto L27
    L21:
        r14 = r69;
        goto L23
    L17:
        r13 = r68;
        goto L19
    L13:
        r12 = r67;
        goto L15
    L9:
        r11 = r66;
        goto L11
    L5:
        r10 = r65;
        goto L7
    }
}
