package com.bytedance.android.ec.common.impl.sku.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.PriceComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u0082\u0001\b\u0086\b\u0018\u00002\u00020\u0001B±\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010*\u001a\u00020+\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0014\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u00106\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000107j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`8\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010:\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010>J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0011HÆ\u0003J\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\u0012\u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\n\u0010\u0094\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010OJ\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010OJ\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\n\u0010¤\u0001\u001a\u00020+HÆ\u0003J\u0012\u0010¥\u0001\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0014HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J*\u0010¬\u0001\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000107j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`8HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010:HÆ\u0003J\u0011\u0010®\u0001\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0002\u0010RJ\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0002\u0010RJ\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\n\u0010³\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\n\u0010µ\u0001\u001a\u00020\u0005HÆ\u0003JÄ\u0004\u0010¶\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010*\u001a\u00020+2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00142\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032(\b\u0002\u00106\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000107j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`82\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010·\u0001J\u0015\u0010¸\u0001\u001a\u00020+2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\n\u0010º\u0001\u001a\u00020\u0011HÖ\u0001J\n\u0010»\u0001\u001a\u00020\u0003HÖ\u0001R\u0018\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0018\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010BR\u0018\u00109\u001a\u0004\u0018\u00010:8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010DR\u001a\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010JR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010BR\u001a\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\bM\u0010JR\u001a\u0010&\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010P\u001a\u0004\bN\u0010OR\u001a\u0010<\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010S\u001a\u0004\bQ\u0010RR\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0018\u0010.\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010BR\u001a\u0010 \u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010P\u001a\u0004\bY\u0010OR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010BR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010BR\u001a\u0010'\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\b\\\u0010JR\"\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\b]\u0010J\"\u0004\b^\u0010_R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010B\"\u0004\ba\u0010bR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001a\u0010;\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010S\u001a\u0004\be\u0010RR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010B\"\u0004\bg\u0010bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010BR\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010BR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\bl\u0010JR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010BR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010j\"\u0004\bs\u0010tR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010BR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010j\"\u0004\bw\u0010tR\u0018\u00100\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0016\u0010\u0017\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010oR\u0018\u0010=\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010BR\u001a\u0010)\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\b|\u0010JR6\u00106\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000107j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`88\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0018\u00105\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010BR\u001a\u00103\u001a\u0004\u0018\u0001048\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010K\u001a\u0005\b\u0082\u0001\u0010JR\u0019\u00102\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010BR \u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010j\"\u0005\b\u0085\u0001\u0010tR\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010K\u001a\u0005\b\u0086\u0001\u0010JR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010BR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010K\u001a\u0005\b\u0088\u0001\u0010J¨\u0006¼\u0001"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfo;", "Ljava/io/Serializable;", "id", "", "stockNum", "", "unpayNum", "price", "originPrice", "discountPrice", "discountPriceText", "userLimit", "lowerLimit", "upperLimitToast", "lowerLimitToast", "limitText", "nowStock", "", "skuType", "benefitLabels", "", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "campaignPriceHeader", "priceHeaderStyle", "newBonusText", "marketPrice", "epInfo", "", "presellDelayDesc", "deliveryDelayDesc", "deliveryDelayBackground", "delayDescIcon", "delayDescStyle", "campaignStartTime", "campaignEndTime", "activityIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "atmosphereHeader", "campaignSubType", "depositPrice", "buttonLabel", "serverTime", "canSelect", "", "buttons", "Lcom/bytedance/android/ec/model/sku/SkuBottomButtons;", "carAdaptComponent", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "priceComponent", "Lcom/bytedance/android/ec/model/sku/PriceComponent;", "stockDesc", "skuStatusDetail", "Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "skuExtra", "showEventTrack", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "buttonTipComponent", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "hideTradeIn", "canAddCart", "promiseType", "(Ljava/lang/String;JLjava/lang/Long;JJLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;ZLjava/util/List;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/PriceComponent;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;Ljava/lang/String;Ljava/util/HashMap;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getActivityIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getAtmosphereHeader", "()Ljava/lang/String;", "getBenefitLabels", "()Ljava/util/List;", "getButtonLabel", "getButtonTipComponent", "()Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "getButtons", "getCampaignEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCampaignPriceHeader", "getCampaignStartTime", "getCampaignSubType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCanAddCart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanSelect", "()Z", "getCarAdaptComponent", "()Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getDelayDescIcon", "getDelayDescStyle", "getDeliveryDelayBackground", "getDeliveryDelayDesc", "getDepositPrice", "getDiscountPrice", "setDiscountPrice", "(Ljava/lang/Long;)V", "getDiscountPriceText", "setDiscountPriceText", "(Ljava/lang/String;)V", "getEpInfo", "()Ljava/lang/Object;", "getHideTradeIn", "getId", "setId", "getLimitText", "getLowerLimit", "()J", "getLowerLimitToast", "getMarketPrice", "getNewBonusText", "getNowStock", "()I", "setNowStock", "(I)V", "getOriginPrice", "setOriginPrice", "(J)V", "getPresellDelayDesc", "getPrice", "setPrice", "getPriceComponent", "()Lcom/bytedance/android/ec/model/sku/PriceComponent;", "getPriceHeaderStyle", "getPromiseType", "getServerTime", "getShowEventTrack", "()Ljava/util/HashMap;", "getSkuExtra", "getSkuStatusDetail", "()Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "getSkuType", "getStockDesc", "getStockNum", "setStockNum", "getUnpayNum", "getUpperLimitToast", "getUserLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLjava/lang/Long;JJLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;ZLjava/util/List;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/PriceComponent;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;Ljava/lang/String;Ljava/util/HashMap;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfo;", "equals", "other", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuItemInfo implements Serializable {

    @SerializedName("activity_icon")
    private final ECUrlModel activityIcon;

    @SerializedName("atmosphere_header")
    private final String atmosphereHeader;

    @SerializedName("benefit_labels")
    private final List<PromotionBenefitLabel> benefitLabels;

    @SerializedName("button_label")
    private final String buttonLabel;

    @SerializedName("button_tip")
    private final ButtonTipComponent buttonTipComponent;

    @SerializedName("buttons")
    private final List<SkuBottomButtons> buttons;

    @SerializedName("campaign_end_time")
    private final Long campaignEndTime;

    @SerializedName("campaign_price_header")
    private final String campaignPriceHeader;

    @SerializedName("campaign_start_time")
    private final Long campaignStartTime;

    @SerializedName("campaign_sub_type")
    private final Integer campaignSubType;

    @SerializedName("can_add_cart")
    private final Boolean canAddCart;

    @SerializedName("can_select")
    private final boolean canSelect;

    @SerializedName("car_adapt_component")
    private final CarAdaptComponent carAdaptComponent;

    @SerializedName("delay_desc_icon")
    private final String delayDescIcon;

    @SerializedName("delay_desc_style")
    private final Integer delayDescStyle;

    @SerializedName("delivery_delay_background")
    private final String deliveryDelayBackground;

    @SerializedName("delivery_delay_desc")
    private final String deliveryDelayDesc;

    @SerializedName("deposit_price")
    private final Long depositPrice;

    @SerializedName("discount_price")
    private Long discountPrice;

    @SerializedName("discount_price_header")
    private String discountPriceText;

    @SerializedName("addition_modules_data")
    private final Object epInfo;

    @SerializedName("hide_trade_in")
    private final Boolean hideTradeIn;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName(a.KEY_SKU_ID)
    private String f16id;

    @SerializedName("limit_text")
    private final String limitText;

    @SerializedName("user_min_limit")
    private final long lowerLimit;

    @SerializedName("min_limit_toast")
    private final String lowerLimitToast;

    @SerializedName(a.KEY_REGULAR_PRICE)
    private final Long marketPrice;

    @SerializedName("new_bonus_text")
    private final String newBonusText;

    @SerializedName("now_stock")
    private int nowStock;

    @SerializedName("origin_price")
    private long originPrice;

    @SerializedName("presell_delay_desc")
    private final String presellDelayDesc;

    @SerializedName("price")
    private long price;

    @SerializedName("price_component")
    private final PriceComponent priceComponent;

    @SerializedName("price_header_style")
    private final int priceHeaderStyle;

    @SerializedName("promise_type")
    private final String promiseType;

    @SerializedName("server_time")
    private final Long serverTime;

    @SerializedName("show_event_track")
    private final HashMap<String, String> showEventTrack;

    @SerializedName("sku_extra")
    private final String skuExtra;

    @SerializedName("sku_status_detail")
    private final SkuStatusDetail skuStatusDetail;

    @SerializedName("sku_type")
    private final Long skuType;

    @SerializedName("stock_desc")
    private final String stockDesc;

    @SerializedName("stock_num")
    private long stockNum;

    @SerializedName("unpay_num")
    private final Long unpayNum;

    @SerializedName("limit_toast")
    private final String upperLimitToast;

    @SerializedName("user_limit")
    private final Long userLimit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuItemInfo copy$default(SkuItemInfo r17, String r18, long r19, Long r21, long r22, long r24, Long r26, String r27, Long r28, long r29, String r31, String r32, String r33, int r34, Long r35, List r36, String r37, int r38, String r39, Long r40, Object r41, String r42, String r43, String r44, String r45, Integer r46, Long r47, Long r48, ECUrlModel r49, String r50, Integer r51, Long r52, String r53, Long r54, boolean r55, List r56, CarAdaptComponent r57, PriceComponent r58, String r59, SkuStatusDetail r60, String r61, HashMap r62, ButtonTipComponent r63, Boolean r64, Boolean r65, String r66, int r67, int r68, Object r69) {
        if ((r67 & 1) == 0) goto L5;
        String r10 = r17.f16id;
    L7:
        if ((r67 & 2) == 0) goto L9;
        long r11 = r17.stockNum;
    L11:
        if ((r67 & 4) == 0) goto L13;
        Long r12 = r17.unpayNum;
    L15:
        if ((r67 & 8) == 0) goto L17;
        long r13 = r17.price;
    L19:
        if ((r67 & 16) == 0) goto L21;
        long r14 = r17.originPrice;
    L23:
        if ((r67 & 32) == 0) goto L25;
        Long r15 = r17.discountPrice;
    L27:
        if ((r67 & 64) == 0) goto L29;
        String r16 = r17.discountPriceText;
    L31:
        if ((r67 & 128) == 0) goto L33;
        Long r110 = r17.userLimit;
    L35:
        if ((r67 & 256) == 0) goto L37;
        long r111 = r17.lowerLimit;
    L38:
        long r210 = r111;
        if ((r67 & 512) == 0) goto L41;
        String r112 = r17.upperLimitToast;
    L43:
        if ((r67 & 1024) == 0) goto L45;
        String r113 = r17.lowerLimitToast;
    L46:
        String r310 = r113;
        if ((r67 & 2048) == 0) goto L49;
        String r114 = r17.limitText;
    L50:
        String r311 = r114;
        if ((r67 & 4096) == 0) goto L53;
        int r115 = r17.nowStock;
    L54:
        int r312 = r115;
        if ((r67 & 8192) == 0) goto L57;
        Long r116 = r17.skuType;
    L58:
        Long r313 = r116;
        if ((r67 & 16384) == 0) goto L61;
        List r117 = r17.benefitLabels;
    L62:
        List r314 = r117;
        if ((r67 & 32768) == 0) goto L65;
        String r118 = r17.campaignPriceHeader;
    L66:
        String r315 = r118;
        if ((r67 & 65536) == 0) goto L69;
        int r119 = r17.priceHeaderStyle;
    L70:
        int r316 = r119;
        if ((r67 & 131072) == 0) goto L73;
        String r120 = r17.newBonusText;
    L74:
        String r317 = r120;
        if ((r67 & 262144) == 0) goto L77;
        Long r121 = r17.marketPrice;
    L78:
        Long r410 = r121;
        if ((r67 & 524288) == 0) goto L81;
        Object r122 = r17.epInfo;
    L82:
        Object r411 = r122;
        if ((r67 & 1048576) == 0) goto L85;
        String r123 = r17.presellDelayDesc;
    L86:
        String r412 = r123;
        if ((r67 & 2097152) == 0) goto L89;
        String r124 = r17.deliveryDelayDesc;
    L90:
        String r413 = r124;
        if ((r67 & 4194304) == 0) goto L93;
        String r125 = r17.deliveryDelayBackground;
    L94:
        String r414 = r125;
        if ((r67 & 8388608) == 0) goto L97;
        String r126 = r17.delayDescIcon;
    L98:
        String r415 = r126;
        if ((r67 & 16777216) == 0) goto L101;
        Integer r127 = r17.delayDescStyle;
    L102:
        Integer r416 = r127;
        if ((r67 & 33554432) == 0) goto L105;
        Long r128 = r17.campaignStartTime;
    L106:
        Long r417 = r128;
        if ((r67 & 67108864) == 0) goto L109;
        Long r129 = r17.campaignEndTime;
    L110:
        Long r418 = r129;
        if ((r67 & 134217728) == 0) goto L113;
        ECUrlModel r130 = r17.activityIcon;
    L114:
        ECUrlModel r419 = r130;
        if ((r67 & 268435456) == 0) goto L117;
        String r131 = r17.atmosphereHeader;
    L118:
        String r510 = r131;
        if ((r67 & 536870912) == 0) goto L121;
        Integer r132 = r17.campaignSubType;
    L122:
        Integer r511 = r132;
        if ((r67 & 1073741824) == 0) goto L125;
        Long r133 = r17.depositPrice;
    L127:
        if ((r67 & Integer.MIN_VALUE) == 0) goto L129;
        String r1 = r17.buttonLabel;
    L130:
        String r512 = r1;
        if ((r68 & 1) == 0) goto L133;
        Long r20 = r17.serverTime;
    L134:
        Long r513 = r20;
        if ((r68 & 2) == 0) goto L137;
        boolean r23 = r17.canSelect;
    L138:
        boolean r514 = r23;
        if ((r68 & 4) == 0) goto L141;
        List r25 = r17.buttons;
    L142:
        List r515 = r25;
        if ((r68 & 8) == 0) goto L145;
        CarAdaptComponent r30 = r17.carAdaptComponent;
    L146:
        CarAdaptComponent r516 = r30;
        if ((r68 & 16) == 0) goto L149;
        PriceComponent r70 = r17.priceComponent;
    L150:
        PriceComponent r517 = r70;
        if ((r68 & 32) == 0) goto L153;
        String r71 = r17.stockDesc;
    L154:
        String r518 = r71;
        if ((r68 & 64) == 0) goto L157;
        SkuStatusDetail r72 = r17.skuStatusDetail;
    L158:
        SkuStatusDetail r610 = r72;
        if ((r68 & 128) == 0) goto L161;
        String r73 = r17.skuExtra;
    L162:
        String r611 = r73;
        if ((r68 & 256) == 0) goto L165;
        HashMap r74 = r17.showEventTrack;
    L166:
        HashMap r612 = r74;
        if ((r68 & 512) == 0) goto L169;
        ButtonTipComponent r75 = r17.buttonTipComponent;
    L170:
        ButtonTipComponent r613 = r75;
        if ((r68 & 1024) == 0) goto L173;
        Boolean r76 = r17.hideTradeIn;
    L174:
        Boolean r614 = r76;
        if ((r68 & 2048) == 0) goto L177;
        Boolean r77 = r17.canAddCart;
    L179:
        if ((r68 & 4096) == 0) goto L181;
        String r78 = r17.promiseType;
    L183:
        return r17.copy(r10, r11, r12, r13, r14, r15, r16, r110, r210, r112, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r133, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r77, r78);
    L181:
        r78 = r66;
        goto L183
    L177:
        r77 = r65;
        goto L179
    L173:
        r76 = r64;
        goto L174
    L169:
        r75 = r63;
        goto L170
    L165:
        r74 = r62;
        goto L166
    L161:
        r73 = r61;
        goto L162
    L157:
        r72 = r60;
        goto L158
    L153:
        r71 = r59;
        goto L154
    L149:
        r70 = r58;
        goto L150
    L145:
        r30 = r57;
        goto L146
    L141:
        r25 = r56;
        goto L142
    L137:
        r23 = r55;
        goto L138
    L133:
        r20 = r54;
        goto L134
    L129:
        r1 = r53;
        goto L130
    L125:
        r133 = r52;
        goto L127
    L121:
        r132 = r51;
        goto L122
    L117:
        r131 = r50;
        goto L118
    L113:
        r130 = r49;
        goto L114
    L109:
        r129 = r48;
        goto L110
    L105:
        r128 = r47;
        goto L106
    L101:
        r127 = r46;
        goto L102
    L97:
        r126 = r45;
        goto L98
    L93:
        r125 = r44;
        goto L94
    L89:
        r124 = r43;
        goto L90
    L85:
        r123 = r42;
        goto L86
    L81:
        r122 = r41;
        goto L82
    L77:
        r121 = r40;
        goto L78
    L73:
        r120 = r39;
        goto L74
    L69:
        r119 = r38;
        goto L70
    L65:
        r118 = r37;
        goto L66
    L61:
        r117 = r36;
        goto L62
    L57:
        r116 = r35;
        goto L58
    L53:
        r115 = r34;
        goto L54
    L49:
        r114 = r33;
        goto L50
    L45:
        r113 = r32;
        goto L46
    L41:
        r112 = r31;
        goto L43
    L37:
        r111 = r29;
        goto L38
    L33:
        r110 = r28;
        goto L35
    L29:
        r16 = r27;
        goto L31
    L25:
        r15 = r26;
        goto L27
    L21:
        r14 = r24;
        goto L23
    L17:
        r13 = r22;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    public final String component1() {
        return this.f16id;
    }

    public final String component10() {
        return this.upperLimitToast;
    }

    public final String component11() {
        return this.lowerLimitToast;
    }

    public final String component12() {
        return this.limitText;
    }

    public final int component13() {
        return this.nowStock;
    }

    public final Long component14() {
        return this.skuType;
    }

    public final List<PromotionBenefitLabel> component15() {
        return this.benefitLabels;
    }

    public final String component16() {
        return this.campaignPriceHeader;
    }

    public final int component17() {
        return this.priceHeaderStyle;
    }

    public final String component18() {
        return this.newBonusText;
    }

    public final Long component19() {
        return this.marketPrice;
    }

    public final long component2() {
        return this.stockNum;
    }

    public final Object component20() {
        return this.epInfo;
    }

    public final String component21() {
        return this.presellDelayDesc;
    }

    public final String component22() {
        return this.deliveryDelayDesc;
    }

    public final String component23() {
        return this.deliveryDelayBackground;
    }

    public final String component24() {
        return this.delayDescIcon;
    }

    public final Integer component25() {
        return this.delayDescStyle;
    }

    public final Long component26() {
        return this.campaignStartTime;
    }

    public final Long component27() {
        return this.campaignEndTime;
    }

    public final ECUrlModel component28() {
        return this.activityIcon;
    }

    public final String component29() {
        return this.atmosphereHeader;
    }

    public final Long component3() {
        return this.unpayNum;
    }

    public final Integer component30() {
        return this.campaignSubType;
    }

    public final Long component31() {
        return this.depositPrice;
    }

    public final String component32() {
        return this.buttonLabel;
    }

    public final Long component33() {
        return this.serverTime;
    }

    public final boolean component34() {
        return this.canSelect;
    }

    public final List<SkuBottomButtons> component35() {
        return this.buttons;
    }

    public final CarAdaptComponent component36() {
        return this.carAdaptComponent;
    }

    public final PriceComponent component37() {
        return this.priceComponent;
    }

    public final String component38() {
        return this.stockDesc;
    }

    public final SkuStatusDetail component39() {
        return this.skuStatusDetail;
    }

    public final long component4() {
        return this.price;
    }

    public final String component40() {
        return this.skuExtra;
    }

    public final HashMap<String, String> component41() {
        return this.showEventTrack;
    }

    public final ButtonTipComponent component42() {
        return this.buttonTipComponent;
    }

    public final Boolean component43() {
        return this.hideTradeIn;
    }

    public final Boolean component44() {
        return this.canAddCart;
    }

    public final String component45() {
        return this.promiseType;
    }

    public final long component5() {
        return this.originPrice;
    }

    public final Long component6() {
        return this.discountPrice;
    }

    public final String component7() {
        return this.discountPriceText;
    }

    public final Long component8() {
        return this.userLimit;
    }

    public final long component9() {
        return this.lowerLimit;
    }

    public final SkuItemInfo copy(String r52, long r53, Long r55, long r56, long r58, Long r60, String r61, Long r62, long r63, String r65, String r66, String r67, int r68, Long r69, List<PromotionBenefitLabel> r70, String r71, int r72, String r73, Long r74, Object r75, String r76, String r77, String r78, String r79, Integer r80, Long r81, Long r82, ECUrlModel r83, String r84, Integer r85, Long r86, String r87, Long r88, boolean r89, List<SkuBottomButtons> r90, CarAdaptComponent r91, PriceComponent r92, String r93, SkuStatusDetail r94, String r95, HashMap<String, String> r96, ButtonTipComponent r97, Boolean r98, Boolean r99, String r100) {
        Intrinsics.checkNotNullParameter(r61, "discountPriceText");
        Intrinsics.checkNotNullParameter(r71, "campaignPriceHeader");
        return new SkuItemInfo(r52, r53, r55, r56, r58, r60, r61, r62, r63, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof SkuItemInfo) == false) goto L96;
        SkuItemInfo r11 = (SkuItemInfo) r10;
        if (Intrinsics.areEqual(this.f16id, r11.f16id) == true) goto L8;
        return false;
    L8:
        if (this.stockNum == r11.stockNum) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.unpayNum, r11.unpayNum) == true) goto L12;
        return false;
    L12:
        if (this.price == r11.price) goto L14;
        return false;
    L14:
        if (this.originPrice == r11.originPrice) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.discountPrice, r11.discountPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountPriceText, r11.discountPriceText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.userLimit, r11.userLimit) == true) goto L22;
        return false;
    L22:
        if (this.lowerLimit == r11.lowerLimit) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.upperLimitToast, r11.upperLimitToast) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.lowerLimitToast, r11.lowerLimitToast) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.limitText, r11.limitText) == true) goto L30;
        return false;
    L30:
        if (this.nowStock == r11.nowStock) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.skuType, r11.skuType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.benefitLabels, r11.benefitLabels) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.campaignPriceHeader, r11.campaignPriceHeader) == true) goto L38;
        return false;
    L38:
        if (this.priceHeaderStyle == r11.priceHeaderStyle) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.newBonusText, r11.newBonusText) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.marketPrice, r11.marketPrice) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.epInfo, r11.epInfo) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.presellDelayDesc, r11.presellDelayDesc) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.deliveryDelayDesc, r11.deliveryDelayDesc) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.deliveryDelayBackground, r11.deliveryDelayBackground) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.delayDescIcon, r11.delayDescIcon) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.delayDescStyle, r11.delayDescStyle) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.campaignStartTime, r11.campaignStartTime) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.campaignEndTime, r11.campaignEndTime) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.activityIcon, r11.activityIcon) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.atmosphereHeader, r11.atmosphereHeader) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.campaignSubType, r11.campaignSubType) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.depositPrice, r11.depositPrice) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.buttonLabel, r11.buttonLabel) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.serverTime, r11.serverTime) == true) goto L72;
        return false;
    L72:
        if (this.canSelect == r11.canSelect) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.buttons, r11.buttons) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.carAdaptComponent, r11.carAdaptComponent) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.priceComponent, r11.priceComponent) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.stockDesc, r11.stockDesc) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.skuStatusDetail, r11.skuStatusDetail) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.skuExtra, r11.skuExtra) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.showEventTrack, r11.showEventTrack) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.buttonTipComponent, r11.buttonTipComponent) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.hideTradeIn, r11.hideTradeIn) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.canAddCart, r11.canAddCart) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.promiseType, r11.promiseType) == true) goto L145;
        return false;
    L145:
        return true;
    L96:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v68, types: [int] */
    /* JADX WARN: Type inference failed for: r2v131 */
    /* JADX WARN: Type inference failed for: r2v158 */
    /* JADX WARN: Type inference failed for: r2v89, types: [int] */
    public int hashCode() {
        String r0 = this.f16id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        long r11 = this.stockNum;
        int r12 = ((r10 * 31) + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        Long r13 = this.unpayNum;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (r12 + r14) * 31;
        long r16 = this.price;
        int r17 = (r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31;
        long r18 = this.originPrice;
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        Long r20 = this.discountPrice;
        if (r20 == null) goto L13;
        int r21 = r20.hashCode();
    L14:
        int r22 = (r19 + r21) * 31;
        String r23 = this.discountPriceText;
        if (r23 == null) goto L17;
        int r24 = r23.hashCode();
    L18:
        int r25 = (r22 + r24) * 31;
        Long r26 = this.userLimit;
        if (r26 == null) goto L21;
        int r27 = r26.hashCode();
    L22:
        int r28 = (r25 + r27) * 31;
        long r29 = this.lowerLimit;
        int r30 = (r28 + ((int) (r29 ^ (r29 >>> 32)))) * 31;
        String r31 = this.upperLimitToast;
        if (r31 == null) goto L25;
        int r32 = r31.hashCode();
    L26:
        int r33 = (r30 + r32) * 31;
        String r34 = this.lowerLimitToast;
        if (r34 == null) goto L29;
        int r35 = r34.hashCode();
    L30:
        int r36 = (r33 + r35) * 31;
        String r37 = this.limitText;
        if (r37 == null) goto L33;
        int r38 = r37.hashCode();
    L34:
        int r39 = (((r36 + r38) * 31) + this.nowStock) * 31;
        Long r40 = this.skuType;
        if (r40 == null) goto L37;
        int r41 = r40.hashCode();
    L38:
        int r42 = (r39 + r41) * 31;
        List<PromotionBenefitLabel> r43 = this.benefitLabels;
        if (r43 == null) goto L41;
        int r44 = r43.hashCode();
    L42:
        int r45 = (r42 + r44) * 31;
        String r46 = this.campaignPriceHeader;
        if (r46 == null) goto L45;
        int r47 = r46.hashCode();
    L46:
        int r48 = (((r45 + r47) * 31) + this.priceHeaderStyle) * 31;
        String r49 = this.newBonusText;
        if (r49 == null) goto L49;
        int r50 = r49.hashCode();
    L50:
        int r51 = (r48 + r50) * 31;
        Long r52 = this.marketPrice;
        if (r52 == null) goto L53;
        int r53 = r52.hashCode();
    L54:
        int r54 = (r51 + r53) * 31;
        Object r55 = this.epInfo;
        if (r55 == null) goto L57;
        int r56 = r55.hashCode();
    L58:
        int r57 = (r54 + r56) * 31;
        String r58 = this.presellDelayDesc;
        if (r58 == null) goto L61;
        int r59 = r58.hashCode();
    L62:
        int r60 = (r57 + r59) * 31;
        String r61 = this.deliveryDelayDesc;
        if (r61 == null) goto L65;
        int r62 = r61.hashCode();
    L66:
        int r63 = (r60 + r62) * 31;
        String r64 = this.deliveryDelayBackground;
        if (r64 == null) goto L69;
        int r65 = r64.hashCode();
    L70:
        int r66 = (r63 + r65) * 31;
        String r67 = this.delayDescIcon;
        if (r67 == null) goto L73;
        int r68 = r67.hashCode();
    L74:
        int r69 = (r66 + r68) * 31;
        Integer r70 = this.delayDescStyle;
        if (r70 == null) goto L77;
        int r71 = r70.hashCode();
    L78:
        int r72 = (r69 + r71) * 31;
        Long r73 = this.campaignStartTime;
        if (r73 == null) goto L81;
        int r74 = r73.hashCode();
    L82:
        int r75 = (r72 + r74) * 31;
        Long r76 = this.campaignEndTime;
        if (r76 == null) goto L85;
        int r77 = r76.hashCode();
    L86:
        int r78 = (r75 + r77) * 31;
        ECUrlModel r79 = this.activityIcon;
        if (r79 == null) goto L89;
        int r80 = r79.hashCode();
    L90:
        int r81 = (r78 + r80) * 31;
        String r82 = this.atmosphereHeader;
        if (r82 == null) goto L93;
        int r83 = r82.hashCode();
    L94:
        int r84 = (r81 + r83) * 31;
        Integer r85 = this.campaignSubType;
        if (r85 == null) goto L97;
        int r86 = r85.hashCode();
    L98:
        int r87 = (r84 + r86) * 31;
        Long r88 = this.depositPrice;
        if (r88 == null) goto L101;
        int r89 = r88.hashCode();
    L102:
        int r90 = (r87 + r89) * 31;
        String r91 = this.buttonLabel;
        if (r91 == null) goto L105;
        int r92 = r91.hashCode();
    L106:
        int r93 = (r90 + r92) * 31;
        Long r94 = this.serverTime;
        if (r94 == null) goto L109;
        int r95 = r94.hashCode();
    L110:
        int r96 = (r93 + r95) * 31;
        boolean r97 = this.canSelect;
        ?? r98 = r97;
        if (r97 == false) goto L113;
        r98 = 1;
    L113:
        int r99 = (r96 + r98) * 31;
        List<SkuBottomButtons> r100 = this.buttons;
        if (r100 == null) goto L116;
        int r101 = r100.hashCode();
    L117:
        int r102 = (r99 + r101) * 31;
        CarAdaptComponent r103 = this.carAdaptComponent;
        if (r103 == null) goto L120;
        int r104 = r103.hashCode();
    L121:
        int r105 = (r102 + r104) * 31;
        PriceComponent r106 = this.priceComponent;
        if (r106 == null) goto L124;
        int r107 = r106.hashCode();
    L125:
        int r108 = (r105 + r107) * 31;
        String r109 = this.stockDesc;
        if (r109 == null) goto L128;
        int r110 = r109.hashCode();
    L129:
        int r111 = (r108 + r110) * 31;
        SkuStatusDetail r112 = this.skuStatusDetail;
        if (r112 == null) goto L132;
        int r113 = r112.hashCode();
    L133:
        int r114 = (r111 + r113) * 31;
        String r115 = this.skuExtra;
        if (r115 == null) goto L136;
        int r116 = r115.hashCode();
    L137:
        int r117 = (r114 + r116) * 31;
        HashMap<String, String> r118 = this.showEventTrack;
        if (r118 == null) goto L140;
        int r119 = r118.hashCode();
    L141:
        int r120 = (r117 + r119) * 31;
        ButtonTipComponent r121 = this.buttonTipComponent;
        if (r121 == null) goto L144;
        int r122 = r121.hashCode();
    L145:
        int r123 = (r120 + r122) * 31;
        Boolean r124 = this.hideTradeIn;
        if (r124 == null) goto L148;
        int r125 = r124.hashCode();
    L149:
        int r126 = (r123 + r125) * 31;
        Boolean r127 = this.canAddCart;
        if (r127 == null) goto L152;
        int r128 = r127.hashCode();
    L153:
        int r129 = (r126 + r128) * 31;
        String r130 = this.promiseType;
        if (r130 == null) goto L157;
        r1 = r130.hashCode();
    L157:
        return r129 + r1;
    L152:
        r128 = 0;
        goto L153
    L148:
        r125 = 0;
        goto L149
    L144:
        r122 = 0;
        goto L145
    L140:
        r119 = 0;
        goto L141
    L136:
        r116 = 0;
        goto L137
    L132:
        r113 = 0;
        goto L133
    L128:
        r110 = 0;
        goto L129
    L124:
        r107 = 0;
        goto L125
    L120:
        r104 = 0;
        goto L121
    L116:
        r101 = 0;
        goto L117
    L109:
        r95 = 0;
        goto L110
    L105:
        r92 = 0;
        goto L106
    L101:
        r89 = 0;
        goto L102
    L97:
        r86 = 0;
        goto L98
    L93:
        r83 = 0;
        goto L94
    L89:
        r80 = 0;
        goto L90
    L85:
        r77 = 0;
        goto L86
    L81:
        r74 = 0;
        goto L82
    L77:
        r71 = 0;
        goto L78
    L73:
        r68 = 0;
        goto L74
    L69:
        r65 = 0;
        goto L70
    L65:
        r62 = 0;
        goto L66
    L61:
        r59 = 0;
        goto L62
    L57:
        r56 = 0;
        goto L58
    L53:
        r53 = 0;
        goto L54
    L49:
        r50 = 0;
        goto L50
    L45:
        r47 = 0;
        goto L46
    L41:
        r44 = 0;
        goto L42
    L37:
        r41 = 0;
        goto L38
    L33:
        r38 = 0;
        goto L34
    L29:
        r35 = 0;
        goto L30
    L25:
        r32 = 0;
        goto L26
    L21:
        r27 = 0;
        goto L22
    L17:
        r24 = 0;
        goto L18
    L13:
        r21 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "SkuItemInfo(id=" + this.f16id + ", stockNum=" + this.stockNum + ", unpayNum=" + this.unpayNum + ", price=" + this.price + ", originPrice=" + this.originPrice + ", discountPrice=" + this.discountPrice + ", discountPriceText=" + this.discountPriceText + ", userLimit=" + this.userLimit + ", lowerLimit=" + this.lowerLimit + ", upperLimitToast=" + this.upperLimitToast + ", lowerLimitToast=" + this.lowerLimitToast + ", limitText=" + this.limitText + ", nowStock=" + this.nowStock + ", skuType=" + this.skuType + ", benefitLabels=" + this.benefitLabels + ", campaignPriceHeader=" + this.campaignPriceHeader + ", priceHeaderStyle=" + this.priceHeaderStyle + ", newBonusText=" + this.newBonusText + ", marketPrice=" + this.marketPrice + ", epInfo=" + this.epInfo + ", presellDelayDesc=" + this.presellDelayDesc + ", deliveryDelayDesc=" + this.deliveryDelayDesc + ", deliveryDelayBackground=" + this.deliveryDelayBackground + ", delayDescIcon=" + this.delayDescIcon + ", delayDescStyle=" + this.delayDescStyle + ", campaignStartTime=" + this.campaignStartTime + ", campaignEndTime=" + this.campaignEndTime + ", activityIcon=" + this.activityIcon + ", atmosphereHeader=" + this.atmosphereHeader + ", campaignSubType=" + this.campaignSubType + ", depositPrice=" + this.depositPrice + ", buttonLabel=" + this.buttonLabel + ", serverTime=" + this.serverTime + ", canSelect=" + this.canSelect + ", buttons=" + this.buttons + ", carAdaptComponent=" + this.carAdaptComponent + ", priceComponent=" + this.priceComponent + ", stockDesc=" + this.stockDesc + ", skuStatusDetail=" + this.skuStatusDetail + ", skuExtra=" + this.skuExtra + ", showEventTrack=" + this.showEventTrack + ", buttonTipComponent=" + this.buttonTipComponent + ", hideTradeIn=" + this.hideTradeIn + ", canAddCart=" + this.canAddCart + ", promiseType=" + this.promiseType + ")";
    }

    public final ECUrlModel getActivityIcon() {
        return this.activityIcon;
    }

    public final String getAtmosphereHeader() {
        return this.atmosphereHeader;
    }

    public final List<PromotionBenefitLabel> getBenefitLabels() {
        return this.benefitLabels;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final ButtonTipComponent getButtonTipComponent() {
        return this.buttonTipComponent;
    }

    public final List<SkuBottomButtons> getButtons() {
        return this.buttons;
    }

    public final Long getCampaignEndTime() {
        return this.campaignEndTime;
    }

    public final String getCampaignPriceHeader() {
        return this.campaignPriceHeader;
    }

    public final Long getCampaignStartTime() {
        return this.campaignStartTime;
    }

    public final Integer getCampaignSubType() {
        return this.campaignSubType;
    }

    public final Boolean getCanAddCart() {
        return this.canAddCart;
    }

    public final boolean getCanSelect() {
        return this.canSelect;
    }

    public final CarAdaptComponent getCarAdaptComponent() {
        return this.carAdaptComponent;
    }

    public final String getDelayDescIcon() {
        return this.delayDescIcon;
    }

    public final Integer getDelayDescStyle() {
        return this.delayDescStyle;
    }

    public final String getDeliveryDelayBackground() {
        return this.deliveryDelayBackground;
    }

    public final String getDeliveryDelayDesc() {
        return this.deliveryDelayDesc;
    }

    public final Long getDepositPrice() {
        return this.depositPrice;
    }

    public final Long getDiscountPrice() {
        return this.discountPrice;
    }

    public final String getDiscountPriceText() {
        return this.discountPriceText;
    }

    public final Object getEpInfo() {
        return this.epInfo;
    }

    public final Boolean getHideTradeIn() {
        return this.hideTradeIn;
    }

    public final String getId() {
        return this.f16id;
    }

    public final String getLimitText() {
        return this.limitText;
    }

    public final long getLowerLimit() {
        return this.lowerLimit;
    }

    public final String getLowerLimitToast() {
        return this.lowerLimitToast;
    }

    public final Long getMarketPrice() {
        return this.marketPrice;
    }

    public final String getNewBonusText() {
        return this.newBonusText;
    }

    public final int getNowStock() {
        return this.nowStock;
    }

    public final long getOriginPrice() {
        return this.originPrice;
    }

    public final String getPresellDelayDesc() {
        return this.presellDelayDesc;
    }

    public final long getPrice() {
        return this.price;
    }

    public final PriceComponent getPriceComponent() {
        return this.priceComponent;
    }

    public final int getPriceHeaderStyle() {
        return this.priceHeaderStyle;
    }

    public final String getPromiseType() {
        return this.promiseType;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public final HashMap<String, String> getShowEventTrack() {
        return this.showEventTrack;
    }

    public final String getSkuExtra() {
        return this.skuExtra;
    }

    public final SkuStatusDetail getSkuStatusDetail() {
        return this.skuStatusDetail;
    }

    public final Long getSkuType() {
        return this.skuType;
    }

    public final String getStockDesc() {
        return this.stockDesc;
    }

    public final long getStockNum() {
        return this.stockNum;
    }

    public final Long getUnpayNum() {
        return this.unpayNum;
    }

    public final String getUpperLimitToast() {
        return this.upperLimitToast;
    }

    public final Long getUserLimit() {
        return this.userLimit;
    }

    public final void setDiscountPrice(Long r1) {
        this.discountPrice = r1;
    }

    public final void setDiscountPriceText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.discountPriceText = r10;
    }

    public final void setId(String r1) {
        this.f16id = r1;
    }

    public final void setNowStock(int r1) {
        this.nowStock = r1;
    }

    public final void setOriginPrice(long r1) {
        this.originPrice = r1;
    }

    public final void setPrice(long r1) {
        this.price = r1;
    }

    public final void setStockNum(long r1) {
        this.stockNum = r1;
    }

    public SkuItemInfo(String r10, long r11, Long r12, long r13, long r14, Long r15, String r16, Long r17, long r18, String r19, String r20, String r21, int r22, Long r23, List<PromotionBenefitLabel> r24, String r25, int r26, String r27, Long r28, Object r29, String r30, String r31, String r32, String r33, Integer r34, Long r35, Long r36, ECUrlModel r37, String r38, Integer r39, Long r40, String r41, Long r42, boolean r43, List<SkuBottomButtons> r44, CarAdaptComponent r45, PriceComponent r46, String r47, SkuStatusDetail r48, String r49, HashMap<String, String> r50, ButtonTipComponent r51, Boolean r52, Boolean r53, String r54) {
        Intrinsics.checkNotNullParameter(r16, "discountPriceText");
        Intrinsics.checkNotNullParameter(r25, "campaignPriceHeader");
        this.f16id = r10;
        this.stockNum = r11;
        this.unpayNum = r12;
        this.price = r13;
        this.originPrice = r14;
        this.discountPrice = r15;
        this.discountPriceText = r16;
        this.userLimit = r17;
        this.lowerLimit = r18;
        this.upperLimitToast = r19;
        this.lowerLimitToast = r20;
        this.limitText = r21;
        this.nowStock = r22;
        this.skuType = r23;
        this.benefitLabels = r24;
        this.campaignPriceHeader = r25;
        this.priceHeaderStyle = r26;
        this.newBonusText = r27;
        this.marketPrice = r28;
        this.epInfo = r29;
        this.presellDelayDesc = r30;
        this.deliveryDelayDesc = r31;
        this.deliveryDelayBackground = r32;
        this.delayDescIcon = r33;
        this.delayDescStyle = r34;
        this.campaignStartTime = r35;
        this.campaignEndTime = r36;
        this.activityIcon = r37;
        this.atmosphereHeader = r38;
        this.campaignSubType = r39;
        this.depositPrice = r40;
        this.buttonLabel = r41;
        this.serverTime = r42;
        this.canSelect = r43;
        this.buttons = r44;
        this.carAdaptComponent = r45;
        this.priceComponent = r46;
        this.stockDesc = r47;
        this.skuStatusDetail = r48;
        this.skuExtra = r49;
        this.showEventTrack = r50;
        this.buttonTipComponent = r51;
        this.hideTradeIn = r52;
        this.canAddCart = r53;
        this.promiseType = r54;
    }

    public /* synthetic */ SkuItemInfo(String r55, long r56, Long r58, long r59, long r61, Long r63, String r64, Long r65, long r66, String r68, String r69, String r70, int r71, Long r72, List r73, String r74, int r75, String r76, Long r77, Object r78, String r79, String r80, String r81, String r82, Integer r83, Long r84, Long r85, ECUrlModel r86, String r87, Integer r88, Long r89, String r90, Long r91, boolean r92, List r93, CarAdaptComponent r94, PriceComponent r95, String r96, SkuStatusDetail r97, String r98, HashMap r99, ButtonTipComponent r100, Boolean r101, Boolean r102, String r103, int r104, int r105, DefaultConstructorMarker r106) {
        if ((r104 & 4) == 0) goto L5;
        Long r10 = null;
    L7:
        if ((r104 & 32) == 0) goto L9;
        Long r13 = null;
    L11:
        if ((r104 & 64) == 0) goto L13;
        String r14 = "";
    L15:
        if ((r104 & 128) == 0) goto L17;
        Long r15 = null;
    L19:
        if ((r104 & 256) == 0) goto L21;
        long r16 = 1;
    L23:
        if ((r104 & 512) == 0) goto L25;
        String r18 = null;
    L27:
        if ((r104 & 1024) == 0) goto L29;
        String r19 = null;
    L31:
        if ((r104 & 2048) == 0) goto L33;
        String r20 = null;
    L35:
        if ((r104 & 4096) == 0) goto L37;
        int r21 = -1;
    L39:
        if ((r104 & 8192) == 0) goto L41;
        Long r22 = null;
    L43:
        if ((r104 & 16384) == 0) goto L45;
        List r23 = null;
    L47:
        if ((32768 & r104) == 0) goto L49;
        String r24 = "";
    L51:
        if ((65536 & r104) == 0) goto L53;
        int r25 = -1;
    L55:
        if ((131072 & r104) == 0) goto L57;
        String r26 = null;
    L59:
        if ((262144 & r104) == 0) goto L61;
        Long r27 = null;
    L63:
        if ((524288 & r104) == 0) goto L65;
        Object r28 = null;
    L67:
        if ((1048576 & r104) == 0) goto L69;
        String r29 = null;
    L71:
        if ((2097152 & r104) == 0) goto L73;
        String r30 = null;
    L75:
        if ((4194304 & r104) == 0) goto L77;
        String r31 = null;
    L79:
        if ((8388608 & r104) == 0) goto L81;
        String r32 = null;
    L83:
        if ((16777216 & r104) == 0) goto L85;
        Integer r33 = null;
    L87:
        if ((33554432 & r104) == 0) goto L89;
        Long r34 = null;
    L91:
        if ((67108864 & r104) == 0) goto L93;
        Long r35 = null;
    L95:
        if ((134217728 & r104) == 0) goto L97;
        ECUrlModel r36 = null;
    L99:
        if ((268435456 & r104) == 0) goto L101;
        String r37 = null;
    L103:
        if ((536870912 & r104) == 0) goto L105;
        Integer r38 = null;
    L107:
        if ((1073741824 & r104) == 0) goto L109;
        Long r39 = null;
    L111:
        if ((r104 & Integer.MIN_VALUE) == 0) goto L113;
        String r40 = null;
    L115:
        if ((r105 & 1) == 0) goto L117;
        Long r41 = null;
    L119:
        if ((r105 & 2) == 0) goto L121;
        boolean r42 = false;
    L123:
        if ((r105 & 4) == 0) goto L125;
        List r43 = null;
    L127:
        if ((r105 & 8) == 0) goto L129;
        CarAdaptComponent r44 = null;
    L131:
        if ((r105 & 16) == 0) goto L133;
        PriceComponent r45 = null;
    L135:
        if ((r105 & 32) == 0) goto L137;
        String r46 = null;
    L139:
        if ((r105 & 64) == 0) goto L141;
        SkuStatusDetail r47 = null;
    L143:
        if ((r105 & 128) == 0) goto L145;
        String r48 = null;
    L147:
        if ((r105 & 256) == 0) goto L149;
        HashMap r49 = null;
    L151:
        if ((r105 & 512) == 0) goto L153;
        ButtonTipComponent r50 = null;
    L155:
        if ((r105 & 1024) == 0) goto L157;
        Boolean r51 = Boolean.FALSE;
    L159:
        if ((r105 & 2048) == 0) goto L161;
        Boolean r52 = Boolean.FALSE;
    L163:
        if ((r105 & 4096) == 0) goto L165;
        String r53 = null;
    L166:
        this(r55, r56, r10, r59, r61, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53);
        return;
    L165:
        r53 = r103;
        goto L166
    L161:
        r52 = r102;
        goto L163
    L157:
        r51 = r101;
        goto L159
    L153:
        r50 = r100;
        goto L155
    L149:
        r49 = r99;
        goto L151
    L145:
        r48 = r98;
        goto L147
    L141:
        r47 = r97;
        goto L143
    L137:
        r46 = r96;
        goto L139
    L133:
        r45 = r95;
        goto L135
    L129:
        r44 = r94;
        goto L131
    L125:
        r43 = r93;
        goto L127
    L121:
        r42 = r92;
        goto L123
    L117:
        r41 = r91;
        goto L119
    L113:
        r40 = r90;
        goto L115
    L109:
        r39 = r89;
        goto L111
    L105:
        r38 = r88;
        goto L107
    L101:
        r37 = r87;
        goto L103
    L97:
        r36 = r86;
        goto L99
    L93:
        r35 = r85;
        goto L95
    L89:
        r34 = r84;
        goto L91
    L85:
        r33 = r83;
        goto L87
    L81:
        r32 = r82;
        goto L83
    L77:
        r31 = r81;
        goto L79
    L73:
        r30 = r80;
        goto L75
    L69:
        r29 = r79;
        goto L71
    L65:
        r28 = r78;
        goto L67
    L61:
        r27 = r77;
        goto L63
    L57:
        r26 = r76;
        goto L59
    L53:
        r25 = r75;
        goto L55
    L49:
        r24 = r74;
        goto L51
    L45:
        r23 = r73;
        goto L47
    L41:
        r22 = r72;
        goto L43
    L37:
        r21 = r71;
        goto L39
    L33:
        r20 = r70;
        goto L35
    L29:
        r19 = r69;
        goto L31
    L25:
        r18 = r68;
        goto L27
    L21:
        r16 = r66;
        goto L23
    L17:
        r15 = r65;
        goto L19
    L13:
        r14 = r64;
        goto L15
    L9:
        r13 = r63;
        goto L11
    L5:
        r10 = r58;
        goto L7
    }
}
