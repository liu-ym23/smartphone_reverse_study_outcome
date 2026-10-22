package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.f;
import com.ss.ugc.effectplatform.g;
import com.ss.ugc.effectplatform.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\bY\n\u0002\u0010\t\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b/\b\u0017\u0018\u0000 þ\u00012\u00020\u0001:\u0002ÿ\u0001Bç\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\b\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\b\b\u0002\u0010-\u001a\u00020\b\u0012\b\b\u0002\u00100\u001a\u00020\b\u0012\b\b\u0002\u00103\u001a\u00020\b\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u0010=\u001a\u000206\u0012\b\b\u0002\u0010@\u001a\u000206\u0012\b\b\u0002\u0010C\u001a\u000206\u0012\b\b\u0002\u0010F\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\b\b\u0002\u0010S\u001a\u00020\b\u0012\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00000\n\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010_\u001a\u00020\u0006\u0012\b\b\u0002\u0010b\u001a\u00020\u0006\u0012\b\b\u0002\u0010e\u001a\u00020\b\u0012\b\b\u0002\u0010h\u001a\u00020\b\u0012\b\b\u0002\u0010k\u001a\u00020\b\u0012\b\b\u0002\u0010n\u001a\u00020\b\u0012\u0010\b\u0002\u0010q\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010w\u001a\u00020\b\u0012\b\b\u0002\u0010z\u001a\u00020\b\u0012\b\b\u0002\u0010}\u001a\u00020\b\u0012\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u008a\u0001\u001a\u00020\b\u0012\u0011\b\u0002\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u0091\u0001\u001a\u00030\u0090\u0001\u0012\t\b\u0002\u0010\u0097\u0001\u001a\u00020\b\u0012\u0011\b\u0002\u0010\u009a\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u009d\u0001\u001a\u00030\u0090\u0001\u0012\u000b\b\u0002\u0010 \u0001\u001a\u0004\u0018\u00010\b\u0012\u0011\b\u0002\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\u0011\b\u0002\u0010¦\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\t\b\u0002\u0010©\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010¬\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010¯\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010±\u0001\u001a\u00020\b\u0012\t\b\u0002\u0010´\u0001\u001a\u00020\b\u0012\u000b\b\u0002\u0010·\u0001\u001a\u0004\u0018\u00010\b\u0012\t\b\u0002\u0010º\u0001\u001a\u00020\b\u0012\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010Á\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010Ä\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010Ç\u0001\u001a\u0004\u0018\u00010\b\u0012\f\b\u0002\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u0001\u0012\u0012\b\u0002\u0010Ò\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ñ\u0001\u0018\u00010\n\u0012\u000b\b\u0002\u0010Õ\u0001\u001a\u0004\u0018\u00010\b\u0012\t\b\u0002\u0010Ø\u0001\u001a\u00020\u0006\u0012\n\b\u0002\u0010Û\u0001\u001a\u00030\u0090\u0001\u0012\u000b\b\u0002\u0010Þ\u0001\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010á\u0001\u001a\u00030\u0090\u0001\u0012\t\b\u0002\u0010ä\u0001\u001a\u000206\u0012\u000b\b\u0002\u0010ç\u0001\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010ê\u0001\u001a\u00030\u0090\u0001\u0012\u0011\b\u0002\u0010í\u0001\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\n\u0012\u000b\b\u0002\u0010ð\u0001\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010ó\u0001\u001a\u00030\u0090\u0001\u0012\t\b\u0002\u0010ö\u0001\u001a\u00020\u0006\u0012\n\b\u0002\u0010ù\u0001\u001a\u00030\u0090\u0001¢\u0006\u0006\bü\u0001\u0010ý\u0001J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006HÖ\u0001R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\n8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\n8V@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\b8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001aR*\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u001dR\"\u0010-\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010%R\"\u00100\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010%R\"\u00103\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010%R\"\u00107\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b=\u00108\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R\"\u0010@\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b@\u00108\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\"\u0010C\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bC\u00108\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\"\u0010F\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010\u001aR*\u0010M\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010\u001a\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u001dR*\u0010P\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bP\u0010\u001a\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u001dR\"\u0010S\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bS\u0010\"\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010%R*\u0010V\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bV\u0010\u001a\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u001dR(\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00000\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bY\u0010\u001a\u001a\u0004\bZ\u0010\f\"\u0004\b[\u0010\u001dR$\u0010\\\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\\\u0010\"\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010%R\"\u0010_\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b_\u0010G\u001a\u0004\b`\u0010I\"\u0004\ba\u0010KR\"\u0010b\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bb\u0010G\u001a\u0004\bc\u0010I\"\u0004\bd\u0010KR\"\u0010e\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\be\u0010\"\u001a\u0004\bf\u0010\u0011\"\u0004\bg\u0010%R\"\u0010h\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bh\u0010\"\u001a\u0004\bi\u0010\u0011\"\u0004\bj\u0010%R\"\u0010k\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bk\u0010\"\u001a\u0004\bl\u0010\u0011\"\u0004\bm\u0010%R\"\u0010n\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bn\u0010\"\u001a\u0004\bo\u0010\u0011\"\u0004\bp\u0010%R*\u0010q\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bq\u0010\u001a\u001a\u0004\br\u0010\f\"\u0004\bs\u0010\u001dR$\u0010t\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bt\u0010\"\u001a\u0004\bu\u0010\u0011\"\u0004\bv\u0010%R\"\u0010w\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bw\u0010\"\u001a\u0004\bx\u0010\u0011\"\u0004\by\u0010%R\"\u0010z\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bz\u0010\"\u001a\u0004\b{\u0010\u0011\"\u0004\b|\u0010%R\"\u0010}\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b}\u0010\"\u001a\u0004\b~\u0010\u0011\"\u0004\b\u007f\u0010%R)\u0010\u0080\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0080\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R&\u0010\u0085\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010\"\u001a\u0005\b\u0086\u0001\u0010\u0011\"\u0005\b\u0087\u0001\u0010%R)\u0010\u0088\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0081\u0001\u001a\u0006\b\u0088\u0001\u0010\u0082\u0001\"\u0006\b\u0089\u0001\u0010\u0084\u0001R&\u0010\u008a\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\"\u001a\u0005\b\u008b\u0001\u0010\u0011\"\u0005\b\u008c\u0001\u0010%R.\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u001a\u001a\u0005\b\u008e\u0001\u0010\f\"\u0005\b\u008f\u0001\u0010\u001dR*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010\"\u001a\u0005\b\u0098\u0001\u0010\u0011\"\u0005\b\u0099\u0001\u0010%R.\u0010\u009a\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010\u001a\u001a\u0005\b\u009b\u0001\u0010\f\"\u0005\b\u009c\u0001\u0010\u001dR*\u0010\u009d\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u0092\u0001\u001a\u0006\b\u009e\u0001\u0010\u0094\u0001\"\u0006\b\u009f\u0001\u0010\u0096\u0001R(\u0010 \u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b \u0001\u0010\"\u001a\u0005\b¡\u0001\u0010\u0011\"\u0005\b¢\u0001\u0010%R.\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010\u001a\u001a\u0005\b¤\u0001\u0010\f\"\u0005\b¥\u0001\u0010\u001dR.\u0010¦\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b¦\u0001\u0010\u001a\u001a\u0005\b§\u0001\u0010\f\"\u0005\b¨\u0001\u0010\u001dR&\u0010©\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b©\u0001\u0010\"\u001a\u0005\bª\u0001\u0010\u0011\"\u0005\b«\u0001\u0010%R&\u0010¬\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b¬\u0001\u0010\"\u001a\u0005\b\u00ad\u0001\u0010\u0011\"\u0005\b®\u0001\u0010%R)\u0010¯\u0001\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010\u0081\u0001\u001a\u0006\b¯\u0001\u0010\u0082\u0001\"\u0006\b°\u0001\u0010\u0084\u0001R&\u0010±\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010\"\u001a\u0005\b²\u0001\u0010\u0011\"\u0005\b³\u0001\u0010%R&\u0010´\u0001\u001a\u00020\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010\"\u001a\u0005\bµ\u0001\u0010\u0011\"\u0005\b¶\u0001\u0010%R(\u0010·\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010\"\u001a\u0005\b¸\u0001\u0010\u0011\"\u0005\b¹\u0001\u0010%R&\u0010º\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010\"\u001a\u0005\b»\u0001\u0010\u0011\"\u0005\b¼\u0001\u0010%R(\u0010½\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010\"\u001a\u0005\b¾\u0001\u0010\u0011\"\u0005\b¿\u0001\u0010%R\u001a\u0010À\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÀ\u0001\u0010\"R(\u0010Á\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÁ\u0001\u0010\"\u001a\u0005\bÂ\u0001\u0010\u0011\"\u0005\bÃ\u0001\u0010%R(\u0010Ä\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÄ\u0001\u0010\"\u001a\u0005\bÅ\u0001\u0010\u0011\"\u0005\bÆ\u0001\u0010%R(\u0010Ç\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÇ\u0001\u0010\"\u001a\u0005\bÈ\u0001\u0010\u0011\"\u0005\bÉ\u0001\u0010%R,\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R/\u0010Ò\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ñ\u0001\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010\u001a\u001a\u0005\bÓ\u0001\u0010\f\"\u0005\bÔ\u0001\u0010\u001dR(\u0010Õ\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010\"\u001a\u0005\bÖ\u0001\u0010\u0011\"\u0005\b×\u0001\u0010%R&\u0010Ø\u0001\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bØ\u0001\u0010G\u001a\u0005\bÙ\u0001\u0010I\"\u0005\bÚ\u0001\u0010KR*\u0010Û\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010\u0092\u0001\u001a\u0006\bÜ\u0001\u0010\u0094\u0001\"\u0006\bÝ\u0001\u0010\u0096\u0001R(\u0010Þ\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bÞ\u0001\u0010\"\u001a\u0005\bß\u0001\u0010\u0011\"\u0005\bà\u0001\u0010%R*\u0010á\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010\u0092\u0001\u001a\u0006\bâ\u0001\u0010\u0094\u0001\"\u0006\bã\u0001\u0010\u0096\u0001R&\u0010ä\u0001\u001a\u0002068\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bä\u0001\u00108\u001a\u0005\bå\u0001\u0010:\"\u0005\bæ\u0001\u0010<R(\u0010ç\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bç\u0001\u0010\"\u001a\u0005\bè\u0001\u0010\u0011\"\u0005\bé\u0001\u0010%R*\u0010ê\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bê\u0001\u0010\u0092\u0001\u001a\u0006\bë\u0001\u0010\u0094\u0001\"\u0006\bì\u0001\u0010\u0096\u0001R.\u0010í\u0001\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bí\u0001\u0010\u001a\u001a\u0005\bî\u0001\u0010\f\"\u0005\bï\u0001\u0010\u001dR(\u0010ð\u0001\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bð\u0001\u0010\"\u001a\u0005\bñ\u0001\u0010\u0011\"\u0005\bò\u0001\u0010%R*\u0010ó\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010\u0092\u0001\u001a\u0006\bô\u0001\u0010\u0094\u0001\"\u0006\bõ\u0001\u0010\u0096\u0001R&\u0010ö\u0001\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0015\n\u0005\bö\u0001\u0010G\u001a\u0005\b÷\u0001\u0010I\"\u0005\bø\u0001\u0010KR*\u0010ù\u0001\u001a\u00030\u0090\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010\u0092\u0001\u001a\u0006\bú\u0001\u0010\u0094\u0001\"\u0006\bû\u0001\u0010\u0096\u0001¨\u0006\u0080\u0002"}, d2 = {"Lcom/ss/ugc/effectplatform/model/Effect;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "", "equals", "", "hashCode", "", "toString", "", "getInternalRequirements$effect_model_release", "()Ljava/util/List;", "getInternalRequirements", "getInternalType$effect_model_release", "getInternalType", "getInternalModelNames$effect_model_release", "()Ljava/lang/String;", "getInternalModelNames", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "requirements", "Ljava/util/List;", "getRequirements", "setRequirements", "(Ljava/util/List;)V", "types", "getTypes", "setTypes", "model_names", "Ljava/lang/String;", "getModel_names", "setModel_names", "(Ljava/lang/String;)V", DBDefinition.NAME, "getName", "setName", "_requirements", "requirements_sec", "getRequirements_sec", "setRequirements_sec", "hint", "getHint", "setHint", "id", "getId", "setId", "effect_id", "getEffect_id", "setEffect_id", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "file_url", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "getFile_url", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setFile_url", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "icon_url", "getIcon_url", "setIcon_url", "hint_icon", "getHint_icon", "setHint_icon", "hint_file", "getHint_file", "setHint_file", "hint_file_format", "I", "getHint_file_format", "()I", "setHint_file_format", "(I)V", "_type", "types_sec", "getTypes_sec", "setTypes_sec", "tags", "getTags", "setTags", "tags_updated_at", "getTags_updated_at", "setTags_updated_at", "children", "getChildren", "setChildren", "child_effects", "getChild_effects", "setChild_effects", "parent", "getParent", "setParent", "effect_type", "getEffect_type", "setEffect_type", "source", "getSource", "setSource", "designer_id", "getDesigner_id", "setDesigner_id", "designer_encrypted_id", "getDesigner_encrypted_id", "setDesigner_encrypted_id", EffectConfiguration.KEY_DEVICE_PLATFORM, "getDevice_platform", "setDevice_platform", "schema", "getSchema", "setSchema", "music", "getMusic", "setMusic", DBDefinition.EXTRA, "getExtra", "setExtra", "sdk_extra", "getSdk_extra", "setSdk_extra", "ad_raw_data", "getAd_raw_data", "setAd_raw_data", "composer_params", "getComposer_params", "setComposer_params", "is_busi", "Z", "()Z", "set_busi", "(Z)V", "iop_id", "getIop_id", "setIop_id", "is_iop", "set_iop", "resource_id", "getResource_id", "setResource_id", "bind_ids", "getBind_ids", "setBind_ids", "", "ptime", "J", "getPtime", "()J", "setPtime", "(J)V", "grade_key", "getGrade_key", "setGrade_key", "challenge", "getChallenge", "setChallenge", "use_number", "getUse_number", "setUse_number", "extra_tag", "getExtra_tag", "setExtra_tag", "videoPlayURLs", "getVideoPlayURLs", "setVideoPlayURLs", "composerPath", "getComposerPath", "setComposerPath", "zipPath", "getZipPath", "setZipPath", "unzipPath", "getUnzipPath", "setUnzipPath", "isDownloaded", "setDownloaded", EffectConfiguration.KEY_PANEL, "getPanel", "setPanel", "searchType", "getSearchType", "setSearchType", "effect_source_id", "getEffect_source_id", "setEffect_source_id", "platformVersion", "getPlatformVersion", "setPlatformVersion", "recId", "getRecId", "setRecId", "_model_names", "model_names_sec", "getModel_names_sec", "setModel_names_sec", "original_effect_id", "getOriginal_effect_id", "setOriginal_effect_id", "nickname", "getNickname", "setNickname", "Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "avatar_thumb", "Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "getAvatar_thumb", "()Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "setAvatar_thumb", "(Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;)V", "Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "ranking_List", "getRanking_List", "setRanking_List", "server_extra", "getServer_extra", "setServer_extra", "force_insert_priority", "getForce_insert_priority", "setForce_insert_priority", "force_insert_position", "getForce_insert_position", "setForce_insert_position", "labels", "getLabels", "setLabels", "rec_tag", "getRec_tag", "setRec_tag", "designer_avatar", "getDesigner_avatar", "setDesigner_avatar", "designer_nickname", "getDesigner_nickname", "setDesigner_nickname", "used_count", "getUsed_count", "setUsed_count", "covers", "getCovers", "setCovers", "keywords", "getKeywords", "setKeywords", "created_at", "getCreated_at", "setCreated_at", "provider", "getProvider", "setProvider", "zipSize", "getZipSize", "setZipSize", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;Lcom/ss/ugc/effectplatform/model/UrlModel;ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;Ljava/util/List;Ljava/lang/String;IJLjava/lang/String;JLcom/ss/ugc/effectplatform/model/UrlModel;Ljava/lang/String;JLjava/util/List;Ljava/lang/String;JIJ)V", "Companion", "a", "effect_model_release"}, k = 1, mv = {1, 4, 0})
public class Effect implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final a Companion = null;
    private String _model_names;
    private List<String> _requirements;
    private List<String> _type;
    private String ad_raw_data;
    private AuthorThumbModel avatar_thumb;
    private List<String> bind_ids;
    private List<String> challenge;
    private List<? extends Effect> child_effects;
    private List<String> children;
    private List<String> composerPath;
    private String composer_params;
    private List<? extends UrlModel> covers;
    private long created_at;
    private UrlModel designer_avatar;
    private String designer_encrypted_id;
    private String designer_id;
    private String designer_nickname;
    private String device_platform;
    private String effect_id;
    private String effect_source_id;
    private int effect_type;
    private String extra;
    private String extra_tag;
    private UrlModel file_url;
    private long force_insert_position;
    private int force_insert_priority;
    private String grade_key;
    private String hint;
    private UrlModel hint_file;
    private int hint_file_format;
    private UrlModel hint_icon;
    private UrlModel icon_url;
    private String id;
    private String iop_id;
    private boolean isDownloaded;
    private boolean is_busi;
    private boolean is_iop;
    private String keywords;
    private String labels;
    private String model_names;
    private String model_names_sec;
    private List<String> music;
    private String name;
    private String nickname;
    private String original_effect_id;
    private String panel;
    private String parent;
    private String platformVersion;
    private int provider;
    private long ptime;
    private List<? extends RankingEffectModel> ranking_List;
    private String recId;
    private long rec_tag;
    private List<String> requirements;
    private List<String> requirements_sec;
    private String resource_id;
    private String schema;
    private String sdk_extra;
    private String searchType;
    private String server_extra;
    private int source;
    private List<String> tags;
    private String tags_updated_at;
    private List<String> types;
    private List<String> types_sec;
    private String unzipPath;
    private long use_number;
    private long used_count;
    private List<String> videoPlayURLs;
    private String zipPath;
    private long zipSize;

    public static final class a extends AndroidEffectParceler {
        public a(int r1) {
        }
    }

    public static class b implements Parcelable.Creator {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r1) {
            return new Effect[r1];
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r84) {
            Parcel r0 = r84;
            Effect.Companion.getClass();
            String r1 = r84.readString();
            ArrayList<String> r2 = r84.createStringArrayList();
            ArrayList<String> r6 = r84.createStringArrayList();
            String r3 = r84.readString();
            String r4 = r84.readString();
            String r5 = r84.readString();
            Parcelable r7 = r0.readParcelable(Effect.class.getClassLoader());
            if (r7 == null) goto L152;
            UrlModel r10 = (UrlModel) r7;
            Parcelable r8 = r0.readParcelable(Effect.class.getClassLoader());
            if (r8 == null) goto L150;
            UrlModel r11 = (UrlModel) r8;
            Parcelable r9 = r0.readParcelable(Effect.class.getClassLoader());
            if (r9 == null) goto L148;
            UrlModel r12 = (UrlModel) r9;
            Parcelable r13 = r0.readParcelable(Effect.class.getClassLoader());
            if (r13 == null) goto L146;
            UrlModel r14 = (UrlModel) r13;
            int r15 = r84.readInt();
            ArrayList<String> r16 = r84.createStringArrayList();
            ArrayList<String> r17 = r84.createStringArrayList();
            ArrayList<String> r18 = r84.createStringArrayList();
            String r19 = r84.readString();
            ArrayList<String> r110 = r84.createStringArrayList();
            int r111 = r84.readInt();
            ArrayList r112 = new ArrayList(r111);
        L11:
            if (r111 == 0) goto L13;
            ArrayList r20 = r112;
            Parcelable r21 = r84.readParcelable(Effect.class.getClassLoader());
            if (r21 == null) goto L144;
            r20.add((Effect) r21);
            r111 = r111 - 1;
            r0 = r84;
            r112 = r20;
            r1 = r1;
            goto L11
        L144:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.Effect");
        L13:
            if (r1 != null) goto L16;
            r1 = "";
        L16:
            if (r2 != null) goto L19;
            r2 = new ArrayList();
        L19:
            if (r3 == null) goto L21;
            String r22 = r3;
        L22:
            if (r4 == null) goto L24;
            String r23 = r4;
        L25:
            if (r5 == null) goto L27;
            String r24 = r5;
        L28:
            if (r16 == null) goto L30;
            ArrayList<String> r25 = r16;
        L31:
            if (r19 == null) goto L33;
            String r26 = r19;
        L34:
            String r27 = r84.readString();
            int r28 = r84.readInt();
            int r29 = r84.readInt();
            String r30 = r84.readString();
            if (r30 == null) goto L37;
            String r210 = r30;
        L38:
            String r31 = r84.readString();
            if (r31 == null) goto L41;
            String r32 = r31;
        L42:
            String r33 = r84.readString();
            if (r33 == null) goto L45;
            String r34 = r33;
        L46:
            String r35 = r84.readString();
            if (r35 == null) goto L49;
            String r36 = r35;
        L50:
            ArrayList<String> r37 = r84.createStringArrayList();
            String r38 = r84.readString();
            String r39 = r84.readString();
            if (r39 == null) goto L53;
            String r310 = r39;
        L54:
            String r40 = r84.readString();
            if (r40 == null) goto L57;
            String r311 = r40;
        L58:
            String r41 = r84.readString();
            if (r41 == null) goto L61;
            String r312 = r41;
        L63:
            if (r84.readInt() != 1) goto L65;
            boolean r313 = true;
        L66:
            String r42 = r84.readString();
            if (r42 == null) goto L69;
            String r314 = r42;
        L71:
            if (r84.readInt() != 1) goto L73;
            boolean r43 = true;
        L74:
            String r44 = r84.readString();
            if (r44 == null) goto L77;
            String r45 = r44;
        L78:
            ArrayList<String> r46 = r84.createStringArrayList();
            long r47 = r84.readLong();
            String r48 = r84.readString();
            if (r48 == null) goto L81;
            String r49 = r48;
        L82:
            ArrayList<String> r410 = r84.createStringArrayList();
            long r411 = r84.readLong();
            String r412 = r84.readString();
            ArrayList<String> r50 = r84.createStringArrayList();
            ArrayList<String> r51 = r84.createStringArrayList();
            String r52 = r84.readString();
            if (r52 == null) goto L85;
            String r53 = r52;
        L86:
            String r54 = r84.readString();
            if (r54 == null) goto L89;
            String r55 = r54;
        L91:
            if (r84.readInt() != 1) goto L93;
            boolean r56 = true;
        L94:
            String r57 = r84.readString();
            if (r57 == null) goto L97;
            String r58 = r57;
        L98:
            String r59 = r84.readString();
            if (r59 == null) goto L101;
            String r510 = r59;
        L102:
            String r511 = r84.readString();
            String r60 = r84.readString();
            if (r60 == null) goto L105;
            String r512 = r60;
        L106:
            String r513 = r84.readString();
            String r61 = r84.readString();
            String r62 = r84.readString();
            String r63 = r84.readString();
            String r64 = r84.readString();
            Parcelable r65 = r0.readParcelable(AuthorThumbModel.class.getClassLoader());
            if ((r65 instanceof AuthorThumbModel) == true) goto L109;
            r65 = null;
        L109:
            AuthorThumbModel r66 = (AuthorThumbModel) r65;
            int r67 = r84.readInt();
            ArrayList r68 = new ArrayList();
            int r69 = 0;
        L110:
            if (r69 >= r67) goto L118;
            Parcelable r70 = r0.readParcelable(RankingEffectModel.class.getClassLoader());
            if ((r70 instanceof RankingEffectModel) == true) goto L114;
            r70 = null;
        L114:
            RankingEffectModel r71 = (RankingEffectModel) r70;
            if (r71 == null) goto L117;
            r68.add(r71);
        L117:
            r69 = r69 + 1;
            goto L110
        L118:
            String r610 = r84.readString();
            int r611 = r84.readInt();
            long r612 = r84.readLong();
            String r72 = r84.readString();
            long r73 = r84.readLong();
            Parcelable r74 = r0.readParcelable(Effect.class.getClassLoader());
            if (r74 == null) goto L139;
            UrlModel r79 = (UrlModel) r74;
            String r80 = r84.readString();
            long r81 = r84.readLong();
            int r75 = r84.readInt();
            ArrayList r76 = new ArrayList();
            int r77 = 0;
        L121:
            if (r77 >= r75) goto L128;
            Parcelable r78 = r0.readParcelable(Effect.class.getClassLoader());
            if ((r78 instanceof Parcelable) == true) goto L125;
            r78 = null;
        L125:
            if (r78 == null) goto L127;
            r76.add(r78);
        L127:
            r77 = r77 + 1;
            goto L121
        L128:
            ArrayList<String> r113 = r25;
            String r114 = r26;
            Effect r115 = new Effect(r1, r2, r6, r22, r23, r24, r10, r11, r12, r14, r15, r113, r17, r18, r114, r110, r112, r27, r28, r29, r210, r32, r34, r36, r37, r38, r310, r311, r312, r313, r314, r43, r45, r46, r47, r49, r410, r411, r412, r50, r51, r53, r55, r56, r58, r510, r511, r512, r513, r61, r62, r63, r64, r66, r68, r610, r611, r612, r72, r73, r79, r80, r81, r76, r84.readString(), r84.readLong(), r84.readInt(), r84.readLong());
            ArrayList<String> r82 = r84.createStringArrayList();
            if (r82 != null) goto L132;
            r82 = new ArrayList();
        L132:
            r115.setRequirements(r82);
            ArrayList<String> r83 = r84.createStringArrayList();
            if (r83 != null) goto L136;
            r83 = new ArrayList();
        L136:
            r115.setTypes(r83);
            r115.setModel_names(r84.readString());
            return r115;
        L139:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        L105:
            r512 = "";
            goto L106
        L101:
            r510 = "";
            goto L102
        L97:
            r58 = "";
            goto L98
        L93:
            r56 = false;
            goto L94
        L89:
            r55 = "";
            goto L91
        L85:
            r53 = "";
            goto L86
        L81:
            r49 = "";
            goto L82
        L77:
            r45 = "";
            goto L78
        L73:
            r43 = false;
            goto L74
        L69:
            r314 = "";
            goto L71
        L65:
            r313 = false;
            goto L66
        L61:
            r312 = "";
            goto L63
        L57:
            r311 = "";
            goto L58
        L53:
            r310 = "";
            goto L54
        L49:
            r36 = "";
            goto L50
        L45:
            r34 = "";
            goto L46
        L41:
            r32 = "";
            goto L42
        L37:
            r210 = "";
            goto L38
        L33:
            r26 = "";
            goto L34
        L30:
            r25 = new ArrayList();
            goto L31
        L27:
            r24 = "";
            goto L28
        L24:
            r23 = "";
            goto L25
        L21:
            r22 = "";
            goto L22
        L146:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        L148:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        L150:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        L152:
            throw new TypeCastException("null cannot be cast to non-null type com.ss.ugc.effectplatform.model.UrlModel");
        }
    }

    static {
        Companion = new a(0);
        CREATOR = new b();
    }

    public Effect() {
        this(null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, false, null, false, null, null, 0, null, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, null, null, 0, null, null, 0, 0, 0, -1, -1, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getModel_names() {
        String r0 = this._model_names;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L23;
        String r3 = getModel_names_sec();
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L23;
        int r5 = flc.a.a;
        j r6 = f.a;
        j r7 = f.a;
        if (r7 == null) goto L21;
        String r8 = r7.decrypt(getModel_names_sec());
    L22:
        this._model_names = r8;
        goto L23
    L21:
        r8 = null;
        goto L22
    L13:
        if (StringsKt.isBlank(r3) == true) goto L16;
        r4 = false;
    L23:
        String r9 = this._model_names;
        if (r9 != null) goto L26;
    L27:
        r1 = true;
    L28:
        if (r1 == false) goto L31;
        return this.model_names;
    L31:
        return this._model_names;
    L26:
        if (StringsKt.isBlank(r9) == false) goto L28;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    public List<String> getRequirements() {
        List<String> r0 = this.requirements_sec;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L22;
        List<String> r2 = this.requirements_sec;
        if (r2 != null) goto L13;
    L14:
        int r3 = flc.a.a;
        j r4 = f.a;
        if (r4 == null) goto L19;
        List<String> r5 = g.a(r4, this.requirements_sec);
        if (r5 == null) goto L19;
    L20:
        this._requirements = r5;
    L19:
        r5 = new ArrayList();
        goto L20
    L13:
        if (r2.size() != this._requirements.size()) goto L14;
    L22:
        if (this._requirements.isEmpty() == false) goto L25;
        return this.requirements;
    L25:
        return this._requirements;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public List<String> getTypes() {
        List<String> r0 = this.types_sec;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L22;
        List<String> r2 = this.types_sec;
        if (r2 != null) goto L13;
    L14:
        int r3 = flc.a.a;
        j r4 = f.a;
        if (r4 == null) goto L19;
        List<String> r5 = g.a(r4, this.types_sec);
        if (r5 == null) goto L19;
    L20:
        this._type = r5;
    L19:
        r5 = new ArrayList();
        goto L20
    L13:
        if (r2.size() != this._type.size()) goto L14;
    L22:
        if (this._type.isEmpty() == false) goto L25;
        return this.types;
    L25:
        return this._type;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public String toString() {
        return "Effect(name='" + getName() + "', _requirements=" + this._requirements + ", requirements_sec=" + this.requirements_sec + ", hint='" + getHint() + "', id='" + getId() + "', original_effect_id='" + getOriginal_effect_id() + "', effect_id='" + getEffect_id() + "', file_url=" + getFile_url() + ", icon_url=" + getIcon_url() + ", hint_icon=" + getHint_icon() + ", hint_file=" + getHint_file() + ", hint_file_format=" + getHint_file_format() + ", _type=" + this._type + ", types_sec=" + this.types_sec + ", tags=" + getTags() + ", tags_updated_at='" + getTags_updated_at() + "', children=" + getChildren() + ", child_effects=" + getChild_effects() + ", parent=" + getParent() + ", effect_type=" + getEffect_type() + ", source=" + getSource() + ", designer_id='" + getDesigner_id() + "', designer_encrypted_id='" + getDesigner_encrypted_id() + "', device_platform='" + getDevice_platform() + "', schema='" + getSchema() + "', music=" + getMusic() + ", extra='" + getExtra() + "', sdk_extra='" + getSdk_extra() + "', ad_raw_data='" + getAd_raw_data() + "', composer_params='" + getComposer_params() + "', is_busi=" + is_busi() + ", iop_id='" + getIop_id() + "', is_iop=" + is_iop() + ", resource_id='" + getResource_id() + "', bind_ids=" + getBind_ids() + ", publish_time=" + getPtime() + ", grade_key='" + getGrade_key() + "', composerPath=" + getComposerPath() + ", zipPath='" + getZipPath() + "', unzipPath='" + getUnzipPath() + "', isDownloaded=" + isDownloaded() + ", panel='" + getPanel() + "', recId=" + getRecId() + ", _model_names=" + this._model_names + ", model_names_sec='" + getModel_names_sec() + "', labels='" + getLabels() + "', rec_tag='" + getRec_tag() + "', designer_avatar=" + getDesigner_avatar() + ", designer_nickname=" + getDesigner_nickname() + ", used_count=" + getUsed_count() + ", covers=" + getCovers() + ", keywords=" + getKeywords() + ", created_at=" + getCreated_at() + ", provider=" + getProvider() + ", zipSize=" + getZipSize() + ')';
    }

    public int hashCode() {
        return (((getId().hashCode() * 31) + getEffect_id().hashCode()) * 31) + getResource_id().hashCode();
    }

    public String getAd_raw_data() {
        return this.ad_raw_data;
    }

    public AuthorThumbModel getAvatar_thumb() {
        return this.avatar_thumb;
    }

    public List<String> getBind_ids() {
        return this.bind_ids;
    }

    public List<String> getChallenge() {
        return this.challenge;
    }

    public List<Effect> getChild_effects() {
        return this.child_effects;
    }

    public List<String> getChildren() {
        return this.children;
    }

    public List<String> getComposerPath() {
        return this.composerPath;
    }

    public String getComposer_params() {
        return this.composer_params;
    }

    public List<UrlModel> getCovers() {
        return this.covers;
    }

    public long getCreated_at() {
        return this.created_at;
    }

    public UrlModel getDesigner_avatar() {
        return this.designer_avatar;
    }

    public String getDesigner_encrypted_id() {
        return this.designer_encrypted_id;
    }

    public String getDesigner_id() {
        return this.designer_id;
    }

    public String getDesigner_nickname() {
        return this.designer_nickname;
    }

    public String getDevice_platform() {
        return this.device_platform;
    }

    public String getEffect_id() {
        return this.effect_id;
    }

    public String getEffect_source_id() {
        return this.effect_source_id;
    }

    public int getEffect_type() {
        return this.effect_type;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getExtra_tag() {
        return this.extra_tag;
    }

    public UrlModel getFile_url() {
        return this.file_url;
    }

    public long getForce_insert_position() {
        return this.force_insert_position;
    }

    public int getForce_insert_priority() {
        return this.force_insert_priority;
    }

    public String getGrade_key() {
        return this.grade_key;
    }

    public String getHint() {
        return this.hint;
    }

    public UrlModel getHint_file() {
        return this.hint_file;
    }

    public int getHint_file_format() {
        return this.hint_file_format;
    }

    public UrlModel getHint_icon() {
        return this.hint_icon;
    }

    public UrlModel getIcon_url() {
        return this.icon_url;
    }

    public String getId() {
        return this.id;
    }

    public final String getInternalModelNames$effect_model_release() {
        return this._model_names;
    }

    public final List<String> getInternalRequirements$effect_model_release() {
        return this._requirements;
    }

    public final List<String> getInternalType$effect_model_release() {
        return this._type;
    }

    public String getIop_id() {
        return this.iop_id;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public String getLabels() {
        return this.labels;
    }

    public String getModel_names_sec() {
        return this.model_names_sec;
    }

    public List<String> getMusic() {
        return this.music;
    }

    public String getName() {
        return this.name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOriginal_effect_id() {
        return this.original_effect_id;
    }

    public String getPanel() {
        return this.panel;
    }

    public String getParent() {
        return this.parent;
    }

    public final String getPlatformVersion() {
        return this.platformVersion;
    }

    public int getProvider() {
        return this.provider;
    }

    public long getPtime() {
        return this.ptime;
    }

    public List<RankingEffectModel> getRanking_List() {
        return this.ranking_List;
    }

    public String getRecId() {
        return this.recId;
    }

    public long getRec_tag() {
        return this.rec_tag;
    }

    public final List<String> getRequirements_sec() {
        return this.requirements_sec;
    }

    public String getResource_id() {
        return this.resource_id;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSdk_extra() {
        return this.sdk_extra;
    }

    public String getSearchType() {
        return this.searchType;
    }

    public String getServer_extra() {
        return this.server_extra;
    }

    public int getSource() {
        return this.source;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTags_updated_at() {
        return this.tags_updated_at;
    }

    public final List<String> getTypes_sec() {
        return this.types_sec;
    }

    public String getUnzipPath() {
        return this.unzipPath;
    }

    public long getUse_number() {
        return this.use_number;
    }

    public long getUsed_count() {
        return this.used_count;
    }

    public List<String> getVideoPlayURLs() {
        return this.videoPlayURLs;
    }

    public String getZipPath() {
        return this.zipPath;
    }

    public long getZipSize() {
        return this.zipSize;
    }

    public boolean isDownloaded() {
        return this.isDownloaded;
    }

    public boolean is_busi() {
        return this.is_busi;
    }

    public boolean is_iop() {
        return this.is_iop;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Effect) == true) goto L8;
        return false;
    L8:
        Effect r6 = (Effect) r5;
        if ((!Intrinsics.areEqual(getId(), r6.getId())) == false) goto L12;
        return false;
    L12:
        if ((!Intrinsics.areEqual(getEffect_id(), r6.getEffect_id())) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(getResource_id(), r6.getResource_id())) == false) goto L17;
        return false;
    L17:
        return true;
    }

    public void setAd_raw_data(String r1) {
        this.ad_raw_data = r1;
    }

    public void setAvatar_thumb(AuthorThumbModel r1) {
        this.avatar_thumb = r1;
    }

    public void setBind_ids(List<String> r1) {
        this.bind_ids = r1;
    }

    public void setChallenge(List<String> r1) {
        this.challenge = r1;
    }

    public void setChild_effects(List<? extends Effect> r1) {
        this.child_effects = r1;
    }

    public void setChildren(List<String> r1) {
        this.children = r1;
    }

    public void setComposerPath(List<String> r1) {
        this.composerPath = r1;
    }

    public void setComposer_params(String r1) {
        this.composer_params = r1;
    }

    public void setCovers(List<? extends UrlModel> r1) {
        this.covers = r1;
    }

    public void setCreated_at(long r1) {
        this.created_at = r1;
    }

    public void setDesigner_avatar(UrlModel r1) {
        this.designer_avatar = r1;
    }

    public void setDesigner_encrypted_id(String r1) {
        this.designer_encrypted_id = r1;
    }

    public void setDesigner_id(String r1) {
        this.designer_id = r1;
    }

    public void setDesigner_nickname(String r1) {
        this.designer_nickname = r1;
    }

    public void setDevice_platform(String r1) {
        this.device_platform = r1;
    }

    public void setDownloaded(boolean r1) {
        this.isDownloaded = r1;
    }

    public void setEffect_id(String r1) {
        this.effect_id = r1;
    }

    public void setEffect_source_id(String r1) {
        this.effect_source_id = r1;
    }

    public void setEffect_type(int r1) {
        this.effect_type = r1;
    }

    public void setExtra(String r1) {
        this.extra = r1;
    }

    public void setExtra_tag(String r1) {
        this.extra_tag = r1;
    }

    public void setFile_url(UrlModel r1) {
        this.file_url = r1;
    }

    public void setForce_insert_position(long r1) {
        this.force_insert_position = r1;
    }

    public void setForce_insert_priority(int r1) {
        this.force_insert_priority = r1;
    }

    public void setGrade_key(String r1) {
        this.grade_key = r1;
    }

    public void setHint(String r1) {
        this.hint = r1;
    }

    public void setHint_file(UrlModel r1) {
        this.hint_file = r1;
    }

    public void setHint_file_format(int r1) {
        this.hint_file_format = r1;
    }

    public void setHint_icon(UrlModel r1) {
        this.hint_icon = r1;
    }

    public void setIcon_url(UrlModel r1) {
        this.icon_url = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setIop_id(String r1) {
        this.iop_id = r1;
    }

    public void setKeywords(String r1) {
        this.keywords = r1;
    }

    public void setLabels(String r1) {
        this.labels = r1;
    }

    public final void setModel_names(String r1) {
        this.model_names = r1;
    }

    public void setModel_names_sec(String r1) {
        this.model_names_sec = r1;
    }

    public void setMusic(List<String> r1) {
        this.music = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setNickname(String r1) {
        this.nickname = r1;
    }

    public void setOriginal_effect_id(String r1) {
        this.original_effect_id = r1;
    }

    public void setPanel(String r1) {
        this.panel = r1;
    }

    public void setParent(String r1) {
        this.parent = r1;
    }

    public final void setPlatformVersion(String r1) {
        this.platformVersion = r1;
    }

    public void setProvider(int r1) {
        this.provider = r1;
    }

    public void setPtime(long r1) {
        this.ptime = r1;
    }

    public void setRanking_List(List<? extends RankingEffectModel> r1) {
        this.ranking_List = r1;
    }

    public void setRecId(String r1) {
        this.recId = r1;
    }

    public void setRec_tag(long r1) {
        this.rec_tag = r1;
    }

    public void setRequirements(List<String> r1) {
        this.requirements = r1;
    }

    public final void setRequirements_sec(List<String> r1) {
        this.requirements_sec = r1;
    }

    public void setResource_id(String r1) {
        this.resource_id = r1;
    }

    public void setSchema(String r1) {
        this.schema = r1;
    }

    public void setSdk_extra(String r1) {
        this.sdk_extra = r1;
    }

    public void setSearchType(String r1) {
        this.searchType = r1;
    }

    public void setServer_extra(String r1) {
        this.server_extra = r1;
    }

    public void setSource(int r1) {
        this.source = r1;
    }

    public void setTags(List<String> r1) {
        this.tags = r1;
    }

    public void setTags_updated_at(String r1) {
        this.tags_updated_at = r1;
    }

    public void setTypes(List<String> r1) {
        this.types = r1;
    }

    public final void setTypes_sec(List<String> r1) {
        this.types_sec = r1;
    }

    public void setUnzipPath(String r1) {
        this.unzipPath = r1;
    }

    public void setUse_number(long r1) {
        this.use_number = r1;
    }

    public void setUsed_count(long r1) {
        this.used_count = r1;
    }

    public void setVideoPlayURLs(List<String> r1) {
        this.videoPlayURLs = r1;
    }

    public void setZipPath(String r1) {
        this.zipPath = r1;
    }

    public void setZipSize(long r1) {
        this.zipSize = r1;
    }

    public void set_busi(boolean r1) {
        this.is_busi = r1;
    }

    public void set_iop(boolean r1) {
        this.is_iop = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        Companion.getClass();
        r5.writeString(getName());
        r5.writeStringList(getInternalRequirements$effect_model_release());
        r5.writeStringList(getRequirements_sec());
        r5.writeString(getHint());
        r5.writeString(getId());
        r5.writeString(getEffect_id());
        r5.writeParcelable(getFile_url(), r6);
        r5.writeParcelable(getIcon_url(), r6);
        r5.writeParcelable(getHint_icon(), r6);
        r5.writeParcelable(getHint_file(), r6);
        r5.writeInt(getHint_file_format());
        r5.writeStringList(getInternalType$effect_model_release());
        r5.writeStringList(getTypes_sec());
        r5.writeStringList(getTags());
        r5.writeString(getTags_updated_at());
        r5.writeStringList(getChildren());
        List<Effect> r0 = getChild_effects();
        r5.writeInt(r0.size());
        Iterator<Effect> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r5.writeParcelable(r1.next(), r6);
        goto L4
    L6:
        r5.writeString(getParent());
        r5.writeInt(getEffect_type());
        r5.writeInt(getSource());
        r5.writeString(getDesigner_id());
        r5.writeString(getDesigner_encrypted_id());
        r5.writeString(getDevice_platform());
        r5.writeString(getSchema());
        r5.writeStringList(getMusic());
        r5.writeString(getExtra());
        r5.writeString(getSdk_extra());
        r5.writeString(getAd_raw_data());
        r5.writeString(getComposer_params());
        r5.writeInt(is_busi() ? 1 : 0);
        r5.writeString(getIop_id());
        r5.writeInt(is_iop() ? 1 : 0);
        r5.writeString(getResource_id());
        r5.writeStringList(getBind_ids());
        r5.writeLong(getPtime());
        r5.writeString(getGrade_key());
        r5.writeStringList(getChallenge());
        r5.writeLong(getUse_number());
        r5.writeString(getExtra_tag());
        r5.writeStringList(getVideoPlayURLs());
        r5.writeStringList(getComposerPath());
        r5.writeString(getZipPath());
        r5.writeString(getUnzipPath());
        r5.writeInt(isDownloaded() ? 1 : 0);
        r5.writeString(getPanel());
        r5.writeString(getSearchType());
        r5.writeString(getEffect_source_id());
        r5.writeString(getPlatformVersion());
        r5.writeString(getRecId());
        r5.writeString(getInternalModelNames$effect_model_release());
        r5.writeString(getModel_names_sec());
        r5.writeString(getOriginal_effect_id());
        r5.writeString(getNickname());
        r5.writeParcelable(getAvatar_thumb(), r6);
        List<RankingEffectModel> r2 = getRanking_List();
        int r3 = 0;
        if (r2 == null) goto L9;
        int r4 = r2.size();
    L10:
        r5.writeInt(r4);
        if (r2 == null) goto L16;
        Iterator<RankingEffectModel> r7 = r2.iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        r5.writeParcelable(r7.next(), r6);
    L16:
        r5.writeString(getServer_extra());
        r5.writeInt(getForce_insert_priority());
        r5.writeLong(getForce_insert_position());
        r5.writeString(getLabels());
        r5.writeLong(getRec_tag());
        r5.writeParcelable(getDesigner_avatar(), r6);
        r5.writeString(getDesigner_nickname());
        r5.writeLong(getUsed_count());
        List<UrlModel> r8 = getCovers();
        if (r8 == null) goto L19;
        r3 = r8.size();
    L19:
        r5.writeInt(r3);
        if (r8 == null) goto L25;
        Iterator<UrlModel> r9 = r8.iterator();
    L23:
        if (r9.hasNext() == false) goto L25;
        r5.writeParcelable(r9.next(), r6);
    L25:
        r5.writeString(getKeywords());
        r5.writeLong(getCreated_at());
        r5.writeInt(getProvider());
        r5.writeLong(getZipSize());
        r5.writeStringList(getRequirements());
        r5.writeStringList(getTypes());
        r5.writeString(getModel_names());
        return;
    L9:
        r4 = 0;
        goto L10
    }

    public Effect(String r4, List<String> r5, List<String> r6, String r7, String r8, String r9, UrlModel r10, UrlModel r11, UrlModel r12, UrlModel r13, int r14, List<String> r15, List<String> r16, List<String> r17, String r18, List<String> r19, List<? extends Effect> r20, String r21, int r22, int r23, String r24, String r25, String r26, String r27, List<String> r28, String r29, String r30, String r31, String r32, boolean r33, String r34, boolean r35, String r36, List<String> r37, long r38, String r40, List<String> r41, long r42, String r44, List<String> r45, List<String> r46, String r47, String r48, boolean r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, AuthorThumbModel r59, List<? extends RankingEffectModel> r60, String r61, int r62, long r63, String r65, long r66, UrlModel r68, String r69, long r70, List<? extends UrlModel> r72, String r73, long r74, int r76, long r77) {
        this.name = r4;
        this._requirements = r5;
        this.requirements_sec = r6;
        this.hint = r7;
        this.id = r8;
        this.effect_id = r9;
        this.file_url = r10;
        this.icon_url = r11;
        this.hint_icon = r12;
        this.hint_file = r13;
        this.hint_file_format = r14;
        this._type = r15;
        this.types_sec = r16;
        this.tags = r17;
        this.tags_updated_at = r18;
        this.children = r19;
        this.child_effects = r20;
        this.parent = r21;
        this.effect_type = r22;
        this.source = r23;
        this.designer_id = r24;
        this.designer_encrypted_id = r25;
        this.device_platform = r26;
        this.schema = r27;
        this.music = r28;
        this.extra = r29;
        this.sdk_extra = r30;
        this.ad_raw_data = r31;
        this.composer_params = r32;
        this.is_busi = r33;
        this.iop_id = r34;
        this.is_iop = r35;
        this.resource_id = r36;
        this.bind_ids = r37;
        this.ptime = r38;
        this.grade_key = r40;
        this.challenge = r41;
        this.use_number = r42;
        this.extra_tag = r44;
        this.videoPlayURLs = r45;
        this.composerPath = r46;
        this.zipPath = r47;
        this.unzipPath = r48;
        this.isDownloaded = r49;
        this.panel = r50;
        this.searchType = r51;
        this.effect_source_id = r52;
        this.platformVersion = r53;
        this.recId = r54;
        this._model_names = r55;
        this.model_names_sec = r56;
        this.original_effect_id = r57;
        this.nickname = r58;
        this.avatar_thumb = r59;
        this.ranking_List = r60;
        this.server_extra = r61;
        this.force_insert_priority = r62;
        this.force_insert_position = r63;
        this.labels = r65;
        this.rec_tag = r66;
        this.designer_avatar = r68;
        this.designer_nickname = r69;
        this.used_count = r70;
        this.covers = r72;
        this.keywords = r73;
        this.created_at = r74;
        this.provider = r76;
        this.zipSize = r77;
        this.requirements = new ArrayList();
        this.types = new ArrayList();
    }

    public /* synthetic */ Effect(String r75, List r76, List r77, String r78, String r79, String r80, UrlModel r81, UrlModel r82, UrlModel r83, UrlModel r84, int r85, List r86, List r87, List r88, String r89, List r90, List r91, String r92, int r93, int r94, String r95, String r96, String r97, String r98, List r99, String r100, String r101, String r102, String r103, boolean r104, String r105, boolean r106, String r107, List r108, long r109, String r111, List r112, long r113, String r115, List r116, List r117, String r118, String r119, boolean r120, String r121, String r122, String r123, String r124, String r125, String r126, String r127, String r128, String r129, AuthorThumbModel r130, List r131, String r132, int r133, long r134, String r136, long r137, UrlModel r139, String r140, long r141, List r143, String r144, long r145, int r147, long r148, int r150, int r151, int r152, DefaultConstructorMarker r153) {
        if ((r150 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r150 & 2) == 0) goto L9;
        List r4 = new ArrayList();
    L11:
        if ((r150 & 4) == 0) goto L13;
        List r5 = null;
    L15:
        if ((r150 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r150 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r150 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r150 & 64) == 0) goto L29;
        UrlModel r10 = new UrlModel(null, null, null, null, 15, null);
    L31:
        if ((r150 & 128) == 0) goto L33;
        UrlModel r11 = new UrlModel(null, null, null, null, 15, null);
    L35:
        if ((r150 & 256) == 0) goto L37;
        UrlModel r12 = new UrlModel(null, null, null, null, 15, null);
    L39:
        if ((r150 & 512) == 0) goto L41;
        UrlModel r13 = new UrlModel(null, null, null, null, 15, null);
    L43:
        if ((r150 & 1024) == 0) goto L45;
        int r14 = 0;
    L47:
        if ((r150 & 2048) == 0) goto L49;
        List r6 = new ArrayList();
    L51:
        if ((r150 & 4096) == 0) goto L53;
        List r15 = null;
    L55:
        if ((r150 & 8192) == 0) goto L57;
        List r3 = new ArrayList();
    L58:
        List r16 = r3;
        if ((r150 & 16384) == 0) goto L61;
        String r17 = "";
    L63:
        if ((r150 & 32768) == 0) goto L65;
        List r18 = null;
    L67:
        if ((r150 & 65536) == 0) goto L69;
        List r20 = new ArrayList();
    L71:
        if ((r150 & 131072) == 0) goto L73;
        String r22 = null;
    L75:
        if ((r150 & 262144) == 0) goto L77;
        int r23 = 0;
    L79:
        if ((r150 & 524288) == 0) goto L81;
        int r24 = 0;
    L83:
        if ((r150 & 1048576) == 0) goto L85;
        String r25 = "";
    L87:
        if ((r150 & 2097152) == 0) goto L89;
        String r26 = "";
    L91:
        if ((r150 & 4194304) == 0) goto L93;
        String r27 = "";
    L95:
        if ((r150 & 8388608) == 0) goto L97;
        String r28 = "";
    L99:
        if ((r150 & 16777216) == 0) goto L101;
        List r29 = null;
    L103:
        if ((r150 & 33554432) == 0) goto L105;
        String r30 = null;
    L107:
        if ((r150 & 67108864) == 0) goto L109;
        String r31 = "";
    L111:
        if ((r150 & 134217728) == 0) goto L113;
        String r32 = "";
    L115:
        if ((r150 & 268435456) == 0) goto L117;
        String r33 = "";
    L119:
        if ((r150 & 536870912) == 0) goto L121;
        boolean r34 = false;
    L123:
        if ((r150 & 1073741824) == 0) goto L125;
        String r35 = "";
    L127:
        if ((r150 & IntCompanionObject.MIN_VALUE) == 0) goto L129;
        boolean r0 = false;
    L131:
        if ((r151 & 1) == 0) goto L133;
        String r36 = "";
    L135:
        if ((r151 & 2) == 0) goto L137;
        List r37 = null;
    L138:
        long r39 = 0;
        if ((r151 & 4) == 0) goto L141;
        long r41 = 0;
    L143:
        if ((r151 & 8) == 0) goto L145;
        String r38 = "";
    L147:
        if ((r151 & 16) == 0) goto L149;
        List r43 = null;
    L151:
        if ((r151 & 32) == 0) goto L153;
        long r44 = 0;
    L155:
        if ((r151 & 64) == 0) goto L157;
        String r46 = null;
    L158:
        boolean r154 = r0;
        if ((r151 & 128) == 0) goto L161;
        List r1 = null;
    L162:
        List r47 = r1;
        if ((r151 & 256) == 0) goto L165;
        List r19 = null;
    L166:
        List r48 = r19;
        if ((r151 & 512) == 0) goto L169;
        String r21 = "";
    L170:
        String r49 = r21;
        if ((r151 & 1024) == 0) goto L173;
        String r40 = "";
    L174:
        String r50 = r40;
        if ((r151 & 2048) == 0) goto L177;
        boolean r42 = false;
    L178:
        boolean r51 = r42;
        if ((r151 & 4096) == 0) goto L181;
        String r45 = "";
    L182:
        String r52 = r45;
        if ((r151 & 8192) == 0) goto L185;
        String r53 = "";
    L186:
        String r155 = r53;
        if ((r151 & 16384) == 0) goto L189;
        String r54 = null;
    L191:
        if ((r151 & 32768) == 0) goto L193;
        String r110 = "760.0.0.269-alpha.24";
    L195:
        if ((r151 & 65536) == 0) goto L197;
        String r114 = null;
    L199:
        if ((r151 & 131072) == 0) goto L201;
        String r210 = null;
    L203:
        if ((r151 & 262144) == 0) goto L205;
        String r55 = null;
    L207:
        if ((r151 & 524288) == 0) goto L209;
        String r56 = null;
    L211:
        if ((r151 & 1048576) == 0) goto L213;
        String r57 = null;
    L215:
        if ((r151 & 2097152) == 0) goto L217;
        AuthorThumbModel r58 = null;
    L219:
        if ((r151 & 4194304) == 0) goto L221;
        List r59 = null;
    L223:
        if ((r151 & 8388608) == 0) goto L225;
        String r510 = null;
    L227:
        if ((r151 & 16777216) == 0) goto L229;
        int r511 = -1;
    L231:
        if ((r151 & 33554432) == 0) goto L233;
        long r60 = -1;
    L235:
        if ((r151 & 67108864) == 0) goto L237;
        String r62 = null;
    L239:
        if ((r151 & 134217728) == 0) goto L241;
        long r63 = -1;
    L243:
        if ((r151 & 268435456) == 0) goto L245;
        UrlModel r65 = new UrlModel(null, null, null, null, 15, null);
    L247:
        if ((r151 & 536870912) == 0) goto L249;
        String r66 = null;
    L251:
        if ((r151 & 1073741824) == 0) goto L253;
        long r67 = 0;
    L255:
        if ((r151 & IntCompanionObject.MIN_VALUE) == 0) goto L257;
        List r61 = null;
    L259:
        if ((r152 & 1) == 0) goto L261;
        String r69 = null;
    L263:
        if ((r152 & 2) == 0) goto L265;
        long r70 = 0;
    L267:
        if ((r152 & 4) == 0) goto L269;
        int r72 = 0;
    L271:
        if ((r152 & 8) != 0) goto L274;
        r39 = r148;
    L274:
        this(r2, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r6, r15, r16, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r154, r36, r37, r41, r38, r43, r44, r46, r47, r48, r49, r50, r51, r52, r155, r54, r110, r114, r210, r55, r56, r57, r58, r59, r510, r511, r60, r62, r63, r65, r66, r67, r61, r69, r70, r72, r39);
        return;
    L269:
        r72 = r147;
        goto L271
    L265:
        r70 = r145;
        goto L267
    L261:
        r69 = r144;
        goto L263
    L257:
        r61 = r143;
        goto L259
    L253:
        r67 = r141;
        goto L255
    L249:
        r66 = r140;
        goto L251
    L245:
        r65 = r139;
        goto L247
    L241:
        r63 = r137;
        goto L243
    L237:
        r62 = r136;
        goto L239
    L233:
        r60 = r134;
        goto L235
    L229:
        r511 = r133;
        goto L231
    L225:
        r510 = r132;
        goto L227
    L221:
        r59 = r131;
        goto L223
    L217:
        r58 = r130;
        goto L219
    L213:
        r57 = r129;
        goto L215
    L209:
        r56 = r128;
        goto L211
    L205:
        r55 = r127;
        goto L207
    L201:
        r210 = r126;
        goto L203
    L197:
        r114 = r125;
        goto L199
    L193:
        r110 = r124;
        goto L195
    L189:
        r54 = r123;
        goto L191
    L185:
        r53 = r122;
        goto L186
    L181:
        r45 = r121;
        goto L182
    L177:
        r42 = r120;
        goto L178
    L173:
        r40 = r119;
        goto L174
    L169:
        r21 = r118;
        goto L170
    L165:
        r19 = r117;
        goto L166
    L161:
        r1 = r116;
        goto L162
    L157:
        r46 = r115;
        goto L158
    L153:
        r44 = r113;
        goto L155
    L149:
        r43 = r112;
        goto L151
    L145:
        r38 = r111;
        goto L147
    L141:
        r41 = r109;
        goto L143
    L137:
        r37 = r108;
        goto L138
    L133:
        r36 = r107;
        goto L135
    L129:
        r0 = r106;
        goto L131
    L125:
        r35 = r105;
        goto L127
    L121:
        r34 = r104;
        goto L123
    L117:
        r33 = r103;
        goto L119
    L113:
        r32 = r102;
        goto L115
    L109:
        r31 = r101;
        goto L111
    L105:
        r30 = r100;
        goto L107
    L101:
        r29 = r99;
        goto L103
    L97:
        r28 = r98;
        goto L99
    L93:
        r27 = r97;
        goto L95
    L89:
        r26 = r96;
        goto L91
    L85:
        r25 = r95;
        goto L87
    L81:
        r24 = r94;
        goto L83
    L77:
        r23 = r93;
        goto L79
    L73:
        r22 = r92;
        goto L75
    L69:
        r20 = r91;
        goto L71
    L65:
        r18 = r90;
        goto L67
    L61:
        r17 = r89;
        goto L63
    L57:
        r3 = r88;
        goto L58
    L53:
        r15 = r87;
        goto L55
    L49:
        r6 = r86;
        goto L51
    L45:
        r14 = r85;
        goto L47
    L41:
        r13 = r84;
        goto L43
    L37:
        r12 = r83;
        goto L39
    L33:
        r11 = r82;
        goto L35
    L29:
        r10 = r81;
        goto L31
    L25:
        r9 = r80;
        goto L27
    L21:
        r8 = r79;
        goto L23
    L17:
        r7 = r78;
        goto L19
    L13:
        r5 = r77;
        goto L15
    L9:
        r4 = r76;
        goto L11
    L5:
        r2 = r75;
        goto L7
    }
}
