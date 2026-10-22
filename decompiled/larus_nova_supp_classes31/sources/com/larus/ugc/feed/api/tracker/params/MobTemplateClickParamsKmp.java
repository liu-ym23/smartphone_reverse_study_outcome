package com.larus.ugc.feed.api.tracker.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\be\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u009f\u00012\u00060\u0001j\u0002`\u0002:\u0004\u009e\u0001\u009f\u0001Bï\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b%\u0010&BÇ\u0002\b\u0010\u0012\u0006\u0010'\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010$\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0004\b%\u0010*J\u000b\u0010l\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010?J\u0010\u0010u\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010v\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010x\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010UJ\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u0010^J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010?J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u0010^J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u0010^Jø\u0002\u0010\u008a\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0003\u0010\u008b\u0001J\u0007\u0010\u008c\u0001\u001a\u00020\rJ\u0016\u0010\u008d\u0001\u001a\u00020\u001d2\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001HÖ\u0003J\n\u0010\u0090\u0001\u001a\u00020\rHÖ\u0001J\n\u0010\u0091\u0001\u001a\u00020\u0004HÖ\u0001J\u001b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\rJ-\u0010\u0097\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u00002\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0001¢\u0006\u0003\b\u009d\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010,\u001a\u0004\b0\u0010.R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010,\u001a\u0004\b2\u0010.R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010,\u001a\u0004\b4\u0010.R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010,\u001a\u0004\b6\u0010.R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010,\u001a\u0004\b8\u0010.R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010,\u001a\u0004\b:\u0010.R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010,\u001a\u0004\b<\u0010.R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010@\u0012\u0004\b=\u0010,\u001a\u0004\b>\u0010?R \u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010@\u0012\u0004\bA\u0010,\u001a\u0004\bB\u0010?R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u0010,\u001a\u0004\bD\u0010.R \u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010@\u0012\u0004\bE\u0010,\u001a\u0004\bF\u0010?R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010,\u001a\u0004\bH\u0010.R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bI\u0010,\u001a\u0004\bJ\u0010.R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bK\u0010,\u001a\u0004\bL\u0010.R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010,\u001a\u0004\bN\u0010.R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010,\u001a\u0004\bP\u0010.R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bQ\u0010,\u001a\u0004\bR\u0010.R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010V\u0012\u0004\bS\u0010,\u001a\u0004\bT\u0010UR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bW\u0010,\u001a\u0004\bX\u0010.R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bY\u0010,\u001a\u0004\bZ\u0010.R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b[\u0010,\u001a\u0004\b\\\u0010.R \u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010_\u0012\u0004\b]\u0010,\u001a\u0004\b\u001c\u0010^R \u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010@\u0012\u0004\b`\u0010,\u001a\u0004\ba\u0010?R \u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010_\u0012\u0004\bb\u0010,\u001a\u0004\b\u001f\u0010^R\u001e\u0010 \u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bc\u0010,\u001a\u0004\bd\u0010.R\u001e\u0010!\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010,\u001a\u0004\bf\u0010.R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bg\u0010,\u001a\u0004\bh\u0010.R\u001e\u0010#\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bi\u0010,\u001a\u0004\bj\u0010.R \u0010$\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010_\u0012\u0004\bk\u0010,\u001a\u0004\b$\u0010^¨\u0006 \u0001"}, d2 = {"Lcom/larus/ugc/feed/api/tracker/params/MobTemplateClickParamsKmp;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "botId", "", "templateId", "enterFrom", "chatType", "templateType", "templateSubType", "templateSource", "creatorId", "position", "", "pageIndex", "templateRecReqId", "actionBarTemplateId", "aiGenerateTabId", "aiGenerateTabType", "aiGenerateTabName", "recommendFrom", "currentPage", "previousPage", "useTemplateUV", "", "conversationId", "templateRecExtra", "subType", "isImageReferencePublic", "", "imageReferenceCount", "isHasCaption", "enterMethod", "currentPageKey", "templateUseTag", "buttonType", "isHasReplica", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBotId$annotations", "()V", "getBotId", "()Ljava/lang/String;", "getTemplateId$annotations", "getTemplateId", "getEnterFrom$annotations", "getEnterFrom", "getChatType$annotations", "getChatType", "getTemplateType$annotations", "getTemplateType", "getTemplateSubType$annotations", "getTemplateSubType", "getTemplateSource$annotations", "getTemplateSource", "getCreatorId$annotations", "getCreatorId", "getPosition$annotations", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageIndex$annotations", "getPageIndex", "getTemplateRecReqId$annotations", "getTemplateRecReqId", "getActionBarTemplateId$annotations", "getActionBarTemplateId", "getAiGenerateTabId$annotations", "getAiGenerateTabId", "getAiGenerateTabType$annotations", "getAiGenerateTabType", "getAiGenerateTabName$annotations", "getAiGenerateTabName", "getRecommendFrom$annotations", "getRecommendFrom", "getCurrentPage$annotations", "getCurrentPage", "getPreviousPage$annotations", "getPreviousPage", "getUseTemplateUV$annotations", "getUseTemplateUV", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getConversationId$annotations", "getConversationId", "getTemplateRecExtra$annotations", "getTemplateRecExtra", "getSubType$annotations", "getSubType", "isImageReferencePublic$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageReferenceCount$annotations", "getImageReferenceCount", "isHasCaption$annotations", "getEnterMethod$annotations", "getEnterMethod", "getCurrentPageKey$annotations", "getCurrentPageKey", "getTemplateUseTag$annotations", "getTemplateUseTag", "getButtonType$annotations", "getButtonType", "isHasReplica$annotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/ugc/feed/api/tracker/params/MobTemplateClickParamsKmp;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$feed_kmp_api_release", "$serializer", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@Serializable
public final class MobTemplateClickParamsKmp implements Parcelable {
    public static final Parcelable.Creator<MobTemplateClickParamsKmp> CREATOR = null;
    public static final b Companion = null;
    public final String A;
    public final String B;
    public final String C;
    public final Boolean D;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final Integer i;
    public final Integer j;
    public final String k;
    public final Integer l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final Long s;
    public final String t;
    public final String u;
    public final String v;
    public final Boolean w;
    public final Integer x;
    public final Boolean y;
    public final String z;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<MobTemplateClickParamsKmp> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.ugc.feed.api.tracker.params.MobTemplateClickParamsKmp", r0, 30);
            r1.j("bot_id", true);
            r1.j("template_id", true);
            r1.j("enter_from", true);
            r1.j("chat_type", true);
            r1.j("template_type", true);
            r1.j("template_sub_type", true);
            r1.j("template_source", true);
            r1.j("creator_id", true);
            r1.j("position", true);
            r1.j("page_index", true);
            r1.j("template_rec_req_id", true);
            r1.j("action_bar_template_id", true);
            r1.j("ai_generate_tab_id", true);
            r1.j("ai_generate_tab_type", true);
            r1.j("ai_generate_tab_name", true);
            r1.j("recommend_from", true);
            r1.j("current_page", true);
            r1.j("previous_page", true);
            r1.j("use_template_uv", true);
            r1.j("conversation_id", true);
            r1.j("template_rec_extra", true);
            r1.j("sub_type", true);
            r1.j("is_image_reference_public", true);
            r1.j("image_reference_count", true);
            r1.j("is_has_caption", true);
            r1.j("enter_method", true);
            r1.j("current_page_key", true);
            r1.j("template_use_tag", true);
            r1.j("button_type", true);
            r1.j("is_has_replica", true);
            b = r1;
        }

        public final d<?>[] childSerializers() {
            v2 r1 = v2.a;
            w0 r2 = w0.a;
            i r3 = i.a;
            return new d[]{kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r2), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(g1.a), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r3), kuc.a.d(r2), kuc.a.d(r3), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r1), kuc.a.d(r3)};
        }

        public final d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r59) {
            Intrinsics.checkNotNullParameter(r59, "decoder");
            g2 r1 = b;
            muc.c r0 = r59.beginStructure(r1);
            Boolean r11 = null;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r2 = v2.a;
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            String r10 = (String) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 2, r2, null);
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 3, r2, null);
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 4, r2, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 5, r2, null);
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 6, r2, null);
            String r4 = (String) r0.decodeNullableSerializableElement(r1, 7, r2, null);
            w0 r12 = w0.a;
            Integer r8 = (Integer) r0.decodeNullableSerializableElement(r1, 8, r12, null);
            Integer r5 = (Integer) r0.decodeNullableSerializableElement(r1, 9, r12, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 10, r2, null);
            Integer r16 = (Integer) r0.decodeNullableSerializableElement(r1, 11, r12, null);
            String r24 = (String) r0.decodeNullableSerializableElement(r1, 12, r2, null);
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 13, r2, null);
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 14, r2, null);
            String r19 = (String) r0.decodeNullableSerializableElement(r1, 15, r2, null);
            String r20 = (String) r0.decodeNullableSerializableElement(r1, 16, r2, null);
            String r21 = (String) r0.decodeNullableSerializableElement(r1, 17, r2, null);
            Long r22 = (Long) r0.decodeNullableSerializableElement(r1, 18, g1.a, null);
            String r23 = (String) r0.decodeNullableSerializableElement(r1, 19, r2, null);
            String r25 = (String) r0.decodeNullableSerializableElement(r1, 20, r2, null);
            String r26 = (String) r0.decodeNullableSerializableElement(r1, 21, r2, null);
            i r27 = i.a;
            Boolean r28 = (Boolean) r0.decodeNullableSerializableElement(r1, 22, r27, null);
            Integer r29 = (Integer) r0.decodeNullableSerializableElement(r1, 23, r12, null);
            Boolean r110 = (Boolean) r0.decodeNullableSerializableElement(r1, 24, r27, null);
            String r30 = (String) r0.decodeNullableSerializableElement(r1, 25, r2, null);
            String r31 = (String) r0.decodeNullableSerializableElement(r1, 26, r2, null);
            String r32 = (String) r0.decodeNullableSerializableElement(r1, 27, r2, null);
            String r33 = r26;
            String r40 = (String) r0.decodeNullableSerializableElement(r1, 28, r2, null);
            Boolean r41 = (Boolean) r0.decodeNullableSerializableElement(r1, 29, r27, null);
            Boolean r36 = r110;
            Boolean r34 = r28;
            Integer r35 = r29;
            String r37 = r30;
            String r38 = r31;
            String r39 = r32;
            int r111 = 1073741823;
            String r112 = r9;
            String r310 = r25;
            Long r311 = r22;
            String r312 = r23;
            String r210 = r21;
            String r211 = r20;
            String r113 = r3;
            String r114 = r4;
            Integer r212 = r8;
            String r115 = r13;
            String r116 = r15;
            String r213 = r19;
            String r214 = r18;
            Integer r215 = r5;
            String r216 = r6;
            String r117 = r10;
            String r118 = r14;
            String r119 = r7;
            String r217 = r17;
            Integer r218 = r16;
        L55:
            r0.endStructure(r1);
            return new MobTemplateClickParamsKmp(r111, r112, r117, r119, r118, r115, r116, r113, r114, r212, r215, r216, r218, r24, r217, r214, r213, r211, r210, r311, r312, r310, r33, r34, r35, r36, r37, r38, r39, r40, r41);
        L5:
            String r42 = null;
            String r43 = null;
            Boolean r44 = null;
            String r45 = null;
            String r46 = null;
            String r47 = null;
            String r48 = null;
            Integer r120 = null;
            String r121 = null;
            Boolean r122 = null;
            String r123 = null;
            Long r124 = null;
            String r313 = null;
            String r314 = null;
            String r315 = null;
            String r49 = null;
            String r410 = null;
            String r411 = null;
            String r412 = null;
            String r413 = null;
            Integer r414 = null;
            Integer r415 = null;
            String r416 = null;
            Integer r417 = null;
            String r418 = null;
            String r50 = null;
            String r51 = null;
            String r52 = null;
            String r53 = null;
            int r54 = 0;
            boolean r55 = true;
        L6:
            if (r55 == false) goto L54;
            String r56 = r48;
            int r57 = r0.decodeElementIndex(r1);
            switch(r57) {
                case -1: goto L51;
                case 0: goto L50;
                case 1: goto L47;
                case 2: goto L45;
                case 3: goto L43;
                case 4: goto L41;
                case 5: goto L39;
                case 6: goto L37;
                case 7: goto L36;
                case 8: goto L35;
                case 9: goto L34;
                case 10: goto L33;
                case 11: goto L32;
                case 12: goto L31;
                case 13: goto L30;
                case 14: goto L29;
                case 15: goto L28;
                case 16: goto L27;
                case 17: goto L26;
                case 18: goto L25;
                case 19: goto L23;
                case 20: goto L22;
                case 21: goto L20;
                case 22: goto L18;
                case 23: goto L17;
                case 24: goto L16;
                case 25: goto L15;
                case 26: goto L14;
                case 27: goto L13;
                case 28: goto L12;
                case 29: goto L11;
                default: goto L10;
            };
        L11:
            r11 = (Boolean) r0.decodeNullableSerializableElement(r1, 29, i.a, r11);
            int r58 = 536870912;
        L19:
            r54 = r54 | r58;
            Unit r60 = Unit.INSTANCE;
        L21:
            r43 = r43;
            String r61 = r47;
            String r125 = r123;
            String r219 = r315;
            String r220 = r49;
            r410 = r410;
            r411 = r411;
            String r316 = r412;
            Integer r317 = r414;
            Integer r318 = r415;
            String r319 = r416;
            Integer r320 = r417;
            String r221 = r418;
            String r222 = r50;
            String r223 = r51;
            String r224 = r52;
            String r225 = r53;
            r124 = r124;
            String r62 = r46;
            Boolean r126 = r122;
            String r63 = r45;
            String r127 = r121;
            Boolean r64 = r44;
            Boolean r128 = r11;
            String r65 = r413;
            Integer r129 = r120;
            String r130 = r56;
        L49:
            String r321 = r65;
            r44 = r64;
            r45 = r63;
            r46 = r62;
            r47 = r61;
            r48 = r130;
            r120 = r129;
            r11 = r128;
            r121 = r127;
            r122 = r126;
            r123 = r125;
            r43 = r43;
            String r226 = r314;
            r42 = r42;
        L53:
            r42 = r42;
            r53 = r225;
            r52 = r224;
            r51 = r223;
            r50 = r222;
            r418 = r221;
            r314 = r226;
            r315 = r219;
            r49 = r220;
            r410 = r410;
            r411 = r411;
            r412 = r316;
            r413 = r321;
            r414 = r317;
            r415 = r318;
            r416 = r319;
            r417 = r320;
            goto L6
        L12:
            r43 = (String) r0.decodeNullableSerializableElement(r1, 28, v2.a, r43);
            r58 = 268435456;
            goto L19
        L13:
            r42 = (String) r0.decodeNullableSerializableElement(r1, 27, v2.a, r42);
            r58 = 134217728;
            goto L19
        L14:
            r121 = (String) r0.decodeNullableSerializableElement(r1, 26, v2.a, r121);
            r58 = 67108864;
            goto L19
        L15:
            r46 = (String) r0.decodeNullableSerializableElement(r1, 25, v2.a, r46);
            r58 = 33554432;
            goto L19
        L16:
            r122 = (Boolean) r0.decodeNullableSerializableElement(r1, 24, i.a, r122);
            r58 = 16777216;
            goto L19
        L17:
            r120 = (Integer) r0.decodeNullableSerializableElement(r1, 23, w0.a, r120);
            r58 = 8388608;
            goto L19
        L18:
            r44 = (Boolean) r0.decodeNullableSerializableElement(r1, 22, i.a, r44);
            r58 = 4194304;
            goto L19
        L20:
            r124 = r124;
            r45 = (String) r0.decodeNullableSerializableElement(r1, 21, v2.a, r45);
            r54 = r54 | 2097152;
            Unit r66 = Unit.INSTANCE;
            goto L21
        L22:
            r47 = (String) r0.decodeNullableSerializableElement(r1, 20, v2.a, r47);
            r54 = r54 | 1048576;
            Unit r67 = Unit.INSTANCE;
        L24:
            r411 = r411;
            r316 = r412;
            String r68 = r413;
            r317 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            String r69 = r56;
            r124 = r124;
        L44:
            r219 = r315;
            r220 = r49;
        L48:
            Boolean r510 = r44;
            r65 = r68;
            r42 = r42;
            r125 = r123;
            r126 = r122;
            r127 = r121;
            r128 = r11;
            r129 = r120;
            r130 = r69;
            r61 = r47;
            r62 = r46;
            r63 = r45;
            r64 = r510;
            goto L49
        L23:
            r123 = (String) r0.decodeNullableSerializableElement(r1, 19, v2.a, r123);
            r54 = r54 | 524288;
            Unit r70 = Unit.INSTANCE;
            goto L24
        L25:
            r124 = (Long) r0.decodeNullableSerializableElement(r1, 18, g1.a, r124);
            r54 = r54 | 262144;
            Unit r71 = Unit.INSTANCE;
            r316 = r412;
            r321 = r413;
            Integer r72 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            String r227 = r56;
        L42:
            r220 = r49;
            r410 = r410;
        L46:
            r226 = r314;
            r219 = r315;
        L52:
            r317 = r72;
            r43 = r43;
            r48 = r227;
            goto L53
        L26:
            r69 = (String) r0.decodeNullableSerializableElement(r1, 17, v2.a, r56);
            r54 = r54 | 131072;
            Unit r73 = Unit.INSTANCE;
            r411 = r411;
            r316 = r412;
            r68 = r413;
            r317 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            goto L44
        L27:
            r227 = r56;
            String r74 = (String) r0.decodeNullableSerializableElement(r1, 16, v2.a, r53);
            r54 = r54 | 65536;
            Unit r75 = Unit.INSTANCE;
            r225 = r74;
            r316 = r412;
            r321 = r413;
            r72 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            goto L42
        L28:
            r225 = r53;
            String r76 = (String) r0.decodeNullableSerializableElement(r1, 15, v2.a, r52);
            r54 = r54 | 32768;
            Unit r77 = Unit.INSTANCE;
            r224 = r76;
            r69 = r56;
            r411 = r411;
            r316 = r412;
            r68 = r413;
            r317 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            goto L44
        L29:
            r225 = r53;
            r227 = r56;
            r224 = r52;
            String r78 = (String) r0.decodeNullableSerializableElement(r1, 14, v2.a, r51);
            r54 = r54 | 16384;
            Unit r79 = Unit.INSTANCE;
            r223 = r78;
            r316 = r412;
            r321 = r413;
            r72 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            goto L42
        L30:
            r224 = r52;
            r225 = r53;
            r223 = r51;
            String r80 = (String) r0.decodeNullableSerializableElement(r1, 13, v2.a, r50);
            r54 = r54 | 8192;
            Unit r81 = Unit.INSTANCE;
            r222 = r80;
            r69 = r56;
            r411 = r411;
            r316 = r412;
            r68 = r413;
            r317 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            goto L44
        L31:
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r227 = r56;
            r222 = r50;
            String r82 = (String) r0.decodeNullableSerializableElement(r1, 12, v2.a, r418);
            r54 = r54 | 4096;
            Unit r83 = Unit.INSTANCE;
            r221 = r82;
            r316 = r412;
            r321 = r413;
            r72 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            goto L42
        L32:
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r221 = r418;
            Integer r84 = (Integer) r0.decodeNullableSerializableElement(r1, 11, w0.a, r417);
            r54 = r54 | 2048;
            Unit r85 = Unit.INSTANCE;
            r320 = r84;
            r69 = r56;
            r411 = r411;
            r316 = r412;
            r68 = r413;
            r317 = r414;
            r318 = r415;
            r319 = r416;
            goto L44
        L33:
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r227 = r56;
            r320 = r417;
            String r86 = (String) r0.decodeNullableSerializableElement(r1, 10, v2.a, r416);
            r54 = r54 | 1024;
            Unit r87 = Unit.INSTANCE;
            r319 = r86;
            r316 = r412;
            r321 = r413;
            r72 = r414;
            r318 = r415;
            goto L42
        L34:
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r319 = r416;
            Integer r88 = (Integer) r0.decodeNullableSerializableElement(r1, 9, w0.a, r415);
            r54 = r54 | 512;
            Unit r89 = Unit.INSTANCE;
            r318 = r88;
            r69 = r56;
            r411 = r411;
            r316 = r412;
            r68 = r413;
            r317 = r414;
            goto L44
        L35:
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r227 = r56;
            r318 = r415;
            r72 = (Integer) r0.decodeNullableSerializableElement(r1, 8, w0.a, r414);
            r54 = r54 | 256;
            Unit r90 = Unit.INSTANCE;
            r316 = r412;
            r321 = r413;
            goto L42
        L36:
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r317 = r414;
            r68 = (String) r0.decodeNullableSerializableElement(r1, 7, v2.a, r413);
            r54 = r54 | 128;
            Unit r91 = Unit.INSTANCE;
            r69 = r56;
            r411 = r411;
            r316 = r412;
            goto L44
        L37:
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r227 = r56;
            r321 = r413;
            String r92 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r412);
            r54 = r54 | 64;
            Unit r93 = Unit.INSTANCE;
            r316 = r92;
            r72 = r414;
            goto L42
        L39:
            r317 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r316 = r412;
            String r94 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r411);
            r54 = r54 | 32;
            Unit r95 = Unit.INSTANCE;
            r411 = r94;
            r69 = r56;
            r68 = r413;
            goto L44
        L41:
            r42 = r42;
            r43 = r43;
            r316 = r412;
            r321 = r413;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r227 = r56;
            r411 = r411;
            String r96 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r410);
            r54 = r54 | 16;
            Unit r97 = Unit.INSTANCE;
            r410 = r96;
            r72 = r414;
            goto L42
        L43:
            r42 = r42;
            r43 = r43;
            r411 = r411;
            r316 = r412;
            r317 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r410 = r410;
            String r98 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r49);
            r54 = r54 | 8;
            Unit r99 = Unit.INSTANCE;
            r49 = r98;
            r69 = r56;
            r68 = r413;
            goto L44
        L45:
            r42 = r42;
            r43 = r43;
            r410 = r410;
            r411 = r411;
            r316 = r412;
            r321 = r413;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r227 = r56;
            r220 = r49;
            String r100 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r315);
            r54 = r54 | 4;
            Unit r101 = Unit.INSTANCE;
            r315 = r100;
            r72 = r414;
            goto L46
        L47:
            r42 = r42;
            r43 = r43;
            r220 = r49;
            r410 = r410;
            r411 = r411;
            r316 = r412;
            r317 = r414;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r219 = r315;
            r314 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r314);
            r54 = r54 | 2;
            Unit r102 = Unit.INSTANCE;
            r69 = r56;
            r68 = r413;
            goto L48
        L50:
            r42 = r42;
            r43 = r43;
            r219 = r315;
            r220 = r49;
            r410 = r410;
            r411 = r411;
            r316 = r412;
            r321 = r413;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r227 = r56;
            r226 = r314;
            r313 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r313);
            r54 = r54 | 1;
            Unit r103 = Unit.INSTANCE;
            r72 = r414;
            goto L52
        L51:
            r42 = r42;
            r43 = r43;
            r226 = r314;
            r219 = r315;
            r220 = r49;
            r410 = r410;
            r411 = r411;
            r316 = r412;
            r321 = r413;
            r318 = r415;
            r319 = r416;
            r320 = r417;
            r221 = r418;
            r222 = r50;
            r223 = r51;
            r224 = r52;
            r225 = r53;
            r227 = r56;
            Unit r104 = Unit.INSTANCE;
            r72 = r414;
            r55 = false;
            goto L52
        L10:
            throw new UnknownFieldException(r57);
        L54:
            String r131 = r43;
            String r105 = r313;
            String r228 = r314;
            String r229 = r315;
            String r230 = r49;
            String r231 = r410;
            r34 = r44;
            r33 = r45;
            r41 = r11;
            r39 = r42;
            r40 = r131;
            r115 = r231;
            r116 = r411;
            r113 = r412;
            r114 = r413;
            r111 = r54;
            r310 = r47;
            r312 = r123;
            r311 = r124;
            r210 = r48;
            r119 = r229;
            r118 = r230;
            r212 = r414;
            r35 = r120;
            r211 = r53;
            r213 = r52;
            r215 = r415;
            r216 = r416;
            r37 = r46;
            r36 = r122;
            r117 = r228;
            r214 = r51;
            r218 = r417;
            r38 = r121;
            r112 = r105;
            r217 = r50;
            r24 = r418;
            goto L55
        }

        public final void serialize(muc.f r7, Object r8) {
            MobTemplateClickParamsKmp r9 = (MobTemplateClickParamsKmp) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = MobTemplateClickParamsKmp.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, v2.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, v2.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, v2.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeNullableSerializableElement(r0, 6, v2.a, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r10.encodeNullableSerializableElement(r0, 7, v2.a, r9.h);
        L75:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r10.encodeNullableSerializableElement(r0, 8, w0.a, r9.i);
        L84:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r10.encodeNullableSerializableElement(r0, 9, w0.a, r9.j);
        L93:
            if (r10.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            boolean r17 = true;
        L99:
            if (r17 == false) goto L102;
            r10.encodeNullableSerializableElement(r0, 10, v2.a, r9.k);
        L102:
            if (r10.shouldEncodeElementDefault(r0, 11) == false) goto L105;
        L106:
            boolean r18 = true;
        L108:
            if (r18 == false) goto L111;
            r10.encodeNullableSerializableElement(r0, 11, w0.a, r9.l);
        L111:
            if (r10.shouldEncodeElementDefault(r0, 12) == false) goto L114;
        L115:
            boolean r19 = true;
        L117:
            if (r19 == false) goto L120;
            r10.encodeNullableSerializableElement(r0, 12, v2.a, r9.m);
        L120:
            if (r10.shouldEncodeElementDefault(r0, 13) == false) goto L123;
        L124:
            boolean r20 = true;
        L126:
            if (r20 == false) goto L129;
            r10.encodeNullableSerializableElement(r0, 13, v2.a, r9.n);
        L129:
            if (r10.shouldEncodeElementDefault(r0, 14) == false) goto L132;
        L133:
            boolean r21 = true;
        L135:
            if (r21 == false) goto L138;
            r10.encodeNullableSerializableElement(r0, 14, v2.a, r9.o);
        L138:
            if (r10.shouldEncodeElementDefault(r0, 15) == false) goto L141;
        L142:
            boolean r22 = true;
        L144:
            if (r22 == false) goto L147;
            r10.encodeNullableSerializableElement(r0, 15, v2.a, r9.p);
        L147:
            if (r10.shouldEncodeElementDefault(r0, 16) == false) goto L150;
        L151:
            boolean r23 = true;
        L153:
            if (r23 == false) goto L156;
            r10.encodeNullableSerializableElement(r0, 16, v2.a, r9.q);
        L156:
            if (r10.shouldEncodeElementDefault(r0, 17) == false) goto L159;
        L160:
            boolean r24 = true;
        L162:
            if (r24 == false) goto L165;
            r10.encodeNullableSerializableElement(r0, 17, v2.a, r9.r);
        L165:
            if (r10.shouldEncodeElementDefault(r0, 18) == false) goto L168;
        L169:
            boolean r25 = true;
        L171:
            if (r25 == false) goto L174;
            r10.encodeNullableSerializableElement(r0, 18, g1.a, r9.s);
        L174:
            if (r10.shouldEncodeElementDefault(r0, 19) == false) goto L177;
        L178:
            boolean r26 = true;
        L180:
            if (r26 == false) goto L183;
            r10.encodeNullableSerializableElement(r0, 19, v2.a, r9.t);
        L183:
            if (r10.shouldEncodeElementDefault(r0, 20) == false) goto L186;
        L187:
            boolean r27 = true;
        L189:
            if (r27 == false) goto L192;
            r10.encodeNullableSerializableElement(r0, 20, v2.a, r9.u);
        L192:
            if (r10.shouldEncodeElementDefault(r0, 21) == false) goto L195;
        L196:
            boolean r28 = true;
        L198:
            if (r28 == false) goto L201;
            r10.encodeNullableSerializableElement(r0, 21, v2.a, r9.v);
        L201:
            if (r10.shouldEncodeElementDefault(r0, 22) == false) goto L204;
        L205:
            boolean r29 = true;
        L207:
            if (r29 == false) goto L210;
            r10.encodeNullableSerializableElement(r0, 22, i.a, r9.w);
        L210:
            if (r10.shouldEncodeElementDefault(r0, 23) == false) goto L213;
        L214:
            boolean r30 = true;
        L216:
            if (r30 == false) goto L219;
            r10.encodeNullableSerializableElement(r0, 23, w0.a, r9.x);
        L219:
            if (r10.shouldEncodeElementDefault(r0, 24) == false) goto L222;
        L223:
            boolean r31 = true;
        L225:
            if (r31 == false) goto L228;
            r10.encodeNullableSerializableElement(r0, 24, i.a, r9.y);
        L228:
            if (r10.shouldEncodeElementDefault(r0, 25) == false) goto L231;
        L232:
            boolean r32 = true;
        L234:
            if (r32 == false) goto L237;
            r10.encodeNullableSerializableElement(r0, 25, v2.a, r9.z);
        L237:
            if (r10.shouldEncodeElementDefault(r0, 26) == false) goto L240;
        L241:
            boolean r33 = true;
        L243:
            if (r33 == false) goto L246;
            r10.encodeNullableSerializableElement(r0, 26, v2.a, r9.A);
        L246:
            if (r10.shouldEncodeElementDefault(r0, 27) == false) goto L249;
        L250:
            boolean r34 = true;
        L252:
            if (r34 == false) goto L255;
            r10.encodeNullableSerializableElement(r0, 27, v2.a, r9.B);
        L255:
            if (r10.shouldEncodeElementDefault(r0, 28) == false) goto L258;
        L259:
            boolean r35 = true;
        L261:
            if (r35 == false) goto L264;
            r10.encodeNullableSerializableElement(r0, 28, v2.a, r9.C);
        L264:
            if (r10.shouldEncodeElementDefault(r0, 29) == false) goto L267;
        L268:
            r2 = true;
        L269:
            if (r2 == false) goto L271;
            r10.encodeNullableSerializableElement(r0, 29, i.a, r9.D);
        L271:
            r10.endStructure(r0);
            return;
        L267:
            if (r9.D == null) goto L269;
        L258:
            if (r9.C != null) goto L259;
            r35 = false;
            goto L261
        L249:
            if (r9.B != null) goto L250;
            r34 = false;
            goto L252
        L240:
            if (r9.A != null) goto L241;
            r33 = false;
            goto L243
        L231:
            if (r9.z != null) goto L232;
            r32 = false;
            goto L234
        L222:
            if (Intrinsics.areEqual(r9.y, Boolean.FALSE) == false) goto L223;
            r31 = false;
            goto L225
        L213:
            if (r9.x != null) goto L214;
            r30 = false;
            goto L216
        L204:
            if (Intrinsics.areEqual(r9.w, Boolean.FALSE) == false) goto L205;
            r29 = false;
            goto L207
        L195:
            if (r9.v != null) goto L196;
            r28 = false;
            goto L198
        L186:
            if (r9.u != null) goto L187;
            r27 = false;
            goto L189
        L177:
            if (r9.t != null) goto L178;
            r26 = false;
            goto L180
        L168:
            if (r9.s != null) goto L169;
            r25 = false;
            goto L171
        L159:
            if (r9.r != null) goto L160;
            r24 = false;
            goto L162
        L150:
            if (r9.q != null) goto L151;
            r23 = false;
            goto L153
        L141:
            if (r9.p != null) goto L142;
            r22 = false;
            goto L144
        L132:
            if (r9.o != null) goto L133;
            r21 = false;
            goto L135
        L123:
            if (r9.n != null) goto L124;
            r20 = false;
            goto L126
        L114:
            if (r9.m != null) goto L115;
            r19 = false;
            goto L117
        L105:
            if (r9.l != null) goto L106;
            r18 = false;
            goto L108
        L96:
            if (r9.k != null) goto L97;
            r17 = false;
            goto L99
        L87:
            if (r9.j != null) goto L88;
            r16 = false;
            goto L90
        L78:
            if (r9.i != null) goto L79;
            r15 = false;
            goto L81
        L69:
            if (r9.h != null) goto L70;
            r14 = false;
            goto L72
        L60:
            if (r9.g != null) goto L61;
            r13 = false;
            goto L63
        L51:
            if (r9.f != null) goto L52;
            r12 = false;
            goto L54
        L42:
            if (r9.e != null) goto L43;
            r11 = false;
            goto L45
        L33:
            if (r9.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<MobTemplateClickParamsKmp> serializer() {
            return a.a;
        }
    }

    public static final class c implements Parcelable.Creator<MobTemplateClickParamsKmp> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final MobTemplateClickParamsKmp createFromParcel(Parcel r36) {
            Intrinsics.checkNotNullParameter(r36, "parcel");
            String r2 = r36.readString();
            String r3 = r36.readString();
            String r4 = r36.readString();
            String r5 = r36.readString();
            String r6 = r36.readString();
            String r7 = r36.readString();
            String r8 = r36.readString();
            String r9 = r36.readString();
            if (r36.readInt() != 0) goto L5;
            Integer r10 = null;
        L7:
            if (r36.readInt() != 0) goto L9;
            Integer r12 = null;
        L10:
            String r13 = r36.readString();
            if (r36.readInt() != 0) goto L13;
            Integer r14 = null;
        L14:
            String r15 = r36.readString();
            String r16 = r36.readString();
            String r17 = r36.readString();
            String r18 = r36.readString();
            String r19 = r36.readString();
            String r20 = r36.readString();
            if (r36.readInt() != 0) goto L17;
            Long r21 = null;
        L18:
            String r22 = r36.readString();
            String r23 = r36.readString();
            String r24 = r36.readString();
            boolean r26 = false;
            if (r36.readInt() != 0) goto L22;
            Boolean r25 = null;
        L27:
            if (r36.readInt() != 0) goto L29;
            Integer r28 = null;
        L31:
            if (r36.readInt() != 0) goto L34;
            Boolean r29 = null;
        L38:
            String r30 = r36.readString();
            String r31 = r36.readString();
            String r32 = r36.readString();
            String r33 = r36.readString();
            if (r36.readInt() != 0) goto L42;
            Boolean r34 = null;
        L46:
            return new MobTemplateClickParamsKmp(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r28, r29, r30, r31, r32, r33, r34);
        L42:
            if (r36.readInt() == 0) goto L44;
            r26 = true;
        L44:
            r34 = Boolean.valueOf(r26);
            goto L46
        L34:
            if (r36.readInt() == 0) goto L36;
            boolean r210 = true;
        L37:
            r29 = Boolean.valueOf(r210);
            goto L38
        L36:
            r210 = false;
            goto L37
        L29:
            r28 = Integer.valueOf(r36.readInt());
            goto L31
        L22:
            if (r36.readInt() == 0) goto L24;
            boolean r27 = true;
        L25:
            r25 = Boolean.valueOf(r27);
            goto L27
        L24:
            r27 = false;
            goto L25
        L17:
            r21 = Long.valueOf(r36.readLong());
            goto L18
        L13:
            r14 = Integer.valueOf(r36.readInt());
            goto L14
        L9:
            r12 = Integer.valueOf(r36.readInt());
            goto L10
        L5:
            r10 = Integer.valueOf(r36.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MobTemplateClickParamsKmp[] newArray(int r1) {
            return new MobTemplateClickParamsKmp[r1];
        }
    }

    public MobTemplateClickParamsKmp() {
        Boolean r25 = Boolean.FALSE;
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r25, null, r25, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MobTemplateClickParamsKmp) == true) goto L8;
        return false;
    L8:
        MobTemplateClickParamsKmp r6 = (MobTemplateClickParamsKmp) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r6.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r6.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r6.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r6.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r6.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r6.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r6.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r6.B) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r6.C) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.D, r6.D) == true) goto L98;
        return false;
    L98:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Integer r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.n;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.o;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        String r46 = this.p;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        String r49 = this.q;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        String r52 = this.r;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        Long r55 = this.s;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        String r58 = this.t;
        if (r58 != null) goto L81;
        int r59 = 0;
    L82:
        int r60 = (r57 + r59) * 31;
        String r61 = this.u;
        if (r61 != null) goto L85;
        int r62 = 0;
    L86:
        int r63 = (r60 + r62) * 31;
        String r64 = this.v;
        if (r64 != null) goto L89;
        int r65 = 0;
    L90:
        int r66 = (r63 + r65) * 31;
        Boolean r67 = this.w;
        if (r67 != null) goto L93;
        int r68 = 0;
    L94:
        int r69 = (r66 + r68) * 31;
        Integer r70 = this.x;
        if (r70 != null) goto L97;
        int r71 = 0;
    L98:
        int r72 = (r69 + r71) * 31;
        Boolean r73 = this.y;
        if (r73 != null) goto L101;
        int r74 = 0;
    L102:
        int r75 = (r72 + r74) * 31;
        String r76 = this.z;
        if (r76 != null) goto L105;
        int r77 = 0;
    L106:
        int r78 = (r75 + r77) * 31;
        String r79 = this.A;
        if (r79 != null) goto L109;
        int r80 = 0;
    L110:
        int r81 = (r78 + r80) * 31;
        String r82 = this.B;
        if (r82 != null) goto L113;
        int r83 = 0;
    L114:
        int r84 = (r81 + r83) * 31;
        String r85 = this.C;
        if (r85 != null) goto L117;
        int r86 = 0;
    L118:
        int r87 = (r84 + r86) * 31;
        Boolean r88 = this.D;
        if (r88 == null) goto L123;
        r1 = r88.hashCode();
    L123:
        return r87 + r1;
    L117:
        r86 = r85.hashCode();
        goto L118
    L113:
        r83 = r82.hashCode();
        goto L114
    L109:
        r80 = r79.hashCode();
        goto L110
    L105:
        r77 = r76.hashCode();
        goto L106
    L101:
        r74 = r73.hashCode();
        goto L102
    L97:
        r71 = r70.hashCode();
        goto L98
    L93:
        r68 = r67.hashCode();
        goto L94
    L89:
        r65 = r64.hashCode();
        goto L90
    L85:
        r62 = r61.hashCode();
        goto L86
    L81:
        r59 = r58.hashCode();
        goto L82
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MobTemplateClickParamsKmp(botId=" + this.a + ", templateId=" + this.b + ", enterFrom=" + this.c + ", chatType=" + this.d + ", templateType=" + this.e + ", templateSubType=" + this.f + ", templateSource=" + this.g + ", creatorId=" + this.h + ", position=" + this.i + ", pageIndex=" + this.j + ", templateRecReqId=" + this.k + ", actionBarTemplateId=" + this.l + ", aiGenerateTabId=" + this.m + ", aiGenerateTabType=" + this.n + ", aiGenerateTabName=" + this.o + ", recommendFrom=" + this.p + ", currentPage=" + this.q + ", previousPage=" + this.r + ", useTemplateUV=" + this.s + ", conversationId=" + this.t + ", templateRecExtra=" + this.u + ", subType=" + this.v + ", isImageReferencePublic=" + this.w + ", imageReferenceCount=" + this.x + ", isHasCaption=" + this.y + ", enterMethod=" + this.z + ", currentPageKey=" + this.A + ", templateUseTag=" + this.B + ", buttonType=" + this.C + ", isHasReplica=" + this.D + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        r5.writeString(this.a);
        r5.writeString(this.b);
        r5.writeString(this.c);
        r5.writeString(this.d);
        r5.writeString(this.e);
        r5.writeString(this.f);
        r5.writeString(this.g);
        r5.writeString(this.h);
        Integer r7 = this.i;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Integer r8 = this.j;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        r5.writeString(this.k);
        Integer r9 = this.l;
        if (r9 != null) goto L13;
        r5.writeInt(0);
    L14:
        r5.writeString(this.m);
        r5.writeString(this.n);
        r5.writeString(this.o);
        r5.writeString(this.p);
        r5.writeString(this.q);
        r5.writeString(this.r);
        Long r10 = this.s;
        if (r10 != null) goto L17;
        r5.writeInt(0);
    L18:
        r5.writeString(this.t);
        r5.writeString(this.u);
        r5.writeString(this.v);
        Boolean r11 = this.w;
        if (r11 != null) goto L21;
        r5.writeInt(0);
    L22:
        Integer r12 = this.x;
        if (r12 != null) goto L25;
        r5.writeInt(0);
    L26:
        Boolean r13 = this.y;
        if (r13 != null) goto L29;
        r5.writeInt(0);
    L30:
        r5.writeString(this.z);
        r5.writeString(this.A);
        r5.writeString(this.B);
        r5.writeString(this.C);
        Boolean r14 = this.D;
        if (r14 != null) goto L33;
        r5.writeInt(0);
        return;
    L33:
        r5.writeInt(1);
        r5.writeInt(r14.booleanValue() ? 1 : 0);
        return;
    L29:
        r5.writeInt(1);
        r5.writeInt(r13.booleanValue() ? 1 : 0);
        goto L30
    L25:
        r5.writeInt(1);
        r5.writeInt(r12.intValue());
        goto L26
    L21:
        r5.writeInt(1);
        r5.writeInt(r11.booleanValue() ? 1 : 0);
        goto L22
    L17:
        r5.writeInt(1);
        r5.writeLong(r10.longValue());
        goto L18
    L13:
        r5.writeInt(1);
        r5.writeInt(r9.intValue());
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeInt(r8.intValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeInt(r7.intValue());
        goto L6
    }

    static {
        Companion = new b();
        CREATOR = new c();
    }

    public MobTemplateClickParamsKmp(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, Integer r11, Integer r12, String r13, Integer r14, String r15, String r16, String r17, String r18, String r19, String r20, Long r21, String r22, String r23, String r24, Boolean r25, Integer r26, Boolean r27, String r28, String r29, String r30, String r31, Boolean r32) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
        this.q = r19;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.w = r25;
        this.x = r26;
        this.y = r27;
        this.z = r28;
        this.A = r29;
        this.B = r30;
        this.C = r31;
        this.D = r32;
    }

    public MobTemplateClickParamsKmp(int r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, Integer r15, Integer r16, String r17, Integer r18, String r19, String r20, String r21, String r22, String r23, String r24, Long r25, String r26, String r27, String r28, Boolean r29, Integer r30, Boolean r31, String r32, String r33, String r34, String r35, Boolean r36) {
        if ((r6 & 0) == 0) goto L5;
        b2.b(r6, 0, a.b);
        throw null;
    L5:
        if ((r6 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r6 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r6 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r6 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r6 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r6 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r6 & 64) != 0) goto L31;
        this.g = null;
    L33:
        if ((r6 & 128) != 0) goto L35;
        this.h = null;
    L37:
        if ((r6 & 256) != 0) goto L39;
        this.i = null;
    L41:
        if ((r6 & 512) != 0) goto L43;
        this.j = null;
    L45:
        if ((r6 & 1024) != 0) goto L47;
        this.k = null;
    L49:
        if ((r6 & 2048) != 0) goto L51;
        this.l = null;
    L53:
        if ((r6 & 4096) != 0) goto L55;
        this.m = null;
    L57:
        if ((r6 & 8192) != 0) goto L59;
        this.n = null;
    L61:
        if ((r6 & 16384) != 0) goto L63;
        this.o = null;
    L65:
        if ((32768 & r6) != 0) goto L67;
        this.p = null;
    L69:
        if ((65536 & r6) != 0) goto L71;
        this.q = null;
    L73:
        if ((131072 & r6) != 0) goto L75;
        this.r = null;
    L77:
        if ((262144 & r6) != 0) goto L79;
        this.s = null;
    L81:
        if ((524288 & r6) != 0) goto L83;
        this.t = null;
    L85:
        if ((1048576 & r6) != 0) goto L87;
        this.u = null;
    L89:
        if ((2097152 & r6) != 0) goto L91;
        this.v = null;
    L93:
        if ((4194304 & r6) != 0) goto L95;
        Boolean r2 = Boolean.FALSE;
    L96:
        this.w = r2;
        if ((8388608 & r6) != 0) goto L99;
        this.x = null;
    L101:
        if ((16777216 & r6) != 0) goto L103;
        Boolean r3 = Boolean.FALSE;
    L104:
        this.y = r3;
        if ((33554432 & r6) != 0) goto L107;
        this.z = null;
    L109:
        if ((67108864 & r6) != 0) goto L111;
        this.A = null;
    L113:
        if ((134217728 & r6) != 0) goto L115;
        this.B = null;
    L117:
        if ((268435456 & r6) != 0) goto L119;
        this.C = null;
    L121:
        if ((r6 & 536870912) != 0) goto L123;
        this.D = null;
        return;
    L123:
        this.D = r36;
        return;
    L119:
        this.C = r35;
        goto L121
    L115:
        this.B = r34;
        goto L117
    L111:
        this.A = r33;
        goto L113
    L107:
        this.z = r32;
        goto L109
    L103:
        r3 = r31;
        goto L104
    L99:
        this.x = r30;
        goto L101
    L95:
        r2 = r29;
        goto L96
    L91:
        this.v = r28;
        goto L93
    L87:
        this.u = r27;
        goto L89
    L83:
        this.t = r26;
        goto L85
    L79:
        this.s = r25;
        goto L81
    L75:
        this.r = r24;
        goto L77
    L71:
        this.q = r23;
        goto L73
    L67:
        this.p = r22;
        goto L69
    L63:
        this.o = r21;
        goto L65
    L59:
        this.n = r20;
        goto L61
    L55:
        this.m = r19;
        goto L57
    L51:
        this.l = r18;
        goto L53
    L47:
        this.k = r17;
        goto L49
    L43:
        this.j = r16;
        goto L45
    L39:
        this.i = r15;
        goto L41
    L35:
        this.h = r14;
        goto L37
    L31:
        this.g = r13;
        goto L33
    L27:
        this.f = r12;
        goto L29
    L23:
        this.e = r11;
        goto L25
    L19:
        this.d = r10;
        goto L21
    L15:
        this.c = r9;
        goto L17
    L11:
        this.b = r8;
        goto L13
    L7:
        this.a = r7;
        goto L9
    }
}
