package t18;

import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParamContainer;
import com.larksuite.framework.apiplugin.validator.format.Max;
import com.larksuite.framework.apiplugin.validator.format.MaxContainer;
import com.larksuite.framework.apiplugin.validator.format.Min;
import com.larksuite.framework.apiplugin.validator.format.MinContainer;
import com.larksuite.framework.apiplugin.validator.format.NotBlank;
import com.larksuite.framework.apiplugin.validator.format.NotBlankContainer;
import com.larksuite.framework.apiplugin.validator.format.NumberEnum;
import com.larksuite.framework.apiplugin.validator.format.NumberEnumContainer;
import com.larksuite.framework.apiplugin.validator.format.Pattern;
import com.larksuite.framework.apiplugin.validator.format.PatternContainer;
import com.larksuite.framework.apiplugin.validator.format.Prefix;
import com.larksuite.framework.apiplugin.validator.format.PrefixContainer;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import com.larksuite.framework.apiplugin.validator.format.StringEnumContainer;
import com.larksuite.framework.apiplugin.validator.format.Suffix;
import com.larksuite.framework.apiplugin.validator.format.SuffixContainer;
import com.larksuite.framework.apiplugin.validator.format.Valid;
import com.larksuite.framework.apiplugin.validator.format.ValidContainer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class u {
    public static final Map<Class<? extends Annotation>, a<? extends Annotation>> a = null;

    public interface a<T extends Annotation> {
        List<v18.a> a(Field r1, Object r2, T r3, w18.a r4);
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        r0.put(Max.class, new t18.a());
        r0.put(MaxContainer.class, new c());
        r0.put(Min.class, new d());
        r0.put(MinContainer.class, new e());
        r0.put(NotBlank.class, new f());
        r0.put(NotBlankContainer.class, new g());
        r0.put(NumberEnum.class, new h());
        r0.put(NumberEnumContainer.class, new i());
        r0.put(Pattern.class, new j());
        r0.put(PatternContainer.class, new k());
        r0.put(Prefix.class, new l());
        r0.put(PrefixContainer.class, new m());
        r0.put(StringEnum.class, new n());
        r0.put(StringEnumContainer.class, new o());
        r0.put(Suffix.class, new p());
        r0.put(SuffixContainer.class, new q());
        r0.put(LKRequiredParam.class, new r());
        r0.put(LKRequiredParamContainer.class, new s());
        r0.put(Valid.class, new t());
        r0.put(ValidContainer.class, new b());
    }
}
