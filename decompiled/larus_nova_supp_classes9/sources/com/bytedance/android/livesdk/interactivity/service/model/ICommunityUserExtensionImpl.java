package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.PublicAreaBadgeInfo;
import com.bytedance.android.live.base.model.user.api.IAnchorLevel;
import com.bytedance.android.live.base.model.user.d0;
import com.bytedance.android.live.base.model.user.g0;
import com.bytedance.android.live.base.model.user.j;
import com.bytedance.android.live.base.model.user.l0;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.t;
import com.bytedance.android.live.base.model.user.x;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.f;
import py.k;
import py.o;
import py.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u0012\u0012\u0007\u0010¢\u0002\u001a\u00020\u0002¢\u0006\u0006\b£\u0002\u0010¤\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J.\u0010\n\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0001¢\u0006\u0004\b\f\u0010\u000bJ\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0001J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0001J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0001J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001cH\u0096\u0001J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\u000b\u0010 \u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\t\u0010!\u001a\u00020\u001cH\u0096\u0001J\u000b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0001J\t\u0010$\u001a\u00020\u0015H\u0096\u0001J\t\u0010&\u001a\u00020%H\u0096\u0001J\u000b\u0010'\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u000b\u0010(\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0096\u0001J\u000b\u0010+\u001a\u0004\u0018\u00010*H\u0096\u0001J\t\u0010,\u001a\u00020%H\u0096\u0001J\u0013\u0010.\u001a\u0004\u0018\u00010\u00152\u0006\u0010-\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010/\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\t\u00100\u001a\u00020\u0015H\u0096\u0001J\u000b\u00101\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u000b\u00102\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u000b\u00103\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\t\u00104\u001a\u00020\u0005H\u0096\u0001J\t\u00105\u001a\u00020\u001cH\u0096\u0001J\u000b\u00107\u001a\u0004\u0018\u000106H\u0096\u0001J\u000b\u00108\u001a\u0004\u0018\u000106H\u0096\u0001J\u000b\u00109\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\t\u0010;\u001a\u00020:H\u0096\u0001J\t\u0010<\u001a\u00020\u0005H\u0096\u0001J\t\u0010=\u001a\u00020\u0005H\u0096\u0001J\t\u0010>\u001a\u00020\u0005H\u0096\u0001J\t\u0010?\u001a\u00020\u0005H\u0096\u0001J\t\u0010@\u001a\u00020\u0005H\u0096\u0001J\t\u0010A\u001a\u00020\u0005H\u0096\u0001J\t\u0010B\u001a\u00020\u0005H\u0096\u0001J\t\u0010C\u001a\u00020\u0005H\u0096\u0001J\t\u0010D\u001a\u00020\u0005H\u0096\u0001J\t\u0010E\u001a\u00020\u0005H\u0096\u0001J\t\u0010F\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010I\u001a\u00020H2\b\u0010G\u001a\u0004\u0018\u00010\u0010H\u0096\u0001J\u0013\u0010K\u001a\u00020H2\b\u0010J\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0013\u0010L\u001a\u00020H2\b\u0010J\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0013\u0010M\u001a\u00020H2\b\u0010J\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0013\u0010O\u001a\u00020H2\b\u0010N\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0019\u0010R\u001a\u00020H2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010PH\u0096\u0001J\u0013\u0010T\u001a\u00020H2\b\u0010S\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0011\u0010V\u001a\u00020H2\u0006\u0010U\u001a\u00020\u001cH\u0096\u0001J\u0013\u0010X\u001a\u00020H2\b\u0010W\u001a\u0004\u0018\u00010\u001eH\u0096\u0001J\u0011\u0010Z\u001a\u00020H2\u0006\u0010Y\u001a\u00020\u001cH\u0096\u0001J\u0013\u0010\\\u001a\u00020H2\b\u0010[\u001a\u0004\u0018\u00010\"H\u0096\u0001J\u0011\u0010^\u001a\u00020H2\u0006\u0010]\u001a\u00020\u001cH\u0096\u0001J\u0013\u0010`\u001a\u00020H2\b\u0010_\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0013\u0010b\u001a\u00020H2\b\u0010a\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u0011\u0010c\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u001cH\u0096\u0001J\u0011\u0010e\u001a\u00020H2\u0006\u0010d\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010g\u001a\u00020H2\b\u0010f\u001a\u0004\u0018\u000106H\u0096\u0001J\u0011\u0010i\u001a\u00020H2\u0006\u0010h\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010l\u001a\u00020H2\u0006\u0010j\u001a\u00020\u00052\u0006\u0010k\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010n\u001a\u00020H2\u0006\u0010m\u001a\u00020\u0005H\u0096\u0001R(\u0010u\u001a\u0004\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010o8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010z\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001c\u0010}\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b{\u0010w\"\u0004\b|\u0010yR\"\u0010\u0083\u0001\u001a\u0004\u0018\u00010~8\u0016@\u0016X\u0097\u000f¢\u0006\u000f\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u0089\u0001\u001a\u000b\u0018\u00010\u0012j\u0005\u0018\u0001`\u0084\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R#\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001a\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001a\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R#\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0097\u0001\u0010\u008b\u0001\"\u0006\b\u0098\u0001\u0010\u008d\u0001R#\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u009a\u0001\u0010\u008b\u0001\"\u0006\b\u009b\u0001\u0010\u008d\u0001R$\u0010¢\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R!\u0010§\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R \u0010m\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¨\u0001\u0010¤\u0001\"\u0006\b©\u0001\u0010¦\u0001R!\u0010®\u0001\u001a\u00020%8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R$\u0010´\u0001\u001a\u0005\u0018\u00010¯\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R\u001f\u0010[\u001a\u000b\u0018\u00010\"j\u0005\u0018\u0001`µ\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b¶\u0001\u0010·\u0001R\u001f\u0010º\u0001\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\b¸\u0001\u0010w\"\u0005\b¹\u0001\u0010yR!\u0010½\u0001\u001a\u00020\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b»\u0001\u0010\u008b\u0001\"\u0006\b¼\u0001\u0010\u008d\u0001R$\u0010Ã\u0001\u001a\u0005\u0018\u00010¾\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R!\u0010Ä\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÄ\u0001\u0010¤\u0001\"\u0006\bÅ\u0001\u0010¦\u0001R!\u0010Æ\u0001\u001a\u00020\u00058\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÆ\u0001\u0010¤\u0001\"\u0006\bÇ\u0001\u0010¦\u0001R\u001e\u0010U\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bÈ\u0001\u0010w\"\u0005\bÉ\u0001\u0010yR\u001f\u0010Ì\u0001\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bÊ\u0001\u0010w\"\u0005\bË\u0001\u0010yR$\u0010Ò\u0001\u001a\u0005\u0018\u00010Í\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÎ\u0001\u0010Ï\u0001\"\u0006\bÐ\u0001\u0010Ñ\u0001R#\u0010Õ\u0001\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÓ\u0001\u0010\u0086\u0001\"\u0006\bÔ\u0001\u0010\u0088\u0001R,\u0010Ù\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0012\u0018\u00010Pj\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u0001`Ö\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b×\u0001\u0010Ø\u0001R\u001f\u0010Ü\u0001\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bÚ\u0001\u0010w\"\u0005\bÛ\u0001\u0010yR#\u0010ß\u0001\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bÝ\u0001\u0010\u008b\u0001\"\u0006\bÞ\u0001\u0010\u008d\u0001R#\u0010â\u0001\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bà\u0001\u0010\u0086\u0001\"\u0006\bá\u0001\u0010\u0088\u0001R$\u0010è\u0001\u001a\u0005\u0018\u00010ã\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bä\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001R$\u0010î\u0001\u001a\u0005\u0018\u00010é\u00018\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R!\u0010ñ\u0001\u001a\u00020%8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bï\u0001\u0010«\u0001\"\u0006\bð\u0001\u0010\u00ad\u0001R#\u0010ô\u0001\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bò\u0001\u0010\u008b\u0001\"\u0006\bó\u0001\u0010\u008d\u0001R\u001f\u0010÷\u0001\u001a\u00020\u001c8\u0016@\u0016X\u0097\u000f¢\u0006\u000e\u001a\u0005\bõ\u0001\u0010w\"\u0005\bö\u0001\u0010yR!\u0010ú\u0001\u001a\u00020%8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bø\u0001\u0010«\u0001\"\u0006\bù\u0001\u0010\u00ad\u0001R#\u0010ý\u0001\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bû\u0001\u0010\u008b\u0001\"\u0006\bü\u0001\u0010\u008d\u0001R#\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\bþ\u0001\u0010\u008b\u0001\"\u0006\bÿ\u0001\u0010\u008d\u0001R$\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0081\u00028\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R#\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0087\u0002\u0010\u008b\u0001\"\u0006\b\u0088\u0002\u0010\u008d\u0001R,\u0010\u008b\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u0002\u0018\u00010Pj\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u0001`Ö\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u008a\u0002\u0010Ø\u0001R\"\u0010f\u001a\u0004\u0018\u0001068\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u008c\u0002\u0010\u008d\u0002\"\u0006\b\u008e\u0002\u0010\u008f\u0002R,\u0010\u0091\u0002\u001a\u0017\u0012\u0004\u0012\u00020\u0012\u0018\u00010Pj\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u0001`Ö\u00018\u0016X\u0097\u0005¢\u0006\b\u001a\u0006\b\u0090\u0002\u0010Ø\u0001R+\u0010\u0098\u0002\u001a\f\u0018\u00010\u0092\u0002j\u0005\u0018\u0001`\u0093\u00028\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002\"\u0006\b\u0096\u0002\u0010\u0097\u0002R!\u0010\u009b\u0002\u001a\u00020%8\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u0099\u0002\u0010«\u0001\"\u0006\b\u009a\u0002\u0010\u00ad\u0001R#\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u009c\u0002\u0010\u008b\u0001\"\u0006\b\u009d\u0002\u0010\u008d\u0001R#\u0010¡\u0002\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000f¢\u0006\u0010\u001a\u0006\b\u009f\u0002\u0010\u008b\u0001\"\u0006\b \u0002\u0010\u008d\u0001¨\u0006¥\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/model/ICommunityUserExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/livesdk/interactivity/service/model/d;", "Lvh7/e;", BuildConfig.FLAVOR, "canJumpToLiveRoom", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "childrenManagerForbidCreateLiveRoom", "childrenManagerForbidWalletFunctions", "cloneFrom", "Lpy/b;", "getAnchorInfoExt", "Lpy/k;", "getAvatarLarge", "getAvatarMedium", BuildConfig.FLAVOR, "getAvatarUrl", BuildConfig.FLAVOR, "getBadgeImageList", "getBadgeImageListV2", "getBadgeImageListV2Ext", "getCastSecUid", BuildConfig.FLAVOR, "getCommerceUserLevel", "Lcom/bytedance/android/live/base/model/user/j;", "getCommonVipInfo", "getEncryptedId", "getEnterprise", "Lpy/j;", "getFollowInfoExt", "getIdStrKt", BuildConfig.FLAVOR, "getLiveRoomId", "getLocationCity", "getLogPb", "getNewUserBadges", "Lpy/o;", "getOwnRoom", "getPayScores", "isRoomAnchor", "getProperNickName", "getRealNickName", "getRelationship", "getRemarkNameOrNickname", "getRemarkNameOrRealNickName", "getRequestId", "getRoomAutoGiftThanks", "getSearchType", "Lpy/t;", "getUserAttrExt", "getUserAttrFlex", "getUserId", "Lcom/bytedance/android/live/base/model/user/o0;", "getUserIdCompat", "getUserWatchMonthValid", "isEnableShowFansClubReverse", "isEnterpriseVerify", "isFollowing", "isMysteryMan", "isSubscriber", "isVcdAdversaryContentAuthorized", "isVcdAdversaryRelationAuthorized", "isVcdContentAuthorized", "isVcdRelationAuthorized", "isWithCommercePermission", "anchorInfo", BuildConfig.FLAVOR, "setAnchorInfoExt", "model", "setAvatarLargeImplicit", "setAvatarMediumImplicit", "setAvatarThumbImplicit", "url", "setAvatarUrl", BuildConfig.FLAVOR, "badgeImageList", "setBadgeImageListV2", "secUid", "setCastSecUid", "level", "setCommerceUserLevel", "info", "setCommonVipInfo", "enterPrise", "setEnterprise", "followInfo", "setFollowInfoExt", "followStatus", "setFollowStatus", "logPb", "setLogPb", "requestId", "setRequestId", "setSearchType", "shouldUseRealName", "setShouldUseRealName", "userAttr", "setUserAttrExt", "enable", "setUserWatchMonthValid", "contentAuthorized", "relationAuthorized", "setVcdAdversaryAuthorizeState", "enableShowCommerceSale", "setWithCommercePermission", "Lcom/bytedance/android/live/base/model/user/PublicAreaBadgeInfo;", "value", "getPublicAreaBadgeInfo", "()Lcom/bytedance/android/live/base/model/user/PublicAreaBadgeInfo;", "setPublicAreaBadgeInfo", "(Lcom/bytedance/android/live/base/model/user/PublicAreaBadgeInfo;)V", "publicAreaBadgeInfo", "getAdversaryUserStatus", "()I", "setAdversaryUserStatus", "(I)V", "adversaryUserStatus", "getAgeRange", "setAgeRange", "ageRange", "Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "getAnchorLevel", "()Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;", "setAnchorLevel", "(Lcom/bytedance/android/live/base/model/user/api/IAnchorLevel;)V", "anchorLevel", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatarThumbKt", "()Lpy/k;", "setAvatarThumbKt", "(Lpy/k;)V", "avatarThumbKt", "getBackgroundImgUrl", "()Ljava/lang/String;", "setBackgroundImgUrl", "(Ljava/lang/String;)V", "backgroundImgUrl", "Lpy/f;", "getBorder", "()Lpy/f;", "border", "Lcom/bytedance/android/live/base/model/user/e;", "getBottomEntry", "()Lcom/bytedance/android/live/base/model/user/e;", "bottomEntry", "getCity", "setCity", "city", "getDisplayId", "setDisplayId", "displayId", "Lcom/bytedance/android/live/base/model/user/l0;", "getDressInfo", "()Lcom/bytedance/android/live/base/model/user/l0;", "setDressInfo", "(Lcom/bytedance/android/live/base/model/user/l0;)V", "dressInfo", "getEnableCarManagementPermission", "()Z", "setEnableCarManagementPermission", "(Z)V", "enableCarManagementPermission", "getEnableShowCommerceSale", "setEnableShowCommerceSale", "getFanTicketCount", "()J", "setFanTicketCount", "(J)V", "fanTicketCount", "Lcom/bytedance/android/live/base/model/user/t;", "getFansClub", "()Lcom/bytedance/android/live/base/model/user/t;", "setFansClub", "(Lcom/bytedance/android/live/base/model/user/t;)V", "fansClub", "Lcom/bytedance/android/live/api/IFollowInfoKt;", "getFollowInfo", "()Lpy/j;", "getGender", "setGender", "gender", "getIdString", "setIdString", "idString", "Lcom/bytedance/android/live/base/model/user/x;", "getIndustryCertification", "()Lcom/bytedance/android/live/base/model/user/x;", "setIndustryCertification", "(Lcom/bytedance/android/live/base/model/user/x;)V", "industryCertification", "isAnonymous", "setAnonymous", "isVerified", "setVerified", "getLevel", "setLevel", "getLinkMicStats", "setLinkMicStats", "linkMicStats", "Lpy/c;", "getMAuthenticationInfo", "()Lpy/c;", "setMAuthenticationInfo", "(Lpy/c;)V", "mAuthenticationInfo", "getMedal", "setMedal", "medal", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMediaBadgeImageList", "()Ljava/util/List;", "mediaBadgeImageList", "getMysteryMan", "setMysteryMan", "mysteryMan", "getNickName", "setNickName", "nickName", "getPersonalCard", "setPersonalCard", "personalCard", "Lpy/q;", "getPoiInfo", "()Lpy/q;", "setPoiInfo", "(Lpy/q;)V", "poiInfo", "Lcom/bytedance/android/live/base/model/user/d0;", "getProfileStyleParams", "()Lcom/bytedance/android/live/base/model/user/d0;", "setProfileStyleParams", "(Lcom/bytedance/android/live/base/model/user/d0;)V", "profileStyleParams", "getPublicScreenOperateFreq", "setPublicScreenOperateFreq", "publicScreenOperateFreq", "getSafeNicName", "setSafeNicName", "safeNicName", "getSecret", "setSecret", "secret", "getShortId", "setShortId", "shortId", "getSignature", "setSignature", "signature", "getSpecialId", "setSpecialId", "specialId", "Lcom/bytedance/android/live/base/model/user/g0;", "getSubscribe", "()Lcom/bytedance/android/live/base/model/user/g0;", "setSubscribe", "(Lcom/bytedance/android/live/base/model/user/g0;)V", "subscribe", "getTelephone", "setTelephone", "telephone", "getTopFans", "topFans", "getUserAttr", "()Lpy/t;", "setUserAttr", "(Lpy/t;)V", "getUserBadges", "userBadges", "Lpy/d;", "Lcom/bytedance/android/live/api/IBaseUseHonorKt;", "getUserHonor", "()Lpy/d;", "setUserHonor", "(Lpy/d;)V", "userHonor", "getUserWatchMonth", "setUserWatchMonth", "userWatchMonth", "getVerifiedReason", "setVerifiedReason", "verifiedReason", "getWebcastUid", "setWebcastUid", "webcastUid", "base", "<init>", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ICommunityUserExtensionImpl extends ModelExtensionBase<IBaseUser, d> implements d, IBaseUser {
    private final /* synthetic */ IBaseUser $$delegate_0;

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean canJumpToLiveRoom() {
        return this.$$delegate_0.canJumpToLiveRoom();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public <R extends vh7.e<IBaseUser>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public <R extends vh7.e<IBaseUser>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean childrenManagerForbidCreateLiveRoom() {
        return this.$$delegate_0.childrenManagerForbidCreateLiveRoom();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean childrenManagerForbidWalletFunctions() {
        return this.$$delegate_0.childrenManagerForbidWalletFunctions();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public IBaseUser cloneFrom() {
        return this.$$delegate_0.cloneFrom();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getAdversaryUserStatus() {
        return this.$$delegate_0.getAdversaryUserStatus();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getAgeRange() {
        return this.$$delegate_0.getAgeRange();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public py.b getAnchorInfoExt() {
        return this.$$delegate_0.getAnchorInfoExt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public IAnchorLevel getAnchorLevel() {
        return this.$$delegate_0.getAnchorLevel();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public k getAvatarLarge() {
        return this.$$delegate_0.getAvatarLarge();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public k getAvatarMedium() {
        return this.$$delegate_0.getAvatarMedium();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public k getAvatarThumbKt() {
        return this.$$delegate_0.getAvatarThumbKt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getAvatarUrl() {
        return this.$$delegate_0.getAvatarUrl();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getBackgroundImgUrl() {
        return this.$$delegate_0.getBackgroundImgUrl();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public List<k> getBadgeImageList() {
        return this.$$delegate_0.getBadgeImageList();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public List<k> getBadgeImageListV2() {
        return this.$$delegate_0.getBadgeImageListV2();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public List<k> getBadgeImageListV2Ext() {
        return this.$$delegate_0.getBadgeImageListV2Ext();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public f getBorder() {
        return this.$$delegate_0.getBorder();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public com.bytedance.android.live.base.model.user.e getBottomEntry() {
        return this.$$delegate_0.getBottomEntry();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getCastSecUid() {
        return this.$$delegate_0.getCastSecUid();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getCity() {
        return this.$$delegate_0.getCity();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getCommerceUserLevel() {
        return this.$$delegate_0.getCommerceUserLevel();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public j getCommonVipInfo() {
        return this.$$delegate_0.getCommonVipInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getDisplayId() {
        return this.$$delegate_0.getDisplayId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public l0 getDressInfo() {
        return this.$$delegate_0.getDressInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean getEnableCarManagementPermission() {
        return this.$$delegate_0.getEnableCarManagementPermission();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean getEnableShowCommerceSale() {
        return this.$$delegate_0.getEnableShowCommerceSale();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getEncryptedId() {
        return this.$$delegate_0.getEncryptedId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getEnterprise() {
        return this.$$delegate_0.getEnterprise();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public long getFanTicketCount() {
        return this.$$delegate_0.getFanTicketCount();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public t getFansClub() {
        return this.$$delegate_0.getFansClub();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public py.j getFollowInfo() {
        return this.$$delegate_0.getFollowInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public py.j getFollowInfoExt() {
        return this.$$delegate_0.getFollowInfoExt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getGender() {
        return this.$$delegate_0.getGender();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getIdStrKt() {
        return this.$$delegate_0.getIdStrKt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getIdString() {
        return this.$$delegate_0.getIdString();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public x getIndustryCertification() {
        return this.$$delegate_0.getIndustryCertification();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getLevel() {
        return this.$$delegate_0.getLevel();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getLinkMicStats() {
        return this.$$delegate_0.getLinkMicStats();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public long getLiveRoomId() {
        return this.$$delegate_0.getLiveRoomId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getLocationCity() {
        return this.$$delegate_0.getLocationCity();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getLogPb() {
        return this.$$delegate_0.getLogPb();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public py.c getMAuthenticationInfo() {
        return this.$$delegate_0.getMAuthenticationInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public k getMedal() {
        return this.$$delegate_0.getMedal();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public List<k> getMediaBadgeImageList() {
        return this.$$delegate_0.getMediaBadgeImageList();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getMysteryMan() {
        return this.$$delegate_0.getMysteryMan();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public List<k> getNewUserBadges() {
        return this.$$delegate_0.getNewUserBadges();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getNickName() {
        return this.$$delegate_0.getNickName();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public o getOwnRoom() {
        return this.$$delegate_0.getOwnRoom();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public long getPayScores() {
        return this.$$delegate_0.getPayScores();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public k getPersonalCard() {
        return this.$$delegate_0.getPersonalCard();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public q getPoiInfo() {
        return this.$$delegate_0.getPoiInfo();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public d0 getProfileStyleParams() {
        return this.$$delegate_0.getProfileStyleParams();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getProperNickName(boolean r2) {
        return this.$$delegate_0.getProperNickName(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public long getPublicScreenOperateFreq() {
        return this.$$delegate_0.getPublicScreenOperateFreq();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getRealNickName() {
        return this.$$delegate_0.getRealNickName();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getRelationship() {
        return this.$$delegate_0.getRelationship();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getRemarkNameOrNickname() {
        return this.$$delegate_0.getRemarkNameOrNickname();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getRemarkNameOrRealNickName() {
        return this.$$delegate_0.getRemarkNameOrRealNickName();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getRequestId() {
        return this.$$delegate_0.getRequestId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean getRoomAutoGiftThanks() {
        return this.$$delegate_0.getRoomAutoGiftThanks();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getSafeNicName() {
        return this.$$delegate_0.getSafeNicName();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getSearchType() {
        return this.$$delegate_0.getSearchType();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public int getSecret() {
        return this.$$delegate_0.getSecret();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public long getShortId() {
        return this.$$delegate_0.getShortId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getSignature() {
        return this.$$delegate_0.getSignature();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getSpecialId() {
        return this.$$delegate_0.getSpecialId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public g0 getSubscribe() {
        return this.$$delegate_0.getSubscribe();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getTelephone() {
        return this.$$delegate_0.getTelephone();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public List<IBaseUser> getTopFans() {
        return this.$$delegate_0.getTopFans();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public py.t getUserAttr() {
        return this.$$delegate_0.getUserAttr();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public py.t getUserAttrExt() {
        return this.$$delegate_0.getUserAttrExt();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public py.t getUserAttrFlex() {
        return this.$$delegate_0.getUserAttrFlex();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public List<k> getUserBadges() {
        return this.$$delegate_0.getUserBadges();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public py.d getUserHonor() {
        return this.$$delegate_0.getUserHonor();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getUserId() {
        return this.$$delegate_0.getUserId();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public o0 getUserIdCompat() {
        return this.$$delegate_0.getUserIdCompat();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public long getUserWatchMonth() {
        return this.$$delegate_0.getUserWatchMonth();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean getUserWatchMonthValid() {
        return this.$$delegate_0.getUserWatchMonthValid();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getVerifiedReason() {
        return this.$$delegate_0.getVerifiedReason();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public String getWebcastUid() {
        return this.$$delegate_0.getWebcastUid();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isAnonymous() {
        return this.$$delegate_0.isAnonymous();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isEnableShowFansClubReverse() {
        return this.$$delegate_0.isEnableShowFansClubReverse();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isEnterpriseVerify() {
        return this.$$delegate_0.isEnterpriseVerify();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isFollowing() {
        return this.$$delegate_0.isFollowing();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isMysteryMan() {
        return this.$$delegate_0.isMysteryMan();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isSubscriber() {
        return this.$$delegate_0.isSubscriber();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isVcdAdversaryContentAuthorized() {
        return this.$$delegate_0.isVcdAdversaryContentAuthorized();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isVcdAdversaryRelationAuthorized() {
        return this.$$delegate_0.isVcdAdversaryRelationAuthorized();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isVcdContentAuthorized() {
        return this.$$delegate_0.isVcdContentAuthorized();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isVcdRelationAuthorized() {
        return this.$$delegate_0.isVcdRelationAuthorized();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isVerified() {
        return this.$$delegate_0.isVerified();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public boolean isWithCommercePermission() {
        return this.$$delegate_0.isWithCommercePermission();
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAdversaryUserStatus(int r2) {
        this.$$delegate_0.setAdversaryUserStatus(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAgeRange(int r2) {
        this.$$delegate_0.setAgeRange(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAnchorInfoExt(py.b r2) {
        this.$$delegate_0.setAnchorInfoExt(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAnchorLevel(IAnchorLevel r2) {
        this.$$delegate_0.setAnchorLevel(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAnonymous(boolean r2) {
        this.$$delegate_0.setAnonymous(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAvatarLargeImplicit(k r2) {
        this.$$delegate_0.setAvatarLargeImplicit(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAvatarMediumImplicit(k r2) {
        this.$$delegate_0.setAvatarMediumImplicit(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAvatarThumbImplicit(k r2) {
        this.$$delegate_0.setAvatarThumbImplicit(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAvatarThumbKt(k r2) {
        this.$$delegate_0.setAvatarThumbKt(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setAvatarUrl(String r2) {
        this.$$delegate_0.setAvatarUrl(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setBackgroundImgUrl(String r2) {
        this.$$delegate_0.setBackgroundImgUrl(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setBadgeImageListV2(List<? extends k> r2) {
        this.$$delegate_0.setBadgeImageListV2(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setCastSecUid(String r2) {
        this.$$delegate_0.setCastSecUid(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setCity(String r2) {
        this.$$delegate_0.setCity(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setCommerceUserLevel(int r2) {
        this.$$delegate_0.setCommerceUserLevel(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setCommonVipInfo(j r2) {
        this.$$delegate_0.setCommonVipInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setDisplayId(String r2) {
        this.$$delegate_0.setDisplayId(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setDressInfo(l0 r2) {
        this.$$delegate_0.setDressInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setEnableCarManagementPermission(boolean r2) {
        this.$$delegate_0.setEnableCarManagementPermission(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setEnableShowCommerceSale(boolean r2) {
        this.$$delegate_0.setEnableShowCommerceSale(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setEnterprise(int r2) {
        this.$$delegate_0.setEnterprise(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setFanTicketCount(long r2) {
        this.$$delegate_0.setFanTicketCount(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setFansClub(t r2) {
        this.$$delegate_0.setFansClub(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setFollowInfoExt(py.j r2) {
        this.$$delegate_0.setFollowInfoExt(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setFollowStatus(int r2) {
        this.$$delegate_0.setFollowStatus(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setGender(int r2) {
        this.$$delegate_0.setGender(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setIdString(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setIdString(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setIndustryCertification(x r2) {
        this.$$delegate_0.setIndustryCertification(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setLevel(int r2) {
        this.$$delegate_0.setLevel(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setLinkMicStats(int r2) {
        this.$$delegate_0.setLinkMicStats(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setLogPb(String r2) {
        this.$$delegate_0.setLogPb(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setMAuthenticationInfo(py.c r2) {
        this.$$delegate_0.setMAuthenticationInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setMedal(k r2) {
        this.$$delegate_0.setMedal(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setMysteryMan(int r2) {
        this.$$delegate_0.setMysteryMan(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setNickName(String r2) {
        this.$$delegate_0.setNickName(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setPersonalCard(k r2) {
        this.$$delegate_0.setPersonalCard(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setPoiInfo(q r2) {
        this.$$delegate_0.setPoiInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setProfileStyleParams(d0 r2) {
        this.$$delegate_0.setProfileStyleParams(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setPublicScreenOperateFreq(long r2) {
        this.$$delegate_0.setPublicScreenOperateFreq(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setRequestId(String r2) {
        this.$$delegate_0.setRequestId(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setSafeNicName(String r2) {
        this.$$delegate_0.setSafeNicName(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setSearchType(int r2) {
        this.$$delegate_0.setSearchType(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setSecret(int r2) {
        this.$$delegate_0.setSecret(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setShortId(long r2) {
        this.$$delegate_0.setShortId(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setShouldUseRealName(boolean r2) {
        this.$$delegate_0.setShouldUseRealName(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setSignature(String r2) {
        this.$$delegate_0.setSignature(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setSpecialId(String r2) {
        this.$$delegate_0.setSpecialId(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setSubscribe(g0 r2) {
        this.$$delegate_0.setSubscribe(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setTelephone(String r2) {
        this.$$delegate_0.setTelephone(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setUserAttr(py.t r2) {
        this.$$delegate_0.setUserAttr(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setUserAttrExt(py.t r2) {
        this.$$delegate_0.setUserAttrExt(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setUserHonor(py.d r2) {
        this.$$delegate_0.setUserHonor(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setUserWatchMonth(long r2) {
        this.$$delegate_0.setUserWatchMonth(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setUserWatchMonthValid(boolean r2) {
        this.$$delegate_0.setUserWatchMonthValid(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setVcdAdversaryAuthorizeState(boolean r2, boolean r3) {
        this.$$delegate_0.setVcdAdversaryAuthorizeState(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setVerified(boolean r2) {
        this.$$delegate_0.setVerified(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setVerifiedReason(String r2) {
        this.$$delegate_0.setVerifiedReason(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setWebcastUid(String r2) {
        this.$$delegate_0.setWebcastUid(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setWithCommercePermission(boolean r2) {
        this.$$delegate_0.setWithCommercePermission(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public PublicAreaBadgeInfo getPublicAreaBadgeInfo() {
        return (PublicAreaBadgeInfo) get(78, d.class);
    }

    public ICommunityUserExtensionImpl(IBaseUser r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.model.d
    public void setPublicAreaBadgeInfo(PublicAreaBadgeInfo r4) {
        set(78, "public_area_badge_info", d.class, r4);
    }
}
