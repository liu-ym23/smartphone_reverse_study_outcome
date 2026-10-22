package com.bytedance.android.ec.common.impl.sku.model;

import android.os.SystemClock;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\bÕ\u0001\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020.\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010J\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010Kj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`L\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010RJ\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Û\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Ü\u0001\u001a\u00020\u0011HÆ\u0003J\u0012\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0012\u0010Þ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\n\u0010ß\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010à\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010á\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010â\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\n\u0010ã\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010ä\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010å\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010æ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ç\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010è\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010é\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010]J\n\u0010ê\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010ë\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010ì\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010í\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010î\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0011\u0010ï\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010]J\n\u0010ð\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ò\u0001\u001a\u00020\u0005HÆ\u0003J\u0012\u0010ó\u0001\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+HÆ\u0003J\n\u0010ô\u0001\u001a\u00020.HÆ\u0003J\n\u0010õ\u0001\u001a\u00020.HÆ\u0003J\f\u0010ö\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\u0012\u0010÷\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\f\u0010ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010ù\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010ú\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010û\u0001\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010ü\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010ý\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\f\u0010þ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0080\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\u0011\u0010\u0081\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\n\u0010\u0084\u0002\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0087\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0012\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0012\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\u0011\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010]J\f\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008e\u0002\u001a\u0004\u0018\u00010HHÆ\u0003J\u0012\u0010\u008f\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\f\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J*\u0010\u0091\u0002\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010Kj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`LHÆ\u0003J\f\u0010\u0092\u0002\u001a\u0004\u0018\u00010NHÆ\u0003J\u0011\u0010\u0093\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\u0011\u0010\u0094\u0002\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0002\u0010rJ\f\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0096\u0002\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0003\u0010\u0081\u0001J\n\u0010\u0098\u0002\u001a\u00020\u0005HÆ\u0003Jª\u0006\u0010\u0099\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010'\u001a\u00020\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010)\u001a\u00020\u00052\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00105\u001a\u0004\u0018\u00010.2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010:\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010J\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010Kj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u009a\u0002J\u0015\u0010\u009b\u0002\u001a\u00020.2\t\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\n\u0010\u009d\u0002\u001a\u00020\u0011HÖ\u0001J\u0007\u0010\u009e\u0002\u001a\u00020.J\u0007\u0010\u009f\u0002\u001a\u00020.J\u0007\u0010 \u0002\u001a\u00020.J\u0007\u0010¡\u0002\u001a\u00020.J\n\u0010¢\u0002\u001a\u00020\u0003HÖ\u0001R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001e\u0010E\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010`\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010[\"\u0004\be\u0010fR\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bg\u0010[R\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+¢\u0006\b\n\u0000\u001a\u0004\bl\u0010bR\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bm\u0010WR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010[R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bo\u0010WR\u0015\u0010&\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010`\u001a\u0004\bp\u0010]R\u0015\u0010P\u001a\u0004\u0018\u00010.¢\u0006\n\n\u0002\u0010s\u001a\u0004\bq\u0010rR\u001a\u0010t\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010[R\u0015\u0010 \u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010`\u001a\u0004\b|\u0010]R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010[R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b~\u0010[R\u0011\u0010'\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010WR#\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010[\"\u0005\b\u0086\u0001\u0010fR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R#\u00102\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0089\u0001\u0010\u0081\u0001\"\u0006\b\u008a\u0001\u0010\u0083\u0001R!\u00105\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0013\n\u0002\u0010s\u001a\u0005\b\u008b\u0001\u0010r\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001e\u00103\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010[\"\u0005\b\u008f\u0001\u0010fR\u001e\u00104\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010[\"\u0005\b\u0091\u0001\u0010fR\u001e\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010[\"\u0005\b\u0093\u0001\u0010fR\u0016\u0010O\u001a\u0004\u0018\u00010.¢\u0006\u000b\n\u0002\u0010s\u001a\u0005\b\u0094\u0001\u0010rR#\u0010D\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0095\u0001\u0010\u0081\u0001\"\u0006\b\u0096\u0001\u0010\u0083\u0001R#\u0010C\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u0097\u0001\u0010\u0081\u0001\"\u0006\b\u0098\u0001\u0010\u0083\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010[\"\u0005\b\u009a\u0001\u0010fR\u001f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010[\"\u0005\b\u009d\u0001\u0010fR\u0011\u0010/\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u0010vR\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b-\u0010vR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010[R\u0012\u0010\f\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u009f\u0001\u0010WR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010[R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\r\n\u0003\u0010\u0084\u0001\u001a\u0006\b¡\u0001\u0010\u0081\u0001R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010[R\u001e\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u001c\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010W\"\u0005\b¨\u0001\u0010YR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010[R\u001c\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010W\"\u0005\b«\u0001\u0010YR\u0013\u0010\u0017\u001a\u00020\u0011¢\u0006\n\n\u0000\u001a\u0006\b¬\u0001\u0010¤\u0001R#\u0010B\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b\u00ad\u0001\u0010\u0081\u0001\"\u0006\b®\u0001\u0010\u0083\u0001R\u001e\u0010Q\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010[\"\u0005\b°\u0001\u0010fR#\u0010=\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b±\u0001\u0010\u0081\u0001\"\u0006\b²\u0001\u0010\u0083\u0001R!\u0010@\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0013\n\u0002\u0010s\u001a\u0005\b³\u0001\u0010r\"\u0006\b´\u0001\u0010\u008d\u0001R\u001e\u0010>\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010[\"\u0005\b¶\u0001\u0010fR\u001e\u0010?\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010[\"\u0005\b¸\u0001\u0010fR\u001e\u0010A\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010[\"\u0005\bº\u0001\u0010fR#\u00107\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0084\u0001\u001a\u0006\b»\u0001\u0010\u0081\u0001\"\u0006\b¼\u0001\u0010\u0083\u0001R!\u0010;\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0013\n\u0002\u0010s\u001a\u0005\b½\u0001\u0010r\"\u0006\b¾\u0001\u0010\u008d\u0001R!\u0010:\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u0013\n\u0002\u0010s\u001a\u0005\b¿\u0001\u0010r\"\u0006\bÀ\u0001\u0010\u008d\u0001R\u001e\u00108\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÁ\u0001\u0010[\"\u0005\bÂ\u0001\u0010fR\u001e\u00109\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010[\"\u0005\bÄ\u0001\u0010fR\u001e\u0010<\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u0010[\"\u0005\bÆ\u0001\u0010fR\u0012\u0010)\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\bÇ\u0001\u0010WR3\u0010J\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010Kj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`L¢\u0006\n\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001R\u001e\u0010I\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u0010[\"\u0005\bË\u0001\u0010fR \u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\r\n\u0003\u0010\u0084\u0001\u001a\u0006\bÐ\u0001\u0010\u0081\u0001R\u001e\u0010F\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010[\"\u0005\bÒ\u0001\u0010fR\u001c\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u0010W\"\u0005\bÔ\u0001\u0010YR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\r\n\u0003\u0010\u0084\u0001\u001a\u0006\bÕ\u0001\u0010\u0081\u0001R\u0014\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\bÖ\u0001\u0010[R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\r\n\u0003\u0010\u0084\u0001\u001a\u0006\b×\u0001\u0010\u0081\u0001¨\u0006£\u0002"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfoVO;", "Ljava/io/Serializable;", "id", "", "stockNum", "", "unpayNum", "price", "originPrice", "discountPrice", "discountPriceText", "userLimit", "lowerLimit", "upperLimitToast", "lowerLimitToast", "limitText", "nowStock", "", "skuType", "benefitLabels", "", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "campaignPriceHeader", "priceHeaderStyle", "newBonusText", "marketPrice", "epInfo", "", "presellDelayDesc", "deliveryDelayDesc", "deliveryDelayBackground", "delayDescIcon", "delayDescStyle", "campaignStartTime", "campaignEndTime", "activityIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "atmosphereHeader", "campaignSubType", "depositPrice", "buttonLabel", "serverTime", "buttons", "", "Lcom/bytedance/android/ec/model/sku/SkuBottomButtons;", "isSecKill", "", "isDepositPresale", "carAdaptComponent", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "firstPrice", "firstPricePrefix", "firstPriceSuffix", "firstPriceIsUnderline", "firstPriceSupplement", "secondPrice", "secondPricePrefix", "secondPriceSuffix", "secondPriceIsUnderline", "secondPriceIsReducePrice", "secondPriceSupplement", "regularPrice", "regularPricePrefix", "regularPriceSuffix", "regularPriceIsUnderline", "regularPriceSupplement", "priceType", "hotMinPrice", "hotMaxPrice", "atmosphereStyle", "stockDesc", "skuStatusDetail", "Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "skuExtra", "showEventTrack", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "buttonTip", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "hideTradeIn", "canAddCart", "promiseType", "(Ljava/lang/String;JLjava/lang/Long;JJLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JJLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;JLjava/util/List;ZZLcom/bytedance/android/ec/model/sku/CarAdaptComponent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;Ljava/lang/String;Ljava/util/HashMap;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getActivityIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "activityStock", "getActivityStock", "()J", "setActivityStock", "(J)V", "getAtmosphereHeader", "()Ljava/lang/String;", "getAtmosphereStyle", "()Ljava/lang/Integer;", "setAtmosphereStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBenefitLabels", "()Ljava/util/List;", "bigImageUrl", "getBigImageUrl", "setBigImageUrl", "(Ljava/lang/String;)V", "getButtonLabel", "getButtonTip", "()Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "setButtonTip", "(Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;)V", "getButtons", "getCampaignEndTime", "getCampaignPriceHeader", "getCampaignStartTime", "getCampaignSubType", "getCanAddCart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "canSelect", "getCanSelect", "()Z", "setCanSelect", "(Z)V", "getCarAdaptComponent", "()Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getDelayDescIcon", "getDelayDescStyle", "getDeliveryDelayBackground", "getDeliveryDelayDesc", "getDepositPrice", "getDiscountPrice", "()Ljava/lang/Long;", "setDiscountPrice", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDiscountPriceText", "setDiscountPriceText", "getEpInfo", "()Ljava/lang/Object;", "getFirstPrice", "setFirstPrice", "getFirstPriceIsUnderline", "setFirstPriceIsUnderline", "(Ljava/lang/Boolean;)V", "getFirstPricePrefix", "setFirstPricePrefix", "getFirstPriceSuffix", "setFirstPriceSuffix", "getFirstPriceSupplement", "setFirstPriceSupplement", "getHideTradeIn", "getHotMaxPrice", "setHotMaxPrice", "getHotMinPrice", "setHotMinPrice", "getId", "setId", "imageUrl", "getImageUrl", "setImageUrl", "getLimitText", "getLowerLimit", "getLowerLimitToast", "getMarketPrice", "getNewBonusText", "getNowStock", "()I", "setNowStock", "(I)V", "getOriginPrice", "setOriginPrice", "getPresellDelayDesc", "getPrice", "setPrice", "getPriceHeaderStyle", "getPriceType", "setPriceType", "getPromiseType", "setPromiseType", "getRegularPrice", "setRegularPrice", "getRegularPriceIsUnderline", "setRegularPriceIsUnderline", "getRegularPricePrefix", "setRegularPricePrefix", "getRegularPriceSuffix", "setRegularPriceSuffix", "getRegularPriceSupplement", "setRegularPriceSupplement", "getSecondPrice", "setSecondPrice", "getSecondPriceIsReducePrice", "setSecondPriceIsReducePrice", "getSecondPriceIsUnderline", "setSecondPriceIsUnderline", "getSecondPricePrefix", "setSecondPricePrefix", "getSecondPriceSuffix", "setSecondPriceSuffix", "getSecondPriceSupplement", "setSecondPriceSupplement", "getServerTime", "getShowEventTrack", "()Ljava/util/HashMap;", "getSkuExtra", "setSkuExtra", "getSkuStatusDetail", "()Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "setSkuStatusDetail", "(Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;)V", "getSkuType", "getStockDesc", "setStockDesc", "getStockNum", "setStockNum", "getUnpayNum", "getUpperLimitToast", "getUserLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLjava/lang/Long;JJLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JJLcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;JLjava/util/List;ZZLcom/bytedance/android/ec/model/sku/CarAdaptComponent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;Ljava/lang/String;Ljava/util/HashMap;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfoVO;", "equals", "other", "hashCode", "isGroupBuy", "isInDepositPresale", "isInPreSecKill", "isInSecKill", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuItemInfoVO implements Serializable {
    private final ECUrlModel activityIcon;
    private long activityStock;
    private final String atmosphereHeader;
    private Integer atmosphereStyle;
    private final List<PromotionBenefitLabel> benefitLabels;
    private String bigImageUrl;
    private final String buttonLabel;
    private ButtonTipComponent buttonTip;
    private final List<SkuBottomButtons> buttons;
    private final long campaignEndTime;
    private final String campaignPriceHeader;
    private final long campaignStartTime;
    private final Integer campaignSubType;
    private final Boolean canAddCart;
    private boolean canSelect;
    private final CarAdaptComponent carAdaptComponent;
    private final String delayDescIcon;
    private final Integer delayDescStyle;
    private final String deliveryDelayBackground;
    private final String deliveryDelayDesc;
    private final long depositPrice;
    private Long discountPrice;
    private String discountPriceText;
    private final Object epInfo;
    private Long firstPrice;
    private Boolean firstPriceIsUnderline;
    private String firstPricePrefix;
    private String firstPriceSuffix;
    private String firstPriceSupplement;
    private final Boolean hideTradeIn;
    private Long hotMaxPrice;
    private Long hotMinPrice;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f17id;
    private String imageUrl;
    private final boolean isDepositPresale;
    private final boolean isSecKill;
    private final String limitText;
    private final long lowerLimit;
    private final String lowerLimitToast;
    private final Long marketPrice;
    private final String newBonusText;
    private int nowStock;
    private long originPrice;
    private final String presellDelayDesc;
    private long price;
    private final int priceHeaderStyle;
    private Long priceType;
    private String promiseType;
    private Long regularPrice;
    private Boolean regularPriceIsUnderline;
    private String regularPricePrefix;
    private String regularPriceSuffix;
    private String regularPriceSupplement;
    private Long secondPrice;
    private Boolean secondPriceIsReducePrice;
    private Boolean secondPriceIsUnderline;
    private String secondPricePrefix;
    private String secondPriceSuffix;
    private String secondPriceSupplement;
    private final long serverTime;
    private final HashMap<String, String> showEventTrack;
    private String skuExtra;
    private SkuStatusDetail skuStatusDetail;
    private final Long skuType;
    private String stockDesc;
    private long stockNum;
    private final Long unpayNum;
    private final String upperLimitToast;
    private final Long userLimit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuItemInfoVO copy$default(SkuItemInfoVO r24, String r25, long r26, Long r28, long r29, long r31, Long r33, String r34, Long r35, long r36, String r38, String r39, String r40, int r41, Long r42, List r43, String r44, int r45, String r46, Long r47, Object r48, String r49, String r50, String r51, String r52, Integer r53, long r54, long r56, ECUrlModel r58, String r59, Integer r60, long r61, String r63, long r64, List r66, boolean r67, boolean r68, CarAdaptComponent r69, Long r70, String r71, String r72, Boolean r73, String r74, Long r75, String r76, String r77, Boolean r78, Boolean r79, String r80, Long r81, String r82, String r83, Boolean r84, String r85, Long r86, Long r87, Long r88, Integer r89, String r90, SkuStatusDetail r91, String r92, HashMap r93, ButtonTipComponent r94, Boolean r95, Boolean r96, String r97, int r98, int r99, int r100, Object r101) {
        if ((r98 & 1) == 0) goto L5;
        String r10 = r24.f17id;
    L7:
        if ((r98 & 2) == 0) goto L9;
        long r11 = r24.stockNum;
    L11:
        if ((r98 & 4) == 0) goto L13;
        Long r12 = r24.unpayNum;
    L15:
        if ((r98 & 8) == 0) goto L17;
        long r13 = r24.price;
    L19:
        if ((r98 & 16) == 0) goto L21;
        long r14 = r24.originPrice;
    L23:
        if ((r98 & 32) == 0) goto L25;
        Long r15 = r24.discountPrice;
    L27:
        if ((r98 & 64) == 0) goto L29;
        String r16 = r24.discountPriceText;
    L31:
        if ((r98 & 128) == 0) goto L33;
        Long r17 = r24.userLimit;
    L35:
        if ((r98 & 256) == 0) goto L37;
        long r18 = r24.lowerLimit;
    L38:
        long r37 = r18;
        if ((r98 & 512) == 0) goto L41;
        String r19 = r24.upperLimitToast;
    L43:
        if ((r98 & 1024) == 0) goto L45;
        String r110 = r24.lowerLimitToast;
    L46:
        String r310 = r110;
        if ((r98 & 2048) == 0) goto L49;
        String r111 = r24.limitText;
    L50:
        String r410 = r111;
        if ((r98 & 4096) == 0) goto L53;
        int r112 = r24.nowStock;
    L54:
        int r411 = r112;
        if ((r98 & 8192) == 0) goto L57;
        Long r113 = r24.skuType;
    L58:
        Long r412 = r113;
        if ((r98 & 16384) == 0) goto L61;
        List r114 = r24.benefitLabels;
    L62:
        List r413 = r114;
        if ((r98 & 32768) == 0) goto L65;
        String r115 = r24.campaignPriceHeader;
    L66:
        String r414 = r115;
        if ((r98 & 65536) == 0) goto L69;
        int r116 = r24.priceHeaderStyle;
    L70:
        int r415 = r116;
        if ((r98 & 131072) == 0) goto L73;
        String r117 = r24.newBonusText;
    L74:
        String r416 = r117;
        if ((r98 & 262144) == 0) goto L77;
        Long r118 = r24.marketPrice;
    L78:
        Long r417 = r118;
        if ((r98 & 524288) == 0) goto L81;
        Object r119 = r24.epInfo;
    L82:
        Object r418 = r119;
        if ((r98 & 1048576) == 0) goto L85;
        String r120 = r24.presellDelayDesc;
    L86:
        String r419 = r120;
        if ((r98 & 2097152) == 0) goto L89;
        String r121 = r24.deliveryDelayDesc;
    L90:
        String r55 = r121;
        if ((r98 & 4194304) == 0) goto L93;
        String r122 = r24.deliveryDelayBackground;
    L94:
        String r57 = r122;
        if ((r98 & 8388608) == 0) goto L97;
        String r123 = r24.delayDescIcon;
    L98:
        String r510 = r123;
        if ((r98 & 16777216) == 0) goto L101;
        Integer r124 = r24.delayDescStyle;
    L102:
        String r311 = r19;
        Integer r511 = r124;
        if ((r98 & 33554432) == 0) goto L105;
        long r125 = r24.campaignStartTime;
    L106:
        long r512 = r125;
        if ((r98 & 67108864) == 0) goto L109;
        long r126 = r24.campaignEndTime;
    L110:
        long r513 = r126;
        if ((r98 & 134217728) == 0) goto L113;
        ECUrlModel r127 = r24.activityIcon;
    L115:
        if ((268435456 & r98) == 0) goto L117;
        String r128 = r24.atmosphereHeader;
    L118:
        String r514 = r128;
        if ((r98 & 536870912) == 0) goto L121;
        Integer r129 = r24.campaignSubType;
    L122:
        ECUrlModel r515 = r127;
        Integer r62 = r129;
        if ((r98 & 1073741824) == 0) goto L125;
        long r130 = r24.depositPrice;
    L127:
        if ((r98 & Integer.MIN_VALUE) == 0) goto L129;
        String r1 = r24.buttonLabel;
    L130:
        long r65 = r130;
        if ((r99 & 1) == 0) goto L133;
        long r131 = r24.serverTime;
    L134:
        long r610 = r131;
        if ((r99 & 2) == 0) goto L137;
        List r132 = r24.buttons;
    L139:
        if ((r99 & 4) == 0) goto L141;
        boolean r133 = r24.isSecKill;
    L142:
        boolean r611 = r133;
        if ((r99 & 8) == 0) goto L145;
        boolean r134 = r24.isDepositPresale;
    L146:
        boolean r612 = r134;
        if ((r99 & 16) == 0) goto L149;
        CarAdaptComponent r135 = r24.carAdaptComponent;
    L150:
        CarAdaptComponent r613 = r135;
        if ((r99 & 32) == 0) goto L153;
        Long r136 = r24.firstPrice;
    L154:
        Long r710 = r136;
        if ((r99 & 64) == 0) goto L157;
        String r137 = r24.firstPricePrefix;
    L158:
        String r711 = r137;
        if ((r99 & 128) == 0) goto L161;
        String r138 = r24.firstPriceSuffix;
    L162:
        String r712 = r138;
        if ((r99 & 256) == 0) goto L165;
        Boolean r139 = r24.firstPriceIsUnderline;
    L166:
        Boolean r713 = r139;
        if ((r99 & 512) == 0) goto L169;
        String r140 = r24.firstPriceSupplement;
    L170:
        String r714 = r140;
        if ((r99 & 1024) == 0) goto L173;
        Long r141 = r24.secondPrice;
    L174:
        Long r715 = r141;
        if ((r99 & 2048) == 0) goto L177;
        String r142 = r24.secondPricePrefix;
    L178:
        String r716 = r142;
        if ((r99 & 4096) == 0) goto L181;
        String r143 = r24.secondPriceSuffix;
    L182:
        String r717 = r143;
        if ((r99 & 8192) == 0) goto L185;
        Boolean r144 = r24.secondPriceIsUnderline;
    L186:
        Boolean r718 = r144;
        if ((r99 & 16384) == 0) goto L189;
        Boolean r145 = r24.secondPriceIsReducePrice;
    L190:
        Boolean r719 = r145;
        if ((r99 & 32768) == 0) goto L193;
        String r146 = r24.secondPriceSupplement;
    L194:
        String r810 = r146;
        if ((r99 & 65536) == 0) goto L197;
        Long r147 = r24.regularPrice;
    L198:
        Long r811 = r147;
        if ((r99 & 131072) == 0) goto L201;
        String r148 = r24.regularPricePrefix;
    L202:
        String r812 = r148;
        if ((r99 & 262144) == 0) goto L205;
        String r149 = r24.regularPriceSuffix;
    L206:
        String r813 = r149;
        if ((r99 & 524288) == 0) goto L209;
        Boolean r150 = r24.regularPriceIsUnderline;
    L210:
        Boolean r814 = r150;
        if ((r99 & 1048576) == 0) goto L213;
        String r151 = r24.regularPriceSupplement;
    L214:
        String r815 = r151;
        if ((r99 & 2097152) == 0) goto L217;
        Long r152 = r24.priceType;
    L218:
        Long r816 = r152;
        if ((r99 & 4194304) == 0) goto L221;
        Long r153 = r24.hotMinPrice;
    L222:
        Long r817 = r153;
        if ((r99 & 8388608) == 0) goto L225;
        Long r154 = r24.hotMaxPrice;
    L226:
        Long r818 = r154;
        if ((r99 & 16777216) == 0) goto L229;
        Integer r155 = r24.atmosphereStyle;
    L230:
        Integer r819 = r155;
        if ((r99 & 33554432) == 0) goto L233;
        String r156 = r24.stockDesc;
    L234:
        String r910 = r156;
        if ((r99 & 67108864) == 0) goto L237;
        SkuStatusDetail r157 = r24.skuStatusDetail;
    L238:
        SkuStatusDetail r911 = r157;
        if ((r99 & 134217728) == 0) goto L241;
        String r158 = r24.skuExtra;
    L242:
        String r912 = r158;
        if ((r99 & 268435456) == 0) goto L245;
        HashMap r159 = r24.showEventTrack;
    L246:
        HashMap r913 = r159;
        if ((r99 & 536870912) == 0) goto L249;
        ButtonTipComponent r160 = r24.buttonTip;
    L250:
        ButtonTipComponent r914 = r160;
        if ((r99 & 1073741824) == 0) goto L253;
        Boolean r161 = r24.hideTradeIn;
    L255:
        if ((r99 & Integer.MIN_VALUE) == 0) goto L257;
        Boolean r20 = r24.canAddCart;
    L258:
        Boolean r915 = r20;
        if ((r100 & 1) == 0) goto L261;
        String r21 = r24.promiseType;
    L263:
        return r24.copy(r10, r11, r12, r13, r14, r15, r16, r17, r37, r311, r310, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r55, r57, r510, r511, r512, r513, r515, r514, r62, r65, r1, r610, r132, r611, r612, r613, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r161, r915, r21);
    L261:
        r21 = r97;
        goto L263
    L257:
        r20 = r96;
        goto L258
    L253:
        r161 = r95;
        goto L255
    L249:
        r160 = r94;
        goto L250
    L245:
        r159 = r93;
        goto L246
    L241:
        r158 = r92;
        goto L242
    L237:
        r157 = r91;
        goto L238
    L233:
        r156 = r90;
        goto L234
    L229:
        r155 = r89;
        goto L230
    L225:
        r154 = r88;
        goto L226
    L221:
        r153 = r87;
        goto L222
    L217:
        r152 = r86;
        goto L218
    L213:
        r151 = r85;
        goto L214
    L209:
        r150 = r84;
        goto L210
    L205:
        r149 = r83;
        goto L206
    L201:
        r148 = r82;
        goto L202
    L197:
        r147 = r81;
        goto L198
    L193:
        r146 = r80;
        goto L194
    L189:
        r145 = r79;
        goto L190
    L185:
        r144 = r78;
        goto L186
    L181:
        r143 = r77;
        goto L182
    L177:
        r142 = r76;
        goto L178
    L173:
        r141 = r75;
        goto L174
    L169:
        r140 = r74;
        goto L170
    L165:
        r139 = r73;
        goto L166
    L161:
        r138 = r72;
        goto L162
    L157:
        r137 = r71;
        goto L158
    L153:
        r136 = r70;
        goto L154
    L149:
        r135 = r69;
        goto L150
    L145:
        r134 = r68;
        goto L146
    L141:
        r133 = r67;
        goto L142
    L137:
        r132 = r66;
        goto L139
    L133:
        r131 = r64;
        goto L134
    L129:
        r1 = r63;
        goto L130
    L125:
        r130 = r61;
        goto L127
    L121:
        r129 = r60;
        goto L122
    L117:
        r128 = r59;
        goto L118
    L113:
        r127 = r58;
        goto L115
    L109:
        r126 = r56;
        goto L110
    L105:
        r125 = r54;
        goto L106
    L101:
        r124 = r53;
        goto L102
    L97:
        r123 = r52;
        goto L98
    L93:
        r122 = r51;
        goto L94
    L89:
        r121 = r50;
        goto L90
    L85:
        r120 = r49;
        goto L86
    L81:
        r119 = r48;
        goto L82
    L77:
        r118 = r47;
        goto L78
    L73:
        r117 = r46;
        goto L74
    L69:
        r116 = r45;
        goto L70
    L65:
        r115 = r44;
        goto L66
    L61:
        r114 = r43;
        goto L62
    L57:
        r113 = r42;
        goto L58
    L53:
        r112 = r41;
        goto L54
    L49:
        r111 = r40;
        goto L50
    L45:
        r110 = r39;
        goto L46
    L41:
        r19 = r38;
        goto L43
    L37:
        r18 = r36;
        goto L38
    L33:
        r17 = r35;
        goto L35
    L29:
        r16 = r34;
        goto L31
    L25:
        r15 = r33;
        goto L27
    L21:
        r14 = r31;
        goto L23
    L17:
        r13 = r29;
        goto L19
    L13:
        r12 = r28;
        goto L15
    L9:
        r11 = r26;
        goto L11
    L5:
        r10 = r25;
        goto L7
    }

    public final String component1() {
        return this.f17id;
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

    public final long component26() {
        return this.campaignStartTime;
    }

    public final long component27() {
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

    public final long component31() {
        return this.depositPrice;
    }

    public final String component32() {
        return this.buttonLabel;
    }

    public final long component33() {
        return this.serverTime;
    }

    public final List<SkuBottomButtons> component34() {
        return this.buttons;
    }

    public final boolean component35() {
        return this.isSecKill;
    }

    public final boolean component36() {
        return this.isDepositPresale;
    }

    public final CarAdaptComponent component37() {
        return this.carAdaptComponent;
    }

    public final Long component38() {
        return this.firstPrice;
    }

    public final String component39() {
        return this.firstPricePrefix;
    }

    public final long component4() {
        return this.price;
    }

    public final String component40() {
        return this.firstPriceSuffix;
    }

    public final Boolean component41() {
        return this.firstPriceIsUnderline;
    }

    public final String component42() {
        return this.firstPriceSupplement;
    }

    public final Long component43() {
        return this.secondPrice;
    }

    public final String component44() {
        return this.secondPricePrefix;
    }

    public final String component45() {
        return this.secondPriceSuffix;
    }

    public final Boolean component46() {
        return this.secondPriceIsUnderline;
    }

    public final Boolean component47() {
        return this.secondPriceIsReducePrice;
    }

    public final String component48() {
        return this.secondPriceSupplement;
    }

    public final Long component49() {
        return this.regularPrice;
    }

    public final long component5() {
        return this.originPrice;
    }

    public final String component50() {
        return this.regularPricePrefix;
    }

    public final String component51() {
        return this.regularPriceSuffix;
    }

    public final Boolean component52() {
        return this.regularPriceIsUnderline;
    }

    public final String component53() {
        return this.regularPriceSupplement;
    }

    public final Long component54() {
        return this.priceType;
    }

    public final Long component55() {
        return this.hotMinPrice;
    }

    public final Long component56() {
        return this.hotMaxPrice;
    }

    public final Integer component57() {
        return this.atmosphereStyle;
    }

    public final String component58() {
        return this.stockDesc;
    }

    public final SkuStatusDetail component59() {
        return this.skuStatusDetail;
    }

    public final Long component6() {
        return this.discountPrice;
    }

    public final String component60() {
        return this.skuExtra;
    }

    public final HashMap<String, String> component61() {
        return this.showEventTrack;
    }

    public final ButtonTipComponent component62() {
        return this.buttonTip;
    }

    public final Boolean component63() {
        return this.hideTradeIn;
    }

    public final Boolean component64() {
        return this.canAddCart;
    }

    public final String component65() {
        return this.promiseType;
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

    public final SkuItemInfoVO copy(String r76, long r77, Long r79, long r80, long r82, Long r84, String r85, Long r86, long r87, String r89, String r90, String r91, int r92, Long r93, List<PromotionBenefitLabel> r94, String r95, int r96, String r97, Long r98, Object r99, String r100, String r101, String r102, String r103, Integer r104, long r105, long r107, ECUrlModel r109, String r110, Integer r111, long r112, String r114, long r115, List<SkuBottomButtons> r117, boolean r118, boolean r119, CarAdaptComponent r120, Long r121, String r122, String r123, Boolean r124, String r125, Long r126, String r127, String r128, Boolean r129, Boolean r130, String r131, Long r132, String r133, String r134, Boolean r135, String r136, Long r137, Long r138, Long r139, Integer r140, String r141, SkuStatusDetail r142, String r143, HashMap<String, String> r144, ButtonTipComponent r145, Boolean r146, Boolean r147, String r148) {
        Intrinsics.checkNotNullParameter(r85, "discountPriceText");
        Intrinsics.checkNotNullParameter(r95, "campaignPriceHeader");
        return new SkuItemInfoVO(r76, r77, r79, r80, r82, r84, r85, r86, r87, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r107, r109, r110, r111, r112, r114, r115, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof SkuItemInfoVO) == false) goto L136;
        SkuItemInfoVO r11 = (SkuItemInfoVO) r10;
        if (Intrinsics.areEqual(this.f17id, r11.f17id) == true) goto L8;
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
        if (this.campaignStartTime == r11.campaignStartTime) goto L58;
        return false;
    L58:
        if (this.campaignEndTime == r11.campaignEndTime) goto L60;
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
        if (this.depositPrice == r11.depositPrice) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.buttonLabel, r11.buttonLabel) == true) goto L70;
        return false;
    L70:
        if (this.serverTime == r11.serverTime) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.buttons, r11.buttons) == true) goto L74;
        return false;
    L74:
        if (this.isSecKill == r11.isSecKill) goto L76;
        return false;
    L76:
        if (this.isDepositPresale == r11.isDepositPresale) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.carAdaptComponent, r11.carAdaptComponent) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.firstPrice, r11.firstPrice) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.firstPricePrefix, r11.firstPricePrefix) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.firstPriceSuffix, r11.firstPriceSuffix) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.firstPriceIsUnderline, r11.firstPriceIsUnderline) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.firstPriceSupplement, r11.firstPriceSupplement) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.secondPrice, r11.secondPrice) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.secondPricePrefix, r11.secondPricePrefix) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.secondPriceSuffix, r11.secondPriceSuffix) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.secondPriceIsUnderline, r11.secondPriceIsUnderline) == true) goto L98;
        return false;
    L98:
        if (Intrinsics.areEqual(this.secondPriceIsReducePrice, r11.secondPriceIsReducePrice) == true) goto L100;
        return false;
    L100:
        if (Intrinsics.areEqual(this.secondPriceSupplement, r11.secondPriceSupplement) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.regularPrice, r11.regularPrice) == true) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.regularPricePrefix, r11.regularPricePrefix) == true) goto L106;
        return false;
    L106:
        if (Intrinsics.areEqual(this.regularPriceSuffix, r11.regularPriceSuffix) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.regularPriceIsUnderline, r11.regularPriceIsUnderline) == true) goto L110;
        return false;
    L110:
        if (Intrinsics.areEqual(this.regularPriceSupplement, r11.regularPriceSupplement) == true) goto L112;
        return false;
    L112:
        if (Intrinsics.areEqual(this.priceType, r11.priceType) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.hotMinPrice, r11.hotMinPrice) == true) goto L116;
        return false;
    L116:
        if (Intrinsics.areEqual(this.hotMaxPrice, r11.hotMaxPrice) == true) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.atmosphereStyle, r11.atmosphereStyle) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.stockDesc, r11.stockDesc) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.skuStatusDetail, r11.skuStatusDetail) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.skuExtra, r11.skuExtra) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.showEventTrack, r11.showEventTrack) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.buttonTip, r11.buttonTip) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.hideTradeIn, r11.hideTradeIn) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.canAddCart, r11.canAddCart) == true) goto L134;
        return false;
    L134:
        if (Intrinsics.areEqual(this.promiseType, r11.promiseType) == true) goto L205;
        return false;
    L205:
        return true;
    L136:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v70, types: [int] */
    /* JADX WARN: Type inference failed for: r2v203 */
    /* JADX WARN: Type inference failed for: r2v227 */
    /* JADX WARN: Type inference failed for: r2v88, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    public int hashCode() {
        String r0 = this.f17id;
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
        long r73 = this.campaignStartTime;
        int r74 = (r72 + ((int) (r73 ^ (r73 >>> 32)))) * 31;
        long r75 = this.campaignEndTime;
        int r76 = (r74 + ((int) (r75 ^ (r75 >>> 32)))) * 31;
        ECUrlModel r77 = this.activityIcon;
        if (r77 == null) goto L81;
        int r78 = r77.hashCode();
    L82:
        int r79 = (r76 + r78) * 31;
        String r80 = this.atmosphereHeader;
        if (r80 == null) goto L85;
        int r81 = r80.hashCode();
    L86:
        int r82 = (r79 + r81) * 31;
        Integer r83 = this.campaignSubType;
        if (r83 == null) goto L89;
        int r84 = r83.hashCode();
    L90:
        int r85 = (r82 + r84) * 31;
        long r86 = this.depositPrice;
        int r87 = (r85 + ((int) (r86 ^ (r86 >>> 32)))) * 31;
        String r88 = this.buttonLabel;
        if (r88 == null) goto L93;
        int r89 = r88.hashCode();
    L94:
        int r90 = (r87 + r89) * 31;
        long r91 = this.serverTime;
        int r92 = (r90 + ((int) (r91 ^ (r91 >>> 32)))) * 31;
        List<SkuBottomButtons> r93 = this.buttons;
        if (r93 == null) goto L97;
        int r94 = r93.hashCode();
    L98:
        int r95 = (r92 + r94) * 31;
        boolean r96 = this.isSecKill;
        ?? r97 = 1;
        ?? r98 = r96;
        if (r96 == false) goto L101;
        r98 = 1;
    L101:
        int r99 = (r95 + r98) * 31;
        boolean r100 = this.isDepositPresale;
        if (r100 == true) goto L105;
        r97 = r100;
    L105:
        int r101 = (r99 + r97) * 31;
        CarAdaptComponent r102 = this.carAdaptComponent;
        if (r102 == null) goto L108;
        int r103 = r102.hashCode();
    L109:
        int r104 = (r101 + r103) * 31;
        Long r105 = this.firstPrice;
        if (r105 == null) goto L112;
        int r106 = r105.hashCode();
    L113:
        int r107 = (r104 + r106) * 31;
        String r108 = this.firstPricePrefix;
        if (r108 == null) goto L116;
        int r109 = r108.hashCode();
    L117:
        int r110 = (r107 + r109) * 31;
        String r111 = this.firstPriceSuffix;
        if (r111 == null) goto L120;
        int r112 = r111.hashCode();
    L121:
        int r113 = (r110 + r112) * 31;
        Boolean r114 = this.firstPriceIsUnderline;
        if (r114 == null) goto L124;
        int r115 = r114.hashCode();
    L125:
        int r116 = (r113 + r115) * 31;
        String r117 = this.firstPriceSupplement;
        if (r117 == null) goto L128;
        int r118 = r117.hashCode();
    L129:
        int r119 = (r116 + r118) * 31;
        Long r120 = this.secondPrice;
        if (r120 == null) goto L132;
        int r121 = r120.hashCode();
    L133:
        int r122 = (r119 + r121) * 31;
        String r123 = this.secondPricePrefix;
        if (r123 == null) goto L136;
        int r124 = r123.hashCode();
    L137:
        int r125 = (r122 + r124) * 31;
        String r126 = this.secondPriceSuffix;
        if (r126 == null) goto L140;
        int r127 = r126.hashCode();
    L141:
        int r128 = (r125 + r127) * 31;
        Boolean r129 = this.secondPriceIsUnderline;
        if (r129 == null) goto L144;
        int r130 = r129.hashCode();
    L145:
        int r131 = (r128 + r130) * 31;
        Boolean r132 = this.secondPriceIsReducePrice;
        if (r132 == null) goto L148;
        int r133 = r132.hashCode();
    L149:
        int r134 = (r131 + r133) * 31;
        String r135 = this.secondPriceSupplement;
        if (r135 == null) goto L152;
        int r136 = r135.hashCode();
    L153:
        int r137 = (r134 + r136) * 31;
        Long r138 = this.regularPrice;
        if (r138 == null) goto L156;
        int r139 = r138.hashCode();
    L157:
        int r140 = (r137 + r139) * 31;
        String r141 = this.regularPricePrefix;
        if (r141 == null) goto L160;
        int r142 = r141.hashCode();
    L161:
        int r143 = (r140 + r142) * 31;
        String r144 = this.regularPriceSuffix;
        if (r144 == null) goto L164;
        int r145 = r144.hashCode();
    L165:
        int r146 = (r143 + r145) * 31;
        Boolean r147 = this.regularPriceIsUnderline;
        if (r147 == null) goto L168;
        int r148 = r147.hashCode();
    L169:
        int r149 = (r146 + r148) * 31;
        String r150 = this.regularPriceSupplement;
        if (r150 == null) goto L172;
        int r151 = r150.hashCode();
    L173:
        int r152 = (r149 + r151) * 31;
        Long r153 = this.priceType;
        if (r153 == null) goto L176;
        int r154 = r153.hashCode();
    L177:
        int r155 = (r152 + r154) * 31;
        Long r156 = this.hotMinPrice;
        if (r156 == null) goto L180;
        int r157 = r156.hashCode();
    L181:
        int r158 = (r155 + r157) * 31;
        Long r159 = this.hotMaxPrice;
        if (r159 == null) goto L184;
        int r160 = r159.hashCode();
    L185:
        int r161 = (r158 + r160) * 31;
        Integer r162 = this.atmosphereStyle;
        if (r162 == null) goto L188;
        int r163 = r162.hashCode();
    L189:
        int r164 = (r161 + r163) * 31;
        String r165 = this.stockDesc;
        if (r165 == null) goto L192;
        int r166 = r165.hashCode();
    L193:
        int r167 = (r164 + r166) * 31;
        SkuStatusDetail r168 = this.skuStatusDetail;
        if (r168 == null) goto L196;
        int r169 = r168.hashCode();
    L197:
        int r170 = (r167 + r169) * 31;
        String r171 = this.skuExtra;
        if (r171 == null) goto L200;
        int r172 = r171.hashCode();
    L201:
        int r173 = (r170 + r172) * 31;
        HashMap<String, String> r174 = this.showEventTrack;
        if (r174 == null) goto L204;
        int r175 = r174.hashCode();
    L205:
        int r176 = (r173 + r175) * 31;
        ButtonTipComponent r177 = this.buttonTip;
        if (r177 == null) goto L208;
        int r178 = r177.hashCode();
    L209:
        int r179 = (r176 + r178) * 31;
        Boolean r180 = this.hideTradeIn;
        if (r180 == null) goto L212;
        int r181 = r180.hashCode();
    L213:
        int r182 = (r179 + r181) * 31;
        Boolean r183 = this.canAddCart;
        if (r183 == null) goto L216;
        int r184 = r183.hashCode();
    L217:
        int r185 = (r182 + r184) * 31;
        String r186 = this.promiseType;
        if (r186 == null) goto L221;
        r1 = r186.hashCode();
    L221:
        return r185 + r1;
    L216:
        r184 = 0;
        goto L217
    L212:
        r181 = 0;
        goto L213
    L208:
        r178 = 0;
        goto L209
    L204:
        r175 = 0;
        goto L205
    L200:
        r172 = 0;
        goto L201
    L196:
        r169 = 0;
        goto L197
    L192:
        r166 = 0;
        goto L193
    L188:
        r163 = 0;
        goto L189
    L184:
        r160 = 0;
        goto L185
    L180:
        r157 = 0;
        goto L181
    L176:
        r154 = 0;
        goto L177
    L172:
        r151 = 0;
        goto L173
    L168:
        r148 = 0;
        goto L169
    L164:
        r145 = 0;
        goto L165
    L160:
        r142 = 0;
        goto L161
    L156:
        r139 = 0;
        goto L157
    L152:
        r136 = 0;
        goto L153
    L148:
        r133 = 0;
        goto L149
    L144:
        r130 = 0;
        goto L145
    L140:
        r127 = 0;
        goto L141
    L136:
        r124 = 0;
        goto L137
    L132:
        r121 = 0;
        goto L133
    L128:
        r118 = 0;
        goto L129
    L124:
        r115 = 0;
        goto L125
    L120:
        r112 = 0;
        goto L121
    L116:
        r109 = 0;
        goto L117
    L112:
        r106 = 0;
        goto L113
    L108:
        r103 = 0;
        goto L109
    L97:
        r94 = 0;
        goto L98
    L93:
        r89 = 0;
        goto L94
    L89:
        r84 = 0;
        goto L90
    L85:
        r81 = 0;
        goto L86
    L81:
        r78 = 0;
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
        return "SkuItemInfoVO(id=" + this.f17id + ", stockNum=" + this.stockNum + ", unpayNum=" + this.unpayNum + ", price=" + this.price + ", originPrice=" + this.originPrice + ", discountPrice=" + this.discountPrice + ", discountPriceText=" + this.discountPriceText + ", userLimit=" + this.userLimit + ", lowerLimit=" + this.lowerLimit + ", upperLimitToast=" + this.upperLimitToast + ", lowerLimitToast=" + this.lowerLimitToast + ", limitText=" + this.limitText + ", nowStock=" + this.nowStock + ", skuType=" + this.skuType + ", benefitLabels=" + this.benefitLabels + ", campaignPriceHeader=" + this.campaignPriceHeader + ", priceHeaderStyle=" + this.priceHeaderStyle + ", newBonusText=" + this.newBonusText + ", marketPrice=" + this.marketPrice + ", epInfo=" + this.epInfo + ", presellDelayDesc=" + this.presellDelayDesc + ", deliveryDelayDesc=" + this.deliveryDelayDesc + ", deliveryDelayBackground=" + this.deliveryDelayBackground + ", delayDescIcon=" + this.delayDescIcon + ", delayDescStyle=" + this.delayDescStyle + ", campaignStartTime=" + this.campaignStartTime + ", campaignEndTime=" + this.campaignEndTime + ", activityIcon=" + this.activityIcon + ", atmosphereHeader=" + this.atmosphereHeader + ", campaignSubType=" + this.campaignSubType + ", depositPrice=" + this.depositPrice + ", buttonLabel=" + this.buttonLabel + ", serverTime=" + this.serverTime + ", buttons=" + this.buttons + ", isSecKill=" + this.isSecKill + ", isDepositPresale=" + this.isDepositPresale + ", carAdaptComponent=" + this.carAdaptComponent + ", firstPrice=" + this.firstPrice + ", firstPricePrefix=" + this.firstPricePrefix + ", firstPriceSuffix=" + this.firstPriceSuffix + ", firstPriceIsUnderline=" + this.firstPriceIsUnderline + ", firstPriceSupplement=" + this.firstPriceSupplement + ", secondPrice=" + this.secondPrice + ", secondPricePrefix=" + this.secondPricePrefix + ", secondPriceSuffix=" + this.secondPriceSuffix + ", secondPriceIsUnderline=" + this.secondPriceIsUnderline + ", secondPriceIsReducePrice=" + this.secondPriceIsReducePrice + ", secondPriceSupplement=" + this.secondPriceSupplement + ", regularPrice=" + this.regularPrice + ", regularPricePrefix=" + this.regularPricePrefix + ", regularPriceSuffix=" + this.regularPriceSuffix + ", regularPriceIsUnderline=" + this.regularPriceIsUnderline + ", regularPriceSupplement=" + this.regularPriceSupplement + ", priceType=" + this.priceType + ", hotMinPrice=" + this.hotMinPrice + ", hotMaxPrice=" + this.hotMaxPrice + ", atmosphereStyle=" + this.atmosphereStyle + ", stockDesc=" + this.stockDesc + ", skuStatusDetail=" + this.skuStatusDetail + ", skuExtra=" + this.skuExtra + ", showEventTrack=" + this.showEventTrack + ", buttonTip=" + this.buttonTip + ", hideTradeIn=" + this.hideTradeIn + ", canAddCart=" + this.canAddCart + ", promiseType=" + this.promiseType + ")";
    }

    public final boolean isGroupBuy() {
        Long r0 = this.skuType;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.longValue() != 120) goto L8;
        return true;
    }

    public final boolean isInDepositPresale() {
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

    public final boolean isInPreSecKill() {
        Long r0 = this.skuType;
        if (r0 != null) goto L6;
    L10:
        return false;
    L6:
        if (r0.longValue() != 7) goto L10;
        if (SystemClock.elapsedRealtime() >= this.campaignStartTime) goto L10;
        return true;
    }

    public final boolean isInSecKill() {
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

    public final ECUrlModel getActivityIcon() {
        return this.activityIcon;
    }

    public final long getActivityStock() {
        return this.activityStock;
    }

    public final String getAtmosphereHeader() {
        return this.atmosphereHeader;
    }

    public final Integer getAtmosphereStyle() {
        return this.atmosphereStyle;
    }

    public final List<PromotionBenefitLabel> getBenefitLabels() {
        return this.benefitLabels;
    }

    public final String getBigImageUrl() {
        return this.bigImageUrl;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final ButtonTipComponent getButtonTip() {
        return this.buttonTip;
    }

    public final List<SkuBottomButtons> getButtons() {
        return this.buttons;
    }

    public final long getCampaignEndTime() {
        return this.campaignEndTime;
    }

    public final String getCampaignPriceHeader() {
        return this.campaignPriceHeader;
    }

    public final long getCampaignStartTime() {
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

    public final long getDepositPrice() {
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

    public final Boolean getHideTradeIn() {
        return this.hideTradeIn;
    }

    public final Long getHotMaxPrice() {
        return this.hotMaxPrice;
    }

    public final Long getHotMinPrice() {
        return this.hotMinPrice;
    }

    public final String getId() {
        return this.f17id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
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

    public final int getPriceHeaderStyle() {
        return this.priceHeaderStyle;
    }

    public final Long getPriceType() {
        return this.priceType;
    }

    public final String getPromiseType() {
        return this.promiseType;
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

    public final boolean isDepositPresale() {
        return this.isDepositPresale;
    }

    public final boolean isSecKill() {
        return this.isSecKill;
    }

    public final void setActivityStock(long r1) {
        this.activityStock = r1;
    }

    public final void setAtmosphereStyle(Integer r1) {
        this.atmosphereStyle = r1;
    }

    public final void setBigImageUrl(String r1) {
        this.bigImageUrl = r1;
    }

    public final void setButtonTip(ButtonTipComponent r1) {
        this.buttonTip = r1;
    }

    public final void setCanSelect(boolean r1) {
        this.canSelect = r1;
    }

    public final void setDiscountPrice(Long r1) {
        this.discountPrice = r1;
    }

    public final void setDiscountPriceText(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.discountPriceText = r10;
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

    public final void setId(String r1) {
        this.f17id = r1;
    }

    public final void setImageUrl(String r1) {
        this.imageUrl = r1;
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

    public final void setPriceType(Long r1) {
        this.priceType = r1;
    }

    public final void setPromiseType(String r1) {
        this.promiseType = r1;
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

    public final void setSecondPriceIsReducePrice(Boolean r1) {
        this.secondPriceIsReducePrice = r1;
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

    public final void setSkuExtra(String r1) {
        this.skuExtra = r1;
    }

    public final void setSkuStatusDetail(SkuStatusDetail r1) {
        this.skuStatusDetail = r1;
    }

    public final void setStockDesc(String r1) {
        this.stockDesc = r1;
    }

    public final void setStockNum(long r1) {
        this.stockNum = r1;
    }

    public SkuItemInfoVO(String r10, long r11, Long r12, long r13, long r14, Long r15, String r16, Long r17, long r18, String r19, String r20, String r21, int r22, Long r23, List<PromotionBenefitLabel> r24, String r25, int r26, String r27, Long r28, Object r29, String r30, String r31, String r32, String r33, Integer r34, long r35, long r37, ECUrlModel r39, String r40, Integer r41, long r42, String r44, long r45, List<SkuBottomButtons> r47, boolean r48, boolean r49, CarAdaptComponent r50, Long r51, String r52, String r53, Boolean r54, String r55, Long r56, String r57, String r58, Boolean r59, Boolean r60, String r61, Long r62, String r63, String r64, Boolean r65, String r66, Long r67, Long r68, Long r69, Integer r70, String r71, SkuStatusDetail r72, String r73, HashMap<String, String> r74, ButtonTipComponent r75, Boolean r76, Boolean r77, String r78) {
        Intrinsics.checkNotNullParameter(r16, "discountPriceText");
        Intrinsics.checkNotNullParameter(r25, "campaignPriceHeader");
        this.f17id = r10;
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
        this.campaignEndTime = r37;
        this.activityIcon = r39;
        this.atmosphereHeader = r40;
        this.campaignSubType = r41;
        this.depositPrice = r42;
        this.buttonLabel = r44;
        this.serverTime = r45;
        this.buttons = r47;
        this.isSecKill = r48;
        this.isDepositPresale = r49;
        this.carAdaptComponent = r50;
        this.firstPrice = r51;
        this.firstPricePrefix = r52;
        this.firstPriceSuffix = r53;
        this.firstPriceIsUnderline = r54;
        this.firstPriceSupplement = r55;
        this.secondPrice = r56;
        this.secondPricePrefix = r57;
        this.secondPriceSuffix = r58;
        this.secondPriceIsUnderline = r59;
        this.secondPriceIsReducePrice = r60;
        this.secondPriceSupplement = r61;
        this.regularPrice = r62;
        this.regularPricePrefix = r63;
        this.regularPriceSuffix = r64;
        this.regularPriceIsUnderline = r65;
        this.regularPriceSupplement = r66;
        this.priceType = r67;
        this.hotMinPrice = r68;
        this.hotMaxPrice = r69;
        this.atmosphereStyle = r70;
        this.stockDesc = r71;
        this.skuStatusDetail = r72;
        this.skuExtra = r73;
        this.showEventTrack = r74;
        this.buttonTip = r75;
        this.hideTradeIn = r76;
        this.canAddCart = r77;
        this.promiseType = r78;
        this.canSelect = true;
    }

    public /* synthetic */ SkuItemInfoVO(String r79, long r80, Long r82, long r83, long r85, Long r87, String r88, Long r89, long r90, String r92, String r93, String r94, int r95, Long r96, List r97, String r98, int r99, String r100, Long r101, Object r102, String r103, String r104, String r105, String r106, Integer r107, long r108, long r110, ECUrlModel r112, String r113, Integer r114, long r115, String r117, long r118, List r120, boolean r121, boolean r122, CarAdaptComponent r123, Long r124, String r125, String r126, Boolean r127, String r128, Long r129, String r130, String r131, Boolean r132, Boolean r133, String r134, Long r135, String r136, String r137, Boolean r138, String r139, Long r140, Long r141, Long r142, Integer r143, String r144, SkuStatusDetail r145, String r146, HashMap r147, ButtonTipComponent r148, Boolean r149, Boolean r150, String r151, int r152, int r153, int r154, DefaultConstructorMarker r155) {
        if ((r152 & 4) == 0) goto L5;
        Long r10 = null;
    L7:
        if ((r152 & 32) == 0) goto L9;
        Long r13 = null;
    L11:
        if ((r152 & 64) == 0) goto L13;
        String r14 = "";
    L15:
        if ((r152 & 128) == 0) goto L17;
        Long r15 = null;
    L19:
        if ((r152 & 256) == 0) goto L21;
        long r16 = 1;
    L23:
        if ((r152 & 512) == 0) goto L25;
        String r18 = null;
    L27:
        if ((r152 & 1024) == 0) goto L29;
        String r19 = null;
    L31:
        if ((r152 & 2048) == 0) goto L33;
        String r20 = null;
    L35:
        if ((r152 & 4096) == 0) goto L37;
        int r21 = -1;
    L39:
        if ((r152 & 8192) == 0) goto L41;
        Long r22 = null;
    L43:
        if ((r152 & 16384) == 0) goto L45;
        List r23 = null;
    L47:
        if ((r152 & 32768) == 0) goto L49;
        String r24 = "";
    L51:
        if ((r152 & 65536) == 0) goto L53;
        int r25 = -1;
    L55:
        if ((r152 & 131072) == 0) goto L57;
        String r26 = null;
    L59:
        if ((r152 & 262144) == 0) goto L61;
        Long r27 = null;
    L63:
        if ((r152 & 524288) == 0) goto L65;
        Object r28 = null;
    L67:
        if ((r152 & 1048576) == 0) goto L69;
        String r29 = null;
    L71:
        if ((r152 & 2097152) == 0) goto L73;
        String r30 = null;
    L75:
        if ((4194304 & r152) == 0) goto L77;
        String r31 = null;
    L79:
        if ((8388608 & r152) == 0) goto L81;
        String r32 = null;
    L83:
        if ((16777216 & r152) == 0) goto L85;
        Integer r33 = null;
    L87:
        if ((33554432 & r152) == 0) goto L89;
        long r36 = 0;
    L91:
        if ((67108864 & r152) == 0) goto L93;
        long r38 = 0;
    L95:
        if ((134217728 & r152) == 0) goto L97;
        ECUrlModel r40 = null;
    L99:
        if ((268435456 & r152) == 0) goto L101;
        String r41 = null;
    L103:
        if ((536870912 & r152) == 0) goto L105;
        Integer r42 = null;
    L107:
        if ((1073741824 & r152) == 0) goto L109;
        long r43 = 0;
    L111:
        if ((r152 & Integer.MIN_VALUE) == 0) goto L113;
        String r0 = null;
    L115:
        if ((r153 & 1) == 0) goto L117;
        long r45 = 0;
    L119:
        if ((r153 & 2) == 0) goto L121;
        List r47 = null;
    L123:
        if ((r153 & 4) == 0) goto L125;
        boolean r48 = false;
    L127:
        if ((r153 & 8) == 0) goto L129;
        boolean r49 = false;
    L131:
        if ((r153 & 16) == 0) goto L133;
        CarAdaptComponent r50 = null;
    L135:
        if ((r153 & 32) == 0) goto L137;
        Long r51 = null;
    L139:
        if ((r153 & 64) == 0) goto L141;
        String r52 = null;
    L143:
        if ((r153 & 128) == 0) goto L145;
        String r53 = null;
    L147:
        if ((r153 & 256) == 0) goto L149;
        Boolean r54 = null;
    L151:
        if ((r153 & 512) == 0) goto L153;
        String r55 = null;
    L155:
        if ((r153 & 1024) == 0) goto L157;
        Long r56 = null;
    L159:
        if ((r153 & 2048) == 0) goto L161;
        String r57 = null;
    L163:
        if ((r153 & 4096) == 0) goto L165;
        String r58 = null;
    L167:
        if ((r153 & 8192) == 0) goto L169;
        Boolean r59 = null;
    L171:
        if ((r153 & 16384) == 0) goto L173;
        Boolean r60 = null;
    L175:
        if ((32768 & r153) == 0) goto L177;
        String r11 = null;
    L179:
        if ((65536 & r153) == 0) goto L181;
        Long r61 = null;
    L183:
        if ((r153 & 131072) == 0) goto L185;
        String r62 = null;
    L187:
        if ((r153 & 262144) == 0) goto L189;
        String r63 = null;
    L191:
        if ((r153 & 524288) == 0) goto L193;
        Boolean r64 = null;
    L195:
        if ((r153 & 1048576) == 0) goto L197;
        String r65 = null;
    L199:
        if ((r153 & 2097152) == 0) goto L201;
        Long r66 = null;
    L203:
        if ((4194304 & r153) == 0) goto L205;
        Long r67 = null;
    L207:
        if ((8388608 & r153) == 0) goto L209;
        Long r68 = null;
    L211:
        if ((16777216 & r153) == 0) goto L213;
        Integer r69 = null;
    L215:
        if ((33554432 & r153) == 0) goto L217;
        String r70 = null;
    L219:
        if ((67108864 & r153) == 0) goto L221;
        SkuStatusDetail r71 = null;
    L223:
        if ((134217728 & r153) == 0) goto L225;
        String r72 = null;
    L227:
        if ((268435456 & r153) == 0) goto L229;
        HashMap r73 = null;
    L231:
        if ((536870912 & r153) == 0) goto L233;
        ButtonTipComponent r74 = null;
    L235:
        if ((1073741824 & r153) == 0) goto L237;
        Boolean r75 = Boolean.FALSE;
    L239:
        if ((r153 & Integer.MIN_VALUE) == 0) goto L241;
        Boolean r76 = Boolean.FALSE;
    L243:
        if ((r154 & 1) == 0) goto L245;
        String r77 = null;
    L246:
        this(r79, r80, r10, r83, r85, r13, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r36, r38, r40, r41, r42, r43, r0, r45, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r11, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77);
        return;
    L245:
        r77 = r151;
        goto L246
    L241:
        r76 = r150;
        goto L243
    L237:
        r75 = r149;
        goto L239
    L233:
        r74 = r148;
        goto L235
    L229:
        r73 = r147;
        goto L231
    L225:
        r72 = r146;
        goto L227
    L221:
        r71 = r145;
        goto L223
    L217:
        r70 = r144;
        goto L219
    L213:
        r69 = r143;
        goto L215
    L209:
        r68 = r142;
        goto L211
    L205:
        r67 = r141;
        goto L207
    L201:
        r66 = r140;
        goto L203
    L197:
        r65 = r139;
        goto L199
    L193:
        r64 = r138;
        goto L195
    L189:
        r63 = r137;
        goto L191
    L185:
        r62 = r136;
        goto L187
    L181:
        r61 = r135;
        goto L183
    L177:
        r11 = r134;
        goto L179
    L173:
        r60 = r133;
        goto L175
    L169:
        r59 = r132;
        goto L171
    L165:
        r58 = r131;
        goto L167
    L161:
        r57 = r130;
        goto L163
    L157:
        r56 = r129;
        goto L159
    L153:
        r55 = r128;
        goto L155
    L149:
        r54 = r127;
        goto L151
    L145:
        r53 = r126;
        goto L147
    L141:
        r52 = r125;
        goto L143
    L137:
        r51 = r124;
        goto L139
    L133:
        r50 = r123;
        goto L135
    L129:
        r49 = r122;
        goto L131
    L125:
        r48 = r121;
        goto L127
    L121:
        r47 = r120;
        goto L123
    L117:
        r45 = r118;
        goto L119
    L113:
        r0 = r117;
        goto L115
    L109:
        r43 = r115;
        goto L111
    L105:
        r42 = r114;
        goto L107
    L101:
        r41 = r113;
        goto L103
    L97:
        r40 = r112;
        goto L99
    L93:
        r38 = r110;
        goto L95
    L89:
        r36 = r108;
        goto L91
    L85:
        r33 = r107;
        goto L87
    L81:
        r32 = r106;
        goto L83
    L77:
        r31 = r105;
        goto L79
    L73:
        r30 = r104;
        goto L75
    L69:
        r29 = r103;
        goto L71
    L65:
        r28 = r102;
        goto L67
    L61:
        r27 = r101;
        goto L63
    L57:
        r26 = r100;
        goto L59
    L53:
        r25 = r99;
        goto L55
    L49:
        r24 = r98;
        goto L51
    L45:
        r23 = r97;
        goto L47
    L41:
        r22 = r96;
        goto L43
    L37:
        r21 = r95;
        goto L39
    L33:
        r20 = r94;
        goto L35
    L29:
        r19 = r93;
        goto L31
    L25:
        r18 = r92;
        goto L27
    L21:
        r16 = r90;
        goto L23
    L17:
        r15 = r89;
        goto L19
    L13:
        r14 = r88;
        goto L15
    L9:
        r13 = r87;
        goto L11
    L5:
        r10 = r82;
        goto L7
    }
}
